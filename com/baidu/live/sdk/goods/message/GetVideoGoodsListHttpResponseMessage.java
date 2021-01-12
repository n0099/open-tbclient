package com.baidu.live.sdk.goods.message;

import android.text.TextUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetVideoGoodsListHttpResponseMessage extends JsonHttpResponsedMessage {
    public List<com.baidu.live.sdk.goods.a.a> bwe;
    public String bwf;
    public ArrayList<String> bwg;
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
            this.bwe = new ArrayList();
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject != null && getError() == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("good_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        com.baidu.live.sdk.goods.a.a aVar = new com.baidu.live.sdk.goods.a.a();
                        aVar.parseJson(jSONObject2);
                        this.bwe.add(aVar);
                    }
                }
                this.count = optJSONObject.optInt("count");
                this.bwf = optJSONObject.optString("pre_download_swan");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("pre_download_appkeys");
                if (optJSONArray2 != null) {
                    this.bwg = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        String optString = optJSONArray2.optString(i3);
                        if (!TextUtils.isEmpty(optString)) {
                            this.bwg.add(optString);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }
}
