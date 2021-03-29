package com.baidu.mobads;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static Context f8355a;

    /* renamed from: b  reason: collision with root package name */
    public static long f8356b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile j f8357d;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f8358c = new HashMap<>();

    public static j a() {
        if (f8357d == null) {
            synchronized (j.class) {
                if (f8357d == null) {
                    f8357d = new j();
                }
            }
        }
        return f8357d;
    }

    public void b() {
        com.baidu.mobads.b.a.a().a(f8355a, 801, null, this.f8358c);
        this.f8358c.clear();
    }

    public void a(Context context) {
        f8355a = context.getApplicationContext();
        this.f8358c = new HashMap<>();
    }

    public void a(int i) {
        try {
            if (this.f8358c == null || this.f8358c.containsKey(String.valueOf(i))) {
                return;
            }
            f8356b = System.currentTimeMillis();
            this.f8358c.put(String.valueOf(i), String.valueOf(f8356b));
        } catch (Throwable unused) {
        }
    }
}
