package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.android.pushservice.j.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        JSONObject jSONObject;
        g gVar = new g();
        String str = new String(eVar.c);
        com.baidu.android.pushservice.g.a.b("HandShakeMessageHandler", "handleMessage MSG_ID_HANDSHAKE : " + str);
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            com.baidu.android.pushservice.g.a.e("HandShakeMessageHandler", "error : " + e.getMessage());
            jSONObject = null;
        }
        int optInt = jSONObject != null ? jSONObject.optInt("ret", -1) : -1;
        com.baidu.android.pushservice.g.a.b("HandShakeMessageHandler", "handleMessage MSG_ID_HANDSHAKE : result = " + optInt);
        if (optInt == 0) {
            com.baidu.android.pushservice.e.b.a(this.a);
        } else if (optInt == 5003) {
            com.baidu.android.pushservice.e.b.a(this.a);
        } else if (optInt == 2002) {
            com.baidu.android.pushservice.j.a(this.a).a(null, null);
            p.e(this.a);
        }
        gVar.a(optInt);
        return gVar;
    }
}
