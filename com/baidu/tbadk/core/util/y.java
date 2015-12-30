package com.baidu.tbadk.core.util;

import java.util.List;
/* loaded from: classes.dex */
public class y {
    public static <T> void k(List<T> list) {
        if (list != null) {
            list.clear();
        }
    }

    public static <T> int l(List<T> list) {
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
}
