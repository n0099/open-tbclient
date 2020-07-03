package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.z;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaSyncHttpResponseMessage extends JsonHttpResponsedMessage {
    private z aZp;

    public z FZ() {
        return this.aZp;
    }

    public AlaSyncHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_SYNC);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aZp = new z(false);
            this.aZp.parserJson(jSONObject);
        }
    }
}
