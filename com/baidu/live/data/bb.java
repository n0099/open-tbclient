package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bb {
    public be[] awt;
    public ba awu;
    public bd awv;
    public bc aww;
    public bh awx;
    public bf awy;
    public be[] awz;

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
                this.awt = new be[optJSONArray2.length()];
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    this.awt[i] = new be(1, optJSONArray2.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.awu = new ba(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.awv = new bd(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aww = new bc(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.awx = new bh(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.awy = new bf(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.awz = new be[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.awz[i2] = new be(16, optJSONArray.optJSONObject(i2));
                }
            }
        }
    }
}
