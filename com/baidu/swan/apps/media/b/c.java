package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bAt;
    public String cjA;
    public boolean cjJ;
    public boolean cnK;
    public String cnL;
    public int cnM;
    public String cnN;
    public String cnO;
    public String cnP;
    public boolean cnQ;
    public boolean cnR;
    public boolean cnS;
    public String cnT;
    private boolean cnU;
    private boolean cnV;
    private boolean cnW;
    public boolean cnX;
    public boolean cnY;
    public boolean cnZ;
    public boolean coa;
    public boolean cob;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cjA = jSONObject.optString("videoId", cVar.cjA);
            cVar2.cjJ = jSONObject.optBoolean("autoplay", cVar.cjJ);
            cVar2.cnK = jSONObject.optBoolean("muted", cVar.cnK);
            cVar2.cnN = jSONObject.optString("objectFit", cVar.cnN);
            cVar2.cnM = jSONObject.optInt("initialTime", cVar.cnM);
            cVar2.cnL = jSONObject.optString("poster", cVar.cnL);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bAt = jSONObject.optBoolean("fullScreen", cVar.bAt);
            cVar2.cnO = aD(jSONObject);
            cVar2.cnP = jSONObject.optString("danmuList", cVar.cnP);
            cVar2.cnQ = jSONObject.optBoolean("enableDanmu", cVar.cnQ);
            cVar2.cnR = jSONObject.optBoolean("danmuBtn", cVar.cnR);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cnS = jSONObject.optBoolean("controls", cVar.cnS);
            cVar2.mSrc = lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cob = !com.baidu.swan.apps.storage.b.oH(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cnU = jSONObject.optBoolean("showPlayBtn", cVar.cnU);
            cVar2.cnV = jSONObject.optBoolean("showMuteBtn", cVar.cnV);
            cVar2.cnW = jSONObject.optBoolean("showCenterPlayBtn", cVar.cnW);
            cVar2.cnX = jSONObject.optBoolean("pageGesture", cVar.cnX);
            cVar2.cnY = jSONObject.optBoolean("showProgress", cVar.cnY);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cnZ = jSONObject.optBoolean("showFullscreenBtn", cVar.cnZ);
            cVar2.coa = jSONObject.optBoolean("enableProgressGesture", cVar.coa);
            cVar2.cnT = jSONObject.optString("sanId", cVar.cnT);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cjA = "";
        this.cnK = false;
        this.cnL = "";
        this.cnM = 0;
        this.duration = 0;
        this.cjJ = false;
        this.mLoop = false;
        this.cnN = "";
        this.mPos = 0;
        this.cnO = "";
        this.cnP = "";
        this.cnQ = false;
        this.cnR = false;
        this.cnS = true;
        this.mSrc = "";
        this.cnT = "";
        this.cnX = false;
        this.cnY = true;
        this.mDirection = -1;
        this.cnZ = true;
        this.coa = true;
        this.cob = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cjA);
    }

    public boolean isAutoPlay() {
        return this.cjJ;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String aD(JSONObject jSONObject) {
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

    private static String lS(String str) {
        if (!com.baidu.swan.apps.storage.b.oH(str) || e.aoF() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aoF());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cjA + "', mMute=" + this.cnK + ", mPoster='" + this.cnL + "', mInitialTime=" + this.cnM + ", duration=" + this.duration + ", mAutoPlay=" + this.cjJ + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cnN + "', mPos=" + this.mPos + ", mFullScreen=" + this.bAt + ", mDanmu='" + this.cnO + "', mDanmuList='" + this.cnP + "', mEnableDanmu=" + this.cnQ + ", mShowDanmuBtn=" + this.cnR + ", mShowControlPanel=" + this.cnS + ", mSrc='" + this.mSrc + "', mSanId='" + this.cnT + "', mShowPlayBtn=" + this.cnU + ", mShowMuteBtn=" + this.cnV + ", mShowCenterPlayBtn=" + this.cnW + ", mPageGesture=" + this.cnX + ", mShowProgress=" + this.cnY + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cnZ + ", mEnableProgressGesture=" + this.coa + ", mIsRemoteFile=" + this.cob + '}';
    }
}
