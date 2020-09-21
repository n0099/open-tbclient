package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bNi;
    public String cAp;
    public boolean cAy;
    private boolean cEA;
    private boolean cEB;
    public boolean cED;
    public boolean cEE;
    public boolean cEG;
    public boolean cEp;
    public String cEq;
    public boolean cEx;
    public String cEy;
    private boolean cEz;
    public String cFe;
    public b cFf;
    public boolean cFg;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cAp = jSONObject.optString("videoId", cVar.cAp);
            cVar2.cAy = jSONObject.optBoolean("autoplay", cVar.cAy);
            cVar2.cEp = jSONObject.optBoolean("muted", cVar.cEp);
            cVar2.cFe = jSONObject.optString("initialTime", cVar.cFe);
            cVar2.cEq = jSONObject.optString("poster", cVar.cEq);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bNi = jSONObject.optBoolean("fullScreen", cVar.bNi);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cEx = jSONObject.optBoolean("controls", cVar.cEx);
            cVar2.mSrc = nn(jSONObject.optString("src", cVar.mSrc));
            cVar2.cEG = !com.baidu.swan.apps.storage.b.rU(jSONObject.optString("src", cVar.mSrc));
            cVar2.cEz = jSONObject.optBoolean("showPlayBtn", cVar.cEz);
            cVar2.cEA = jSONObject.optBoolean("showMuteBtn", cVar.cEA);
            cVar2.cEB = jSONObject.optBoolean("showCenterPlayBtn", cVar.cEB);
            cVar2.cED = jSONObject.optBoolean("showProgress", cVar.cED);
            cVar2.cEE = jSONObject.optBoolean("showFullscreenBtn", cVar.cEE);
            cVar2.cEy = jSONObject.optString("sanId", cVar.cEy);
            cVar2.cFf = cVar2.cFf.aX(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cFg = jSONObject.optBoolean("showNoWifiTip", cVar.cFg);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cAp = "";
        this.cEp = false;
        this.cEq = "";
        this.cFe = "0";
        this.cAy = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cEx = true;
        this.mSrc = "";
        this.cEy = "";
        this.cEz = true;
        this.cEA = true;
        this.cEB = true;
        this.cED = true;
        this.mDirection = -1;
        this.cEE = true;
        this.cEG = true;
        this.cFf = new b();
        this.cFg = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cAp);
    }

    private static String nn(String str) {
        if (!com.baidu.swan.apps.storage.b.rU(str) || e.aAr() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aAr());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cAp + "', mMute=" + this.cEp + ", mPoster='" + this.cEq + "', mInitialTime=" + this.cFe + ", mAutoPlay=" + this.cAy + ", mShowNoWifiTip=" + this.cFg + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bNi + ", mShowControlPanel=" + this.cEx + ", mSrc='" + this.mSrc + "', mSanId='" + this.cEy + "', mShowPlayBtn=" + this.cEz + ", mShowMuteBtn=" + this.cEA + ", mShowCenterPlayBtn=" + this.cEB + ", mShowProgress=" + this.cED + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cEE + ", mIsRemoteFile=" + this.cEG + ", mVrVideoMode=" + this.cFf.toString() + '}';
    }
}
