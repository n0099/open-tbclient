package com.baidu.live.talentshow.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveBCVideoShowQueueResponse extends JsonHttpResponsedMessage {
    public com.baidu.live.talentshow.components.selector.c bHz;

    public LiveBCVideoShowQueueResponse() {
        super(1021224);
        this.bHz = new com.baidu.live.talentshow.components.selector.c();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.live.talentshow.b.b bVar = new com.baidu.live.talentshow.b.b();
            bVar.parserJson(optJSONObject);
            if (this.bHz.Uy() > 0) {
                this.bHz.clearData();
            }
            this.bHz.ad(bVar.bFS);
            this.bHz.ad(bVar.bFR);
            this.bHz.Uz();
        }
    }

    public List<com.baidu.live.talentshow.b.d> Vy() {
        return this.bHz.Ux();
    }
}
