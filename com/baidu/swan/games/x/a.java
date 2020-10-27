package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends e {
    public int dTF;
    public int dTG;
    public long dTH;
    public int dTy;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dup == null) {
            this.dup = new JSONObject();
        }
        try {
            this.dup.put("stage", this.dTy);
            this.dup.put("errMsg", this.errMsg);
            this.dup.put("netStatus", this.dTF);
            this.dup.put("touch", this.dTG);
            this.dup.put("stuck_interval", this.dTH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
