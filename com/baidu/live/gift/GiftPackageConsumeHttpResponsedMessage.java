package com.baidu.live.gift;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GiftPackageConsumeHttpResponsedMessage extends JsonHttpResponsedMessage {
    public String aQL;
    public int aQM;

    public GiftPackageConsumeHttpResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021151) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.aQL = optJSONObject.optString(LegoListActivityConfig.ITEM_ID);
                this.aQM = optJSONObject.optInt("balance");
            }
        }
    }
}
