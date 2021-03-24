package com.baidu.platform.comapi.walknavi.d.a.g;

import java.io.File;
/* loaded from: classes2.dex */
public final class c {
    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.mkdirs();
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
