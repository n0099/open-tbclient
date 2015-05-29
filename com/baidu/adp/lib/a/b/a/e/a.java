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
        Class<?> fT = cVar.fT();
        if (fT == List.class || fT == ArrayList.class) {
            return new ArrayList(i);
        }
        Object a = com.baidu.adp.lib.a.a.a.a(fT, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.j(fT);
        }
        if (!(a instanceof List)) {
            return null;
        }
        return (List) a;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> fT = cVar.fT();
        if (fT == Set.class) {
            return new HashSet();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(fT, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.j(fT);
        }
        if (!(a instanceof Set)) {
            return null;
        }
        return (Set) a;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> fT = cVar.fT();
        if (fT == Queue.class) {
            return new LinkedList();
        }
        Object a = com.baidu.adp.lib.a.a.a.a(fT, i);
        if (a == null) {
            a = com.baidu.adp.lib.a.a.a.j(fT);
        }
        if (!(a instanceof Queue)) {
            return null;
        }
        return (Queue) a;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> fT = cVar.fT();
        Type[] fS = cVar.fS();
        if (com.baidu.adp.lib.a.a.a.a(fT, Map.class)) {
            if (fS != null && fS.length >= 2 && fS[0] == String.class) {
                if (fT == Map.class) {
                    return new HashMap(i);
                }
                Object a = com.baidu.adp.lib.a.a.a.a(fT, i);
                if (a == null) {
                    a = com.baidu.adp.lib.a.a.a.j(fT);
                }
                if (a instanceof Map) {
                    return (Map) a;
                }
            } else if (fT == Map.class) {
                return new HashMap(i);
            } else {
                Object a2 = com.baidu.adp.lib.a.a.a.a(fT, i);
                if (a2 == null) {
                    a2 = com.baidu.adp.lib.a.a.a.j(fT);
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
