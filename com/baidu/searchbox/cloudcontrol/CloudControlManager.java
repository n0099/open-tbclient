package com.baidu.searchbox.cloudcontrol;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.constant.CloudControlConstant;
import com.baidu.searchbox.cloudcontrol.data.CloudControlData;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.processor.DataProcessors;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.cloudcontrol.request.CloudControlResponseParse;
import com.baidu.searchbox.cloudcontrol.router.DataRouter;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class CloudControlManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SP_CLOUDCONTROL = "cloudControlCCS117";
    public static final String TAG = "CloudControlManager";
    public static CloudControlManager mCloudControlManager;
    public transient /* synthetic */ FieldHolder $fh;
    public DataProcessors mProcessors;
    public SharedPrefsWrapper mSharedPrefsWrapper;

    public CloudControlManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProcessors = new DataProcessors();
        this.mSharedPrefsWrapper = new SharedPrefsWrapper(KEY_SP_CLOUDCONTROL);
    }

    public static CloudControlManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (CloudControlManager.class) {
                if (mCloudControlManager == null) {
                    mCloudControlManager = new CloudControlManager();
                }
            }
            return mCloudControlManager;
        }
        return (CloudControlManager) invokeV.objValue;
    }

    public void fetchCloudControl(String str, ArrayList<CloudControlRequestInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, arrayList) == null) {
            if (!TextUtils.equals(str, "0") && !TextUtils.equals(str, "1")) {
                ExecutorUtilsExt.postOnElastic(new Runnable(this, str, arrayList) { // from class: com.baidu.searchbox.cloudcontrol.CloudControlManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CloudControlManager this$0;
                    public final /* synthetic */ ArrayList val$cloudControlRequestInfos;
                    public final /* synthetic */ String val$runType;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, arrayList};
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
                        this.val$runType = str;
                        this.val$cloudControlRequestInfos = arrayList;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            new CloudControlRequest().cloudControlRequest(this.val$runType, this.val$cloudControlRequestInfos);
                        }
                    }
                }, "fetchCloudControl", 0);
            } else if (AppConfig.isDebug()) {
                try {
                    throw new Exception("runType " + str + " is error please check runType");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean getConnectData(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, jSONObject2, str)) == null) {
            try {
                CloudControlData parseConnectResponse = new CloudControlResponseParse(str).parseConnectResponse(jSONObject, jSONObject2);
                new DataRouter().routeServiceData(parseConnectResponse);
                return parseConnectResponse != null;
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    String str2 = "connect response parse is error" + e2.toString();
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public ArrayList<CloudControlRequestInfo> getPostData(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ArrayList<CloudControlRequestInfo> arrayList = new ArrayList<>();
            HashMap<String, ICloudControlProcessor> processors = this.mProcessors.getProcessors();
            try {
                jSONObject = new JSONObject(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST, ""));
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    String str2 = "drage is not json  " + e2.toString();
                }
                jSONObject = null;
            }
            if (jSONObject == null || jSONObject.length() != 0) {
                for (Map.Entry<String, ICloudControlProcessor> entry : processors.entrySet()) {
                    String key = entry.getKey();
                    CloudControlRequestInfo postData = entry.getValue().getPostData(str, isDegradeTime(), jSONObject != null ? jSONObject.optJSONObject(key) : null);
                    if (AppConfig.isDebug()) {
                        if (postData != null) {
                            try {
                                if (!this.mProcessors.containKey(key)) {
                                    throw new Exception(key + " service is not register");
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        } else {
                            throw new Exception(key + " service get post data is error ");
                        }
                    }
                    arrayList.add(postData);
                }
                return arrayList;
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public ICloudControlProcessor getProcessor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mProcessors.getProcessor(str) : (ICloudControlProcessor) invokeL.objValue;
    }

    public HashMap<String, ICloudControlProcessor> getProcessors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mProcessors.getProcessors() : (HashMap) invokeV.objValue;
    }

    public SharedPrefsWrapper getSharedPrefsWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSharedPrefsWrapper : (SharedPrefsWrapper) invokeV.objValue;
    }

    public boolean isDegradeTime() {
        InterceptResult invokeV;
        long parseLong;
        long parseLong2;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                String string = this.mSharedPrefsWrapper.getString("st", "0");
                String string2 = this.mSharedPrefsWrapper.getString("et", "0");
                parseLong = Long.parseLong(string);
                parseLong2 = Long.parseLong(string2);
                currentTimeMillis = System.currentTimeMillis() / 1000;
            } catch (Exception unused) {
            }
            return parseLong <= currentTimeMillis && currentTimeMillis <= parseLong2;
        }
        return invokeV.booleanValue;
    }

    public boolean isInDegradeList(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str, str2)) == null) {
            if (!isDegradeTime() || jSONObject == null) {
                return false;
            }
            if (jSONObject.length() == 0) {
                return true;
            }
            if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return false;
            }
            if (optJSONObject.length() == 0) {
                return true;
            }
            return optJSONObject.has(str2) && (optJSONObject2 = optJSONObject.optJSONObject(str2)) != null && optJSONObject2.length() == 0;
        }
        return invokeLLL.booleanValue;
    }

    public void onBackgroundToForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            getInstance().requestCloudControl("1");
        }
    }

    public void registProcessor(String str, ICloudControlProcessor iCloudControlProcessor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, iCloudControlProcessor) == null) {
            this.mProcessors.addProcessor(str, iCloudControlProcessor);
        }
    }

    public void requestCloudControl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            ExecutorUtilsExt.postOnElastic(new Runnable(this, str) { // from class: com.baidu.searchbox.cloudcontrol.CloudControlManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CloudControlManager this$0;
                public final /* synthetic */ String val$runType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$runType = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new CloudControlRequest().cloudControlRequest(this.val$runType, null);
                    }
                }
            }, "requestCloudControl", 0);
        }
    }

    public boolean isInDegradeList(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, str2, str3)) == null) {
            if (isDegradeTime()) {
                try {
                    jSONObject = new JSONObject(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST, ""));
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        String str4 = "drage is not json  " + e2.toString();
                    }
                    jSONObject = null;
                }
                if (jSONObject == null || jSONObject.length() != 0) {
                    JSONObject optJSONObject3 = jSONObject != null ? jSONObject.optJSONObject(str) : null;
                    if (optJSONObject3 != null) {
                        if (optJSONObject3.length() == 0) {
                            return true;
                        }
                        if (!optJSONObject3.has(str2) || (optJSONObject = optJSONObject3.optJSONObject(str2)) == null) {
                            return false;
                        }
                        if (optJSONObject.length() == 0) {
                            return true;
                        }
                        return optJSONObject.has(str3) && (optJSONObject2 = optJSONObject.optJSONObject(str3)) != null && optJSONObject2.length() == 0;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
