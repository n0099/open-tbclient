package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAM;
    public b bAN;
    public boolean bAO;
    public boolean bAa;
    public String bAb;
    public boolean bAe;
    public boolean bAj;
    public String bAk;
    private boolean bAl;
    private boolean bAm;
    private boolean bAn;
    public boolean bAp;
    public boolean bAq;
    public boolean bAs;
    public String bwp;
    public boolean bwx;
    public boolean bwy;
    public int mDirection;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bwp = jSONObject.optString("videoId", cVar.bwp);
            cVar2.bwx = jSONObject.optBoolean("autoplay", cVar.bwx);
            cVar2.bAa = jSONObject.optBoolean("muted", cVar.bAa);
            cVar2.bAM = jSONObject.optString("initialTime", cVar.bAM);
            cVar2.bAb = jSONObject.optString("poster", cVar.bAb);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bAe = jSONObject.optBoolean("fullScreen", cVar.bAe);
            cVar2.bwy = jSONObject.optBoolean("loop", cVar.bwy);
            cVar2.bAj = jSONObject.optBoolean("controls", cVar.bAj);
            cVar2.mSrc = jd(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bAs = !com.baidu.swan.apps.storage.b.lD(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bAl = jSONObject.optBoolean("showPlayBtn", cVar.bAl);
            cVar2.bAm = jSONObject.optBoolean("showMuteBtn", cVar.bAm);
            cVar2.bAn = jSONObject.optBoolean("showCenterPlayBtn", cVar.bAn);
            cVar2.bAp = jSONObject.optBoolean("showProgress", cVar.bAp);
            cVar2.bAq = jSONObject.optBoolean("showFullscreenBtn", cVar.bAq);
            cVar2.bAk = jSONObject.optString("sanId", cVar.bAk);
            cVar2.bAN = cVar2.bAN.ap(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.bAO = jSONObject.optBoolean("showNoWifiTip", cVar.bAO);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.bwp = "";
        this.bAa = false;
        this.bAb = "";
        this.bAM = "0";
        this.bwx = false;
        this.bwy = false;
        this.mPos = 0;
        this.bAj = true;
        this.mSrc = "";
        this.bAk = "";
        this.bAl = true;
        this.bAm = true;
        this.bAn = true;
        this.bAp = true;
        this.mDirection = -1;
        this.bAq = true;
        this.bAs = true;
        this.bAN = new b();
        this.bAO = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bwp);
    }

    private static String jd(String str) {
        if (!com.baidu.swan.apps.storage.b.lD(str) || e.aap() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aap());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bwp + "', mMute=" + this.bAa + ", mPoster='" + this.bAb + "', mInitialTime=" + this.bAM + ", mAutoPlay=" + this.bwx + ", mShowNoWifiTip=" + this.bAO + ", mLoop=" + this.bwy + ", mPos=" + this.mPos + ", mFullScreen=" + this.bAe + ", mShowControlPanel=" + this.bAj + ", mSrc='" + this.mSrc + "', mSanId='" + this.bAk + "', mShowPlayBtn=" + this.bAl + ", mShowMuteBtn=" + this.bAm + ", mShowCenterPlayBtn=" + this.bAn + ", mShowProgress=" + this.bAp + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bAq + ", mIsRemoteFile=" + this.bAs + ", mVrVideoMode=" + this.bAN.toString() + '}';
    }
}
