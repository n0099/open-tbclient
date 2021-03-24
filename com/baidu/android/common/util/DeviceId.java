package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import d.b.j.f;
import d.b.j.g.a;
import d.b.j.i.c;
import d.b.j.j;
import d.b.j.k;
import d.b.j.l;
import java.io.File;
/* loaded from: classes.dex */
public final class DeviceId {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2515a = "DeviceId";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f2516b = false;

    /* renamed from: d  reason: collision with root package name */
    public static l.a f2517d = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile DeviceId f2518g = null;
    public static boolean sDataCuidInfoShable = true;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2519c;

    /* renamed from: e  reason: collision with root package name */
    public l f2520e;

    /* renamed from: f  reason: collision with root package name */
    public k f2521f;

    /* renamed from: h  reason: collision with root package name */
    public f f2522h = new f();

    public DeviceId(Context context) {
        this.f2519c = context.getApplicationContext();
        this.f2520e = new l(this.f2519c, new a(this.f2519c), this.f2522h);
        this.f2521f = new k(this.f2519c, this.f2522h);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (j.class) {
            if (f2518g == null) {
                f2518g = new DeviceId(context);
            }
            deviceId = f2518g;
        }
        return deviceId;
    }

    private l.a a(String str) {
        l.a o = this.f2520e.o();
        return o == null ? b(str) : o;
    }

    private synchronized void a(l.a aVar) {
        new Thread(b(aVar)).start();
    }

    private l.a b() {
        this.f2520e.l();
        try {
            l.a c2 = c();
            if (c2 == null) {
                c2 = a((String) null);
            }
            if (c2 == null) {
                c2 = c((String) null);
            }
            a(c2);
            return c2;
        } catch (Throwable th) {
            this.f2520e.n();
            throw th;
        }
    }

    public static l.a b(Context context) {
        if (f2517d == null) {
            synchronized (j.class) {
                if (f2517d == null) {
                    SystemClock.uptimeMillis();
                    f2517d = a(context).b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f2517d;
    }

    private l.a b(String str) {
        j b2 = this.f2521f.b(str);
        if (b2 != null) {
            return this.f2520e.b(b2);
        }
        return null;
    }

    private Runnable b(final l.a aVar) {
        return new Runnable() { // from class: com.baidu.android.common.util.DeviceId.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DeviceId.this.c(aVar);
                } finally {
                    DeviceId.this.f2520e.n();
                }
            }
        };
    }

    private l.a c() {
        l.a d2 = d();
        return d2 == null ? e() : d2;
    }

    private l.a c(String str) {
        return this.f2520e.k(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cuidV270Info should not be null");
        }
        j l = aVar.l();
        this.f2520e.j(aVar, true, false);
        this.f2521f.c(l);
        this.f2520e.i(aVar);
    }

    private l.a d() {
        return this.f2520e.a();
    }

    private l.a e() {
        j e2;
        File file = new File(this.f2519c.getFilesDir(), "libcuid.so");
        if (!file.exists() || (e2 = j.e(c.a(file))) == null) {
            return null;
        }
        return this.f2520e.b(e2);
    }

    public static String getCUID(Context context) {
        return b(context).n();
    }

    public static String getDeviceID(Context context) {
        return b(context).e();
    }

    public static boolean isMySelfTrusted(Context context) {
        return a(context).f2522h.d(context.getApplicationContext());
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
    }

    public l a() {
        return this.f2520e;
    }
}
