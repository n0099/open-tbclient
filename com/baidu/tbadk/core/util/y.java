package com.baidu.tbadk.core.util;

import java.util.List;
/* loaded from: classes.dex */
public class y {
    public static <T> void q(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> int r(List<T> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public static <T> T c(List<T> list, int i) {
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

    public static List<String> a(List<String> list, int i, int i2) {
        int r = r(list);
        if (r > 0 && i >= 0 && i2 <= r) {
            return list.subList(i, i2);
        }
        return null;
    }

    public static <T> boolean s(List<T> list) {
        return r(list) <= 0;
    }

    public static <T> T d(List<T> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.remove(i);
    }

    public static <T> boolean a(List<T> list, int i, T t) {
        if (list == null || i > list.size() || i < 0) {
            return false;
        }
        list.add(i, t);
        return true;
    }
}
