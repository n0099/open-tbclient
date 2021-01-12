package com.baidu.live.message;

import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetUserInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLivePersonData brm;

    public AlaGetUserInfoHttpResponseMessage() {
        super(1021039);
    }

    public AlaLivePersonData MQ() {
        return this.brm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.brm = new AlaLivePersonData();
                this.brm.parseJson(optJSONObject);
            }
        }
    }
}
