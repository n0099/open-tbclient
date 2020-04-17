package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bf {
    public long awN;
    public int awO;
    public int awP;
    public int awQ;
    public int awR;
    public int awS;
    public List<a> awT;

    /* loaded from: classes3.dex */
    public static class a {
        public String awU;
        public String awV;
    }

    public bf(JSONObject jSONObject) {
        this.awN = jSONObject.optLong("max_packet_amount");
        this.awO = jSONObject.optInt("every_packet_min_amount");
        this.awP = jSONObject.optInt("min_packet_num");
        this.awQ = jSONObject.optInt("max_packet_num");
        this.awR = jSONObject.optInt("board_cast_amount");
        this.awS = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.awT = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.awU = jSONObject2.optString("condition_text");
                        aVar.awV = jSONObject2.optString("condition_value");
                        this.awT.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        this.awT = null;
    }
}
