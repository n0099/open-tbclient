package com.baidu.adp.lib.util;

import com.baidu.adp.base.BdBaseApplication;
import dalvik.system.DexFile;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class q {
    public static String a = "Static";

    public static void a() {
        try {
            Enumeration<String> entries = new DexFile(BdBaseApplication.getInst().getApp().getPackageCodePath()).entries();
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
