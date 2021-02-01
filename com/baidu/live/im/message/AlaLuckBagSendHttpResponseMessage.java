package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLuckBagSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bgl;
    private long bgm;
    private String bov;
    private List<com.baidu.live.im.data.a> bpH;
    private List<com.baidu.live.im.data.a> bpI;
    private long bpJ;
    private String bpK;
    private String bpL;
    private long mLogId;
    public String orderId;

    public AlaLuckBagSendHttpResponseMessage() {
        super(1021229);
        this.bgl = 0L;
    }

    public long HG() {
        return this.bgl;
    }

    public long HH() {
        return this.bgm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public List<com.baidu.live.im.data.a> Lz() {
        return this.bpH;
    }

    public List<com.baidu.live.im.data.a> LA() {
        return this.bpI;
    }

    public long LB() {
        return this.bpJ;
    }

    public String LC() {
        return this.bpK;
    }

    public String LD() {
        return this.bov;
    }

    public String LE() {
        return this.bpL;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021229) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.bgl = optJSONObject.optLong("left_scores");
                this.bgm = optJSONObject.optLong("tdou_num");
                this.mLogId = optJSONObject.optLong("logid");
                this.orderId = optJSONObject.optString("order_id");
                this.bpL = optJSONObject.optString("lucky_bag_id");
                this.bpK = optJSONObject.optString("luckybag_image");
                this.bpJ = optJSONObject.optInt("prize_total_value");
                this.bov = optJSONObject.optString("luckybag_name");
                JSONArray optJSONArray = optJSONObject.optJSONArray("prize_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.bpH = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        com.baidu.live.im.data.a T = com.baidu.live.im.data.a.T(optJSONArray.getJSONObject(i2));
                        if (T != null) {
                            this.bpH.add(T);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("surprise_list");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    this.bpI = new ArrayList(length2);
                    for (int i3 = 0; i3 < length2; i3++) {
                        com.baidu.live.im.data.a T2 = com.baidu.live.im.data.a.T(optJSONArray2.getJSONObject(i3));
                        if (T2 != null) {
                            this.bpI.add(T2);
                        }
                    }
                }
            }
        }
    }
}
