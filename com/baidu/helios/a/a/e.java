package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.a.a.c;
import com.baidu.helios.b;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class e implements h {
    @Override // com.baidu.helios.a.a.h
    public String a(Context context) {
        return com.baidu.helios.b.af(context.getApplicationContext()).uh();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray aj(Context context) {
        b.C0128b c0128b;
        c cVar = new c();
        com.baidu.helios.b.af(context).a(cVar);
        boolean a = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a) {
            c.b uA = cVar.uA();
            if (uA != null && uA.result != 0 && (c0128b = (b.C0128b) uA.result) != null && c0128b.uk() != null) {
                for (b.c cVar2 : c0128b.uk()) {
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
            cVar.uB();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.af(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.uB();
            return null;
        }
        c.b uA = cVar.uA();
        if (uA == null || TextUtils.isEmpty((CharSequence) uA.result)) {
            return null;
        }
        return (String) uA.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.af(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.uB();
            return null;
        }
        c.b uA = cVar.uA();
        if (uA == null || TextUtils.isEmpty((CharSequence) uA.result)) {
            return null;
        }
        return (String) uA.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.af(context.getApplicationContext()).getIid();
    }
}
