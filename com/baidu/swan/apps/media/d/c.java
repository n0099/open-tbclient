package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aUO;
    public boolean aUX;
    public boolean aUY;
    public boolean aWS;
    public String aWT;
    public int aWU;
    public String aWV;
    public boolean aWW;
    public String aWX;
    public String aWY;
    public boolean aWZ;
    public boolean aXa;
    public boolean aXb;
    public String aXc;
    private boolean aXd;
    private boolean aXe;
    private boolean aXf;
    public boolean aXg;
    public boolean aXh;
    public boolean aXi;
    public boolean aXj;
    public boolean aXk;
    public int duration;
    public int mDirection;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.aUO = jSONObject.optString("videoId", cVar.aUO);
            cVar2.aUX = jSONObject.optBoolean("autoplay", cVar.aUX);
            cVar2.aWS = jSONObject.optBoolean("muted", cVar.aWS);
            cVar2.aWV = jSONObject.optString("objectFit", cVar.aWV);
            cVar2.aWU = jSONObject.optInt("initialTime", cVar.aWU);
            cVar2.aWT = jSONObject.optString("poster", cVar.aWT);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.aWW = jSONObject.optBoolean("fullScreen", cVar.aWW);
            cVar2.aWX = af(jSONObject);
            cVar2.aWY = jSONObject.optString("danmuList", cVar.aWY);
            cVar2.aWZ = jSONObject.optBoolean("enableDanmu", cVar.aWZ);
            cVar2.aXa = jSONObject.optBoolean("danmuBtn", cVar.aXa);
            cVar2.aUY = jSONObject.optBoolean("loop", cVar.aUY);
            cVar2.aXb = jSONObject.optBoolean("controls", cVar.aXb);
            cVar2.mSrc = ga(jSONObject.optString("src", cVar.mSrc));
            cVar2.aXk = !com.baidu.swan.apps.storage.b.m18if(jSONObject.optString("src", cVar.mSrc));
            cVar2.aXd = jSONObject.optBoolean("showPlayBtn", cVar.aXd);
            cVar2.aXe = jSONObject.optBoolean("showMuteBtn", cVar.aXe);
            cVar2.aXf = jSONObject.optBoolean("showCenterPlayBtn", cVar.aXf);
            cVar2.aXg = jSONObject.optBoolean("pageGesture", cVar.aXg);
            cVar2.aXh = jSONObject.optBoolean("showProgress", cVar.aXh);
            cVar2.mDirection = jSONObject.optInt("direction");
            cVar2.aXi = jSONObject.optBoolean("showFullscreenBtn", cVar.aXi);
            cVar2.aXj = jSONObject.optBoolean("enableProgressGesture", cVar.aXj);
            cVar2.aXc = jSONObject.optString("sanId", cVar.aXc);
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.aUO = "";
        this.aWS = false;
        this.aWT = "";
        this.aWU = 0;
        this.duration = 0;
        this.aUX = false;
        this.aUY = false;
        this.aWV = "";
        this.mPos = 0;
        this.aWX = "";
        this.aWY = "";
        this.aWZ = false;
        this.aXa = false;
        this.aXb = true;
        this.mSrc = "";
        this.aXc = "";
        this.aXg = false;
        this.aXh = true;
        this.mDirection = 0;
        this.aXi = true;
        this.aXj = true;
        this.aXk = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUO);
    }

    public boolean isAutoPlay() {
        return this.aUX;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String af(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("text", jSONObject.optString("text"));
            jSONObject2.putOpt("color", jSONObject.optString("color"));
            jSONObject2.putOpt("videoId", jSONObject.optString("videoId"));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject2.toString();
    }

    private static String ga(String str) {
        if (!com.baidu.swan.apps.storage.b.m18if(str) || com.baidu.swan.apps.ae.b.QZ() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.QZ());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aUO + "', mSlaveId='" + this.aXH + "', mMuted=" + this.aWS + "', mObjectFit='" + this.aWV + "', mControl=" + this.aXb + '}';
    }
}
