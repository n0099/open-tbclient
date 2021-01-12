package com.baidu.live.utils;

import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes10.dex */
public class u {
    public static int d(ViewGroup viewGroup, int i) {
        int i2 = -1;
        HashMap<Integer, Integer> e = e(viewGroup, i);
        int parseInt = Integer.parseInt(h(e).toString());
        if (e.size() == 0) {
            return -1;
        }
        Iterator<Map.Entry<Integer, Integer>> it = e.entrySet().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3;
            }
            Map.Entry<Integer, Integer> next = it.next();
            i2 = parseInt == next.getValue().intValue() ? next.getKey().intValue() : i3;
        }
    }

    public static HashMap<Integer, Integer> e(ViewGroup viewGroup, int i) {
        int intValue;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (viewGroup == null) {
            return hashMap;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= viewGroup.getChildCount()) {
                return hashMap;
            }
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getTag() != null && (childAt.getTag() instanceof Integer) && (intValue = ((Integer) childAt.getTag()).intValue()) > i) {
                hashMap.put(Integer.valueOf(i3), Integer.valueOf(intValue));
            }
            i2 = i3 + 1;
        }
    }

    public static Object h(Map<Integer, Integer> map) {
        if (map.size() == 0) {
            return 0;
        }
        Object[] array = map.values().toArray();
        Arrays.sort(array);
        return array[0];
    }

    public static void a(ViewGroup viewGroup, View view, int i) {
        if (viewGroup != null && view != null) {
            int d = d(viewGroup, i);
            if (d > -1) {
                viewGroup.addView(view, d);
            } else {
                viewGroup.addView(view);
            }
        }
    }

    public static void a(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            int d = d(viewGroup, i);
            if (d > 0) {
                viewGroup.addView(view, d, layoutParams);
            } else {
                viewGroup.addView(view);
            }
            view.setTag(Integer.valueOf(i));
        }
    }
}
