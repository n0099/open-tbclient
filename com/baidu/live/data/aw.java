package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aw {
    public az[] abH;
    public av abI;
    public ay abJ;
    public ax abK;
    public bc abL;
    public ba abM;
    public az[] abN;

    public aw(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            if (jSONObject.has("pay_barrage") && (optJSONArray2 = jSONObject.optJSONArray("pay_barrage")) != null) {
                this.abH = new az[optJSONArray2.length()];
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    this.abH[i] = new az(1, optJSONArray2.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.abI = new av(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.abJ = new ay(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.abK = new ax(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.abL = new bc(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.abM = new ba(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.abN = new az[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.abN[i2] = new az(16, optJSONArray.optJSONObject(i2));
                }
            }
        }
    }
}
