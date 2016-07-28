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
        Class<?> ci = cVar.ci();
        if (ci == List.class || ci == ArrayList.class) {
            return new ArrayList(i);
        }
        Object a = com.baidu.adp.lib.a.a.a.a(ci, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(ci);
        }
        if (!(a instanceof List)) {
            return null;
        }
        return (List) a;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> ci = cVar.ci();
        if (ci == Set.class) {
            return new HashSet();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(ci, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(ci);
        }
        if (!(a instanceof Set)) {
            return null;
        }
        return (Set) a;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> ci = cVar.ci();
        if (ci == Queue.class) {
            return new LinkedList();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(ci, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(ci);
        }
        if (!(a instanceof Queue)) {
            return null;
        }
        return (Queue) a;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> ci = cVar.ci();
        Type[] ch = cVar.ch();
        if (com.baidu.adp.lib.a.a.a.e(ci, Map.class)) {
            if (ch != null && ch.length >= 2 && ch[0] == String.class) {
                if (ci == Map.class) {
                    return new HashMap(i);
                }
                Object a = com.baidu.adp.lib.a.a.a.a(ci, i);
                if (a == null) {
                    a = com.baidu.adp.lib.a.a.a.k(ci);
                }
                if (a instanceof Map) {
                    return (Map) a;
                }
            } else if (ci == Map.class) {
                return new HashMap(i);
            } else {
                Object a2 = com.baidu.adp.lib.a.a.a.a(ci, i);
                if (a2 == null) {
                    a2 = com.baidu.adp.lib.a.a.a.k(ci);
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
