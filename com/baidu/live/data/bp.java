package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bp {
    public int aEA;
    public int aEB;
    public long aEC;
    public int aED;
    public String aEE;
    public String[] aEF;
    public long aEt;
    public int aEu;
    public int aEv;
    public int aEw;
    public int aEx;
    public int aEy;
    public List<a> aEz;

    /* loaded from: classes3.dex */
    public static class a {
        public String aEG;
        public String aEH;
    }

    public bp(JSONObject jSONObject) {
        int length;
        this.aEt = jSONObject.optLong("max_packet_amount");
        this.aEu = jSONObject.optInt("every_packet_min_amount");
        this.aEv = jSONObject.optInt("min_packet_num");
        this.aEw = jSONObject.optInt("max_packet_num");
        this.aEx = jSONObject.optInt("board_cast_amount");
        this.aEy = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.aEz = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aEG = jSONObject2.optString("condition_text");
                        aVar.aEH = jSONObject2.optString("condition_value");
                        this.aEz.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aEz = null;
        }
        this.aEA = jSONObject.optInt("send_default_amount");
        this.aEB = jSONObject.optInt("send_default_num");
        this.aEC = jSONObject.optLong("large_amount_threshold");
        this.aED = jSONObject.optInt("large_amount_packet_amount");
        this.aEE = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray2 != null && (length = optJSONArray2.length()) > 0) {
            this.aEF = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.aEF[i2] = optJSONArray2.optString(i2);
            }
        }
    }
}
