package com.baidu.searchbox.ubcprocessor;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.w0.s;
import c.a.w0.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
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
/* loaded from: classes11.dex */
public class UBCCloudControlProcessor implements ICloudControlProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_STATISTIC_DATA_COUNT = "count";
    public static final String SP_UBC_FILE_NAME = "com.baidu.searchbox_ubc";
    public static final String UBC_CLOUDCONFIG_VERSION = "ubc_cloudconfig_version";
    public static final String UBC_KEY = "ubc";
    public static final String UBC_VERSION_ASC = "version_asc";
    public static final String UBC_VERSION_ASC_DEFAULT = "0";
    public static final String UBC_VERSION_DEFAULT = "0";
    public transient /* synthetic */ FieldHolder $fh;

    public UBCCloudControlProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkStatisticData(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONObject)) == null) {
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

    private JSONObject generateFailStatisticData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences(SP_UBC_FILE_NAME)) : (SharedPrefsWrapper) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), jSONObject})) == null) {
            if (jSONObject == null || jSONObject.length() != 0) {
                return new CloudControlRequestInfo(UBC_KEY, sharedPrefsWrapper().getString(UBC_CLOUDCONFIG_VERSION, "0"), null, "");
            }
            return null;
        }
        return (CloudControlRequestInfo) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudControlResponseInfo, iCloudControlUBCCallBack) == null) {
            JSONObject option = cloudControlResponseInfo.getOption();
            JSONObject serviceData = cloudControlResponseInfo.getServiceData();
            if (TextUtils.equals(cloudControlResponseInfo.getServiceName(), UBC_KEY) && serviceData != null) {
                boolean z = !"0".equals(option != null ? option.optString("version_asc") : "0");
                w wVar = new w("", serviceData);
                if (wVar.l()) {
                    ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).registerConfig(wVar, z, new s(this, iCloudControlUBCCallBack, wVar.g()) { // from class: com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor.1
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
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$cloudControlUBCCallBack = iCloudControlUBCCallBack;
                            this.val$step = r8;
                        }

                        @Override // c.a.w0.s
                        public void setUBCConfigStatisticData(JSONObject jSONObject) {
                            ICloudControlUBCCallBack iCloudControlUBCCallBack2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) || jSONObject == null || (iCloudControlUBCCallBack2 = this.val$cloudControlUBCCallBack) == null) {
                                return;
                            }
                            iCloudControlUBCCallBack2.setServiceInfo(jSONObject);
                            if (!this.this$0.checkStatisticData(jSONObject) || TextUtils.isEmpty(this.val$step)) {
                                return;
                            }
                            UBCCloudControlProcessor.sharedPrefsWrapper().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, this.val$step);
                        }
                    });
                } else if (iCloudControlUBCCallBack != null) {
                    iCloudControlUBCCallBack.setServiceInfo(generateFailStatisticData());
                }
                List<UBCCloudConfigObserver> list = new UBCCloudConfigObservers().mObservers.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                String jSONObject = serviceData.toString();
                for (UBCCloudConfigObserver uBCCloudConfigObserver : list) {
                    try {
                        uBCCloudConfigObserver.onReceiveUbcCloudConfig(jSONObject, option);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
