package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int csm;
    public int css;
    public int cst;
    public long csu;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVl == null) {
            this.bVl = new JSONObject();
        }
        try {
            this.bVl.put("stage", this.csm);
            this.bVl.put("errMsg", this.errMsg);
            this.bVl.put("netStatus", this.css);
            this.bVl.put("touch", this.cst);
            this.bVl.put("stuck_interval", this.csu);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
