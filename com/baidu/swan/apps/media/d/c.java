package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public b bAa;
    public boolean bAb;
    public String bvC;
    public boolean bvK;
    public boolean bvL;
    private boolean bzA;
    public boolean bzC;
    public boolean bzD;
    public boolean bzF;
    public String bzZ;
    public boolean bzn;
    public String bzo;
    public boolean bzr;
    public boolean bzw;
    public String bzx;
    private boolean bzy;
    private boolean bzz;
    public int mDirection;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bvC = jSONObject.optString("videoId", cVar.bvC);
            cVar2.bvK = jSONObject.optBoolean("autoplay", cVar.bvK);
            cVar2.bzn = jSONObject.optBoolean("muted", cVar.bzn);
            cVar2.bzZ = jSONObject.optString("initialTime", cVar.bzZ);
            cVar2.bzo = jSONObject.optString("poster", cVar.bzo);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bzr = jSONObject.optBoolean("fullScreen", cVar.bzr);
            cVar2.bvL = jSONObject.optBoolean("loop", cVar.bvL);
            cVar2.bzw = jSONObject.optBoolean("controls", cVar.bzw);
            cVar2.mSrc = ja(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bzF = !com.baidu.swan.apps.storage.b.lA(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bzy = jSONObject.optBoolean("showPlayBtn", cVar.bzy);
            cVar2.bzz = jSONObject.optBoolean("showMuteBtn", cVar.bzz);
            cVar2.bzA = jSONObject.optBoolean("showCenterPlayBtn", cVar.bzA);
            cVar2.bzC = jSONObject.optBoolean("showProgress", cVar.bzC);
            cVar2.bzD = jSONObject.optBoolean("showFullscreenBtn", cVar.bzD);
            cVar2.bzx = jSONObject.optString("sanId", cVar.bzx);
            cVar2.bAa = cVar2.bAa.ap(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.bAb = jSONObject.optBoolean("showNoWifiTip", cVar.bAb);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bvC = "";
        this.bzn = false;
        this.bzo = "";
        this.bzZ = "0";
        this.bvK = false;
        this.bvL = false;
        this.mPos = 0;
        this.bzw = true;
        this.mSrc = "";
        this.bzx = "";
        this.bzy = true;
        this.bzz = true;
        this.bzA = true;
        this.bzC = true;
        this.mDirection = -1;
        this.bzD = true;
        this.bzF = true;
        this.bAa = new b();
        this.bAb = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bvC);
    }

    private static String ja(String str) {
        if (!com.baidu.swan.apps.storage.b.lA(str) || e.ZS() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.ZS());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bvC + "', mMute=" + this.bzn + ", mPoster='" + this.bzo + "', mInitialTime=" + this.bzZ + ", mAutoPlay=" + this.bvK + ", mShowNoWifiTip=" + this.bAb + ", mLoop=" + this.bvL + ", mPos=" + this.mPos + ", mFullScreen=" + this.bzr + ", mShowControlPanel=" + this.bzw + ", mSrc='" + this.mSrc + "', mSanId='" + this.bzx + "', mShowPlayBtn=" + this.bzy + ", mShowMuteBtn=" + this.bzz + ", mShowCenterPlayBtn=" + this.bzA + ", mShowProgress=" + this.bzC + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bzD + ", mIsRemoteFile=" + this.bzF + ", mVrVideoMode=" + this.bAa.toString() + '}';
    }
}
