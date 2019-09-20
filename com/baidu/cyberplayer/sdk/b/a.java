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
/* loaded from: classes.dex */
public class a extends BaseDexClassLoader {
    static Class a = null;
    static Class b = null;

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
