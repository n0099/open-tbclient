package com.baidu.swan.apps.media.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cZa;
    public boolean cZj;
    public boolean cgp;
    public boolean ddd;
    public String dde;
    public int ddf;
    public String ddg;
    public String ddh;
    public String ddi;
    public boolean ddj;
    public boolean ddk;
    public boolean ddl;
    public String ddm;
    private boolean ddn;
    private boolean ddo;
    private boolean ddp;
    public boolean ddq;
    public boolean ddr;
    public boolean dds;
    public boolean ddt;
    public boolean ddv;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.component.b.b) cVar);
            cVar2.cZa = jSONObject.optString("videoId", cVar.cZa);
            cVar2.cZj = jSONObject.optBoolean("autoplay", cVar.cZj);
            cVar2.ddd = jSONObject.optBoolean("muted", cVar.ddd);
            cVar2.ddg = jSONObject.optString("objectFit", cVar.ddg);
            cVar2.ddf = jSONObject.optInt("initialTime", cVar.ddf);
            cVar2.dde = jSONObject.optString("poster", cVar.dde);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cgp = jSONObject.optBoolean("fullScreen", cVar.cgp);
            cVar2.ddh = bg(jSONObject);
            cVar2.ddi = jSONObject.optString("danmuList", cVar.ddi);
            cVar2.ddj = jSONObject.optBoolean("enableDanmu", cVar.ddj);
            cVar2.ddk = jSONObject.optBoolean("danmuBtn", cVar.ddk);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.ddl = jSONObject.optBoolean("controls", cVar.ddl);
            cVar2.mSrc = oC(jSONObject.optString("src", cVar.mSrc));
            cVar2.ddv = !com.baidu.swan.apps.storage.b.tj(jSONObject.optString("src", cVar.mSrc));
            cVar2.ddn = jSONObject.optBoolean("showPlayBtn", cVar.ddn);
            cVar2.ddo = jSONObject.optBoolean("showMuteBtn", cVar.ddo);
            cVar2.ddp = jSONObject.optBoolean("showCenterPlayBtn", cVar.ddp);
            cVar2.ddq = jSONObject.optBoolean("pageGesture", cVar.ddq);
            cVar2.ddr = jSONObject.optBoolean("showProgress", cVar.ddr);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.dds = jSONObject.optBoolean("showFullscreenBtn", cVar.dds);
            cVar2.ddt = jSONObject.optBoolean("enableProgressGesture", cVar.ddt);
            cVar2.ddm = jSONObject.optString("sanId", cVar.ddm);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.cZa = "";
        this.ddd = false;
        this.dde = "";
        this.ddf = 0;
        this.duration = 0;
        this.cZj = false;
        this.mLoop = false;
        this.ddg = "";
        this.mPos = 0;
        this.ddh = "";
        this.ddi = "";
        this.ddj = false;
        this.ddk = false;
        this.ddl = true;
        this.mSrc = "";
        this.ddm = "";
        this.ddq = false;
        this.ddr = true;
        this.mDirection = -1;
        this.dds = true;
        this.ddt = true;
        this.ddv = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cZa);
    }

    public boolean isAutoPlay() {
        return this.cZj;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bg(JSONObject jSONObject) {
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

    private static String oC(String str) {
        if (!com.baidu.swan.apps.storage.b.tj(str) || e.aGM() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aGM());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cZa + "', mMute=" + this.ddd + ", mPoster='" + this.dde + "', mInitialTime=" + this.ddf + ", duration=" + this.duration + ", mAutoPlay=" + this.cZj + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.ddg + "', mPos=" + this.mPos + ", mFullScreen=" + this.cgp + ", mDanmu='" + this.ddh + "', mDanmuList='" + this.ddi + "', mEnableDanmu=" + this.ddj + ", mShowDanmuBtn=" + this.ddk + ", mShowControlPanel=" + this.ddl + ", mSrc='" + this.mSrc + "', mSanId='" + this.ddm + "', mShowPlayBtn=" + this.ddn + ", mShowMuteBtn=" + this.ddo + ", mShowCenterPlayBtn=" + this.ddp + ", mPageGesture=" + this.ddq + ", mShowProgress=" + this.ddr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dds + ", mEnableProgressGesture=" + this.ddt + ", mIsRemoteFile=" + this.ddv + '}';
    }
}
