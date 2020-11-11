package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ch {
    public int aRA;
    public int aRB;
    public int aRC;
    public List<a> aRD;
    public List<a> aRE;
    public int aRF;
    public int aRG;
    public long aRH;
    public int aRI;
    public String aRJ;
    public String[] aRK;
    public long aRx;
    public int aRy;
    public int aRz;

    /* loaded from: classes4.dex */
    public static class a {
        public String aRL;
        public String aRM;
    }

    public ch(JSONObject jSONObject) {
        int length;
        this.aRx = jSONObject.optLong("max_packet_amount");
        this.aRy = jSONObject.optInt("every_packet_min_amount");
        this.aRz = jSONObject.optInt("min_packet_num");
        this.aRA = jSONObject.optInt("max_packet_num");
        this.aRB = jSONObject.optInt("board_cast_amount");
        this.aRC = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aRD = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aRL = jSONObject2.optString("condition_text");
                        aVar.aRM = jSONObject2.optString("condition_value");
                        this.aRD.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aRD = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aRE = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aRL = jSONObject3.optString("condition_text");
                        aVar2.aRM = jSONObject3.optString("condition_value");
                        this.aRE.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aRE = null;
        }
        this.aRF = jSONObject.optInt("send_default_amount");
        this.aRG = jSONObject.optInt("send_default_num");
        this.aRH = jSONObject.optLong("large_amount_threshold");
        this.aRI = jSONObject.optInt("large_amount_packet_amount");
        this.aRJ = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aRK = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aRK[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
