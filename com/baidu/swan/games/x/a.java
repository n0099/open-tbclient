package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends e {
    public int dwZ;
    public int dxg;
    public int dxh;
    public long dxi;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cXD == null) {
            this.cXD = new JSONObject();
        }
        try {
            this.cXD.put("stage", this.dwZ);
            this.cXD.put("errMsg", this.errMsg);
            this.cXD.put("netStatus", this.dxg);
            this.cXD.put("touch", this.dxh);
            this.cXD.put("stuck_interval", this.dxi);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
