package com.baidu.swan.gamecenter.appmanager.d;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a {
    String cHF;
    String cOC;
    String cOE;
    String cOG;
    String cOJ;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cOC = "";
        this.cOE = "";
        this.cOG = "";
        this.mScheme = "";
        this.cOJ = "";
        if (e.arw() != null) {
            b.a arz = e.arw().arz();
            this.mFrom = h.ho(arz.getAppFrameType());
            this.mAppId = arz.getAppId();
            this.mSource = arz.ajg();
            this.cOE = arz.ajm().getString("aiapp_extra_need_download", "");
            this.cOG = arz.ajm().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = arz.aji();
            this.cOJ = arz.getPage();
            this.cHF = arz.ajz();
            this.mAppVersion = arz.getVersion();
            this.cOC = arz.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cOC = "";
        this.cOE = "";
        this.cOG = "";
        this.mScheme = "";
        this.cOJ = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cOE = jSONObject.optString("needDown");
            this.cOG = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.cOJ = jSONObject.optString("extPage");
            this.cHF = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cOC = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cOE);
            jSONObject.put("isPreset", this.cOG);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.cOJ);
            jSONObject.put("launchId", this.cHF);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cOC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
