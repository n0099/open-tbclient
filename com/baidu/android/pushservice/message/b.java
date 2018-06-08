package com.baidu.android.pushservice.message;

import android.content.Context;
import com.baidu.android.pushservice.j.m;
import com.baidu.ar.parser.ARResourceKey;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.message.c
    public g a(e eVar) {
        JSONObject jSONObject;
        g gVar = new g();
        try {
            jSONObject = new JSONObject(new String(eVar.c));
        } catch (JSONException e) {
            jSONObject = null;
        }
        int optInt = jSONObject != null ? jSONObject.optInt(ARResourceKey.HTTP_RET, -1) : -1;
        if (optInt == 0) {
            com.baidu.android.pushservice.e.b.a(this.a);
        } else if (optInt == 5003) {
            com.baidu.android.pushservice.e.b.a(this.a);
        } else if (optInt == 2002) {
            com.baidu.android.pushservice.j.a(this.a).a(null, null, null, null);
            m.e(this.a);
        }
        gVar.a(optInt);
        return gVar;
    }
}
