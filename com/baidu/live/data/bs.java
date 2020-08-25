package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bs {
    public long aKX;
    public int aKY;
    public int aKZ;
    public int aLa;
    public int aLb;
    public int aLc;
    public List<a> aLd;
    public int aLe;
    public int aLf;
    public long aLg;
    public int aLh;
    public String aLi;
    public String[] aLj;

    /* loaded from: classes7.dex */
    public static class a {
        public String aLk;
        public String aLl;
    }

    public bs(JSONObject jSONObject) {
        int length;
        this.aKX = jSONObject.optLong("max_packet_amount");
        this.aKY = jSONObject.optInt("every_packet_min_amount");
        this.aKZ = jSONObject.optInt("min_packet_num");
        this.aLa = jSONObject.optInt("max_packet_num");
        this.aLb = jSONObject.optInt("board_cast_amount");
        this.aLc = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.aLd = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aLk = jSONObject2.optString("condition_text");
                        aVar.aLl = jSONObject2.optString("condition_value");
                        this.aLd.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aLd = null;
        }
        this.aLe = jSONObject.optInt("send_default_amount");
        this.aLf = jSONObject.optInt("send_default_num");
        this.aLg = jSONObject.optLong("large_amount_threshold");
        this.aLh = jSONObject.optInt("large_amount_packet_amount");
        this.aLi = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray2 != null && (length = optJSONArray2.length()) > 0) {
            this.aLj = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.aLj[i2] = optJSONArray2.optString(i2);
            }
        }
    }
}
