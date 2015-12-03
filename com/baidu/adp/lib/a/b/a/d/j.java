package com.baidu.adp.lib.a.b.a.d;

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
    private JSONArray sk;

    public j(JSONArray jSONArray) {
        this.sk = jSONArray;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        Type[] fK = cVar.fK();
        if (fL.isArray()) {
            Class<?> componentType = fL.getComponentType();
            Object newInstance = Array.newInstance(componentType, this.sk.length());
            int length = this.sk.length();
            for (int i = 0; i < length; i++) {
                Object g = com.baidu.adp.lib.a.b.a.e.g.j(this.sk.opt(i)).g(new com.baidu.adp.lib.a.b.a.e.c(componentType));
                if (g != null) {
                    Array.set(newInstance, i, g);
                }
            }
            return newInstance;
        }
        if (fK != null && fK.length >= 1) {
            if (com.baidu.adp.lib.a.a.a.a(fL, List.class)) {
                List<Object> a = com.baidu.adp.lib.a.b.a.e.a.a(cVar, this.sk.length());
                if (a != null) {
                    int length2 = this.sk.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        Object g2 = com.baidu.adp.lib.a.b.a.e.g.j(this.sk.opt(i2)).g(new com.baidu.adp.lib.a.b.a.e.c(fK[0]));
                        if (g2 != null) {
                            a.add(g2);
                        }
                    }
                    return a;
                }
                return a;
            } else if (com.baidu.adp.lib.a.a.a.a(fL, Set.class)) {
                Set<Object> b = com.baidu.adp.lib.a.b.a.e.a.b(cVar, this.sk.length());
                if (b != null) {
                    int length3 = this.sk.length();
                    for (int i3 = 0; i3 < length3; i3++) {
                        Object g3 = com.baidu.adp.lib.a.b.a.e.g.j(this.sk.opt(i3)).g(new com.baidu.adp.lib.a.b.a.e.c(fK[0]));
                        if (g3 != null) {
                            b.add(g3);
                        }
                    }
                    return b;
                }
                return b;
            } else if (com.baidu.adp.lib.a.a.a.a(fL, Map.class)) {
                Map<String, Object> d = com.baidu.adp.lib.a.b.a.e.a.d(cVar, this.sk.length());
                if (d != null) {
                    int length4 = this.sk.length();
                    for (int i4 = 0; i4 < length4; i4++) {
                        Object g4 = com.baidu.adp.lib.a.b.a.e.g.j(this.sk.opt(i4)).g(new com.baidu.adp.lib.a.b.a.e.c(fK[0]));
                        if (g4 != null) {
                            d.put(String.valueOf(i4), g4);
                        }
                    }
                    return d;
                }
                return d;
            } else if (com.baidu.adp.lib.a.a.a.a(fL, Queue.class)) {
                Queue<Object> c = com.baidu.adp.lib.a.b.a.e.a.c(cVar, this.sk.length());
                if (c != null) {
                    int length5 = this.sk.length();
                    for (int i5 = 0; i5 < length5; i5++) {
                        Object g5 = com.baidu.adp.lib.a.b.a.e.g.j(this.sk.opt(i5)).g(new com.baidu.adp.lib.a.b.a.e.c(fK[0]));
                        if (g5 != null) {
                            c.add(g5);
                        }
                    }
                    return c;
                }
                return c;
            } else if (fL == SparseArray.class) {
                SparseArray sparseArray = new SparseArray(this.sk.length());
                int length6 = this.sk.length();
                for (int i6 = 0; i6 < length6; i6++) {
                    Object g6 = com.baidu.adp.lib.a.b.a.e.g.j(this.sk.opt(i6)).g(new com.baidu.adp.lib.a.b.a.e.c(fK[0]));
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
