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
    private JSONArray IK;

    public j(JSONArray jSONArray) {
        this.IK = jSONArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        Type[] jW = cVar.jW();
        if (fieldClass.isArray()) {
            Class<?> componentType = fieldClass.getComponentType();
            Object newInstance = Array.newInstance(componentType, this.IK.length());
            int length = this.IK.length();
            for (int i = 0; i < length; i++) {
                Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.u(this.IK.opt(i)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
                if (g != null) {
                    Array.set(newInstance, i, g);
                }
            }
            return newInstance;
        }
        if (jW != null && jW.length >= 1) {
            if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fieldClass, List.class)) {
                List<Object> a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.a(cVar, this.IK.length());
                if (a != null) {
                    int length2 = this.IK.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.u(this.IK.opt(i2)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(jW[0]));
                        if (g2 != null) {
                            a.add(g2);
                        }
                    }
                    return a;
                }
                return a;
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fieldClass, Set.class)) {
                Set<Object> b = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.b(cVar, this.IK.length());
                if (b != null) {
                    int length3 = this.IK.length();
                    for (int i3 = 0; i3 < length3; i3++) {
                        Object g3 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.u(this.IK.opt(i3)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(jW[0]));
                        if (g3 != null) {
                            b.add(g3);
                        }
                    }
                    return b;
                }
                return b;
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fieldClass, Map.class)) {
                Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.IK.length());
                if (d != null) {
                    int length4 = this.IK.length();
                    for (int i4 = 0; i4 < length4; i4++) {
                        Object g4 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.u(this.IK.opt(i4)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(jW[0]));
                        if (g4 != null) {
                            d.put(String.valueOf(i4), g4);
                        }
                    }
                    return d;
                }
                return d;
            } else if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fieldClass, Queue.class)) {
                Queue<Object> c = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.c(cVar, this.IK.length());
                if (c != null) {
                    int length5 = this.IK.length();
                    for (int i5 = 0; i5 < length5; i5++) {
                        Object g5 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.u(this.IK.opt(i5)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(jW[0]));
                        if (g5 != null) {
                            c.add(g5);
                        }
                    }
                    return c;
                }
                return c;
            } else if (fieldClass == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.IK.length());
                int length6 = this.IK.length();
                for (int i6 = 0; i6 < length6; i6++) {
                    Object g6 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.u(this.IK.opt(i6)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(jW[0]));
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
