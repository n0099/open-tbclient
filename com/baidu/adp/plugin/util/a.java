package com.baidu.adp.plugin.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.adp.plugin.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0012a {
        public boolean EV;
        public String mErrMsg;
    }

    public static C0012a a(ClassLoader classLoader, ClassLoader classLoader2, String str) {
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        boolean z = true;
        try {
            Class.forName("dalvik.system.BaseDexClassLoader");
        } catch (ClassNotFoundException e) {
            z = false;
        }
        if (!z) {
            return b(classLoader, classLoader2, str);
        }
        return c(classLoader, classLoader2, str);
    }

    private static C0012a b(ClassLoader classLoader, ClassLoader classLoader2, String str) {
        C0012a c0012a;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            try {
                PathClassLoader pathClassLoader = (PathClassLoader) classLoader;
                DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
                dexClassLoader.loadClass(str);
                a(pathClassLoader, PathClassLoader.class, "mPaths", d(a(pathClassLoader, PathClassLoader.class, "mPaths"), a(dexClassLoader, DexClassLoader.class, "mRawDexPath")));
                a(pathClassLoader, PathClassLoader.class, "mDexs", c(a(pathClassLoader, PathClassLoader.class, "mDexs"), a(dexClassLoader, DexClassLoader.class, "mDexs")));
                a(pathClassLoader, PathClassLoader.class, "mFiles", c(a(pathClassLoader, PathClassLoader.class, "mFiles"), a(dexClassLoader, DexClassLoader.class, "mFiles")));
                a(pathClassLoader, PathClassLoader.class, "mZips", c(a(pathClassLoader, PathClassLoader.class, "mZips"), a(dexClassLoader, DexClassLoader.class, "mZips")));
                try {
                    ArrayList arrayList = (ArrayList) a(pathClassLoader, PathClassLoader.class, "libraryPathElements");
                    for (String str2 : (String[]) a(dexClassLoader, DexClassLoader.class, "mLibPaths")) {
                        arrayList.add(str2);
                    }
                    Collections.sort(arrayList, new b());
                    c0012a = null;
                } catch (Exception e) {
                    a(pathClassLoader, PathClassLoader.class, "mLibPaths", c(a(pathClassLoader, PathClassLoader.class, "mLibPaths"), a(dexClassLoader, DexClassLoader.class, "mLibPaths")));
                    c0012a = null;
                }
            } catch (IllegalAccessException e2) {
                C0012a a = a(false, e2);
                BdLog.e(e2);
                c0012a = a;
            } catch (NoSuchFieldException e3) {
                C0012a a2 = a(false, e3);
                BdLog.e(e3);
                c0012a = a2;
            }
        } catch (NoSuchFieldError e4) {
            C0012a a3 = a(false, e4);
            BdLog.e(e4);
            c0012a = a3;
        } catch (Throwable th) {
            C0012a a4 = a(false, th);
            BdLog.e(th);
            c0012a = a4;
        }
        if (c0012a == null) {
            return a(true, null);
        }
        return c0012a;
    }

    private static C0012a c(ClassLoader classLoader, ClassLoader classLoader2, String str) {
        C0012a c0012a;
        List list;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
            dexClassLoader.loadClass(str);
            Object t = t((PathClassLoader) classLoader);
            Object t2 = t(dexClassLoader);
            a(t, t.getClass(), "dexElements", c(u(t), u(t2)));
            Object c = c(v(t), v(t2));
            if (c instanceof File[]) {
                Arrays.sort((File[]) c, mA());
                list = c;
            } else {
                boolean z = c instanceof List;
                list = c;
                if (z) {
                    List list2 = (List) c;
                    Collections.sort(list2, mA());
                    list = list2;
                }
            }
            a(t, t.getClass(), "nativeLibraryDirectories", list);
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList((List) list);
                arrayList.addAll((List) a(t, t.getClass(), "systemNativeLibraryDirectories"));
                Method declaredMethod = t.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                declaredMethod.setAccessible(true);
                a(t, t.getClass(), "nativeLibraryPathElements", declaredMethod.invoke(t.getClass(), arrayList, null, new ArrayList()));
                c0012a = null;
            } else {
                c0012a = null;
            }
        } catch (ClassNotFoundException e) {
            C0012a a = a(false, e);
            BdLog.e(e);
            c0012a = a;
        } catch (IllegalAccessException e2) {
            C0012a a2 = a(false, e2);
            BdLog.e(e2);
            c0012a = a2;
        } catch (IllegalArgumentException e3) {
            C0012a a3 = a(false, e3);
            BdLog.e(e3);
            c0012a = a3;
        } catch (NoSuchFieldError e4) {
            C0012a a4 = a(false, e4);
            BdLog.e(e4);
            c0012a = a4;
        } catch (NoSuchFieldException e5) {
            C0012a a5 = a(false, e5);
            BdLog.e(e5);
            c0012a = a5;
        } catch (NoSuchMethodException e6) {
            C0012a a6 = a(false, e6);
            BdLog.e(e6);
            c0012a = a6;
        } catch (SecurityException e7) {
            C0012a a7 = a(false, e7);
            BdLog.e(e7);
            c0012a = a7;
        } catch (Throwable th) {
            C0012a a8 = a(false, th);
            BdLog.e(th);
            c0012a = a8;
        }
        if (c0012a == null) {
            return a(true, null);
        }
        return c0012a;
    }

    private static void a(Object obj, Class<?> cls, String str, Object obj2) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj2 != null) {
            if (obj.getClass().isArray() && obj2.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                int length = Array.getLength(obj);
                int length2 = length + Array.getLength(obj2);
                Object newInstance = Array.newInstance(componentType, length2);
                for (int i = 0; i < length2; i++) {
                    if (i < length) {
                        Array.set(newInstance, i, Array.get(obj, i));
                    } else {
                        Array.set(newInstance, i, Array.get(obj2, i - length));
                    }
                }
                return newInstance;
            } else if ((obj instanceof List) && (obj2 instanceof List)) {
                List list = (List) obj;
                List list2 = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size() + list2.size());
                arrayList.addAll(list);
                arrayList.addAll(list2);
                return arrayList;
            } else {
                return obj;
            }
        }
        return obj;
    }

    private static Object d(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int i = length + 1;
        Object newInstance = Array.newInstance(componentType, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < length) {
                Array.set(newInstance, i2, Array.get(obj, i2));
            } else {
                Array.set(newInstance, i2, obj2);
            }
        }
        return newInstance;
    }

    private static C0012a a(boolean z, Throwable th) {
        C0012a c0012a = new C0012a();
        c0012a.EV = z;
        c0012a.mErrMsg = th != null ? th.getLocalizedMessage() : null;
        return c0012a;
    }

    private static Object t(Object obj) {
        return a(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    private static Object u(Object obj) {
        return a(obj, obj.getClass(), "dexElements");
    }

    private static Object v(Object obj) {
        return a(obj, obj.getClass(), "nativeLibraryDirectories");
    }

    public static C0012a a(Context context, ClassLoader classLoader, String str) {
        Object a;
        try {
            classLoader.loadClass(str);
            if (Build.VERSION.SDK_INT <= 7) {
                a = a(context.getApplicationContext(), Class.forName("android.app.ApplicationContext"), "mPackageInfo");
            } else {
                a = a(a(context.getApplicationContext(), ContextWrapper.class, "mBase"), Class.forName("android.app.ContextImpl"), "mPackageInfo");
            }
            a(a, a.getClass(), "mClassLoader", classLoader);
            return a(true, null);
        } catch (IllegalAccessException e) {
            return a(false, e);
        } catch (IllegalArgumentException e2) {
            return a(false, e2);
        } catch (Throwable th) {
            return a(false, th);
        }
    }

    private static final Comparator<File> mA() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int K(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        return (str.contains(TbConfig.MAIN_PACKAGE_NAME) ? -1 : 0) - (str2.contains(TbConfig.MAIN_PACKAGE_NAME) ? -1 : 0);
    }
}
