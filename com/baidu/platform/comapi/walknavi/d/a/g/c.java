package com.baidu.platform.comapi.walknavi.d.a.g;

import java.io.File;
/* loaded from: classes3.dex */
public final class c {
    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (SecurityException e) {
                return false;
            }
        }
        return true;
    }
}
