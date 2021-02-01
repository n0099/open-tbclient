package com.baidu.live.audiolive;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class NewFrameHttpResponseMessage extends JsonHttpResponsedMessage {
    private int aCY;
    private int aCZ;
    private int aDa;
    private JSONArray aDb;

    public NewFrameHttpResponseMessage() {
        super(1031089);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031089 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aCY = optJSONObject.optInt("unshow_num", 0);
            this.aCZ = optJSONObject.optInt("unotice_num", 0);
            this.aDa = optJSONObject.optInt("bubble_num", 0);
            this.aDb = optJSONObject.optJSONArray("info_list");
        }
    }

    public int zI() {
        return this.aCY;
    }

    public int zJ() {
        return this.aDa;
    }
}
