package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bLi;
    private boolean cCA;
    private boolean cCB;
    public boolean cCD;
    public boolean cCE;
    public boolean cCG;
    public boolean cCp;
    public String cCq;
    public boolean cCx;
    public String cCy;
    private boolean cCz;
    public String cDe;
    public b cDf;
    public boolean cDg;
    public String cyo;
    public boolean cyx;
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
            cVar2.cDe = jSONObject.optString("initialTime", cVar.cDe);
            cVar2.cCq = jSONObject.optString("poster", cVar.cCq);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bLi = jSONObject.optBoolean("fullScreen", cVar.bLi);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cCx = jSONObject.optBoolean("controls", cVar.cCx);
            cVar2.mSrc = mU(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCG = !com.baidu.swan.apps.storage.b.rB(jSONObject.optString("src", cVar.mSrc));
            cVar2.cCz = jSONObject.optBoolean("showPlayBtn", cVar.cCz);
            cVar2.cCA = jSONObject.optBoolean("showMuteBtn", cVar.cCA);
            cVar2.cCB = jSONObject.optBoolean("showCenterPlayBtn", cVar.cCB);
            cVar2.cCD = jSONObject.optBoolean("showProgress", cVar.cCD);
            cVar2.cCE = jSONObject.optBoolean("showFullscreenBtn", cVar.cCE);
            cVar2.cCy = jSONObject.optString("sanId", cVar.cCy);
            cVar2.cDf = cVar2.cDf.aU(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cDg = jSONObject.optBoolean("showNoWifiTip", cVar.cDg);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cyo = "";
        this.cCp = false;
        this.cCq = "";
        this.cDe = "0";
        this.cyx = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cCx = true;
        this.mSrc = "";
        this.cCy = "";
        this.cCz = true;
        this.cCA = true;
        this.cCB = true;
        this.cCD = true;
        this.mDirection = -1;
        this.cCE = true;
        this.cCG = true;
        this.cDf = new b();
        this.cDg = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cyo);
    }

    private static String mU(String str) {
        if (!com.baidu.swan.apps.storage.b.rB(str) || e.azI() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.azI());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cyo + "', mMute=" + this.cCp + ", mPoster='" + this.cCq + "', mInitialTime=" + this.cDe + ", mAutoPlay=" + this.cyx + ", mShowNoWifiTip=" + this.cDg + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bLi + ", mShowControlPanel=" + this.cCx + ", mSrc='" + this.mSrc + "', mSanId='" + this.cCy + "', mShowPlayBtn=" + this.cCz + ", mShowMuteBtn=" + this.cCA + ", mShowCenterPlayBtn=" + this.cCB + ", mShowProgress=" + this.cCD + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cCE + ", mIsRemoteFile=" + this.cCG + ", mVrVideoMode=" + this.cDf.toString() + '}';
    }
}
