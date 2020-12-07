package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cmW;
    public String dga;
    public boolean dgj;
    public boolean dkd;
    public String dke;
    public int dkf;
    public String dkg;
    public String dkh;
    public String dki;
    public boolean dkj;
    public boolean dkk;
    public boolean dkl;
    public String dkm;
    private boolean dkn;
    private boolean dko;
    private boolean dkp;
    public boolean dkq;
    public boolean dkr;
    public boolean dks;
    public boolean dkt;
    public boolean dku;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.dga = jSONObject.optString("videoId", cVar.dga);
            cVar2.dgj = jSONObject.optBoolean("autoplay", cVar.dgj);
            cVar2.dkd = jSONObject.optBoolean("muted", cVar.dkd);
            cVar2.dkg = jSONObject.optString("objectFit", cVar.dkg);
            cVar2.dkf = jSONObject.optInt("initialTime", cVar.dkf);
            cVar2.dke = jSONObject.optString("poster", cVar.dke);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cmW = jSONObject.optBoolean("fullScreen", cVar.cmW);
            cVar2.dkh = bi(jSONObject);
            cVar2.dki = jSONObject.optString("danmuList", cVar.dki);
            cVar2.dkj = jSONObject.optBoolean("enableDanmu", cVar.dkj);
            cVar2.dkk = jSONObject.optBoolean("danmuBtn", cVar.dkk);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dkl = jSONObject.optBoolean("controls", cVar.dkl);
            cVar2.mSrc = pj(jSONObject.optString("src", cVar.mSrc));
            cVar2.dku = !com.baidu.swan.apps.storage.b.tQ(jSONObject.optString("src", cVar.mSrc));
            cVar2.dkn = jSONObject.optBoolean("showPlayBtn", cVar.dkn);
            cVar2.dko = jSONObject.optBoolean("showMuteBtn", cVar.dko);
            cVar2.dkp = jSONObject.optBoolean("showCenterPlayBtn", cVar.dkp);
            cVar2.dkq = jSONObject.optBoolean("pageGesture", cVar.dkq);
            cVar2.dkr = jSONObject.optBoolean("showProgress", cVar.dkr);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.dks = jSONObject.optBoolean("showFullscreenBtn", cVar.dks);
            cVar2.dkt = jSONObject.optBoolean("enableProgressGesture", cVar.dkt);
            cVar2.dkm = jSONObject.optString("sanId", cVar.dkm);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.dga = "";
        this.dkd = false;
        this.dke = "";
        this.dkf = 0;
        this.duration = 0;
        this.dgj = false;
        this.mLoop = false;
        this.dkg = "";
        this.mPos = 0;
        this.dkh = "";
        this.dki = "";
        this.dkj = false;
        this.dkk = false;
        this.dkl = true;
        this.mSrc = "";
        this.dkm = "";
        this.dkq = false;
        this.dkr = true;
        this.mDirection = -1;
        this.dks = true;
        this.dkt = true;
        this.dku = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.dga);
    }

    public boolean isAutoPlay() {
        return this.dgj;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bi(JSONObject jSONObject) {
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

    private static String pj(String str) {
        if (!com.baidu.swan.apps.storage.b.tQ(str) || e.aJU() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aJU());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.dga + "', mMute=" + this.dkd + ", mPoster='" + this.dke + "', mInitialTime=" + this.dkf + ", duration=" + this.duration + ", mAutoPlay=" + this.dgj + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.dkg + "', mPos=" + this.mPos + ", mFullScreen=" + this.cmW + ", mDanmu='" + this.dkh + "', mDanmuList='" + this.dki + "', mEnableDanmu=" + this.dkj + ", mShowDanmuBtn=" + this.dkk + ", mShowControlPanel=" + this.dkl + ", mSrc='" + this.mSrc + "', mSanId='" + this.dkm + "', mShowPlayBtn=" + this.dkn + ", mShowMuteBtn=" + this.dko + ", mShowCenterPlayBtn=" + this.dkp + ", mPageGesture=" + this.dkq + ", mShowProgress=" + this.dkr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dks + ", mEnableProgressGesture=" + this.dkt + ", mIsRemoteFile=" + this.dku + '}';
    }
}
