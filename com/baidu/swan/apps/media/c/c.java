package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cia;
    public String daK;
    public boolean daT;
    public boolean deM;
    public String deN;
    public boolean deU;
    public String deV;
    private boolean deW;
    private boolean deX;
    private boolean deY;
    public String dfB;
    public b dfC;
    public boolean dfD;
    public boolean dfa;
    public boolean dfb;
    public boolean dfd;
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
            cVar2.dfB = jSONObject.optString("initialTime", cVar.dfB);
            cVar2.deN = jSONObject.optString("poster", cVar.deN);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cia = jSONObject.optBoolean("fullScreen", cVar.cia);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.deU = jSONObject.optBoolean("controls", cVar.deU);
            cVar2.mSrc = oI(jSONObject.optString("src", cVar.mSrc));
            cVar2.dfd = !com.baidu.swan.apps.storage.b.to(jSONObject.optString("src", cVar.mSrc));
            cVar2.deW = jSONObject.optBoolean("showPlayBtn", cVar.deW);
            cVar2.deX = jSONObject.optBoolean("showMuteBtn", cVar.deX);
            cVar2.deY = jSONObject.optBoolean("showCenterPlayBtn", cVar.deY);
            cVar2.dfa = jSONObject.optBoolean("showProgress", cVar.dfa);
            cVar2.dfb = jSONObject.optBoolean("showFullscreenBtn", cVar.dfb);
            cVar2.deV = jSONObject.optString("sanId", cVar.deV);
            cVar2.dfC = cVar2.dfC.bn(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.dfD = jSONObject.optBoolean("showNoWifiTip", cVar.dfD);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.daK = "";
        this.deM = false;
        this.deN = "";
        this.dfB = "0";
        this.daT = false;
        this.mLoop = false;
        this.mPos = 0;
        this.deU = true;
        this.mSrc = "";
        this.deV = "";
        this.deW = true;
        this.deX = true;
        this.deY = true;
        this.dfa = true;
        this.mDirection = -1;
        this.dfb = true;
        this.dfd = true;
        this.dfC = new b();
        this.dfD = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.daK);
    }

    private static String oI(String str) {
        if (!com.baidu.swan.apps.storage.b.to(str) || e.aHu() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aHu());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.daK + "', mMute=" + this.deM + ", mPoster='" + this.deN + "', mInitialTime=" + this.dfB + ", mAutoPlay=" + this.daT + ", mShowNoWifiTip=" + this.dfD + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.cia + ", mShowControlPanel=" + this.deU + ", mSrc='" + this.mSrc + "', mSanId='" + this.deV + "', mShowPlayBtn=" + this.deW + ", mShowMuteBtn=" + this.deX + ", mShowCenterPlayBtn=" + this.deY + ", mShowProgress=" + this.dfa + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dfb + ", mIsRemoteFile=" + this.dfd + ", mVrVideoMode=" + this.dfC.toString() + '}';
    }
}
