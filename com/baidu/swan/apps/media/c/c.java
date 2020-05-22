package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bAt;
    public String cjA;
    public boolean cjJ;
    public boolean cnK;
    public String cnL;
    public boolean cnS;
    public String cnT;
    private boolean cnU;
    private boolean cnV;
    private boolean cnW;
    public boolean cnY;
    public boolean cnZ;
    public b coA;
    public boolean coB;
    public boolean cob;
    public String coz;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cjA = jSONObject.optString("videoId", cVar.cjA);
            cVar2.cjJ = jSONObject.optBoolean("autoplay", cVar.cjJ);
            cVar2.cnK = jSONObject.optBoolean("muted", cVar.cnK);
            cVar2.coz = jSONObject.optString("initialTime", cVar.coz);
            cVar2.cnL = jSONObject.optString("poster", cVar.cnL);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bAt = jSONObject.optBoolean("fullScreen", cVar.bAt);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cnS = jSONObject.optBoolean("controls", cVar.cnS);
            cVar2.mSrc = lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cob = !com.baidu.swan.apps.storage.b.oH(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cnU = jSONObject.optBoolean("showPlayBtn", cVar.cnU);
            cVar2.cnV = jSONObject.optBoolean("showMuteBtn", cVar.cnV);
            cVar2.cnW = jSONObject.optBoolean("showCenterPlayBtn", cVar.cnW);
            cVar2.cnY = jSONObject.optBoolean("showProgress", cVar.cnY);
            cVar2.cnZ = jSONObject.optBoolean("showFullscreenBtn", cVar.cnZ);
            cVar2.cnT = jSONObject.optString("sanId", cVar.cnT);
            cVar2.coA = cVar2.coA.aE(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.coB = jSONObject.optBoolean("showNoWifiTip", cVar.coB);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cjA = "";
        this.cnK = false;
        this.cnL = "";
        this.coz = "0";
        this.cjJ = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cnS = true;
        this.mSrc = "";
        this.cnT = "";
        this.cnU = true;
        this.cnV = true;
        this.cnW = true;
        this.cnY = true;
        this.mDirection = -1;
        this.cnZ = true;
        this.cob = true;
        this.coA = new b();
        this.coB = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cjA);
    }

    private static String lS(String str) {
        if (!com.baidu.swan.apps.storage.b.oH(str) || e.aoF() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aoF());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cjA + "', mMute=" + this.cnK + ", mPoster='" + this.cnL + "', mInitialTime=" + this.coz + ", mAutoPlay=" + this.cjJ + ", mShowNoWifiTip=" + this.coB + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bAt + ", mShowControlPanel=" + this.cnS + ", mSrc='" + this.mSrc + "', mSanId='" + this.cnT + "', mShowPlayBtn=" + this.cnU + ", mShowMuteBtn=" + this.cnV + ", mShowCenterPlayBtn=" + this.cnW + ", mShowProgress=" + this.cnY + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cnZ + ", mIsRemoteFile=" + this.cob + ", mVrVideoMode=" + this.coA.toString() + '}';
    }
}
