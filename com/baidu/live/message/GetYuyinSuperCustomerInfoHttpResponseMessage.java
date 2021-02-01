package com.baidu.live.message;

import android.util.Log;
import com.baidu.live.data.aq;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetYuyinSuperCustomerInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private aq bvg;

    public GetYuyinSuperCustomerInfoHttpResponseMessage() {
        super(1031064);
    }

    public aq Ox() {
        return this.bvg;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.d("SuperCustomerHelper", "GetSuperCustomerInfoHttpResponseMessage retJson:" + jSONObject.toString());
            this.bvg = new aq();
            this.bvg.parseJson(jSONObject);
        }
    }
}
