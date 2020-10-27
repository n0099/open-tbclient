package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r extends BaseData {
    public String aUP;
    public String aUQ;
    public long aUR;
    public String aUS;
    public String aUT;
    public int aUU;
    public ArrayList<s> aUV;
    public long anchorId;
    public int countDown;
    public String giftId;
    public long liveId;
    public String subappType;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.aUP = jSONObject.optString("tying_gift_id");
            this.aUQ = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aUR = jSONObject.optLong("pay_userid");
            this.aUS = jSONObject.optString("im_test");
            this.aUT = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aUU = jSONObject.optInt("tying_status");
            F(jSONObject);
        }
    }

    private void F(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aUV == null) {
                this.aUV = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    s sVar = new s();
                    sVar.parserJson(optJSONObject);
                    this.aUV.add(sVar);
                }
            }
        }
    }

    public String Gs() {
        return this.aUQ;
    }

    public String Gt() {
        return this.aUS;
    }

    public int Gu() {
        return this.aUU;
    }
}
