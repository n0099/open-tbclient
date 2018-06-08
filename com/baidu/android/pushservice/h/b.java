package com.baidu.android.pushservice.h;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.ar.statistic.StatisticConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends l {
    public String a;
    public String b;
    public String c;

    public b() {
    }

    public b(l lVar) {
        super(lVar);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_name", this.d);
        jSONObject.put(HttpConstants.TIMESTAMP, this.e);
        jSONObject.put("network_status", this.f);
        jSONObject.put("msg_result", this.a);
        jSONObject.put(StatisticConstants.REQUEST_ID, this.b);
        jSONObject.put(ARResourceKey.HTTP_ERR_CODE, this.g);
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.put("channel", this.c);
        }
        return jSONObject;
    }
}
