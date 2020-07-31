package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
/* loaded from: classes11.dex */
public final class b {
    private static volatile a rO;
    private static Object sLock = new Object();
    private static boolean rP = false;

    public static void a(Context context, a.b bVar) {
        dW().a(context, bVar);
    }

    public static void a(ARType aRType, String str, String str2, a.InterfaceC0086a interfaceC0086a) {
        dW().a(aRType, str, str2, interfaceC0086a);
    }

    public static void a(a aVar) {
        synchronized (sLock) {
            rO = aVar;
            rP = true;
        }
    }

    public static void a(String str, a.c cVar) {
        dW().a(str, cVar);
    }

    public static void ao(String str) {
        dW().ao(str);
    }

    private static a dW() {
        if (rO == null) {
            synchronized (sLock) {
                if (rO == null) {
                    rO = new c();
                }
            }
        }
        return rO;
    }

    public static boolean isRegistered() {
        boolean z;
        synchronized (sLock) {
            z = rP;
        }
        return z;
    }

    public static void release() {
        rP = false;
        if (rO != null) {
            rO.release();
            rO = null;
        }
    }

    public static void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        dW().setLibLoadPlugin(iLibLoaderPlugin);
    }
}
