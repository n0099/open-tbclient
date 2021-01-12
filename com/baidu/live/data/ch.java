package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ch {
    public ck[] aOo;
    public cg aOp;
    public cj aOq;
    public ci aOr;
    public cn aOs;
    public cl aOt;
    public ck[] aOu;
    public ck[] aOv;
    public ck[] aOw;
    public String aOx;
    public String aOy;

    public ch(JSONObject jSONObject) {
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
                this.aOo = new ck[optJSONArray4.length()];
                for (int i = 0; i < optJSONArray4.length(); i++) {
                    this.aOo[i] = new ck(1, optJSONArray4.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aOp = new cg(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aOq = new cj(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aOr = new ci(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aOy = optJSONObject2.optString("rotary_table_h5_url");
                this.aOx = optJSONObject2.optString("rotary_table_icon");
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aOt = new cl(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray3 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aOu = new ck[optJSONArray3.length()];
                for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                    this.aOu[i2] = new ck(16, optJSONArray3.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray2 = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray2.length() > 0) {
                this.aOv = new ck[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.aOv[i3] = new ck(17, optJSONArray2.optJSONObject(i3));
                }
            }
            if (jSONObject.has("mysterious_man_barrage") && (optJSONArray = jSONObject.optJSONArray("mysterious_man_barrage")) != null && optJSONArray.length() > 0) {
                this.aOw = new ck[optJSONArray.length()];
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.aOw[i4] = new ck(18, optJSONArray.optJSONObject(i4));
                }
            }
        }
    }
}
