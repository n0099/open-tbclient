package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import android.util.SparseArray;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q implements h {
    private SparseArray<?> Kf;

    public q(SparseArray<?> sparseArray) {
        this.Kf = sparseArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] lQ = cVar.lQ();
        JSONObject jSONObject = new JSONObject();
        int size = this.Kf.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.Kf.keyAt(i);
            Object obj = this.Kf.get(keyAt);
            if (obj != null) {
                if (lQ != null && lQ.length >= 1) {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(lQ[0]));
                    if (a2 != null) {
                        try {
                            jSONObject.put(String.valueOf(keyAt), a2);
                        } catch (JSONException e) {
                        }
                    }
                } else {
                    Object a3 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.v(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.getFieldClass()));
                    if (a3 != null) {
                        try {
                            jSONObject.put(String.valueOf(keyAt), a3);
                        } catch (JSONException e2) {
                        }
                    }
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
        return this.Kf;
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
        return this.Kf;
    }
}
