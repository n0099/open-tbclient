package com.baidu.live.message;

import com.baidu.live.data.AlaUserAuthenInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaUserAuthenVerifyInfoResponseMessage extends JsonHttpResponsedMessage {
    public AlaUserAuthenInfoData bmK;
    public int bmL;

    public AlaUserAuthenVerifyInfoResponseMessage() {
        super(1021046);
        this.bmL = 1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                try {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("authen_info");
                    if (optJSONObject2 != null) {
                        this.bmK = new AlaUserAuthenInfoData();
                        this.bmK.paserJson(optJSONObject2);
                    }
                    this.bmL = optJSONObject.optInt("authen_switch");
                } catch (Exception e) {
                }
            }
        }
    }
}
