package com.baidu.swan.games.r;

import android.app.Activity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.r.a.d;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public d blB;
    private int blC;
    private long blD;
    public int type;

    public a(int i, d dVar) {
        this.type = i;
        this.blB = dVar;
        this.blC = Ti() ? 20 : 10;
        this.blD = System.currentTimeMillis();
    }

    private boolean Ti() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh == null) {
            return false;
        }
        Activity activity = Mh.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d vI = ((SwanAppActivity) activity).vI();
            if (vI instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) vI).Sd();
            }
            return false;
        }
        return false;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.blC);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.blD);
            if (this.blB != null) {
                jSONObject.put("msg", this.blB.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
