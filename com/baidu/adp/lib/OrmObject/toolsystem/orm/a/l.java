package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l implements h {
    private Map<String, Object> KU;

    public l(Map<String, Object> map) {
        this.KU = map;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        JSONObject jSONObject = new JSONObject();
        if (this.KU == null) {
            return jSONObject;
        }
        Type[] lQ = cVar.lQ();
        for (String str : this.KU.keySet()) {
            Object obj = this.KU.get(str);
            if (lQ != null && lQ.length >= 2) {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lQ[1])));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.getFieldClass())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object b(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Object a2 = a(cVar);
        if (a2 == null || !(a2 instanceof JSONObject)) {
            return null;
        }
        return a2.toString();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object c(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object d(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.KU;
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
        return this.KU;
    }
}
