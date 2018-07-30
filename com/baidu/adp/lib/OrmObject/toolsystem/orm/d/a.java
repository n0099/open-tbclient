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
        Class<?> gF = cVar.gF();
        if (gF == List.class || gF == ArrayList.class) {
            return new ArrayList(i);
        }
        Object a = com.baidu.adp.lib.OrmObject.a.a.a(gF, i);
        if (a == null) {
            a = com.baidu.adp.lib.OrmObject.a.a.d(gF);
        }
        if (!(a instanceof List)) {
            return null;
        }
        return (List) a;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> gF = cVar.gF();
        if (gF == Set.class) {
            return new HashSet();
        }
        Object a = com.baidu.adp.lib.OrmObject.a.a.a(gF, i);
        if (a == null) {
            a = com.baidu.adp.lib.OrmObject.a.a.d(gF);
        }
        if (!(a instanceof Set)) {
            return null;
        }
        return (Set) a;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> gF = cVar.gF();
        if (gF == Queue.class) {
            return new LinkedList();
        }
        Object a = com.baidu.adp.lib.OrmObject.a.a.a(gF, i);
        if (a == null) {
            a = com.baidu.adp.lib.OrmObject.a.a.d(gF);
        }
        if (!(a instanceof Queue)) {
            return null;
        }
        return (Queue) a;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> gF = cVar.gF();
        Type[] gE = cVar.gE();
        if (com.baidu.adp.lib.OrmObject.a.a.d(gF, Map.class)) {
            if (gE != null && gE.length >= 2 && gE[0] == String.class) {
                if (gF == Map.class) {
                    return new HashMap(i);
                }
                Object a = com.baidu.adp.lib.OrmObject.a.a.a(gF, i);
                if (a == null) {
                    a = com.baidu.adp.lib.OrmObject.a.a.d(gF);
                }
                if (a instanceof Map) {
                    return (Map) a;
                }
            } else if (gF == Map.class) {
                return new HashMap(i);
            } else {
                Object a2 = com.baidu.adp.lib.OrmObject.a.a.a(gF, i);
                if (a2 == null) {
                    a2 = com.baidu.adp.lib.OrmObject.a.a.d(gF);
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
