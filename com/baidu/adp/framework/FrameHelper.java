package com.baidu.adp.framework;

import com.baidu.adp.lib.util.BdLog;
import d.b.c.c.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrameHelper {

    /* loaded from: classes.dex */
    public enum TYPE {
        HTTP,
        SOCKET,
        CUSTOM
    }

    public static boolean a(int i) {
        return i >= 2000000 && i < 3000000;
    }

    public static boolean b(int i) {
        return i >= 1000000 && i < 2000000;
    }

    public static boolean c(int i) {
        return i >= 0 && i < 1000000;
    }

    public static <T extends d> int d(LinkedList<T> linkedList, int i) {
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size && linkedList.get(i2).getPriority() <= i) {
            i2++;
        }
        return i2;
    }

    public static TYPE e(int i) {
        if (i < 0 || i >= 1000000) {
            if (i < 1000000 || i >= 2000000) {
                if (i >= 2000000 && i < 3000000) {
                    return TYPE.CUSTOM;
                }
                BdLog.e("cmd invalid:cmd=" + i);
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

    public static void g(int i) {
    }
}
