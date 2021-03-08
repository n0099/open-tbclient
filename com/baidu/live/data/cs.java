package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cs {
    public long aTB;
    public int aTC;
    public int aTD;
    public int aTE;
    public int aTF;
    public int aTG;
    public List<a> aTH;
    public List<a> aTI;
    public int aTJ;
    public int aTK;
    public long aTL;
    public int aTM;
    public String aTN;
    public String[] aTO;

    /* loaded from: classes10.dex */
    public static class a {
        public String aTP;
        public String aTQ;
    }

    public cs(JSONObject jSONObject) {
        int length;
        this.aTB = jSONObject.optLong("max_packet_amount");
        this.aTC = jSONObject.optInt("every_packet_min_amount");
        this.aTD = jSONObject.optInt("min_packet_num");
        this.aTE = jSONObject.optInt("max_packet_num");
        this.aTF = jSONObject.optInt("board_cast_amount");
        this.aTG = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aTH = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aTP = jSONObject2.optString("condition_text");
                        aVar.aTQ = jSONObject2.optString("condition_value");
                        this.aTH.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aTH = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aTI = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aTP = jSONObject3.optString("condition_text");
                        aVar2.aTQ = jSONObject3.optString("condition_value");
                        this.aTI.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aTI = null;
        }
        this.aTJ = jSONObject.optInt("send_default_amount");
        this.aTK = jSONObject.optInt("send_default_num");
        this.aTL = jSONObject.optLong("large_amount_threshold");
        this.aTM = jSONObject.optInt("large_amount_packet_amount");
        this.aTN = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aTO = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aTO[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
