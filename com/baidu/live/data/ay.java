package com.baidu.live.data;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ay {
    public bb[] adW;
    public ax adX;
    public ba adY;
    public az adZ;
    public be aea;
    public bc aeb;
    public bb[] aec;

    public ay(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            if (jSONObject.has("pay_barrage") && (optJSONArray2 = jSONObject.optJSONArray("pay_barrage")) != null) {
                this.adW = new bb[optJSONArray2.length()];
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    this.adW[i] = new bb(1, optJSONArray2.optJSONObject(i));
                }
            }
            if (jSONObject.has("cash_gift") && (optJSONObject5 = jSONObject.optJSONObject("cash_gift")) != null) {
                this.adX = new ax(optJSONObject5);
            }
            if (jSONObject.has("flower_guide") && (optJSONObject4 = jSONObject.optJSONObject("flower_guide")) != null) {
                this.adY = new ba(optJSONObject4);
            }
            if (jSONObject.has("first_recharge") && (optJSONObject3 = jSONObject.optJSONObject("first_recharge")) != null) {
                this.adZ = new az(optJSONObject3);
            }
            if (jSONObject.has("rotary_table") && (optJSONObject2 = jSONObject.optJSONObject("rotary_table")) != null) {
                this.aea = new be(optJSONObject2);
            }
            if (jSONObject.has("red_packet") && (optJSONObject = jSONObject.optJSONObject("red_packet")) != null) {
                this.aeb = new bc(optJSONObject);
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && jSONObject.has("guard_barrage") && (optJSONArray = jSONObject.optJSONArray("guard_barrage")) != null) {
                this.aec = new bb[optJSONArray.length()];
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.aec[i2] = new bb(16, optJSONArray.optJSONObject(i2));
                }
            }
        }
    }
}
