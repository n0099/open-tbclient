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
    public boolean bFh;
    public String cop;
    public boolean coy;
    public String csA;
    public String csB;
    public String csC;
    public boolean csD;
    public boolean csE;
    public boolean csF;
    public String csG;
    private boolean csH;
    private boolean csI;
    private boolean csJ;
    public boolean csK;
    public boolean csL;
    public boolean csM;
    public boolean csN;
    public boolean csO;
    public boolean csx;
    public String csy;
    public int csz;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cop = jSONObject.optString("videoId", cVar.cop);
            cVar2.coy = jSONObject.optBoolean("autoplay", cVar.coy);
            cVar2.csx = jSONObject.optBoolean("muted", cVar.csx);
            cVar2.csA = jSONObject.optString("objectFit", cVar.csA);
            cVar2.csz = jSONObject.optInt("initialTime", cVar.csz);
            cVar2.csy = jSONObject.optString("poster", cVar.csy);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bFh = jSONObject.optBoolean("fullScreen", cVar.bFh);
            cVar2.csB = aK(jSONObject);
            cVar2.csC = jSONObject.optString("danmuList", cVar.csC);
            cVar2.csD = jSONObject.optBoolean("enableDanmu", cVar.csD);
            cVar2.csE = jSONObject.optBoolean("danmuBtn", cVar.csE);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.csF = jSONObject.optBoolean("controls", cVar.csF);
            cVar2.mSrc = ma(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.csO = !com.baidu.swan.apps.storage.b.oP(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.csH = jSONObject.optBoolean("showPlayBtn", cVar.csH);
            cVar2.csI = jSONObject.optBoolean("showMuteBtn", cVar.csI);
            cVar2.csJ = jSONObject.optBoolean("showCenterPlayBtn", cVar.csJ);
            cVar2.csK = jSONObject.optBoolean("pageGesture", cVar.csK);
            cVar2.csL = jSONObject.optBoolean("showProgress", cVar.csL);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.csM = jSONObject.optBoolean("showFullscreenBtn", cVar.csM);
            cVar2.csN = jSONObject.optBoolean("enableProgressGesture", cVar.csN);
            cVar2.csG = jSONObject.optString("sanId", cVar.csG);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cop = "";
        this.csx = false;
        this.csy = "";
        this.csz = 0;
        this.duration = 0;
        this.coy = false;
        this.mLoop = false;
        this.csA = "";
        this.mPos = 0;
        this.csB = "";
        this.csC = "";
        this.csD = false;
        this.csE = false;
        this.csF = true;
        this.mSrc = "";
        this.csG = "";
        this.csK = false;
        this.csL = true;
        this.mDirection = -1;
        this.csM = true;
        this.csN = true;
        this.csO = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cop);
    }

    public boolean isAutoPlay() {
        return this.coy;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String aK(JSONObject jSONObject) {
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

    private static String ma(String str) {
        if (!com.baidu.swan.apps.storage.b.oP(str) || e.apM() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.apM());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cop + "', mMute=" + this.csx + ", mPoster='" + this.csy + "', mInitialTime=" + this.csz + ", duration=" + this.duration + ", mAutoPlay=" + this.coy + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.csA + "', mPos=" + this.mPos + ", mFullScreen=" + this.bFh + ", mDanmu='" + this.csB + "', mDanmuList='" + this.csC + "', mEnableDanmu=" + this.csD + ", mShowDanmuBtn=" + this.csE + ", mShowControlPanel=" + this.csF + ", mSrc='" + this.mSrc + "', mSanId='" + this.csG + "', mShowPlayBtn=" + this.csH + ", mShowMuteBtn=" + this.csI + ", mShowCenterPlayBtn=" + this.csJ + ", mPageGesture=" + this.csK + ", mShowProgress=" + this.csL + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.csM + ", mEnableProgressGesture=" + this.csN + ", mIsRemoteFile=" + this.csO + '}';
    }
}
