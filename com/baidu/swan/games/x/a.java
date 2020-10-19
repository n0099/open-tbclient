package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends e {
    public int dLb;
    public int dLi;
    public int dLj;
    public long dLk;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dlN == null) {
            this.dlN = new JSONObject();
        }
        try {
            this.dlN.put("stage", this.dLb);
            this.dlN.put("errMsg", this.errMsg);
            this.dlN.put("netStatus", this.dLi);
            this.dlN.put("touch", this.dLj);
            this.dlN.put("stuck_interval", this.dLk);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
