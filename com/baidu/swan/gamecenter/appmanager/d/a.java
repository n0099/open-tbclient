package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    String dEC;
    String dLA;
    String dLC;
    String dLF;
    String dLy;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dLy = "";
        this.dLA = "";
        this.dLC = "";
        this.mScheme = "";
        this.dLF = "";
        if (e.aIL() != null) {
            b.a aIO = e.aIL().aIO();
            this.mFrom = h.ju(aIO.getAppFrameType());
            this.mAppId = aIO.getAppId();
            this.mSource = aIO.aza();
            this.dLA = aIO.azg().getString("aiapp_extra_need_download", "");
            this.dLC = aIO.azg().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aIO.azc();
            this.dLF = aIO.getPage();
            this.dEC = aIO.azt();
            this.mAppVersion = aIO.getVersion();
            this.dLy = aIO.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dLy = "";
        this.dLA = "";
        this.dLC = "";
        this.mScheme = "";
        this.dLF = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dLA = jSONObject.optString("needDown");
            this.dLC = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dLF = jSONObject.optString("extPage");
            this.dEC = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dLy = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dLA);
            jSONObject.put("isPreset", this.dLC);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dLF);
            jSONObject.put("launchId", this.dEC);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dLy);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
