package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aw {
    public long abX;
    public int abY;
    public int abZ;
    public int aca;
    public int acb;
    public int acc;
    public List<a> acd;

    /* loaded from: classes2.dex */
    public static class a {
        public String ace;
        public String acf;
    }

    public aw(JSONObject jSONObject) {
        this.abX = jSONObject.optLong("max_packet_amount");
        this.abY = jSONObject.optInt("every_packet_min_amount");
        this.abZ = jSONObject.optInt("min_packet_num");
        this.aca = jSONObject.optInt("max_packet_num");
        this.acb = jSONObject.optInt("board_cast_amount");
        this.acc = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.acd = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.ace = jSONObject2.optString("condition_text");
                        aVar.acf = jSONObject2.optString("condition_value");
                        this.acd.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        this.acd = null;
    }
}
