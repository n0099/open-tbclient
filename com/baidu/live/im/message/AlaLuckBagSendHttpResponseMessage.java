package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLuckBagSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bhT;
    private long bhU;
    private String bpP;
    private List<com.baidu.live.im.data.a> bqT;
    private List<com.baidu.live.im.data.a> bqU;
    private long bqV;
    private String bqW;
    private String bqX;
    private long mLogId;
    public String orderId;

    public AlaLuckBagSendHttpResponseMessage() {
        super(1021229);
        this.bhT = 0L;
    }

    public long Kl() {
        return this.bhT;
    }

    public long Km() {
        return this.bhU;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public List<com.baidu.live.im.data.a> NV() {
        return this.bqT;
    }

    public List<com.baidu.live.im.data.a> NW() {
        return this.bqU;
    }

    public long NX() {
        return this.bqV;
    }

    public String NY() {
        return this.bqW;
    }

    public String NZ() {
        return this.bpP;
    }

    public String Oa() {
        return this.bqX;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021229) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.bhT = optJSONObject.optLong("left_scores");
                this.bhU = optJSONObject.optLong("tdou_num");
                this.mLogId = optJSONObject.optLong("logid");
                this.orderId = optJSONObject.optString("order_id");
                this.bqX = optJSONObject.optString("lucky_bag_id");
                this.bqW = optJSONObject.optString("luckybag_image");
                this.bqV = optJSONObject.optInt("prize_total_value");
                this.bpP = optJSONObject.optString("luckybag_name");
                JSONArray optJSONArray = optJSONObject.optJSONArray("prize_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.bqT = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        com.baidu.live.im.data.a T = com.baidu.live.im.data.a.T(optJSONArray.getJSONObject(i2));
                        if (T != null) {
                            this.bqT.add(T);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("surprise_list");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    this.bqU = new ArrayList(length2);
                    for (int i3 = 0; i3 < length2; i3++) {
                        com.baidu.live.im.data.a T2 = com.baidu.live.im.data.a.T(optJSONArray2.getJSONObject(i3));
                        if (T2 != null) {
                            this.bqU.add(T2);
                        }
                    }
                }
            }
        }
    }
}
