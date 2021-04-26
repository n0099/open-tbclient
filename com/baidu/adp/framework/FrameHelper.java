package com.baidu.adp.framework;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.c.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrameHelper {

    /* loaded from: classes.dex */
    public enum TYPE {
        HTTP,
        SOCKET,
        CUSTOM
    }

    public static boolean a(int i2) {
        return i2 >= 2000000 && i2 < 3000000;
    }

    public static boolean b(int i2) {
        return i2 >= 1000000 && i2 < 2000000;
    }

    public static boolean c(int i2) {
        return i2 >= 0 && i2 < 1000000;
    }

    public static <T extends d> int d(LinkedList<T> linkedList, int i2) {
        int size = linkedList.size();
        int i3 = 0;
        while (i3 < size && linkedList.get(i3).getPriority() <= i2) {
            i3++;
        }
        return i3;
    }

    public static TYPE e(int i2) {
        if (i2 < 0 || i2 >= 1000000) {
            if (i2 < 1000000 || i2 >= 2000000) {
                if (i2 >= 2000000 && i2 < 3000000) {
                    return TYPE.CUSTOM;
                }
                BdLog.e("cmd invalid:cmd=" + i2);
                return null;
            }
            return TYPE.HTTP;
        }
        return TYPE.SOCKET;
    }

    public static <T extends d> void f(LinkedList<T> linkedList, T t) {
        if (t == null || linkedList.contains(t)) {
            return;
        }
        linkedList.add(d(linkedList, t.getPriority()), t);
    }

    public static void g(int i2) {
    }
}
