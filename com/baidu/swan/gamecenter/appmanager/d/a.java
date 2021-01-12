package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    String dCy;
    String dJB;
    String dJu;
    String dJw;
    String dJy;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dJu = "";
        this.dJw = "";
        this.dJy = "";
        this.mScheme = "";
        this.dJB = "";
        if (e.aIs() != null) {
            b.a aIv = e.aIs().aIv();
            this.mFrom = h.jr(aIv.getAppFrameType());
            this.mAppId = aIv.getAppId();
            this.mSource = aIv.ayC();
            this.dJw = aIv.ayI().getString("aiapp_extra_need_download", "");
            this.dJy = aIv.ayI().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aIv.ayE();
            this.dJB = aIv.getPage();
            this.dCy = aIv.ayV();
            this.mAppVersion = aIv.getVersion();
            this.dJu = aIv.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        this.mAppVersion = "";
        this.dJu = "";
        this.dJw = "";
        this.dJy = "";
        this.mScheme = "";
        this.dJB = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dJw = jSONObject.optString("needDown");
            this.dJy = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dJB = jSONObject.optString("extPage");
            this.dCy = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dJu = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dJw);
            jSONObject.put("isPreset", this.dJy);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dJB);
            jSONObject.put("launchId", this.dCy);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dJu);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
