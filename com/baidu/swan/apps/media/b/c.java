package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bFE;
    public boolean cqD;
    public String cqu;
    public boolean cuB;
    public String cuC;
    public int cuD;
    public String cuE;
    public String cuF;
    public String cuG;
    public boolean cuH;
    public boolean cuI;
    public boolean cuJ;
    public String cuK;
    private boolean cuL;
    private boolean cuM;
    private boolean cuN;
    public boolean cuO;
    public boolean cuP;
    public boolean cuQ;
    public boolean cuR;
    public boolean cuS;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cqu = jSONObject.optString("videoId", cVar.cqu);
            cVar2.cqD = jSONObject.optBoolean("autoplay", cVar.cqD);
            cVar2.cuB = jSONObject.optBoolean("muted", cVar.cuB);
            cVar2.cuE = jSONObject.optString("objectFit", cVar.cuE);
            cVar2.cuD = jSONObject.optInt("initialTime", cVar.cuD);
            cVar2.cuC = jSONObject.optString("poster", cVar.cuC);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bFE = jSONObject.optBoolean("fullScreen", cVar.bFE);
            cVar2.cuF = aN(jSONObject);
            cVar2.cuG = jSONObject.optString("danmuList", cVar.cuG);
            cVar2.cuH = jSONObject.optBoolean("enableDanmu", cVar.cuH);
            cVar2.cuI = jSONObject.optBoolean("danmuBtn", cVar.cuI);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cuJ = jSONObject.optBoolean("controls", cVar.cuJ);
            cVar2.mSrc = lb(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cuS = !com.baidu.swan.apps.storage.b.pA(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cuL = jSONObject.optBoolean("showPlayBtn", cVar.cuL);
            cVar2.cuM = jSONObject.optBoolean("showMuteBtn", cVar.cuM);
            cVar2.cuN = jSONObject.optBoolean("showCenterPlayBtn", cVar.cuN);
            cVar2.cuO = jSONObject.optBoolean("pageGesture", cVar.cuO);
            cVar2.cuP = jSONObject.optBoolean("showProgress", cVar.cuP);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cuQ = jSONObject.optBoolean("showFullscreenBtn", cVar.cuQ);
            cVar2.cuR = jSONObject.optBoolean("enableProgressGesture", cVar.cuR);
            cVar2.cuK = jSONObject.optString("sanId", cVar.cuK);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cqu = "";
        this.cuB = false;
        this.cuC = "";
        this.cuD = 0;
        this.duration = 0;
        this.cqD = false;
        this.mLoop = false;
        this.cuE = "";
        this.mPos = 0;
        this.cuF = "";
        this.cuG = "";
        this.cuH = false;
        this.cuI = false;
        this.cuJ = true;
        this.mSrc = "";
        this.cuK = "";
        this.cuO = false;
        this.cuP = true;
        this.mDirection = -1;
        this.cuQ = true;
        this.cuR = true;
        this.cuS = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cqu);
    }

    public boolean isAutoPlay() {
        return this.cqD;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String aN(JSONObject jSONObject) {
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

    private static String lb(String str) {
        if (!com.baidu.swan.apps.storage.b.pA(str) || e.arv() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.arv());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cqu + "', mMute=" + this.cuB + ", mPoster='" + this.cuC + "', mInitialTime=" + this.cuD + ", duration=" + this.duration + ", mAutoPlay=" + this.cqD + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cuE + "', mPos=" + this.mPos + ", mFullScreen=" + this.bFE + ", mDanmu='" + this.cuF + "', mDanmuList='" + this.cuG + "', mEnableDanmu=" + this.cuH + ", mShowDanmuBtn=" + this.cuI + ", mShowControlPanel=" + this.cuJ + ", mSrc='" + this.mSrc + "', mSanId='" + this.cuK + "', mShowPlayBtn=" + this.cuL + ", mShowMuteBtn=" + this.cuM + ", mShowCenterPlayBtn=" + this.cuN + ", mPageGesture=" + this.cuO + ", mShowProgress=" + this.cuP + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cuQ + ", mEnableProgressGesture=" + this.cuR + ", mIsRemoteFile=" + this.cuS + '}';
    }
}
