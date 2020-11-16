package com.baidu.live.talentshow.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveBCVideoShowQueueResponse extends JsonHttpResponsedMessage {
    public com.baidu.live.talentshow.components.selector.c bxE;

    public LiveBCVideoShowQueueResponse() {
        super(1021224);
        this.bxE = new com.baidu.live.talentshow.components.selector.c();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.live.talentshow.b.b bVar = new com.baidu.live.talentshow.b.b();
            bVar.parserJson(optJSONObject);
            if (this.bxE.QV() > 0) {
                this.bxE.clearData();
            }
            this.bxE.aa(bVar.bvV);
            this.bxE.aa(bVar.bvU);
            this.bxE.QW();
        }
    }

    public List<com.baidu.live.talentshow.b.d> RV() {
        return this.bxE.QU();
    }
}
