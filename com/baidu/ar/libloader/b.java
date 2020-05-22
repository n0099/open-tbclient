package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
/* loaded from: classes3.dex */
public final class b {
    private static volatile a rp;
    private static Object sLock = new Object();
    private static boolean rq = false;

    public static void a(Context context, a.b bVar) {
        dG().a(context, bVar);
    }

    public static void a(ARType aRType, String str, String str2, a.InterfaceC0084a interfaceC0084a) {
        dG().a(aRType, str, str2, interfaceC0084a);
    }

    public static void a(a aVar) {
        synchronized (sLock) {
            rp = aVar;
            rq = true;
        }
    }

    public static void a(String str, a.c cVar) {
        dG().a(str, cVar);
    }

    public static void an(String str) {
        dG().an(str);
    }

    private static a dG() {
        if (rp == null) {
            synchronized (sLock) {
                if (rp == null) {
                    rp = new c();
                }
            }
        }
        return rp;
    }

    public static boolean isRegistered() {
        boolean z;
        synchronized (sLock) {
            z = rq;
        }
        return z;
    }

    public static void release() {
        rq = false;
        if (rp != null) {
            rp.release();
            rp = null;
        }
    }

    public static void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        dG().setLibLoadPlugin(iLibLoaderPlugin);
    }
}
