package com.baidu.tbadk.core.util;

import java.util.List;
/* loaded from: classes.dex */
public class x {
    public static <T> void r(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> int s(List<T> list) {
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

    public static <T> boolean t(List<T> list) {
        return s(list) <= 0;
    }

    public static <T> T d(List<T> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.remove(i);
    }

    public static <T> boolean b(List<T> list, T t) {
        if (list == null) {
            return false;
        }
        return list.add(t);
    }

    public static <T> boolean a(List<T> list, int i, T t) {
        if (list == null || i > list.size() || i < 0) {
            return false;
        }
        list.add(i, t);
        return true;
    }

    public static <T> List<T> a(List<T> list, int i, int i2) {
        int s = s(list);
        if (s > 0 && i >= 0 && i2 <= s) {
            return list.subList(i, i2);
        }
        return null;
    }

    public static <T> void b(List<T> list, int i, int i2) {
        int s = s(list);
        if (s > 0 && i >= 0 && i2 <= s) {
            r(list.subList(i, i2));
        }
    }
}
