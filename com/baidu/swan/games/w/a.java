package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int csE;
    public int csF;
    public long csG;
    public int csy;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVx == null) {
            this.bVx = new JSONObject();
        }
        try {
            this.bVx.put("stage", this.csy);
            this.bVx.put("errMsg", this.errMsg);
            this.bVx.put("netStatus", this.csE);
            this.bVx.put("touch", this.csF);
            this.bVx.put("stuck_interval", this.csG);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
