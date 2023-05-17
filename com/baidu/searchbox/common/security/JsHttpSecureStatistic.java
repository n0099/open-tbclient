package com.baidu.searchbox.common.security;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.utils.BdussParamProcessUtil;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsHttpSecureStatistic {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String FROM = "research";
    public static final String JS_TYPE_INTERFACE = "2";
    public static final String JS_TYPE_SCHEME = "1";
    public static final String KEY_API = "api";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_URI = "intent";
    public static final String KEY_URL = "url";
    public static final String TAG = "JsHttpSecureStatistic";
    public static final String TYPE_BDBOX = "4";
    public static final String TYPE_LIGHTAPP = "5";
    public static final String TYPE_MAIN = "3";
    public static final String UBC_ID = "746";
    public String mApi;
    public String mCmd;
    public String mJsType;
    public String mPackageName;
    public String mUrl;

    public JsHttpSecureStatistic setApi(String str) {
        this.mApi = str;
        return this;
    }

    public JsHttpSecureStatistic setCmd(String str) {
        this.mCmd = str;
        return this;
    }

    public JsHttpSecureStatistic setJsType(String str) {
        this.mJsType = str;
        return this;
    }

    public JsHttpSecureStatistic setPackageName(String str) {
        this.mPackageName = str;
        return this;
    }

    public JsHttpSecureStatistic setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public void statistic() {
        String str = null;
        try {
            if (!TextUtils.isEmpty(this.mUrl)) {
                Uri parse = Uri.parse(this.mUrl);
                str = parse.getAuthority() + parse.getPath();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "statistic uri parse:" + e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "research");
            jSONObject.put("source", this.mJsType);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", BdussParamProcessUtil.excludeBdussParam(str));
            jSONObject2.put("api", this.mApi);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "statistic json:" + e2);
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_ID, jSONObject.toString());
    }

    public void statisticCmd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "research");
            jSONObject.put("source", this.mJsType);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("intent", this.mCmd);
            if (TextUtils.isEmpty(this.mPackageName)) {
                jSONObject2.put("package", StringUtil.NULL_STRING);
            } else {
                jSONObject2.put("package", this.mPackageName);
            }
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.e(TAG, "statistic json:" + e);
            }
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBC_ID, jSONObject.toString());
    }
}
