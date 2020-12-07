package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLuckBagSendHttpResponseMessage extends JsonHttpResponsedMessage {
    private long bgl;
    private long bgm;
    private String bog;
    private List<com.baidu.live.im.data.a> bpl;
    private List<com.baidu.live.im.data.a> bpm;
    private long bpn;
    private String bpo;
    private String bpp;
    private long mLogId;
    public String orderId;

    public AlaLuckBagSendHttpResponseMessage() {
        super(1021229);
        this.bgl = 0L;
    }

    public long KK() {
        return this.bgl;
    }

    public long KL() {
        return this.bgm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public long getLogId() {
        return this.mLogId;
    }

    public List<com.baidu.live.im.data.a> Op() {
        return this.bpl;
    }

    public List<com.baidu.live.im.data.a> Oq() {
        return this.bpm;
    }

    public long Or() {
        return this.bpn;
    }

    public String Os() {
        return this.bpo;
    }

    public String Ot() {
        return this.bog;
    }

    public String Ou() {
        return this.bpp;
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
                this.bpp = optJSONObject.optString("lucky_bag_id");
                this.bpo = optJSONObject.optString("luckybag_image");
                this.bpn = optJSONObject.optInt("prize_total_value");
                this.bog = optJSONObject.optString("luckybag_name");
                JSONArray optJSONArray = optJSONObject.optJSONArray("prize_list");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.bpl = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        com.baidu.live.im.data.a L = com.baidu.live.im.data.a.L(optJSONArray.getJSONObject(i2));
                        if (L != null) {
                            this.bpl.add(L);
                        }
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("surprise_list");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    this.bpm = new ArrayList(length2);
                    for (int i3 = 0; i3 < length2; i3++) {
                        com.baidu.live.im.data.a L2 = com.baidu.live.im.data.a.L(optJSONArray2.getJSONObject(i3));
                        if (L2 != null) {
                            this.bpm.add(L2);
                        }
                    }
                }
            }
        }
    }
}
