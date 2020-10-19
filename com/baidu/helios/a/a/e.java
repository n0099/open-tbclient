package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.a.a.c;
import com.baidu.helios.b;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
class e implements h {
    @Override // com.baidu.helios.a.a.h
    public String a(Context context) {
        return com.baidu.helios.b.aj(context.getApplicationContext()).zZ();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray an(Context context) {
        b.C0140b c0140b;
        c cVar = new c();
        com.baidu.helios.b.aj(context).a(cVar);
        boolean a2 = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a2) {
            c.b At = cVar.At();
            if (At != null && At.result != 0 && (c0140b = (b.C0140b) At.result) != null && c0140b.Ad() != null) {
                for (b.c cVar2 : c0140b.Ad()) {
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
            cVar.Au();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.aj(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.Au();
            return null;
        }
        c.b At = cVar.At();
        if (At == null || TextUtils.isEmpty((CharSequence) At.result)) {
            return null;
        }
        return (String) At.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.aj(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.Au();
            return null;
        }
        c.b At = cVar.At();
        if (At == null || TextUtils.isEmpty((CharSequence) At.result)) {
            return null;
        }
        return (String) At.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.aj(context.getApplicationContext()).getIid();
    }
}
