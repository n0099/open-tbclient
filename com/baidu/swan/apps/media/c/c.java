package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bFE;
    public boolean cqD;
    public String cqu;
    public boolean cuB;
    public String cuC;
    public boolean cuJ;
    public String cuK;
    private boolean cuL;
    private boolean cuM;
    private boolean cuN;
    public boolean cuP;
    public boolean cuQ;
    public boolean cuS;
    public String cvq;
    public b cvr;
    public boolean cvs;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cqu = jSONObject.optString("videoId", cVar.cqu);
            cVar2.cqD = jSONObject.optBoolean("autoplay", cVar.cqD);
            cVar2.cuB = jSONObject.optBoolean("muted", cVar.cuB);
            cVar2.cvq = jSONObject.optString("initialTime", cVar.cvq);
            cVar2.cuC = jSONObject.optString("poster", cVar.cuC);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bFE = jSONObject.optBoolean("fullScreen", cVar.bFE);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cuJ = jSONObject.optBoolean("controls", cVar.cuJ);
            cVar2.mSrc = lb(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cuS = !com.baidu.swan.apps.storage.b.pA(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cuL = jSONObject.optBoolean("showPlayBtn", cVar.cuL);
            cVar2.cuM = jSONObject.optBoolean("showMuteBtn", cVar.cuM);
            cVar2.cuN = jSONObject.optBoolean("showCenterPlayBtn", cVar.cuN);
            cVar2.cuP = jSONObject.optBoolean("showProgress", cVar.cuP);
            cVar2.cuQ = jSONObject.optBoolean("showFullscreenBtn", cVar.cuQ);
            cVar2.cuK = jSONObject.optString("sanId", cVar.cuK);
            cVar2.cvr = cVar2.cvr.aO(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cvs = jSONObject.optBoolean("showNoWifiTip", cVar.cvs);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cqu = "";
        this.cuB = false;
        this.cuC = "";
        this.cvq = "0";
        this.cqD = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cuJ = true;
        this.mSrc = "";
        this.cuK = "";
        this.cuL = true;
        this.cuM = true;
        this.cuN = true;
        this.cuP = true;
        this.mDirection = -1;
        this.cuQ = true;
        this.cuS = true;
        this.cvr = new b();
        this.cvs = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cqu);
    }

    private static String lb(String str) {
        if (!com.baidu.swan.apps.storage.b.pA(str) || e.arv() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.arv());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cqu + "', mMute=" + this.cuB + ", mPoster='" + this.cuC + "', mInitialTime=" + this.cvq + ", mAutoPlay=" + this.cqD + ", mShowNoWifiTip=" + this.cvs + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bFE + ", mShowControlPanel=" + this.cuJ + ", mSrc='" + this.mSrc + "', mSanId='" + this.cuK + "', mShowPlayBtn=" + this.cuL + ", mShowMuteBtn=" + this.cuM + ", mShowCenterPlayBtn=" + this.cuN + ", mShowProgress=" + this.cuP + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cuQ + ", mIsRemoteFile=" + this.cuS + ", mVrVideoMode=" + this.cvr.toString() + '}';
    }
}
