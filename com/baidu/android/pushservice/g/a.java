package com.baidu.android.pushservice.g;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends j {
    public String a;
    public String b;
    public String c;

    public a() {
    }

    public a(j jVar) {
        super(jVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, this.f);
        jSONObject.put("msg_result", this.a);
        jSONObject.put("request_id", this.b);
        jSONObject.put("err_code", this.g);
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put("channel", this.c);
        }
        return jSONObject;
    }
}
