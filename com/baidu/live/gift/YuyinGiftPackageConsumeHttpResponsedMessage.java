package com.baidu.live.gift;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinGiftPackageConsumeHttpResponsedMessage extends JsonHttpResponsedMessage {
    public String aUM;
    public int aUN;

    public YuyinGiftPackageConsumeHttpResponsedMessage() {
        super(1031057);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031057) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.aUM = optJSONObject.optString(LegoListActivityConfig.ITEM_ID);
                this.aUN = optJSONObject.optInt("balance");
            }
        }
    }
}
