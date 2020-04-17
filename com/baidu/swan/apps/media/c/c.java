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
    public String bYS;
    public boolean bZa;
    public boolean bsM;
    public boolean cdc;
    public String cdd;
    public int cde;
    public String cdf;
    public String cdg;
    public String cdh;
    public boolean cdi;
    public boolean cdj;
    public boolean cdk;
    public String cdm;
    private boolean cdn;
    private boolean cdo;
    private boolean cdp;
    public boolean cdq;
    public boolean cdr;
    public boolean cds;
    public boolean cdt;
    public boolean cdu;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.bYS = jSONObject.optString("videoId", cVar.bYS);
            cVar2.bZa = jSONObject.optBoolean("autoplay", cVar.bZa);
            cVar2.cdc = jSONObject.optBoolean("muted", cVar.cdc);
            cVar2.cdf = jSONObject.optString("objectFit", cVar.cdf);
            cVar2.cde = jSONObject.optInt("initialTime", cVar.cde);
            cVar2.cdd = jSONObject.optString("poster", cVar.cdd);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.bsM = jSONObject.optBoolean("fullScreen", cVar.bsM);
            cVar2.cdg = az(jSONObject);
            cVar2.cdh = jSONObject.optString("danmuList", cVar.cdh);
            cVar2.cdi = jSONObject.optBoolean("enableDanmu", cVar.cdi);
            cVar2.cdj = jSONObject.optBoolean("danmuBtn", cVar.cdj);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.cdk = jSONObject.optBoolean("controls", cVar.cdk);
            cVar2.mSrc = kE(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdu = !com.baidu.swan.apps.storage.b.ne(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.cdn = jSONObject.optBoolean("showPlayBtn", cVar.cdn);
            cVar2.cdo = jSONObject.optBoolean("showMuteBtn", cVar.cdo);
            cVar2.cdp = jSONObject.optBoolean("showCenterPlayBtn", cVar.cdp);
            cVar2.cdq = jSONObject.optBoolean("pageGesture", cVar.cdq);
            cVar2.cdr = jSONObject.optBoolean("showProgress", cVar.cdr);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.cds = jSONObject.optBoolean("showFullscreenBtn", cVar.cds);
            cVar2.cdt = jSONObject.optBoolean("enableProgressGesture", cVar.cdt);
            cVar2.cdm = jSONObject.optString("sanId", cVar.cdm);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.bYS = "";
        this.cdc = false;
        this.cdd = "";
        this.cde = 0;
        this.duration = 0;
        this.bZa = false;
        this.mLoop = false;
        this.cdf = "";
        this.mPos = 0;
        this.cdg = "";
        this.cdh = "";
        this.cdi = false;
        this.cdj = false;
        this.cdk = true;
        this.mSrc = "";
        this.cdm = "";
        this.cdq = false;
        this.cdr = true;
        this.mDirection = -1;
        this.cds = true;
        this.cdt = true;
        this.cdu = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.bYS);
    }

    public boolean isAutoPlay() {
        return this.bZa;
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
        if (!com.baidu.swan.apps.storage.b.ne(str) || e.akN() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.akN());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.bYS + "', mMute=" + this.cdc + ", mPoster='" + this.cdd + "', mInitialTime=" + this.cde + ", duration=" + this.duration + ", mAutoPlay=" + this.bZa + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.cdf + "', mPos=" + this.mPos + ", mFullScreen=" + this.bsM + ", mDanmu='" + this.cdg + "', mDanmuList='" + this.cdh + "', mEnableDanmu=" + this.cdi + ", mShowDanmuBtn=" + this.cdj + ", mShowControlPanel=" + this.cdk + ", mSrc='" + this.mSrc + "', mSanId='" + this.cdm + "', mShowPlayBtn=" + this.cdn + ", mShowMuteBtn=" + this.cdo + ", mShowCenterPlayBtn=" + this.cdp + ", mPageGesture=" + this.cdq + ", mShowProgress=" + this.cdr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.cds + ", mEnableProgressGesture=" + this.cdt + ", mIsRemoteFile=" + this.cdu + '}';
    }
}
