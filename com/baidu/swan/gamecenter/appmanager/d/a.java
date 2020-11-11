package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    String dAk;
    String dAm;
    String dAo;
    String dAr;
    String dtm;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dAk = "";
        this.dAm = "";
        this.dAo = "";
        this.mScheme = "";
        this.dAr = "";
        if (e.aHv() != null) {
            b.a aHy = e.aHv().aHy();
            this.mFrom = h.ky(aHy.getAppFrameType());
            this.mAppId = aHy.getAppId();
            this.mSource = aHy.ayD();
            this.dAm = aHy.ayJ().getString("aiapp_extra_need_download", "");
            this.dAo = aHy.ayJ().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = aHy.ayF();
            this.dAr = aHy.getPage();
            this.dtm = aHy.ayW();
            this.mAppVersion = aHy.getVersion();
            this.dAk = aHy.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.dAk = "";
        this.dAm = "";
        this.dAo = "";
        this.mScheme = "";
        this.dAr = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.dAm = jSONObject.optString("needDown");
            this.dAo = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString("scheme");
            this.dAr = jSONObject.optString("extPage");
            this.dtm = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.dAk = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.dAm);
            jSONObject.put("isPreset", this.dAo);
            jSONObject.put("scheme", this.mScheme);
            jSONObject.put("extPage", this.dAr);
            jSONObject.put("launchId", this.dtm);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.dAk);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
