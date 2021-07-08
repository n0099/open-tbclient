package com.baidu.ar.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.plugin.helper.ActivityThreadCompat;
import com.baidu.ar.plugin.helper.CompatibilityInfoCompat;
import com.baidu.ar.plugin.helper.NativeLibraryHelperCompat;
import com.baidu.ar.plugin.helper.Utils;
import com.baidu.ar.plugin.reflect.FieldUtils;
import com.baidu.ar.plugin.reflect.MethodUtils;
import com.baidu.ar.session.XRSessionAnchor;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class PluginManager {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, ClassLoader> sPluginClassLoaderCache;
    public static Map<String, Object> sPluginLoadedApkCache;
    public static PluginManager sPluginManager;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Map<String, PluginPackageParser> mPluginCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1586423469, "Lcom/baidu/ar/plugin/PluginManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1586423469, "Lcom/baidu/ar/plugin/PluginManager;");
                return;
            }
        }
        sPluginClassLoaderCache = new WeakHashMap(1);
        sPluginLoadedApkCache = new WeakHashMap(1);
    }

    public PluginManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPluginCache = Collections.synchronizedMap(new HashMap(1));
        this.mContext = context;
    }

    private int copyNativeLibs(Context context, String str, ApplicationInfo applicationInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, str, applicationInfo)) == null) {
            String pluginNativeLibraryDir = PluginDirHelper.getPluginNativeLibraryDir(context, applicationInfo.packageName);
            if (new File(pluginNativeLibraryDir).list().length > 1) {
                return 1;
            }
            return NativeLibraryHelperCompat.copyNativeBinaries(new File(str), new File(pluginNativeLibraryDir));
        }
        return invokeLLL.intValue;
    }

    public static PluginManager getPluginManagerInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (sPluginManager == null) {
                sPluginManager = new PluginManager(context);
            }
            return sPluginManager;
        }
        return (PluginManager) invokeL.objValue;
    }

    private void hookPackageManager(PluginPackageParser pluginPackageParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, pluginPackageParser) == null) {
            Object currentActivityThread = ActivityThreadCompat.currentActivityThread();
            Object readField = FieldUtils.readField(currentActivityThread, "sPackageManager");
            Class<?> cls = Class.forName("android.content.pm.IPackageManager");
            FieldUtils.writeField(currentActivityThread, "sPackageManager", Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new PackageManagerHookHandler(readField, pluginPackageParser)));
        }
    }

    private void preLoadAPK(String str, ApplicationInfo applicationInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, applicationInfo) == null) {
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
                        String str2 = applicationInfo.publicSourceDir;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = PluginDirHelper.getPluginApkFile(this.mContext, str);
                            applicationInfo.publicSourceDir = str2;
                        }
                        if (str2 != null) {
                            DexClassLoader dexClassLoader = null;
                            try {
                                dexClassLoader = new DexClassLoader(str2, pluginDalvikCacheDir, pluginNativeLibraryDir, this.mContext.getClassLoader().getParent());
                            } catch (Exception unused) {
                                Log.i("andrew", "load classloader exeception!!!!");
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
    }

    private void saveSignatures(PackageInfo packageInfo) {
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, packageInfo) == null) || packageInfo == null || (signatureArr = packageInfo.signatures) == null) {
            return;
        }
        int i2 = 0;
        for (Signature signature : signatureArr) {
            File file = new File(PluginDirHelper.getPluginSignatureFile(this.mContext, packageInfo.packageName, i2));
            try {
                Utils.writeToFile(file, signature.toByteArray());
                i2++;
            } catch (Exception e2) {
                e2.printStackTrace();
                file.delete();
                Utils.deleteDir(PluginDirHelper.getPluginSignatureDir(this.mContext, packageInfo.packageName));
                return;
            }
        }
    }

    public int installPackage(String str, boolean z) {
        InterceptResult invokeLZ;
        String pluginApkFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
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
                } else if (this.mPluginCache.containsKey(XRSessionAnchor.apkinfo)) {
                    return -1;
                } else {
                    pluginApkFile = PluginDirHelper.getPluginApkFile(this.mContext, XRSessionAnchor.apkinfo);
                }
                String str2 = pluginApkFile;
                if (!new File(str2).exists()) {
                    Utils.copyFile(str, str2, z, this.mContext);
                }
                PluginPackageParser pluginPackageParser = new PluginPackageParser(this.mContext, new File(str2));
                ApplicationInfo applicationInfo = pluginPackageParser.getApplicationInfo(0);
                if (copyNativeLibs(this.mContext, str2, applicationInfo) < 0) {
                    new File(str2).delete();
                    return -3;
                }
                preLoadAPK(pluginPackageParser.getPackageName(), applicationInfo);
                hookPackageManager(pluginPackageParser);
                this.mPluginCache.put(pluginPackageParser.getPackageName(), pluginPackageParser);
                return 1;
            } catch (Exception e2) {
                if (0 != 0) {
                    new File((String) null).delete();
                }
                e2.printStackTrace();
                return -110;
            }
        }
        return invokeLZ.intValue;
    }
}
