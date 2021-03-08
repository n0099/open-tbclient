package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.a.a.c;
import com.baidu.helios.b;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
class e implements h {
    @Override // com.baidu.helios.a.a.h
    public String a(Context context) {
        return com.baidu.helios.b.ai(context.getApplicationContext()).uE();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray am(Context context) {
        b.C0126b c0126b;
        c cVar = new c();
        com.baidu.helios.b.ai(context).a(cVar);
        boolean a2 = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a2) {
            c.b uY = cVar.uY();
            if (uY != null && uY.result != 0 && (c0126b = (b.C0126b) uY.result) != null && c0126b.uI() != null) {
                for (b.c cVar2 : c0126b.uI()) {
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
            cVar.uZ();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ai(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.uZ();
            return null;
        }
        c.b uY = cVar.uY();
        if (uY == null || TextUtils.isEmpty((CharSequence) uY.result)) {
            return null;
        }
        return (String) uY.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ai(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.uZ();
            return null;
        }
        c.b uY = cVar.uY();
        if (uY == null || TextUtils.isEmpty((CharSequence) uY.result)) {
            return null;
        }
        return (String) uY.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.ai(context.getApplicationContext()).getIid();
    }
}
