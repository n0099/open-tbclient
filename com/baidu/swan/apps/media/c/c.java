package com.baidu.swan.apps.media.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cZa;
    public boolean cZj;
    public boolean cgp;
    public String ddT;
    public b ddU;
    public boolean ddV;
    public boolean ddd;
    public String dde;
    public boolean ddl;
    public String ddm;
    private boolean ddn;
    private boolean ddo;
    private boolean ddp;
    public boolean ddr;
    public boolean dds;
    public boolean ddv;
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
            cVar2.ddT = jSONObject.optString("initialTime", cVar.ddT);
            cVar2.dde = jSONObject.optString("poster", cVar.dde);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.cgp = jSONObject.optBoolean("fullScreen", cVar.cgp);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.ddl = jSONObject.optBoolean("controls", cVar.ddl);
            cVar2.mSrc = oC(jSONObject.optString("src", cVar.mSrc));
            cVar2.ddv = !com.baidu.swan.apps.storage.b.tj(jSONObject.optString("src", cVar.mSrc));
            cVar2.ddn = jSONObject.optBoolean("showPlayBtn", cVar.ddn);
            cVar2.ddo = jSONObject.optBoolean("showMuteBtn", cVar.ddo);
            cVar2.ddp = jSONObject.optBoolean("showCenterPlayBtn", cVar.ddp);
            cVar2.ddr = jSONObject.optBoolean("showProgress", cVar.ddr);
            cVar2.dds = jSONObject.optBoolean("showFullscreenBtn", cVar.dds);
            cVar2.ddm = jSONObject.optString("sanId", cVar.ddm);
            cVar2.ddU = cVar2.ddU.bh(jSONObject.optJSONObject("vrVideoMode"));
            cVar2.ddV = jSONObject.optBoolean("showNoWifiTip", cVar.ddV);
        }
        return cVar2;
    }

    public c() {
        super("vrvideo", "viewId");
        this.cZa = "";
        this.ddd = false;
        this.dde = "";
        this.ddT = "0";
        this.cZj = false;
        this.mLoop = false;
        this.mPos = 0;
        this.ddl = true;
        this.mSrc = "";
        this.ddm = "";
        this.ddn = true;
        this.ddo = true;
        this.ddp = true;
        this.ddr = true;
        this.mDirection = -1;
        this.dds = true;
        this.ddv = true;
        this.ddU = new b();
        this.ddV = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.cZa);
    }

    private static String oC(String str) {
        if (!com.baidu.swan.apps.storage.b.tj(str) || e.aGM() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.d(str, e.aGM());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.cZa + "', mMute=" + this.ddd + ", mPoster='" + this.dde + "', mInitialTime=" + this.ddT + ", mAutoPlay=" + this.cZj + ", mShowNoWifiTip=" + this.ddV + ", mLoop=" + this.mLoop + ", mPos=" + this.mPos + ", mFullScreen=" + this.cgp + ", mShowControlPanel=" + this.ddl + ", mSrc='" + this.mSrc + "', mSanId='" + this.ddm + "', mShowPlayBtn=" + this.ddn + ", mShowMuteBtn=" + this.ddo + ", mShowCenterPlayBtn=" + this.ddp + ", mShowProgress=" + this.ddr + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dds + ", mIsRemoteFile=" + this.ddv + ", mVrVideoMode=" + this.ddU.toString() + '}';
    }
}
