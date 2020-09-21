package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ca {
    public long aMG;
    public int aMH;
    public int aMI;
    public int aMJ;
    public int aMK;
    public int aML;
    public List<a> aMM;
    public List<a> aMN;
    public int aMO;
    public int aMP;
    public long aMQ;
    public int aMR;
    public String aMS;
    public String[] aMT;

    /* loaded from: classes4.dex */
    public static class a {
        public String aMU;
        public String aMV;
    }

    public ca(JSONObject jSONObject) {
        int length;
        this.aMG = jSONObject.optLong("max_packet_amount");
        this.aMH = jSONObject.optInt("every_packet_min_amount");
        this.aMI = jSONObject.optInt("min_packet_num");
        this.aMJ = jSONObject.optInt("max_packet_num");
        this.aMK = jSONObject.optInt("board_cast_amount");
        this.aML = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aMM = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aMU = jSONObject2.optString("condition_text");
                        aVar.aMV = jSONObject2.optString("condition_value");
                        this.aMM.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aMM = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aMN = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aMU = jSONObject3.optString("condition_text");
                        aVar2.aMV = jSONObject3.optString("condition_value");
                        this.aMN.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aMN = null;
        }
        this.aMO = jSONObject.optInt("send_default_amount");
        this.aMP = jSONObject.optInt("send_default_num");
        this.aMQ = jSONObject.optLong("large_amount_threshold");
        this.aMR = jSONObject.optInt("large_amount_packet_amount");
        this.aMS = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aMT = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aMT[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
