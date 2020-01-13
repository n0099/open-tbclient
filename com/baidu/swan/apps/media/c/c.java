package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bAa;
    public String bAb;
    public int bAc;
    public String bAd;
    public boolean bAe;
    public String bAf;
    public String bAg;
    public boolean bAh;
    public boolean bAi;
    public boolean bAj;
    public String bAk;
    private boolean bAl;
    private boolean bAm;
    private boolean bAn;
    public boolean bAo;
    public boolean bAp;
    public boolean bAq;
    public boolean bAr;
    public boolean bAs;
    public String bwp;
    public boolean bwx;
    public boolean bwy;
    public int duration;
    public int mDirection;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bwp = jSONObject.optString("videoId", cVar.bwp);
            cVar2.bwx = jSONObject.optBoolean("autoplay", cVar.bwx);
            cVar2.bAa = jSONObject.optBoolean("muted", cVar.bAa);
            cVar2.bAd = jSONObject.optString("objectFit", cVar.bAd);
            cVar2.bAc = jSONObject.optInt("initialTime", cVar.bAc);
            cVar2.bAb = jSONObject.optString("poster", cVar.bAb);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bAe = jSONObject.optBoolean("fullScreen", cVar.bAe);
            cVar2.bAf = ao(jSONObject);
            cVar2.bAg = jSONObject.optString("danmuList", cVar.bAg);
            cVar2.bAh = jSONObject.optBoolean("enableDanmu", cVar.bAh);
            cVar2.bAi = jSONObject.optBoolean("danmuBtn", cVar.bAi);
            cVar2.bwy = jSONObject.optBoolean("loop", cVar.bwy);
            cVar2.bAj = jSONObject.optBoolean("controls", cVar.bAj);
            cVar2.mSrc = jd(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bAs = !com.baidu.swan.apps.storage.b.lD(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.bAl = jSONObject.optBoolean("showPlayBtn", cVar.bAl);
            cVar2.bAm = jSONObject.optBoolean("showMuteBtn", cVar.bAm);
            cVar2.bAn = jSONObject.optBoolean("showCenterPlayBtn", cVar.bAn);
            cVar2.bAo = jSONObject.optBoolean("pageGesture", cVar.bAo);
            cVar2.bAp = jSONObject.optBoolean("showProgress", cVar.bAp);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.bAq = jSONObject.optBoolean("showFullscreenBtn", cVar.bAq);
            cVar2.bAr = jSONObject.optBoolean("enableProgressGesture", cVar.bAr);
            cVar2.bAk = jSONObject.optString("sanId", cVar.bAk);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bwp = "";
        this.bAa = false;
        this.bAb = "";
        this.bAc = 0;
        this.duration = 0;
        this.bwx = false;
        this.bwy = false;
        this.bAd = "";
        this.mPos = 0;
        this.bAf = "";
        this.bAg = "";
        this.bAh = false;
        this.bAi = false;
        this.bAj = true;
        this.mSrc = "";
        this.bAk = "";
        this.bAo = false;
        this.bAp = true;
        this.mDirection = -1;
        this.bAq = true;
        this.bAr = true;
        this.bAs = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bwp);
    }

    public boolean isAutoPlay() {
        return this.bwx;
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

    private static String jd(String str) {
        if (!com.baidu.swan.apps.storage.b.lD(str) || e.aap() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aap());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bwp + "', mMute=" + this.bAa + ", mPoster='" + this.bAb + "', mInitialTime=" + this.bAc + ", duration=" + this.duration + ", mAutoPlay=" + this.bwx + ", mLoop=" + this.bwy + ", mObjectFit='" + this.bAd + "', mPos=" + this.mPos + ", mFullScreen=" + this.bAe + ", mDanmu='" + this.bAf + "', mDanmuList='" + this.bAg + "', mEnableDanmu=" + this.bAh + ", mShowDanmuBtn=" + this.bAi + ", mShowControlPanel=" + this.bAj + ", mSrc='" + this.mSrc + "', mSanId='" + this.bAk + "', mShowPlayBtn=" + this.bAl + ", mShowMuteBtn=" + this.bAm + ", mShowCenterPlayBtn=" + this.bAn + ", mPageGesture=" + this.bAo + ", mShowProgress=" + this.bAp + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.bAq + ", mEnableProgressGesture=" + this.bAr + ", mIsRemoteFile=" + this.bAs + '}';
    }
}
