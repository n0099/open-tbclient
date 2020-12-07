package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cmW;
    public String dga;
    public boolean dgj;
    public String dkS;
    public b dkT;
    public boolean dkU;
    public boolean dkd;
    public String dke;
    public boolean dkl;
    public String dkm;
    private boolean dkn;
    private boolean dko;
    private boolean dkp;
    public boolean dkr;
    public boolean dks;
    public boolean dku;
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
            cVar2.dkS = jSONObject.optString("initialTime", cVar.dkS);
            cVar2.dke = jSONObject.optString("poster", cVar.dke);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cmW = jSONObject.optBoolean("fullScreen", cVar.cmW);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dkl = jSONObject.optBoolean("controls", cVar.dkl);
            cVar2.mSrc = pj(jSONObject.optString("src", cVar.mSrc));
            cVar2.dku = !com.baidu.swan.apps.storage.b.tQ(jSONObject.optString("src", cVar.mSrc));
            cVar2.dkn = jSONObject.optBoolean("showPlayBtn", cVar.dkn);
            cVar2.dko = jSONObject.optBoolean("showMuteBtn", cVar.dko);
            cVar2.dkp = jSONObject.optBoolean("showCenterPlayBtn", cVar.dkp);
            cVar2.dkr = jSONObject.optBoolean("showProgress", cVar.dkr);
            cVar2.dks = jSONObject.optBoolean("showFullscreenBtn", cVar.dks);
            cVar2.dkm = jSONObject.optString("sanId", cVar.dkm);
            cVar2.dkT = cVar2.dkT.bj(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.dkU = jSONObject.optBoolean("showNoWifiTip", cVar.dkU);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.dga = "";
        this.dkd = false;
        this.dke = "";
        this.dkS = "0";
        this.dgj = false;
        this.mLoop = false;
        this.mPos = 0;
        this.dkl = true;
        this.mSrc = "";
        this.dkm = "";
        this.dkn = true;
        this.dko = true;
        this.dkp = true;
        this.dkr = true;
        this.mDirection = -1;
        this.dks = true;
        this.dku = true;
        this.dkT = new b();
        this.dkU = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.dga);
    }

    private static String pj(String str) {
        if (!com.baidu.swan.apps.storage.b.tQ(str) || e.aJU() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aJU());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.dga + "', mMute=" + this.dkd + ", mPoster='" + this.dke + "', mInitialTime=" + this.dkS + ", mAutoPlay=" + this.dgj + ", mShowNoWifiTip=" + this.dkU + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.cmW + ", mShowControlPanel=" + this.dkl + ", mSrc='" + this.mSrc + "', mSanId='" + this.dkm + "', mShowPlayBtn=" + this.dkn + ", mShowMuteBtn=" + this.dko + ", mShowCenterPlayBtn=" + this.dkp + ", mShowProgress=" + this.dkr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dks + ", mIsRemoteFile=" + this.dku + ", mVrVideoMode=" + this.dkT.toString() + '}';
    }
}
