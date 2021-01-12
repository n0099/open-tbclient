package com.baidu.live.talentshow.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveBCVideoShowQueueResponse extends JsonHttpResponsedMessage {
    public com.baidu.live.talentshow.components.selector.c bCN;

    public LiveBCVideoShowQueueResponse() {
        super(1021224);
        this.bCN = new com.baidu.live.talentshow.components.selector.c();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.live.talentshow.b.b bVar = new com.baidu.live.talentshow.b.b();
            bVar.parserJson(optJSONObject);
            if (this.bCN.QD() > 0) {
                this.bCN.clearData();
            }
            this.bCN.ad(bVar.bBg);
            this.bCN.ad(bVar.bBf);
            this.bCN.QE();
        }
    }

    public List<com.baidu.live.talentshow.b.d> RF() {
        return this.bCN.QC();
    }
}
