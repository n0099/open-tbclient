package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String cjG;
    public boolean cjI;
    public String mReferer;
    public String mUserAgent;
    public String cjA = "";
    public String bIH = "";
    public String mUrl = "";
    public String mTitle = "";
    public String cjB = "";
    public String cjC = "";
    public String mCoverUrl = "";
    public String cjD = "";
    public int cjE = 0;
    public int mPos = 0;
    public String cjF = "";
    public boolean cjH = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.cjA = jSONObject.optString("audioId", aVar.cjA);
            aVar2.bIH = jSONObject.optString("slaveId", aVar.bIH);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.cjH = e.aoF() != null && com.baidu.swan.apps.storage.b.oH(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.cjB = jSONObject.optString("epname", aVar.cjB);
            aVar2.cjC = jSONObject.optString("singer", aVar.cjC);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.cjD = jSONObject.optString("lrcURL", aVar.cjD);
            aVar2.cjE = jSONObject.optInt("startTime", aVar.cjE);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.cjG = jSONObject.optString("cb", aVar.cjG);
            aVar2.cjF = jSONObject.optString("param", aVar.cjF);
            aVar2.cjI = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String abJ = com.baidu.swan.apps.core.turbo.d.abl().abJ();
            if (!TextUtils.isEmpty(abJ)) {
                aVar2.mUserAgent = abJ;
            }
            String atD = z.atD();
            if (!TextUtils.isEmpty(atD) && z.pI(aVar2.mUrl)) {
                aVar2.mReferer = atD;
            }
        }
        return aVar2;
    }

    public boolean aik() {
        return this.cjI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lv(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.cjB);
            jSONObject.putOpt("singer", this.cjC);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("lrcURL", this.cjD);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.cjH));
            jSONObject.putOpt("appid", e.aoH());
            jSONObject.putOpt("user-agent", this.mUserAgent);
            jSONObject.putOpt("refer", this.mReferer);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.cjA + "; slaveId : " + this.bIH + "; url : " + this.mUrl + "; startTime : " + this.cjE + "; pos : " + this.mPos + "; canPlay : " + this.cjI;
    }
}
