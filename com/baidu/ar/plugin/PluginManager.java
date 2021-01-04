package com.baidu.ar.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.plugin.helper.ActivityThreadCompat;
import com.baidu.ar.plugin.helper.CompatibilityInfoCompat;
import com.baidu.ar.plugin.helper.NativeLibraryHelperCompat;
import com.baidu.ar.plugin.helper.Utils;
import com.baidu.ar.plugin.reflect.FieldUtils;
import com.baidu.ar.plugin.reflect.MethodUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class PluginManager {
    private Context mContext;
    private Map<String, PluginPackageParser> mPluginCache = Collections.synchronizedMap(new HashMap(1));
    private static PluginManager sPluginManager = null;
    private static Map<String, ClassLoader> sPluginClassLoaderCache = new WeakHashMap(1);
    private static Map<String, Object> sPluginLoadedApkCache = new WeakHashMap(1);

    PluginManager(Context context) {
        this.mContext = context;
    }

    public static PluginManager getPluginManagerInstance(Context context) {
        if (sPluginManager == null) {
            sPluginManager = new PluginManager(context);
        }
        return sPluginManager;
    }

    private int copyNativeLibs(Context context, String str, ApplicationInfo applicationInfo) throws Exception {
        String pluginNativeLibraryDir = PluginDirHelper.getPluginNativeLibraryDir(context, applicationInfo.packageName);
        if (new File(pluginNativeLibraryDir).list().length > 1) {
            return 1;
        }
        return NativeLibraryHelperCompat.copyNativeBinaries(new File(str), new File(pluginNativeLibraryDir));
    }

    private void saveSignatures(PackageInfo packageInfo) {
        if (packageInfo != null && packageInfo.signatures != null) {
            Signature[] signatureArr = packageInfo.signatures;
            int length = signatureArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Signature signature = signatureArr[i];
                File file = new File(PluginDirHelper.getPluginSignatureFile(this.mContext, packageInfo.packageName, i2));
                try {
                    Utils.writeToFile(file, signature.toByteArray());
                    i++;
                    i2++;
                } catch (Exception e) {
                    e.printStackTrace();
                    file.delete();
                    Utils.deleteDir(PluginDirHelper.getPluginSignatureDir(this.mContext, packageInfo.packageName));
                    return;
                }
            }
        }
    }

    private void hookPackageManager(PluginPackageParser pluginPackageParser) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Object currentActivityThread = ActivityThreadCompat.currentActivityThread();
        Object readField = FieldUtils.readField(currentActivityThread, "sPackageManager");
        Class<?> cls = Class.forName("android.content.pm.IPackageManager");
        FieldUtils.writeField(currentActivityThread, "sPackageManager", Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new PackageManagerHookHandler(readField, pluginPackageParser)));
    }

    private void preLoadAPK(String str, ApplicationInfo applicationInfo) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        String str2;
        DexClassLoader dexClassLoader;
        synchronized (sPluginLoadedApkCache) {
            Object currentActivityThread = ActivityThreadCompat.currentActivityThread();
            if (currentActivityThread != null) {
                Object readField = FieldUtils.readField(currentActivityThread, "mPackages");
                Map map = (Map) FieldUtils.getField(ActivityThreadCompat.activityThreadClass(), "mPackages").get(currentActivityThread);
                Map map2 = (Map) FieldUtils.getField(ActivityThreadCompat.activityThreadClass(), "mResourcePackages").get(currentActivityThread);
                Object invokeMethod = MethodUtils.invokeMethod(readField, "containsKey", str);
                if ((invokeMethod instanceof Boolean) && !((Boolean) invokeMethod).booleanValue()) {
                    Object invokeMethod2 = MethodUtils.invokeMethod(currentActivityThread, "getPackageInfoNoCheck", applicationInfo, CompatibilityInfoCompat.getDefaultCompatibilityInfo());
                    sPluginLoadedApkCache.put(str, invokeMethod2);
                    String pluginDalvikCacheDir = PluginDirHelper.getPluginDalvikCacheDir(this.mContext, str);
                    String pluginNativeLibraryDir = PluginDirHelper.getPluginNativeLibraryDir(this.mContext, str);
                    String str3 = applicationInfo.publicSourceDir;
                    if (TextUtils.isEmpty(str3)) {
                        applicationInfo.publicSourceDir = PluginDirHelper.getPluginApkFile(this.mContext, str);
                        str2 = applicationInfo.publicSourceDir;
                    } else {
                        str2 = str3;
                    }
                    if (str2 != null) {
                        try {
                            dexClassLoader = new DexClassLoader(str2, pluginDalvikCacheDir, pluginNativeLibraryDir, this.mContext.getClassLoader().getParent());
                        } catch (Exception e) {
                            Log.i("andrew", "load classloader exeception!!!!");
                            dexClassLoader = null;
                        }
                        if (dexClassLoader == null) {
                            PluginDirHelper.cleanOptimizedDirectory(pluginDalvikCacheDir);
                            dexClassLoader = new DexClassLoader(str2, pluginDalvikCacheDir, pluginNativeLibraryDir, this.mContext.getClassLoader().getParent());
                        }
                        synchronized (invokeMethod2) {
                            FieldUtils.writeDeclaredField(invokeMethod2, "mClassLoader", dexClassLoader);
                        }
                        sPluginClassLoaderCache.put(str, dexClassLoader);
                        WeakReference weakReference = new WeakReference(invokeMethod2);
                        map.put(applicationInfo.packageName, weakReference);
                        map2.put(applicationInfo.packageName, weakReference);
                    }
                }
            }
        }
    }

    public int installPackage(String str, boolean z) {
        String pluginApkFile;
        try {
            if (!z) {
                PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 0);
                if (packageArchiveInfo == null) {
                    return -2;
                }
                if (this.mPluginCache.containsKey(packageArchiveInfo.packageName)) {
                    return -1;
                }
                pluginApkFile = PluginDirHelper.getPluginApkFile(this.mContext, packageArchiveInfo.packageName);
            } else if (this.mPluginCache.containsKey("com.google.ar.core")) {
                return -1;
            } else {
                pluginApkFile = PluginDirHelper.getPluginApkFile(this.mContext, "com.google.ar.core");
            }
            if (!new File(pluginApkFile).exists()) {
                Utils.copyFile(str, pluginApkFile, z, this.mContext);
            }
            PluginPackageParser pluginPackageParser = new PluginPackageParser(this.mContext, new File(pluginApkFile));
            ApplicationInfo applicationInfo = pluginPackageParser.getApplicationInfo(0);
            if (copyNativeLibs(this.mContext, pluginApkFile, applicationInfo) < 0) {
                new File(pluginApkFile).delete();
                return -3;
            }
            preLoadAPK(pluginPackageParser.getPackageName(), applicationInfo);
            hookPackageManager(pluginPackageParser);
            this.mPluginCache.put(pluginPackageParser.getPackageName(), pluginPackageParser);
            return 1;
        } catch (Exception e) {
            if (0 != 0) {
                new File((String) null).delete();
            }
            e.printStackTrace();
            return -110;
        }
    }
}
