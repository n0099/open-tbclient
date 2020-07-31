package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bq {
    public long aFN;
    public int aFO;
    public int aFP;
    public int aFQ;
    public int aFR;
    public int aFS;
    public List<a> aFT;
    public int aFU;
    public int aFV;
    public long aFW;
    public int aFX;
    public String aFY;
    public String[] aFZ;

    /* loaded from: classes4.dex */
    public static class a {
        public String aGa;
        public String aGb;
    }

    public bq(JSONObject jSONObject) {
        int length;
        this.aFN = jSONObject.optLong("max_packet_amount");
        this.aFO = jSONObject.optInt("every_packet_min_amount");
        this.aFP = jSONObject.optInt("min_packet_num");
        this.aFQ = jSONObject.optInt("max_packet_num");
        this.aFR = jSONObject.optInt("board_cast_amount");
        this.aFS = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.aFT = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aGa = jSONObject2.optString("condition_text");
                        aVar.aGb = jSONObject2.optString("condition_value");
                        this.aFT.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aFT = null;
        }
        this.aFU = jSONObject.optInt("send_default_amount");
        this.aFV = jSONObject.optInt("send_default_num");
        this.aFW = jSONObject.optLong("large_amount_threshold");
        this.aFX = jSONObject.optInt("large_amount_packet_amount");
        this.aFY = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray2 != null && (length = optJSONArray2.length()) > 0) {
            this.aFZ = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.aFZ[i2] = optJSONArray2.optString(i2);
            }
        }
    }
}
