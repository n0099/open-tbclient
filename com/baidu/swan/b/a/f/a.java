package com.baidu.swan.b.a.f;

import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    String bPt;
    String bVo;
    String bVq;
    String bVr;
    String bVu;
    String mAppId;
    String mAppVersion;
    String mFrom;
    String mScheme;
    String mSource;

    public a() {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVo = "";
        this.bVq = "";
        this.bVr = "";
        this.mScheme = "";
        this.bVu = "";
        if (e.acG() != null) {
            b.a acI = e.acG().acI();
            this.mFrom = f.gs(acI.getAppFrameType());
            this.mAppId = acI.getAppId();
            this.mSource = acI.VJ();
            this.bVq = acI.VP().getString("aiapp_extra_need_download", "");
            this.bVr = acI.VP().getString("aiapp_extra_preset_pkg", "");
            this.mScheme = acI.VL();
            this.bVu = acI.getPage();
            this.bPt = acI.Wc();
            this.mAppVersion = acI.getVersion();
            this.bVo = acI.getVersionCode();
        }
    }

    public a(JSONObject jSONObject) {
        this.mFrom = "swan";
        this.mAppVersion = "";
        this.bVo = "";
        this.bVq = "";
        this.bVr = "";
        this.mScheme = "";
        this.bVu = "";
        if (jSONObject != null && jSONObject.length() != 0) {
            this.mFrom = jSONObject.optString("from", "swan");
            this.mAppId = jSONObject.optString("appId");
            this.mSource = jSONObject.optString("source");
            this.bVq = jSONObject.optString("needDown");
            this.bVr = jSONObject.optString("isPreset");
            this.mScheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
            this.bVu = jSONObject.optString("extPage");
            this.bPt = jSONObject.optString("launchId", null);
            this.mAppVersion = jSONObject.optString("appVersion");
            this.bVo = jSONObject.optString("thirdVersion");
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.mFrom);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("source", this.mSource);
            jSONObject.put("needDown", this.bVq);
            jSONObject.put("isPreset", this.bVr);
            jSONObject.put(SuspensionBallEntity.KEY_SCHEME, this.mScheme);
            jSONObject.put("extPage", this.bVu);
            jSONObject.put("launchId", this.bPt);
            jSONObject.put("appVersion", this.mAppVersion);
            jSONObject.put("thirdVersion", this.bVo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
