package com.baidu.cyberplayer.sdk.loader;

import android.os.Build;
import android.system.Os;
import android.util.AndroidRuntimeException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
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
@Keep
/* loaded from: classes3.dex */
public class CyberClassLoader extends BaseDexClassLoader {
    public static Class a;
    public static Class b;

    /* loaded from: classes3.dex */
    public static final class a {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            CyberClassLoader.b(CyberClassLoader.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = CyberClassLoader.b(classLoader, "pathList").get(classLoader);
            List list = (List) CyberClassLoader.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method b = CyberClassLoader.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            ArrayList arrayList = new ArrayList();
            list.addAll((List) CyberClassLoader.b(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list, null, arrayList};
            Field b2 = CyberClassLoader.b(obj, "nativeLibraryPathElements");
            b2.setAccessible(true);
            b2.set(obj, (Object[]) b.invoke(obj, objArr));
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = CyberClassLoader.b(classLoader, "pathList").get(classLoader);
            List list = (List) CyberClassLoader.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method b = CyberClassLoader.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class});
            list.addAll((List) CyberClassLoader.b(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list};
            Field b2 = CyberClassLoader.b(obj, "nativeLibraryPathElements");
            b2.setAccessible(true);
            b2.set(obj, (Object[]) b.invoke(obj, objArr));
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            String path = file.getPath();
            Field b = CyberClassLoader.b(classLoader, "libPath");
            b.set(classLoader, ((String) b.get(classLoader)) + ':' + path);
            Field b2 = CyberClassLoader.b(classLoader, "libraryPathElements");
            List list = (List) b2.get(classLoader);
            list.add(0, path);
            b2.set(classLoader, list);
        }
    }

    public CyberClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(a(str, "super()"), file, str2, classLoader);
        if (Build.VERSION.SDK_INT < 21 && str.endsWith(".so")) {
            CyberLog.d("CyberClassLoader", "makeDexElements for our package. < L");
            a(str, file, str2, classLoader);
        }
    }

    public static void a(Class cls, Object obj, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
        declaredField.setAccessible(isAccessible);
    }

    public static Object a(Class cls, Object obj, String str) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        declaredField.setAccessible(isAccessible);
        return obj2;
    }

    public static void b(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field b2 = b(obj, str);
        Object[] objArr2 = (Object[]) b2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        b2.set(obj, objArr3);
    }

    public static String a(String str, String str2) {
        CyberLog.d("CyberClassLoader", str2);
        return str;
    }

    public static void a() throws Exception {
        if (a == null || b == null) {
            Class<?> cls = Class.forName("dalvik.system.DexPathList");
            a = cls;
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class<?> cls2 = declaredClasses[i];
                if (cls2.getSimpleName().equals("Element")) {
                    b = cls2;
                    break;
                }
                i++;
            }
            if (b != null) {
                return;
            }
            throw new AndroidRuntimeException("DexPathList$Element not found!");
        }
    }

    public static void a(ClassLoader classLoader, File file) throws Throwable {
        int i;
        if (file != null && file.exists()) {
            if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || (i = Build.VERSION.SDK_INT) > 25) {
                try {
                    c.b(classLoader, file);
                    return;
                } catch (Throwable th) {
                    CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v25 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th.getMessage() + ", try to fallback to V23");
                    b.b(classLoader, file);
                    return;
                }
            } else if (i >= 23) {
                try {
                    b.b(classLoader, file);
                    return;
                } catch (Throwable th2) {
                    CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v23 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th2.getMessage() + ", try to fallback to V14");
                    a.b(classLoader, file);
                    return;
                }
            } else if (i >= 14) {
                a.b(classLoader, file);
                return;
            } else {
                d.b(classLoader, file);
                return;
            }
        }
        CyberLog.e("CyberClassLoader", "installNativeLibraryPath, folder (" + file + ") is illegal");
    }

    private void a(String str, File file, String str2, ClassLoader classLoader) {
        Object newInstance;
        try {
            a();
            String replace = new File(str).getName().replace(".so", ".dex");
            DexFile loadDex = DexFile.loadDex(str, file.getAbsolutePath() + File.separator + replace, 0);
            Constructor<?> constructor = b.getConstructors()[0];
            int length = constructor.getParameterTypes().length;
            if (length == 4) {
                newInstance = constructor.newInstance(new File(str), Boolean.FALSE, null, loadDex);
            } else if (length == 3) {
                newInstance = constructor.newInstance(new File(str), null, loadDex);
            } else {
                throw new Exception("Unsupported:" + constructor.toGenericString());
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

    public static void addNativeLibraryDirectories(ClassLoader classLoader, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
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
    }

    public static Field b(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static Method b(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static CyberClassLoader createClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        CyberLog.d("CyberClassLoader", "dexPath:" + str);
        if (Build.VERSION.SDK_INT >= 31) {
            int lastIndexOf = str.lastIndexOf("/");
            if (!new File(str).exists()) {
                CyberLog.e("CyberClassLoader", "Failed to found dexFile:" + str);
            } else if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
                try {
                    String substring = str.substring(0, lastIndexOf);
                    String replace = str.substring(lastIndexOf + 1).replace(".", "_");
                    File file2 = new File(substring, replace);
                    if (!file2.exists()) {
                        CyberLog.d("CyberClassLoader", "SymLink not exists");
                        Os.symlink(str, substring + File.separator + replace);
                    }
                    str = file2.getAbsolutePath();
                    CyberLog.d("CyberClassLoader", "SymLink path:" + str);
                } catch (Exception e) {
                    CyberLog.e("CyberClassLoader", "Failed to create symlink:" + e.toString());
                }
            } else {
                CyberLog.e("CyberClassLoader", "Failed to found '/' in:" + str);
            }
        }
        return new CyberClassLoader(str, file, str2, classLoader);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (str != null) {
            try {
                if (str.startsWith("com.baidu.media.duplayer.") || str.startsWith("com.baidu.media.dlna.") || str.startsWith("com.baidu.media.ext.") || str.startsWith("com.baidu.media.extractor.") || str.startsWith("com.baidu.media.kernelnet.") || str.startsWith("com.baidu.media.pcdn.") || str.startsWith("com.baidu.media.recorder.") || str.startsWith("com.baidu.cybermedia.ext.rtc.") || str.startsWith("com.baidu.cloud.") || str.startsWith("com.baidu.cloudbase.") || str.startsWith("com.baidu.rtc.") || str.startsWith("org.webrtc.") || str.startsWith("tv.danmaku.ijk.media.player.") || str.startsWith("com.baidu.media.playerconfig") || str.startsWith("com.baidu.media.videodownload")) {
                    return findClass(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.loadClass(str);
    }
}
