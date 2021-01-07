package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.helios.a.a.c;
import com.baidu.helios.b;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
class e implements h {
    @Override // com.baidu.helios.a.a.h
    public String a(Context context) {
        return com.baidu.helios.b.ak(context.getApplicationContext()).yz();
    }

    @Override // com.baidu.helios.a.a.h
    public JSONArray ao(Context context) {
        b.C0128b c0128b;
        c cVar = new c();
        com.baidu.helios.b.ak(context).a(cVar);
        boolean a2 = cVar.a(10000);
        JSONArray jSONArray = new JSONArray();
        if (a2) {
            c.b yT = cVar.yT();
            if (yT != null && yT.result != 0 && (c0128b = (b.C0128b) yT.result) != null && c0128b.yD() != null) {
                for (b.c cVar2 : c0128b.yD()) {
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
            cVar.yU();
        }
        return jSONArray;
    }

    @Override // com.baidu.helios.a.a.h
    public String c(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ak(context).b(cVar);
        if (!cVar.a(10000)) {
            cVar.yU();
            return null;
        }
        c.b yT = cVar.yT();
        if (yT == null || TextUtils.isEmpty((CharSequence) yT.result)) {
            return null;
        }
        return (String) yT.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String d(Context context) {
        c cVar = new c();
        com.baidu.helios.b.ak(context).c(cVar);
        if (!cVar.a(10000)) {
            cVar.yU();
            return null;
        }
        c.b yT = cVar.yT();
        if (yT == null || TextUtils.isEmpty((CharSequence) yT.result)) {
            return null;
        }
        return (String) yT.result;
    }

    @Override // com.baidu.helios.a.a.h
    public String e(Context context) {
        return com.baidu.helios.b.ak(context.getApplicationContext()).getIid();
    }
}
