package com.baidu.live.audiolive;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class NewFrameHttpResponseMessage extends JsonHttpResponsedMessage {
    private int aEA;
    private JSONArray aEB;
    private int aEy;
    private int aEz;

    public NewFrameHttpResponseMessage() {
        super(1031089);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031089 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aEy = optJSONObject.optInt("unshow_num", 0);
            this.aEz = optJSONObject.optInt("unotice_num", 0);
            this.aEA = optJSONObject.optInt("bubble_num", 0);
            this.aEB = optJSONObject.optJSONArray("info_list");
        }
    }

    public int zL() {
        return this.aEy;
    }

    public int zM() {
        return this.aEA;
    }
}
