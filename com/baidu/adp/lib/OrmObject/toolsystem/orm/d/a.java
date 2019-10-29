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
        Class<?> eV = cVar.eV();
        if (eV == List.class || eV == ArrayList.class) {
            return new ArrayList(i);
        }
        if (eV == LinkedList.class) {
            return new LinkedList();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(eV, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(eV);
        }
        if (!(newOneIntParamsInstance instanceof List)) {
            return null;
        }
        return (List) newOneIntParamsInstance;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> eV = cVar.eV();
        if (eV == Set.class) {
            return new HashSet();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(eV, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(eV);
        }
        if (!(newOneIntParamsInstance instanceof Set)) {
            return null;
        }
        return (Set) newOneIntParamsInstance;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> eV = cVar.eV();
        if (eV == Queue.class) {
            return new LinkedList();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(eV, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(eV);
        }
        if (!(newOneIntParamsInstance instanceof Queue)) {
            return null;
        }
        return (Queue) newOneIntParamsInstance;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> eV = cVar.eV();
        Type[] eU = cVar.eU();
        if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(eV, Map.class)) {
            if (eU != null && eU.length >= 2 && eU[0] == String.class) {
                if (eV == Map.class) {
                    return new HashMap(i);
                }
                Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(eV, i);
                if (newOneIntParamsInstance == null) {
                    newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(eV);
                }
                if (newOneIntParamsInstance instanceof Map) {
                    return (Map) newOneIntParamsInstance;
                }
            } else if (eV == Map.class) {
                return new HashMap(i);
            } else {
                Object newOneIntParamsInstance2 = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(eV, i);
                if (newOneIntParamsInstance2 == null) {
                    newOneIntParamsInstance2 = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(eV);
                }
                if (newOneIntParamsInstance2 instanceof Map) {
                    return (Map) newOneIntParamsInstance2;
                }
            }
            return null;
        }
        return null;
    }
}
