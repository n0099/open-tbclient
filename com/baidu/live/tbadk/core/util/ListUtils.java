package com.baidu.live.tbadk.core.util;

import java.util.List;
/* loaded from: classes6.dex */
public class ListUtils {
    public static <T> void clear(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> int getCount(List<T> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public static <T> T getItem(List<T> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static <T> int getPosition(List<T> list, T t) {
        if (list == null || list.isEmpty() || t == null) {
            return -1;
        }
        return list.indexOf(t);
    }

    public static <T> boolean isEmpty(List<T> list) {
        return getCount(list) <= 0;
    }

    public static <T> T remove(List<T> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.remove(i);
    }

    public static <T> boolean add(List<T> list, T t) {
        if (list == null) {
            return false;
        }
        return list.add(t);
    }

    public static <T> boolean add(List<T> list, int i, T t) {
        if (list == null || i > list.size() || i < 0) {
            return false;
        }
        list.add(i, t);
        return true;
    }

    public static <T> boolean addAll(List<T> list, int i, List<T> list2) {
        if (list == null || i > list.size() || i < 0 || list2 == null || list2.size() <= 0) {
            return false;
        }
        list.addAll(i, list2);
        return true;
    }

    public static <T> List<T> subList(List<T> list, int i, int i2) {
        int count = getCount(list);
        if (count > 0 && i >= 0 && i2 <= count) {
            return list.subList(i, i2);
        }
        return null;
    }

    public static <T> void removeSubList(List<T> list, int i, int i2) {
        int count = getCount(list);
        if (count > 0 && i >= 0 && i2 <= count) {
            clear(list.subList(i, i2));
        }
    }

    public static <T> boolean equalList(List<T> list, List<T> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        return list.size() == list2.size() && list.containsAll(list2);
    }
}
