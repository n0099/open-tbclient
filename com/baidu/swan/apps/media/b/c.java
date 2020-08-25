package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bLe;
    public boolean cCA;
    public boolean cCB;
    public boolean cCC;
    public boolean cCl;
    public String cCm;
    public int cCn;
    public String cCo;
    public String cCp;
    public String cCq;
    public boolean cCr;
    public boolean cCs;
    public boolean cCt;
    public String cCu;
    private boolean cCv;
    private boolean cCw;
    private boolean cCx;
    public boolean cCy;
    public boolean cCz;
    public String cyk;
    public boolean cyt;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cyk = jSONObject.optString("videoId", cVar.cyk);
            cVar2.cyt = jSONObject.optBoolean("autoplay", cVar.cyt);
            cVar2.cCl = jSONObject.optBoolean("muted", cVar.cCl);
            cVar2.cCo = jSONObject.optString("objectFit", cVar.cCo);
            cVar2.cCn = jSONObject.optInt("initialTime", cVar.cCn);
            cVar2.cCm = jSONObject.optString("poster", cVar.cCm);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bLe = jSONObject.optBoolean("fullScreen", cVar.bLe);
            cVar2.cCp = aT(jSONObject);
            cVar2.cCq = jSONObject.optString("danmuList", cVar.cCq);
            cVar2.cCr = jSONObject.optBoolean("enableDanmu", cVar.cCr);
            cVar2.cCs = jSONObject.optBoolean("danmuBtn", cVar.cCs);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cCt = jSONObject.optBoolean("controls", cVar.cCt);
            cVar2.mSrc = mT(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCC = !com.baidu.swan.apps.storage.b.rA(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCv = jSONObject.optBoolean("showPlayBtn", cVar.cCv);
            cVar2.cCw = jSONObject.optBoolean("showMuteBtn", cVar.cCw);
            cVar2.cCx = jSONObject.optBoolean("showCenterPlayBtn", cVar.cCx);
            cVar2.cCy = jSONObject.optBoolean("pageGesture", cVar.cCy);
            cVar2.cCz = jSONObject.optBoolean("showProgress", cVar.cCz);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cCA = jSONObject.optBoolean("showFullscreenBtn", cVar.cCA);
            cVar2.cCB = jSONObject.optBoolean("enableProgressGesture", cVar.cCB);
            cVar2.cCu = jSONObject.optString("sanId", cVar.cCu);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cyk = "";
        this.cCl = false;
        this.cCm = "";
        this.cCn = 0;
        this.duration = 0;
        this.cyt = false;
        this.mLoop = false;
        this.cCo = "";
        this.mPos = 0;
        this.cCp = "";
        this.cCq = "";
        this.cCr = false;
        this.cCs = false;
        this.cCt = true;
        this.mSrc = "";
        this.cCu = "";
        this.cCy = false;
        this.cCz = true;
        this.mDirection = -1;
        this.cCA = true;
        this.cCB = true;
        this.cCC = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cyk);
    }

    public boolean isAutoPlay() {
        return this.cyt;
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

    private static String mT(String str) {
        if (!com.baidu.swan.apps.storage.b.rA(str) || e.azI() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.azI());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cyk + "', mMute=" + this.cCl + ", mPoster='" + this.cCm + "', mInitialTime=" + this.cCn + ", duration=" + this.duration + ", mAutoPlay=" + this.cyt + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cCo + "', mPos=" + this.mPos + ", mFullScreen=" + this.bLe + ", mDanmu='" + this.cCp + "', mDanmuList='" + this.cCq + "', mEnableDanmu=" + this.cCr + ", mShowDanmuBtn=" + this.cCs + ", mShowControlPanel=" + this.cCt + ", mSrc='" + this.mSrc + "', mSanId='" + this.cCu + "', mShowPlayBtn=" + this.cCv + ", mShowMuteBtn=" + this.cCw + ", mShowCenterPlayBtn=" + this.cCx + ", mPageGesture=" + this.cCy + ", mShowProgress=" + this.cCz + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cCA + ", mEnableProgressGesture=" + this.cCB + ", mIsRemoteFile=" + this.cCC + '}';
    }
}
