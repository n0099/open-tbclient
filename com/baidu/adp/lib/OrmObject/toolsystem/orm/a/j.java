package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j implements h {
    private List<?> tS;

    public j(List<?> list) {
        this.tS = list;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] er = cVar.er();
        JSONArray jSONArray = new JSONArray();
        for (Object obj : this.tS) {
            if (obj != null) {
                if (er != null && er.length >= 1) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(er[0]));
                    if (a != null) {
                        jSONArray.put(a);
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.es()));
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
        Type[] er = cVar.er();
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.tS) {
            if (obj != null) {
                if (er != null && er.length >= 1) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(er[0]));
                    if (a != null) {
                        arrayList.add(a.toString());
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.es()));
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
        return this.tS;
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
        return this.tS;
    }
}
