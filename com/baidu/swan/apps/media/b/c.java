package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cia;
    public String daK;
    public boolean daT;
    public boolean deM;
    public String deN;
    public int deO;
    public String deP;
    public String deQ;
    public String deR;
    public boolean deS;
    public boolean deT;
    public boolean deU;
    public String deV;
    private boolean deW;
    private boolean deX;
    private boolean deY;
    public boolean deZ;
    public boolean dfa;
    public boolean dfb;
    public boolean dfc;
    public boolean dfd;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.daK = jSONObject.optString("videoId", cVar.daK);
            cVar2.daT = jSONObject.optBoolean("autoplay", cVar.daT);
            cVar2.deM = jSONObject.optBoolean("muted", cVar.deM);
            cVar2.deP = jSONObject.optString("objectFit", cVar.deP);
            cVar2.deO = jSONObject.optInt("initialTime", cVar.deO);
            cVar2.deN = jSONObject.optString("poster", cVar.deN);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cia = jSONObject.optBoolean("fullScreen", cVar.cia);
            cVar2.deQ = bm(jSONObject);
            cVar2.deR = jSONObject.optString("danmuList", cVar.deR);
            cVar2.deS = jSONObject.optBoolean("enableDanmu", cVar.deS);
            cVar2.deT = jSONObject.optBoolean("danmuBtn", cVar.deT);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.deU = jSONObject.optBoolean("controls", cVar.deU);
            cVar2.mSrc = oI(jSONObject.optString("src", cVar.mSrc));
            cVar2.dfd = !com.baidu.swan.apps.storage.b.to(jSONObject.optString("src", cVar.mSrc));
            cVar2.deW = jSONObject.optBoolean("showPlayBtn", cVar.deW);
            cVar2.deX = jSONObject.optBoolean("showMuteBtn", cVar.deX);
            cVar2.deY = jSONObject.optBoolean("showCenterPlayBtn", cVar.deY);
            cVar2.deZ = jSONObject.optBoolean("pageGesture", cVar.deZ);
            cVar2.dfa = jSONObject.optBoolean("showProgress", cVar.dfa);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.dfb = jSONObject.optBoolean("showFullscreenBtn", cVar.dfb);
            cVar2.dfc = jSONObject.optBoolean("enableProgressGesture", cVar.dfc);
            cVar2.deV = jSONObject.optString("sanId", cVar.deV);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.daK = "";
        this.deM = false;
        this.deN = "";
        this.deO = 0;
        this.duration = 0;
        this.daT = false;
        this.mLoop = false;
        this.deP = "";
        this.mPos = 0;
        this.deQ = "";
        this.deR = "";
        this.deS = false;
        this.deT = false;
        this.deU = true;
        this.mSrc = "";
        this.deV = "";
        this.deZ = false;
        this.dfa = true;
        this.mDirection = -1;
        this.dfb = true;
        this.dfc = true;
        this.dfd = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.daK);
    }

    public boolean isAutoPlay() {
        return this.daT;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bm(JSONObject jSONObject) {
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

    private static String oI(String str) {
        if (!com.baidu.swan.apps.storage.b.to(str) || e.aHu() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aHu());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.daK + "', mMute=" + this.deM + ", mPoster='" + this.deN + "', mInitialTime=" + this.deO + ", duration=" + this.duration + ", mAutoPlay=" + this.daT + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.deP + "', mPos=" + this.mPos + ", mFullScreen=" + this.cia + ", mDanmu='" + this.deQ + "', mDanmuList='" + this.deR + "', mEnableDanmu=" + this.deS + ", mShowDanmuBtn=" + this.deT + ", mShowControlPanel=" + this.deU + ", mSrc='" + this.mSrc + "', mSanId='" + this.deV + "', mShowPlayBtn=" + this.deW + ", mShowMuteBtn=" + this.deX + ", mShowCenterPlayBtn=" + this.deY + ", mPageGesture=" + this.deZ + ", mShowProgress=" + this.dfa + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dfb + ", mEnableProgressGesture=" + this.dfc + ", mIsRemoteFile=" + this.dfd + '}';
    }
}
