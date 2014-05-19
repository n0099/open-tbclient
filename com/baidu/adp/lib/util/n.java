package com.baidu.adp.lib.util;

import dalvik.system.DexFile;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class n {
    public static String a = "Static";

    public static void a() {
        try {
            Enumeration<String> entries = new DexFile(com.baidu.adp.base.a.getInst().getApp().getPackageCodePath()).entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                if (nextElement.endsWith(a)) {
                    Class.forName(nextElement);
                }
            }
        } catch (Exception e) {
        }
    }
}
