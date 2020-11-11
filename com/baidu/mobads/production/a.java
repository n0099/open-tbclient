package com.baidu.mobads.production;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static DexClassLoader f2392a = null;

    public static DexClassLoader a(Context context) {
        if (f2392a == null) {
            try {
                String absolutePath = context.getFilesDir().getAbsolutePath();
                File file = new File((context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/") + "local_vr_imageview.jar");
                synchronized (a.class) {
                    String absolutePath2 = file.getAbsolutePath();
                    ClassLoader classLoader = context.getClass().getClassLoader();
                    System.currentTimeMillis();
                    DexClassLoader dexClassLoader = new DexClassLoader(absolutePath2, absolutePath, null, classLoader);
                    System.currentTimeMillis();
                    f2392a = dexClassLoader;
                }
            } catch (Exception e) {
                f2392a = null;
            }
        }
        return f2392a;
    }
}
