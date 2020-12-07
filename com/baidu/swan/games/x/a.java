package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends e {
    public int eeH;
    public int eeO;
    public int eeP;
    public long eeQ;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dFz == null) {
            this.dFz = new JSONObject();
        }
        try {
            this.dFz.put("stage", this.eeH);
            this.dFz.put("errMsg", this.errMsg);
            this.dFz.put("netStatus", this.eeO);
            this.dFz.put("touch", this.eeP);
            this.dFz.put("stuck_interval", this.eeQ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
