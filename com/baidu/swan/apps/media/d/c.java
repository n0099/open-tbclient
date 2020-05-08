package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bYY;
    public boolean bZg;
    public boolean bsQ;
    public boolean cdA;
    public String cdU;
    public b cdV;
    public boolean cdW;
    public boolean cdi;
    public String cdj;
    public boolean cdr;
    public String cds;
    private boolean cdt;
    private boolean cdu;
    private boolean cdv;
    public boolean cdx;
    public boolean cdy;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bYY = jSONObject.optString("videoId", cVar.bYY);
            cVar2.bZg = jSONObject.optBoolean("autoplay", cVar.bZg);
            cVar2.cdi = jSONObject.optBoolean("muted", cVar.cdi);
            cVar2.cdU = jSONObject.optString("initialTime", cVar.cdU);
            cVar2.cdj = jSONObject.optString("poster", cVar.cdj);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bsQ = jSONObject.optBoolean("fullScreen", cVar.bsQ);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cdr = jSONObject.optBoolean("controls", cVar.cdr);
            cVar2.mSrc = kE(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdA = !com.baidu.swan.apps.storage.b.ne(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdt = jSONObject.optBoolean("showPlayBtn", cVar.cdt);
            cVar2.cdu = jSONObject.optBoolean("showMuteBtn", cVar.cdu);
            cVar2.cdv = jSONObject.optBoolean("showCenterPlayBtn", cVar.cdv);
            cVar2.cdx = jSONObject.optBoolean("showProgress", cVar.cdx);
            cVar2.cdy = jSONObject.optBoolean("showFullscreenBtn", cVar.cdy);
            cVar2.cds = jSONObject.optString("sanId", cVar.cds);
            cVar2.cdV = cVar2.cdV.aA(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.cdW = jSONObject.optBoolean("showNoWifiTip", cVar.cdW);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bYY = "";
        this.cdi = false;
        this.cdj = "";
        this.cdU = "0";
        this.bZg = false;
        this.mLoop = false;
        this.mPos = 0;
        this.cdr = true;
        this.mSrc = "";
        this.cds = "";
        this.cdt = true;
        this.cdu = true;
        this.cdv = true;
        this.cdx = true;
        this.mDirection = -1;
        this.cdy = true;
        this.cdA = true;
        this.cdV = new b();
        this.cdW = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYY);
    }

    private static String kE(String str) {
        if (!com.baidu.swan.apps.storage.b.ne(str) || e.akM() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.akM());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bYY + "', mMute=" + this.cdi + ", mPoster='" + this.cdj + "', mInitialTime=" + this.cdU + ", mAutoPlay=" + this.bZg + ", mShowNoWifiTip=" + this.cdW + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.bsQ + ", mShowControlPanel=" + this.cdr + ", mSrc='" + this.mSrc + "', mSanId='" + this.cds + "', mShowPlayBtn=" + this.cdt + ", mShowMuteBtn=" + this.cdu + ", mShowCenterPlayBtn=" + this.cdv + ", mShowProgress=" + this.cdx + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cdy + ", mIsRemoteFile=" + this.cdA + ", mVrVideoMode=" + this.cdV.toString() + '}';
    }
}
