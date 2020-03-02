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
    public boolean bAH;
    public String bAz;
    public boolean bEh;
    public String bEi;
    public int bEj;
    public String bEk;
    public boolean bEl;
    public String bEm;
    public String bEn;
    public boolean bEo;
    public boolean bEp;
    public boolean bEq;
    public String bEr;
    private boolean bEs;
    private boolean bEt;
    private boolean bEu;
    public boolean bEv;
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
            cVar2.bAz = jSONObject.optString("videoId", cVar.bAz);
            cVar2.bAH = jSONObject.optBoolean("autoplay", cVar.bAH);
            cVar2.bEh = jSONObject.optBoolean("muted", cVar.bEh);
            cVar2.bEk = jSONObject.optString("objectFit", cVar.bEk);
            cVar2.bEj = jSONObject.optInt("initialTime", cVar.bEj);
            cVar2.bEi = jSONObject.optString("poster", cVar.bEi);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bEl = jSONObject.optBoolean("fullScreen", cVar.bEl);
            cVar2.bEm = ao(jSONObject);
            cVar2.bEn = jSONObject.optString("danmuList", cVar.bEn);
            cVar2.bEo = jSONObject.optBoolean("enableDanmu", cVar.bEo);
            cVar2.bEp = jSONObject.optBoolean("danmuBtn", cVar.bEp);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.bEq = jSONObject.optBoolean("controls", cVar.bEq);
            cVar2.mSrc = js(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEz = !com.baidu.swan.apps.storage.b.lS(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bEs = jSONObject.optBoolean("showPlayBtn", cVar.bEs);
            cVar2.bEt = jSONObject.optBoolean("showMuteBtn", cVar.bEt);
            cVar2.bEu = jSONObject.optBoolean("showCenterPlayBtn", cVar.bEu);
            cVar2.bEv = jSONObject.optBoolean("pageGesture", cVar.bEv);
            cVar2.bEw = jSONObject.optBoolean("showProgress", cVar.bEw);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.bEx = jSONObject.optBoolean("showFullscreenBtn", cVar.bEx);
            cVar2.bEy = jSONObject.optBoolean("enableProgressGesture", cVar.bEy);
            cVar2.bEr = jSONObject.optString("sanId", cVar.bEr);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bAz = "";
        this.bEh = false;
        this.bEi = "";
        this.bEj = 0;
        this.duration = 0;
        this.bAH = false;
        this.mLoop = false;
        this.bEk = "";
        this.mPos = 0;
        this.bEm = "";
        this.bEn = "";
        this.bEo = false;
        this.bEp = false;
        this.bEq = true;
        this.mSrc = "";
        this.bEr = "";
        this.bEv = false;
        this.bEw = true;
        this.mDirection = -1;
        this.bEx = true;
        this.bEy = true;
        this.bEz = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bAz);
    }

    public boolean isAutoPlay() {
        return this.bAH;
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
        return "VideoPlayerParams{mPlayerId='" + this.bAz + "', mMute=" + this.bEh + ", mPoster='" + this.bEi + "', mInitialTime=" + this.bEj + ", duration=" + this.duration + ", mAutoPlay=" + this.bAH + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.bEk + "', mPos=" + this.mPos + ", mFullScreen=" + this.bEl + ", mDanmu='" + this.bEm + "', mDanmuList='" + this.bEn + "', mEnableDanmu=" + this.bEo + ", mShowDanmuBtn=" + this.bEp + ", mShowControlPanel=" + this.bEq + ", mSrc='" + this.mSrc + "', mSanId='" + this.bEr + "', mShowPlayBtn=" + this.bEs + ", mShowMuteBtn=" + this.bEt + ", mShowCenterPlayBtn=" + this.bEu + ", mPageGesture=" + this.bEv + ", mShowProgress=" + this.bEw + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bEx + ", mEnableProgressGesture=" + this.bEy + ", mIsRemoteFile=" + this.bEz + '}';
    }
}
