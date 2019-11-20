package com.baidu.live.data;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class al {
    public ao[] Uo;
    public ak Up;
    public an Uq;
    public am Ur;
    public aq Us;

    public al(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONArray optJSONArray;
        if (jSONObject != null) {
            if (jSONObject.has("pay_barrage") && (optJSONArray = jSONObject.optJSONArray("pay_barrage")) != null) {
                this.Uo = new ao[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.Uo[i] = new ao(optJSONArray.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject4 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.Up = new ak(optJSONObject4);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject3 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.Uq = new an(optJSONObject3);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject2 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.Ur = new am(optJSONObject2);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject = jSONObject.optJSONObject("rotary_table")) != null) {
                this.Us = new aq(optJSONObject);
            }
        }
    }
}
