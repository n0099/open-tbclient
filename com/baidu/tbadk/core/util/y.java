package com.baidu.tbadk.core.util;

import java.util.List;
/* loaded from: classes.dex */
public class y {
    public static <T> void o(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> int p(List<T> list) {
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

    public static List<String> a(List<String> list, int i, int i2) {
        int p = p(list);
        if (p > 0 && i >= 0 && i2 <= p) {
            return list.subList(i, i2);
        }
        return null;
    }

    public static <T> boolean q(List<T> list) {
        return p(list) <= 0;
    }

    public static <T> T c(List<T> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.remove(i);
    }
}
