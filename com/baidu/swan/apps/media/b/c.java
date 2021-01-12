package com.baidu.swan.apps.media.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cpl;
    public String dge;
    public boolean dgn;
    public boolean dkA;
    public boolean dkB;
    public boolean dkC;
    public boolean dkD;
    public boolean dkE;
    public String dko;
    public int dkp;
    public String dkq;
    public String dkr;
    public String dks;
    public boolean dkt;
    public boolean dku;
    public boolean dkv;
    public String dkw;
    private boolean dkx;
    private boolean dky;
    private boolean dkz;
    public int duration;
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
            cVar2.dkq = jSONObject.optString("objectFit", cVar.dkq);
            cVar2.dkp = jSONObject.optInt("initialTime", cVar.dkp);
            cVar2.dko = jSONObject.optString("poster", cVar.dko);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cpl = jSONObject.optBoolean("fullScreen", cVar.cpl);
            cVar2.dkr = bq(jSONObject);
            cVar2.dks = jSONObject.optString("danmuList", cVar.dks);
            cVar2.dkt = jSONObject.optBoolean("enableDanmu", cVar.dkt);
            cVar2.dku = jSONObject.optBoolean("danmuBtn", cVar.dku);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dkv = jSONObject.optBoolean("controls", cVar.dkv);
            cVar2.mSrc = nP(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dkE = !com.baidu.swan.apps.storage.b.sC(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dkx = jSONObject.optBoolean("showPlayBtn", cVar.dkx);
            cVar2.dky = jSONObject.optBoolean("showMuteBtn", cVar.dky);
            cVar2.dkz = jSONObject.optBoolean("showCenterPlayBtn", cVar.dkz);
            cVar2.dkA = jSONObject.optBoolean("pageGesture", cVar.dkA);
            cVar2.dkB = jSONObject.optBoolean("showProgress", cVar.dkB);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.dkC = jSONObject.optBoolean("showFullscreenBtn", cVar.dkC);
            cVar2.dkD = jSONObject.optBoolean("enableProgressGesture", cVar.dkD);
            cVar2.dkw = jSONObject.optString("sanId", cVar.dkw);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.dge = "";
        this.mMute = false;
        this.dko = "";
        this.dkp = 0;
        this.duration = 0;
        this.dgn = false;
        this.mLoop = false;
        this.dkq = "";
        this.mPos = 0;
        this.dkr = "";
        this.dks = "";
        this.dkt = false;
        this.dku = false;
        this.dkv = true;
        this.mSrc = "";
        this.dkw = "";
        this.dkA = false;
        this.dkB = true;
        this.mDirection = -1;
        this.dkC = true;
        this.dkD = true;
        this.dkE = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.dge);
    }

    public boolean isAutoPlay() {
        return this.dgn;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bq(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("text", jSONObject.optString("text"));
            jSONObject2.putOpt("color", jSONObject.optString("color"));
            jSONObject2.putOpt("videoId", jSONObject.optString("videoId"));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject2.toString();
    }

    private static String nP(String str) {
        if (!com.baidu.swan.apps.storage.b.sC(str) || e.aIr() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aIr());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.dge + "', mMute=" + this.mMute + ", mPoster='" + this.dko + "', mInitialTime=" + this.dkp + ", duration=" + this.duration + ", mAutoPlay=" + this.dgn + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.dkq + "', mPos=" + this.mPos + ", mFullScreen=" + this.cpl + ", mDanmu='" + this.dkr + "', mDanmuList='" + this.dks + "', mEnableDanmu=" + this.dkt + ", mShowDanmuBtn=" + this.dku + ", mShowControlPanel=" + this.dkv + ", mSrc='" + this.mSrc + "', mSanId='" + this.dkw + "', mShowPlayBtn=" + this.dkx + ", mShowMuteBtn=" + this.dky + ", mShowCenterPlayBtn=" + this.dkz + ", mPageGesture=" + this.dkA + ", mShowProgress=" + this.dkB + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dkC + ", mEnableProgressGesture=" + this.dkD + ", mIsRemoteFile=" + this.dkE + '}';
    }
}
