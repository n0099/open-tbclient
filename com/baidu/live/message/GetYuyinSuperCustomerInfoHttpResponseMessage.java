package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.ak;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetYuyinSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private ak brJ;

    public GetYuyinSuperCustomerInfoHttpResponseMessage() {
        super(1031064);
    }

    public ak PV() {
        return this.brJ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.brJ = new ak();
            this.brJ.parseJson(jSONObject);
        }
    }
}
