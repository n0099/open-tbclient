package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBA;
    public boolean aBJ;
    public boolean aDD;
    public String aDE;
    public int aDF;
    public String aDG;
    public boolean aDH;
    public String aDI;
    public String aDJ;
    public boolean aDK;
    public boolean aDL;
    public boolean aDM;
    public String aDN;
    private boolean aDO;
    private boolean aDP;
    private boolean aDQ;
    public boolean aDR;
    public boolean aDS;
    public boolean aDT;
    public boolean aDU;
    public boolean aDV;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.aBA = jSONObject.optString("videoId", cVar.aBA);
            cVar2.aBJ = jSONObject.optBoolean("autoplay", cVar.aBJ);
            cVar2.aDD = jSONObject.optBoolean("muted", cVar.aDD);
            cVar2.aDG = jSONObject.optString("objectFit", cVar.aDG);
            cVar2.aDF = jSONObject.optInt("initialTime", cVar.aDF);
            cVar2.aDE = jSONObject.optString("poster", cVar.aDE);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.aDH = jSONObject.optBoolean("fullScreen", cVar.aDH);
            cVar2.aDI = H(jSONObject);
            cVar2.aDJ = jSONObject.optString("danmuList", cVar.aDJ);
            cVar2.aDK = jSONObject.optBoolean("enableDanmu", cVar.aDK);
            cVar2.aDL = jSONObject.optBoolean("danmuBtn", cVar.aDL);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.aDM = jSONObject.optBoolean("controls", cVar.aDM);
            cVar2.mSrc = fu(jSONObject.optString("src", cVar.mSrc));
            cVar2.aDV = !com.baidu.swan.apps.storage.b.hB(jSONObject.optString("src", cVar.mSrc));
            cVar2.aDO = jSONObject.optBoolean("showPlayBtn", cVar.aDO);
            cVar2.aDP = jSONObject.optBoolean("showMuteBtn", cVar.aDP);
            cVar2.aDQ = jSONObject.optBoolean("showCenterPlayBtn", cVar.aDQ);
            cVar2.aDR = jSONObject.optBoolean("pageGesture", cVar.aDR);
            cVar2.aDS = jSONObject.optBoolean("showProgress", cVar.aDS);
            cVar2.mDirection = jSONObject.optInt("direction");
            cVar2.aDT = jSONObject.optBoolean("showFullscreenBtn", cVar.aDT);
            cVar2.aDU = jSONObject.optBoolean("enableProgressGesture", cVar.aDU);
            cVar2.aDN = jSONObject.optString("sanId", cVar.aDN);
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.aBA = "";
        this.aDD = false;
        this.aDE = "";
        this.aDF = 0;
        this.duration = 0;
        this.aBJ = false;
        this.mLoop = false;
        this.aDG = "";
        this.mPos = 0;
        this.aDI = "";
        this.aDJ = "";
        this.aDK = false;
        this.aDL = false;
        this.aDM = true;
        this.mSrc = "";
        this.aDN = "";
        this.aDR = false;
        this.aDS = true;
        this.mDirection = 0;
        this.aDT = true;
        this.aDU = true;
        this.aDV = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBA);
    }

    public boolean isAutoPlay() {
        return this.aBJ;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String H(JSONObject jSONObject) {
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

    private static String fu(String str) {
        if (!com.baidu.swan.apps.storage.b.hB(str) || com.baidu.swan.apps.ae.b.Mh() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.Mh());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aBA + "', mSlaveId='" + this.aEs + "', mMuted=" + this.aDD + "', mObjectFit='" + this.aDG + "', mControl=" + this.aDM + '}';
    }
}
