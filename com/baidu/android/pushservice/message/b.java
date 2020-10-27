package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends c {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        JSONObject jSONObject;
        g gVar = new g();
        try {
            jSONObject = new JSONObject(new String(eVar.b));
        } catch (JSONException e) {
            new b.c(this.f1174a).a(Log.getStackTraceString(e)).a();
            jSONObject = null;
        }
        int optInt = jSONObject != null ? jSONObject.optInt("ret", -1) : -1;
        if (optInt == 2002) {
            com.baidu.android.pushservice.j.a(this.f1174a).a(null, null, null, null);
            m.c(this.f1174a);
        }
        new b.C0064b(this.f1174a).a(System.currentTimeMillis()).a(optInt + "").d(401102L).a();
        gVar.a(optInt);
        return gVar;
    }
}
