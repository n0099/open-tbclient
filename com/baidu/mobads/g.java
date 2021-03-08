package com.baidu.mobads;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f2384a;
    private static HashMap<String, String> b = new HashMap<>();

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f2384a == null) {
                f2384a = new g();
            }
            gVar = f2384a;
        }
        return gVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0095 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.HashMap<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int a(int i) {
        int i2;
        int e = 1;
        e = 1;
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
                    e = b;
                    e.put(i + "", i2 + "");
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                b.put(i + "", "1");
                i2 = 1;
            }
        } catch (Exception e3) {
            i2 = e;
        }
        return i2;
    }
}
