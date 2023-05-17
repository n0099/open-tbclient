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
/* loaded from: classes3.dex */
public class HistoryLoginStat implements NoProguard {
    public static final String TAG = "HistoryLoginStat";
    public static final String UBC_ID = "4921";

    /* loaded from: classes3.dex */
    public static class HistoryClickLoginStat implements NoProguard {
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_SENCE = "sence";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "smslogin";
        public static final String VALUE_SENCE_IN = "in";
        public static final String VALUE_SENCE_OUT = "out";
        public static final String VALUE_UNABLE = "0";
        public static Map<String, Object> statExtMap = new HashMap();
        public static String sValue = "";
        public static String sValueSence = "out";

        public static void resetData() {
            statExtMap.clear();
            sValue = "";
        }

        public static void upload() {
            statExtMap.put("sence", sValueSence);
            JSONObject jSONObject = new JSONObject(statExtMap);
            ServiceManager serviceManager = ServiceManager.getInstance();
            if (serviceManager == null) {
                Log.e(HistoryLoginStat.TAG, "ServiceManager is null, maybe had not init");
                return;
            }
            ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
            if (isAccountManager == null) {
                Log.e(HistoryLoginStat.TAG, "AccountManager is null, maybe had not init");
                return;
            }
            UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
            if (ubcUploadImplCallback == null) {
                Log.e(HistoryLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                SapiConfiguration confignation = isAccountManager.getConfignation();
                if (confignation != null) {
                    jSONObject2.put("source", confignation.getTpl());
                }
                jSONObject2.put("page", "smslogin");
                jSONObject2.put("ext", jSONObject);
                jSONObject2.put("value", sValue);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ubcUploadImplCallback.onEvent(HistoryLoginStat.UBC_ID, jSONObject2);
            resetData();
        }
    }

    /* loaded from: classes3.dex */
    public static class HistoryShowStat implements NoProguard {
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_AVAILABLE_COUNT = "available_count";
        public static final String KEY_EXT_HISTORY_COUNT = "history_count";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_PAGE = "getdpass";
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
                Log.e(HistoryLoginStat.TAG, "ServiceManager is null, maybe had not init");
                return;
            }
            ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
            if (isAccountManager == null) {
                Log.e(HistoryLoginStat.TAG, "AccountManager is null, maybe had not init");
                return;
            }
            UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
            if (ubcUploadImplCallback == null) {
                Log.e(HistoryLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                SapiConfiguration confignation = isAccountManager.getConfignation();
                if (confignation != null) {
                    jSONObject2.put("source", confignation.getTpl());
                }
                jSONObject2.put("page", "getdpass");
                jSONObject2.put("ext", jSONObject);
                jSONObject2.put("value", sValue);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ubcUploadImplCallback.onEvent(HistoryLoginStat.UBC_ID, jSONObject2);
            resetData();
        }
    }
}
