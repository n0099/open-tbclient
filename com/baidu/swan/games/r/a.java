package com.baidu.swan.games.r;

import android.app.Activity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.r.a.d;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private long bDA;
    public d bDy;
    private int bDz;
    public int type;

    public a(int i, d dVar) {
        this.type = i;
        this.bDy = dVar;
        this.bDz = XX() ? 20 : 10;
        this.bDA = System.currentTimeMillis();
    }

    private boolean XX() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra == null) {
            return false;
        }
        Activity activity = Ra.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d AD = ((SwanAppActivity) activity).AD();
            if (AD instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AD).WS();
            }
            return false;
        }
        return false;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.bDz);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.bDA);
            if (this.bDy != null) {
                jSONObject.put("msg", this.bDy.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
