package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class EventPollingHttpResponseMessage extends JsonHttpResponsedMessage {
    public long OO;
    public int ajM;
    public List<x> ajN;
    public long liveId;

    public EventPollingHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.ajN = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    x xVar = new x();
                    xVar.parseJson(jSONObject2);
                    this.ajN.add(xVar);
                }
                this.ajM = optJSONObject.optInt("polling_interval");
                this.liveId = optJSONObject.optLong("live_id");
                this.OO = optJSONObject.optLong("current_time");
            }
        }
    }
}
