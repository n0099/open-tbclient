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
    public static g.a f8026b = null;

    /* renamed from: c  reason: collision with root package name */
    public static g.a f8027c = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile DeviceId f8028f = null;
    public static boolean sDataCuidInfoShable = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8029a;

    /* renamed from: d  reason: collision with root package name */
    public g f8030d;

    /* renamed from: e  reason: collision with root package name */
    public f f8031e;

    /* renamed from: g  reason: collision with root package name */
    public c f8032g = new c();

    public DeviceId(Context context) {
        this.f8029a = context.getApplicationContext();
        this.f8030d = new g(this.f8029a, new a(this.f8029a), this.f8032g);
        this.f8031e = new f(this.f8029a, this.f8032g);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (e.class) {
            if (f8028f == null) {
                f8028f = new DeviceId(context);
            }
            deviceId = f8028f;
        }
        return deviceId;
    }

    private g.a a() {
        g.a a2 = a((String) null);
        return a2 == null ? this.f8030d.a() : a2;
    }

    private g.a a(String str) {
        g.a b2 = this.f8030d.b();
        return b2 == null ? b(str) : b2;
    }

    public static g.a b(Context context) {
        if (f8026b == null) {
            synchronized (e.class) {
                if (f8026b == null) {
                    SystemClock.uptimeMillis();
                    f8026b = a(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8026b;
    }

    private g.a b(String str) {
        e a2 = this.f8031e.a(str);
        if (a2 != null) {
            return this.f8030d.a(a2);
        }
        return null;
    }

    public static g.a c(Context context) {
        if (f8027c == null) {
            synchronized (e.class) {
                if (f8027c == null) {
                    SystemClock.uptimeMillis();
                    f8027c = a(context).f8030d.c();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8027c;
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
