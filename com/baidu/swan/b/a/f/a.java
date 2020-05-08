package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String cox;
    String cuA;
    String cuB;
    String cuE;
    String cuy;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cuy = "";
        this.cuA = "";
        this.cuB = "";
        this.mScheme = "";
        this.cuE = "";
        if (e.akN() != null) {
            b.a akP = e.akN().akP();
            this.mFrom = f.gz(akP.getAppFrameType());
            this.mAppId = akP.getAppId();
            this.mSource = akP.adA();
            this.cuA = akP.adG().getString("aiapp_extra_need_download", "");
            this.cuB = akP.adG().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = akP.adC();
            this.cuE = akP.getPage();
            this.cox = akP.adT();
            this.mAppVersion = akP.getVersion();
            this.cuy = akP.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.cuy = "";
        this.cuA = "";
        this.cuB = "";
        this.mScheme = "";
        this.cuE = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.cuA = jSONObject.optString("needDown");
            this.cuB = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.cuE = jSONObject.optString("extPage");
            this.cox = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.cuy = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.cuA);
            jSONObject.put("isPreset", this.cuB);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.cuE);
            jSONObject.put("launchId", this.cox);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.cuy);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
