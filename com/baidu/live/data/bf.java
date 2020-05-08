package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bf {
    public long awT;
    public int awU;
    public int awV;
    public int awW;
    public int awX;
    public int awY;
    public List<a> awZ;

    /* loaded from: classes3.dex */
    public static class a {
        public String axa;
        public String axb;
    }

    public bf(JSONObject jSONObject) {
        this.awT = jSONObject.optLong("max_packet_amount");
        this.awU = jSONObject.optInt("every_packet_min_amount");
        this.awV = jSONObject.optInt("min_packet_num");
        this.awW = jSONObject.optInt("max_packet_num");
        this.awX = jSONObject.optInt("board_cast_amount");
        this.awY = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.awZ = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.axa = jSONObject2.optString("condition_text");
                        aVar.axb = jSONObject2.optString("condition_value");
                        this.awZ.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        this.awZ = null;
    }
}
