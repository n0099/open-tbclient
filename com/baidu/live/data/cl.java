package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cl {
    public long aOZ;
    public int aPa;
    public int aPb;
    public int aPc;
    public int aPd;
    public int aPe;
    public List<a> aPf;
    public List<a> aPg;
    public int aPh;
    public int aPi;
    public long aPj;
    public int aPk;
    public String aPl;
    public String[] aPm;

    /* loaded from: classes10.dex */
    public static class a {
        public String aPn;
        public String aPo;
    }

    public cl(JSONObject jSONObject) {
        int length;
        this.aOZ = jSONObject.optLong("max_packet_amount");
        this.aPa = jSONObject.optInt("every_packet_min_amount");
        this.aPb = jSONObject.optInt("min_packet_num");
        this.aPc = jSONObject.optInt("max_packet_num");
        this.aPd = jSONObject.optInt("board_cast_amount");
        this.aPe = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aPf = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aPn = jSONObject2.optString("condition_text");
                        aVar.aPo = jSONObject2.optString("condition_value");
                        this.aPf.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aPf = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aPg = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aPn = jSONObject3.optString("condition_text");
                        aVar2.aPo = jSONObject3.optString("condition_value");
                        this.aPg.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aPg = null;
        }
        this.aPh = jSONObject.optInt("send_default_amount");
        this.aPi = jSONObject.optInt("send_default_num");
        this.aPj = jSONObject.optLong("large_amount_threshold");
        this.aPk = jSONObject.optInt("large_amount_packet_amount");
        this.aPl = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aPm = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aPm[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
