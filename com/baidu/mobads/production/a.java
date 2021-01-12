package com.baidu.mobads.production;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static DexClassLoader f3427a = null;

    public static DexClassLoader a(Context context) {
        if (f3427a == null) {
            try {
                String absolutePath = context.getFilesDir().getAbsolutePath();
                File file = new File((context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/") + "local_vr_imageview.jar");
                synchronized (a.class) {
                    String absolutePath2 = file.getAbsolutePath();
                    ClassLoader classLoader = context.getClass().getClassLoader();
                    System.currentTimeMillis();
                    DexClassLoader dexClassLoader = new DexClassLoader(absolutePath2, absolutePath, null, classLoader);
                    System.currentTimeMillis();
                    f3427a = dexClassLoader;
                }
            } catch (Exception e) {
                f3427a = null;
            }
        }
        return f3427a;
    }
}
