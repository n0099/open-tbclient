package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int cRE;
    public int cRF;
    public long cRG;
    public int cRy;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cuv == null) {
            this.cuv = new JSONObject();
        }
        try {
            this.cuv.put("stage", this.cRy);
            this.cuv.put("errMsg", this.errMsg);
            this.cuv.put("netStatus", this.cRE);
            this.cuv.put("touch", this.cRF);
            this.cuv.put("stuck_interval", this.cRG);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
