package com.baidu.live.gift.broadcastgift;

import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetBroadcastGiftResponseMessage extends JsonHttpResponsedMessage {
    public ArrayList<AlaBroadcastGiftToastData> aWg;
    public long aWh;

    public AlaGetBroadcastGiftResponseMessage(int i) {
        super(1021119);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aWh = optJSONObject.optLong("msg_id", 0L);
            this.aWg = new ArrayList<>();
            JSONArray optJSONArray = optJSONObject.optJSONArray("queue");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.parserJson(optJSONArray.optJSONObject(i2));
                    this.aWg.add(alaBroadcastGiftToastData);
                }
            }
        }
    }
}
