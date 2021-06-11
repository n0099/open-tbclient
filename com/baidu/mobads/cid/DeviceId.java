package com.baidu.mobads.cid;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.mobads.cid.cesium.c;
import com.baidu.mobads.cid.cesium.e;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.f;
import com.baidu.mobads.cid.cesium.g;
/* loaded from: classes2.dex */
public final class DeviceId {

    /* renamed from: b  reason: collision with root package name */
    public static g.a f8088b = null;

    /* renamed from: c  reason: collision with root package name */
    public static g.a f8089c = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile DeviceId f8090f = null;
    public static boolean sDataCuidInfoShable = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8091a;

    /* renamed from: d  reason: collision with root package name */
    public g f8092d;

    /* renamed from: e  reason: collision with root package name */
    public f f8093e;

    /* renamed from: g  reason: collision with root package name */
    public c f8094g = new c();

    public DeviceId(Context context) {
        this.f8091a = context.getApplicationContext();
        this.f8092d = new g(this.f8091a, new a(this.f8091a), this.f8094g);
        this.f8093e = new f(this.f8091a, this.f8094g);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (e.class) {
            if (f8090f == null) {
                f8090f = new DeviceId(context);
            }
            deviceId = f8090f;
        }
        return deviceId;
    }

    private g.a a() {
        g.a a2 = a((String) null);
        return a2 == null ? this.f8092d.a() : a2;
    }

    private g.a a(String str) {
        g.a b2 = this.f8092d.b();
        return b2 == null ? b(str) : b2;
    }

    public static g.a b(Context context) {
        if (f8088b == null) {
            synchronized (e.class) {
                if (f8088b == null) {
                    SystemClock.uptimeMillis();
                    f8088b = a(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8088b;
    }

    private g.a b(String str) {
        e a2 = this.f8093e.a(str);
        if (a2 != null) {
            return this.f8092d.a(a2);
        }
        return null;
    }

    public static g.a c(Context context) {
        if (f8089c == null) {
            synchronized (e.class) {
                if (f8089c == null) {
                    SystemClock.uptimeMillis();
                    f8089c = a(context).f8092d.c();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8089c;
    }

    public static String getSelfCUID(Context context) {
        return c(context).c();
    }

    public static String getTrustChainCUID(Context context) {
        return b(context).c();
    }

    public static String getTrustChainDeviceID(Context context) {
        return b(context).a();
    }
}
