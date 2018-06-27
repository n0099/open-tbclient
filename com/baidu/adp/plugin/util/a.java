package com.baidu.adp.plugin.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
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
    public static class C0022a {
        public boolean Jm;
        public String mErrMsg;
    }

    public static C0022a a(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        boolean z2 = true;
        try {
            Class.forName("dalvik.system.BaseDexClassLoader");
        } catch (ClassNotFoundException e) {
            z2 = false;
        }
        if (!z2) {
            return a(classLoader, classLoader2, str, z);
        }
        return b(classLoader, classLoader2, str, z, str2);
    }

    private static C0022a a(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z) {
        C0022a c0022a;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            try {
                PathClassLoader pathClassLoader = (PathClassLoader) classLoader;
                DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
                dexClassLoader.loadClass(str);
                a(pathClassLoader, PathClassLoader.class, "mPaths", e(a(pathClassLoader, PathClassLoader.class, "mPaths"), a(dexClassLoader, DexClassLoader.class, "mRawDexPath")));
                if (z) {
                    a(pathClassLoader, PathClassLoader.class, "mDexs", d(a(pathClassLoader, PathClassLoader.class, "mDexs"), a(dexClassLoader, DexClassLoader.class, "mDexs")));
                    a(pathClassLoader, PathClassLoader.class, "mFiles", d(a(pathClassLoader, PathClassLoader.class, "mFiles"), a(dexClassLoader, DexClassLoader.class, "mFiles")));
                    a(pathClassLoader, PathClassLoader.class, "mZips", d(a(pathClassLoader, PathClassLoader.class, "mZips"), a(dexClassLoader, DexClassLoader.class, "mZips")));
                } else {
                    a(pathClassLoader, PathClassLoader.class, "mDexs", d(a(dexClassLoader, DexClassLoader.class, "mDexs"), a(pathClassLoader, PathClassLoader.class, "mDexs")));
                    a(pathClassLoader, PathClassLoader.class, "mFiles", d(a(dexClassLoader, DexClassLoader.class, "mFiles"), a(pathClassLoader, PathClassLoader.class, "mFiles")));
                    a(pathClassLoader, PathClassLoader.class, "mZips", d(a(dexClassLoader, DexClassLoader.class, "mZips"), a(pathClassLoader, PathClassLoader.class, "mZips")));
                }
                try {
                    ArrayList arrayList = (ArrayList) a(pathClassLoader, PathClassLoader.class, "libraryPathElements");
                    for (String str2 : (String[]) a(dexClassLoader, DexClassLoader.class, "mLibPaths")) {
                        arrayList.add(str2);
                    }
                    Collections.sort(arrayList, new Comparator<Object>() { // from class: com.baidu.adp.plugin.util.a.1
                        @Override // java.util.Comparator
                        public int compare(Object obj, Object obj2) {
                            if ((obj instanceof String) && (obj2 instanceof String)) {
                                return a.H((String) obj, (String) obj2);
                            }
                            return 0;
                        }
                    });
                } catch (Exception e) {
                    a(pathClassLoader, PathClassLoader.class, "mLibPaths", d(a(pathClassLoader, PathClassLoader.class, "mLibPaths"), a(dexClassLoader, DexClassLoader.class, "mLibPaths")));
                }
                c0022a = null;
            } catch (IllegalAccessException e2) {
                C0022a a = a(false, e2);
                BdLog.e(e2);
                c0022a = a;
            } catch (NoSuchFieldException e3) {
                C0022a a2 = a(false, e3);
                BdLog.e(e3);
                c0022a = a2;
            }
        } catch (NoSuchFieldError e4) {
            C0022a a3 = a(false, e4);
            BdLog.e(e4);
            c0022a = a3;
        } catch (Throwable th) {
            C0022a a4 = a(false, th);
            BdLog.e(th);
            c0022a = a4;
        }
        if (c0022a == null) {
            return a(true, null);
        }
        return c0022a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [257=7] */
    private static C0022a b(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
        C0022a c0022a;
        List list;
        List list2;
        List list3;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
            dexClassLoader.loadClass(str);
            Object y = y((PathClassLoader) classLoader);
            Object y2 = y(dexClassLoader);
            if (Build.VERSION.SDK_INT > 25 || (Build.VERSION.SDK_INT == 25 && Util.isPreview())) {
                Method declaredMethod = y.getClass().getDeclaredMethod("addDexPath", String.class, File.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(y, str2, null);
                Object d = d(A(y), A(y2));
                if (d instanceof File[]) {
                    Arrays.sort((File[]) d, mw());
                    list = d;
                } else {
                    boolean z2 = d instanceof List;
                    list = d;
                    if (z2) {
                        List list4 = (List) d;
                        Collections.sort(list4, mw());
                        list = list4;
                    }
                }
                a(y, y.getClass(), "nativeLibraryDirectories", list);
                ArrayList arrayList = new ArrayList((List) list);
                arrayList.addAll((List) a(y, y.getClass(), "systemNativeLibraryDirectories"));
                Method declaredMethod2 = y.getClass().getDeclaredMethod("makePathElements", List.class);
                declaredMethod2.setAccessible(true);
                a(y, y.getClass(), "nativeLibraryPathElements", declaredMethod2.invoke(y.getClass(), arrayList));
            } else if (Build.VERSION.SDK_INT >= 23) {
                a(y, y.getClass(), "dexElements", z ? d(z(y), z(y2)) : d(z(y2), z(y)));
                Object d2 = d(A(y), A(y2));
                if (d2 instanceof File[]) {
                    Arrays.sort((File[]) d2, mw());
                    list3 = d2;
                } else {
                    boolean z3 = d2 instanceof List;
                    list3 = d2;
                    if (z3) {
                        List list5 = (List) d2;
                        Collections.sort(list5, mw());
                        list3 = list5;
                    }
                }
                a(y, y.getClass(), "nativeLibraryDirectories", list3);
                ArrayList arrayList2 = new ArrayList((List) list3);
                arrayList2.addAll((List) a(y, y.getClass(), "systemNativeLibraryDirectories"));
                Method declaredMethod3 = y.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                declaredMethod3.setAccessible(true);
                a(y, y.getClass(), "nativeLibraryPathElements", declaredMethod3.invoke(y.getClass(), arrayList2, null, new ArrayList()));
            } else {
                a(y, y.getClass(), "dexElements", z ? d(z(y), z(y2)) : d(z(y2), z(y)));
                Object d3 = d(A(y), A(y2));
                if (d3 instanceof File[]) {
                    Arrays.sort((File[]) d3, mw());
                    list2 = d3;
                } else {
                    boolean z4 = d3 instanceof List;
                    list2 = d3;
                    if (z4) {
                        List list6 = (List) d3;
                        Collections.sort(list6, mw());
                        list2 = list6;
                    }
                }
                a(y, y.getClass(), "nativeLibraryDirectories", list2);
            }
            c0022a = null;
        } catch (ClassNotFoundException e) {
            C0022a a = a(false, e);
            BdLog.e(e);
            c0022a = a;
        } catch (IllegalAccessException e2) {
            C0022a a2 = a(false, e2);
            BdLog.e(e2);
            c0022a = a2;
        } catch (IllegalArgumentException e3) {
            C0022a a3 = a(false, e3);
            BdLog.e(e3);
            c0022a = a3;
        } catch (NoSuchFieldError e4) {
            C0022a a4 = a(false, e4);
            BdLog.e(e4);
            c0022a = a4;
        } catch (NoSuchFieldException e5) {
            C0022a a5 = a(false, e5);
            BdLog.e(e5);
            c0022a = a5;
        } catch (NoSuchMethodException e6) {
            C0022a a6 = a(false, e6);
            BdLog.e(e6);
            c0022a = a6;
        } catch (SecurityException e7) {
            C0022a a7 = a(false, e7);
            BdLog.e(e7);
            c0022a = a7;
        } catch (Throwable th) {
            C0022a a8 = a(false, th);
            BdLog.e(th);
            c0022a = a8;
        }
        return c0022a == null ? a(true, null) : c0022a;
    }

    private static void a(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    private static Object a(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object d(Object obj, Object obj2) {
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

    private static Object e(Object obj, Object obj2) {
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

    private static C0022a a(boolean z, Throwable th) {
        C0022a c0022a = new C0022a();
        c0022a.Jm = z;
        c0022a.mErrMsg = th != null ? th.getLocalizedMessage() : null;
        return c0022a;
    }

    private static Object y(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException, ClassNotFoundException {
        return a(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    private static Object z(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        return a(obj, obj.getClass(), "dexElements");
    }

    private static Object A(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        return a(obj, obj.getClass(), "nativeLibraryDirectories");
    }

    public static C0022a a(Context context, ClassLoader classLoader, String str) {
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

    private static final Comparator<File> mw() {
        return new Comparator<File>() { // from class: com.baidu.adp.plugin.util.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                if (file == null || file2 == null) {
                    return 0;
                }
                return a.H(file.getAbsolutePath(), file2.getAbsolutePath());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        return (str.contains("com.baidu.tieba") ? -1 : 0) - (str2.contains("com.baidu.tieba") ? -1 : 0);
    }
}
