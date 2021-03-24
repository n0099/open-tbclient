package com.baidu.mobads;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f8246a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, String> f8247b = new HashMap<>();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f8246a == null) {
                f8246a = new g();
            }
            gVar = f8246a;
        }
        return gVar;
    }

    public int a(int i) {
        int i2 = 1;
        if (i < 1) {
            return 1;
        }
        try {
            if (f8247b.containsKey(i + "")) {
                int parseInt = Integer.parseInt(f8247b.get(i + "")) + 1;
                if (parseInt >= 1) {
                    i2 = parseInt;
                }
                f8247b.put(i + "", i2 + "");
            } else {
                f8247b.put(i + "", "1");
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
