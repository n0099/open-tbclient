package com.baidu.live.gift;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends BaseData {
    public String aUA;
    public int aUB;
    public ArrayList<r> aUC;
    public String aUw;
    public String aUx;
    public long aUy;
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
            this.aUw = jSONObject.optString("tying_gift_id");
            this.aUx = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aUy = jSONObject.optLong("pay_userid");
            this.aUz = jSONObject.optString("im_test");
            this.aUA = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            this.subappType = jSONObject.optString("subapp_type");
            this.aUB = jSONObject.optInt("tying_status");
            C(jSONObject);
        }
    }

    private void C(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("gift_member") && (optJSONArray = jSONObject.optJSONArray("gift_member")) != null && optJSONArray.length() > 0) {
            if (this.aUC == null) {
                this.aUC = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    r rVar = new r();
                    rVar.parserJson(optJSONObject);
                    this.aUC.add(rVar);
                }
            }
        }
    }

    public String Gk() {
        return this.aUx;
    }

    public String Gl() {
        return this.aUz;
    }

    public int Gm() {
        return this.aUB;
    }
}
