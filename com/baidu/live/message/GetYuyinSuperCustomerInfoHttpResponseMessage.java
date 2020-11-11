package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.aj;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetYuyinSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private aj bom;

    public GetYuyinSuperCustomerInfoHttpResponseMessage() {
        super(1031064);
    }

    public aj Ol() {
        return this.bom;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.bom = new aj();
            this.bom.parseJson(jSONObject);
        }
    }
}
