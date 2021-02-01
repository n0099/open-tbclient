package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r extends BaseData {
    public String aXA;
    public String aXB;
    public long aXC;
    public String aXD;
    public String aXE;
    public int aXF;
    public ArrayList<s> aXG;
    public long anchorId;
    public int countDown;
    public String giftId;
    public long liveId;
    public String subappType;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aXA = jSONObject.optString("tying_gift_id");
            this.aXB = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aXC = jSONObject.optLong("pay_userid");
            this.aXD = jSONObject.optString("im_test");
            this.aXE = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aXF = jSONObject.optInt("tying_status");
            J(jSONObject);
        }
    }

    private void J(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aXG == null) {
                this.aXG = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    s sVar = new s();
                    sVar.parserJson(optJSONObject);
                    this.aXG.add(sVar);
                }
            }
        }
    }

    public String EV() {
        return this.aXB;
    }

    public String EW() {
        return this.aXD;
    }

    public int EX() {
        return this.aXF;
    }
}
