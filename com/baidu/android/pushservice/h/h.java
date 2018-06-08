package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.parser.ARResourceKey;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends l {
    public int a;
    public String b;
    public String c;

    public h() {
    }

    public h(l lVar) {
        super(lVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(HttpConstants.TIMESTAMP, this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("heart", this.a);
        jSONObject.put(ARResourceKey.HTTP_ERR_CODE, this.g);
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
