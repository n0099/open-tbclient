package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.ILibLoader;
/* loaded from: classes.dex */
public final class a {
    public static volatile ILibLoader sJ;
    public static boolean sK;
    public static volatile boolean sL;
    public static Object sLock = new Object();

    public static void a(ILibLoader iLibLoader) {
        synchronized (sLock) {
            sJ = iLibLoader;
            sK = true;
        }
        sL = false;
    }

    public static ILibLoader ff() {
        if (sJ == null) {
            synchronized (sLock) {
                if (sJ == null) {
                    sJ = new b();
                }
            }
        }
        return sJ;
    }

    public static void fg() {
        sL = false;
    }

    public static boolean isRegistered() {
        boolean z;
        synchronized (sLock) {
            z = sK;
        }
        return z;
    }

    public static void load(Context context, ILibLoader.b bVar) {
        if (sL) {
            return;
        }
        ff().load(context, bVar);
    }

    public static void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        if (sL) {
            return;
        }
        ff().prepareCaseRes(aRType, str, str2, aVar);
    }

    public static void release() {
        sL = true;
        sK = false;
        if (sJ != null) {
            sJ.release();
            sJ = null;
        }
    }

    public static void require(String str) {
        if (sL) {
            return;
        }
        ff().require(str);
    }

    public static void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        ff().setLibLoadPlugin(iLibLoaderPlugin);
    }

    public static void setLibReadyListener(String str, ILibLoader.c cVar) {
        ff().setLibReadyListener(str, cVar);
    }
}
