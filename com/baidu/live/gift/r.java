package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r extends BaseData {
    public String aZi;
    public String aZj;
    public long aZk;
    public String aZl;
    public String aZm;
    public int aZn;
    public ArrayList<s> aZo;
    public long anchorId;
    public int countDown;
    public String giftId;
    public long liveId;
    public String subappType;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aZi = jSONObject.optString("tying_gift_id");
            this.aZj = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aZk = jSONObject.optLong("pay_userid");
            this.aZl = jSONObject.optString("im_test");
            this.aZm = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aZn = jSONObject.optInt("tying_status");
            J(jSONObject);
        }
    }

    private void J(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aZo == null) {
                this.aZo = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    s sVar = new s();
                    sVar.parserJson(optJSONObject);
                    this.aZo.add(sVar);
                }
            }
        }
    }

    public String HA() {
        return this.aZj;
    }

    public String HB() {
        return this.aZl;
    }

    public int HC() {
        return this.aZn;
    }
}
