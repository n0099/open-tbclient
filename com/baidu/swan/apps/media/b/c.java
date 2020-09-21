package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bNi;
    public String cAp;
    public boolean cAy;
    private boolean cEA;
    private boolean cEB;
    public boolean cEC;
    public boolean cED;
    public boolean cEE;
    public boolean cEF;
    public boolean cEG;
    public boolean cEp;
    public String cEq;
    public int cEr;
    public String cEs;
    public String cEt;
    public String cEu;
    public boolean cEv;
    public boolean cEw;
    public boolean cEx;
    public String cEy;
    private boolean cEz;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cAp = jSONObject.optString("videoId", cVar.cAp);
            cVar2.cAy = jSONObject.optBoolean("autoplay", cVar.cAy);
            cVar2.cEp = jSONObject.optBoolean("muted", cVar.cEp);
            cVar2.cEs = jSONObject.optString("objectFit", cVar.cEs);
            cVar2.cEr = jSONObject.optInt("initialTime", cVar.cEr);
            cVar2.cEq = jSONObject.optString("poster", cVar.cEq);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bNi = jSONObject.optBoolean("fullScreen", cVar.bNi);
            cVar2.cEt = aW(jSONObject);
            cVar2.cEu = jSONObject.optString("danmuList", cVar.cEu);
            cVar2.cEv = jSONObject.optBoolean("enableDanmu", cVar.cEv);
            cVar2.cEw = jSONObject.optBoolean("danmuBtn", cVar.cEw);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cEx = jSONObject.optBoolean("controls", cVar.cEx);
            cVar2.mSrc = nn(jSONObject.optString("src", cVar.mSrc));
            cVar2.cEG = !com.baidu.swan.apps.storage.b.rU(jSONObject.optString("src", cVar.mSrc));
            cVar2.cEz = jSONObject.optBoolean("showPlayBtn", cVar.cEz);
            cVar2.cEA = jSONObject.optBoolean("showMuteBtn", cVar.cEA);
            cVar2.cEB = jSONObject.optBoolean("showCenterPlayBtn", cVar.cEB);
            cVar2.cEC = jSONObject.optBoolean("pageGesture", cVar.cEC);
            cVar2.cED = jSONObject.optBoolean("showProgress", cVar.cED);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cEE = jSONObject.optBoolean("showFullscreenBtn", cVar.cEE);
            cVar2.cEF = jSONObject.optBoolean("enableProgressGesture", cVar.cEF);
            cVar2.cEy = jSONObject.optString("sanId", cVar.cEy);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cAp = "";
        this.cEp = false;
        this.cEq = "";
        this.cEr = 0;
        this.duration = 0;
        this.cAy = false;
        this.mLoop = false;
        this.cEs = "";
        this.mPos = 0;
        this.cEt = "";
        this.cEu = "";
        this.cEv = false;
        this.cEw = false;
        this.cEx = true;
        this.mSrc = "";
        this.cEy = "";
        this.cEC = false;
        this.cED = true;
        this.mDirection = -1;
        this.cEE = true;
        this.cEF = true;
        this.cEG = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cAp);
    }

    public boolean isAutoPlay() {
        return this.cAy;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String aW(JSONObject jSONObject) {
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

    private static String nn(String str) {
        if (!com.baidu.swan.apps.storage.b.rU(str) || e.aAr() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aAr());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cAp + "', mMute=" + this.cEp + ", mPoster='" + this.cEq + "', mInitialTime=" + this.cEr + ", duration=" + this.duration + ", mAutoPlay=" + this.cAy + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cEs + "', mPos=" + this.mPos + ", mFullScreen=" + this.bNi + ", mDanmu='" + this.cEt + "', mDanmuList='" + this.cEu + "', mEnableDanmu=" + this.cEv + ", mShowDanmuBtn=" + this.cEw + ", mShowControlPanel=" + this.cEx + ", mSrc='" + this.mSrc + "', mSanId='" + this.cEy + "', mShowPlayBtn=" + this.cEz + ", mShowMuteBtn=" + this.cEA + ", mShowCenterPlayBtn=" + this.cEB + ", mPageGesture=" + this.cEC + ", mShowProgress=" + this.cED + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cEE + ", mEnableProgressGesture=" + this.cEF + ", mIsRemoteFile=" + this.cEG + '}';
    }
}
