package com.baidu.live.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ba {
    public long aci;
    public int acj;
    public int acm;
    public int acn;
    public int aco;
    public int acp;
    public List<a> acq;

    /* loaded from: classes2.dex */
    public static class a {
        public String acr;
        public String acs;
    }

    public ba(JSONObject jSONObject) {
        this.aci = jSONObject.optLong("max_packet_amount");
        this.acj = jSONObject.optInt("every_packet_min_amount");
        this.acm = jSONObject.optInt("min_packet_num");
        this.acn = jSONObject.optInt("max_packet_num");
        this.aco = jSONObject.optInt("board_cast_amount");
        this.acp = jSONObject.optInt("between_time");
        JSONArray optJSONArray = jSONObject.optJSONArray("condition");
        if (optJSONArray.length() > 0) {
            this.acq = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        a aVar = new a();
                        aVar.acr = jSONObject2.optString("condition_text");
                        aVar.acs = jSONObject2.optString("condition_value");
                        this.acq.add(aVar);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        this.acq = null;
    }
}
