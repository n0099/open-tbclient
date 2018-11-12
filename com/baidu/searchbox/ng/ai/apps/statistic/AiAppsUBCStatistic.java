package com.baidu.searchbox.ng.ai.apps.statistic;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.ubc.Flow;
import com.baidu.ubc.o;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class AiAppsUBCStatistic {
    private static final boolean DEBUG = false;
    private static final String EXT_APPID_KEY = "appid";
    public static final String EXT_KEY_ERRCODE = "errcode";
    public static final String EXT_KEY_LAUNCH_FLAG = "launch_flag_for_statistic";
    private static final String EXT_MONEY_KEY = "money";
    public static final String EXT_TOKEN_KEY = "token";
    public static final String EXT_TOKEN_VALUE = "swanubc";
    public static final String SOURCE_ALI_PAY = "alipay";
    public static final String SOURCE_BAR = "bar";
    public static final String SOURCE_MENU = "menu";
    public static final String SOURCE_NUO_MI = "nuomi";
    public static final String SOURCE_QIAN_BAO = "baiduqianbao";
    private static final String TAG = "AiAppsUBCStatistic";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_LAUNCH = "launch";
    private static final String TYPE_LOGIN = "login";
    private static final String TYPE_PAY = "pay";
    public static final String TYPE_SHOW = "show";
    private static final String UBC_AIAPPS_DURATION_ID = "607";
    private static final String UBC_AIAPPS_EVENT_ID = "606";
    private static final String UBC_AIAPPS_LOGIN_ID = "751";
    private static final String UBC_AIAPPS_PAGESTO_ID = "778";
    public static final String UBC_SWAN_VALUE = "swan";
    public static final String VALUE_ABOUT = "about";
    public static final String VALUE_ADD_SHORTCUT = "addshortcut";
    public static final String VALUE_BACK = "back";
    public static final String VALUE_CANCEL = "cancel";
    public static final String VALUE_CLOSE = "close";
    public static final String VALUE_FAILURE = "fail";
    public static final String VALUE_GOHOME = "gohome";
    public static final String VALUE_MENU = "menu";
    public static final String VALUE_PERMISSION = "permission";
    public static final String VALUE_SUCCESS = "success";
    private Flow mFlow;

    public void startFlow() {
        if (this.mFlow == null) {
            this.mFlow = o.xI(UBC_AIAPPS_DURATION_ID);
        }
    }

    public void endFlow(final AiAppsUBCEvent aiAppsUBCEvent) {
        if (aiAppsUBCEvent != null && this.mFlow != null) {
            final Flow flow = this.mFlow;
            AiAppExecutorUtils.postOnComputation(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic.1
                @Override // java.lang.Runnable
                public void run() {
                    aiAppsUBCEvent.mergeExtInfo(AiAppsUBCStatistic.verifyTokenForChannelRefining());
                    flow.xD(aiAppsUBCEvent.toJSONObject().toString());
                    flow.end();
                }
            }, "AiAppsUBCEndFlow");
            this.mFlow = null;
        }
    }

    public static void onEvent(final AiAppsUBCEvent aiAppsUBCEvent) {
        if (aiAppsUBCEvent != null) {
            AiAppExecutorUtils.postOnComputation(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic.2
                @Override // java.lang.Runnable
                public void run() {
                    AiAppsUBCEvent.this.mergeExtInfo(AiAppsUBCStatistic.verifyTokenForChannelRefining());
                    o.i(AiAppsUBCStatistic.UBC_AIAPPS_EVENT_ID, AiAppsUBCEvent.this.toJSONObject());
                }
            }, "AiAppsUBCOnEvent");
        }
    }

    public static void onLogin(boolean z, String str) {
        final AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCEvent();
        aiAppsUBCEvent.mType = TYPE_LOGIN;
        aiAppsUBCEvent.mValue = z ? "success" : "fail";
        aiAppsUBCEvent.mAppId = str;
        aiAppsUBCEvent.mSource = AiApp.get().getLaunchInfo().mLaunchFrom;
        AiAppExecutorUtils.postOnComputation(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic.3
            @Override // java.lang.Runnable
            public void run() {
                o.i(AiAppsUBCStatistic.UBC_AIAPPS_LOGIN_ID, AiAppsUBCEvent.this.toJSONObject());
            }
        }, "AiAppsUBCOnLogin");
    }

    public static void onPay(boolean z, String str, String str2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "swan");
            jSONObject.put("type", TYPE_PAY);
            jSONObject.put("value", z ? "success" : "fail");
            jSONObject.put("source", str);
            JSONObject jSONObject2 = new JSONObject();
            AiApp aiApp = AiApp.get();
            if (aiApp != null) {
                jSONObject2.put("appid", aiApp.getAppKey());
            }
            jSONObject2.put(EXT_MONEY_KEY, str2);
            jSONObject.put("ext", jSONObject2);
            AiAppExecutorUtils.postOnComputation(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic.4
                @Override // java.lang.Runnable
                public void run() {
                    o.onEvent(AiAppsUBCStatistic.UBC_AIAPPS_LOGIN_ID, jSONObject.toString());
                }
            }, "AiAppsUBCOnPay");
        } catch (JSONException e) {
        }
    }

    public static void onPagesRoute(boolean z, String str) {
        final AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCEvent();
        aiAppsUBCEvent.mType = "show";
        aiAppsUBCEvent.mSource = str;
        aiAppsUBCEvent.mValue = z ? "success" : "fail";
        aiAppsUBCEvent.mAppId = AiApp.getAiAppId();
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic.5
            @Override // java.lang.Runnable
            public void run() {
                AiAppsUBCEvent.this.mergeExtInfo(AiAppsUBCStatistic.verifyTokenForChannelRefining());
                o.i(AiAppsUBCStatistic.UBC_AIAPPS_PAGESTO_ID, AiAppsUBCEvent.this.toJSONObject());
            }
        }, "AiAppsUBCOnPagesRoute");
    }

    public static JSONObject genJSONObject(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e) {
            }
        }
        return jSONObject;
    }

    public static JSONObject verifyTokenForChannelRefining() {
        AiAppsLaunchInfo launchInfo;
        JSONObject jSONObject;
        AiApp aiApp = AiApp.get();
        if (aiApp == null || (launchInfo = aiApp.getLaunchInfo()) == null || (jSONObject = launchInfo.mExtJSonObject) == null || !TextUtils.equals(jSONObject.optString("token"), EXT_TOKEN_VALUE)) {
            return null;
        }
        return jSONObject;
    }

    /* loaded from: classes2.dex */
    public static class AiAppsUBCEvent {
        public String mAppId;
        public JSONObject mExt;
        public String mFrom = "swan";
        public String mPage;
        public String mSource;
        public String mType;
        public String mValue;

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.mFrom)) {
                    jSONObject.put("from", this.mFrom);
                }
                if (!TextUtils.isEmpty(this.mType)) {
                    jSONObject.put("type", this.mType);
                }
                if (!TextUtils.isEmpty(this.mValue)) {
                    jSONObject.put("value", this.mValue);
                }
                if (!TextUtils.isEmpty(this.mSource)) {
                    jSONObject.put("source", this.mSource);
                }
                if (!TextUtils.isEmpty(this.mPage)) {
                    jSONObject.put(SystemScreenshotManager.PAGE, this.mPage);
                }
                JSONObject genExt = genExt();
                if (genExt == null) {
                    genExt = new JSONObject();
                }
                if (!TextUtils.isEmpty(this.mAppId)) {
                    genExt.put("appid", this.mAppId);
                }
                jSONObject.put("ext", genExt);
                return jSONObject;
            } catch (JSONException e) {
                return null;
            }
        }

        public JSONObject genExt() {
            return this.mExt;
        }

        public void mergeExtInfo(JSONObject jSONObject) {
            if (jSONObject != null) {
                if (this.mExt == null) {
                    this.mExt = jSONObject;
                    return;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        this.mExt.put(next, jSONObject.opt(next));
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }
}
