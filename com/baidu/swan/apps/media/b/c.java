package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bTR;
    public boolean cMD;
    public String cMu;
    public boolean cQA;
    public boolean cQB;
    public String cQC;
    private boolean cQD;
    private boolean cQE;
    private boolean cQF;
    public boolean cQG;
    public boolean cQH;
    public boolean cQI;
    public boolean cQJ;
    public boolean cQK;
    public boolean cQt;
    public String cQu;
    public int cQv;
    public String cQw;
    public String cQx;
    public String cQy;
    public boolean cQz;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cMu = jSONObject.optString("videoId", cVar.cMu);
            cVar2.cMD = jSONObject.optBoolean("autoplay", cVar.cMD);
            cVar2.cQt = jSONObject.optBoolean("muted", cVar.cQt);
            cVar2.cQw = jSONObject.optString("objectFit", cVar.cQw);
            cVar2.cQv = jSONObject.optInt("initialTime", cVar.cQv);
            cVar2.cQu = jSONObject.optString("poster", cVar.cQu);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bTR = jSONObject.optBoolean("fullScreen", cVar.bTR);
            cVar2.cQx = bd(jSONObject);
            cVar2.cQy = jSONObject.optString("danmuList", cVar.cQy);
            cVar2.cQz = jSONObject.optBoolean("enableDanmu", cVar.cQz);
            cVar2.cQA = jSONObject.optBoolean("danmuBtn", cVar.cQA);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cQB = jSONObject.optBoolean("controls", cVar.cQB);
            cVar2.mSrc = nZ(jSONObject.optString("src", cVar.mSrc));
            cVar2.cQK = !com.baidu.swan.apps.storage.b.sH(jSONObject.optString("src", cVar.mSrc));
            cVar2.cQD = jSONObject.optBoolean("showPlayBtn", cVar.cQD);
            cVar2.cQE = jSONObject.optBoolean("showMuteBtn", cVar.cQE);
            cVar2.cQF = jSONObject.optBoolean("showCenterPlayBtn", cVar.cQF);
            cVar2.cQG = jSONObject.optBoolean("pageGesture", cVar.cQG);
            cVar2.cQH = jSONObject.optBoolean("showProgress", cVar.cQH);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cQI = jSONObject.optBoolean("showFullscreenBtn", cVar.cQI);
            cVar2.cQJ = jSONObject.optBoolean("enableProgressGesture", cVar.cQJ);
            cVar2.cQC = jSONObject.optString("sanId", cVar.cQC);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cMu = "";
        this.cQt = false;
        this.cQu = "";
        this.cQv = 0;
        this.duration = 0;
        this.cMD = false;
        this.mLoop = false;
        this.cQw = "";
        this.mPos = 0;
        this.cQx = "";
        this.cQy = "";
        this.cQz = false;
        this.cQA = false;
        this.cQB = true;
        this.mSrc = "";
        this.cQC = "";
        this.cQG = false;
        this.cQH = true;
        this.mDirection = -1;
        this.cQI = true;
        this.cQJ = true;
        this.cQK = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cMu);
    }

    public boolean isAutoPlay() {
        return this.cMD;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bd(JSONObject jSONObject) {
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

    private static String nZ(String str) {
        if (!com.baidu.swan.apps.storage.b.sH(str) || e.aDa() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aDa());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cMu + "', mMute=" + this.cQt + ", mPoster='" + this.cQu + "', mInitialTime=" + this.cQv + ", duration=" + this.duration + ", mAutoPlay=" + this.cMD + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cQw + "', mPos=" + this.mPos + ", mFullScreen=" + this.bTR + ", mDanmu='" + this.cQx + "', mDanmuList='" + this.cQy + "', mEnableDanmu=" + this.cQz + ", mShowDanmuBtn=" + this.cQA + ", mShowControlPanel=" + this.cQB + ", mSrc='" + this.mSrc + "', mSanId='" + this.cQC + "', mShowPlayBtn=" + this.cQD + ", mShowMuteBtn=" + this.cQE + ", mShowCenterPlayBtn=" + this.cQF + ", mPageGesture=" + this.cQG + ", mShowProgress=" + this.cQH + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cQI + ", mEnableProgressGesture=" + this.cQJ + ", mIsRemoteFile=" + this.cQK + '}';
    }
}
