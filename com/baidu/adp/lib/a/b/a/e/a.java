package com.baidu.adp.lib.a.b.a.e;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    public static final List<Object> a(c cVar, int i) {
        Class<?> cj = cVar.cj();
        if (cj == List.class || cj == ArrayList.class) {
            return new ArrayList(i);
        }
        Object a = com.baidu.adp.lib.a.a.a.a(cj, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(cj);
        }
        if (!(a instanceof List)) {
            return null;
        }
        return (List) a;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> cj = cVar.cj();
        if (cj == Set.class) {
            return new HashSet();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(cj, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(cj);
        }
        if (!(a instanceof Set)) {
            return null;
        }
        return (Set) a;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> cj = cVar.cj();
        if (cj == Queue.class) {
            return new LinkedList();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(cj, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(cj);
        }
        if (!(a instanceof Queue)) {
            return null;
        }
        return (Queue) a;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> cj = cVar.cj();
        Type[] ci = cVar.ci();
        if (com.baidu.adp.lib.a.a.a.a(cj, Map.class)) {
            if (ci != null && ci.length >= 2 && ci[0] == String.class) {
                if (cj == Map.class) {
                    return new HashMap(i);
                }
                Object a = com.baidu.adp.lib.a.a.a.a(cj, i);
                if (a == null) {
                    a = com.baidu.adp.lib.a.a.a.k(cj);
                }
                if (a instanceof Map) {
                    return (Map) a;
                }
            } else if (cj == Map.class) {
                return new HashMap(i);
            } else {
                Object a2 = com.baidu.adp.lib.a.a.a.a(cj, i);
                if (a2 == null) {
                    a2 = com.baidu.adp.lib.a.a.a.k(cj);
                }
                if (a2 instanceof Map) {
                    return (Map) a2;
                }
            }
            return null;
        }
        return null;
    }
}
