package com.baidu.searchbox.util;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BaiduActiveStatistic {
    public static final String BAIDU_ACTIVE_UBC_ID = "3822";
    public static final String UBC_EXT_KEY_ACTIVE_TIME_INFO = "active_time_info";
    public static final String UBC_EXT_KEY_DATA = "data";
    public static final String UBC_EXT_KEY_ORIGINAL_DATA = "original_data";
    public static final String UBC_EXT_KEY_PRI_ABI = "pri_abi";
    public static final String UBC_EXT_KEY_RESPONSE_CODE = "response_code";
    public static final String UBC_FROM_ACTIVE = "active";
    public static final String UBC_VALUE_REQUEST_FAILED = "request_failed";
    public static final String UBC_VALUE_REQUEST_START = "request_start";
    public static final String UBC_VALUE_REQUEST_SUCCESS = "request_success";

    public static void onUBCEvent(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "active");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("source", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("value", str);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("ext", str3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(BAIDU_ACTIVE_UBC_ID, jSONObject);
    }
}
