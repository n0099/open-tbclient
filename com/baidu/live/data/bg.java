package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bg {
    public bj[] aBC;
    public bf aBD;
    public bi aBE;
    public bh aBF;
    public bm aBG;
    public bk aBH;
    public bj[] aBI;
    public bj[] aBJ;

    public bg(JSONObject jSONObject) {
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
                this.aBC = new bj[optJSONArray3.length()];
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    this.aBC[i] = new bj(1, optJSONArray3.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aBD = new bf(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aBE = new bi(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aBF = new bh(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aBG = new bm(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aBH = new bk(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray2 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aBI = new bj[optJSONArray2.length()];
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aBI[i2] = new bj(16, optJSONArray2.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray.length() > 0) {
                this.aBJ = new bj[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.aBJ[i3] = new bj(17, optJSONArray.optJSONObject(i3));
                }
            }
        }
    }
}
