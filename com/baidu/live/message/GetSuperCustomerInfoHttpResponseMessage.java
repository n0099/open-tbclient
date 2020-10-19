package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.af;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private af blx;

    public GetSuperCustomerInfoHttpResponseMessage() {
        super(1021186);
    }

    public af Nr() {
        return this.blx;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.blx = new af();
            this.blx.parseJson(jSONObject);
        }
    }
}
