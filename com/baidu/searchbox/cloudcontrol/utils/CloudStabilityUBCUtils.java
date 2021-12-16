package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class CloudStabilityUBCUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CSS_CODE_ERROR = 2;
    public static final int CSS_DATA_ERROR = 5;
    public static final int CSS_DISPATCH = 0;
    public static final int CSS_ERRNO = 4;
    public static final int CSS_FAIL = 3;
    public static final int CSS_NET_ERROR = 6;
    public static final int ERRNO_NULL = -100;
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MSG = "errorMsg";
    public static final String KEY_EXT = "ext";
    public static final String KEY_LENGTH = "length";
    public static final String KEY_NETWORK = "network";
    public static final String KEY_POST_LENGTH = "postLength";
    public static final String KEY_RESPONSE_CODE = "responseCode";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_TRACE_ID = "traceid";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final String KEY_WEAK_QUALITY = "networkQuality";
    public static final String TAG = "CloudStabilityUBCUtils";
    public static final String UBC_CLOUD_STABILITY_REQUEST_ID = "1929";
    public static final String UBC_CLOUD_STABILITY_RESPONSE_ID = "1928";
    public static final String VALUE_TYPE = "stability";
    public transient /* synthetic */ FieldHolder $fh;

    public CloudStabilityUBCUtils() {
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

    public static void doRequestStatistics(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            String networkInfo = ConnectManager.getNetworkInfo(AppRuntime.getAppContext());
            int networkQuality = NetworkQuality.getNetworkQuality();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", VALUE_TYPE);
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("traceid", str2);
                jSONObject2.put("network", networkInfo);
                jSONObject2.put(KEY_WEAK_QUALITY, String.valueOf(networkQuality));
                if (j2 != -1) {
                    jSONObject2.put("length", String.valueOf(j2));
                }
                jSONObject.put("ext", jSONObject2);
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(UBC_CLOUD_STABILITY_REQUEST_ID, jSONObject);
                }
                if (AppConfig.isDebug()) {
                    String str3 = "doRequestStatistics 1929:" + jSONObject.toString();
                }
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    String str4 = "doRequestStatistics error" + e2.toString();
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void doResponseStatistics(String str, int i2, String str2, int i3, int i4, String str3, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i4), str3, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            String networkInfo = ConnectManager.getNetworkInfo(AppRuntime.getAppContext());
            int networkQuality = NetworkQuality.getNetworkQuality();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", VALUE_TYPE);
                jSONObject.put("source", str);
                jSONObject.put("value", i2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("traceid", str2);
                jSONObject2.put("network", networkInfo);
                jSONObject2.put(KEY_WEAK_QUALITY, String.valueOf(networkQuality));
                jSONObject2.put(KEY_RESPONSE_CODE, i3);
                jSONObject2.put("duration", j2);
                if (j3 != 0) {
                    jSONObject2.put("length", String.valueOf(j3));
                }
                if (j4 != 0) {
                    jSONObject2.put(KEY_POST_LENGTH, String.valueOf(j4));
                }
                if (i4 != -100) {
                    jSONObject2.put("errorCode", i4);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("errorMsg", str3);
                }
                jSONObject.put("ext", jSONObject2);
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(UBC_CLOUD_STABILITY_RESPONSE_ID, jSONObject);
                }
                if (AppConfig.isDebug()) {
                    String str4 = "doResponseStatistics 1928:" + jSONObject.toString();
                }
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    String str5 = "doResponseStatistics error" + e2.toString();
                    e2.printStackTrace();
                }
            }
        }
    }
}
