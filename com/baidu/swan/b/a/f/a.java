package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    String bKD;
    String bQA;
    String bQB;
    String bQE;
    String bQy;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bQy = "";
        this.bQA = "";
        this.bQB = "";
        this.mScheme = "";
        this.bQE = "";
        if (e.ZT() != null) {
            b.a ZV = e.ZT().ZV();
            this.mFrom = f.ga(ZV.getAppFrameType());
            this.mAppId = ZV.getAppId();
            this.mSource = ZV.SW();
            this.bQA = ZV.Tc().getString("aiapp_extra_need_download", "");
            this.bQB = ZV.Tc().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = ZV.SY();
            this.bQE = ZV.getPage();
            this.bKD = ZV.Tp();
            this.mAppVersion = ZV.getVersion();
            this.bQy = ZV.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bQy = "";
        this.bQA = "";
        this.bQB = "";
        this.mScheme = "";
        this.bQE = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.bQA = jSONObject.optString("needDown");
            this.bQB = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.bQE = jSONObject.optString("extPage");
            this.bKD = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.bQy = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.bQA);
            jSONObject.put("isPreset", this.bQB);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.bQE);
            jSONObject.put("launchId", this.bKD);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.bQy);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
