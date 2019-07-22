package com.baidu.swan.apps.media.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.apps.model.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aBc;
    public boolean aBl;
    public boolean aDf;
    public String aDg;
    public int aDh;
    public String aDi;
    public boolean aDj;
    public String aDk;
    public String aDl;
    public boolean aDm;
    public boolean aDn;
    public boolean aDo;
    public String aDp;
    private boolean aDq;
    private boolean aDr;
    private boolean aDs;
    public boolean aDt;
    public boolean aDu;
    public boolean aDv;
    public boolean aDw;
    public boolean aDx;
    public int duration;
    public int mDirection;
    public boolean mLoop;
    public int mPos;
    public String mSrc;

    public static c a(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        if (jSONObject != null) {
            cVar2.a(jSONObject, (com.baidu.swan.apps.model.a.a.a) cVar);
            cVar2.aBc = jSONObject.optString("videoId", cVar.aBc);
            cVar2.aBl = jSONObject.optBoolean("autoplay", cVar.aBl);
            cVar2.aDf = jSONObject.optBoolean("muted", cVar.aDf);
            cVar2.aDi = jSONObject.optString("objectFit", cVar.aDi);
            cVar2.aDh = jSONObject.optInt("initialTime", cVar.aDh);
            cVar2.aDg = jSONObject.optString("poster", cVar.aDg);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.aDj = jSONObject.optBoolean("fullScreen", cVar.aDj);
            cVar2.aDk = H(jSONObject);
            cVar2.aDl = jSONObject.optString("danmuList", cVar.aDl);
            cVar2.aDm = jSONObject.optBoolean("enableDanmu", cVar.aDm);
            cVar2.aDn = jSONObject.optBoolean("danmuBtn", cVar.aDn);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.aDo = jSONObject.optBoolean("controls", cVar.aDo);
            cVar2.mSrc = fs(jSONObject.optString("src", cVar.mSrc));
            cVar2.aDx = !com.baidu.swan.apps.storage.b.hz(jSONObject.optString("src", cVar.mSrc));
            cVar2.aDq = jSONObject.optBoolean("showPlayBtn", cVar.aDq);
            cVar2.aDr = jSONObject.optBoolean("showMuteBtn", cVar.aDr);
            cVar2.aDs = jSONObject.optBoolean("showCenterPlayBtn", cVar.aDs);
            cVar2.aDt = jSONObject.optBoolean("pageGesture", cVar.aDt);
            cVar2.aDu = jSONObject.optBoolean("showProgress", cVar.aDu);
            cVar2.mDirection = jSONObject.optInt("direction");
            cVar2.aDv = jSONObject.optBoolean("showFullscreenBtn", cVar.aDv);
            cVar2.aDw = jSONObject.optBoolean("enableProgressGesture", cVar.aDw);
            cVar2.aDp = jSONObject.optString("sanId", cVar.aDp);
        }
        return cVar2;
    }

    public c() {
        super("viewId", "video");
        this.aBc = "";
        this.aDf = false;
        this.aDg = "";
        this.aDh = 0;
        this.duration = 0;
        this.aBl = false;
        this.mLoop = false;
        this.aDi = "";
        this.mPos = 0;
        this.aDk = "";
        this.aDl = "";
        this.aDm = false;
        this.aDn = false;
        this.aDo = true;
        this.mSrc = "";
        this.aDp = "";
        this.aDt = false;
        this.aDu = true;
        this.mDirection = 0;
        this.aDv = true;
        this.aDw = true;
        this.aDx = true;
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.aBc);
    }

    public boolean isAutoPlay() {
        return this.aBl;
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

    private static String fs(String str) {
        if (!com.baidu.swan.apps.storage.b.hz(str) || com.baidu.swan.apps.ae.b.Md() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.b(str, com.baidu.swan.apps.ae.b.Md());
    }

    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.aBc + "', mSlaveId='" + this.aDU + "', mMuted=" + this.aDf + "', mObjectFit='" + this.aDi + "', mControl=" + this.aDo + '}';
    }
}
