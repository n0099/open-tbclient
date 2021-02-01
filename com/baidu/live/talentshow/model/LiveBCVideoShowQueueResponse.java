package com.baidu.live.talentshow.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveBCVideoShowQueueResponse extends JsonHttpResponsedMessage {
    public com.baidu.live.talentshow.components.selector.c bGx;

    public LiveBCVideoShowQueueResponse() {
        super(1021224);
        this.bGx = new com.baidu.live.talentshow.components.selector.c();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.baidu.live.talentshow.b.b bVar = new com.baidu.live.talentshow.b.b();
            bVar.parserJson(optJSONObject);
            if (this.bGx.Sn() > 0) {
                this.bGx.clearData();
            }
            this.bGx.ae(bVar.bEM);
            this.bGx.ae(bVar.bEL);
            this.bGx.So();
        }
    }

    public List<com.baidu.live.talentshow.b.d> Tm() {
        return this.bGx.Sm();
    }
}
