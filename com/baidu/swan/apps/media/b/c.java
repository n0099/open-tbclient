package com.baidu.swan.apps.media.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.apps.component.b.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String djT;
    public boolean dkc;
    public String dnZ;
    public int doa;
    public String dob;
    public boolean dod;
    public String doe;
    public String dof;
    public boolean dog;
    public boolean doh;
    public boolean doi;
    public String doj;
    private boolean dok;
    private boolean dol;
    private boolean dom;
    public boolean don;
    public boolean doo;
    public boolean dop;
    public boolean doq;
    public boolean dor;
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
            cVar2.djT = jSONObject.optString("videoId", cVar.djT);
            cVar2.dkc = jSONObject.optBoolean("autoplay", cVar.dkc);
            cVar2.mMute = jSONObject.optBoolean("muted", cVar.mMute);
            cVar2.dob = jSONObject.optString("objectFit", cVar.dob);
            cVar2.doa = jSONObject.optInt("initialTime", cVar.doa);
            cVar2.dnZ = jSONObject.optString("poster", cVar.dnZ);
            cVar2.mPos = jSONObject.optInt("position", cVar.mPos);
            cVar2.dod = jSONObject.optBoolean("fullScreen", cVar.dod);
            cVar2.doe = bp(jSONObject);
            cVar2.dof = jSONObject.optString("danmuList", cVar.dof);
            cVar2.dog = jSONObject.optBoolean("enableDanmu", cVar.dog);
            cVar2.doh = jSONObject.optBoolean("danmuBtn", cVar.doh);
            cVar2.mLoop = jSONObject.optBoolean("loop", cVar.mLoop);
            cVar2.doi = jSONObject.optBoolean("controls", cVar.doi);
            cVar2.mSrc = oq(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dor = !com.baidu.swan.apps.storage.b.tc(jSONObject.optString(UserAccountActionItem.KEY_SRC, cVar.mSrc));
            cVar2.dok = jSONObject.optBoolean("showPlayBtn", cVar.dok);
            cVar2.dol = jSONObject.optBoolean("showMuteBtn", cVar.dol);
            cVar2.dom = jSONObject.optBoolean("showCenterPlayBtn", cVar.dom);
            cVar2.don = jSONObject.optBoolean("pageGesture", cVar.don);
            cVar2.doo = jSONObject.optBoolean("showProgress", cVar.doo);
            cVar2.mDirection = jSONObject.optInt("direction", cVar.mDirection);
            cVar2.dop = jSONObject.optBoolean("showFullscreenBtn", cVar.dop);
            cVar2.doq = jSONObject.optBoolean("enableProgressGesture", cVar.doq);
            cVar2.doj = jSONObject.optString("sanId", cVar.doj);
        }
        return cVar2;
    }

    public c() {
        super("video", "viewId");
        this.djT = "";
        this.mMute = false;
        this.dnZ = "";
        this.doa = 0;
        this.duration = 0;
        this.dkc = false;
        this.mLoop = false;
        this.dob = "";
        this.mPos = 0;
        this.doe = "";
        this.dof = "";
        this.dog = false;
        this.doh = false;
        this.doi = true;
        this.mSrc = "";
        this.doj = "";
        this.don = false;
        this.doo = true;
        this.mDirection = -1;
        this.dop = true;
        this.doq = true;
        this.dor = true;
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.djT);
    }

    public boolean isAutoPlay() {
        return this.dkc;
    }

    public boolean isVisible() {
        return !this.hidden;
    }

    private static String bp(JSONObject jSONObject) {
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

    private static String oq(String str) {
        if (!com.baidu.swan.apps.storage.b.tc(str) || e.aIN() == null) {
            return str;
        }
        return com.baidu.swan.apps.storage.b.c(str, e.aIN());
    }

    @Override // com.baidu.swan.apps.component.b.b
    public String toString() {
        return "VideoPlayerParams{mPlayerId='" + this.djT + "', mMute=" + this.mMute + ", mPoster='" + this.dnZ + "', mInitialTime=" + this.doa + ", duration=" + this.duration + ", mAutoPlay=" + this.dkc + ", mLoop=" + this.mLoop + ", mObjectFit='" + this.dob + "', mPos=" + this.mPos + ", mFullScreen=" + this.dod + ", mDanmu='" + this.doe + "', mDanmuList='" + this.dof + "', mEnableDanmu=" + this.dog + ", mShowDanmuBtn=" + this.doh + ", mShowControlPanel=" + this.doi + ", mSrc='" + this.mSrc + "', mSanId='" + this.doj + "', mShowPlayBtn=" + this.dok + ", mShowMuteBtn=" + this.dol + ", mShowCenterPlayBtn=" + this.dom + ", mPageGesture=" + this.don + ", mShowProgress=" + this.doo + ", mDirection=" + this.mDirection + ", mShowFullscreenBtn=" + this.dop + ", mEnableProgressGesture=" + this.doq + ", mIsRemoteFile=" + this.dor + '}';
    }
}
