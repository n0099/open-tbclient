package com.baidu.live.gift;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YuyinGiftPackageConsumeHttpResponsedMessage extends JsonHttpResponsedMessage {
    public int aZA;
    public String aZz;

    public YuyinGiftPackageConsumeHttpResponsedMessage() {
        super(1031057);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031057) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.aZz = optJSONObject.optString(LegoListActivityConfig.ITEM_ID);
                this.aZA = optJSONObject.optInt("balance");
            }
        }
    }
}
