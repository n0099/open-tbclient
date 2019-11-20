package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean aUF;
    public boolean aUG;
    public String aUw;
    public boolean aWA;
    public String aWB;
    public int aWC;
    public String aWD;
    public boolean aWE;
    public String aWF;
    public String aWG;
    public boolean aWH;
    public boolean aWI;
    public boolean aWJ;
    public String aWK;
    private boolean aWL;
    private boolean aWM;
    private boolean aWN;
    public boolean aWO;
    public boolean aWP;
    public boolean aWQ;
    public boolean aWR;
    public boolean aWS;
    public int duration;
    public int mDirection;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.aUw = jSONObject.optString("videoId", cVar.aUw);
            cVar2.aUF = jSONObject.optBoolean("autoplay", cVar.aUF);
            cVar2.aWA = jSONObject.optBoolean("muted", cVar.aWA);
            cVar2.aWD = jSONObject.optString("objectFit", cVar.aWD);
            cVar2.aWC = jSONObject.optInt("initialTime", cVar.aWC);
            cVar2.aWB = jSONObject.optString("poster", cVar.aWB);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.aWE = jSONObject.optBoolean("fullScreen", cVar.aWE);
            cVar2.aWF = ag(jSONObject);
            cVar2.aWG = jSONObject.optString("danmuList", cVar.aWG);
            cVar2.aWH = jSONObject.optBoolean("enableDanmu", cVar.aWH);
            cVar2.aWI = jSONObject.optBoolean("danmuBtn", cVar.aWI);
            cVar2.aUG = jSONObject.optBoolean("loop", cVar.aUG);
            cVar2.aWJ = jSONObject.optBoolean("controls", cVar.aWJ);
            cVar2.mSrc = ga(jSONObject.optString("src", cVar.mSrc));
            cVar2.aWS = !com.baidu.swan.apps.storage.b.m18if(jSONObject.optString("src", cVar.mSrc));
            cVar2.aWL = jSONObject.optBoolean("showPlayBtn", cVar.aWL);
            cVar2.aWM = jSONObject.optBoolean("showMuteBtn", cVar.aWM);
            cVar2.aWN = jSONObject.optBoolean("showCenterPlayBtn", cVar.aWN);
            cVar2.aWO = jSONObject.optBoolean("pageGesture", cVar.aWO);
            cVar2.aWP = jSONObject.optBoolean("showProgress", cVar.aWP);
            cVar2.mDirection = jSONObject.optInt("direction");
            cVar2.aWQ = jSONObject.optBoolean("showFullscreenBtn", cVar.aWQ);
            cVar2.aWR = jSONObject.optBoolean("enableProgressGesture", cVar.aWR);
            cVar2.aWK = jSONObject.optString("sanId", cVar.aWK);
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.aUw = "";
        this.aWA = false;
        this.aWB = "";
        this.aWC = 0;
        this.duration = 0;
        this.aUF = false;
        this.aUG = false;
        this.aWD = "";
        this.mPos = 0;
        this.aWF = "";
        this.aWG = "";
        this.aWH = false;
        this.aWI = false;
        this.aWJ = true;
        this.mSrc = "";
        this.aWK = "";
        this.aWO = false;
        this.aWP = true;
        this.mDirection = 0;
        this.aWQ = true;
        this.aWR = true;
        this.aWS = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aUw);
    }

    public boolean isAutoPlay() {
        return this.aUF;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String ag(JSONObject jSONObject) {
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
        if (!com.baidu.swan.apps.storage.b.m18if(str) || com.baidu.swan.apps.ae.b.Ra() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.Ra());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aUw + "', mSlaveId='" + this.aXp + "', mMuted=" + this.aWA + "', mObjectFit='" + this.aWD + "', mControl=" + this.aWJ + '}';
    }
}
