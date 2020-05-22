package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bk {
    public long aCi;
    public int aCj;
    public int aCk;
    public int aCl;
    public int aCm;
    public int aCn;
    public List<a> aCo;

    /* loaded from: classes3.dex */
    public static class a {
        public String aCp;
        public String aCq;
    }

    public bk(JSONObject jSONObject) {
        this.aCi = jSONObject.optLong("max_packet_amount");
        this.aCj = jSONObject.optInt("every_packet_min_amount");
        this.aCk = jSONObject.optInt("min_packet_num");
        this.aCl = jSONObject.optInt("max_packet_num");
        this.aCm = jSONObject.optInt("board_cast_amount");
        this.aCn = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.aCo = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.aCp = jSONObject2.optString("condition_text");
                        aVar.aCq = jSONObject2.optString("condition_value");
                        this.aCo.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        this.aCo = null;
    }
}
