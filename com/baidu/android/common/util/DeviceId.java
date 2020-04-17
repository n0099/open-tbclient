package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.cesium.c;
import com.baidu.cesium.e;
import com.baidu.cesium.e.a;
import com.baidu.cesium.f;
import com.baidu.cesium.g;
import java.io.File;
/* loaded from: classes13.dex */
public final class DeviceId {
    private static final String a = "DeviceId";
    private static final boolean b = false;
    private static g.a d;
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

    private g.a a() {
        this.e.b();
        try {
            g.a b2 = b();
            if (b2 == null) {
                b2 = a((String) null);
            }
            if (b2 == null) {
                b2 = c((String) null);
            }
            a(b2);
            return b2;
        } catch (Throwable th) {
            this.e.c();
            throw th;
        }
    }

    private static g.a a(Context context) {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    SystemClock.uptimeMillis();
                    d = new DeviceId(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return d;
    }

    private g.a a(String str) {
        g.a d2 = this.e.d();
        return d2 == null ? b(str) : d2;
    }

    private synchronized void a(g.a aVar) {
        new Thread(b(aVar)).start();
    }

    private g.a b() {
        g.a c = c();
        return c == null ? d() : c;
    }

    private g.a b(String str) {
        e da = this.f.da(str);
        if (da != null) {
            return this.e.b(da);
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
        return this.e.a();
    }

    private g.a c(String str) {
        return this.e.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g.a aVar) {
        if (aVar == null) {
            throw new NullPointerException("cuidV270Info should not be null");
        }
        e sg = aVar.sg();
        this.e.a(aVar, true, false);
        this.f.a(sg);
        this.e.a(aVar);
    }

    private g.a d() {
        e cY;
        File file = new File(this.c.getFilesDir(), "libcuid.so");
        if (!file.exists() || (cY = e.cY(com.baidu.cesium.f.c.a(file))) == null) {
            return null;
        }
        return this.e.b(cY);
    }

    public static String getCUID(Context context) {
        return a(context).g();
    }

    public static String getDeviceID(Context context) {
        return a(context).b();
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
    }
}
