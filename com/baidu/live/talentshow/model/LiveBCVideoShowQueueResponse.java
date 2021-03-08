package com.baidu.live.talentshow.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveBCVideoShowQueueResponse extends JsonHttpResponsedMessage {
    public com.baidu.live.talentshow.components.selector.c bHX;

    public LiveBCVideoShowQueueResponse() {
        super(1021224);
        this.bHX = new com.baidu.live.talentshow.components.selector.c();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.live.talentshow.b.b bVar = new com.baidu.live.talentshow.b.b();
            bVar.parserJson(optJSONObject);
            if (this.bHX.Sq() > 0) {
                this.bHX.clearData();
            }
            this.bHX.ae(bVar.bGm);
            this.bHX.ae(bVar.bGl);
            this.bHX.Sr();
        }
    }

    public List<com.baidu.live.talentshow.b.d> Tp() {
        return this.bHX.Sp();
    }
}
