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
        Class<?> cs = cVar.cs();
        if (cs == List.class || cs == ArrayList.class) {
            return new ArrayList(i);
        }
        Object a = com.baidu.adp.lib.a.a.a.a(cs, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.j(cs);
        }
        if (!(a instanceof List)) {
            return null;
        }
        return (List) a;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> cs = cVar.cs();
        if (cs == Set.class) {
            return new HashSet();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(cs, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.j(cs);
        }
        if (!(a instanceof Set)) {
            return null;
        }
        return (Set) a;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> cs = cVar.cs();
        if (cs == Queue.class) {
            return new LinkedList();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(cs, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.j(cs);
        }
        if (!(a instanceof Queue)) {
            return null;
        }
        return (Queue) a;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> cs = cVar.cs();
        Type[] cr = cVar.cr();
        if (com.baidu.adp.lib.a.a.a.a(cs, Map.class)) {
            if (cr != null && cr.length >= 2 && cr[0] == String.class) {
                if (cs == Map.class) {
                    return new HashMap(i);
                }
                Object a = com.baidu.adp.lib.a.a.a.a(cs, i);
                if (a == null) {
                    a = com.baidu.adp.lib.a.a.a.j(cs);
                }
                if (a instanceof Map) {
                    return (Map) a;
                }
            } else if (cs == Map.class) {
                return new HashMap(i);
            } else {
                Object a2 = com.baidu.adp.lib.a.a.a.a(cs, i);
                if (a2 == null) {
                    a2 = com.baidu.adp.lib.a.a.a.j(cs);
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
