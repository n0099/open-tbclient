package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends m {
    public String a;
    public int b;
    public int c;
    public String k;

    public j() {
        this.a = "";
        this.b = -1;
        this.c = -1;
    }

    public j(m mVar) {
        super(mVar);
        this.a = "";
        this.b = -1;
        this.c = -1;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put("network_status", this.f);
        if (this.c != -1) {
            jSONObject.put("msg_type", this.c);
        }
        if (!TextUtils.isEmpty(this.a)) {
            jSONObject.put(PbActivityConfig.KEY_MSG_ID, this.a);
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
