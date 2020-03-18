package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String bPF;
    String bVA;
    String bVC;
    String bVD;
    String bVG;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVA = "";
        this.bVC = "";
        this.bVD = "";
        this.mScheme = "";
        this.bVG = "";
        if (e.acJ() != null) {
            b.a acL = e.acJ().acL();
            this.mFrom = f.gs(acL.getAppFrameType());
            this.mAppId = acL.getAppId();
            this.mSource = acL.VM();
            this.bVC = acL.VS().getString("aiapp_extra_need_download", "");
            this.bVD = acL.VS().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = acL.VO();
            this.bVG = acL.getPage();
            this.bPF = acL.Wf();
            this.mAppVersion = acL.getVersion();
            this.bVA = acL.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVA = "";
        this.bVC = "";
        this.bVD = "";
        this.mScheme = "";
        this.bVG = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.bVC = jSONObject.optString("needDown");
            this.bVD = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.bVG = jSONObject.optString("extPage");
            this.bPF = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.bVA = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.bVC);
            jSONObject.put("isPreset", this.bVD);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.bVG);
            jSONObject.put("launchId", this.bPF);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.bVA);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
