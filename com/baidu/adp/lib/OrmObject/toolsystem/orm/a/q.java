package com.baidu.adp.lib.OrmObject.toolsystem.orm.a;

import android.util.SparseArray;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q implements h {
    private SparseArray<?> yY;

    public q(SparseArray<?> sparseArray) {
        this.yY = sparseArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.a.h
    public Object a(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Type[] hK = cVar.hK();
        JSONObject jSONObject = new JSONObject();
        int size = this.yY.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.yY.keyAt(i);
            Object obj = this.yY.get(keyAt);
            if (obj != null) {
                if (hK != null && hK.length >= 1) {
                    Object a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.o(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(hK[0]));
                    if (a != null) {
                        try {
                            jSONObject.put(String.valueOf(keyAt), a);
                        } catch (JSONException e) {
                        }
                    }
                } else {
                    Object a2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.f.o(obj).a(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(cVar.hL()));
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
        return this.yY;
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
        return this.yY;
    }
}
