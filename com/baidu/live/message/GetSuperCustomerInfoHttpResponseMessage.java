package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.aa;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private aa beS;

    public GetSuperCustomerInfoHttpResponseMessage() {
        super(1021186);
    }

    public aa LL() {
        return this.beS;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.beS = new aa();
            this.beS.parseJson(jSONObject);
        }
    }
}
