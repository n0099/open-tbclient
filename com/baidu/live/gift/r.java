package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r extends BaseData {
    public String aXD;
    public String aXE;
    public long aXF;
    public String aXG;
    public String aXH;
    public int aXI;
    public ArrayList<s> aXJ;
    public long anchorId;
    public int countDown;
    public String giftId;
    public long liveId;
    public String subappType;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aXD = jSONObject.optString("tying_gift_id");
            this.aXE = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aXF = jSONObject.optLong("pay_userid");
            this.aXG = jSONObject.optString("im_test");
            this.aXH = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aXI = jSONObject.optInt("tying_status");
            C(jSONObject);
        }
    }

    private void C(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aXJ == null) {
                this.aXJ = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    s sVar = new s();
                    sVar.parserJson(optJSONObject);
                    this.aXJ.add(sVar);
                }
            }
        }
    }

    public String HZ() {
        return this.aXE;
    }

    public String Ia() {
        return this.aXG;
    }

    public int Ib() {
        return this.aXI;
    }
}
