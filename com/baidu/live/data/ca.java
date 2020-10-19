package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ca {
    public long aPL;
    public int aPM;
    public int aPN;
    public int aPO;
    public int aPP;
    public int aPQ;
    public List<a> aPR;
    public List<a> aPS;
    public int aPT;
    public int aPU;
    public long aPV;
    public int aPW;
    public String aPX;
    public String[] aPY;

    /* loaded from: classes4.dex */
    public static class a {
        public String aPZ;
        public String aQa;
    }

    public ca(JSONObject jSONObject) {
        int length;
        this.aPL = jSONObject.optLong("max_packet_amount");
        this.aPM = jSONObject.optInt("every_packet_min_amount");
        this.aPN = jSONObject.optInt("min_packet_num");
        this.aPO = jSONObject.optInt("max_packet_num");
        this.aPP = jSONObject.optInt("board_cast_amount");
        this.aPQ = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aPR = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aPZ = jSONObject2.optString("condition_text");
                        aVar.aQa = jSONObject2.optString("condition_value");
                        this.aPR.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aPR = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aPS = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aPZ = jSONObject3.optString("condition_text");
                        aVar2.aQa = jSONObject3.optString("condition_value");
                        this.aPS.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aPS = null;
        }
        this.aPT = jSONObject.optInt("send_default_amount");
        this.aPU = jSONObject.optInt("send_default_num");
        this.aPV = jSONObject.optLong("large_amount_threshold");
        this.aPW = jSONObject.optInt("large_amount_packet_amount");
        this.aPX = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aPY = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aPY[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
