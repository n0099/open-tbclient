package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import d.a.j.f;
import d.a.j.g.a;
import d.a.j.i.c;
import d.a.j.j;
import d.a.j.k;
import d.a.j.l;
import java.io.File;
/* loaded from: classes.dex */
public final class DeviceId {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2573a = "DeviceId";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f2574b = false;

    /* renamed from: d  reason: collision with root package name */
    public static l.a f2575d = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile DeviceId f2576g = null;
    public static boolean sDataCuidInfoShable = true;

    /* renamed from: c  reason: collision with root package name */
    public final Context f2577c;

    /* renamed from: e  reason: collision with root package name */
    public l f2578e;

    /* renamed from: f  reason: collision with root package name */
    public k f2579f;

    /* renamed from: h  reason: collision with root package name */
    public f f2580h = new f();

    public DeviceId(Context context) {
        this.f2577c = context.getApplicationContext();
        this.f2578e = new l(this.f2577c, new a(this.f2577c), this.f2580h);
        this.f2579f = new k(this.f2577c, this.f2580h);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (j.class) {
            if (f2576g == null) {
                f2576g = new DeviceId(context);
            }
            deviceId = f2576g;
        }
        return deviceId;
    }

    private l.a a(String str) {
        l.a o = this.f2578e.o();
        return o == null ? b(str) : o;
    }

    private synchronized void a(l.a aVar) {
        new Thread(b(aVar)).start();
    }

    private l.a b() {
        this.f2578e.l();
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
            this.f2578e.n();
            throw th;
        }
    }

    public static l.a b(Context context) {
        if (f2575d == null) {
            synchronized (j.class) {
                if (f2575d == null) {
                    SystemClock.uptimeMillis();
                    f2575d = a(context).b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f2575d;
    }

    private l.a b(String str) {
        j b2 = this.f2579f.b(str);
        if (b2 != null) {
            return this.f2578e.b(b2);
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
                    DeviceId.this.f2578e.n();
                }
            }
        };
    }

    private l.a c() {
        l.a d2 = d();
        return d2 == null ? e() : d2;
    }

    private l.a c(String str) {
        return this.f2578e.k(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cuidV270Info should not be null");
        }
        j l = aVar.l();
        this.f2578e.j(aVar, true, false);
        this.f2579f.c(l);
        this.f2578e.i(aVar);
    }

    private l.a d() {
        return this.f2578e.a();
    }

    private l.a e() {
        j e2;
        File file = new File(this.f2577c.getFilesDir(), "libcuid.so");
        if (!file.exists() || (e2 = j.e(c.a(file))) == null) {
            return null;
        }
        return this.f2578e.b(e2);
    }

    public static String getCUID(Context context) {
        return b(context).n();
    }

    public static String getDeviceID(Context context) {
        return b(context).e();
    }

    public static boolean isMySelfTrusted(Context context) {
        return a(context).f2580h.d(context.getApplicationContext());
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
    }

    public l a() {
        return this.f2578e;
    }
}
