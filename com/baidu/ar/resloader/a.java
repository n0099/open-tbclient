package com.baidu.ar.resloader;

import android.text.TextUtils;
import com.baidu.ar.resloader.b;
/* loaded from: classes3.dex */
public class a {
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;

    private static void a() {
        if (c) {
            return;
        }
        System.loadLibrary("baiduar");
        c = true;
    }

    public static boolean a(b.a aVar) {
        if (b) {
            b();
        }
        if (a) {
            a();
        }
        if (b && a) {
            if (aVar != null) {
                aVar.a(true);
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (a && str.endsWith("libbaiduar.so")) {
            return false;
        }
        return (b && (str.endsWith("libARClient.so") || str.endsWith("libArTrackerClient.so"))) ? false : true;
    }

    private static void b() {
        if (d) {
            return;
        }
        System.loadLibrary("ARClient");
        d = true;
    }
}
