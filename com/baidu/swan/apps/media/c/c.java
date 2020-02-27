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
    public boolean bAG;
    public String bAy;
    public boolean bEg;
    public String bEh;
    public int bEi;
    public String bEj;
    public boolean bEk;
    public String bEl;
    public String bEm;
    public boolean bEn;
    public boolean bEo;
    public boolean bEp;
    public String bEq;
    private boolean bEr;
    private boolean bEs;
    private boolean bEt;
    public boolean bEu;
    public boolean bEv;
    public boolean bEw;
    public boolean bEx;
    public boolean bEy;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bAy = jSONObject.optString("videoId", cVar.bAy);
            cVar2.bAG = jSONObject.optBoolean("autoplay", cVar.bAG);
            cVar2.bEg = jSONObject.optBoolean("muted", cVar.bEg);
            cVar2.bEj = jSONObject.optString("objectFit", cVar.bEj);
            cVar2.bEi = jSONObject.optInt("initialTime", cVar.bEi);
            cVar2.bEh = jSONObject.optString("poster", cVar.bEh);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEk = jSONObject.optBoolean("fullScreen", cVar.bEk);
            cVar2.bEl = ao(jSONObject);
            cVar2.bEm = jSONObject.optString("danmuList", cVar.bEm);
            cVar2.bEn = jSONObject.optBoolean("enableDanmu", cVar.bEn);
            cVar2.bEo = jSONObject.optBoolean("danmuBtn", cVar.bEo);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEp = jSONObject.optBoolean("controls", cVar.bEp);
            cVar2.mSrc = js(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEy = !com.baidu.swan.apps.storage.b.lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEr = jSONObject.optBoolean("showPlayBtn", cVar.bEr);
            cVar2.bEs = jSONObject.optBoolean("showMuteBtn", cVar.bEs);
            cVar2.bEt = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEt);
            cVar2.bEu = jSONObject.optBoolean("pageGesture", cVar.bEu);
            cVar2.bEv = jSONObject.optBoolean("showProgress", cVar.bEv);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.bEw = jSONObject.optBoolean("showFullscreenBtn", cVar.bEw);
            cVar2.bEx = jSONObject.optBoolean("enableProgressGesture", cVar.bEx);
            cVar2.bEq = jSONObject.optString("sanId", cVar.bEq);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bAy = "";
        this.bEg = false;
        this.bEh = "";
        this.bEi = 0;
        this.duration = 0;
        this.bAG = false;
        this.mLoop = false;
        this.bEj = "";
        this.mPos = 0;
        this.bEl = "";
        this.bEm = "";
        this.bEn = false;
        this.bEo = false;
        this.bEp = true;
        this.mSrc = "";
        this.bEq = "";
        this.bEu = false;
        this.bEv = true;
        this.mDirection = -1;
        this.bEw = true;
        this.bEx = true;
        this.bEy = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAy);
    }

    public boolean isAutoPlay() {
        return this.bAG;
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

    private static String js(String str) {
        if (!com.baidu.swan.apps.storage.b.lS(str) || e.acD() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.acD());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bAy + "', mMute=" + this.bEg + ", mPoster='" + this.bEh + "', mInitialTime=" + this.bEi + ", duration=" + this.duration + ", mAutoPlay=" + this.bAG + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.bEj + "', mPos=" + this.mPos + ", mFullScreen=" + this.bEk + ", mDanmu='" + this.bEl + "', mDanmuList='" + this.bEm + "', mEnableDanmu=" + this.bEn + ", mShowDanmuBtn=" + this.bEo + ", mShowControlPanel=" + this.bEp + ", mSrc='" + this.mSrc + "', mSanId='" + this.bEq + "', mShowPlayBtn=" + this.bEr + ", mShowMuteBtn=" + this.bEs + ", mShowCenterPlayBtn=" + this.bEt + ", mPageGesture=" + this.bEu + ", mShowProgress=" + this.bEv + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEw + ", mEnableProgressGesture=" + this.bEx + ", mIsRemoteFile=" + this.bEy + '}';
    }
}
