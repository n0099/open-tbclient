package com.baidu.swan.apps.media.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String djT;
    public boolean dkc;
    public String dnZ;
    public String doP;
    public b doQ;
    public boolean doR;
    public boolean dod;
    public boolean doi;
    public String doj;
    private boolean dok;
    private boolean dol;
    private boolean dom;
    public boolean doo;
    public boolean dop;
    public boolean dor;
    public int mDirection;
    public boolean mLoop;
    public boolean mMute;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.djT = jSONObject.optString("videoId", cVar.djT);
            cVar2.dkc = jSONObject.optBoolean("autoplay", cVar.dkc);
            cVar2.mMute = jSONObject.optBoolean("muted", cVar.mMute);
            cVar2.doP = jSONObject.optString("initialTime", cVar.doP);
            cVar2.dnZ = jSONObject.optString("poster", cVar.dnZ);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.dod = jSONObject.optBoolean("fullScreen", cVar.dod);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.doi = jSONObject.optBoolean("controls", cVar.doi);
            cVar2.mSrc = oq(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dor = !com.baidu.swan.apps.storage.b.tc(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dok = jSONObject.optBoolean("showPlayBtn", cVar.dok);
            cVar2.dol = jSONObject.optBoolean("showMuteBtn", cVar.dol);
            cVar2.dom = jSONObject.optBoolean("showCenterPlayBtn", cVar.dom);
            cVar2.doo = jSONObject.optBoolean("showProgress", cVar.doo);
            cVar2.dop = jSONObject.optBoolean("showFullscreenBtn", cVar.dop);
            cVar2.doj = jSONObject.optString("sanId", cVar.doj);
            cVar2.doQ = cVar2.doQ.bq(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.doR = jSONObject.optBoolean("showNoWifiTip", cVar.doR);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.djT = "";
        this.mMute = false;
        this.dnZ = "";
        this.doP = "0";
        this.dkc = false;
        this.mLoop = false;
        this.mPos = 0;
        this.doi = true;
        this.mSrc = "";
        this.doj = "";
        this.dok = true;
        this.dol = true;
        this.dom = true;
        this.doo = true;
        this.mDirection = -1;
        this.dop = true;
        this.dor = true;
        this.doQ = new b();
        this.doR = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.djT);
    }

    private static String oq(String str) {
        if (!com.baidu.swan.apps.storage.b.tc(str) || e.aIN() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aIN());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.djT + "', mMute=" + this.mMute + ", mPoster='" + this.dnZ + "', mInitialTime=" + this.doP + ", mAutoPlay=" + this.dkc + ", mShowNoWifiTip=" + this.doR + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.dod + ", mShowControlPanel=" + this.doi + ", mSrc='" + this.mSrc + "', mSanId='" + this.doj + "', mShowPlayBtn=" + this.dok + ", mShowMuteBtn=" + this.dol + ", mShowCenterPlayBtn=" + this.dom + ", mShowProgress=" + this.doo + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dop + ", mIsRemoteFile=" + this.dor + ", mVrVideoMode=" + this.doQ.toString() + '}';
    }
}
