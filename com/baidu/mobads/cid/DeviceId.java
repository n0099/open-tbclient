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
    public static g.a f8023b = null;

    /* renamed from: c  reason: collision with root package name */
    public static g.a f8024c = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile DeviceId f8025f = null;
    public static boolean sDataCuidInfoShable = true;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8026a;

    /* renamed from: d  reason: collision with root package name */
    public g f8027d;

    /* renamed from: e  reason: collision with root package name */
    public f f8028e;

    /* renamed from: g  reason: collision with root package name */
    public c f8029g = new c();

    public DeviceId(Context context) {
        this.f8026a = context.getApplicationContext();
        this.f8027d = new g(this.f8026a, new a(this.f8026a), this.f8029g);
        this.f8028e = new f(this.f8026a, this.f8029g);
    }

    public static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (e.class) {
            if (f8025f == null) {
                f8025f = new DeviceId(context);
            }
            deviceId = f8025f;
        }
        return deviceId;
    }

    private g.a a() {
        g.a a2 = a((String) null);
        return a2 == null ? this.f8027d.a() : a2;
    }

    private g.a a(String str) {
        g.a b2 = this.f8027d.b();
        return b2 == null ? b(str) : b2;
    }

    public static g.a b(Context context) {
        if (f8023b == null) {
            synchronized (e.class) {
                if (f8023b == null) {
                    SystemClock.uptimeMillis();
                    f8023b = a(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8023b;
    }

    private g.a b(String str) {
        e a2 = this.f8028e.a(str);
        if (a2 != null) {
            return this.f8027d.a(a2);
        }
        return null;
    }

    public static g.a c(Context context) {
        if (f8024c == null) {
            synchronized (e.class) {
                if (f8024c == null) {
                    SystemClock.uptimeMillis();
                    f8024c = a(context).f8027d.c();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f8024c;
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
