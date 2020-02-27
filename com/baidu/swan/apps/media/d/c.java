package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bAG;
    public String bAy;
    public String bES;
    public b bET;
    public boolean bEU;
    public boolean bEg;
    public String bEh;
    public boolean bEk;
    public boolean bEp;
    public String bEq;
    private boolean bEr;
    private boolean bEs;
    private boolean bEt;
    public boolean bEv;
    public boolean bEw;
    public boolean bEy;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bAy = jSONObject.optString("videoId", cVar.bAy);
            cVar2.bAG = jSONObject.optBoolean("autoplay", cVar.bAG);
            cVar2.bEg = jSONObject.optBoolean("muted", cVar.bEg);
            cVar2.bES = jSONObject.optString("initialTime", cVar.bES);
            cVar2.bEh = jSONObject.optString("poster", cVar.bEh);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEk = jSONObject.optBoolean("fullScreen", cVar.bEk);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEp = jSONObject.optBoolean("controls", cVar.bEp);
            cVar2.mSrc = js(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEy = !com.baidu.swan.apps.storage.b.lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEr = jSONObject.optBoolean("showPlayBtn", cVar.bEr);
            cVar2.bEs = jSONObject.optBoolean("showMuteBtn", cVar.bEs);
            cVar2.bEt = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEt);
            cVar2.bEv = jSONObject.optBoolean("showProgress", cVar.bEv);
            cVar2.bEw = jSONObject.optBoolean("showFullscreenBtn", cVar.bEw);
            cVar2.bEq = jSONObject.optString("sanId", cVar.bEq);
            cVar2.bET = cVar2.bET.ap(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.bEU = jSONObject.optBoolean("showNoWifiTip", cVar.bEU);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bAy = "";
        this.bEg = false;
        this.bEh = "";
        this.bES = "0";
        this.bAG = false;
        this.mLoop = false;
        this.mPos = 0;
        this.bEp = true;
        this.mSrc = "";
        this.bEq = "";
        this.bEr = true;
        this.bEs = true;
        this.bEt = true;
        this.bEv = true;
        this.mDirection = -1;
        this.bEw = true;
        this.bEy = true;
        this.bET = new b();
        this.bEU = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAy);
    }

    private static String js(String str) {
        if (!com.baidu.swan.apps.storage.b.lS(str) || e.acD() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.acD());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bAy + "', mMute=" + this.bEg + ", mPoster='" + this.bEh + "', mInitialTime=" + this.bES + ", mAutoPlay=" + this.bAG + ", mShowNoWifiTip=" + this.bEU + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bEk + ", mShowControlPanel=" + this.bEp + ", mSrc='" + this.mSrc + "', mSanId='" + this.bEq + "', mShowPlayBtn=" + this.bEr + ", mShowMuteBtn=" + this.bEs + ", mShowCenterPlayBtn=" + this.bEt + ", mShowProgress=" + this.bEv + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEw + ", mIsRemoteFile=" + this.bEy + ", mVrVideoMode=" + this.bET.toString() + '}';
    }
}
