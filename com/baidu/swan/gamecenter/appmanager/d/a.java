package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    String dGd;
    String dMZ;
    String dNb;
    String dNd;
    String dNg;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dMZ = "";
        this.dNb = "";
        this.dNd = "";
        this.mScheme = "";
        this.dNg = "";
        if (e.aIO() != null) {
            b.a aIR = e.aIO().aIR();
            this.mFrom = h.jv(aIR.getAppFrameType());
            this.mAppId = aIR.getAppId();
            this.mSource = aIR.azd();
            this.dNb = aIR.azj().getString("aiapp_extra_need_download", "");
            this.dNd = aIR.azj().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aIR.azf();
            this.dNg = aIR.getPage();
            this.dGd = aIR.azw();
            this.mAppVersion = aIR.getVersion();
            this.dMZ = aIR.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dMZ = "";
        this.dNb = "";
        this.dNd = "";
        this.mScheme = "";
        this.dNg = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dNb = jSONObject.optString("needDown");
            this.dNd = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dNg = jSONObject.optString("extPage");
            this.dGd = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dMZ = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dNb);
            jSONObject.put("isPreset", this.dNd);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dNg);
            jSONObject.put("launchId", this.dGd);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dMZ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
