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
        Class<?> gS = cVar.gS();
        if (gS == List.class || gS == ArrayList.class) {
            return new ArrayList(i);
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(gS, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.f(gS);
        }
        if (!(b instanceof List)) {
            return null;
        }
        return (List) b;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> gS = cVar.gS();
        if (gS == Set.class) {
            return new HashSet();
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(gS, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.f(gS);
        }
        if (!(b instanceof Set)) {
            return null;
        }
        return (Set) b;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> gS = cVar.gS();
        if (gS == Queue.class) {
            return new LinkedList();
        }
        Object b = com.baidu.adp.lib.OrmObject.a.a.b(gS, i);
        if (b == null) {
            b = com.baidu.adp.lib.OrmObject.a.a.f(gS);
        }
        if (!(b instanceof Queue)) {
            return null;
        }
        return (Queue) b;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> gS = cVar.gS();
        Type[] gR = cVar.gR();
        if (com.baidu.adp.lib.OrmObject.a.a.d(gS, Map.class)) {
            if (gR != null && gR.length >= 2 && gR[0] == String.class) {
                if (gS == Map.class) {
                    return new HashMap(i);
                }
                Object b = com.baidu.adp.lib.OrmObject.a.a.b(gS, i);
                if (b == null) {
                    b = com.baidu.adp.lib.OrmObject.a.a.f(gS);
                }
                if (b instanceof Map) {
                    return (Map) b;
                }
            } else if (gS == Map.class) {
                return new HashMap(i);
            } else {
                Object b2 = com.baidu.adp.lib.OrmObject.a.a.b(gS, i);
                if (b2 == null) {
                    b2 = com.baidu.adp.lib.OrmObject.a.a.f(gS);
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
