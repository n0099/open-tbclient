package com.baidu.swan.games.x;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public int dza;
    public int dzh;
    public int dzi;
    public long dzj;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cZD == null) {
            this.cZD = new JSONObject();
        }
        try {
            this.cZD.put("stage", this.dza);
            this.cZD.put("errMsg", this.errMsg);
            this.cZD.put("netStatus", this.dzh);
            this.cZD.put("touch", this.dzi);
            this.cZD.put("stuck_interval", this.dzj);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
