package com.baidu.live.message;

import com.baidu.live.data.AlaUserAuthenInfoData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaUserAuthenVerifyInfoResponseMessage extends JsonHttpResponsedMessage {
    public AlaUserAuthenInfoData brv;
    public int brw;

    public AlaUserAuthenVerifyInfoResponseMessage() {
        super(1021046);
        this.brw = 1;
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
                        this.brv = new AlaUserAuthenInfoData();
                        this.brv.paserJson(optJSONObject2);
                    }
                    this.brw = optJSONObject.optInt("authen_switch");
                } catch (Exception e) {
                }
            }
        }
    }
}
