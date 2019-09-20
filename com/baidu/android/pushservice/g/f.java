package com.baidu.android.pushservice.g;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends j {
    public int a;
    public String b;
    public String c;

    public f() {
    }

    public f(j jVar) {
        super(jVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(DpStatConstants.KEY_TIMESTAMP, this.e);
        jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, this.f);
        jSONObject.put("heart", this.a);
        jSONObject.put("err_code", this.g);
        jSONObject.put("msg_result", this.i);
        if (!TextUtils.isEmpty(this.b)) {
            jSONObject.put("msg_id", this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put("msg_open_by", this.c);
        }
        return jSONObject;
    }
}
