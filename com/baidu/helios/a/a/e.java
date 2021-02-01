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
        return com.baidu.helios.b.aj(context.getApplicationContext()).uB();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray an(Context context) {
        b.C0120b c0120b;
        c cVar = new c();
        com.baidu.helios.b.aj(context).a(cVar);
        boolean a2 = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a2) {
            c.b uV = cVar.uV();
            if (uV != null && uV.result != 0 && (c0120b = (b.C0120b) uV.result) != null && c0120b.uF() != null) {
                for (b.c cVar2 : c0120b.uF()) {
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
            cVar.uW();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.aj(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.uW();
            return null;
        }
        c.b uV = cVar.uV();
        if (uV == null || TextUtils.isEmpty((CharSequence) uV.result)) {
            return null;
        }
        return (String) uV.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.aj(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.uW();
            return null;
        }
        c.b uV = cVar.uV();
        if (uV == null || TextUtils.isEmpty((CharSequence) uV.result)) {
            return null;
        }
        return (String) uV.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.aj(context.getApplicationContext()).getIid();
    }
}
