package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cUQ;
    public boolean cUZ;
    public boolean cYP;
    public String cYQ;
    public int cYR;
    public String cYS;
    public String cYT;
    public String cYU;
    public boolean cYV;
    public boolean cYW;
    public boolean cYX;
    public String cYY;
    private boolean cYZ;
    private boolean cZa;
    private boolean cZb;
    public boolean cZc;
    public boolean cZd;
    public boolean cZe;
    public boolean cZf;
    public boolean cZg;
    public boolean cco;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cUQ = jSONObject.optString("videoId", cVar.cUQ);
            cVar2.cUZ = jSONObject.optBoolean("autoplay", cVar.cUZ);
            cVar2.cYP = jSONObject.optBoolean("muted", cVar.cYP);
            cVar2.cYS = jSONObject.optString("objectFit", cVar.cYS);
            cVar2.cYR = jSONObject.optInt("initialTime", cVar.cYR);
            cVar2.cYQ = jSONObject.optString("poster", cVar.cYQ);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cco = jSONObject.optBoolean("fullScreen", cVar.cco);
            cVar2.cYT = bg(jSONObject);
            cVar2.cYU = jSONObject.optString("danmuList", cVar.cYU);
            cVar2.cYV = jSONObject.optBoolean("enableDanmu", cVar.cYV);
            cVar2.cYW = jSONObject.optBoolean("danmuBtn", cVar.cYW);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cYX = jSONObject.optBoolean("controls", cVar.cYX);
            cVar2.mSrc = ou(jSONObject.optString("src", cVar.mSrc));
            cVar2.cZg = !com.baidu.swan.apps.storage.b.ta(jSONObject.optString("src", cVar.mSrc));
            cVar2.cYZ = jSONObject.optBoolean("showPlayBtn", cVar.cYZ);
            cVar2.cZa = jSONObject.optBoolean("showMuteBtn", cVar.cZa);
            cVar2.cZb = jSONObject.optBoolean("showCenterPlayBtn", cVar.cZb);
            cVar2.cZc = jSONObject.optBoolean("pageGesture", cVar.cZc);
            cVar2.cZd = jSONObject.optBoolean("showProgress", cVar.cZd);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cZe = jSONObject.optBoolean("showFullscreenBtn", cVar.cZe);
            cVar2.cZf = jSONObject.optBoolean("enableProgressGesture", cVar.cZf);
            cVar2.cYY = jSONObject.optString("sanId", cVar.cYY);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cUQ = "";
        this.cYP = false;
        this.cYQ = "";
        this.cYR = 0;
        this.duration = 0;
        this.cUZ = false;
        this.mLoop = false;
        this.cYS = "";
        this.mPos = 0;
        this.cYT = "";
        this.cYU = "";
        this.cYV = false;
        this.cYW = false;
        this.cYX = true;
        this.mSrc = "";
        this.cYY = "";
        this.cZc = false;
        this.cZd = true;
        this.mDirection = -1;
        this.cZe = true;
        this.cZf = true;
        this.cZg = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cUQ);
    }

    public boolean isAutoPlay() {
        return this.cUZ;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bg(JSONObject jSONObject) {
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

    private static String ou(String str) {
        if (!com.baidu.swan.apps.storage.b.ta(str) || e.aEU() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aEU());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cUQ + "', mMute=" + this.cYP + ", mPoster='" + this.cYQ + "', mInitialTime=" + this.cYR + ", duration=" + this.duration + ", mAutoPlay=" + this.cUZ + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cYS + "', mPos=" + this.mPos + ", mFullScreen=" + this.cco + ", mDanmu='" + this.cYT + "', mDanmuList='" + this.cYU + "', mEnableDanmu=" + this.cYV + ", mShowDanmuBtn=" + this.cYW + ", mShowControlPanel=" + this.cYX + ", mSrc='" + this.mSrc + "', mSanId='" + this.cYY + "', mShowPlayBtn=" + this.cYZ + ", mShowMuteBtn=" + this.cZa + ", mShowCenterPlayBtn=" + this.cZb + ", mPageGesture=" + this.cZc + ", mShowProgress=" + this.cZd + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cZe + ", mEnableProgressGesture=" + this.cZf + ", mIsRemoteFile=" + this.cZg + '}';
    }
}
