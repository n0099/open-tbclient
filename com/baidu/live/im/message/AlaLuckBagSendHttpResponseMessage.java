package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLuckBagSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bhM;
    private long bhN;
    private String bpV;
    private List<com.baidu.live.im.data.a> brh;
    private List<com.baidu.live.im.data.a> bri;
    private long brj;
    private String brk;
    private String brl;
    private long mLogId;
    public String orderId;

    public AlaLuckBagSendHttpResponseMessage() {
        super(1021229);
        this.bhM = 0L;
    }

    public long HJ() {
        return this.bhM;
    }

    public long HK() {
        return this.bhN;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public List<com.baidu.live.im.data.a> LC() {
        return this.brh;
    }

    public List<com.baidu.live.im.data.a> LD() {
        return this.bri;
    }

    public long LE() {
        return this.brj;
    }

    public String LF() {
        return this.brk;
    }

    public String LG() {
        return this.bpV;
    }

    public String LH() {
        return this.brl;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021229) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.bhM = optJSONObject.optLong("left_scores");
                this.bhN = optJSONObject.optLong("tdou_num");
                this.mLogId = optJSONObject.optLong("logid");
                this.orderId = optJSONObject.optString("order_id");
                this.brl = optJSONObject.optString("lucky_bag_id");
                this.brk = optJSONObject.optString("luckybag_image");
                this.brj = optJSONObject.optInt("prize_total_value");
                this.bpV = optJSONObject.optString("luckybag_name");
                JSONArray optJSONArray = optJSONObject.optJSONArray("prize_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.brh = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        com.baidu.live.im.data.a V = com.baidu.live.im.data.a.V(optJSONArray.getJSONObject(i2));
                        if (V != null) {
                            this.brh.add(V);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("surprise_list");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    this.bri = new ArrayList(length2);
                    for (int i3 = 0; i3 < length2; i3++) {
                        com.baidu.live.im.data.a V2 = com.baidu.live.im.data.a.V(optJSONArray2.getJSONObject(i3));
                        if (V2 != null) {
                            this.bri.add(V2);
                        }
                    }
                }
            }
        }
    }
}
