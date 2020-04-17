package com.baidu.mobads;

import java.util.HashMap;
/* loaded from: classes10.dex */
public class g {
    private static HashMap<String, String> b = new HashMap<>();
    private static g bli;

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (bli == null) {
                bli = new g();
            }
            gVar = bli;
        }
        return gVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.HashMap<java.lang.String, java.lang.String>, java.util.HashMap] */
    public int a(int i) {
        int i2;
        Exception e;
        int i3 = 1;
        i3 = 1;
        if (i < 1) {
            return 1;
        }
        try {
            if (b.containsKey(i + "")) {
                i2 = Integer.parseInt(b.get(i + "")) + 1;
                if (i2 < 1) {
                    i2 = 1;
                }
                try {
                    ?? r1 = b;
                    r1.put(i + "", i2 + "");
                    i3 = r1;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return i2;
                }
            } else {
                b.put(i + "", "1");
                i2 = 1;
            }
        } catch (Exception e3) {
            i2 = i3;
            e = e3;
        }
        return i2;
    }
}
