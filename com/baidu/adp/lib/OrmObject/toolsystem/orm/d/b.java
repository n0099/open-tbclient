package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public static final Object a(Object obj, c cVar) {
        if (obj == null || cVar == null || !obj.getClass().isArray()) {
            return null;
        }
        int length = Array.getLength(obj);
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        return a((ArrayList<Object>) arrayList, cVar);
    }

    public static final Object a(List<Object> list, c cVar) {
        if (list == null || cVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return a((ArrayList<Object>) arrayList, cVar);
    }

    public static final Object a(Queue<Object> queue, c cVar) {
        if (queue == null || cVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(queue.size());
        for (Object obj : queue) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return a((ArrayList<Object>) arrayList, cVar);
    }

    public static final Object a(Set<Object> set, c cVar) {
        if (set == null || cVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(set.size());
        for (Object obj : set) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return a((ArrayList<Object>) arrayList, cVar);
    }

    public static final Object a(SparseArray<Object> sparseArray, c cVar) {
        if (sparseArray == null || cVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            Object obj = sparseArray.get(sparseArray.keyAt(i));
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return a((ArrayList<Object>) arrayList, cVar);
    }

    private static final Object a(ArrayList<Object> arrayList, c cVar) {
        Object g;
        Object g2;
        Object g3;
        Object g4;
        int i = 0;
        if (arrayList == null || cVar == null) {
            return null;
        }
        Class<?> hY = cVar.hY();
        Type[] hX = cVar.hX();
        if (hY.isArray()) {
            Object newInstance = Array.newInstance(hY.getComponentType(), arrayList.size());
            Iterator<Object> it = arrayList.iterator();
            while (it.hasNext()) {
                Object g5 = g.s(it.next()).g(new c(hY.getComponentType()));
                if (g5 != null) {
                    Array.set(newInstance, i, g5);
                }
                i++;
            }
            return newInstance;
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(hY, List.class)) {
            List<Object> a = a.a(cVar, arrayList.size());
            if (a != null) {
                Iterator<Object> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    h s = g.s(it2.next());
                    if (hX != null && hX.length >= 1 && (g4 = s.g(new c(hX[0]))) != null) {
                        a.add(g4);
                    }
                }
            }
            return a;
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(hY, Queue.class)) {
            Queue<Object> c = a.c(cVar, arrayList.size());
            if (c != null) {
                Iterator<Object> it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    h s2 = g.s(it3.next());
                    if (hX != null && hX.length >= 1 && (g3 = s2.g(new c(hX[0]))) != null) {
                        c.add(g3);
                    }
                }
            }
            return c;
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(hY, Set.class)) {
            Set<Object> b = a.b(cVar, arrayList.size());
            if (b != null) {
                Iterator<Object> it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    h s3 = g.s(it4.next());
                    if (hX != null && hX.length >= 1 && (g2 = s3.g(new c(hX[0]))) != null) {
                        b.add(g2);
                    }
                }
            }
            return b;
        } else if (com.baidu.adp.lib.OrmObject.a.a.d(hY, Map.class)) {
            Map<String, Object> d = a.d(cVar, arrayList.size());
            if (d != null) {
                Iterator<Object> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    h s4 = g.s(it5.next());
                    if (hX != null && hX.length >= 2) {
                        g = s4.g(new c(hX[1]));
                    } else {
                        g = s4.g(new c(String.class));
                    }
                    if (g != null) {
                        d.put(String.valueOf(i), g);
                    }
                    i++;
                }
            }
            return d;
        } else if (hY != SparseArray.class) {
            return hY == Bundle.class ? null : null;
        } else {
            SparseArray sparseArray = new SparseArray();
            Iterator<Object> it6 = arrayList.iterator();
            int i2 = 0;
            while (it6.hasNext()) {
                Object next = it6.next();
                h s5 = g.s(next);
                if (hX != null && hX.length >= 1 && s5.g(new c(hX[0])) != null) {
                    sparseArray.put(i2, next);
                }
                i2++;
            }
            return sparseArray;
        }
    }
}
