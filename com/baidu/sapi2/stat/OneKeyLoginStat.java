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
public class OneKeyLoginStat implements NoProguard {
    public static final String TAG = "OneKeyLoginStat";
    public static final String UBC_ID_ONEKEY_LOGIN = "4920";

    /* loaded from: classes3.dex */
    public static class CheckAbility implements NoProguard {
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_CONNECTTIMEOUT = "connectTimeout";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_JS_ABLE = "js_able";
        public static final String KEY_EXT_JS_ABLE_REPETITION = "js_able_repetition";
        public static final String KEY_EXT_JS_DUR = "js_dur";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_EXT_PHONENUM = "phoneNum";
        public static final String KEY_EXT_SCENE = "scene";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_check_ability";
        public static final String VALUE_UNABLE = "0";
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
                Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                return;
            }
            ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
            if (isAccountManager == null) {
                Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                return;
            }
            UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
            if (ubcUploadImplCallback == null) {
                Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
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
            ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
            resetData();
        }
    }

    /* loaded from: classes3.dex */
    public static class LoadLogin implements NoProguard {
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_DUR_JS = "dur_js";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_load_login";
        public static final String VALUE_UNABLE = "0";
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
                Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                return;
            }
            ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
            if (isAccountManager == null) {
                Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                return;
            }
            UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
            if (ubcUploadImplCallback == null) {
                Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
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
            ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
            resetData();
        }
    }

    /* loaded from: classes3.dex */
    public static class OauthToken implements NoProguard {
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_EXT_SUBCODE = "subCode";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_oauth_token";
        public static final String VALUE_UNABLE = "0";
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
                Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                return;
            }
            ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
            if (isAccountManager == null) {
                Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                return;
            }
            UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
            if (ubcUploadImplCallback == null) {
                Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
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
            ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
            resetData();
        }
    }

    /* loaded from: classes3.dex */
    public static class PreGetPhoneStat implements NoProguard {
        public static final String KEY_EXT = "ext";
        public static final String KEY_EXT_CODE = "code";
        public static final String KEY_EXT_CONNECTTIMEOUT = "connectTimeout";
        public static final String KEY_EXT_DUR = "dur";
        public static final String KEY_EXT_IS_ABLE_SIM = "is_able_sim";
        public static final String KEY_EXT_IS_GRAY = "is_gray";
        public static final String KEY_EXT_IS_LOGIN = "is_login";
        public static final String KEY_EXT_NETTYPE = "netType";
        public static final String KEY_EXT_OPERATOR = "operator";
        public static final String KEY_EXT_PHONENUM = "phoneNum";
        public static final String KEY_EXT_SCENE = "scene";
        public static final String KEY_EXT_SUBCODE = "subCode";
        public static final String KEY_PAGE = "page";
        public static final String KEY_SOURCE = "source";
        public static final String KEY_VALUE = "value";
        public static final String VALUE_ABLE = "1";
        public static final String VALUE_PAGE = "one_key_pre_get_phone";
        public static final String VALUE_UNABLE = "0";
        public static Map<String, Object> statExtMap = new HashMap();
        public static String sValue = "";

        public static void resetData() {
            statExtMap.clear();
            sValue = "";
        }

        public static void upload() {
            try {
                JSONObject jSONObject = new JSONObject(statExtMap);
                ServiceManager serviceManager = ServiceManager.getInstance();
                if (serviceManager == null) {
                    Log.e(OneKeyLoginStat.TAG, "ServiceManager is null, maybe had not init");
                    return;
                }
                ISAccountManager isAccountManager = serviceManager.getIsAccountManager();
                if (isAccountManager == null) {
                    Log.e(OneKeyLoginStat.TAG, "AccountManager is null, maybe had not init");
                    return;
                }
                UbcUploadImplCallback ubcUploadImplCallback = isAccountManager.getUbcUploadImplCallback();
                if (ubcUploadImplCallback == null) {
                    Log.e(OneKeyLoginStat.TAG, "UbcUploadImplCallback is null, maybe had not init");
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
                ubcUploadImplCallback.onEvent(OneKeyLoginStat.UBC_ID_ONEKEY_LOGIN, jSONObject2);
                resetData();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
