package com.baidu.live.message;

import com.baidu.live.data.y;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetVideoGoodsListHttpResponseMessage extends JsonHttpResponsedMessage {
    public List<y> akk;
    public int count;
    public long liveId;

    public GetVideoGoodsListHttpResponseMessage() {
        super(1021144);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.akk = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("good_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        y yVar = new y();
                        yVar.parseJson(jSONObject2);
                        this.akk.add(yVar);
                    }
                }
                this.count = optJSONObject.optInt("count");
            }
        }
    }
}
