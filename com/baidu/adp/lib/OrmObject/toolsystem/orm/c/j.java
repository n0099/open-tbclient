package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import android.util.SparseArray;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class j implements h {
    private JSONArray wW;

    public j(JSONArray jSONArray) {
        this.wW = jSONArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gG = cVar.gG();
        Type[] gF = cVar.gF();
        if (gG.isArray()) {
            Class<?> componentType = gG.getComponentType();
            Object newInstance = Array.newInstance(componentType, this.wW.length());
            int length = this.wW.length();
            for (int i = 0; i < length; i++) {
                Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wW.opt(i)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
                if (g != null) {
                    Array.set(newInstance, i, g);
                }
            }
            return newInstance;
        }
        if (gF != null && gF.length >= 1) {
            if (com.baidu.adp.lib.OrmObject.a.a.d(gG, List.class)) {
                List<Object> a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.a(cVar, this.wW.length());
                if (a != null) {
                    int length2 = this.wW.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wW.opt(i2)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                        if (g2 != null) {
                            a.add(g2);
                        }
                    }
                    return a;
                }
                return a;
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(gG, Set.class)) {
                Set<Object> b = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.b(cVar, this.wW.length());
                if (b != null) {
                    int length3 = this.wW.length();
                    for (int i3 = 0; i3 < length3; i3++) {
                        Object g3 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wW.opt(i3)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                        if (g3 != null) {
                            b.add(g3);
                        }
                    }
                    return b;
                }
                return b;
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(gG, Map.class)) {
                Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.wW.length());
                if (d != null) {
                    int length4 = this.wW.length();
                    for (int i4 = 0; i4 < length4; i4++) {
                        Object g4 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wW.opt(i4)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                        if (g4 != null) {
                            d.put(String.valueOf(i4), g4);
                        }
                    }
                    return d;
                }
                return d;
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(gG, Queue.class)) {
                Queue<Object> c = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.c(cVar, this.wW.length());
                if (c != null) {
                    int length5 = this.wW.length();
                    for (int i5 = 0; i5 < length5; i5++) {
                        Object g5 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wW.opt(i5)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                        if (g5 != null) {
                            c.add(g5);
                        }
                    }
                    return c;
                }
                return c;
            } else if (gG == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.wW.length());
                int length6 = this.wW.length();
                for (int i6 = 0; i6 < length6; i6++) {
                    Object g6 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.o(this.wW.opt(i6)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gF[0]));
                    if (g6 != null) {
                        sparseArray.put(i6, g6);
                    }
                }
                return sparseArray;
            }
        }
        return null;
    }
}
