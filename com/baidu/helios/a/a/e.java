package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.a.a.c;
import com.baidu.helios.b;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class e implements h {
    @Override // com.baidu.helios.a.a.h
    public String a(Context context) {
        return com.baidu.helios.b.al(context.getApplicationContext()).zi();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray ap(Context context) {
        b.C0136b c0136b;
        c cVar = new c();
        com.baidu.helios.b.al(context).a(cVar);
        boolean a2 = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a2) {
            c.b zC = cVar.zC();
            if (zC != null && zC.result != 0 && (c0136b = (b.C0136b) zC.result) != null && c0136b.zm() != null) {
                for (b.c cVar2 : c0136b.zm()) {
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
            cVar.zD();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.al(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.zD();
            return null;
        }
        c.b zC = cVar.zC();
        if (zC == null || TextUtils.isEmpty((CharSequence) zC.result)) {
            return null;
        }
        return (String) zC.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.al(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.zD();
            return null;
        }
        c.b zC = cVar.zC();
        if (zC == null || TextUtils.isEmpty((CharSequence) zC.result)) {
            return null;
        }
        return (String) zC.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.al(context.getApplicationContext()).getIid();
    }
}
