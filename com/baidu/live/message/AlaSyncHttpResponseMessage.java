package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private ab beH;

    public ab LH() {
        return this.beH;
    }

    public AlaSyncHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SYNC);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beH = new ab(false);
            this.beH.parserJson(jSONObject);
        }
    }
}
