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
    public static final String COM_BAIDU_CLOUD = "com.baidu.cloud.";
    public static final String COM_BAIDU_CLOUDBASE = "com.baidu.cloudbase.";
    public static final String COM_BAIDU_CYBERMEDIA_EXT_RTC = "com.baidu.cybermedia.ext.rtc.";
    public static final String COM_BAIDU_MEDIA_DLNA = "com.baidu.media.dlna.";
    public static final String COM_BAIDU_MEDIA_DUPLAYER = "com.baidu.media.duplayer.";
    public static final String COM_BAIDU_MEDIA_EXT = "com.baidu.media.ext.";
    public static final String COM_BAIDU_MEDIA_EXTRACTOR = "com.baidu.media.extractor.";
    public static final String COM_BAIDU_MEDIA_KERNELNET = "com.baidu.media.kernelnet.";
    public static final String COM_BAIDU_MEDIA_PCDN = "com.baidu.media.pcdn.";
    public static final String COM_BAIDU_MEDIA_PLAYER_CONFIG = "com.baidu.media.playerconfig";
    public static final String COM_BAIDU_MEDIA_RECORDER = "com.baidu.media.recorder.";
    public static final String COM_BAIDU_MEDIA_VIDEO_DOWNLOAD = "com.baidu.media.videodownload";
    public static final String COM_BAIDU_RTC = "com.baidu.rtc.";
    public static Class DexPathListClass = null;
    public static Class ElementClass = null;
    public static final String ORG_WEBRTC = "org.webrtc.";
    public static final String TAG = "CyberClassLoader";
    public static final String TV_DANMAKU_IJK_MEDIA_PLAYER = "tv.danmaku.ijk.media.player.";

    public CyberClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(logBeforeCallSuper(str, "super()"), file, str2, classLoader);
        if (Build.VERSION.SDK_INT < 21 && str.endsWith(".so")) {
            CyberLog.d(TAG, "makeDexElements for our package. < L");
            makeAndSetDexElements(str, file, str2, classLoader);
        }
    }

    public static void setField(Class cls, Object obj, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
        declaredField.setAccessible(isAccessible);
    }

    /* loaded from: classes3.dex */
    public static final class V14 {
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            CyberClassLoader.expandFieldArray(CyberClassLoader.findField(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* loaded from: classes3.dex */
    public static final class V23 {
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = CyberClassLoader.findField(classLoader, "pathList").get(classLoader);
            List list = (List) CyberClassLoader.findField(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method findMethod = CyberClassLoader.findMethod(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList = new ArrayList();
            list.addAll((List) CyberClassLoader.findField(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list, null, arrayList};
            Field findField = CyberClassLoader.findField(obj, "nativeLibraryPathElements");
            findField.setAccessible(true);
            findField.set(obj, (Object[]) findMethod.invoke(obj, objArr));
        }
    }

    /* loaded from: classes3.dex */
    public static final class V25 {
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = CyberClassLoader.findField(classLoader, "pathList").get(classLoader);
            List list = (List) CyberClassLoader.findField(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method findMethod = CyberClassLoader.findMethod(obj, "makePathElements", List.class);
            list.addAll((List) CyberClassLoader.findField(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list};
            Field findField = CyberClassLoader.findField(obj, "nativeLibraryPathElements");
            findField.setAccessible(true);
            findField.set(obj, (Object[]) findMethod.invoke(obj, objArr));
        }
    }

    /* loaded from: classes3.dex */
    public static final class V4 {
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            String path = file.getPath();
            Field findField = CyberClassLoader.findField(classLoader, "libPath");
            findField.set(classLoader, ((String) findField.get(classLoader)) + ':' + path);
            Field findField2 = CyberClassLoader.findField(classLoader, "libraryPathElements");
            List list = (List) findField2.get(classLoader);
            list.add(0, path);
            findField2.set(classLoader, list);
        }
    }

    public static String logBeforeCallSuper(String str, String str2) {
        CyberLog.d(TAG, str2);
        return str;
    }

    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        findField.set(obj, objArr3);
    }

    public static Object getField(Class cls, Object obj, String str) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        boolean isAccessible = declaredField.isAccessible();
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        declaredField.setAccessible(isAccessible);
        return obj2;
    }

    public static void addNativeLibraryDirectories(ClassLoader classLoader, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                try {
                    installNativeLibraryPath(classLoader, new File(str));
                } catch (Exception e) {
                    CyberLog.e(TAG, "addNativeLibraryDirectories:" + e.toString());
                } catch (Throwable th) {
                    CyberLog.e(TAG, "addNativeLibraryDirectories:" + th.toString());
                }
            }
        }
    }

    public static CyberClassLoader createClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        CyberLog.d(TAG, "dexPath:" + str);
        if (Build.VERSION.SDK_INT >= 31) {
            int lastIndexOf = str.lastIndexOf("/");
            if (!new File(str).exists()) {
                CyberLog.e(TAG, "Failed to found dexFile:" + str);
            } else if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
                try {
                    String substring = str.substring(0, lastIndexOf);
                    String replace = str.substring(lastIndexOf + 1).replace(".", "_");
                    File file2 = new File(substring, replace);
                    if (!file2.exists()) {
                        CyberLog.d(TAG, "SymLink not exists");
                        Os.symlink(str, substring + File.separator + replace);
                    }
                    str = file2.getAbsolutePath();
                    CyberLog.d(TAG, "SymLink path:" + str);
                } catch (Exception e) {
                    CyberLog.e(TAG, "Failed to create symlink:" + e.toString());
                }
            } else {
                CyberLog.e(TAG, "Failed to found '/' in:" + str);
            }
        }
        return new CyberClassLoader(str, file, str2, classLoader);
    }

    public static void ensureReflectionInited() throws Exception {
        if (DexPathListClass == null || ElementClass == null) {
            Class<?> cls = Class.forName("dalvik.system.DexPathList");
            DexPathListClass = cls;
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Class<?> cls2 = declaredClasses[i];
                if (cls2.getSimpleName().equals("Element")) {
                    ElementClass = cls2;
                    break;
                }
                i++;
            }
            if (ElementClass != null) {
                return;
            }
            throw new AndroidRuntimeException("DexPathList$Element not found!");
        }
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
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

    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
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

    public static void installNativeLibraryPath(ClassLoader classLoader, File file) throws Throwable {
        int i;
        if (file != null && file.exists()) {
            if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || (i = Build.VERSION.SDK_INT) > 25) {
                try {
                    V25.install(classLoader, file);
                    return;
                } catch (Throwable th) {
                    CyberLog.e(TAG, "installNativeLibraryPath, v25 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th.getMessage() + ", try to fallback to V23");
                    V23.install(classLoader, file);
                    return;
                }
            } else if (i >= 23) {
                try {
                    V23.install(classLoader, file);
                    return;
                } catch (Throwable th2) {
                    CyberLog.e(TAG, "installNativeLibraryPath, v23 fail, sdk: " + Build.VERSION.SDK_INT + ", error: " + th2.getMessage() + ", try to fallback to V14");
                    V14.install(classLoader, file);
                    return;
                }
            } else if (i >= 14) {
                V14.install(classLoader, file);
                return;
            } else {
                V4.install(classLoader, file);
                return;
            }
        }
        CyberLog.e(TAG, "installNativeLibraryPath, folder (" + file + ") is illegal");
    }

    private void makeAndSetDexElements(String str, File file, String str2, ClassLoader classLoader) {
        Object newInstance;
        try {
            ensureReflectionInited();
            String replace = new File(str).getName().replace(".so", ".dex");
            DexFile loadDex = DexFile.loadDex(str, file.getAbsolutePath() + File.separator + replace, 0);
            Constructor<?> constructor = ElementClass.getConstructors()[0];
            int length = constructor.getParameterTypes().length;
            if (length == 4) {
                newInstance = constructor.newInstance(new File(str), Boolean.FALSE, null, loadDex);
            } else if (length == 3) {
                newInstance = constructor.newInstance(new File(str), null, loadDex);
            } else {
                throw new Exception("Unsupported:" + constructor.toGenericString());
            }
            Object newInstance2 = Array.newInstance(ElementClass, 1);
            Array.set(newInstance2, 0, newInstance);
            Object field = getField(BaseDexClassLoader.class, this, "pathList");
            setField(DexPathListClass, field, "dexElements", newInstance2);
            if (Build.VERSION.SDK_INT >= 19) {
                setField(DexPathListClass, field, "dexElementsSuppressedExceptions", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AndroidRuntimeException(e);
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (str != null) {
            try {
                if (str.startsWith(COM_BAIDU_MEDIA_DUPLAYER) || str.startsWith(COM_BAIDU_MEDIA_DLNA) || str.startsWith(COM_BAIDU_MEDIA_EXT) || str.startsWith(COM_BAIDU_MEDIA_EXTRACTOR) || str.startsWith(COM_BAIDU_MEDIA_KERNELNET) || str.startsWith(COM_BAIDU_MEDIA_PCDN) || str.startsWith(COM_BAIDU_MEDIA_RECORDER) || str.startsWith(COM_BAIDU_CYBERMEDIA_EXT_RTC) || str.startsWith(COM_BAIDU_CLOUD) || str.startsWith(COM_BAIDU_CLOUDBASE) || str.startsWith(COM_BAIDU_RTC) || str.startsWith(ORG_WEBRTC) || str.startsWith(TV_DANMAKU_IJK_MEDIA_PLAYER) || str.startsWith(COM_BAIDU_MEDIA_PLAYER_CONFIG) || str.startsWith(COM_BAIDU_MEDIA_VIDEO_DOWNLOAD)) {
                    return findClass(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.loadClass(str);
    }
}
