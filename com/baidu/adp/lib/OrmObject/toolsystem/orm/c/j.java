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
    private JSONArray xE;

    public j(JSONArray jSONArray) {
        this.xE = jSONArray;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gS = cVar.gS();
        Type[] gR = cVar.gR();
        if (gS.isArray()) {
            Class<?> componentType = gS.getComponentType();
            Object newInstance = Array.newInstance(componentType, this.xE.length());
            int length = this.xE.length();
            for (int i = 0; i < length; i++) {
                Object g = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xE.opt(i)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(componentType));
                if (g != null) {
                    Array.set(newInstance, i, g);
                }
            }
            return newInstance;
        }
        if (gR != null && gR.length >= 1) {
            if (com.baidu.adp.lib.OrmObject.a.a.d(gS, List.class)) {
                List<Object> a = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.a(cVar, this.xE.length());
                if (a != null) {
                    int length2 = this.xE.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object g2 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xE.opt(i2)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gR[0]));
                        if (g2 != null) {
                            a.add(g2);
                        }
                    }
                    return a;
                }
                return a;
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(gS, Set.class)) {
                Set<Object> b = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.b(cVar, this.xE.length());
                if (b != null) {
                    int length3 = this.xE.length();
                    for (int i3 = 0; i3 < length3; i3++) {
                        Object g3 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xE.opt(i3)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gR[0]));
                        if (g3 != null) {
                            b.add(g3);
                        }
                    }
                    return b;
                }
                return b;
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(gS, Map.class)) {
                Map<String, Object> d = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.d(cVar, this.xE.length());
                if (d != null) {
                    int length4 = this.xE.length();
                    for (int i4 = 0; i4 < length4; i4++) {
                        Object g4 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xE.opt(i4)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gR[0]));
                        if (g4 != null) {
                            d.put(String.valueOf(i4), g4);
                        }
                    }
                    return d;
                }
                return d;
            } else if (com.baidu.adp.lib.OrmObject.a.a.d(gS, Queue.class)) {
                Queue<Object> c = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.a.c(cVar, this.xE.length());
                if (c != null) {
                    int length5 = this.xE.length();
                    for (int i5 = 0; i5 < length5; i5++) {
                        Object g5 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xE.opt(i5)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gR[0]));
                        if (g5 != null) {
                            c.add(g5);
                        }
                    }
                    return c;
                }
                return c;
            } else if (gS == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.xE.length());
                int length6 = this.xE.length();
                for (int i6 = 0; i6 < length6; i6++) {
                    Object g6 = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.s(this.xE.opt(i6)).g(new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(gR[0]));
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
