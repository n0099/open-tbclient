package com.baidu.live.business.model.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveGrParams {
    public int clk;
    public long clkTs;
    public String id;
    public int show;
    public long showTs;

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("show", this.show);
            jSONObject.put("show_ts", this.showTs);
            jSONObject.put("clk", this.clk);
            jSONObject.put("clk_ts", this.clkTs);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
