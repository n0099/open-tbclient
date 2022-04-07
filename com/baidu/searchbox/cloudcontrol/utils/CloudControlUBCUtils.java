package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.data.CloudControlUBCData;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlUBCUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CONTROL = "control";
    public static final String KEY_EXT = "ext";
    public static final String KEY_K = "product";
    public static final String KEY_LOGID = "logid";
    public static final String KEY_SERVICE = "service";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_TRACE_ID = "traceid";
    public static final String KEY_V = "version";
    public static final String KEY_VALID = "valid";
    public static final String TAG = "CloudControlUBCUtils";
    public static final String UBC_CLOUD_CTROL_ID = "944";
    public transient /* synthetic */ FieldHolder $fh;

    public CloudControlUBCUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void doStatistics(CloudControlUBCData cloudControlUBCData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cloudControlUBCData) == null) || cloudControlUBCData == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", cloudControlUBCData.getRunType());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("logid", cloudControlUBCData.getLogId());
            JSONObject serviceJsonObject = cloudControlUBCData.getServiceJsonObject();
            if (serviceJsonObject != null && serviceJsonObject.length() != 0) {
                jSONObject2.put("service", serviceJsonObject);
            }
            JSONObject controlJsonObject = cloudControlUBCData.getControlJsonObject();
            if (controlJsonObject != null && controlJsonObject.length() != 0) {
                jSONObject2.put("control", controlJsonObject);
            }
            if (!TextUtils.isEmpty(cloudControlUBCData.getTraceId())) {
                jSONObject2.put("traceid", cloudControlUBCData.getTraceId());
            }
            jSONObject.put("ext", jSONObject2);
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent(UBC_CLOUD_CTROL_ID, jSONObject);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "cloud control ubc is 944:" + jSONObject.toString());
            }
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "cloud control doStatistics error" + e.toString());
                e.printStackTrace();
            }
        }
    }
}
