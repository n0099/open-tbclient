package com.baidu.swan.games.r;

import android.app.Activity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.r.a.d;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public d bEp;
    private int bEq;
    private long bEr;
    public int type;

    public a(int i, d dVar) {
        this.type = i;
        this.bEp = dVar;
        this.bEq = XZ() ? 20 : 10;
        this.bEr = System.currentTimeMillis();
    }

    private boolean XZ() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ == null) {
            return false;
        }
        Activity activity = QZ.getActivity();
        if (activity instanceof SwanAppActivity) {
            com.baidu.swan.apps.o.d AC = ((SwanAppActivity) activity).AC();
            if (AC instanceof com.baidu.swan.games.g.a) {
                return ((com.baidu.swan.games.g.a) AC).WU();
            }
            return false;
        }
        return false;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.bEq);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.bEr);
            if (this.bEp != null) {
                jSONObject.put("msg", this.bEp.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
