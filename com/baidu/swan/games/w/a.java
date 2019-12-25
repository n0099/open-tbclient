package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends e {
    public int cnW;
    public int cod;
    public int coe;
    public long cof;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bQv == null) {
            this.bQv = new JSONObject();
        }
        try {
            this.bQv.put("stage", this.cnW);
            this.bQv.put("errMsg", this.errMsg);
            this.bQv.put("netStatus", this.cod);
            this.bQv.put("touch", this.coe);
            this.bQv.put("stuck_interval", this.cof);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
