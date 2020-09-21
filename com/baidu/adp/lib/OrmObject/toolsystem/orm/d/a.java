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
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == List.class || fieldClass == ArrayList.class) {
            return new ArrayList(i);
        }
        if (fieldClass == LinkedList.class) {
            return new LinkedList();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fieldClass, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fieldClass);
        }
        if (!(newOneIntParamsInstance instanceof List)) {
            return null;
        }
        return (List) newOneIntParamsInstance;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Set.class) {
            return new HashSet();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fieldClass, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fieldClass);
        }
        if (!(newOneIntParamsInstance instanceof Set)) {
            return null;
        }
        return (Set) newOneIntParamsInstance;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Queue.class) {
            return new LinkedList();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fieldClass, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fieldClass);
        }
        if (!(newOneIntParamsInstance instanceof Queue)) {
            return null;
        }
        return (Queue) newOneIntParamsInstance;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> fieldClass = cVar.getFieldClass();
        Type[] lP = cVar.lP();
        if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fieldClass, Map.class)) {
            if (lP != null && lP.length >= 2 && lP[0] == String.class) {
                if (fieldClass == Map.class) {
                    return new HashMap(i);
                }
                Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fieldClass, i);
                if (newOneIntParamsInstance == null) {
                    newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fieldClass);
                }
                if (newOneIntParamsInstance instanceof Map) {
                    return (Map) newOneIntParamsInstance;
                }
            } else if (fieldClass == Map.class) {
                return new HashMap(i);
            } else {
                Object newOneIntParamsInstance2 = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fieldClass, i);
                if (newOneIntParamsInstance2 == null) {
                    newOneIntParamsInstance2 = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fieldClass);
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
