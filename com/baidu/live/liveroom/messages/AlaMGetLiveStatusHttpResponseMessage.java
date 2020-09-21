package com.baidu.live.liveroom.messages;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMGetLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    private List<Long> mClosedIds;
    private long mInterval;

    public AlaMGetLiveStatusHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS);
    }

    public List<Long> getClosedIds() {
        return this.mClosedIds;
    }

    public long getInterval() {
        return this.mInterval;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONArray = optJSONObject.optJSONArray("close_live")) != null) {
            this.mInterval = optJSONObject.optLong("interval");
            this.mClosedIds = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                long optLong = optJSONArray.optLong(i2);
                if (optLong > 0) {
                    this.mClosedIds.add(Long.valueOf(optLong));
                }
            }
        }
    }
}
