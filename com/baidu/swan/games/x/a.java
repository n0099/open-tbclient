package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends e {
    public int dmQ;
    public int dmX;
    public int dmY;
    public long dmZ;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cOz == null) {
            this.cOz = new JSONObject();
        }
        try {
            this.cOz.put("stage", this.dmQ);
            this.cOz.put("errMsg", this.errMsg);
            this.cOz.put("netStatus", this.dmX);
            this.cOz.put("touch", this.dmY);
            this.cOz.put("stuck_interval", this.dmZ);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
