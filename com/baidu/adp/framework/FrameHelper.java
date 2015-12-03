package com.baidu.adp.framework;

import com.baidu.adp.lib.util.BdLog;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrameHelper {

    /* loaded from: classes.dex */
    public enum TYPE {
        HTTP,
        SOCKET,
        CUSTOM;

        /* JADX DEBUG: Replace access to removed values field (oc) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TYPE[] valuesCustom() {
            TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            TYPE[] typeArr = new TYPE[length];
            System.arraycopy(valuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    public static TYPE u(int i) {
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

    public static boolean v(int i) {
        return i >= 1000000 && i < 2000000;
    }

    public static boolean w(int i) {
        return i >= 0 && i < 1000000;
    }

    public static boolean x(int i) {
        return i >= 2000000 && i < 3000000;
    }

    public static <T extends d> int a(LinkedList<T> linkedList, int i) {
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size && linkedList.get(i2).getPriority() <= i) {
            i2++;
        }
        return i2;
    }

    public static <T extends d> void a(LinkedList<T> linkedList, T t) {
        if (t != null && !linkedList.contains(t)) {
            linkedList.add(a(linkedList, t.getPriority()), t);
        }
    }
}
