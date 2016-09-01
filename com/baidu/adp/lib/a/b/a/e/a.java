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
        Class<?> dd = cVar.dd();
        if (dd == List.class || dd == ArrayList.class) {
            return new ArrayList(i);
        }
        Object a = com.baidu.adp.lib.a.a.a.a(dd, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(dd);
        }
        if (!(a instanceof List)) {
            return null;
        }
        return (List) a;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> dd = cVar.dd();
        if (dd == Set.class) {
            return new HashSet();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(dd, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(dd);
        }
        if (!(a instanceof Set)) {
            return null;
        }
        return (Set) a;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> dd = cVar.dd();
        if (dd == Queue.class) {
            return new LinkedList();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(dd, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.k(dd);
        }
        if (!(a instanceof Queue)) {
            return null;
        }
        return (Queue) a;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> dd = cVar.dd();
        Type[] dc = cVar.dc();
        if (com.baidu.adp.lib.a.a.a.e(dd, Map.class)) {
            if (dc != null && dc.length >= 2 && dc[0] == String.class) {
                if (dd == Map.class) {
                    return new HashMap(i);
                }
                Object a = com.baidu.adp.lib.a.a.a.a(dd, i);
                if (a == null) {
                    a = com.baidu.adp.lib.a.a.a.k(dd);
                }
                if (a instanceof Map) {
                    return (Map) a;
                }
            } else if (dd == Map.class) {
                return new HashMap(i);
            } else {
                Object a2 = com.baidu.adp.lib.a.a.a.a(dd, i);
                if (a2 == null) {
                    a2 = com.baidu.adp.lib.a.a.a.k(dd);
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
