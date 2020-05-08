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
    public String bYY;
    public boolean bZg;
    public boolean bsQ;
    public boolean cdA;
    public boolean cdi;
    public String cdj;
    public int cdk;
    public String cdm;
    public String cdn;
    public String cdo;
    public boolean cdp;
    public boolean cdq;
    public boolean cdr;
    public String cds;
    private boolean cdt;
    private boolean cdu;
    private boolean cdv;
    public boolean cdw;
    public boolean cdx;
    public boolean cdy;
    public boolean cdz;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bYY = jSONObject.optString("videoId", cVar.bYY);
            cVar2.bZg = jSONObject.optBoolean("autoplay", cVar.bZg);
            cVar2.cdi = jSONObject.optBoolean("muted", cVar.cdi);
            cVar2.cdm = jSONObject.optString("objectFit", cVar.cdm);
            cVar2.cdk = jSONObject.optInt("initialTime", cVar.cdk);
            cVar2.cdj = jSONObject.optString("poster", cVar.cdj);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bsQ = jSONObject.optBoolean("fullScreen", cVar.bsQ);
            cVar2.cdn = az(jSONObject);
            cVar2.cdo = jSONObject.optString("danmuList", cVar.cdo);
            cVar2.cdp = jSONObject.optBoolean("enableDanmu", cVar.cdp);
            cVar2.cdq = jSONObject.optBoolean("danmuBtn", cVar.cdq);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cdr = jSONObject.optBoolean("controls", cVar.cdr);
            cVar2.mSrc = kE(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdA = !com.baidu.swan.apps.storage.b.ne(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdt = jSONObject.optBoolean("showPlayBtn", cVar.cdt);
            cVar2.cdu = jSONObject.optBoolean("showMuteBtn", cVar.cdu);
            cVar2.cdv = jSONObject.optBoolean("showCenterPlayBtn", cVar.cdv);
            cVar2.cdw = jSONObject.optBoolean("pageGesture", cVar.cdw);
            cVar2.cdx = jSONObject.optBoolean("showProgress", cVar.cdx);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cdy = jSONObject.optBoolean("showFullscreenBtn", cVar.cdy);
            cVar2.cdz = jSONObject.optBoolean("enableProgressGesture", cVar.cdz);
            cVar2.cds = jSONObject.optString("sanId", cVar.cds);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bYY = "";
        this.cdi = false;
        this.cdj = "";
        this.cdk = 0;
        this.duration = 0;
        this.bZg = false;
        this.mLoop = false;
        this.cdm = "";
        this.mPos = 0;
        this.cdn = "";
        this.cdo = "";
        this.cdp = false;
        this.cdq = false;
        this.cdr = true;
        this.mSrc = "";
        this.cds = "";
        this.cdw = false;
        this.cdx = true;
        this.mDirection = -1;
        this.cdy = true;
        this.cdz = true;
        this.cdA = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYY);
    }

    public boolean isAutoPlay() {
        return this.bZg;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String az(JSONObject jSONObject) {
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

    private static String kE(String str) {
        if (!com.baidu.swan.apps.storage.b.ne(str) || e.akM() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.akM());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bYY + "', mMute=" + this.cdi + ", mPoster='" + this.cdj + "', mInitialTime=" + this.cdk + ", duration=" + this.duration + ", mAutoPlay=" + this.bZg + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cdm + "', mPos=" + this.mPos + ", mFullScreen=" + this.bsQ + ", mDanmu='" + this.cdn + "', mDanmuList='" + this.cdo + "', mEnableDanmu=" + this.cdp + ", mShowDanmuBtn=" + this.cdq + ", mShowControlPanel=" + this.cdr + ", mSrc='" + this.mSrc + "', mSanId='" + this.cds + "', mShowPlayBtn=" + this.cdt + ", mShowMuteBtn=" + this.cdu + ", mShowCenterPlayBtn=" + this.cdv + ", mPageGesture=" + this.cdw + ", mShowProgress=" + this.cdx + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cdy + ", mEnableProgressGesture=" + this.cdz + ", mIsRemoteFile=" + this.cdA + '}';
    }
}
