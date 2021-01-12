package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cpl;
    public String dge;
    public boolean dgn;
    public boolean dkB;
    public boolean dkC;
    public boolean dkE;
    public String dko;
    public boolean dkv;
    public String dkw;
    private boolean dkx;
    private boolean dky;
    private boolean dkz;
    public String dlb;
    public b dlc;
    public boolean dld;
    public int mDirection;
    public boolean mLoop;
    public boolean mMute;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.dge = jSONObject.optString("videoId", cVar.dge);
            cVar2.dgn = jSONObject.optBoolean("autoplay", cVar.dgn);
            cVar2.mMute = jSONObject.optBoolean("muted", cVar.mMute);
            cVar2.dlb = jSONObject.optString("initialTime", cVar.dlb);
            cVar2.dko = jSONObject.optString("poster", cVar.dko);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cpl = jSONObject.optBoolean("fullScreen", cVar.cpl);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dkv = jSONObject.optBoolean("controls", cVar.dkv);
            cVar2.mSrc = nP(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dkE = !com.baidu.swan.apps.storage.b.sC(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dkx = jSONObject.optBoolean("showPlayBtn", cVar.dkx);
            cVar2.dky = jSONObject.optBoolean("showMuteBtn", cVar.dky);
            cVar2.dkz = jSONObject.optBoolean("showCenterPlayBtn", cVar.dkz);
            cVar2.dkB = jSONObject.optBoolean("showProgress", cVar.dkB);
            cVar2.dkC = jSONObject.optBoolean("showFullscreenBtn", cVar.dkC);
            cVar2.dkw = jSONObject.optString("sanId", cVar.dkw);
            cVar2.dlc = cVar2.dlc.br(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.dld = jSONObject.optBoolean("showNoWifiTip", cVar.dld);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.dge = "";
        this.mMute = false;
        this.dko = "";
        this.dlb = "0";
        this.dgn = false;
        this.mLoop = false;
        this.mPos = 0;
        this.dkv = true;
        this.mSrc = "";
        this.dkw = "";
        this.dkx = true;
        this.dky = true;
        this.dkz = true;
        this.dkB = true;
        this.mDirection = -1;
        this.dkC = true;
        this.dkE = true;
        this.dlc = new b();
        this.dld = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.dge);
    }

    private static String nP(String str) {
        if (!com.baidu.swan.apps.storage.b.sC(str) || e.aIr() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aIr());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.dge + "', mMute=" + this.mMute + ", mPoster='" + this.dko + "', mInitialTime=" + this.dlb + ", mAutoPlay=" + this.dgn + ", mShowNoWifiTip=" + this.dld + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.cpl + ", mShowControlPanel=" + this.dkv + ", mSrc='" + this.mSrc + "', mSanId='" + this.dkw + "', mShowPlayBtn=" + this.dkx + ", mShowMuteBtn=" + this.dky + ", mShowCenterPlayBtn=" + this.dkz + ", mShowProgress=" + this.dkB + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dkC + ", mIsRemoteFile=" + this.dkE + ", mVrVideoMode=" + this.dlc.toString() + '}';
    }
}
