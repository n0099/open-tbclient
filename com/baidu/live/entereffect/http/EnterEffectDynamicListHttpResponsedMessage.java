package com.baidu.live.entereffect.http;

import com.baidu.live.entereffect.a.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EnterEffectDynamicListHttpResponsedMessage extends JsonHttpResponsedMessage {
    private List<a> mDatas;

    public EnterEffectDynamicListHttpResponsedMessage(int i) {
        super(i);
    }

    public List<a> getDatas() {
        return this.mDatas;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021141) {
            this.mDatas = com.baidu.live.entereffect.a.pZ().i(jSONObject.optJSONArray("data"));
        }
    }
}
