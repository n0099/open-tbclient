package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o implements h {
    private Set<?> Ke;

    public o(Set<?> set) {
        this.Ke = set;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] lQ = cVar.lQ();
        JSONArray jSONArray = new JSONArray();
        for (Object obj : this.Ke) {
            if (obj != null) {
                if (lQ != null && lQ.length >= 1) {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lQ[0]));
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                } else {
                    Object a3 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.getFieldClass()));
                    if (a3 != null) {
                        jSONArray.put(a3);
                    }
                }
            }
        }
        return jSONArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object b(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] lQ = cVar.lQ();
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.Ke) {
            if (obj != null) {
                if (lQ != null && lQ.length >= 1) {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lQ[0]));
                    if (a2 != null) {
                        arrayList.add(a2.toString());
                    }
                } else {
                    Object a3 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.getFieldClass()));
                    if (a3 != null) {
                        arrayList.add(a3.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object c(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object d(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.Ke;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object e(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Object a2 = a(cVar);
        if (a2 != null) {
            if (a2 instanceof JSONObject) {
                return a2.toString();
            }
            if (a2 instanceof JSONArray) {
                return a2.toString();
            }
            return a2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object f(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.Ke;
    }
}
