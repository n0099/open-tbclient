package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.au;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EventPollingHttpResponseMessage extends JsonHttpResponsedMessage {
    public int beN;
    public List<au> beO;
    public long currentTime;
    public long liveId;

    public EventPollingHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.beO = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    au auVar = new au();
                    auVar.parseJson(jSONObject2);
                    this.beO.add(auVar);
                }
                this.beN = optJSONObject.optInt("polling_interval");
                this.liveId = optJSONObject.optLong("live_id");
                this.currentTime = optJSONObject.optLong("current_time");
            }
        }
    }
}
