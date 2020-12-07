package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cj {
    public long aSO;
    public int aSP;
    public int aSQ;
    public int aSR;
    public int aSS;
    public int aST;
    public List<a> aSU;
    public List<a> aSV;
    public int aSW;
    public int aSX;
    public long aSY;
    public int aSZ;
    public String aTa;
    public String[] aTb;

    /* loaded from: classes4.dex */
    public static class a {
        public String aTc;
        public String aTd;
    }

    public cj(JSONObject jSONObject) {
        int length;
        this.aSO = jSONObject.optLong("max_packet_amount");
        this.aSP = jSONObject.optInt("every_packet_min_amount");
        this.aSQ = jSONObject.optInt("min_packet_num");
        this.aSR = jSONObject.optInt("max_packet_num");
        this.aSS = jSONObject.optInt("board_cast_amount");
        this.aST = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aSU = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aTc = jSONObject2.optString("condition_text");
                        aVar.aTd = jSONObject2.optString("condition_value");
                        this.aSU.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aSU = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aSV = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aTc = jSONObject3.optString("condition_text");
                        aVar2.aTd = jSONObject3.optString("condition_value");
                        this.aSV.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aSV = null;
        }
        this.aSW = jSONObject.optInt("send_default_amount");
        this.aSX = jSONObject.optInt("send_default_num");
        this.aSY = jSONObject.optLong("large_amount_threshold");
        this.aSZ = jSONObject.optInt("large_amount_packet_amount");
        this.aTa = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aTb = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aTb[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
