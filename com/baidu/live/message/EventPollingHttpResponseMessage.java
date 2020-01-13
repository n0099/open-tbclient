package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.ae;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EventPollingHttpResponseMessage extends JsonHttpResponsedMessage {
    public int asw;
    public List<ae> asx;
    public long currentTime;
    public long liveId;

    public EventPollingHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.asx = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    ae aeVar = new ae();
                    aeVar.parseJson(jSONObject2);
                    this.asx.add(aeVar);
                }
                this.asw = optJSONObject.optInt("polling_interval");
                this.liveId = optJSONObject.optLong("live_id");
                this.currentTime = optJSONObject.optLong("current_time");
            }
        }
    }
}
