package com.baidu.swan.games.r;

import android.app.Activity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.r.a.d;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public d bld;
    private int ble;
    private long blf;
    public int type;

    public a(int i, d dVar) {
        this.type = i;
        this.bld = dVar;
        this.ble = Te() ? 20 : 10;
        this.blf = System.currentTimeMillis();
    }

    private boolean Te() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md == null) {
            return false;
        }
        Activity activity = Md.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vE = ((SwanAppActivity) activity).vE();
            if (vE instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vE).RZ();
            }
            return false;
        }
        return false;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.ble);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.blf);
            if (this.bld != null) {
                jSONObject.put("msg", this.bld.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
