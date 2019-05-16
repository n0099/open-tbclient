package com.baidu.swan.games.r;

import android.app.Activity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.r.a.d;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public d bkq;
    private int bkr;
    private long bks;
    public int type;

    public a(int i, d dVar) {
        this.type = i;
        this.bkq = dVar;
        this.bkr = Sl() ? 20 : 10;
        this.bks = System.currentTimeMillis();
    }

    private boolean Sl() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq == null) {
            return false;
        }
        Activity activity = Lq.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vd = ((SwanAppActivity) activity).vd();
            if (vd instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vd).Rg();
            }
            return false;
        }
        return false;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.bkr);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.bks);
            if (this.bkq != null) {
                jSONObject.put("msg", this.bkq.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
