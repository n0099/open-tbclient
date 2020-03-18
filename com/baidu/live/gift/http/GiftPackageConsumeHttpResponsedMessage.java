package com.baidu.live.gift.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GiftPackageConsumeHttpResponsedMessage extends JsonHttpResponsedMessage {
    public String aod;
    public int aoe;

    public GiftPackageConsumeHttpResponsedMessage() {
        super(1021151);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021151) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.aod = optJSONObject.optString(LegoListActivityConfig.ITEM_ID);
                this.aoe = optJSONObject.optInt("balance");
            }
        }
    }
}
