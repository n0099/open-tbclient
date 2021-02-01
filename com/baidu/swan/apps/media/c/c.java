package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean diB;
    public String diq;
    public boolean dmA;
    public boolean dmF;
    public String dmG;
    private boolean dmH;
    private boolean dmI;
    private boolean dmJ;
    public boolean dmL;
    public boolean dmM;
    public boolean dmO;
    public String dmx;
    public String dnl;
    public b dnm;
    public boolean dnn;
    public int mDirection;
    public boolean mLoop;
    public boolean mMute;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.diq = jSONObject.optString("videoId", cVar.diq);
            cVar2.diB = jSONObject.optBoolean("autoplay", cVar.diB);
            cVar2.mMute = jSONObject.optBoolean("muted", cVar.mMute);
            cVar2.dnl = jSONObject.optString("initialTime", cVar.dnl);
            cVar2.dmx = jSONObject.optString("poster", cVar.dmx);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.dmA = jSONObject.optBoolean("fullScreen", cVar.dmA);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dmF = jSONObject.optBoolean("controls", cVar.dmF);
            cVar2.mSrc = oi(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dmO = !com.baidu.swan.apps.storage.b.sV(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dmH = jSONObject.optBoolean("showPlayBtn", cVar.dmH);
            cVar2.dmI = jSONObject.optBoolean("showMuteBtn", cVar.dmI);
            cVar2.dmJ = jSONObject.optBoolean("showCenterPlayBtn", cVar.dmJ);
            cVar2.dmL = jSONObject.optBoolean("showProgress", cVar.dmL);
            cVar2.dmM = jSONObject.optBoolean("showFullscreenBtn", cVar.dmM);
            cVar2.dmG = jSONObject.optString("sanId", cVar.dmG);
            cVar2.dnm = cVar2.dnm.bo(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.dnn = jSONObject.optBoolean("showNoWifiTip", cVar.dnn);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.diq = "";
        this.mMute = false;
        this.dmx = "";
        this.dnl = "0";
        this.diB = false;
        this.mLoop = false;
        this.mPos = 0;
        this.dmF = true;
        this.mSrc = "";
        this.dmG = "";
        this.dmH = true;
        this.dmI = true;
        this.dmJ = true;
        this.dmL = true;
        this.mDirection = -1;
        this.dmM = true;
        this.dmO = true;
        this.dnm = new b();
        this.dnn = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.diq);
    }

    private static String oi(String str) {
        if (!com.baidu.swan.apps.storage.b.sV(str) || e.aIK() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aIK());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.diq + "', mMute=" + this.mMute + ", mPoster='" + this.dmx + "', mInitialTime=" + this.dnl + ", mAutoPlay=" + this.diB + ", mShowNoWifiTip=" + this.dnn + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.dmA + ", mShowControlPanel=" + this.dmF + ", mSrc='" + this.mSrc + "', mSanId='" + this.dmG + "', mShowPlayBtn=" + this.dmH + ", mShowMuteBtn=" + this.dmI + ", mShowCenterPlayBtn=" + this.dmJ + ", mShowProgress=" + this.dmL + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dmM + ", mIsRemoteFile=" + this.dmO + ", mVrVideoMode=" + this.dnm.toString() + '}';
    }
}
