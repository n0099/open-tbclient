package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bb {
    public be[] awn;
    public ba awo;
    public bd awp;
    public bc awq;
    public bh awr;
    public bf aws;
    public be[] awt;

    public bb(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            if (jSONObject.has("pay_barrage") && (optJSONArray2 = jSONObject.optJSONArray("pay_barrage")) != null) {
                this.awn = new be[optJSONArray2.length()];
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    this.awn[i] = new be(1, optJSONArray2.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.awo = new ba(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.awp = new bd(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.awq = new bc(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.awr = new bh(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aws = new bf(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.awt = new be[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.awt[i2] = new be(16, optJSONArray.optJSONObject(i2));
                }
            }
        }
    }
}
