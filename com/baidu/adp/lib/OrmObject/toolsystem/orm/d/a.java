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
        Class<?> hb = cVar.hb();
        if (hb == List.class || hb == ArrayList.class) {
            return new ArrayList(i);
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(hb, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.f(hb);
        }
        if (!(b instanceof List)) {
            return null;
        }
        return (List) b;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> hb = cVar.hb();
        if (hb == Set.class) {
            return new HashSet();
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(hb, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.f(hb);
        }
        if (!(b instanceof Set)) {
            return null;
        }
        return (Set) b;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> hb = cVar.hb();
        if (hb == Queue.class) {
            return new LinkedList();
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(hb, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.f(hb);
        }
        if (!(b instanceof Queue)) {
            return null;
        }
        return (Queue) b;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> hb = cVar.hb();
        Type[] ha = cVar.ha();
        if (com.baidu.adp.lib.OrmObject.a.a.d(hb, Map.class)) {
            if (ha != null && ha.length >= 2 && ha[0] == String.class) {
                if (hb == Map.class) {
                    return new HashMap(i);
                }
                Object b = com.baidu.adp.lib.OrmObject.a.a.b(hb, i);
                if (b == null) {
                    b = com.baidu.adp.lib.OrmObject.a.a.f(hb);
                }
                if (b instanceof Map) {
                    return (Map) b;
                }
            } else if (hb == Map.class) {
                return new HashMap(i);
            } else {
                Object b2 = com.baidu.adp.lib.OrmObject.a.a.b(hb, i);
                if (b2 == null) {
                    b2 = com.baidu.adp.lib.OrmObject.a.a.f(hb);
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
