package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bLe;
    public boolean cCA;
    public boolean cCC;
    public boolean cCl;
    public String cCm;
    public boolean cCt;
    public String cCu;
    private boolean cCv;
    private boolean cCw;
    private boolean cCx;
    public boolean cCz;
    public String cDa;
    public b cDb;
    public boolean cDc;
    public String cyk;
    public boolean cyt;
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
            cVar2.cDa = jSONObject.optString("initialTime", cVar.cDa);
            cVar2.cCm = jSONObject.optString("poster", cVar.cCm);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bLe = jSONObject.optBoolean("fullScreen", cVar.bLe);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cCt = jSONObject.optBoolean("controls", cVar.cCt);
            cVar2.mSrc = mT(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCC = !com.baidu.swan.apps.storage.b.rA(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCv = jSONObject.optBoolean("showPlayBtn", cVar.cCv);
            cVar2.cCw = jSONObject.optBoolean("showMuteBtn", cVar.cCw);
            cVar2.cCx = jSONObject.optBoolean("showCenterPlayBtn", cVar.cCx);
            cVar2.cCz = jSONObject.optBoolean("showProgress", cVar.cCz);
            cVar2.cCA = jSONObject.optBoolean("showFullscreenBtn", cVar.cCA);
            cVar2.cCu = jSONObject.optString("sanId", cVar.cCu);
            cVar2.cDb = cVar2.cDb.aU(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cDc = jSONObject.optBoolean("showNoWifiTip", cVar.cDc);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cyk = "";
        this.cCl = false;
        this.cCm = "";
        this.cDa = "0";
        this.cyt = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cCt = true;
        this.mSrc = "";
        this.cCu = "";
        this.cCv = true;
        this.cCw = true;
        this.cCx = true;
        this.cCz = true;
        this.mDirection = -1;
        this.cCA = true;
        this.cCC = true;
        this.cDb = new b();
        this.cDc = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cyk);
    }

    private static String mT(String str) {
        if (!com.baidu.swan.apps.storage.b.rA(str) || e.azI() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.azI());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cyk + "', mMute=" + this.cCl + ", mPoster='" + this.cCm + "', mInitialTime=" + this.cDa + ", mAutoPlay=" + this.cyt + ", mShowNoWifiTip=" + this.cDc + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bLe + ", mShowControlPanel=" + this.cCt + ", mSrc='" + this.mSrc + "', mSanId='" + this.cCu + "', mShowPlayBtn=" + this.cCv + ", mShowMuteBtn=" + this.cCw + ", mShowCenterPlayBtn=" + this.cCx + ", mShowProgress=" + this.cCz + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cCA + ", mIsRemoteFile=" + this.cCC + ", mVrVideoMode=" + this.cDb.toString() + '}';
    }
}
