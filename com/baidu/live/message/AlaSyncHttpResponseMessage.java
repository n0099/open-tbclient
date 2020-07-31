package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.z;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private z aZn;

    public z FT() {
        return this.aZn;
    }

    public AlaSyncHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SYNC);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZn = new z(false);
            this.aZn.parserJson(jSONObject);
        }
    }
}
