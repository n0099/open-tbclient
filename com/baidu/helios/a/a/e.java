package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.a.a.c;
import com.baidu.helios.b;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class e implements h {
    @Override // com.baidu.helios.a.a.h
    public String a(Context context) {
        return com.baidu.helios.b.ae(context.getApplicationContext()).tP();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray ai(Context context) {
        b.C0128b c0128b;
        c cVar = new c();
        com.baidu.helios.b.ae(context).a(cVar);
        boolean a = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a) {
            c.b ui = cVar.ui();
            if (ui != null && ui.result != 0 && (c0128b = (b.C0128b) ui.result) != null && c0128b.tS() != null) {
                for (b.c cVar2 : c0128b.tS()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("aid", cVar2.aid);
                        jSONObject.put(Config.INPUT_DEF_PKG, cVar2.packageName);
                        jSONObject.put("priority", cVar2.priority);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            cVar.uj();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ae(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.uj();
            return null;
        }
        c.b ui = cVar.ui();
        if (ui == null || TextUtils.isEmpty((CharSequence) ui.result)) {
            return null;
        }
        return (String) ui.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ae(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.uj();
            return null;
        }
        c.b ui = cVar.ui();
        if (ui == null || TextUtils.isEmpty((CharSequence) ui.result)) {
            return null;
        }
        return (String) ui.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.ae(context.getApplicationContext()).getIid();
    }
}
