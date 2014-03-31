package com.baidu.adp.lib.util;

import dalvik.system.DexFile;
import java.util.Enumeration;
/* loaded from: classes.dex */
public final class m {
    public static String a = "Static";

    public static void a() {
        try {
            Enumeration<String> entries = new DexFile(com.baidu.adp.a.b.a().b().getPackageCodePath()).entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                try {
                    if (nextElement.endsWith(a)) {
                        Class.forName(nextElement);
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
    }
}
