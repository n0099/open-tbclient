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
    public static class C0026a {
        public String mErrMsg;
        public boolean zA;
    }

    public static C0026a a(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
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

    private static C0026a a(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z) {
        C0026a c0026a;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            try {
                PathClassLoader pathClassLoader = (PathClassLoader) classLoader;
                DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
                dexClassLoader.loadClass(str);
                setField(pathClassLoader, PathClassLoader.class, "mPaths", e(getField(pathClassLoader, PathClassLoader.class, "mPaths"), getField(dexClassLoader, DexClassLoader.class, "mRawDexPath")));
                if (z) {
                    setField(pathClassLoader, PathClassLoader.class, "mDexs", combineArray(getField(pathClassLoader, PathClassLoader.class, "mDexs"), getField(dexClassLoader, DexClassLoader.class, "mDexs")));
                    setField(pathClassLoader, PathClassLoader.class, "mFiles", combineArray(getField(pathClassLoader, PathClassLoader.class, "mFiles"), getField(dexClassLoader, DexClassLoader.class, "mFiles")));
                    setField(pathClassLoader, PathClassLoader.class, "mZips", combineArray(getField(pathClassLoader, PathClassLoader.class, "mZips"), getField(dexClassLoader, DexClassLoader.class, "mZips")));
                } else {
                    setField(pathClassLoader, PathClassLoader.class, "mDexs", combineArray(getField(dexClassLoader, DexClassLoader.class, "mDexs"), getField(pathClassLoader, PathClassLoader.class, "mDexs")));
                    setField(pathClassLoader, PathClassLoader.class, "mFiles", combineArray(getField(dexClassLoader, DexClassLoader.class, "mFiles"), getField(pathClassLoader, PathClassLoader.class, "mFiles")));
                    setField(pathClassLoader, PathClassLoader.class, "mZips", combineArray(getField(dexClassLoader, DexClassLoader.class, "mZips"), getField(pathClassLoader, PathClassLoader.class, "mZips")));
                }
                try {
                    ArrayList arrayList = (ArrayList) getField(pathClassLoader, PathClassLoader.class, "libraryPathElements");
                    for (String str2 : (String[]) getField(dexClassLoader, DexClassLoader.class, "mLibPaths")) {
                        arrayList.add(str2);
                    }
                    Collections.sort(arrayList, new Comparator<Object>() { // from class: com.baidu.adp.plugin.util.a.1
                        @Override // java.util.Comparator
                        public int compare(Object obj, Object obj2) {
                            if ((obj instanceof String) && (obj2 instanceof String)) {
                                return a.E((String) obj, (String) obj2);
                            }
                            return 0;
                        }
                    });
                } catch (Exception e) {
                    setField(pathClassLoader, PathClassLoader.class, "mLibPaths", combineArray(getField(pathClassLoader, PathClassLoader.class, "mLibPaths"), getField(dexClassLoader, DexClassLoader.class, "mLibPaths")));
                }
                c0026a = null;
            } catch (IllegalAccessException e2) {
                C0026a a = a(false, e2);
                BdLog.e(e2);
                c0026a = a;
            } catch (NoSuchFieldException e3) {
                C0026a a2 = a(false, e3);
                BdLog.e(e3);
                c0026a = a2;
            }
        } catch (NoSuchFieldError e4) {
            C0026a a3 = a(false, e4);
            BdLog.e(e4);
            c0026a = a3;
        } catch (Throwable th) {
            C0026a a4 = a(false, th);
            BdLog.e(th);
            c0026a = a4;
        }
        if (c0026a == null) {
            return a(true, null);
        }
        return c0026a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [257=7] */
    private static C0026a b(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
        C0026a c0026a;
        List list;
        List list2;
        List list3;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
            dexClassLoader.loadClass(str);
            Object pathList = getPathList((PathClassLoader) classLoader);
            Object pathList2 = getPathList(dexClassLoader);
            if (Build.VERSION.SDK_INT > 25 || (Build.VERSION.SDK_INT == 25 && Util.isPreview())) {
                Method declaredMethod = pathList.getClass().getDeclaredMethod("addDexPath", String.class, File.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(pathList, str2, null);
                Object combineArray = combineArray(z(pathList), z(pathList2));
                if (combineArray instanceof File[]) {
                    Arrays.sort((File[]) combineArray, kd());
                    list = combineArray;
                } else {
                    boolean z2 = combineArray instanceof List;
                    list = combineArray;
                    if (z2) {
                        List list4 = (List) combineArray;
                        Collections.sort(list4, kd());
                        list = list4;
                    }
                }
                setField(pathList, pathList.getClass(), "nativeLibraryDirectories", list);
                ArrayList arrayList = new ArrayList((List) list);
                arrayList.addAll((List) getField(pathList, pathList.getClass(), "systemNativeLibraryDirectories"));
                Method declaredMethod2 = pathList.getClass().getDeclaredMethod("makePathElements", List.class);
                declaredMethod2.setAccessible(true);
                setField(pathList, pathList.getClass(), "nativeLibraryPathElements", declaredMethod2.invoke(pathList.getClass(), arrayList));
            } else if (Build.VERSION.SDK_INT >= 23) {
                setField(pathList, pathList.getClass(), "dexElements", z ? combineArray(y(pathList), y(pathList2)) : combineArray(y(pathList2), y(pathList)));
                Object combineArray2 = combineArray(z(pathList), z(pathList2));
                if (combineArray2 instanceof File[]) {
                    Arrays.sort((File[]) combineArray2, kd());
                    list3 = combineArray2;
                } else {
                    boolean z3 = combineArray2 instanceof List;
                    list3 = combineArray2;
                    if (z3) {
                        List list5 = (List) combineArray2;
                        Collections.sort(list5, kd());
                        list3 = list5;
                    }
                }
                setField(pathList, pathList.getClass(), "nativeLibraryDirectories", list3);
                ArrayList arrayList2 = new ArrayList((List) list3);
                arrayList2.addAll((List) getField(pathList, pathList.getClass(), "systemNativeLibraryDirectories"));
                Method declaredMethod3 = pathList.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                declaredMethod3.setAccessible(true);
                setField(pathList, pathList.getClass(), "nativeLibraryPathElements", declaredMethod3.invoke(pathList.getClass(), arrayList2, null, new ArrayList()));
            } else {
                setField(pathList, pathList.getClass(), "dexElements", z ? combineArray(y(pathList), y(pathList2)) : combineArray(y(pathList2), y(pathList)));
                Object combineArray3 = combineArray(z(pathList), z(pathList2));
                if (combineArray3 instanceof File[]) {
                    Arrays.sort((File[]) combineArray3, kd());
                    list2 = combineArray3;
                } else {
                    boolean z4 = combineArray3 instanceof List;
                    list2 = combineArray3;
                    if (z4) {
                        List list6 = (List) combineArray3;
                        Collections.sort(list6, kd());
                        list2 = list6;
                    }
                }
                setField(pathList, pathList.getClass(), "nativeLibraryDirectories", list2);
            }
            c0026a = null;
        } catch (ClassNotFoundException e) {
            C0026a a = a(false, e);
            BdLog.e(e);
            c0026a = a;
        } catch (IllegalAccessException e2) {
            C0026a a2 = a(false, e2);
            BdLog.e(e2);
            c0026a = a2;
        } catch (IllegalArgumentException e3) {
            C0026a a3 = a(false, e3);
            BdLog.e(e3);
            c0026a = a3;
        } catch (NoSuchFieldError e4) {
            C0026a a4 = a(false, e4);
            BdLog.e(e4);
            c0026a = a4;
        } catch (NoSuchFieldException e5) {
            C0026a a5 = a(false, e5);
            BdLog.e(e5);
            c0026a = a5;
        } catch (NoSuchMethodException e6) {
            C0026a a6 = a(false, e6);
            BdLog.e(e6);
            c0026a = a6;
        } catch (SecurityException e7) {
            C0026a a7 = a(false, e7);
            BdLog.e(e7);
            c0026a = a7;
        } catch (Throwable th) {
            C0026a a8 = a(false, th);
            BdLog.e(th);
            c0026a = a8;
        }
        return c0026a == null ? a(true, null) : c0026a;
    }

    private static void setField(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    private static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object combineArray(Object obj, Object obj2) {
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

    private static C0026a a(boolean z, Throwable th) {
        C0026a c0026a = new C0026a();
        c0026a.zA = z;
        c0026a.mErrMsg = th != null ? th.getLocalizedMessage() : null;
        return c0026a;
    }

    private static Object getPathList(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException, ClassNotFoundException {
        return getField(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    private static Object y(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        return getField(obj, obj.getClass(), "dexElements");
    }

    private static Object z(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        return getField(obj, obj.getClass(), "nativeLibraryDirectories");
    }

    public static C0026a a(Context context, ClassLoader classLoader, String str) {
        Object field;
        try {
            classLoader.loadClass(str);
            if (Build.VERSION.SDK_INT <= 7) {
                field = getField(context.getApplicationContext(), Class.forName("android.app.ApplicationContext"), "mPackageInfo");
            } else {
                field = getField(getField(context.getApplicationContext(), ContextWrapper.class, "mBase"), Class.forName("android.app.ContextImpl"), "mPackageInfo");
            }
            setField(field, field.getClass(), "mClassLoader", classLoader);
            return a(true, null);
        } catch (IllegalAccessException e) {
            return a(false, e);
        } catch (IllegalArgumentException e2) {
            return a(false, e2);
        } catch (Throwable th) {
            return a(false, th);
        }
    }

    private static final Comparator<File> kd() {
        return new Comparator<File>() { // from class: com.baidu.adp.plugin.util.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                if (file == null || file2 == null) {
                    return 0;
                }
                return a.E(file.getAbsolutePath(), file2.getAbsolutePath());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        return (str.contains("com.baidu.tieba") ? -1 : 0) - (str2.contains("com.baidu.tieba") ? -1 : 0);
    }
}
