package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cf {
    public int aQA;
    public List<a> aQB;
    public List<a> aQC;
    public int aQD;
    public int aQE;
    public long aQF;
    public int aQG;
    public String aQH;
    public String[] aQI;
    public long aQv;
    public int aQw;
    public int aQx;
    public int aQy;
    public int aQz;

    /* loaded from: classes4.dex */
    public static class a {
        public String aQJ;
        public String aQK;
    }

    public cf(JSONObject jSONObject) {
        int length;
        this.aQv = jSONObject.optLong("max_packet_amount");
        this.aQw = jSONObject.optInt("every_packet_min_amount");
        this.aQx = jSONObject.optInt("min_packet_num");
        this.aQy = jSONObject.optInt("max_packet_num");
        this.aQz = jSONObject.optInt("board_cast_amount");
        this.aQA = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aQB = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aQJ = jSONObject2.optString("condition_text");
                        aVar.aQK = jSONObject2.optString("condition_value");
                        this.aQB.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aQB = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aQC = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aQJ = jSONObject3.optString("condition_text");
                        aVar2.aQK = jSONObject3.optString("condition_value");
                        this.aQC.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aQC = null;
        }
        this.aQD = jSONObject.optInt("send_default_amount");
        this.aQE = jSONObject.optInt("send_default_num");
        this.aQF = jSONObject.optLong("large_amount_threshold");
        this.aQG = jSONObject.optInt("large_amount_packet_amount");
        this.aQH = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aQI = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aQI[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
