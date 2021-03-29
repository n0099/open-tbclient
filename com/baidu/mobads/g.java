package com.baidu.mobads;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f8247a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, String> f8248b = new HashMap<>();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f8247a == null) {
                f8247a = new g();
            }
            gVar = f8247a;
        }
        return gVar;
    }

    public int a(int i) {
        int i2 = 1;
        if (i < 1) {
            return 1;
        }
        try {
            if (f8248b.containsKey(i + "")) {
                int parseInt = Integer.parseInt(f8248b.get(i + "")) + 1;
                if (parseInt >= 1) {
                    i2 = parseInt;
                }
                f8248b.put(i + "", i2 + "");
            } else {
                f8248b.put(i + "", "1");
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
