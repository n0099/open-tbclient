package com.baidu.android.silentupdate;

import android.content.Context;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class b {
    private static final String a = "PushClassloader";

    b() {
    }

    public static ClassLoader a(String str, String str2, String str3, Context context) {
        try {
            return new DexClassLoader(str, str2, str3, context.getClassLoader());
        } catch (Exception e) {
            try {
                DexFile dexFile = new DexFile(context.getPackageResourcePath());
                Class<?> cls = Class.forName("dalvik.system.DexFile");
                Method declaredMethod = cls.getDeclaredMethod("openDexFile", String.class, String.class, Integer.TYPE);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(dexFile, str, str2, 0)).intValue();
                Field declaredField = cls.getDeclaredField("mCookie");
                declaredField.setAccessible(true);
                declaredField.set(dexFile, Integer.valueOf(intValue));
                Field declaredField2 = cls.getDeclaredField("mFileName");
                declaredField2.setAccessible(true);
                declaredField2.set(dexFile, str);
                PathClassLoader pathClassLoader = new PathClassLoader(context.getPackageResourcePath(), context.getClassLoader());
                Field declaredField3 = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
                declaredField3.setAccessible(true);
                Object obj = declaredField3.get(pathClassLoader);
                Field declaredField4 = Class.forName("dalvik.system.DexPathList").getDeclaredField("dexElements");
                declaredField4.setAccessible(true);
                Object[] objArr = (Object[]) declaredField4.get(obj);
                if (objArr.length > 0) {
                    Field declaredField5 = Class.forName("dalvik.system.DexPathList$Element").getDeclaredField("dexFile");
                    declaredField5.setAccessible(true);
                    declaredField5.set(objArr[0], dexFile);
                    return pathClassLoader;
                }
            } catch (IOException e2) {
            } catch (ClassNotFoundException e3) {
            } catch (IllegalAccessException e4) {
            } catch (IllegalArgumentException e5) {
            } catch (NoSuchFieldException e6) {
            } catch (NoSuchMethodException e7) {
            } catch (InvocationTargetException e8) {
            }
            return null;
        }
    }

    public static boolean a(ClassLoader classLoader, ClassLoader classLoader2) {
        for (ClassLoader classLoader3 = classLoader2; classLoader3 != null; classLoader3 = classLoader3.getParent()) {
            if (classLoader3 == classLoader) {
                Log.d(a, "the classloader has been inserted");
                return true;
            }
        }
        try {
            Field declaredField = Class.forName("java.lang.ClassLoader").getDeclaredField("parent");
            declaredField.setAccessible(true);
            declaredField.set(classLoader, declaredField.get(classLoader2));
            declaredField.set(classLoader2, classLoader);
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            return false;
        }
    }
}
