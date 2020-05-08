package com.baidu.live.message;

import com.baidu.live.data.aj;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetVideoGoodsListHttpResponseMessage extends JsonHttpResponsedMessage {
    private long aGH;
    public List<aj> aQH;
    public int count;
    public long liveId;

    public GetVideoGoodsListHttpResponseMessage() {
        super(1021144);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.aGH = jSONObject.optLong("logid");
            this.aQH = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("good_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        aj ajVar = new aj();
                        ajVar.parseJson(jSONObject2);
                        this.aQH.add(ajVar);
                    }
                }
                this.count = optJSONObject.optInt("count");
            }
        }
    }

    public long zk() {
        return this.aGH;
    }
}
