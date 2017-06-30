package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l implements h {
    private Map<String, Object> sl;

    public l(Map<String, Object> map) {
        this.sl = map;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] ei = cVar.ei();
        Set<String> keySet = this.sl.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            Object obj = this.sl.get(str);
            if (ei != null && ei.length >= 2) {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(ei[1])));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.l(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.ej())));
                } catch (JSONException e2) {
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
        return this.sl;
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
        return this.sl;
    }
}
