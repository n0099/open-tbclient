package com.baidu.tbadk.core.util;

import java.util.List;
/* loaded from: classes.dex */
public class x {
    public static <T> void n(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> int o(List<T> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public static <T> T b(List<T> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static <T> int a(List<T> list, T t) {
        if (list == null || list.isEmpty() || t == null) {
            return -1;
        }
        return list.indexOf(t);
    }

    public static <T> boolean p(List<T> list) {
        return o(list) <= 0;
    }
}
