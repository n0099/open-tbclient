package com.baidu.searchbox.ubcprocessor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.eq9;
import com.baidu.tieba.iq9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UBCCloudControlProcessor implements ICloudControlProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String KEY_STATISTIC_DATA_COUNT = "count";
    public static final String KEY_UBC_APP_VERSION = "ubc_app_version";
    public static final String SP_UBC_FILE_NAME = "com.baidu.searchbox_ubc";
    public static final String TAG = "UBCCloudProcessor";
    public static final String UBC_APP_VERSION_DEFAULT = "0";
    public static final String UBC_CLOUDCONFIG_VERSION = "ubc_cloudconfig_version";
    public static final String UBC_KEY = "ubc";
    public static final String UBC_VERSION_ASC = "version_asc";
    public static final String UBC_VERSION_ASC_DEFAULT = "0";
    public static final String UBC_VERSION_DEFAULT = "0";
    public static boolean sCheckedAppVersion;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(110254446, "Lcom/baidu/searchbox/ubcprocessor/UBCCloudControlProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(110254446, "Lcom/baidu/searchbox/ubcprocessor/UBCCloudControlProcessor;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        sCheckedAppVersion = false;
    }

    public UBCCloudControlProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        checkAppVersion();
    }

    public static /* synthetic */ SharedPrefsWrapper access$100() {
        return sharedPrefsWrapper();
    }

    private JSONObject generateFailStatisticData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", new JSONArray());
                jSONObject.put("count", "0,0,0");
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static SharedPrefsWrapper sharedPrefsWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences(SP_UBC_FILE_NAME));
        }
        return (SharedPrefsWrapper) invokeV.objValue;
    }

    private void checkAppVersion() {
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) || sCheckedAppVersion) {
            return;
        }
        String str = "";
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean z = false;
        try {
            packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (packageInfo == null) {
            return;
        }
        str = packageInfo.versionName;
        String string = sharedPrefsWrapper().getString(KEY_UBC_APP_VERSION, "0");
        if (DEBUG) {
            Log.d(TAG, "current version: " + str + ", oldVersion: " + string);
        }
        z = !TextUtils.equals(str, string);
        if (z) {
            sharedPrefsWrapper().putString(UBC_CLOUDCONFIG_VERSION, "0");
            sharedPrefsWrapper().putString(KEY_UBC_APP_VERSION, str);
            if (DEBUG) {
                Log.d(TAG, "reset step: 0, save app version: " + str);
            }
        }
        sCheckedAppVersion = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkStatisticData(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, jSONObject)) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                String optString = jSONObject.optString("count");
                if (!TextUtils.isEmpty(optString) && (split = optString.split(",")) != null && split.length == 3) {
                    try {
                        if (Integer.parseInt(split[0]) == Integer.parseInt(split[1]) + Integer.parseInt(split[2])) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), jSONObject})) == null) {
            if (jSONObject != null && jSONObject.length() == 0) {
                return null;
            }
            return new CloudControlRequestInfo(UBC_KEY, sharedPrefsWrapper().getString(UBC_CLOUDCONFIG_VERSION, "0"), null, "");
        }
        return (CloudControlRequestInfo) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudControlResponseInfo, iCloudControlUBCCallBack) == null) {
            JSONObject option = cloudControlResponseInfo.getOption();
            JSONObject serviceData = cloudControlResponseInfo.getServiceData();
            if (!TextUtils.equals(cloudControlResponseInfo.getServiceName(), UBC_KEY) || serviceData == null) {
                return;
            }
            if (option == null) {
                str = "0";
            } else {
                str = option.optString("version_asc");
            }
            boolean z = !"0".equals(str);
            iq9 iq9Var = new iq9("", serviceData);
            if (iq9Var.l()) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).registerConfig(iq9Var, z, new eq9(this, iCloudControlUBCCallBack, iq9Var.g()) { // from class: com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UBCCloudControlProcessor this$0;
                    public final /* synthetic */ ICloudControlUBCCallBack val$cloudControlUBCCallBack;
                    public final /* synthetic */ String val$step;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iCloudControlUBCCallBack, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$cloudControlUBCCallBack = iCloudControlUBCCallBack;
                        this.val$step = r8;
                    }

                    @Override // com.baidu.tieba.eq9
                    public void setUBCConfigStatisticData(JSONObject jSONObject) {
                        ICloudControlUBCCallBack iCloudControlUBCCallBack2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && (iCloudControlUBCCallBack2 = this.val$cloudControlUBCCallBack) != null) {
                            iCloudControlUBCCallBack2.setServiceInfo(jSONObject);
                            if (this.this$0.checkStatisticData(jSONObject) && !TextUtils.isEmpty(this.val$step)) {
                                UBCCloudControlProcessor.access$100().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, this.val$step);
                            }
                        }
                    }
                });
            } else if (iCloudControlUBCCallBack != null) {
                iCloudControlUBCCallBack.setServiceInfo(generateFailStatisticData());
            }
            List<UBCCloudConfigObserver> list = new UBCCloudConfigObservers().mObservers.getList();
            if (list != null && !list.isEmpty()) {
                String jSONObject = serviceData.toString();
                for (UBCCloudConfigObserver uBCCloudConfigObserver : list) {
                    try {
                        uBCCloudConfigObserver.onReceiveUbcCloudConfig(jSONObject, option);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
