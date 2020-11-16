package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a {
    String drE;
    String dyD;
    String dyF;
    String dyH;
    String dyK;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dyD = "";
        this.dyF = "";
        this.dyH = "";
        this.mScheme = "";
        this.dyK = "";
        if (e.aGN() != null) {
            b.a aGQ = e.aGN().aGQ();
            this.mFrom = h.ku(aGQ.getAppFrameType());
            this.mAppId = aGQ.getAppId();
            this.mSource = aGQ.axV();
            this.dyF = aGQ.ayb().getString("aiapp_extra_need_download", "");
            this.dyH = aGQ.ayb().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aGQ.axX();
            this.dyK = aGQ.getPage();
            this.drE = aGQ.ayo();
            this.mAppVersion = aGQ.getVersion();
            this.dyD = aGQ.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dyD = "";
        this.dyF = "";
        this.dyH = "";
        this.mScheme = "";
        this.dyK = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dyF = jSONObject.optString("needDown");
            this.dyH = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dyK = jSONObject.optString("extPage");
            this.drE = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dyD = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dyF);
            jSONObject.put("isPreset", this.dyH);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dyK);
            jSONObject.put("launchId", this.drE);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dyD);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
