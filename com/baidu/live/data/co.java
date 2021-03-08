package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class co {
    public cr[] aSR;
    public cn aSS;
    public cq aST;
    public cp aSU;
    public cs aSV;
    public cr[] aSW;
    public cr[] aSX;
    public cr[] aSY;
    public String aSZ;
    public String aTa;

    public co(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONArray optJSONArray4;
        if (jSONObject != null) {
            if (jSONObject.has("pay_barrage") && (optJSONArray4 = jSONObject.optJSONArray("pay_barrage")) != null) {
                this.aSR = new cr[optJSONArray4.length()];
                for (int i = 0; i < optJSONArray4.length(); i++) {
                    this.aSR[i] = new cr(1, optJSONArray4.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aSS = new cn(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aST = new cq(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aSU = new cp(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aTa = optJSONObject2.optString("rotary_table_h5_url");
                this.aSZ = optJSONObject2.optString("rotary_table_icon");
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aSV = new cs(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray3 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aSW = new cr[optJSONArray3.length()];
                for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                    this.aSW[i2] = new cr(16, optJSONArray3.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray2 = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray2.length() > 0) {
                this.aSX = new cr[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.aSX[i3] = new cr(17, optJSONArray2.optJSONObject(i3));
                }
            }
            if (jSONObject.has("mysterious_man_barrage") && (optJSONArray = jSONObject.optJSONArray("mysterious_man_barrage")) != null && optJSONArray.length() > 0) {
                this.aSY = new cr[optJSONArray.length()];
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.aSY[i4] = new cr(18, optJSONArray.optJSONObject(i4));
                }
            }
        }
    }
}
