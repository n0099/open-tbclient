package com.baidu.mobads;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3389a;

    /* renamed from: b  reason: collision with root package name */
    private static long f3390b;
    private static volatile j d = null;
    private HashMap<String, String> c = new HashMap<>();

    private j() {
    }

    public static j a() {
        if (d == null) {
            synchronized (j.class) {
                if (d == null) {
                    d = new j();
                }
            }
        }
        return d;
    }

    public void a(Context context) {
        f3389a = context.getApplicationContext();
        this.c = new HashMap<>();
    }

    public void a(int i) {
        try {
            if (this.c != null && !this.c.containsKey(String.valueOf(i))) {
                f3390b = System.currentTimeMillis();
                this.c.put(String.valueOf(i), String.valueOf(f3390b));
            }
        } catch (Throwable th) {
        }
    }

    public void b() {
        com.baidu.mobads.b.a.a().a(f3389a, 801, null, this.c);
        this.c.clear();
    }
}
