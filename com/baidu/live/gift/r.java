package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r extends BaseData {
    public String aZa;
    public String aZb;
    public long aZc;
    public String aZd;
    public String aZe;
    public int aZf;
    public ArrayList<s> aZg;
    public long anchorId;
    public int countDown;
    public String giftId;
    public long liveId;
    public String subappType;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aZa = jSONObject.optString("tying_gift_id");
            this.aZb = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aZc = jSONObject.optLong("pay_userid");
            this.aZd = jSONObject.optString("im_test");
            this.aZe = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aZf = jSONObject.optInt("tying_status");
            L(jSONObject);
        }
    }

    private void L(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aZg == null) {
                this.aZg = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    s sVar = new s();
                    sVar.parserJson(optJSONObject);
                    this.aZg.add(sVar);
                }
            }
        }
    }

    public String EY() {
        return this.aZb;
    }

    public String EZ() {
        return this.aZd;
    }

    public int Fa() {
        return this.aZf;
    }
}
