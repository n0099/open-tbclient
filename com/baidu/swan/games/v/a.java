package com.baidu.swan.games.v;

import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public com.baidu.swan.games.v.a.d eiT;
    private int eiU;
    private long ts;
    public int type;

    public a(int i, com.baidu.swan.games.v.a.d dVar) {
        this.type = i;
        this.eiT = dVar;
        this.eiU = d.aYb() ? 20 : 10;
        this.ts = System.currentTimeMillis();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("stage", this.eiU);
            jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.ts);
            if (this.eiT != null) {
                jSONObject.put("msg", this.eiT.toJSON());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
