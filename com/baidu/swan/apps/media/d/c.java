package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bYS;
    public boolean bZa;
    public boolean bsM;
    public String cdO;
    public b cdP;
    public boolean cdQ;
    public boolean cdc;
    public String cdd;
    public boolean cdk;
    public String cdm;
    private boolean cdn;
    private boolean cdo;
    private boolean cdp;
    public boolean cdr;
    public boolean cds;
    public boolean cdu;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bYS = jSONObject.optString("videoId", cVar.bYS);
            cVar2.bZa = jSONObject.optBoolean("autoplay", cVar.bZa);
            cVar2.cdc = jSONObject.optBoolean("muted", cVar.cdc);
            cVar2.cdO = jSONObject.optString("initialTime", cVar.cdO);
            cVar2.cdd = jSONObject.optString("poster", cVar.cdd);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bsM = jSONObject.optBoolean("fullScreen", cVar.bsM);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cdk = jSONObject.optBoolean("controls", cVar.cdk);
            cVar2.mSrc = kE(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdu = !com.baidu.swan.apps.storage.b.ne(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdn = jSONObject.optBoolean("showPlayBtn", cVar.cdn);
            cVar2.cdo = jSONObject.optBoolean("showMuteBtn", cVar.cdo);
            cVar2.cdp = jSONObject.optBoolean("showCenterPlayBtn", cVar.cdp);
            cVar2.cdr = jSONObject.optBoolean("showProgress", cVar.cdr);
            cVar2.cds = jSONObject.optBoolean("showFullscreenBtn", cVar.cds);
            cVar2.cdm = jSONObject.optString("sanId", cVar.cdm);
            cVar2.cdP = cVar2.cdP.aA(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cdQ = jSONObject.optBoolean("showNoWifiTip", cVar.cdQ);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bYS = "";
        this.cdc = false;
        this.cdd = "";
        this.cdO = "0";
        this.bZa = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cdk = true;
        this.mSrc = "";
        this.cdm = "";
        this.cdn = true;
        this.cdo = true;
        this.cdp = true;
        this.cdr = true;
        this.mDirection = -1;
        this.cds = true;
        this.cdu = true;
        this.cdP = new b();
        this.cdQ = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYS);
    }

    private static String kE(String str) {
        if (!com.baidu.swan.apps.storage.b.ne(str) || e.akN() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.akN());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bYS + "', mMute=" + this.cdc + ", mPoster='" + this.cdd + "', mInitialTime=" + this.cdO + ", mAutoPlay=" + this.bZa + ", mShowNoWifiTip=" + this.cdQ + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bsM + ", mShowControlPanel=" + this.cdk + ", mSrc='" + this.mSrc + "', mSanId='" + this.cdm + "', mShowPlayBtn=" + this.cdn + ", mShowMuteBtn=" + this.cdo + ", mShowCenterPlayBtn=" + this.cdp + ", mShowProgress=" + this.cdr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cds + ", mIsRemoteFile=" + this.cdu + ", mVrVideoMode=" + this.cdP.toString() + '}';
    }
}
