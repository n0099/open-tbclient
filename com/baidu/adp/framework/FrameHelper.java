package com.baidu.adp.framework;

import com.baidu.adp.lib.util.f;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrameHelper {

    /* loaded from: classes.dex */
    public enum TYPE {
        HTTP,
        SOCKET,
        CUSTOM;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TYPE[] valuesCustom() {
            TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            TYPE[] typeArr = new TYPE[length];
            System.arraycopy(valuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    public static TYPE a(int i) {
        if (i >= 1000 && i < 1001000) {
            return TYPE.SOCKET;
        }
        if (i >= 1001000 && i < 2001000) {
            return TYPE.HTTP;
        }
        if (i >= 2001000 && i < 3001000) {
            return TYPE.CUSTOM;
        }
        f.b("cmd invalid");
        return null;
    }

    public static boolean b(int i) {
        return i >= 1001000 && i < 2001000;
    }

    public static boolean c(int i) {
        return i >= 1000 && i < 1001000;
    }

    public static boolean d(int i) {
        return i >= 2001000 && i < 3001000;
    }

    public static <T extends d> int a(LinkedList<T> linkedList, int i) {
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size && linkedList.get(i2).a() <= i) {
            i2++;
        }
        return i2;
    }

    public static <T extends d> void a(LinkedList<T> linkedList, T t) {
        if (t != null && !linkedList.contains(t)) {
            linkedList.add(a(linkedList, t.a()), t);
        }
    }
}
