package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cuc;
    public String dkT;
    public boolean dlc;
    public String dpR;
    public b dpS;
    public boolean dpT;
    public String dpd;
    public boolean dpk;
    public String dpm;
    private boolean dpn;
    private boolean dpo;
    private boolean dpp;
    public boolean dpr;
    public boolean dps;
    public boolean dpu;
    public int mDirection;
    public boolean mLoop;
    public boolean mMute;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.dkT = jSONObject.optString("videoId", cVar.dkT);
            cVar2.dlc = jSONObject.optBoolean("autoplay", cVar.dlc);
            cVar2.mMute = jSONObject.optBoolean("muted", cVar.mMute);
            cVar2.dpR = jSONObject.optString("initialTime", cVar.dpR);
            cVar2.dpd = jSONObject.optString("poster", cVar.dpd);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cuc = jSONObject.optBoolean("fullScreen", cVar.cuc);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dpk = jSONObject.optBoolean("controls", cVar.dpk);
            cVar2.mSrc = pc(jSONObject.optString("src", cVar.mSrc));
            cVar2.dpu = !com.baidu.swan.apps.storage.b.tN(jSONObject.optString("src", cVar.mSrc));
            cVar2.dpn = jSONObject.optBoolean("showPlayBtn", cVar.dpn);
            cVar2.dpo = jSONObject.optBoolean("showMuteBtn", cVar.dpo);
            cVar2.dpp = jSONObject.optBoolean("showCenterPlayBtn", cVar.dpp);
            cVar2.dpr = jSONObject.optBoolean("showProgress", cVar.dpr);
            cVar2.dps = jSONObject.optBoolean("showFullscreenBtn", cVar.dps);
            cVar2.dpm = jSONObject.optString("sanId", cVar.dpm);
            cVar2.dpS = cVar2.dpS.br(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.dpT = jSONObject.optBoolean("showNoWifiTip", cVar.dpT);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.dkT = "";
        this.mMute = false;
        this.dpd = "";
        this.dpR = "0";
        this.dlc = false;
        this.mLoop = false;
        this.mPos = 0;
        this.dpk = true;
        this.mSrc = "";
        this.dpm = "";
        this.dpn = true;
        this.dpo = true;
        this.dpp = true;
        this.dpr = true;
        this.mDirection = -1;
        this.dps = true;
        this.dpu = true;
        this.dpS = new b();
        this.dpT = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.dkT);
    }

    private static String pc(String str) {
        if (!com.baidu.swan.apps.storage.b.tN(str) || e.aMk() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aMk());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.dkT + "', mMute=" + this.mMute + ", mPoster='" + this.dpd + "', mInitialTime=" + this.dpR + ", mAutoPlay=" + this.dlc + ", mShowNoWifiTip=" + this.dpT + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.cuc + ", mShowControlPanel=" + this.dpk + ", mSrc='" + this.mSrc + "', mSanId='" + this.dpm + "', mShowPlayBtn=" + this.dpn + ", mShowMuteBtn=" + this.dpo + ", mShowCenterPlayBtn=" + this.dpp + ", mShowProgress=" + this.dpr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dps + ", mIsRemoteFile=" + this.dpu + ", mVrVideoMode=" + this.dpS.toString() + '}';
    }
}
