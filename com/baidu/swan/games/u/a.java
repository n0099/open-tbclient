package com.baidu.swan.games.u;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public com.baidu.swan.games.u.a.d cRs;
    private int cRt;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.u.a.d dVar) {
        this.type = i;
        this.cRs = dVar;
        this.cRt = d.axU() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.cRt);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.ts);
            if (this.cRs != null) {
                jSONObject.put("msg", this.cRs.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
