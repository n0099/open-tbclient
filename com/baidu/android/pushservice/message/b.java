package com.baidu.android.pushservice.message;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        JSONObject jSONObject;
        g gVar = new g();
        try {
            jSONObject = new JSONObject(new String(eVar.f3528b));
        } catch (JSONException e2) {
            new b.c(this.f3524a).a(Log.getStackTraceString(e2)).a();
            jSONObject = null;
        }
        int optInt = jSONObject != null ? jSONObject.optInt(Constants.KEYS.RET, -1) : -1;
        if (optInt == 2002) {
            com.baidu.android.pushservice.k.a(this.f3524a).a(null, null, null, null);
            m.c(this.f3524a);
        }
        new b.C0052b(this.f3524a).a(System.currentTimeMillis()).a(optInt + "").d(401102L).a();
        gVar.a(optInt);
        return gVar;
    }
}
