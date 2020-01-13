package com.baidu.swan.games.u;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public com.baidu.swan.games.u.a.d coi;
    private int coj;
    private long cok;
    public int type;

    public a(int i, com.baidu.swan.games.u.a.d dVar) {
        this.type = i;
        this.coi = dVar;
        this.coj = d.anp() ? 20 : 10;
        this.cok = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.coj);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.cok);
            if (this.coi != null) {
                jSONObject.put("msg", this.coi.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
