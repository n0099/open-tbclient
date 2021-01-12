package com.baidu.mobads;

import java.util.HashMap;
/* loaded from: classes14.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f3322a;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, String> f3323b = new HashMap<>();

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f3322a == null) {
                f3322a = new g();
            }
            gVar = f3322a;
        }
        return gVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.HashMap<java.lang.String, java.lang.String>, java.util.HashMap] */
    public int a(int i) {
        int i2;
        int i3 = 1;
        i3 = 1;
        if (i < 1) {
            return 1;
        }
        try {
            if (f3323b.containsKey(i + "")) {
                i2 = Integer.parseInt(f3323b.get(i + "")) + 1;
                if (i2 < 1) {
                    i2 = 1;
                }
                try {
                    ?? r1 = f3323b;
                    r1.put(i + "", i2 + "");
                    i3 = r1;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return i2;
                }
            } else {
                f3323b.put(i + "", "1");
                i2 = 1;
            }
        } catch (Exception e2) {
            e = e2;
            i2 = i3;
        }
        return i2;
    }
}
