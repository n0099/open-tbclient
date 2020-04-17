package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String cor;
    String cuq;
    String cuu;
    String cuv;
    String cuy;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cuq = "";
        this.cuu = "";
        this.cuv = "";
        this.mScheme = "";
        this.cuy = "";
        if (e.akO() != null) {
            b.a akQ = e.akO().akQ();
            this.mFrom = f.gz(akQ.getAppFrameType());
            this.mAppId = akQ.getAppId();
            this.mSource = akQ.adB();
            this.cuu = akQ.adH().getString("aiapp_extra_need_download", "");
            this.cuv = akQ.adH().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = akQ.adD();
            this.cuy = akQ.getPage();
            this.cor = akQ.adU();
            this.mAppVersion = akQ.getVersion();
            this.cuq = akQ.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cuq = "";
        this.cuu = "";
        this.cuv = "";
        this.mScheme = "";
        this.cuy = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cuu = jSONObject.optString("needDown");
            this.cuv = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.cuy = jSONObject.optString("extPage");
            this.cor = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cuq = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cuu);
            jSONObject.put("isPreset", this.cuv);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.cuy);
            jSONObject.put("launchId", this.cor);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cuq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
