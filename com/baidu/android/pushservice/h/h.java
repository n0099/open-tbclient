package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends m {
    public int a;
    public String b;
    public String c;

    public h() {
    }

    public h(m mVar) {
        super(mVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put("timestamp", this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("heart", this.a);
        jSONObject.put("err_code", this.g);
        jSONObject.put("msg_result", this.i);
        if (!TextUtils.isEmpty(this.b)) {
            jSONObject.put(PbActivityConfig.KEY_MSG_ID, this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put("msg_open_by", this.c);
        }
        return jSONObject;
    }
}
