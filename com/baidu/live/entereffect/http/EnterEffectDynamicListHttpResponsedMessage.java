package com.baidu.live.entereffect.http;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class EnterEffectDynamicListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private List<com.baidu.live.entereffect.a.a> mDatas;

    public EnterEffectDynamicListHttpResponsedMessage(int i) {
        super(i);
    }

    public List<com.baidu.live.entereffect.a.a> getDatas() {
        return this.mDatas;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021141) {
            this.mDatas = com.baidu.live.entereffect.a.CY().i(jSONObject.optJSONArray("data"));
        }
    }

    public boolean Dp() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
