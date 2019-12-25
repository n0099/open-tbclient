package com.baidu.live.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.aa;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EventPollingHttpResponseMessage extends JsonHttpResponsedMessage {
    public long VM;
    public int arK;
    public List<aa> arL;
    public long liveId;

    public EventPollingHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.arL = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    aa aaVar = new aa();
                    aaVar.parseJson(jSONObject2);
                    this.arL.add(aaVar);
                }
                this.arK = optJSONObject.optInt("polling_interval");
                this.liveId = optJSONObject.optLong("live_id");
                this.VM = optJSONObject.optLong("current_time");
            }
        }
    }
}
