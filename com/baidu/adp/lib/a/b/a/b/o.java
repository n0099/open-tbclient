package com.baidu.adp.lib.a.b.a.b;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o implements h {
    private Set<?> gw;

    public o(Set<?> set) {
        this.gw = set;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object a(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Type[] cp = cVar.cp();
        JSONArray jSONArray = new JSONArray();
        for (Object obj : this.gw) {
            if (obj != null) {
                if (cp != null && cp.length >= 1) {
                    Object a = com.baidu.adp.lib.a.b.a.e.f.h(obj).a(new com.baidu.adp.lib.a.b.a.e.c(cp[0]));
                    if (a != null) {
                        jSONArray.put(a);
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.a.b.a.e.f.h(obj).a(new com.baidu.adp.lib.a.b.a.e.c(cVar.cq()));
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        return jSONArray;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object b(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Type[] cp = cVar.cp();
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.gw) {
            if (obj != null) {
                if (cp != null && cp.length >= 1) {
                    Object a = com.baidu.adp.lib.a.b.a.e.f.h(obj).a(new com.baidu.adp.lib.a.b.a.e.c(cp[0]));
                    if (a != null) {
                        arrayList.add(a.toString());
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.a.b.a.e.f.h(obj).a(new com.baidu.adp.lib.a.b.a.e.c(cVar.cq()));
                    if (a2 != null) {
                        arrayList.add(a2.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object c(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.a.b.a.b.h
    public Object d(com.baidu.adp.lib.a.b.a.e.c cVar) {
        return this.gw;
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
        return this.gw;
    }
}
