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
        return com.baidu.helios.b.ag(context.getApplicationContext()).zD();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray ak(Context context) {
        b.C0135b c0135b;
        c cVar = new c();
        com.baidu.helios.b.ag(context).a(cVar);
        boolean a = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a) {
            c.b zX = cVar.zX();
            if (zX != null && zX.result != 0 && (c0135b = (b.C0135b) zX.result) != null && c0135b.zH() != null) {
                for (b.c cVar2 : c0135b.zH()) {
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
            cVar.zY();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ag(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.zY();
            return null;
        }
        c.b zX = cVar.zX();
        if (zX == null || TextUtils.isEmpty((CharSequence) zX.result)) {
            return null;
        }
        return (String) zX.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ag(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.zY();
            return null;
        }
        c.b zX = cVar.zX();
        if (zX == null || TextUtils.isEmpty((CharSequence) zX.result)) {
            return null;
        }
        return (String) zX.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.ag(context.getApplicationContext()).getIid();
    }
}
