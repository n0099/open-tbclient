package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bs {
    public long aKZ;
    public int aLa;
    public int aLb;
    public int aLc;
    public int aLd;
    public int aLe;
    public List<a> aLf;
    public int aLg;
    public int aLh;
    public long aLi;
    public int aLj;
    public String aLk;
    public String[] aLl;

    /* loaded from: classes7.dex */
    public static class a {
        public String aLm;
        public String aLn;
    }

    public bs(JSONObject jSONObject) {
        int length;
        this.aKZ = jSONObject.optLong("max_packet_amount");
        this.aLa = jSONObject.optInt("every_packet_min_amount");
        this.aLb = jSONObject.optInt("min_packet_num");
        this.aLc = jSONObject.optInt("max_packet_num");
        this.aLd = jSONObject.optInt("board_cast_amount");
        this.aLe = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.aLf = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aLm = jSONObject2.optString("condition_text");
                        aVar.aLn = jSONObject2.optString("condition_value");
                        this.aLf.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.aLf = null;
        }
        this.aLg = jSONObject.optInt("send_default_amount");
        this.aLh = jSONObject.optInt("send_default_num");
        this.aLi = jSONObject.optLong("large_amount_threshold");
        this.aLj = jSONObject.optInt("large_amount_packet_amount");
        this.aLk = jSONObject.optString("send_tip_top");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("rule_desc");
        if (optJSONArray2 != null && (length = optJSONArray2.length()) > 0) {
            this.aLl = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.aLl[i2] = optJSONArray2.optString(i2);
            }
        }
    }
}
