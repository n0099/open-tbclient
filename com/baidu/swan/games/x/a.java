package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends e {
    public int enI;
    public int enP;
    public int enQ;
    public long enR;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dOd == null) {
            this.dOd = new JSONObject();
        }
        try {
            this.dOd.put("stage", this.enI);
            this.dOd.put("errMsg", this.errMsg);
            this.dOd.put("netStatus", this.enP);
            this.dOd.put("touch", this.enQ);
            this.dOd.put("stuck_interval", this.enR);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
