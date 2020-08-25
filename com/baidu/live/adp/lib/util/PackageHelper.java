package com.baidu.live.adp.lib.util;

import com.baidu.live.adp.base.BdBaseApplication;
import dalvik.system.DexFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes7.dex */
public class PackageHelper {
    public static String SUFFIX = "Static";

    public static void loadPackageStaticClasses() {
        try {
            Enumeration<String> entries = new DexFile(BdBaseApplication.getInst().getApp().getPackageCodePath()).entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                if (nextElement.endsWith(SUFFIX)) {
                    Class.forName(nextElement);
                }
            }
        } catch (Exception e) {
        }
    }

    public static List<String> getPackageClassesByInterface(Class<?> cls, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<String> entries = new DexFile(BdBaseApplication.getInst().getApp().getPackageCodePath()).entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                try {
                    if (nextElement.contains(str)) {
                        Class<?> cls2 = Class.forName(nextElement, false, contextClassLoader);
                        if (cls.isAssignableFrom(cls2) && !cls.equals(cls2)) {
                            arrayList.add(nextElement);
                        }
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> getPackageClasses() {
        try {
            DexFile dexFile = new DexFile(BdBaseApplication.getInst().getApp().getPackageCodePath());
            ArrayList arrayList = new ArrayList();
            Enumeration<String> entries = dexFile.entries();
            while (entries.hasMoreElements()) {
                arrayList.add(entries.nextElement());
            }
            return arrayList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
