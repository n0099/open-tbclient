package com.baidu.mobads;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f3360a;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, String> f3361b = new HashMap<>();

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f3360a == null) {
                f3360a = new g();
            }
            gVar = f3360a;
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
            if (f3361b.containsKey(i + "")) {
                i2 = Integer.parseInt(f3361b.get(i + "")) + 1;
                if (i2 < 1) {
                    i2 = 1;
                }
                try {
                    ?? r1 = f3361b;
                    r1.put(i + "", i2 + "");
                    i3 = r1;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return i2;
                }
            } else {
                f3361b.put(i + "", "1");
                i2 = 1;
            }
        } catch (Exception e2) {
            e = e2;
            i2 = i3;
        }
        return i2;
    }
}
