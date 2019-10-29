package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.o;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private o ajX;

    public o un() {
        return this.ajX;
    }

    public AlaSyncHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SYNC);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ajX = new o(false);
            this.ajX.parserJson(jSONObject);
        }
    }
}
