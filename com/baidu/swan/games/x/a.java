package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends e {
    public int emC;
    public int emJ;
    public int emK;
    public long emL;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dMW == null) {
            this.dMW = new JSONObject();
        }
        try {
            this.dMW.put("stage", this.emC);
            this.dMW.put("errMsg", this.errMsg);
            this.dMW.put("netStatus", this.emJ);
            this.dMW.put("touch", this.emK);
            this.dMW.put("stuck_interval", this.emL);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
