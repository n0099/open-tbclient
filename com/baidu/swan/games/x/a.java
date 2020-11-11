package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends e {
    public int dZq;
    public int dZx;
    public int dZy;
    public long dZz;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dAh == null) {
            this.dAh = new JSONObject();
        }
        try {
            this.dAh.put("stage", this.dZq);
            this.dAh.put("errMsg", this.errMsg);
            this.dAh.put("netStatus", this.dZx);
            this.dAh.put("touch", this.dZy);
            this.dAh.put("stuck_interval", this.dZz);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
