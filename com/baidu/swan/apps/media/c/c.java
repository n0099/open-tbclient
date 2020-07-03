package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bFh;
    public String cop;
    public boolean coy;
    public boolean csF;
    public String csG;
    private boolean csH;
    private boolean csI;
    private boolean csJ;
    public boolean csL;
    public boolean csM;
    public boolean csO;
    public boolean csx;
    public String csy;
    public String ctm;
    public b ctn;
    public boolean cto;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cop = jSONObject.optString("videoId", cVar.cop);
            cVar2.coy = jSONObject.optBoolean("autoplay", cVar.coy);
            cVar2.csx = jSONObject.optBoolean("muted", cVar.csx);
            cVar2.ctm = jSONObject.optString("initialTime", cVar.ctm);
            cVar2.csy = jSONObject.optString("poster", cVar.csy);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bFh = jSONObject.optBoolean("fullScreen", cVar.bFh);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.csF = jSONObject.optBoolean("controls", cVar.csF);
            cVar2.mSrc = ma(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.csO = !com.baidu.swan.apps.storage.b.oP(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.csH = jSONObject.optBoolean("showPlayBtn", cVar.csH);
            cVar2.csI = jSONObject.optBoolean("showMuteBtn", cVar.csI);
            cVar2.csJ = jSONObject.optBoolean("showCenterPlayBtn", cVar.csJ);
            cVar2.csL = jSONObject.optBoolean("showProgress", cVar.csL);
            cVar2.csM = jSONObject.optBoolean("showFullscreenBtn", cVar.csM);
            cVar2.csG = jSONObject.optString("sanId", cVar.csG);
            cVar2.ctn = cVar2.ctn.aL(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cto = jSONObject.optBoolean("showNoWifiTip", cVar.cto);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cop = "";
        this.csx = false;
        this.csy = "";
        this.ctm = "0";
        this.coy = false;
        this.mLoop = false;
        this.mPos = 0;
        this.csF = true;
        this.mSrc = "";
        this.csG = "";
        this.csH = true;
        this.csI = true;
        this.csJ = true;
        this.csL = true;
        this.mDirection = -1;
        this.csM = true;
        this.csO = true;
        this.ctn = new b();
        this.cto = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cop);
    }

    private static String ma(String str) {
        if (!com.baidu.swan.apps.storage.b.oP(str) || e.apM() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.apM());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cop + "', mMute=" + this.csx + ", mPoster='" + this.csy + "', mInitialTime=" + this.ctm + ", mAutoPlay=" + this.coy + ", mShowNoWifiTip=" + this.cto + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bFh + ", mShowControlPanel=" + this.csF + ", mSrc='" + this.mSrc + "', mSanId='" + this.csG + "', mShowPlayBtn=" + this.csH + ", mShowMuteBtn=" + this.csI + ", mShowCenterPlayBtn=" + this.csJ + ", mShowProgress=" + this.csL + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.csM + ", mIsRemoteFile=" + this.csO + ", mVrVideoMode=" + this.ctn.toString() + '}';
    }
}
