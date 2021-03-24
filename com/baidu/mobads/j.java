package com.baidu.mobads;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static Context f8354a;

    /* renamed from: b  reason: collision with root package name */
    public static long f8355b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile j f8356d;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f8357c = new HashMap<>();

    public static j a() {
        if (f8356d == null) {
            synchronized (j.class) {
                if (f8356d == null) {
                    f8356d = new j();
                }
            }
        }
        return f8356d;
    }

    public void b() {
        com.baidu.mobads.b.a.a().a(f8354a, 801, null, this.f8357c);
        this.f8357c.clear();
    }

    public void a(Context context) {
        f8354a = context.getApplicationContext();
        this.f8357c = new HashMap<>();
    }

    public void a(int i) {
        try {
            if (this.f8357c == null || this.f8357c.containsKey(String.valueOf(i))) {
                return;
            }
            f8355b = System.currentTimeMillis();
            this.f8357c.put(String.valueOf(i), String.valueOf(f8355b));
        } catch (Throwable unused) {
        }
    }
}
