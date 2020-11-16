package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends e {
    public int dXI;
    public int dXP;
    public int dXQ;
    public long dXR;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dyA == null) {
            this.dyA = new JSONObject();
        }
        try {
            this.dyA.put("stage", this.dXI);
            this.dyA.put("errMsg", this.errMsg);
            this.dyA.put("netStatus", this.dXP);
            this.dyA.put("touch", this.dXQ);
            this.dyA.put("stuck_interval", this.dXR);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
