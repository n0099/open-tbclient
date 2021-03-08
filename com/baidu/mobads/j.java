package com.baidu.mobads;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2417a;
    private static long b;
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
        f2417a = context.getApplicationContext();
        this.c = new HashMap<>();
    }

    public void a(int i) {
        try {
            if (this.c != null && !this.c.containsKey(String.valueOf(i))) {
                b = System.currentTimeMillis();
                this.c.put(String.valueOf(i), String.valueOf(b));
            }
        } catch (Throwable th) {
        }
    }

    public void b() {
        com.baidu.mobads.b.a.a().a(f2417a, 801, null, this.c);
        this.c.clear();
    }
}
