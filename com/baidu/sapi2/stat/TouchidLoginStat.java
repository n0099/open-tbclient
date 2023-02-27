package com.baidu.sapi2.stat;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TouchidLoginStat implements NoProguard {
    public static final String KEY_EXT = "ext";
    public static final String KEY_EXT_CODE = "code";
    public static final String KEY_PAGE = "page";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_VALUE = "value";
    public static final String UBC_ID = "4993";
    public static final String VALUE_ABLE = "1";
    public static final String VALUE_PAGE = "native_guide_finger";
    public static final String VALUE_UNABLE = "0";
    public static final String TAG = SmsLoginStat.class.getSimpleName();
    public static Map<String, Object> statExtMap = new HashMap();
    public static String sValue = "";

    public static void resetData() {
        statExtMap.clear();
        sValue = "";
    }

    public static void upload() {
        JSONObject jSONObject = new JSONObject(statExtMap);
        ServiceManager serviceManager = ServiceManager.getInstance();
        if (serviceManager == null) {
            Log.e(TAG, "ServiceManager is null, maybe had not init");
            return;
        }
        ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
        if (isAccountManager == null) {
            Log.e(TAG, "AccountManager is null, maybe had not init");
            return;
        }
        UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
        if (ubcUploadImplCallback == null) {
            Log.e(TAG, "UbcUploadImplCallback is null, maybe had not init");
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            SapiConfiguration confignation = isAccountManager.getConfignation();
            if (confignation != null) {
                jSONObject2.put("source", confignation.getTpl());
            }
            jSONObject2.put("page", VALUE_PAGE);
            jSONObject2.put("ext", jSONObject);
            jSONObject2.put("value", sValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcUploadImplCallback.onEvent(UBC_ID, jSONObject2);
        resetData();
    }
}
