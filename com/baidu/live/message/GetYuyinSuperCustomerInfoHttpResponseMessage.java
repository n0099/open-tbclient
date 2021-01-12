package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.am;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetYuyinSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private am brD;

    public GetYuyinSuperCustomerInfoHttpResponseMessage() {
        super(1031064);
    }

    public am MZ() {
        return this.brD;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.brD = new am();
            this.brD.parseJson(jSONObject);
        }
    }
}
