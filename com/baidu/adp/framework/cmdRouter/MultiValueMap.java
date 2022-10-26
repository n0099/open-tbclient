package com.baidu.adp.framework.cmdRouter;

import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public interface MultiValueMap {
    void add(Object obj, Object obj2);

    void add(Object obj, List list);

    void addAll(Map map);

    void clear();

    boolean containsKey(Object obj);

    Object getValue(Object obj, int i);

    List getValues(Object obj);

    boolean isEmpty();

    Set keySet();

    List remove(Object obj);

    void set(Object obj, Object obj2);

    void set(Object obj, List list);

    void set(Map map);

    int size();

    List values();
}
