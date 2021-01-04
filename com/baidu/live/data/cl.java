package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cl {
    public long aTM;
    public int aTN;
    public int aTO;
    public int aTP;
    public int aTQ;
    public int aTR;
    public List<a> aTS;
    public List<a> aTT;
    public int aTU;
    public int aTV;
    public long aTW;
    public int aTX;
    public String aTY;
    public String[] aTZ;

    /* loaded from: classes11.dex */
    public static class a {
        public String aUa;
        public String aUb;
    }

    public cl(JSONObject jSONObject) {
        int length;
        this.aTM = jSONObject.optLong("max_packet_amount");
        this.aTN = jSONObject.optInt("every_packet_min_amount");
        this.aTO = jSONObject.optInt("min_packet_num");
        this.aTP = jSONObject.optInt("max_packet_num");
        this.aTQ = jSONObject.optInt("board_cast_amount");
        this.aTR = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aTS = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aUa = jSONObject2.optString("condition_text");
                        aVar.aUb = jSONObject2.optString("condition_value");
                        this.aTS.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aTS = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aTT = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aUa = jSONObject3.optString("condition_text");
                        aVar2.aUb = jSONObject3.optString("condition_value");
                        this.aTT.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aTT = null;
        }
        this.aTU = jSONObject.optInt("send_default_amount");
        this.aTV = jSONObject.optInt("send_default_num");
        this.aTW = jSONObject.optLong("large_amount_threshold");
        this.aTX = jSONObject.optInt("large_amount_packet_amount");
        this.aTY = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aTZ = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aTZ[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
