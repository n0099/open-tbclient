package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String bAD;
    public boolean bAF;
    public String mReferer;
    public String mUserAgent;
    public String bAy = "";
    public String bch = "";
    public String mUrl = "";
    public String mTitle = "";
    public String bAz = "";
    public String bAA = "";
    public String mCoverUrl = "";
    public int bAB = 0;
    public int mPos = 0;
    public String bAC = "";
    public boolean bAE = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.bAy = jSONObject.optString("audioId", aVar.bAy);
            aVar2.bch = jSONObject.optString("slaveId", aVar.bch);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.bAE = e.acD() != null && com.baidu.swan.apps.storage.b.lS(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.bAz = jSONObject.optString("epname", aVar.bAz);
            aVar2.bAA = jSONObject.optString("singer", aVar.bAA);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.bAB = jSONObject.optInt("startTime", aVar.bAB);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.bAD = jSONObject.optString("cb", aVar.bAD);
            aVar2.bAC = jSONObject.optString("param", aVar.bAC);
            aVar2.bAF = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String QR = com.baidu.swan.apps.core.k.d.Qu().QR();
            if (!TextUtils.isEmpty(QR)) {
                aVar2.mUserAgent = QR;
            }
            String agR = y.agR();
            if (!TextUtils.isEmpty(agR) && y.mN(aVar2.mUrl)) {
                aVar2.mReferer = agR;
            }
        }
        return aVar2;
    }

    public boolean Xc() {
        return this.bAF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String iW(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.bAz);
            jSONObject.putOpt("singer", this.bAA);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.bAE));
            jSONObject.putOpt("appid", e.acF());
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
        return "playerId : " + this.bAy + "; slaveId : " + this.bch + "; url : " + this.mUrl + "; startTime : " + this.bAB + "; pos : " + this.mPos + "; canPlay : " + this.bAF;
    }
}
