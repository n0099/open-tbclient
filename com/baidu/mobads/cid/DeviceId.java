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
    public static g.a f8314b = null;

    /* renamed from: c  reason: collision with root package name */
    public static g.a f8315c = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile DeviceId f8316f = null;
    public static boolean sDataCuidInfoShable = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8317a;

    /* renamed from: d  reason: collision with root package name */
    public g f8318d;

    /* renamed from: e  reason: collision with root package name */
    public f f8319e;

    /* renamed from: g  reason: collision with root package name */
    public c f8320g = new c();

    public DeviceId(Context context) {
        this.f8317a = context.getApplicationContext();
        this.f8318d = new g(this.f8317a, new a(this.f8317a), this.f8320g);
        this.f8319e = new f(this.f8317a, this.f8320g);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (e.class) {
            if (f8316f == null) {
                f8316f = new DeviceId(context);
            }
            deviceId = f8316f;
        }
        return deviceId;
    }

    private g.a a() {
        g.a a2 = a((String) null);
        return a2 == null ? this.f8318d.a() : a2;
    }

    private g.a a(String str) {
        g.a b2 = this.f8318d.b();
        return b2 == null ? b(str) : b2;
    }

    public static g.a b(Context context) {
        if (f8314b == null) {
            synchronized (e.class) {
                if (f8314b == null) {
                    SystemClock.uptimeMillis();
                    f8314b = a(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8314b;
    }

    private g.a b(String str) {
        e a2 = this.f8319e.a(str);
        if (a2 != null) {
            return this.f8318d.a(a2);
        }
        return null;
    }

    public static g.a c(Context context) {
        if (f8315c == null) {
            synchronized (e.class) {
                if (f8315c == null) {
                    SystemClock.uptimeMillis();
                    f8315c = a(context).f8318d.c();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8315c;
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
