package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends e {
    public int eiU;
    public int ejb;
    public int ejc;
    public long ejd;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dJr == null) {
            this.dJr = new JSONObject();
        }
        try {
            this.dJr.put("stage", this.eiU);
            this.dJr.put("errMsg", this.errMsg);
            this.dJr.put("netStatus", this.ejb);
            this.dJr.put("touch", this.ejc);
            this.dJr.put("stuck_interval", this.ejd);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
