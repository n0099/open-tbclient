package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ch {
    public ck[] aTb;
    public cg aTc;
    public cj aTd;
    public ci aTe;
    public cn aTf;
    public cl aTg;
    public ck[] aTh;
    public ck[] aTi;
    public ck[] aTj;
    public String aTk;
    public String aTl;

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
                this.aTb = new ck[optJSONArray4.length()];
                for (int i = 0; i < optJSONArray4.length(); i++) {
                    this.aTb[i] = new ck(1, optJSONArray4.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.aTc = new cg(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.aTd = new cj(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.aTe = new ci(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aTl = optJSONObject2.optString("rotary_table_h5_url");
                this.aTk = optJSONObject2.optString("rotary_table_icon");
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aTg = new cl(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray3 = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aTh = new ck[optJSONArray3.length()];
                for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                    this.aTh[i2] = new ck(16, optJSONArray3.optJSONObject(i2));
                }
            }
            if (jSONObject.has("noble_barrage") && (optJSONArray2 = jSONObject.optJSONArray("noble_barrage")) != null && optJSONArray2.length() > 0) {
                this.aTi = new ck[optJSONArray2.length()];
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.aTi[i3] = new ck(17, optJSONArray2.optJSONObject(i3));
                }
            }
            if (jSONObject.has("mysterious_man_barrage") && (optJSONArray = jSONObject.optJSONArray("mysterious_man_barrage")) != null && optJSONArray.length() > 0) {
                this.aTj = new ck[optJSONArray.length()];
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.aTj[i4] = new ck(18, optJSONArray.optJSONObject(i4));
                }
            }
        }
    }
}
