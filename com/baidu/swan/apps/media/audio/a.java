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
    String bYX;
    public boolean bYZ;
    public String mReferer;
    public String mUserAgent;
    public String bYS = "";
    public String bAK = "";
    public String mUrl = "";
    public String mTitle = "";
    public String bYT = "";
    public String bYU = "";
    public String mCoverUrl = "";
    public int bYV = 0;
    public int mPos = 0;
    public String bYW = "";
    public boolean bYY = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.bYS = jSONObject.optString("audioId", aVar.bYS);
            aVar2.bAK = jSONObject.optString("slaveId", aVar.bAK);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.bYY = e.akN() != null && com.baidu.swan.apps.storage.b.ne(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.bYT = jSONObject.optString("epname", aVar.bYT);
            aVar2.bYU = jSONObject.optString("singer", aVar.bYU);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.bYV = jSONObject.optInt("startTime", aVar.bYV);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.bYX = jSONObject.optString("cb", aVar.bYX);
            aVar2.bYW = jSONObject.optString("param", aVar.bYW);
            aVar2.bYZ = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String YL = com.baidu.swan.apps.core.k.d.Yo().YL();
            if (!TextUtils.isEmpty(YL)) {
                aVar2.mUserAgent = YL;
            }
            String apd = y.apd();
            if (!TextUtils.isEmpty(apd) && y.nZ(aVar2.mUrl)) {
                aVar2.mReferer = apd;
            }
        }
        return aVar2;
    }

    public boolean aeX() {
        return this.bYZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ki(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.bYT);
            jSONObject.putOpt("singer", this.bYU);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.bYY));
            jSONObject.putOpt("appid", e.akP());
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
        return "playerId : " + this.bYS + "; slaveId : " + this.bAK + "; url : " + this.mUrl + "; startTime : " + this.bYV + "; pos : " + this.mPos + "; canPlay : " + this.bYZ;
    }
}
