package com.baidu.android.pushservice.w;

import android.content.Context;
import com.baidu.android.pushservice.util.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.android.pushservice.w.c
    public g a(e eVar) {
        JSONObject jSONObject;
        g gVar = new g();
        try {
            jSONObject = new JSONObject(new String(eVar.b));
        } catch (JSONException unused) {
            jSONObject = null;
        }
        int optInt = jSONObject != null ? jSONObject.optInt("ret", -1) : -1;
        if (optInt == 2002) {
            com.baidu.android.pushservice.j.a(this.a).a(null, null, null, null);
            Utility.X(this.a);
        }
        gVar.a(optInt);
        return gVar;
    }
}
