package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends BaseData {
    public String aWh;
    public String aWi;
    public long aWj;
    public String aWk;
    public String aWl;
    public int aWm;
    public ArrayList<r> aWn;
    public long anchorId;
    public int countDown;
    public String giftId;
    public long liveId;
    public String subappType;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aWh = jSONObject.optString("tying_gift_id");
            this.aWi = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aWj = jSONObject.optLong("pay_userid");
            this.aWk = jSONObject.optString("im_test");
            this.aWl = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aWm = jSONObject.optInt("tying_status");
            I(jSONObject);
        }
    }

    private void I(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aWn == null) {
                this.aWn = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    r rVar = new r();
                    rVar.parserJson(optJSONObject);
                    this.aWn.add(rVar);
                }
            }
        }
    }

    public String GT() {
        return this.aWi;
    }

    public String GU() {
        return this.aWk;
    }

    public int GV() {
        return this.aWm;
    }
}
