package com.baidu.live.personmanager;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YuyinPersonManagerResponseMessage extends JsonHttpResponsedMessage {
    private String bxz;

    public YuyinPersonManagerResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
        if (optJSONObject != null) {
            this.bxz = optJSONObject.optString("usermsg");
        }
    }

    public String getUserMsg() {
        return this.bxz;
    }
}
