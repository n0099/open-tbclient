package com.baidu.live.message;

import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetUserInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLivePersonData bhs;

    public AlaGetUserInfoHttpResponseMessage() {
        super(1021039);
    }

    public AlaLivePersonData Me() {
        return this.bhs;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.bhs = new AlaLivePersonData();
                this.bhs.parseJson(optJSONObject);
            }
        }
    }
}
