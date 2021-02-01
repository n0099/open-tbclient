package com.baidu.live.alablmsdk.a;

import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public static <T> boolean isEmpty(List<T> list) {
        return getCount(list) <= 0;
    }

    public static <T> int getCount(List<T> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public static int t(List<Integer> list) {
        if (isEmpty(list)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int intValue = list.get(i2).intValue();
            if (i < intValue) {
                i = intValue;
            }
        }
        return i;
    }
}
