package com.baidu.live.sdk.goods.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetVideoGoodsListHttpResponseMessage extends JsonHttpResponsedMessage {
    public List<com.baidu.live.sdk.goods.a.a> blM;
    public int count;
    private long mLogId;

    public GetVideoGoodsListHttpResponseMessage() {
        super(1021144);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.mLogId = jSONObject.optLong("logid");
            this.blM = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("good_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        com.baidu.live.sdk.goods.a.a aVar = new com.baidu.live.sdk.goods.a.a();
                        aVar.parseJson(jSONObject2);
                        this.blM.add(aVar);
                    }
                }
                this.count = optJSONObject.optInt("count");
            }
        }
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }
}
