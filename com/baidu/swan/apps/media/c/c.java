package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bTR;
    public boolean cMD;
    public String cMu;
    public boolean cQB;
    public String cQC;
    private boolean cQD;
    private boolean cQE;
    private boolean cQF;
    public boolean cQH;
    public boolean cQI;
    public boolean cQK;
    public boolean cQt;
    public String cQu;
    public String cRi;
    public b cRj;
    public boolean cRk;
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
            cVar2.cRi = jSONObject.optString("initialTime", cVar.cRi);
            cVar2.cQu = jSONObject.optString("poster", cVar.cQu);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bTR = jSONObject.optBoolean("fullScreen", cVar.bTR);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cQB = jSONObject.optBoolean("controls", cVar.cQB);
            cVar2.mSrc = nZ(jSONObject.optString("src", cVar.mSrc));
            cVar2.cQK = !com.baidu.swan.apps.storage.b.sH(jSONObject.optString("src", cVar.mSrc));
            cVar2.cQD = jSONObject.optBoolean("showPlayBtn", cVar.cQD);
            cVar2.cQE = jSONObject.optBoolean("showMuteBtn", cVar.cQE);
            cVar2.cQF = jSONObject.optBoolean("showCenterPlayBtn", cVar.cQF);
            cVar2.cQH = jSONObject.optBoolean("showProgress", cVar.cQH);
            cVar2.cQI = jSONObject.optBoolean("showFullscreenBtn", cVar.cQI);
            cVar2.cQC = jSONObject.optString("sanId", cVar.cQC);
            cVar2.cRj = cVar2.cRj.be(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cRk = jSONObject.optBoolean("showNoWifiTip", cVar.cRk);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cMu = "";
        this.cQt = false;
        this.cQu = "";
        this.cRi = "0";
        this.cMD = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cQB = true;
        this.mSrc = "";
        this.cQC = "";
        this.cQD = true;
        this.cQE = true;
        this.cQF = true;
        this.cQH = true;
        this.mDirection = -1;
        this.cQI = true;
        this.cQK = true;
        this.cRj = new b();
        this.cRk = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cMu);
    }

    private static String nZ(String str) {
        if (!com.baidu.swan.apps.storage.b.sH(str) || e.aDa() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aDa());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cMu + "', mMute=" + this.cQt + ", mPoster='" + this.cQu + "', mInitialTime=" + this.cRi + ", mAutoPlay=" + this.cMD + ", mShowNoWifiTip=" + this.cRk + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bTR + ", mShowControlPanel=" + this.cQB + ", mSrc='" + this.mSrc + "', mSanId='" + this.cQC + "', mShowPlayBtn=" + this.cQD + ", mShowMuteBtn=" + this.cQE + ", mShowCenterPlayBtn=" + this.cQF + ", mShowProgress=" + this.cQH + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cQI + ", mIsRemoteFile=" + this.cQK + ", mVrVideoMode=" + this.cRj.toString() + '}';
    }
}
