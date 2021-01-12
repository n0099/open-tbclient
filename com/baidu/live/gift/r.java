package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r extends BaseData {
    public int aUA;
    public ArrayList<s> aUB;
    public String aUv;
    public String aUw;
    public long aUx;
    public String aUy;
    public String aUz;
    public long anchorId;
    public int countDown;
    public String giftId;
    public long liveId;
    public String subappType;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aUv = jSONObject.optString("tying_gift_id");
            this.aUw = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aUx = jSONObject.optLong("pay_userid");
            this.aUy = jSONObject.optString("im_test");
            this.aUz = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aUA = jSONObject.optInt("tying_status");
            J(jSONObject);
        }
    }

    private void J(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aUB == null) {
                this.aUB = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    s sVar = new s();
                    sVar.parserJson(optJSONObject);
                    this.aUB.add(sVar);
                }
            }
        }
    }

    public String DF() {
        return this.aUw;
    }

    public String DG() {
        return this.aUy;
    }

    public int DH() {
        return this.aUA;
    }
}
