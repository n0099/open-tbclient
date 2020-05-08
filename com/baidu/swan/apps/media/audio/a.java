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
    String bZd;
    public boolean bZf;
    public String mReferer;
    public String mUserAgent;
    public String bYY = "";
    public String bAP = "";
    public String mUrl = "";
    public String mTitle = "";
    public String bYZ = "";
    public String bZa = "";
    public String mCoverUrl = "";
    public int bZb = 0;
    public int mPos = 0;
    public String bZc = "";
    public boolean bZe = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.bYY = jSONObject.optString("audioId", aVar.bYY);
            aVar2.bAP = jSONObject.optString("slaveId", aVar.bAP);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.bZe = e.akM() != null && com.baidu.swan.apps.storage.b.ne(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.bYZ = jSONObject.optString("epname", aVar.bYZ);
            aVar2.bZa = jSONObject.optString("singer", aVar.bZa);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.bZb = jSONObject.optInt("startTime", aVar.bZb);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.bZd = jSONObject.optString("cb", aVar.bZd);
            aVar2.bZc = jSONObject.optString("param", aVar.bZc);
            aVar2.bZf = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String YK = com.baidu.swan.apps.core.k.d.Yn().YK();
            if (!TextUtils.isEmpty(YK)) {
                aVar2.mUserAgent = YK;
            }
            String apc = y.apc();
            if (!TextUtils.isEmpty(apc) && y.nZ(aVar2.mUrl)) {
                aVar2.mReferer = apc;
            }
        }
        return aVar2;
    }

    public boolean aeW() {
        return this.bZf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ki(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.bYZ);
            jSONObject.putOpt("singer", this.bZa);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.bZe));
            jSONObject.putOpt("appid", e.akO());
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
        return "playerId : " + this.bYY + "; slaveId : " + this.bAP + "; url : " + this.mUrl + "; startTime : " + this.bZb + "; pos : " + this.mPos + "; canPlay : " + this.bZf;
    }
}
