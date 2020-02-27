package com.baidu.android.pushservice.g;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends j {
    public String a;

    public e() {
    }

    public e(j jVar) {
        super(jVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, this.f);
        jSONObject.put("crash_stack", this.a);
        return jSONObject;
    }
}
