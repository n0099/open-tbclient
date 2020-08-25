package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends e {
    public int dwV;
    public int dxc;
    public int dxd;
    public long dxe;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cXz == null) {
            this.cXz = new JSONObject();
        }
        try {
            this.cXz.put("stage", this.dwV);
            this.cXz.put("errMsg", this.errMsg);
            this.cXz.put("netStatus", this.dxc);
            this.cXz.put("touch", this.dxd);
            this.cXz.put("stuck_interval", this.dxe);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
