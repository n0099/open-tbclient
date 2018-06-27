package com.baidu.tbadk.core.util;

import java.util.List;
/* loaded from: classes.dex */
public class w {
    public static <T> void y(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> int z(List<T> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public static <T> T d(List<T> list, int i) {
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

    public static <T> boolean A(List<T> list) {
        return z(list) <= 0;
    }

    public static <T> T e(List<T> list, int i) {
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

    public static <T> boolean a(List<T> list, int i, List<T> list2) {
        if (list == null || i > list.size() || i < 0 || list2 == null || list2.size() <= 0) {
            return false;
        }
        list.addAll(i, list2);
        return true;
    }

    public static <T> List<T> a(List<T> list, int i, int i2) {
        int z = z(list);
        if (z > 0 && i >= 0 && i2 <= z) {
            return list.subList(i, i2);
        }
        return null;
    }

    public static <T> void b(List<T> list, int i, int i2) {
        int z = z(list);
        if (z > 0 && i >= 0 && i2 <= z) {
            y(list.subList(i, i2));
        }
    }

    public static <T> boolean c(List<T> list, List<T> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        return list.size() == list2.size() && list.containsAll(list2);
    }
}
