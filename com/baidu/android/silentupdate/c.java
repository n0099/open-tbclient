package com.baidu.android.silentupdate;

import android.app.Application;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
class c {
    c() {
    }

    public static void a(Application application, String str) {
        try {
            Field declaredField = Class.forName("android.content.ContextWrapper").getDeclaredField("mBase");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(application);
            Class<?> cls = Class.forName("android.app.ContextImpl");
            cls.getDeclaredField("mMainThread").setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mPackageInfo");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<?> cls2 = Class.forName("android.app.LoadedApk");
            Field declaredField3 = cls2.getDeclaredField("mResDir");
            declaredField3.setAccessible(true);
            declaredField3.set(obj2, str);
            Field declaredField4 = cls2.getDeclaredField("mResources");
            declaredField4.setAccessible(true);
            declaredField4.set(obj2, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }
}
