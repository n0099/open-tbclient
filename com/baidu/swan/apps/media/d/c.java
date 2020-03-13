package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAA;
    public boolean bAI;
    public boolean bEA;
    public String bEU;
    public b bEV;
    public boolean bEW;
    public boolean bEi;
    public String bEj;
    public boolean bEm;
    public boolean bEr;
    public String bEs;
    private boolean bEt;
    private boolean bEu;
    private boolean bEv;
    public boolean bEx;
    public boolean bEy;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bAA = jSONObject.optString("videoId", cVar.bAA);
            cVar2.bAI = jSONObject.optBoolean("autoplay", cVar.bAI);
            cVar2.bEi = jSONObject.optBoolean("muted", cVar.bEi);
            cVar2.bEU = jSONObject.optString("initialTime", cVar.bEU);
            cVar2.bEj = jSONObject.optString("poster", cVar.bEj);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEm = jSONObject.optBoolean("fullScreen", cVar.bEm);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEr = jSONObject.optBoolean("controls", cVar.bEr);
            cVar2.mSrc = js(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEA = !com.baidu.swan.apps.storage.b.lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEt = jSONObject.optBoolean("showPlayBtn", cVar.bEt);
            cVar2.bEu = jSONObject.optBoolean("showMuteBtn", cVar.bEu);
            cVar2.bEv = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEv);
            cVar2.bEx = jSONObject.optBoolean("showProgress", cVar.bEx);
            cVar2.bEy = jSONObject.optBoolean("showFullscreenBtn", cVar.bEy);
            cVar2.bEs = jSONObject.optString("sanId", cVar.bEs);
            cVar2.bEV = cVar2.bEV.ap(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.bEW = jSONObject.optBoolean("showNoWifiTip", cVar.bEW);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bAA = "";
        this.bEi = false;
        this.bEj = "";
        this.bEU = "0";
        this.bAI = false;
        this.mLoop = false;
        this.mPos = 0;
        this.bEr = true;
        this.mSrc = "";
        this.bEs = "";
        this.bEt = true;
        this.bEu = true;
        this.bEv = true;
        this.bEx = true;
        this.mDirection = -1;
        this.bEy = true;
        this.bEA = true;
        this.bEV = new b();
        this.bEW = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAA);
    }

    private static String js(String str) {
        if (!com.baidu.swan.apps.storage.b.lS(str) || e.acF() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.acF());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bAA + "', mMute=" + this.bEi + ", mPoster='" + this.bEj + "', mInitialTime=" + this.bEU + ", mAutoPlay=" + this.bAI + ", mShowNoWifiTip=" + this.bEW + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bEm + ", mShowControlPanel=" + this.bEr + ", mSrc='" + this.mSrc + "', mSanId='" + this.bEs + "', mShowPlayBtn=" + this.bEt + ", mShowMuteBtn=" + this.bEu + ", mShowCenterPlayBtn=" + this.bEv + ", mShowProgress=" + this.bEx + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEy + ", mIsRemoteFile=" + this.bEA + ", mVrVideoMode=" + this.bEV.toString() + '}';
    }
}
