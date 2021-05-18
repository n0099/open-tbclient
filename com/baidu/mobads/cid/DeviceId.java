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
    public static g.a f8126b = null;

    /* renamed from: c  reason: collision with root package name */
    public static g.a f8127c = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile DeviceId f8128f = null;
    public static boolean sDataCuidInfoShable = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8129a;

    /* renamed from: d  reason: collision with root package name */
    public g f8130d;

    /* renamed from: e  reason: collision with root package name */
    public f f8131e;

    /* renamed from: g  reason: collision with root package name */
    public c f8132g = new c();

    public DeviceId(Context context) {
        this.f8129a = context.getApplicationContext();
        this.f8130d = new g(this.f8129a, new a(this.f8129a), this.f8132g);
        this.f8131e = new f(this.f8129a, this.f8132g);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (e.class) {
            if (f8128f == null) {
                f8128f = new DeviceId(context);
            }
            deviceId = f8128f;
        }
        return deviceId;
    }

    private g.a a() {
        g.a a2 = a((String) null);
        return a2 == null ? this.f8130d.a() : a2;
    }

    private g.a a(String str) {
        g.a b2 = this.f8130d.b();
        return b2 == null ? b(str) : b2;
    }

    public static g.a b(Context context) {
        if (f8126b == null) {
            synchronized (e.class) {
                if (f8126b == null) {
                    SystemClock.uptimeMillis();
                    f8126b = a(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8126b;
    }

    private g.a b(String str) {
        e a2 = this.f8131e.a(str);
        if (a2 != null) {
            return this.f8130d.a(a2);
        }
        return null;
    }

    public static g.a c(Context context) {
        if (f8127c == null) {
            synchronized (e.class) {
                if (f8127c == null) {
                    SystemClock.uptimeMillis();
                    f8127c = a(context).f8130d.c();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8127c;
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
