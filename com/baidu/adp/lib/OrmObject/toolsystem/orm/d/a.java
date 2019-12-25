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
        Class<?> fp = cVar.fp();
        if (fp == List.class || fp == ArrayList.class) {
            return new ArrayList(i);
        }
        if (fp == LinkedList.class) {
            return new LinkedList();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fp, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fp);
        }
        if (!(newOneIntParamsInstance instanceof List)) {
            return null;
        }
        return (List) newOneIntParamsInstance;
    }

    public static final Set<Object> b(c cVar, int i) {
        Class<?> fp = cVar.fp();
        if (fp == Set.class) {
            return new HashSet();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fp, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fp);
        }
        if (!(newOneIntParamsInstance instanceof Set)) {
            return null;
        }
        return (Set) newOneIntParamsInstance;
    }

    public static final Queue<Object> c(c cVar, int i) {
        Class<?> fp = cVar.fp();
        if (fp == Queue.class) {
            return new LinkedList();
        }
        Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fp, i);
        if (newOneIntParamsInstance == null) {
            newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fp);
        }
        if (!(newOneIntParamsInstance instanceof Queue)) {
            return null;
        }
        return (Queue) newOneIntParamsInstance;
    }

    public static final Map<String, Object> d(c cVar, int i) {
        Class<?> fp = cVar.fp();
        Type[] fo = cVar.fo();
        if (com.baidu.adp.lib.OrmObject.a.a.isClassIsSubClassForClazz(fp, Map.class)) {
            if (fo != null && fo.length >= 2 && fo[0] == String.class) {
                if (fp == Map.class) {
                    return new HashMap(i);
                }
                Object newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fp, i);
                if (newOneIntParamsInstance == null) {
                    newOneIntParamsInstance = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fp);
                }
                if (newOneIntParamsInstance instanceof Map) {
                    return (Map) newOneIntParamsInstance;
                }
            } else if (fp == Map.class) {
                return new HashMap(i);
            } else {
                Object newOneIntParamsInstance2 = com.baidu.adp.lib.OrmObject.a.a.newOneIntParamsInstance(fp, i);
                if (newOneIntParamsInstance2 == null) {
                    newOneIntParamsInstance2 = com.baidu.adp.lib.OrmObject.a.a.newEmptyParamsInstance(fp);
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
