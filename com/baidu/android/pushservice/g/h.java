package com.baidu.android.pushservice.g;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h extends j {
    public String a;
    public int b;
    public int c;
    public String k;

    public h() {
        this.a = "";
        this.b = -1;
        this.c = -1;
    }

    public h(j jVar) {
        super(jVar);
        this.a = "";
        this.b = -1;
        this.c = -1;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, this.f);
        if (this.c != -1) {
            jSONObject.put("msg_type", this.c);
        }
        if (!TextUtils.isEmpty(this.a)) {
            jSONObject.put("msg_id", this.a);
        }
        if (this.b > 0) {
            jSONObject.put("msg_len", this.b);
        }
        if (this.k != null) {
            jSONObject.put("msg_open_by", this.k);
        }
        jSONObject.put("err_code", this.g);
        return jSONObject;
    }
}
