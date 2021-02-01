package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cs {
    public long aSb;
    public int aSc;
    public int aSd;
    public int aSe;
    public int aSf;
    public int aSg;
    public List<a> aSh;
    public List<a> aSi;
    public int aSj;
    public int aSk;
    public long aSl;
    public int aSm;
    public String aSn;
    public String[] aSo;

    /* loaded from: classes11.dex */
    public static class a {
        public String aSp;
        public String aSq;
    }

    public cs(JSONObject jSONObject) {
        int length;
        this.aSb = jSONObject.optLong("max_packet_amount");
        this.aSc = jSONObject.optInt("every_packet_min_amount");
        this.aSd = jSONObject.optInt("min_packet_num");
        this.aSe = jSONObject.optInt("max_packet_num");
        this.aSf = jSONObject.optInt("board_cast_amount");
        this.aSg = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("audio_condition");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.aSh = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aSp = jSONObject2.optString("condition_text");
                        aVar.aSq = jSONObject2.optString("condition_value");
                        this.aSh.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aSh = null;
        }
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            this.aSi = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                try {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        a aVar2 = new a();
                        aVar2.aSp = jSONObject3.optString("condition_text");
                        aVar2.aSq = jSONObject3.optString("condition_value");
                        this.aSi.add(aVar2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.aSi = null;
        }
        this.aSj = jSONObject.optInt("send_default_amount");
        this.aSk = jSONObject.optInt("send_default_num");
        this.aSl = jSONObject.optLong("large_amount_threshold");
        this.aSm = jSONObject.optInt("large_amount_packet_amount");
        this.aSn = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray3 != null && (length = optJSONArray3.length()) > 0) {
            this.aSo = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.aSo[i3] = optJSONArray3.optString(i3);
            }
        }
    }
}
