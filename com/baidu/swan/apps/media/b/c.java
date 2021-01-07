package com.baidu.swan.apps.media.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean cuc;
    public String dkT;
    public boolean dlc;
    public String dpd;
    public int dpe;
    public String dpf;
    public String dpg;
    public String dph;
    public boolean dpi;
    public boolean dpj;
    public boolean dpk;
    public String dpm;
    private boolean dpn;
    private boolean dpo;
    private boolean dpp;
    public boolean dpq;
    public boolean dpr;
    public boolean dps;
    public boolean dpt;
    public boolean dpu;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public boolean mMute;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.dkT = jSONObject.optString("videoId", cVar.dkT);
            cVar2.dlc = jSONObject.optBoolean("autoplay", cVar.dlc);
            cVar2.mMute = jSONObject.optBoolean("muted", cVar.mMute);
            cVar2.dpf = jSONObject.optString("objectFit", cVar.dpf);
            cVar2.dpe = jSONObject.optInt("initialTime", cVar.dpe);
            cVar2.dpd = jSONObject.optString("poster", cVar.dpd);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cuc = jSONObject.optBoolean("fullScreen", cVar.cuc);
            cVar2.dpg = bq(jSONObject);
            cVar2.dph = jSONObject.optString("danmuList", cVar.dph);
            cVar2.dpi = jSONObject.optBoolean("enableDanmu", cVar.dpi);
            cVar2.dpj = jSONObject.optBoolean("danmuBtn", cVar.dpj);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.dpk = jSONObject.optBoolean("controls", cVar.dpk);
            cVar2.mSrc = pc(jSONObject.optString("src", cVar.mSrc));
            cVar2.dpu = !com.baidu.swan.apps.storage.b.tN(jSONObject.optString("src", cVar.mSrc));
            cVar2.dpn = jSONObject.optBoolean("showPlayBtn", cVar.dpn);
            cVar2.dpo = jSONObject.optBoolean("showMuteBtn", cVar.dpo);
            cVar2.dpp = jSONObject.optBoolean("showCenterPlayBtn", cVar.dpp);
            cVar2.dpq = jSONObject.optBoolean("pageGesture", cVar.dpq);
            cVar2.dpr = jSONObject.optBoolean("showProgress", cVar.dpr);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.dps = jSONObject.optBoolean("showFullscreenBtn", cVar.dps);
            cVar2.dpt = jSONObject.optBoolean("enableProgressGesture", cVar.dpt);
            cVar2.dpm = jSONObject.optString("sanId", cVar.dpm);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.dkT = "";
        this.mMute = false;
        this.dpd = "";
        this.dpe = 0;
        this.duration = 0;
        this.dlc = false;
        this.mLoop = false;
        this.dpf = "";
        this.mPos = 0;
        this.dpg = "";
        this.dph = "";
        this.dpi = false;
        this.dpj = false;
        this.dpk = true;
        this.mSrc = "";
        this.dpm = "";
        this.dpq = false;
        this.dpr = true;
        this.mDirection = -1;
        this.dps = true;
        this.dpt = true;
        this.dpu = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.dkT);
    }

    public boolean isAutoPlay() {
        return this.dlc;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bq(JSONObject jSONObject) {
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

    private static String pc(String str) {
        if (!com.baidu.swan.apps.storage.b.tN(str) || e.aMl() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aMl());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.dkT + "', mMute=" + this.mMute + ", mPoster='" + this.dpd + "', mInitialTime=" + this.dpe + ", duration=" + this.duration + ", mAutoPlay=" + this.dlc + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.dpf + "', mPos=" + this.mPos + ", mFullScreen=" + this.cuc + ", mDanmu='" + this.dpg + "', mDanmuList='" + this.dph + "', mEnableDanmu=" + this.dpi + ", mShowDanmuBtn=" + this.dpj + ", mShowControlPanel=" + this.dpk + ", mSrc='" + this.mSrc + "', mSanId='" + this.dpm + "', mShowPlayBtn=" + this.dpn + ", mShowMuteBtn=" + this.dpo + ", mShowCenterPlayBtn=" + this.dpp + ", mPageGesture=" + this.dpq + ", mShowProgress=" + this.dpr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dps + ", mEnableProgressGesture=" + this.dpt + ", mIsRemoteFile=" + this.dpu + '}';
    }
}
