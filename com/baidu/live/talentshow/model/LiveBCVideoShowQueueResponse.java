package com.baidu.live.talentshow.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveBCVideoShowQueueResponse extends JsonHttpResponsedMessage {
    public com.baidu.live.talentshow.components.selector.c bzp;

    public LiveBCVideoShowQueueResponse() {
        super(1021224);
        this.bzp = new com.baidu.live.talentshow.components.selector.c();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.live.talentshow.b.b bVar = new com.baidu.live.talentshow.b.b();
            bVar.parserJson(optJSONObject);
            if (this.bzp.RE() > 0) {
                this.bzp.clearData();
            }
            this.bzp.aa(bVar.bxG);
            this.bzp.aa(bVar.bxF);
            this.bzp.RF();
        }
    }

    public List<com.baidu.live.talentshow.b.d> SE() {
        return this.bzp.RD();
    }
}
