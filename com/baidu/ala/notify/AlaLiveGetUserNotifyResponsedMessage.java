package com.baidu.ala.notify;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveGetUserNotifyResponsedMessage extends JsonHttpResponsedMessage {
    private ArrayList<AlaLiveUserNotifyData> dataList;
    private int notify_count;

    public AlaLiveGetUserNotifyResponsedMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.notify_count = optJSONObject.optInt("notify_count");
            JSONArray optJSONArray = optJSONObject.optJSONArray("notify_list");
            if (optJSONArray != null) {
                this.dataList = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    if (optJSONArray.optJSONObject(i2) != null) {
                        AlaLiveUserNotifyData alaLiveUserNotifyData = new AlaLiveUserNotifyData();
                        alaLiveUserNotifyData.parseJson(optJSONArray.optJSONObject(i2));
                        this.dataList.add(alaLiveUserNotifyData);
                    }
                }
            }
        }
    }

    public ArrayList<AlaLiveUserNotifyData> getDataList() {
        return this.dataList;
    }

    public int getNofifyCount() {
        return this.notify_count;
    }
}
