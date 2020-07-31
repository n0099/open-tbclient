package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.y;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private y aZy;

    public GetSuperCustomerInfoHttpResponseMessage() {
        super(1021186);
    }

    public y FX() {
        return this.aZy;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.aZy = new y();
            this.aZy.parseJson(jSONObject);
        }
    }
}
