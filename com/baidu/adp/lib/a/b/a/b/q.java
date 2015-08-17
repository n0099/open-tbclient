package com.baidu.adp.lib.a.b.a.b;

import android.util.SparseArray;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q implements h {
    private SparseArray<?> sa;

    public q(SparseArray<?> sparseArray) {
        this.sa = sparseArray;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object a(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Type[] fN = cVar.fN();
        JSONObject jSONObject = new JSONObject();
        int size = this.sa.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.sa.keyAt(i);
            Object obj = this.sa.get(keyAt);
            if (obj != null) {
                if (fN != null && fN.length >= 1) {
                    Object a = com.baidu.adp.lib.a.b.a.e.f.i(obj).a(new com.baidu.adp.lib.a.b.a.e.c(fN[0]));
                    if (a != null) {
                        try {
                            jSONObject.put(String.valueOf(keyAt), a);
                        } catch (JSONException e) {
                        }
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.a.b.a.e.f.i(obj).a(new com.baidu.adp.lib.a.b.a.e.c(cVar.fO()));
                    if (a2 != null) {
                        try {
                            jSONObject.put(String.valueOf(keyAt), a2);
                        } catch (JSONException e2) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object b(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Object a = a(cVar);
        if (a == null || !(a instanceof JSONObject)) {
            return null;
        }
        return a.toString();
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object c(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object d(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.sa;
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
        return this.sa;
    }
}
