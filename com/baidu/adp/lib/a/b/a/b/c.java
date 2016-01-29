package com.baidu.adp.lib.a.b.a.b;

import android.os.Bundle;
import java.lang.reflect.Type;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements h {
    private Bundle rY;

    public c(Bundle bundle) {
        this.rY = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object a(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Type[] fS = cVar.fS();
        Set<String> keySet = this.rY.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            Object obj = this.rY.get(str);
            if (fS != null && fS.length >= 2) {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.a.b.a.e.f.i(obj).a(new com.baidu.adp.lib.a.b.a.e.c(fS[1])));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.a.b.a.e.f.i(obj).a(new com.baidu.adp.lib.a.b.a.e.c(cVar.fT())));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object b(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.rY;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object c(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object d(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.rY;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object e(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Object a = a(cVar);
        if (a != null) {
            if (a instanceof JSONObject) {
                return a.toString();
            }
            if (a instanceof JSONArray) {
                return a.toString();
            }
            return a;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object f(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.rY;
    }
}
