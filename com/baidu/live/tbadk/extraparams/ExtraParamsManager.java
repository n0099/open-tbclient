package com.baidu.live.tbadk.extraparams;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ExtraParamsManager {
    public static final String KEY_BUY_TBEAN_RESULT_CALLBACK = "buy_tbean_result_callback";
    public static final String KEY_CMD = "cmd";
    public static final String KEY_DO_LOG = "do_log";
    public static final String KEY_DO_TIEBA_LOG = "do_tieba_log";
    public static final String KEY_GET_BAIDUSID = "get_baidusid";
    public static final String KEY_GET_BAIDUZID = "get_baiduzid";
    public static final String KEY_GET_BASE64 = "get_base64";
    public static final String KEY_GET_DECRYPT_USERID = "get_decrypt_userid";
    public static final String KEY_GET_ENCRYPTION_USERID = "get_encryption_userid";
    public static final String KEY_GET_SAVE_FLOW_STATUS = "get_save_flow_status";
    public static final String KEY_GET_TOP_ACTIVITY = "get_top_activity";
    public static final String KEY_GET_USER_AGENT = "get_user_agent";
    public static final String KEY_GET_WALLET_SDK_UA = "getWalletSdkUa";
    public static final String KEY_GO_FEED_BACK = "goFeedBack";
    public static final String KEY_GO_SHARE_WITH_CHANNEL = "go_share_with_channel";
    public static final String KEY_GO_USER_INFO = "go_user_info";
    public static final String KEY_ID = "id";
    public static final String KEY_PARAMS_JSON = "params_json";
    public static final String KEY_PROCESS_PLUGIN_ASYNC_CALLBACK = "process_plugin_async_callback";
    public static final String KEY_RESULT = "result";
    public static final String KEY_SYNC_WEB_COOKIE = "sync_web_cookie";
    public static final String PARAM_LOG_DATA = "log_data";
    public static final String PARAM_LOG_ISPACKAGE = "log_isPackageLog";
    public static final String PARAM_LOG_TYPE = "log_type";
    private static String WALLET_SDK_UA;
    private static List<ResultCallback> enterBuyTBeanCallbackList = new ArrayList();
    private static List<ResultCallback> loginCallbackList = new ArrayList();
    private IExtraParams mExtraParams;
    private IExtraParamsBuilder mExtraParamsBuilder;

    public static ExtraParamsManager getInstance() {
        return InstanceHolder.sInst;
    }

    private ExtraParamsManager() {
    }

    public void init(IExtraParamsBuilder iExtraParamsBuilder) {
        this.mExtraParamsBuilder = iExtraParamsBuilder;
        build();
    }

    public IExtraParams buildParamsExtra() {
        if (this.mExtraParams != null) {
            return this.mExtraParams;
        }
        build();
        return this.mExtraParams;
    }

    private void build() {
        if (this.mExtraParamsBuilder != null) {
            this.mExtraParams = this.mExtraParamsBuilder.build();
        }
    }

    public static String getWalletSdkUa() {
        return WALLET_SDK_UA;
    }

    public static void setWalletSdkUa(String str) {
        WALLET_SDK_UA = str;
    }

    @Deprecated
    public static boolean doLog(JSONObject jSONObject, boolean z) {
        boolean booleanValue;
        if (jSONObject == null) {
            return false;
        }
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(PARAM_LOG_ISPACKAGE, Boolean.valueOf(z));
                hashMap2.put(PARAM_LOG_DATA, jSONObject);
                hashMap.put(KEY_DO_LOG, hashMap2);
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_DO_LOG)) {
                    booleanValue = ((Boolean) process.get(KEY_DO_LOG)).booleanValue();
                    return booleanValue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        booleanValue = false;
        return booleanValue;
    }

    public static boolean doLog(JSONObject jSONObject, int i) {
        boolean booleanValue;
        if (jSONObject == null) {
            return false;
        }
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(PARAM_LOG_TYPE, Integer.valueOf(i));
                hashMap2.put(PARAM_LOG_DATA, jSONObject);
                hashMap.put(KEY_DO_LOG, hashMap2);
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_DO_LOG)) {
                    booleanValue = ((Boolean) process.get(KEY_DO_LOG)).booleanValue();
                    return booleanValue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        booleanValue = false;
        return booleanValue;
    }

    public static boolean doTiebaLog(Map<String, String> map) {
        boolean booleanValue;
        if (map == null) {
            return false;
        }
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_DO_TIEBA_LOG, map);
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_DO_TIEBA_LOG)) {
                    booleanValue = ((Boolean) process.get(KEY_DO_TIEBA_LOG)).booleanValue();
                    return booleanValue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        booleanValue = false;
        return booleanValue;
    }

    public static void handleResultCallback(String str, Intent intent) {
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        HashMap hashMap = new HashMap();
        hashMap.put(str, intent);
        buildParamsExtra.process(hashMap);
        if (!enterBuyTBeanCallbackList.isEmpty()) {
            onCallEnterBuyTBeanCallback(intent);
        }
    }

    public static void handleLoginResultCallback(String str, Intent intent) {
        if (!loginCallbackList.isEmpty()) {
            onCallLoginCallback(intent);
        }
    }

    public static void addEnterBuyTBeanCallback(ResultCallback resultCallback) {
        enterBuyTBeanCallbackList.add(resultCallback);
    }

    public static void addLoginCallback(ResultCallback resultCallback) {
        loginCallbackList.add(resultCallback);
    }

    public static void onCallEnterBuyTBeanCallback(Intent intent) {
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", intent.getIntExtra("status", 0));
            jSONObject.put("message", intent.getStringExtra("message"));
            jSONObject.put(BuyTBeanActivityConfig.CALLBACK, intent.getStringExtra(BuyTBeanActivityConfig.CALLBACK));
            jSONObject.put("productId", intent.getStringExtra("productId"));
            jSONObject.put("total", intent.getStringExtra("total"));
            jSONObject.put("transitionId", intent.getStringExtra("transitionId"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        while (true) {
            int i2 = i;
            if (i2 < enterBuyTBeanCallbackList.size()) {
                enterBuyTBeanCallbackList.get(i2).onCallback(jSONObject);
                i = i2 + 1;
            } else {
                enterBuyTBeanCallbackList.clear();
                return;
            }
        }
    }

    public static void onCallLoginCallback(Intent intent) {
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", intent.getBooleanExtra("status", false));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        while (true) {
            int i2 = i;
            if (i2 < loginCallbackList.size()) {
                loginCallbackList.get(i2).onCallback(jSONObject);
                i = i2 + 1;
            } else {
                loginCallbackList.clear();
                return;
            }
        }
    }

    public static String getEncryptionUserId(String str) {
        String str2;
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_GET_ENCRYPTION_USERID, str);
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_GET_ENCRYPTION_USERID)) {
                    str2 = (String) process.get(KEY_GET_ENCRYPTION_USERID);
                    return str2;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        str2 = "";
        return str2;
    }

    public static String getDecryptUserId(String str) {
        String str2;
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_GET_DECRYPT_USERID, str);
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_GET_DECRYPT_USERID)) {
                    str2 = (String) process.get(KEY_GET_DECRYPT_USERID);
                    return str2;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        str2 = "";
        return str2;
    }

    public static boolean getSaveFlowStatus() {
        boolean booleanValue;
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_GET_SAVE_FLOW_STATUS, false);
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_GET_SAVE_FLOW_STATUS) && (process.get(KEY_GET_SAVE_FLOW_STATUS) instanceof Boolean)) {
                    booleanValue = ((Boolean) process.get(KEY_GET_SAVE_FLOW_STATUS)).booleanValue();
                    return booleanValue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        booleanValue = false;
        return booleanValue;
    }

    public static String getUserAgent() {
        Map<String, Object> process;
        String str;
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        String str2 = "";
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_GET_USER_AGENT, "");
                process = buildParamsExtra.process(hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (process.containsKey(KEY_GET_USER_AGENT) && (process.get(KEY_GET_USER_AGENT) instanceof String)) {
                str = (String) process.get(KEY_GET_USER_AGENT);
                str2 = str;
                Log.i("ExtraParamsManager", "getUserAgent" + str2);
                return str2;
            }
        }
        str = "";
        str2 = str;
        Log.i("ExtraParamsManager", "getUserAgent" + str2);
        return str2;
    }

    public static String getBaiduzid() {
        String str;
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_GET_BAIDUZID, "");
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_GET_BAIDUZID) && (process.get(KEY_GET_BAIDUZID) instanceof String)) {
                    str = (String) process.get(KEY_GET_BAIDUZID);
                    return str;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        str = "";
        return str;
    }

    public static String getBaiduSid() {
        String str;
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_GET_BAIDUSID, "");
                Map<String, Object> process = buildParamsExtra.process(hashMap);
                if (process.containsKey(KEY_GET_BAIDUSID) && (process.get(KEY_GET_BAIDUSID) instanceof String)) {
                    str = (String) process.get(KEY_GET_BAIDUSID);
                    return str;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        str = "";
        return str;
    }

    public static void syncWebCookie() {
        IExtraParams buildParamsExtra = getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_SYNC_WEB_COOKIE, "");
                buildParamsExtra.process(hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.i("ExtraParamsManager", "syncWebCookie");
    }

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        private static final ExtraParamsManager sInst = new ExtraParamsManager();
    }

    public static String getBase64(String str) {
        IExtraParams buildParamsExtra;
        if (TextUtils.isEmpty(str) || (buildParamsExtra = getInstance().buildParamsExtra()) == null) {
            return "";
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(KEY_GET_BASE64, str);
            Map<String, Object> process = buildParamsExtra.process(hashMap);
            if (!process.containsKey(KEY_GET_BASE64) || !(process.get(KEY_GET_BASE64) instanceof String)) {
                return "";
            }
            return (String) process.get(KEY_GET_BASE64);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Object doProcessObject(String str, Object obj) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(str, obj);
            Map<String, Object> process = getInstance().buildParamsExtra().process(hashMap);
            if (process == null || !process.containsKey(str)) {
                return null;
            }
            return process.get(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String doProcessString(String str, Object obj) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(str, obj);
            Map<String, Object> process = getInstance().buildParamsExtra().process(hashMap);
            if (process == null || !process.containsKey(str)) {
                return null;
            }
            return (String) process.get(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <E> E doProcessGeneric(String str, Object obj, Class<E> cls) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(str, obj);
            Map<String, Object> process = getInstance().buildParamsExtra().process(hashMap);
            if (process == null || !process.containsKey(str)) {
                return null;
            }
            return (E) process.get(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
