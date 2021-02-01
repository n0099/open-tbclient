package com.baidu.swan.games.v;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public com.baidu.swan.games.v.a.d ela;
    private int elb;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.ela = dVar;
        this.elb = d.aYn() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.elb);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.ts);
            if (this.ela != null) {
                jSONObject.put("msg", this.ela.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
