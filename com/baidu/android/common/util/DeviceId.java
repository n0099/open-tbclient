package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.cesium.c;
import com.baidu.cesium.e;
import com.baidu.cesium.e.a;
import com.baidu.cesium.f;
import com.baidu.cesium.g;
import java.io.File;
/* loaded from: classes9.dex */
public final class DeviceId {
    private static final String a = "DeviceId";
    private static final boolean b = false;
    private static g.a d;
    private static volatile DeviceId g;
    public static boolean sDataCuidInfoShable = true;
    private final Context c;
    private g e;
    private f f;

    private DeviceId(Context context) {
        this.c = context.getApplicationContext();
        c cVar = new c();
        this.e = new g(this.c, new a(this.c), cVar);
        this.f = new f(this.c, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (e.class) {
            if (g == null) {
                g = new DeviceId(context);
            }
            deviceId = g;
        }
        return deviceId;
    }

    private g.a a(String str) {
        g.a d2 = this.e.d();
        return d2 == null ? b(str) : d2;
    }

    private synchronized void a(g.a aVar) {
        new Thread(b(aVar)).start();
    }

    private g.a b() {
        this.e.b();
        try {
            g.a c = c();
            if (c == null) {
                c = a((String) null);
            }
            if (c == null) {
                c = c((String) null);
            }
            a(c);
            return c;
        } catch (Throwable th) {
            this.e.c();
            throw th;
        }
    }

    private static g.a b(Context context) {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    SystemClock.uptimeMillis();
                    d = a(context).b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return d;
    }

    private g.a b(String str) {
        e m21do = this.f.m21do(str);
        if (m21do != null) {
            return this.e.b(m21do);
        }
        return null;
    }

    private Runnable b(final g.a aVar) {
        return new Runnable() { // from class: com.baidu.android.common.util.DeviceId.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DeviceId.this.c(aVar);
                } finally {
                    DeviceId.this.e.c();
                }
            }
        };
    }

    private g.a c() {
        g.a d2 = d();
        return d2 == null ? e() : d2;
    }

    private g.a c(String str) {
        return this.e.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cuidV270Info should not be null");
        }
        e uu = aVar.uu();
        this.e.a(aVar, true, false);
        this.f.a(uu);
        this.e.a(aVar);
    }

    private g.a d() {
        return this.e.uo();
    }

    private g.a e() {
        e dm;
        File file = new File(this.c.getFilesDir(), "libcuid.so");
        if (!file.exists() || (dm = e.dm(com.baidu.cesium.f.c.a(file))) == null) {
            return null;
        }
        return this.e.b(dm);
    }

    public static String getCUID(Context context) {
        return b(context).g();
    }

    public static String getDeviceID(Context context) {
        return b(context).b();
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a() {
        return this.e;
    }
}
