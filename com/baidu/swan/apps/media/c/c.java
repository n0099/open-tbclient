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
    public String bAA;
    public boolean bAI;
    public boolean bEA;
    public boolean bEi;
    public String bEj;
    public int bEk;
    public String bEl;
    public boolean bEm;
    public String bEn;
    public String bEo;
    public boolean bEp;
    public boolean bEq;
    public boolean bEr;
    public String bEs;
    private boolean bEt;
    private boolean bEu;
    private boolean bEv;
    public boolean bEw;
    public boolean bEx;
    public boolean bEy;
    public boolean bEz;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bAA = jSONObject.optString("videoId", cVar.bAA);
            cVar2.bAI = jSONObject.optBoolean("autoplay", cVar.bAI);
            cVar2.bEi = jSONObject.optBoolean("muted", cVar.bEi);
            cVar2.bEl = jSONObject.optString("objectFit", cVar.bEl);
            cVar2.bEk = jSONObject.optInt("initialTime", cVar.bEk);
            cVar2.bEj = jSONObject.optString("poster", cVar.bEj);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEm = jSONObject.optBoolean("fullScreen", cVar.bEm);
            cVar2.bEn = ao(jSONObject);
            cVar2.bEo = jSONObject.optString("danmuList", cVar.bEo);
            cVar2.bEp = jSONObject.optBoolean("enableDanmu", cVar.bEp);
            cVar2.bEq = jSONObject.optBoolean("danmuBtn", cVar.bEq);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEr = jSONObject.optBoolean("controls", cVar.bEr);
            cVar2.mSrc = js(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEA = !com.baidu.swan.apps.storage.b.lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEt = jSONObject.optBoolean("showPlayBtn", cVar.bEt);
            cVar2.bEu = jSONObject.optBoolean("showMuteBtn", cVar.bEu);
            cVar2.bEv = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEv);
            cVar2.bEw = jSONObject.optBoolean("pageGesture", cVar.bEw);
            cVar2.bEx = jSONObject.optBoolean("showProgress", cVar.bEx);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.bEy = jSONObject.optBoolean("showFullscreenBtn", cVar.bEy);
            cVar2.bEz = jSONObject.optBoolean("enableProgressGesture", cVar.bEz);
            cVar2.bEs = jSONObject.optString("sanId", cVar.bEs);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bAA = "";
        this.bEi = false;
        this.bEj = "";
        this.bEk = 0;
        this.duration = 0;
        this.bAI = false;
        this.mLoop = false;
        this.bEl = "";
        this.mPos = 0;
        this.bEn = "";
        this.bEo = "";
        this.bEp = false;
        this.bEq = false;
        this.bEr = true;
        this.mSrc = "";
        this.bEs = "";
        this.bEw = false;
        this.bEx = true;
        this.mDirection = -1;
        this.bEy = true;
        this.bEz = true;
        this.bEA = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAA);
    }

    public boolean isAutoPlay() {
        return this.bAI;
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
        if (!com.baidu.swan.apps.storage.b.lS(str) || e.acF() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.acF());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bAA + "', mMute=" + this.bEi + ", mPoster='" + this.bEj + "', mInitialTime=" + this.bEk + ", duration=" + this.duration + ", mAutoPlay=" + this.bAI + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.bEl + "', mPos=" + this.mPos + ", mFullScreen=" + this.bEm + ", mDanmu='" + this.bEn + "', mDanmuList='" + this.bEo + "', mEnableDanmu=" + this.bEp + ", mShowDanmuBtn=" + this.bEq + ", mShowControlPanel=" + this.bEr + ", mSrc='" + this.mSrc + "', mSanId='" + this.bEs + "', mShowPlayBtn=" + this.bEt + ", mShowMuteBtn=" + this.bEu + ", mShowCenterPlayBtn=" + this.bEv + ", mPageGesture=" + this.bEw + ", mShowProgress=" + this.bEx + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEy + ", mEnableProgressGesture=" + this.bEz + ", mIsRemoteFile=" + this.bEA + '}';
    }
}
