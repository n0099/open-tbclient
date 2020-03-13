package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int csn;
    public int cst;
    public int csu;
    public long csv;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVm == null) {
            this.bVm = new JSONObject();
        }
        try {
            this.bVm.put("stage", this.csn);
            this.bVm.put("errMsg", this.errMsg);
            this.bVm.put("netStatus", this.cst);
            this.bVm.put("touch", this.csu);
            this.bVm.put("stuck_interval", this.csv);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
