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
    String bAQ;
    public boolean bAS;
    public String mReferer;
    public String mUserAgent;
    public String bAL = "";
    public String bcw = "";
    public String mUrl = "";
    public String mTitle = "";
    public String bAM = "";
    public String bAN = "";
    public String mCoverUrl = "";
    public int bAO = 0;
    public int mPos = 0;
    public String bAP = "";
    public boolean bAR = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.bAL = jSONObject.optString("audioId", aVar.bAL);
            aVar2.bcw = jSONObject.optString("slaveId", aVar.bcw);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.bAR = e.acI() != null && com.baidu.swan.apps.storage.b.lR(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.bAM = jSONObject.optString("epname", aVar.bAM);
            aVar2.bAN = jSONObject.optString("singer", aVar.bAN);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.bAO = jSONObject.optInt("startTime", aVar.bAO);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.bAQ = jSONObject.optString("cb", aVar.bAQ);
            aVar2.bAP = jSONObject.optString("param", aVar.bAP);
            aVar2.bAS = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String QW = com.baidu.swan.apps.core.k.d.Qz().QW();
            if (!TextUtils.isEmpty(QW)) {
                aVar2.mUserAgent = QW;
            }
            String agW = y.agW();
            if (!TextUtils.isEmpty(agW) && y.mM(aVar2.mUrl)) {
                aVar2.mReferer = agW;
            }
        }
        return aVar2;
    }

    public boolean Xh() {
        return this.bAS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String iV(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.bAM);
            jSONObject.putOpt("singer", this.bAN);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.bAR));
            jSONObject.putOpt("appid", e.acK());
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
        return "playerId : " + this.bAL + "; slaveId : " + this.bcw + "; url : " + this.mUrl + "; startTime : " + this.bAO + "; pos : " + this.mPos + "; canPlay : " + this.bAS;
    }
}
