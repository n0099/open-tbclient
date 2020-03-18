package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bc {
    public int aeA;
    public int aeB;
    public int aeC;
    public List<a> aeD;
    public long aex;
    public int aey;
    public int aez;

    /* loaded from: classes3.dex */
    public static class a {
        public String aeE;
        public String aeF;
    }

    public bc(JSONObject jSONObject) {
        this.aex = jSONObject.optLong("max_packet_amount");
        this.aey = jSONObject.optInt("every_packet_min_amount");
        this.aez = jSONObject.optInt("min_packet_num");
        this.aeA = jSONObject.optInt("max_packet_num");
        this.aeB = jSONObject.optInt("board_cast_amount");
        this.aeC = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.aeD = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aeE = jSONObject2.optString("condition_text");
                        aVar.aeF = jSONObject2.optString("condition_value");
                        this.aeD.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        this.aeD = null;
    }
}
