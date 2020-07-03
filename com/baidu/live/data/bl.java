package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bl {
    public bo[] aDN;
    public bk aDO;
    public bn aDP;
    public bm aDQ;
    public br aDR;
    public bp aDS;
    public bo[] aDT;
    public bo[] aDU;

    public bl(JSONObject jSONObject) {
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
                this.aDN = new bo[optJSONArray3.length()];
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    this.aDN[i] = new bo(1, optJSONArray3.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aDO = new bk(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aDP = new bn(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aDQ = new bm(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aDR = new br(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aDS = new bp(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray2 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aDT = new bo[optJSONArray2.length()];
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.aDT[i2] = new bo(16, optJSONArray2.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray.length() > 0) {
                this.aDU = new bo[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.aDU[i3] = new bo(17, optJSONArray.optJSONObject(i3));
                }
            }
        }
    }
}
