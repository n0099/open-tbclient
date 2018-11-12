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
        Class<?> hZ = cVar.hZ();
        if (hZ == List.class || hZ == ArrayList.class) {
            return new ArrayList(i);
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(hZ, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.g(hZ);
        }
        if (!(b instanceof List)) {
            return null;
        }
        return (List) b;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> hZ = cVar.hZ();
        if (hZ == Set.class) {
            return new HashSet();
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(hZ, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.g(hZ);
        }
        if (!(b instanceof Set)) {
            return null;
        }
        return (Set) b;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> hZ = cVar.hZ();
        if (hZ == Queue.class) {
            return new LinkedList();
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(hZ, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.g(hZ);
        }
        if (!(b instanceof Queue)) {
            return null;
        }
        return (Queue) b;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> hZ = cVar.hZ();
        Type[] hY = cVar.hY();
        if (com.baidu.adp.lib.OrmObject.a.a.d(hZ, Map.class)) {
            if (hY != null && hY.length >= 2 && hY[0] == String.class) {
                if (hZ == Map.class) {
                    return new HashMap(i);
                }
                Object b = com.baidu.adp.lib.OrmObject.a.a.b(hZ, i);
                if (b == null) {
                    b = com.baidu.adp.lib.OrmObject.a.a.g(hZ);
                }
                if (b instanceof Map) {
                    return (Map) b;
                }
            } else if (hZ == Map.class) {
                return new HashMap(i);
            } else {
                Object b2 = com.baidu.adp.lib.OrmObject.a.a.b(hZ, i);
                if (b2 == null) {
                    b2 = com.baidu.adp.lib.OrmObject.a.a.g(hZ);
                }
                if (b2 instanceof Map) {
                    return (Map) b2;
                }
            }
            return null;
        }
        return null;
    }
}
