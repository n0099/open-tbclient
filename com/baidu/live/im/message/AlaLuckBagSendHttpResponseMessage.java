package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLuckBagSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bdc;
    private long bdd;
    private String blc;
    private List<com.baidu.live.im.data.a> bmg;
    private List<com.baidu.live.im.data.a> bmh;
    private long bmi;
    private String bmj;
    private String bmk;
    private long mLogId;
    public String orderId;

    public AlaLuckBagSendHttpResponseMessage() {
        super(1021229);
        this.bdc = 0L;
    }

    public long Gq() {
        return this.bdc;
    }

    public long Gr() {
        return this.bdd;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public List<com.baidu.live.im.data.a> Ka() {
        return this.bmg;
    }

    public List<com.baidu.live.im.data.a> Kb() {
        return this.bmh;
    }

    public long Kc() {
        return this.bmi;
    }

    public String Kd() {
        return this.bmj;
    }

    public String Ke() {
        return this.blc;
    }

    public String Kf() {
        return this.bmk;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021229) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.bdc = optJSONObject.optLong("left_scores");
                this.bdd = optJSONObject.optLong("tdou_num");
                this.mLogId = optJSONObject.optLong("logid");
                this.orderId = optJSONObject.optString("order_id");
                this.bmk = optJSONObject.optString("lucky_bag_id");
                this.bmj = optJSONObject.optString("luckybag_image");
                this.bmi = optJSONObject.optInt("prize_total_value");
                this.blc = optJSONObject.optString("luckybag_name");
                JSONArray optJSONArray = optJSONObject.optJSONArray("prize_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.bmg = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        com.baidu.live.im.data.a T = com.baidu.live.im.data.a.T(optJSONArray.getJSONObject(i2));
                        if (T != null) {
                            this.bmg.add(T);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("surprise_list");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    this.bmh = new ArrayList(length2);
                    for (int i3 = 0; i3 < length2; i3++) {
                        com.baidu.live.im.data.a T2 = com.baidu.live.im.data.a.T(optJSONArray2.getJSONObject(i3));
                        if (T2 != null) {
                            this.bmh.add(T2);
                        }
                    }
                }
            }
        }
    }
}
