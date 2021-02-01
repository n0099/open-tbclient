package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends e {
    public int elb;
    public int eli;
    public int elj;
    public long elk;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dLv == null) {
            this.dLv = new JSONObject();
        }
        try {
            this.dLv.put("stage", this.elb);
            this.dLv.put("errMsg", this.errMsg);
            this.dLv.put("netStatus", this.eli);
            this.dLv.put("touch", this.elj);
            this.dLv.put("stuck_interval", this.elk);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
