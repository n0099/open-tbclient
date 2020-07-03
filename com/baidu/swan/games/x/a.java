package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends e {
    public int dhh;
    public int dho;
    public int dhp;
    public long dhq;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cLe == null) {
            this.cLe = new JSONObject();
        }
        try {
            this.cLe.put("stage", this.dhh);
            this.cLe.put("errMsg", this.errMsg);
            this.cLe.put("netStatus", this.dho);
            this.cLe.put("touch", this.dhp);
            this.cLe.put("stuck_interval", this.dhq);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
