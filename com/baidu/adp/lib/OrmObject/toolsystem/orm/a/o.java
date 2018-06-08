package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o implements h {
    private Set<?> wM;

    public o(Set<?> set) {
        this.wM = set;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] gF = cVar.gF();
        JSONArray jSONArray = new JSONArray();
        for (Object obj : this.wM) {
            if (obj != null) {
                if (gF != null && gF.length >= 1) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.n(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                    if (a != null) {
                        jSONArray.put(a);
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.n(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.gG()));
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        return jSONArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object b(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] gF = cVar.gF();
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.wM) {
            if (obj != null) {
                if (gF != null && gF.length >= 1) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.n(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                    if (a != null) {
                        arrayList.add(a.toString());
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.n(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.gG()));
                    if (a2 != null) {
                        arrayList.add(a2.toString());
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
        return this.wM;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object e(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
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

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object f(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.wM;
    }
}
