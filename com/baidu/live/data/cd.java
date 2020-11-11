package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cd {
    public cg[] aQP;
    public cc aQQ;
    public cf aQR;
    public ce aQS;
    public cj aQT;
    public ch aQU;
    public cg[] aQV;
    public cg[] aQW;

    public cd(JSONObject jSONObject) {
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
                this.aQP = new cg[optJSONArray3.length()];
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    this.aQP[i] = new cg(1, optJSONArray3.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aQQ = new cc(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aQR = new cf(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aQS = new ce(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aQT = new cj(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aQU = new ch(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray2 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aQV = new cg[optJSONArray2.length()];
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aQV[i2] = new cg(16, optJSONArray2.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray.length() > 0) {
                this.aQW = new cg[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.aQW[i3] = new cg(17, optJSONArray.optJSONObject(i3));
                }
            }
        }
    }
}
