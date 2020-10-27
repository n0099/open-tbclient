package com.baidu.live.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tieba.yuyinala.c.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFeedBackReasonListResponse extends JsonHttpResponsedMessage {
    private List<a> mList;

    public AlaFeedBackReasonListResponse() {
        super(1031040);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0 && (optJSONArray = optJSONObject.optJSONArray("tipoff_type")) != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            this.mList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                a aVar = new a();
                aVar.parseJson(optJSONArray.optJSONObject(i2));
                this.mList.add(aVar);
            }
        }
    }

    public List<a> RN() {
        return this.mList;
    }
}
