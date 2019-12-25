package com.baidu.swan.apps.media.audio;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    String bvH;
    public boolean bvJ;
    public String mReferer;
    public String mUserAgent;
    public String bvC = "";
    public String aXf = "";
    public String mUrl = "";
    public String mTitle = "";
    public String bvD = "";
    public String bvE = "";
    public String mCoverUrl = "";
    public int bvF = 0;
    public int mPos = 0;
    public String bvG = "";
    public boolean bvI = false;

    public static a a(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.bvC = jSONObject.optString("audioId", aVar.bvC);
            aVar2.aXf = jSONObject.optString("slaveId", aVar.aXf);
            aVar2.mUrl = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.mUrl);
            aVar2.bvI = e.ZS() != null && com.baidu.swan.apps.storage.b.lA(aVar2.mUrl);
            aVar2.mTitle = jSONObject.optString("title", aVar.mTitle);
            aVar2.bvD = jSONObject.optString("epname", aVar.bvD);
            aVar2.bvE = jSONObject.optString("singer", aVar.bvE);
            aVar2.mCoverUrl = jSONObject.optString("coverImgUrl", aVar.mCoverUrl);
            aVar2.bvF = jSONObject.optInt("startTime", aVar.bvF);
            aVar2.mPos = jSONObject.optInt("position", aVar.mPos);
            aVar2.bvH = jSONObject.optString("cb", aVar.bvH);
            aVar2.bvG = jSONObject.optString("param", aVar.bvG);
            aVar2.bvJ = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String Oh = com.baidu.swan.apps.core.k.d.NK().Oh();
            if (!TextUtils.isEmpty(Oh)) {
                aVar2.mUserAgent = Oh;
            }
            String aek = y.aek();
            if (!TextUtils.isEmpty(aek) && y.mv(aVar2.mUrl)) {
                aVar2.mReferer = aek;
            }
        }
        return aVar2;
    }

    public boolean Ur() {
        return this.bvJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String iE(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.mTitle);
            jSONObject.putOpt("epname", this.bvD);
            jSONObject.putOpt("singer", this.bvE);
            jSONObject.putOpt("coverImgUrl", this.mCoverUrl);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.bvI));
            jSONObject.putOpt("appid", e.ZU());
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
        return "playerId : " + this.bvC + "; slaveId : " + this.aXf + "; url : " + this.mUrl + "; startTime : " + this.bvF + "; pos : " + this.mPos + "; canPlay : " + this.bvJ;
    }
}
