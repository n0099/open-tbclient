package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int csl;
    public int csr;
    public int css;
    public long cst;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVk == null) {
            this.bVk = new JSONObject();
        }
        try {
            this.bVk.put("stage", this.csl);
            this.bVk.put("errMsg", this.errMsg);
            this.bVk.put("netStatus", this.csr);
            this.bVk.put("touch", this.css);
            this.bVk.put("stuck_interval", this.cst);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
