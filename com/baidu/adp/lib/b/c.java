package com.baidu.adp.lib.b;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class c {
    private static a a = null;
    private static SparseArray b = null;

    public static Object a(String str, int i) {
        d a2;
        Object a3;
        if (str == null || str.length() <= 0 || a == null || (a2 = a(i)) == null || (a3 = a2.a(str)) == null) {
            return null;
        }
        return a3;
    }

    private static d a(int i) {
        if (b == null) {
            b = new SparseArray();
        }
        d dVar = (d) b.get(i);
        if (dVar == null) {
            d a2 = a.a(i);
            b.put(i, a2);
            return a2;
        }
        return dVar;
    }
}
