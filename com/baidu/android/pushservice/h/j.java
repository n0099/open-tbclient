package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.parser.ARResourceKey;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends l {
    public String a;
    public int b;
    public int c;
    public String k;

    public j() {
        this.a = "";
        this.b = -1;
        this.c = -1;
    }

    public j(l lVar) {
        super(lVar);
        this.a = "";
        this.b = -1;
        this.c = -1;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(HttpConstants.TIMESTAMP, this.e);
        jSONObject.put("network_status", this.f);
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
        jSONObject.put(ARResourceKey.HTTP_ERR_CODE, this.g);
        return jSONObject;
    }
}
