package com.baidu.tbadk.core.util;

import java.util.List;
/* loaded from: classes3.dex */
public class ListUtils {
    public static <T> boolean add(List<T> list, T t) {
        if (list == null) {
            return false;
        }
        return list.add(t);
    }

    public static <T> boolean addAll(List<T> list, int i2, List<T> list2) {
        if (list == null || i2 > list.size() || i2 < 0 || list2 == null || list2.size() <= 0) {
            return false;
        }
        list.addAll(i2, list2);
        return true;
    }

    public static <T> void clear(List<T> list) {
        if (list == null) {
            return;
        }
        list.clear();
    }

    public static <T> boolean equalList(List<T> list, List<T> list2) {
        if (list == list2) {
            return true;
        }
        return list != null && list2 != null && list.size() == list2.size() && list.containsAll(list2);
    }

    public static <T> int getCount(List<T> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public static <T> T getItem(List<T> list, int i2) {
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
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

    public static <T> T remove(List<T> list, int i2) {
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return list.remove(i2);
    }

    public static <T> void removeSubList(List<T> list, int i2, int i3) {
        int count = getCount(list);
        if (count > 0 && i2 >= 0 && i3 <= count) {
            clear(list.subList(i2, i3));
        }
    }

    public static <T> List<T> subList(List<T> list, int i2, int i3) {
        int count = getCount(list);
        if (count > 0 && i2 >= 0 && i3 <= count) {
            return list.subList(i2, i3);
        }
        return null;
    }

    public static <T> List<T> trimToSize(List<T> list, int i2) {
        int count = getCount(list);
        int min = Math.min(count, i2);
        return (min <= 0 || min >= count) ? list : subList(list, 0, min);
    }

    public static <T> boolean add(List<T> list, int i2, T t) {
        if (list == null || i2 > list.size() || i2 < 0) {
            return false;
        }
        list.add(i2, t);
        return true;
    }
}
