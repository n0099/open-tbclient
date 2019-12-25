package com.baidu.adp.framework;

import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrameHelper {

    /* loaded from: classes.dex */
    public enum TYPE {
        HTTP,
        SOCKET,
        CUSTOM
    }

    public static TYPE z(int i) {
        if (i >= 0 && i < 1000000) {
            return TYPE.SOCKET;
        }
        if (i >= 1000000 && i < 2000000) {
            return TYPE.HTTP;
        }
        if (i >= 2000000 && i < 3000000) {
            return TYPE.CUSTOM;
        }
        BdLog.e("cmd invalid:cmd=" + i);
        return null;
    }

    public static boolean checkHttpCmd(int i) {
        return i >= 1000000 && i < 2000000;
    }

    public static boolean checkSocketCmd(int i) {
        return i >= 0 && i < 1000000;
    }

    public static boolean checkCustomCmd(int i) {
        return i >= 2000000 && i < 3000000;
    }

    public static <T extends d> int getInsertIndex(LinkedList<T> linkedList, int i) {
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size && linkedList.get(i2).getPriority() <= i) {
            i2++;
        }
        return i2;
    }

    public static <T extends d> void a(LinkedList<T> linkedList, T t) {
        if (t != null && !linkedList.contains(t)) {
            linkedList.add(getInsertIndex(linkedList, t.getPriority()), t);
        }
    }

    public static void A(int i) {
    }
}
