package com.baidu.adp.lib.a.b.a.b;

import android.os.Bundle;
import java.lang.reflect.Type;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements h {
    private Bundle hV;

    public c(Bundle bundle) {
        this.hV = bundle;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object a(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Type[] ch = cVar.ch();
        Set<String> keySet = this.hV.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            Object obj = this.hV.get(str);
            if (ch != null && ch.length >= 2) {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.a.b.a.e.f.i(obj).a(new com.baidu.adp.lib.a.b.a.e.c(ch[1])));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.a.b.a.e.f.i(obj).a(new com.baidu.adp.lib.a.b.a.e.c(cVar.ci())));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object b(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.hV;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object c(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object d(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.hV;
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
        return this.hV;
    }
}
