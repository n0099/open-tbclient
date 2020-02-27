package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bc {
    public long aen;
    public int aeo;
    public int aep;
    public int aeq;
    public int aer;
    public int aes;
    public List<a> aet;

    /* loaded from: classes3.dex */
    public static class a {
        public String aeu;
        public String aev;
    }

    public bc(JSONObject jSONObject) {
        this.aen = jSONObject.optLong("max_packet_amount");
        this.aeo = jSONObject.optInt("every_packet_min_amount");
        this.aep = jSONObject.optInt("min_packet_num");
        this.aeq = jSONObject.optInt("max_packet_num");
        this.aer = jSONObject.optInt("board_cast_amount");
        this.aes = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.aet = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aeu = jSONObject2.optString("condition_text");
                        aVar.aev = jSONObject2.optString("condition_value");
                        this.aet.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        this.aet = null;
    }
}
