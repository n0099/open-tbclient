package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private u aQA;

    public GetSuperCustomerInfoHttpResponseMessage() {
        super(1021186);
    }

    public u DW() {
        return this.aQA;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.aQA = new u();
            this.aQA.parseJson(jSONObject);
        }
    }
}
