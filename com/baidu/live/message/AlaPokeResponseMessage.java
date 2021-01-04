package com.baidu.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaPokeResponseMessage extends JsonHttpResponsedMessage {
    public int bwe;
    public long userId;

    public AlaPokeResponseMessage() {
        super(1021227);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.userId = optJSONObject.optLong("poke_user_id", 0L);
            this.bwe = optJSONObject.optInt("poke_flag", 0);
        }
    }
}
