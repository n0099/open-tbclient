package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ch {
    public long aPM;
    public int aPN;
    public int aPO;
    public int aPP;
    public int aPQ;
    public int aPR;
    public List<a> aPS;
    public List<a> aPT;
    public int aPU;
    public int aPV;
    public long aPW;
    public int aPX;
    public String aPY;
    public String[] aPZ;

    /* loaded from: classes4.dex */
    public static class a {
        public String aQa;
        public String aQb;
    }

    public ch(JSONObject jSONObject) {
        int length;
        this.aPM = jSONObject.optLong("max_packet_amount");
        this.aPN = jSONObject.optInt("every_packet_min_amount");
        this.aPO = jSONObject.optInt("min_packet_num");
        this.aPP = jSONObject.optInt("max_packet_num");
        this.aPQ = jSONObject.optInt("board_cast_amount");
        this.aPR = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aPS = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aQa = jSONObject2.optString("condition_text");
                        aVar.aQb = jSONObject2.optString("condition_value");
                        this.aPS.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aPS = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aPT = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aQa = jSONObject3.optString("condition_text");
                        aVar2.aQb = jSONObject3.optString("condition_value");
                        this.aPT.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aPT = null;
        }
        this.aPU = jSONObject.optInt("send_default_amount");
        this.aPV = jSONObject.optInt("send_default_num");
        this.aPW = jSONObject.optLong("large_amount_threshold");
        this.aPX = jSONObject.optInt("large_amount_packet_amount");
        this.aPY = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aPZ = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aPZ[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
