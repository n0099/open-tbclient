package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bm {
    public bp[] aFh;
    public bl aFi;
    public bo aFj;
    public bn aFk;
    public bs aFl;
    public bq aFm;
    public bp[] aFn;
    public bp[] aFo;

    public bm(JSONObject jSONObject) {
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
                this.aFh = new bp[optJSONArray3.length()];
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    this.aFh[i] = new bp(1, optJSONArray3.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aFi = new bl(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aFj = new bo(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aFk = new bn(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aFl = new bs(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aFm = new bq(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray2 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aFn = new bp[optJSONArray2.length()];
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aFn[i2] = new bp(16, optJSONArray2.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray.length() > 0) {
                this.aFo = new bp[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.aFo[i3] = new bp(17, optJSONArray.optJSONObject(i3));
                }
            }
        }
    }
}
