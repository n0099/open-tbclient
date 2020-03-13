package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String bPu;
    String bVp;
    String bVr;
    String bVs;
    String bVv;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVp = "";
        this.bVr = "";
        this.bVs = "";
        this.mScheme = "";
        this.bVv = "";
        if (e.acG() != null) {
            b.a acI = e.acG().acI();
            this.mFrom = f.gs(acI.getAppFrameType());
            this.mAppId = acI.getAppId();
            this.mSource = acI.VJ();
            this.bVr = acI.VP().getString("aiapp_extra_need_download", "");
            this.bVs = acI.VP().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = acI.VL();
            this.bVv = acI.getPage();
            this.bPu = acI.Wc();
            this.mAppVersion = acI.getVersion();
            this.bVp = acI.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVp = "";
        this.bVr = "";
        this.bVs = "";
        this.mScheme = "";
        this.bVv = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.bVr = jSONObject.optString("needDown");
            this.bVs = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.bVv = jSONObject.optString("extPage");
            this.bPu = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.bVp = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.bVr);
            jSONObject.put("isPreset", this.bVs);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.bVv);
            jSONObject.put("launchId", this.bPu);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.bVp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
