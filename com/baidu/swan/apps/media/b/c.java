package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bLi;
    private boolean cCA;
    private boolean cCB;
    public boolean cCC;
    public boolean cCD;
    public boolean cCE;
    public boolean cCF;
    public boolean cCG;
    public boolean cCp;
    public String cCq;
    public int cCr;
    public String cCs;
    public String cCt;
    public String cCu;
    public boolean cCv;
    public boolean cCw;
    public boolean cCx;
    public String cCy;
    private boolean cCz;
    public String cyo;
    public boolean cyx;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cyo = jSONObject.optString("videoId", cVar.cyo);
            cVar2.cyx = jSONObject.optBoolean("autoplay", cVar.cyx);
            cVar2.cCp = jSONObject.optBoolean("muted", cVar.cCp);
            cVar2.cCs = jSONObject.optString("objectFit", cVar.cCs);
            cVar2.cCr = jSONObject.optInt("initialTime", cVar.cCr);
            cVar2.cCq = jSONObject.optString("poster", cVar.cCq);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bLi = jSONObject.optBoolean("fullScreen", cVar.bLi);
            cVar2.cCt = aT(jSONObject);
            cVar2.cCu = jSONObject.optString("danmuList", cVar.cCu);
            cVar2.cCv = jSONObject.optBoolean("enableDanmu", cVar.cCv);
            cVar2.cCw = jSONObject.optBoolean("danmuBtn", cVar.cCw);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cCx = jSONObject.optBoolean("controls", cVar.cCx);
            cVar2.mSrc = mU(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCG = !com.baidu.swan.apps.storage.b.rB(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCz = jSONObject.optBoolean("showPlayBtn", cVar.cCz);
            cVar2.cCA = jSONObject.optBoolean("showMuteBtn", cVar.cCA);
            cVar2.cCB = jSONObject.optBoolean("showCenterPlayBtn", cVar.cCB);
            cVar2.cCC = jSONObject.optBoolean("pageGesture", cVar.cCC);
            cVar2.cCD = jSONObject.optBoolean("showProgress", cVar.cCD);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cCE = jSONObject.optBoolean("showFullscreenBtn", cVar.cCE);
            cVar2.cCF = jSONObject.optBoolean("enableProgressGesture", cVar.cCF);
            cVar2.cCy = jSONObject.optString("sanId", cVar.cCy);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cyo = "";
        this.cCp = false;
        this.cCq = "";
        this.cCr = 0;
        this.duration = 0;
        this.cyx = false;
        this.mLoop = false;
        this.cCs = "";
        this.mPos = 0;
        this.cCt = "";
        this.cCu = "";
        this.cCv = false;
        this.cCw = false;
        this.cCx = true;
        this.mSrc = "";
        this.cCy = "";
        this.cCC = false;
        this.cCD = true;
        this.mDirection = -1;
        this.cCE = true;
        this.cCF = true;
        this.cCG = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cyo);
    }

    public boolean isAutoPlay() {
        return this.cyx;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String aT(JSONObject jSONObject) {
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

    private static String mU(String str) {
        if (!com.baidu.swan.apps.storage.b.rB(str) || e.azI() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.azI());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cyo + "', mMute=" + this.cCp + ", mPoster='" + this.cCq + "', mInitialTime=" + this.cCr + ", duration=" + this.duration + ", mAutoPlay=" + this.cyx + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cCs + "', mPos=" + this.mPos + ", mFullScreen=" + this.bLi + ", mDanmu='" + this.cCt + "', mDanmuList='" + this.cCu + "', mEnableDanmu=" + this.cCv + ", mShowDanmuBtn=" + this.cCw + ", mShowControlPanel=" + this.cCx + ", mSrc='" + this.mSrc + "', mSanId='" + this.cCy + "', mShowPlayBtn=" + this.cCz + ", mShowMuteBtn=" + this.cCA + ", mShowCenterPlayBtn=" + this.cCB + ", mPageGesture=" + this.cCC + ", mShowProgress=" + this.cCD + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cCE + ", mEnableProgressGesture=" + this.cCF + ", mIsRemoteFile=" + this.cCG + '}';
    }
}
