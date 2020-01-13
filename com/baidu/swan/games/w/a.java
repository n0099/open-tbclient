package com.baidu.swan.games.w;

import com.baidu.swan.apps.statistic.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends e {
    public int coj;
    public int coq;
    public int cor;
    public long cos;
    public String errMsg;

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bRf == null) {
            this.bRf = new JSONObject();
        }
        try {
            this.bRf.put("stage", this.coj);
            this.bRf.put("errMsg", this.errMsg);
            this.bRf.put("netStatus", this.coq);
            this.bRf.put("touch", this.cor);
            this.bRf.put("stuck_interval", this.cos);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return super.toJSONObject();
    }
}
