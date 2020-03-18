package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAL;
    public boolean bAT;
    public boolean bEC;
    public String bED;
    private boolean bEE;
    private boolean bEF;
    private boolean bEG;
    public boolean bEI;
    public boolean bEJ;
    public boolean bEL;
    public boolean bEt;
    public String bEu;
    public boolean bEx;
    public String bFf;
    public b bFg;
    public boolean bFh;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bAL = jSONObject.optString("videoId", cVar.bAL);
            cVar2.bAT = jSONObject.optBoolean("autoplay", cVar.bAT);
            cVar2.bEt = jSONObject.optBoolean("muted", cVar.bEt);
            cVar2.bFf = jSONObject.optString("initialTime", cVar.bFf);
            cVar2.bEu = jSONObject.optString("poster", cVar.bEu);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEx = jSONObject.optBoolean("fullScreen", cVar.bEx);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEC = jSONObject.optBoolean("controls", cVar.bEC);
            cVar2.mSrc = jr(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEL = !com.baidu.swan.apps.storage.b.lR(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEE = jSONObject.optBoolean("showPlayBtn", cVar.bEE);
            cVar2.bEF = jSONObject.optBoolean("showMuteBtn", cVar.bEF);
            cVar2.bEG = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEG);
            cVar2.bEI = jSONObject.optBoolean("showProgress", cVar.bEI);
            cVar2.bEJ = jSONObject.optBoolean("showFullscreenBtn", cVar.bEJ);
            cVar2.bED = jSONObject.optString("sanId", cVar.bED);
            cVar2.bFg = cVar2.bFg.ap(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.bFh = jSONObject.optBoolean("showNoWifiTip", cVar.bFh);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bAL = "";
        this.bEt = false;
        this.bEu = "";
        this.bFf = "0";
        this.bAT = false;
        this.mLoop = false;
        this.mPos = 0;
        this.bEC = true;
        this.mSrc = "";
        this.bED = "";
        this.bEE = true;
        this.bEF = true;
        this.bEG = true;
        this.bEI = true;
        this.mDirection = -1;
        this.bEJ = true;
        this.bEL = true;
        this.bFg = new b();
        this.bFh = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAL);
    }

    private static String jr(String str) {
        if (!com.baidu.swan.apps.storage.b.lR(str) || e.acI() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.acI());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bAL + "', mMute=" + this.bEt + ", mPoster='" + this.bEu + "', mInitialTime=" + this.bFf + ", mAutoPlay=" + this.bAT + ", mShowNoWifiTip=" + this.bFh + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bEx + ", mShowControlPanel=" + this.bEC + ", mSrc='" + this.mSrc + "', mSanId='" + this.bED + "', mShowPlayBtn=" + this.bEE + ", mShowMuteBtn=" + this.bEF + ", mShowCenterPlayBtn=" + this.bEG + ", mShowProgress=" + this.bEI + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEJ + ", mIsRemoteFile=" + this.bEL + ", mVrVideoMode=" + this.bFg.toString() + '}';
    }
}
