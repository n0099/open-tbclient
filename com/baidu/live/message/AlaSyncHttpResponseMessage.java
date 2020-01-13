package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.s;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private s asq;

    public s wA() {
        return this.asq;
    }

    public AlaSyncHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SYNC);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.asq = new s(false);
            this.asq.parserJson(jSONObject);
        }
    }
}
