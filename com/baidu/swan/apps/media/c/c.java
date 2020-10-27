package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cUQ;
    public boolean cUZ;
    public boolean cYP;
    public String cYQ;
    public boolean cYX;
    public String cYY;
    private boolean cYZ;
    public String cZE;
    public b cZF;
    public boolean cZG;
    private boolean cZa;
    private boolean cZb;
    public boolean cZd;
    public boolean cZe;
    public boolean cZg;
    public boolean cco;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cUQ = jSONObject.optString("videoId", cVar.cUQ);
            cVar2.cUZ = jSONObject.optBoolean("autoplay", cVar.cUZ);
            cVar2.cYP = jSONObject.optBoolean("muted", cVar.cYP);
            cVar2.cZE = jSONObject.optString("initialTime", cVar.cZE);
            cVar2.cYQ = jSONObject.optString("poster", cVar.cYQ);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cco = jSONObject.optBoolean("fullScreen", cVar.cco);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cYX = jSONObject.optBoolean("controls", cVar.cYX);
            cVar2.mSrc = ou(jSONObject.optString("src", cVar.mSrc));
            cVar2.cZg = !com.baidu.swan.apps.storage.b.ta(jSONObject.optString("src", cVar.mSrc));
            cVar2.cYZ = jSONObject.optBoolean("showPlayBtn", cVar.cYZ);
            cVar2.cZa = jSONObject.optBoolean("showMuteBtn", cVar.cZa);
            cVar2.cZb = jSONObject.optBoolean("showCenterPlayBtn", cVar.cZb);
            cVar2.cZd = jSONObject.optBoolean("showProgress", cVar.cZd);
            cVar2.cZe = jSONObject.optBoolean("showFullscreenBtn", cVar.cZe);
            cVar2.cYY = jSONObject.optString("sanId", cVar.cYY);
            cVar2.cZF = cVar2.cZF.bh(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cZG = jSONObject.optBoolean("showNoWifiTip", cVar.cZG);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cUQ = "";
        this.cYP = false;
        this.cYQ = "";
        this.cZE = "0";
        this.cUZ = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cYX = true;
        this.mSrc = "";
        this.cYY = "";
        this.cYZ = true;
        this.cZa = true;
        this.cZb = true;
        this.cZd = true;
        this.mDirection = -1;
        this.cZe = true;
        this.cZg = true;
        this.cZF = new b();
        this.cZG = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cUQ);
    }

    private static String ou(String str) {
        if (!com.baidu.swan.apps.storage.b.ta(str) || e.aEU() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aEU());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cUQ + "', mMute=" + this.cYP + ", mPoster='" + this.cYQ + "', mInitialTime=" + this.cZE + ", mAutoPlay=" + this.cUZ + ", mShowNoWifiTip=" + this.cZG + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.cco + ", mShowControlPanel=" + this.cYX + ", mSrc='" + this.mSrc + "', mSanId='" + this.cYY + "', mShowPlayBtn=" + this.cYZ + ", mShowMuteBtn=" + this.cZa + ", mShowCenterPlayBtn=" + this.cZb + ", mShowProgress=" + this.cZd + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cZe + ", mIsRemoteFile=" + this.cZg + ", mVrVideoMode=" + this.cZF.toString() + '}';
    }
}
