package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.a.a.c;
import com.baidu.helios.b;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
class e implements h {
    @Override // com.baidu.helios.a.a.h
    public String a(Context context) {
        return com.baidu.helios.b.aj(context.getApplicationContext()).zq();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray an(Context context) {
        b.C0138b c0138b;
        c cVar = new c();
        com.baidu.helios.b.aj(context).a(cVar);
        boolean a2 = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a2) {
            c.b zK = cVar.zK();
            if (zK != null && zK.result != 0 && (c0138b = (b.C0138b) zK.result) != null && c0138b.zu() != null) {
                for (b.c cVar2 : c0138b.zu()) {
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
            cVar.zL();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.aj(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.zL();
            return null;
        }
        c.b zK = cVar.zK();
        if (zK == null || TextUtils.isEmpty((CharSequence) zK.result)) {
            return null;
        }
        return (String) zK.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.aj(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.zL();
            return null;
        }
        c.b zK = cVar.zK();
        if (zK == null || TextUtils.isEmpty((CharSequence) zK.result)) {
            return null;
        }
        return (String) zK.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.aj(context.getApplicationContext()).getIid();
    }
}
