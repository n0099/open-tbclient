package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bvC;
    public boolean bvK;
    public boolean bvL;
    private boolean bzA;
    public boolean bzB;
    public boolean bzC;
    public boolean bzD;
    public boolean bzE;
    public boolean bzF;
    public boolean bzn;
    public String bzo;
    public int bzp;
    public String bzq;
    public boolean bzr;
    public String bzs;
    public String bzt;
    public boolean bzu;
    public boolean bzv;
    public boolean bzw;
    public String bzx;
    private boolean bzy;
    private boolean bzz;
    public int duration;
    public int mDirection;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bvC = jSONObject.optString("videoId", cVar.bvC);
            cVar2.bvK = jSONObject.optBoolean("autoplay", cVar.bvK);
            cVar2.bzn = jSONObject.optBoolean("muted", cVar.bzn);
            cVar2.bzq = jSONObject.optString("objectFit", cVar.bzq);
            cVar2.bzp = jSONObject.optInt("initialTime", cVar.bzp);
            cVar2.bzo = jSONObject.optString("poster", cVar.bzo);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bzr = jSONObject.optBoolean("fullScreen", cVar.bzr);
            cVar2.bzs = ao(jSONObject);
            cVar2.bzt = jSONObject.optString("danmuList", cVar.bzt);
            cVar2.bzu = jSONObject.optBoolean("enableDanmu", cVar.bzu);
            cVar2.bzv = jSONObject.optBoolean("danmuBtn", cVar.bzv);
            cVar2.bvL = jSONObject.optBoolean("loop", cVar.bvL);
            cVar2.bzw = jSONObject.optBoolean("controls", cVar.bzw);
            cVar2.mSrc = ja(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bzF = !com.baidu.swan.apps.storage.b.lA(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bzy = jSONObject.optBoolean("showPlayBtn", cVar.bzy);
            cVar2.bzz = jSONObject.optBoolean("showMuteBtn", cVar.bzz);
            cVar2.bzA = jSONObject.optBoolean("showCenterPlayBtn", cVar.bzA);
            cVar2.bzB = jSONObject.optBoolean("pageGesture", cVar.bzB);
            cVar2.bzC = jSONObject.optBoolean("showProgress", cVar.bzC);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.bzD = jSONObject.optBoolean("showFullscreenBtn", cVar.bzD);
            cVar2.bzE = jSONObject.optBoolean("enableProgressGesture", cVar.bzE);
            cVar2.bzx = jSONObject.optString("sanId", cVar.bzx);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bvC = "";
        this.bzn = false;
        this.bzo = "";
        this.bzp = 0;
        this.duration = 0;
        this.bvK = false;
        this.bvL = false;
        this.bzq = "";
        this.mPos = 0;
        this.bzs = "";
        this.bzt = "";
        this.bzu = false;
        this.bzv = false;
        this.bzw = true;
        this.mSrc = "";
        this.bzx = "";
        this.bzB = false;
        this.bzC = true;
        this.mDirection = -1;
        this.bzD = true;
        this.bzE = true;
        this.bzF = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bvC);
    }

    public boolean isAutoPlay() {
        return this.bvK;
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

    private static String ja(String str) {
        if (!com.baidu.swan.apps.storage.b.lA(str) || e.ZS() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.ZS());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bvC + "', mMute=" + this.bzn + ", mPoster='" + this.bzo + "', mInitialTime=" + this.bzp + ", duration=" + this.duration + ", mAutoPlay=" + this.bvK + ", mLoop=" + this.bvL + ", mObjectFit='" + this.bzq + "', mPos=" + this.mPos + ", mFullScreen=" + this.bzr + ", mDanmu='" + this.bzs + "', mDanmuList='" + this.bzt + "', mEnableDanmu=" + this.bzu + ", mShowDanmuBtn=" + this.bzv + ", mShowControlPanel=" + this.bzw + ", mSrc='" + this.mSrc + "', mSanId='" + this.bzx + "', mShowPlayBtn=" + this.bzy + ", mShowMuteBtn=" + this.bzz + ", mShowCenterPlayBtn=" + this.bzA + ", mPageGesture=" + this.bzB + ", mShowProgress=" + this.bzC + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bzD + ", mEnableProgressGesture=" + this.bzE + ", mIsRemoteFile=" + this.bzF + '}';
    }
}
