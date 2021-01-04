package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    String dHk;
    String dOg;
    String dOi;
    String dOk;
    String dOn;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dOg = "";
        this.dOi = "";
        this.dOk = "";
        this.mScheme = "";
        this.dOn = "";
        if (e.aMl() != null) {
            b.a aMo = e.aMl().aMo();
            this.mFrom = h.kX(aMo.getAppFrameType());
            this.mAppId = aMo.getAppId();
            this.mSource = aMo.aCv();
            this.dOi = aMo.aCB().getString("aiapp_extra_need_download", "");
            this.dOk = aMo.aCB().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aMo.aCx();
            this.dOn = aMo.getPage();
            this.dHk = aMo.aCO();
            this.mAppVersion = aMo.getVersion();
            this.dOg = aMo.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dOg = "";
        this.dOi = "";
        this.dOk = "";
        this.mScheme = "";
        this.dOn = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dOi = jSONObject.optString("needDown");
            this.dOk = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dOn = jSONObject.optString("extPage");
            this.dHk = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dOg = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dOi);
            jSONObject.put("isPreset", this.dOk);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dOn);
            jSONObject.put("launchId", this.dHk);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dOg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
