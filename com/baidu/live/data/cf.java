package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cf {
    public ci[] aSg;
    public ce aSh;
    public ch aSi;
    public cg aSj;
    public cl aSk;
    public cj aSl;
    public ci[] aSm;
    public ci[] aSn;

    public cf(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONArray optJSONArray3;
        if (jSONObject != null) {
            if (jSONObject.has("pay_barrage") && (optJSONArray3 = jSONObject.optJSONArray("pay_barrage")) != null) {
                this.aSg = new ci[optJSONArray3.length()];
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    this.aSg[i] = new ci(1, optJSONArray3.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aSh = new ce(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aSi = new ch(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aSj = new cg(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aSk = new cl(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aSl = new cj(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray2 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aSm = new ci[optJSONArray2.length()];
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aSm[i2] = new ci(16, optJSONArray2.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray.length() > 0) {
                this.aSn = new ci[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.aSn[i3] = new ci(17, optJSONArray.optJSONObject(i3));
                }
            }
        }
    }
}
