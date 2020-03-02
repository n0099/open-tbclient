package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bAH;
    public String bAz;
    public String bET;
    public b bEU;
    public boolean bEV;
    public boolean bEh;
    public String bEi;
    public boolean bEl;
    public boolean bEq;
    public String bEr;
    private boolean bEs;
    private boolean bEt;
    private boolean bEu;
    public boolean bEw;
    public boolean bEx;
    public boolean bEz;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bAz = jSONObject.optString("videoId", cVar.bAz);
            cVar2.bAH = jSONObject.optBoolean("autoplay", cVar.bAH);
            cVar2.bEh = jSONObject.optBoolean("muted", cVar.bEh);
            cVar2.bET = jSONObject.optString("initialTime", cVar.bET);
            cVar2.bEi = jSONObject.optString("poster", cVar.bEi);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEl = jSONObject.optBoolean("fullScreen", cVar.bEl);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEq = jSONObject.optBoolean("controls", cVar.bEq);
            cVar2.mSrc = js(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEz = !com.baidu.swan.apps.storage.b.lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEs = jSONObject.optBoolean("showPlayBtn", cVar.bEs);
            cVar2.bEt = jSONObject.optBoolean("showMuteBtn", cVar.bEt);
            cVar2.bEu = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEu);
            cVar2.bEw = jSONObject.optBoolean("showProgress", cVar.bEw);
            cVar2.bEx = jSONObject.optBoolean("showFullscreenBtn", cVar.bEx);
            cVar2.bEr = jSONObject.optString("sanId", cVar.bEr);
            cVar2.bEU = cVar2.bEU.ap(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.bEV = jSONObject.optBoolean("showNoWifiTip", cVar.bEV);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bAz = "";
        this.bEh = false;
        this.bEi = "";
        this.bET = "0";
        this.bAH = false;
        this.mLoop = false;
        this.mPos = 0;
        this.bEq = true;
        this.mSrc = "";
        this.bEr = "";
        this.bEs = true;
        this.bEt = true;
        this.bEu = true;
        this.bEw = true;
        this.mDirection = -1;
        this.bEx = true;
        this.bEz = true;
        this.bEU = new b();
        this.bEV = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAz);
    }

    private static String js(String str) {
        if (!com.baidu.swan.apps.storage.b.lS(str) || e.acF() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.acF());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bAz + "', mMute=" + this.bEh + ", mPoster='" + this.bEi + "', mInitialTime=" + this.bET + ", mAutoPlay=" + this.bAH + ", mShowNoWifiTip=" + this.bEV + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bEl + ", mShowControlPanel=" + this.bEq + ", mSrc='" + this.mSrc + "', mSanId='" + this.bEr + "', mShowPlayBtn=" + this.bEs + ", mShowMuteBtn=" + this.bEt + ", mShowCenterPlayBtn=" + this.bEu + ", mShowProgress=" + this.bEw + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEx + ", mIsRemoteFile=" + this.bEz + ", mVrVideoMode=" + this.bEU.toString() + '}';
    }
}
