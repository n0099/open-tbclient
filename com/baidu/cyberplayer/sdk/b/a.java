package com.baidu.cyberplayer.sdk.b;

import android.os.Build;
import android.util.AndroidRuntimeException;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.cyberplayer.sdk.CyberLog;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseDexClassLoader {
    static Class a = null;
    static Class b = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.cyberplayer.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0107a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            a.b(a.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = a.b(classLoader, "pathList").get(classLoader);
            List list = (List) a.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method b = a.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            ArrayList arrayList = new ArrayList();
            list.addAll((List) a.b(obj, "systemNativeLibraryDirectories").get(obj));
            Field b2 = a.b(obj, "nativeLibraryPathElements");
            b2.setAccessible(true);
            b2.set(obj, (Object[]) b.invoke(obj, list, null, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = a.b(classLoader, "pathList").get(classLoader);
            List list = (List) a.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method b = a.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class});
            list.addAll((List) a.b(obj, "systemNativeLibraryDirectories").get(obj));
            Field b2 = a.b(obj, "nativeLibraryPathElements");
            b2.setAccessible(true);
            b2.set(obj, (Object[]) b.invoke(obj, list));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            String path = file.getPath();
            Field b = a.b(classLoader, "libPath");
            StringBuilder sb = new StringBuilder((String) b.get(classLoader));
            sb.append(':').append(path);
            b.set(classLoader, sb.toString());
            Field b2 = a.b(classLoader, "libraryPathElements");
            List list = (List) b2.get(classLoader);
            list.add(0, path);
            b2.set(classLoader, list);
        }
    }

    public a(String str, File file, String str2, ClassLoader classLoader) {
        super(a(str, "super()"), file, str2, classLoader);
        if (Build.VERSION.SDK_INT >= 21 || !str.endsWith(PluginInstallerService.APK_LIB_SUFFIX)) {
            return;
        }
        CyberLog.d("CyberClassLoader", "makeDexElements for our package. < L");
        a(str, file, str2, classLoader);
    }

    private static Object a(Class cls, Object obj, String str) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        declaredField.setAccessible(isAccessible);
        return obj2;
    }

    private static String a(String str, String str2) {
        CyberLog.d("CyberClassLoader", str2);
        return str;
    }

    private static void a() throws Exception {
        if (a == null || b == null) {
            a = Class.forName("dalvik.system.DexPathList");
            Class<?>[] declaredClasses = a.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class<?> cls = declaredClasses[i];
                if (cls.getSimpleName().equals("Element")) {
                    b = cls;
                    break;
                }
                i++;
            }
            if (b == null) {
                throw new AndroidRuntimeException("DexPathList$Element not found!");
            }
        }
    }

    private static void a(Class cls, Object obj, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
        declaredField.setAccessible(isAccessible);
    }

    private static void a(ClassLoader classLoader, File file) throws Throwable {
        if (file == null || !file.exists()) {
            CyberLog.e("CyberClassLoader", "installNativeLibraryPath, folder (" + file + ") is illegal");
        } else if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
            try {
                c.b(classLoader, file);
            } catch (Throwable th) {
                CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v25 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th.getMessage() + ", try to fallback to V23");
            }
        } else if (Build.VERSION.SDK_INT < 23) {
            if (Build.VERSION.SDK_INT >= 14) {
                C0107a.b(classLoader, file);
            } else {
                d.b(classLoader, file);
            }
        } else {
            try {
                b.b(classLoader, file);
            } catch (Throwable th2) {
                CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v23 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th2.getMessage() + ", try to fallback to V14");
                C0107a.b(classLoader, file);
            }
        }
    }

    public static void a(ClassLoader classLoader, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            try {
                a(classLoader, new File(str));
            } catch (Exception e) {
                CyberLog.e("CyberClassLoader", "addNativeLibraryDirectories:" + e.toString());
            } catch (Throwable th) {
                CyberLog.e("CyberClassLoader", "addNativeLibraryDirectories:" + th.toString());
            }
        }
    }

    private void a(String str, File file, String str2, ClassLoader classLoader) {
        Object newInstance;
        try {
            a();
            DexFile loadDex = DexFile.loadDex(str, file.getAbsolutePath() + File.separator + new File(str).getName().replace(PluginInstallerService.APK_LIB_SUFFIX, ".dex"), 0);
            Constructor<?> constructor = b.getConstructors()[0];
            int length = constructor.getParameterTypes().length;
            if (length == 4) {
                newInstance = constructor.newInstance(new File(str), false, null, loadDex);
            } else if (length != 3) {
                throw new Exception("Unsupported:" + constructor.toGenericString());
            } else {
                newInstance = constructor.newInstance(new File(str), null, loadDex);
            }
            Object newInstance2 = Array.newInstance(b, 1);
            Array.set(newInstance2, 0, newInstance);
            Object a2 = a(BaseDexClassLoader.class, this, "pathList");
            a(a, a2, "dexElements", newInstance2);
            if (Build.VERSION.SDK_INT >= 19) {
                a(a, a2, "dexElementsSuppressedExceptions", (Object) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AndroidRuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field b(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field b2 = b(obj, str);
        Object[] objArr2 = (Object[]) b2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        b2.set(obj, objArr3);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (str != null) {
            try {
                if (str.startsWith("com.baidu.media.duplayer.") || str.startsWith("tv.danmaku.ijk.media.player.")) {
                    return findClass(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.loadClass(str);
    }
}
