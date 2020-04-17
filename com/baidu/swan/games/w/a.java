package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int cRA;
    public long cRB;
    public int cRt;
    public int cRz;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cun == null) {
            this.cun = new JSONObject();
        }
        try {
            this.cun.put("stage", this.cRt);
            this.cun.put("errMsg", this.errMsg);
            this.cun.put("netStatus", this.cRz);
            this.cun.put("touch", this.cRA);
            this.cun.put("stuck_interval", this.cRB);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
