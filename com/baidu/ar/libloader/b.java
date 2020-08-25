package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.a;
/* loaded from: classes11.dex */
public final class b {
    private static volatile a ss;
    private static Object sLock = new Object();
    private static boolean st = false;
    private static volatile boolean su = false;

    public static void a(Context context, a.b bVar) {
        if (su) {
            return;
        }
        fg().a(context, bVar);
    }

    public static void a(ARType aRType, String str, String str2, a.InterfaceC0083a interfaceC0083a) {
        if (su) {
            return;
        }
        fg().a(aRType, str, str2, interfaceC0083a);
    }

    public static void a(a aVar) {
        synchronized (sLock) {
            ss = aVar;
            st = true;
        }
        su = false;
    }

    public static void a(String str, a.c cVar) {
        fg().a(str, cVar);
    }

    public static void as(String str) {
        if (su) {
            return;
        }
        fg().as(str);
    }

    private static a fg() {
        if (ss == null) {
            synchronized (sLock) {
                if (ss == null) {
                    ss = new c();
                }
            }
        }
        return ss;
    }

    public static void fh() {
        su = false;
    }

    public static boolean isRegistered() {
        boolean z;
        synchronized (sLock) {
            z = st;
        }
        return z;
    }

    public static void release() {
        su = true;
        st = false;
        if (ss != null) {
            ss.release();
            ss = null;
        }
    }

    public static void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        fg().setLibLoadPlugin(iLibLoaderPlugin);
    }
}
