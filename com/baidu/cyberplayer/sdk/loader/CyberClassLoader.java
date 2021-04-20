package com.baidu.cyberplayer.sdk.loader;

import android.os.Build;
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
/* loaded from: classes.dex */
public class CyberClassLoader extends BaseDexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    public static Class f5010a;

    /* renamed from: b  reason: collision with root package name */
    public static Class f5011b;

    /* loaded from: classes.dex */
    public static final class a {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            CyberClassLoader.b(CyberClassLoader.b(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = CyberClassLoader.b(classLoader, "pathList").get(classLoader);
            List list = (List) CyberClassLoader.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method b2 = CyberClassLoader.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            ArrayList arrayList = new ArrayList();
            list.addAll((List) CyberClassLoader.b(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list, null, arrayList};
            Field b3 = CyberClassLoader.b(obj, "nativeLibraryPathElements");
            b3.setAccessible(true);
            b3.set(obj, (Object[]) b2.invoke(obj, objArr));
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            Object obj = CyberClassLoader.b(classLoader, "pathList").get(classLoader);
            List list = (List) CyberClassLoader.b(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method b2 = CyberClassLoader.b(obj, "makePathElements", (Class<?>[]) new Class[]{List.class});
            list.addAll((List) CyberClassLoader.b(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list};
            Field b3 = CyberClassLoader.b(obj, "nativeLibraryPathElements");
            b3.setAccessible(true);
            b3.set(obj, (Object[]) b2.invoke(obj, objArr));
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static void b(ClassLoader classLoader, File file) throws Throwable {
            String path = file.getPath();
            Field b2 = CyberClassLoader.b(classLoader, "libPath");
            b2.set(classLoader, ((String) b2.get(classLoader)) + ':' + path);
            Field b3 = CyberClassLoader.b(classLoader, "libraryPathElements");
            List list = (List) b3.get(classLoader);
            list.add(0, path);
            b3.set(classLoader, list);
        }
    }

    public CyberClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(a(str, "super()"), file, str2, classLoader);
        if (Build.VERSION.SDK_INT >= 21 || !str.endsWith(".so")) {
            return;
        }
        CyberLog.d("CyberClassLoader", "makeDexElements for our package. < L");
        a(str, file, str2, classLoader);
    }

    public static Object a(Class cls, Object obj, String str) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        declaredField.setAccessible(isAccessible);
        return obj2;
    }

    public static String a(String str, String str2) {
        CyberLog.d("CyberClassLoader", str2);
        return str;
    }

    public static void a() throws Exception {
        if (f5010a == null || f5011b == null) {
            Class<?> cls = Class.forName("dalvik.system.DexPathList");
            f5010a = cls;
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class<?> cls2 = declaredClasses[i];
                if (cls2.getSimpleName().equals("Element")) {
                    f5011b = cls2;
                    break;
                }
                i++;
            }
            if (f5011b == null) {
                throw new AndroidRuntimeException("DexPathList$Element not found!");
            }
        }
    }

    public static void a(Class cls, Object obj, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
        declaredField.setAccessible(isAccessible);
    }

    public static void a(ClassLoader classLoader, File file) throws Throwable {
        int i;
        if (file == null || !file.exists()) {
            CyberLog.e("CyberClassLoader", "installNativeLibraryPath, folder (" + file + ") is illegal");
        } else if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || (i = Build.VERSION.SDK_INT) > 25) {
            try {
                c.b(classLoader, file);
            } catch (Throwable th) {
                CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v25 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th.getMessage() + ", try to fallback to V23");
            }
        } else {
            if (i >= 23) {
                try {
                    b.b(classLoader, file);
                    return;
                } catch (Throwable th2) {
                    CyberLog.e("CyberClassLoader", "installNativeLibraryPath, v23 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th2.getMessage() + ", try to fallback to V14");
                }
            } else if (i < 14) {
                d.b(classLoader, file);
                return;
            }
            a.b(classLoader, file);
        }
    }

    private void a(String str, File file, String str2, ClassLoader classLoader) {
        Object newInstance;
        try {
            a();
            String replace = new File(str).getName().replace(".so", ".dex");
            DexFile loadDex = DexFile.loadDex(str, file.getAbsolutePath() + File.separator + replace, 0);
            Constructor<?> constructor = f5011b.getConstructors()[0];
            int length = constructor.getParameterTypes().length;
            if (length == 4) {
                newInstance = constructor.newInstance(new File(str), Boolean.FALSE, null, loadDex);
            } else if (length != 3) {
                throw new Exception("Unsupported:" + constructor.toGenericString());
            } else {
                newInstance = constructor.newInstance(new File(str), null, loadDex);
            }
            Object newInstance2 = Array.newInstance(f5011b, 1);
            Array.set(newInstance2, 0, newInstance);
            Object a2 = a(BaseDexClassLoader.class, this, "pathList");
            a(f5010a, a2, "dexElements", newInstance2);
            if (Build.VERSION.SDK_INT >= 19) {
                a(f5010a, a2, "dexElementsSuppressedExceptions", (Object) null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new AndroidRuntimeException(e2);
        }
    }

    public static void addNativeLibraryDirectories(ClassLoader classLoader, String[] strArr) {
        StringBuilder sb;
        String th;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            try {
                a(classLoader, new File(str));
            } catch (Exception e2) {
                sb = new StringBuilder();
                sb.append("addNativeLibraryDirectories:");
                th = e2.toString();
                sb.append(th);
                CyberLog.e("CyberClassLoader", sb.toString());
            } catch (Throwable th2) {
                sb = new StringBuilder();
                sb.append("addNativeLibraryDirectories:");
                th = th2.toString();
                sb.append(th);
                CyberLog.e("CyberClassLoader", sb.toString());
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
                if (str.startsWith("com.baidu.media.duplayer.") || str.startsWith("com.baidu.media.dlna.") || str.startsWith("com.baidu.media.ext.") || str.startsWith("com.baidu.media.extractor.") || str.startsWith("com.baidu.media.kernelnet.") || str.startsWith("com.baidu.media.pcdn.") || str.startsWith("com.baidu.media.recorder.") || str.startsWith("com.baidu.cybermedia.ext.rtc.") || str.startsWith("com.baidu.cloud.") || str.startsWith("com.baidu.cloudbase.") || str.startsWith("com.baidu.rtc.") || str.startsWith("org.webrtc.") || str.startsWith("tv.danmaku.ijk.media.player.")) {
                    return findClass(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.loadClass(str);
    }
}
