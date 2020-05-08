package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private u aQF;

    public GetSuperCustomerInfoHttpResponseMessage() {
        super(1021186);
    }

    public u DV() {
        return this.aQF;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.aQF = new u();
            this.aQF.parseJson(jSONObject);
        }
    }
}
