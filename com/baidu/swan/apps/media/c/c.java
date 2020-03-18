package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bAL;
    public boolean bAT;
    public boolean bEA;
    public boolean bEB;
    public boolean bEC;
    public String bED;
    private boolean bEE;
    private boolean bEF;
    private boolean bEG;
    public boolean bEH;
    public boolean bEI;
    public boolean bEJ;
    public boolean bEK;
    public boolean bEL;
    public boolean bEt;
    public String bEu;
    public int bEv;
    public String bEw;
    public boolean bEx;
    public String bEy;
    public String bEz;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bAL = jSONObject.optString("videoId", cVar.bAL);
            cVar2.bAT = jSONObject.optBoolean("autoplay", cVar.bAT);
            cVar2.bEt = jSONObject.optBoolean("muted", cVar.bEt);
            cVar2.bEw = jSONObject.optString("objectFit", cVar.bEw);
            cVar2.bEv = jSONObject.optInt("initialTime", cVar.bEv);
            cVar2.bEu = jSONObject.optString("poster", cVar.bEu);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEx = jSONObject.optBoolean("fullScreen", cVar.bEx);
            cVar2.bEy = ao(jSONObject);
            cVar2.bEz = jSONObject.optString("danmuList", cVar.bEz);
            cVar2.bEA = jSONObject.optBoolean("enableDanmu", cVar.bEA);
            cVar2.bEB = jSONObject.optBoolean("danmuBtn", cVar.bEB);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEC = jSONObject.optBoolean("controls", cVar.bEC);
            cVar2.mSrc = jr(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEL = !com.baidu.swan.apps.storage.b.lR(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEE = jSONObject.optBoolean("showPlayBtn", cVar.bEE);
            cVar2.bEF = jSONObject.optBoolean("showMuteBtn", cVar.bEF);
            cVar2.bEG = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEG);
            cVar2.bEH = jSONObject.optBoolean("pageGesture", cVar.bEH);
            cVar2.bEI = jSONObject.optBoolean("showProgress", cVar.bEI);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.bEJ = jSONObject.optBoolean("showFullscreenBtn", cVar.bEJ);
            cVar2.bEK = jSONObject.optBoolean("enableProgressGesture", cVar.bEK);
            cVar2.bED = jSONObject.optString("sanId", cVar.bED);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bAL = "";
        this.bEt = false;
        this.bEu = "";
        this.bEv = 0;
        this.duration = 0;
        this.bAT = false;
        this.mLoop = false;
        this.bEw = "";
        this.mPos = 0;
        this.bEy = "";
        this.bEz = "";
        this.bEA = false;
        this.bEB = false;
        this.bEC = true;
        this.mSrc = "";
        this.bED = "";
        this.bEH = false;
        this.bEI = true;
        this.mDirection = -1;
        this.bEJ = true;
        this.bEK = true;
        this.bEL = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAL);
    }

    public boolean isAutoPlay() {
        return this.bAT;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String ao(JSONObject jSONObject) {
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

    private static String jr(String str) {
        if (!com.baidu.swan.apps.storage.b.lR(str) || e.acI() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.acI());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bAL + "', mMute=" + this.bEt + ", mPoster='" + this.bEu + "', mInitialTime=" + this.bEv + ", duration=" + this.duration + ", mAutoPlay=" + this.bAT + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.bEw + "', mPos=" + this.mPos + ", mFullScreen=" + this.bEx + ", mDanmu='" + this.bEy + "', mDanmuList='" + this.bEz + "', mEnableDanmu=" + this.bEA + ", mShowDanmuBtn=" + this.bEB + ", mShowControlPanel=" + this.bEC + ", mSrc='" + this.mSrc + "', mSanId='" + this.bED + "', mShowPlayBtn=" + this.bEE + ", mShowMuteBtn=" + this.bEF + ", mShowCenterPlayBtn=" + this.bEG + ", mPageGesture=" + this.bEH + ", mShowProgress=" + this.bEI + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEJ + ", mEnableProgressGesture=" + this.bEK + ", mIsRemoteFile=" + this.bEL + '}';
    }
}
