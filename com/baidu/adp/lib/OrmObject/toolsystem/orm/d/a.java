package com.baidu.adp.lib.OrmObject.toolsystem.orm.d;

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
        Class<?> ia = cVar.ia();
        if (ia == List.class || ia == ArrayList.class) {
            return new ArrayList(i);
        }
        Object a = com.baidu.adp.lib.OrmObject.a.a.a(ia, i);
        if (a == null) {
            a = com.baidu.adp.lib.OrmObject.a.a.g(ia);
        }
        if (!(a instanceof List)) {
            return null;
        }
        return (List) a;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> ia = cVar.ia();
        if (ia == Set.class) {
            return new HashSet();
        }
        Object a = com.baidu.adp.lib.OrmObject.a.a.a(ia, i);
        if (a == null) {
            a = com.baidu.adp.lib.OrmObject.a.a.g(ia);
        }
        if (!(a instanceof Set)) {
            return null;
        }
        return (Set) a;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> ia = cVar.ia();
        if (ia == Queue.class) {
            return new LinkedList();
        }
        Object a = com.baidu.adp.lib.OrmObject.a.a.a(ia, i);
        if (a == null) {
            a = com.baidu.adp.lib.OrmObject.a.a.g(ia);
        }
        if (!(a instanceof Queue)) {
            return null;
        }
        return (Queue) a;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> ia = cVar.ia();
        Type[] hZ = cVar.hZ();
        if (com.baidu.adp.lib.OrmObject.a.a.d(ia, Map.class)) {
            if (hZ != null && hZ.length >= 2 && hZ[0] == String.class) {
                if (ia == Map.class) {
                    return new HashMap(i);
                }
                Object a = com.baidu.adp.lib.OrmObject.a.a.a(ia, i);
                if (a == null) {
                    a = com.baidu.adp.lib.OrmObject.a.a.g(ia);
                }
                if (a instanceof Map) {
                    return (Map) a;
                }
            } else if (ia == Map.class) {
                return new HashMap(i);
            } else {
                Object a2 = com.baidu.adp.lib.OrmObject.a.a.a(ia, i);
                if (a2 == null) {
                    a2 = com.baidu.adp.lib.OrmObject.a.a.g(ia);
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
