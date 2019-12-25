package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class as {
    public ay abA;
    public aw abB;
    public av[] abC;
    public av[] abw;
    public ar abx;
    public au aby;
    public at abz;

    public as(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            if (jSONObject.has("pay_barrage") && (optJSONArray2 = jSONObject.optJSONArray("pay_barrage")) != null) {
                this.abw = new av[optJSONArray2.length()];
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    this.abw[i] = new av(1, optJSONArray2.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.abx = new ar(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aby = new au(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.abz = new at(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.abA = new ay(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.abB = new aw(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.abC = new av[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.abC[i2] = new av(16, optJSONArray.optJSONObject(i2));
                }
            }
        }
    }
}
