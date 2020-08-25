package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l implements h {
    private Map<String, Object> JD;

    public l(Map<String, Object> map) {
        this.JD = map;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        JSONObject jSONObject = new JSONObject();
        if (this.JD == null) {
            return jSONObject;
        }
        Type[] lL = cVar.lL();
        for (String str : this.JD.keySet()) {
            Object obj = this.JD.get(str);
            if (lL != null && lL.length >= 2) {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.u(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lL[1])));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.u(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.getFieldClass())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object b(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Object a = a(cVar);
        if (a == null || !(a instanceof JSONObject)) {
            return null;
        }
        return a.toString();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object c(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return b(cVar);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object d(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return this.JD;
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
        return this.JD;
    }
}
