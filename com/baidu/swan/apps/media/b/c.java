package com.baidu.swan.apps.media.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean diB;
    public String diq;
    public boolean dmA;
    public String dmB;
    public String dmC;
    public boolean dmD;
    public boolean dmE;
    public boolean dmF;
    public String dmG;
    private boolean dmH;
    private boolean dmI;
    private boolean dmJ;
    public boolean dmK;
    public boolean dmL;
    public boolean dmM;
    public boolean dmN;
    public boolean dmO;
    public String dmx;
    public int dmy;
    public String dmz;
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
            cVar2.diq = jSONObject.optString("videoId", cVar.diq);
            cVar2.diB = jSONObject.optBoolean("autoplay", cVar.diB);
            cVar2.mMute = jSONObject.optBoolean("muted", cVar.mMute);
            cVar2.dmz = jSONObject.optString("objectFit", cVar.dmz);
            cVar2.dmy = jSONObject.optInt("initialTime", cVar.dmy);
            cVar2.dmx = jSONObject.optString("poster", cVar.dmx);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.dmA = jSONObject.optBoolean("fullScreen", cVar.dmA);
            cVar2.dmB = bn(jSONObject);
            cVar2.dmC = jSONObject.optString("danmuList", cVar.dmC);
            cVar2.dmD = jSONObject.optBoolean("enableDanmu", cVar.dmD);
            cVar2.dmE = jSONObject.optBoolean("danmuBtn", cVar.dmE);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dmF = jSONObject.optBoolean("controls", cVar.dmF);
            cVar2.mSrc = oi(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dmO = !com.baidu.swan.apps.storage.b.sV(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dmH = jSONObject.optBoolean("showPlayBtn", cVar.dmH);
            cVar2.dmI = jSONObject.optBoolean("showMuteBtn", cVar.dmI);
            cVar2.dmJ = jSONObject.optBoolean("showCenterPlayBtn", cVar.dmJ);
            cVar2.dmK = jSONObject.optBoolean("pageGesture", cVar.dmK);
            cVar2.dmL = jSONObject.optBoolean("showProgress", cVar.dmL);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.dmM = jSONObject.optBoolean("showFullscreenBtn", cVar.dmM);
            cVar2.dmN = jSONObject.optBoolean("enableProgressGesture", cVar.dmN);
            cVar2.dmG = jSONObject.optString("sanId", cVar.dmG);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.diq = "";
        this.mMute = false;
        this.dmx = "";
        this.dmy = 0;
        this.duration = 0;
        this.diB = false;
        this.mLoop = false;
        this.dmz = "";
        this.mPos = 0;
        this.dmB = "";
        this.dmC = "";
        this.dmD = false;
        this.dmE = false;
        this.dmF = true;
        this.mSrc = "";
        this.dmG = "";
        this.dmK = false;
        this.dmL = true;
        this.mDirection = -1;
        this.dmM = true;
        this.dmN = true;
        this.dmO = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.diq);
    }

    public boolean isAutoPlay() {
        return this.diB;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bn(JSONObject jSONObject) {
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

    private static String oi(String str) {
        if (!com.baidu.swan.apps.storage.b.sV(str) || e.aIK() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aIK());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.diq + "', mMute=" + this.mMute + ", mPoster='" + this.dmx + "', mInitialTime=" + this.dmy + ", duration=" + this.duration + ", mAutoPlay=" + this.diB + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.dmz + "', mPos=" + this.mPos + ", mFullScreen=" + this.dmA + ", mDanmu='" + this.dmB + "', mDanmuList='" + this.dmC + "', mEnableDanmu=" + this.dmD + ", mShowDanmuBtn=" + this.dmE + ", mShowControlPanel=" + this.dmF + ", mSrc='" + this.mSrc + "', mSanId='" + this.dmG + "', mShowPlayBtn=" + this.dmH + ", mShowMuteBtn=" + this.dmI + ", mShowCenterPlayBtn=" + this.dmJ + ", mPageGesture=" + this.dmK + ", mShowProgress=" + this.dmL + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dmM + ", mEnableProgressGesture=" + this.dmN + ", mIsRemoteFile=" + this.dmO + '}';
    }
}
