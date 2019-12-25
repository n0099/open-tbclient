package com.baidu.swan.games.u;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public com.baidu.swan.games.u.a.d cnV;
    private int cnW;
    private long cnX;
    public int type;

    public a(int i, com.baidu.swan.games.u.a.d dVar) {
        this.type = i;
        this.cnV = dVar;
        this.cnW = d.amW() ? 20 : 10;
        this.cnX = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.cnW);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.cnX);
            if (this.cnV != null) {
                jSONObject.put("msg", this.cnV.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
