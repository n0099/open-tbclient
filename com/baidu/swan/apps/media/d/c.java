package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean aAD;
    public String aAu;
    public String aCA;
    public boolean aCB;
    public String aCC;
    public String aCD;
    public boolean aCE;
    public boolean aCF;
    public boolean aCG;
    public String aCH;
    private boolean aCI;
    private boolean aCJ;
    private boolean aCK;
    public boolean aCL;
    public boolean aCM;
    public boolean aCN;
    public boolean aCO;
    public boolean aCP;
    public boolean aCx;
    public String aCy;
    public int aCz;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.aAu = jSONObject.optString("videoId", cVar.aAu);
            cVar2.aAD = jSONObject.optBoolean("autoplay", cVar.aAD);
            cVar2.aCx = jSONObject.optBoolean("muted", cVar.aCx);
            cVar2.aCA = jSONObject.optString("objectFit", cVar.aCA);
            cVar2.aCz = jSONObject.optInt("initialTime", cVar.aCz);
            cVar2.aCy = jSONObject.optString("poster", cVar.aCy);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.aCB = jSONObject.optBoolean("fullScreen", cVar.aCB);
            cVar2.aCC = H(jSONObject);
            cVar2.aCD = jSONObject.optString("danmuList", cVar.aCD);
            cVar2.aCE = jSONObject.optBoolean("enableDanmu", cVar.aCE);
            cVar2.aCF = jSONObject.optBoolean("danmuBtn", cVar.aCF);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.aCG = jSONObject.optBoolean("controls", cVar.aCG);
            cVar2.mSrc = fo(jSONObject.optString("src", cVar.mSrc));
            cVar2.aCP = !com.baidu.swan.apps.storage.b.ht(jSONObject.optString("src", cVar.mSrc));
            cVar2.aCI = jSONObject.optBoolean("showPlayBtn", cVar.aCI);
            cVar2.aCJ = jSONObject.optBoolean("showMuteBtn", cVar.aCJ);
            cVar2.aCK = jSONObject.optBoolean("showCenterPlayBtn", cVar.aCK);
            cVar2.aCL = jSONObject.optBoolean("pageGesture", cVar.aCL);
            cVar2.aCM = jSONObject.optBoolean("showProgress", cVar.aCM);
            cVar2.mDirection = jSONObject.optInt("direction");
            cVar2.aCN = jSONObject.optBoolean("showFullscreenBtn", cVar.aCN);
            cVar2.aCO = jSONObject.optBoolean("enableProgressGesture", cVar.aCO);
            cVar2.aCH = jSONObject.optString("sanId", cVar.aCH);
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.aAu = "";
        this.aCx = false;
        this.aCy = "";
        this.aCz = 0;
        this.duration = 0;
        this.aAD = false;
        this.mLoop = false;
        this.aCA = "";
        this.mPos = 0;
        this.aCC = "";
        this.aCD = "";
        this.aCE = false;
        this.aCF = false;
        this.aCG = true;
        this.mSrc = "";
        this.aCH = "";
        this.aCL = false;
        this.aCM = true;
        this.mDirection = 0;
        this.aCN = true;
        this.aCO = true;
        this.aCP = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aAu);
    }

    public boolean isAutoPlay() {
        return this.aAD;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String H(JSONObject jSONObject) {
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

    private static String fo(String str) {
        if (!com.baidu.swan.apps.storage.b.ht(str) || com.baidu.swan.apps.ae.b.Lq() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.Lq());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aAu + "', mSlaveId='" + this.aDm + "', mMuted=" + this.aCx + "', mObjectFit='" + this.aCA + "', mControl=" + this.aCG + '}';
    }
}
