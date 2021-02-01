package com.baidu.live.message;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetLiveInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private ab aDd;

    public AlaGetLiveInfoHttpResponseMessage() {
        super(1021007);
    }

    public ab Fm() {
        return this.aDd;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            long j = jSONObject.getLong("time");
            if (optJSONObject != null && getError() == 0) {
                this.aDd = new ab();
                this.aDd.serverTime = j;
                this.aDd.parserJson(optJSONObject);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("live_info");
                if (optJSONObject2 != null) {
                    AlaLiveSwitchData.isHotLive = optJSONObject2.optInt(HttpRequest.SDK_LIVE_IS_HOT);
                    AlaLiveSwitchData.liveActivityType = optJSONObject2.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                }
            }
        }
    }
}
