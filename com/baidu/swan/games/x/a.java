package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int dcC;
    public int dcD;
    public long dcE;
    public int dcv;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cGu == null) {
            this.cGu = new JSONObject();
        }
        try {
            this.cGu.put("stage", this.dcv);
            this.cGu.put("errMsg", this.errMsg);
            this.cGu.put("netStatus", this.dcC);
            this.cGu.put("touch", this.dcD);
            this.cGu.put("stuck_interval", this.dcE);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
