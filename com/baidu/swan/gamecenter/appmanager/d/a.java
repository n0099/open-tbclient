package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    String cSI;
    String cZG;
    String cZI;
    String cZK;
    String cZN;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cZG = "";
        this.cZI = "";
        this.cZK = "";
        this.mScheme = "";
        this.cZN = "";
        if (e.aAs() != null) {
            b.a aAv = e.aAs().aAv();
            this.mFrom = h.jG(aAv.getAppFrameType());
            this.mAppId = aAv.getAppId();
            this.mSource = aAv.arx();
            this.cZI = aAv.arD().getString("aiapp_extra_need_download", "");
            this.cZK = aAv.arD().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aAv.arz();
            this.cZN = aAv.getPage();
            this.cSI = aAv.arQ();
            this.mAppVersion = aAv.getVersion();
            this.cZG = aAv.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cZG = "";
        this.cZI = "";
        this.cZK = "";
        this.mScheme = "";
        this.cZN = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cZI = jSONObject.optString("needDown");
            this.cZK = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.cZN = jSONObject.optString("extPage");
            this.cSI = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cZG = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cZI);
            jSONObject.put("isPreset", this.cZK);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.cZN);
            jSONObject.put("launchId", this.cSI);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cZG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
