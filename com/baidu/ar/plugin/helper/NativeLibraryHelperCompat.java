package com.baidu.ar.plugin.helper;

import android.annotation.TargetApi;
import android.os.Build;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.ar.plugin.reflect.MethodUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class NativeLibraryHelperCompat {
    private static final Class nativeLibraryHelperClass() throws ClassNotFoundException {
        return Class.forName("com.android.internal.content.NativeLibraryHelper");
    }

    private static final Class handleClass() throws ClassNotFoundException {
        return Class.forName("com.android.internal.content.NativeLibraryHelper$Handle");
    }

    public static final int copyNativeBinaries(File file, File file2) {
        return Build.VERSION.SDK_INT >= 21 ? copyNativeBinariesAfterL(file, file2) : copyNativeBinariesBeforeL(file, file2);
    }

    private static int copyNativeBinariesBeforeL(File file, File file2) {
        try {
            return ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "copyNativeBinariesIfNeededLI", file, file2)).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return -1;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return -1;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096 A[Catch: NoSuchMethodException -> 0x00b5, IllegalAccessException -> 0x00bc, InvocationTargetException -> 0x00c1, ClassNotFoundException -> 0x00c6, TRY_LEAVE, TryCatch #2 {ClassNotFoundException -> 0x00c6, IllegalAccessException -> 0x00bc, NoSuchMethodException -> 0x00b5, InvocationTargetException -> 0x00c1, blocks: (B:3:0x0002, B:7:0x0017, B:9:0x001e, B:11:0x0023, B:13:0x002d, B:16:0x0035, B:18:0x0053, B:20:0x0059, B:22:0x005e, B:24:0x0068, B:27:0x0070, B:29:0x008e, B:32:0x0096), top: B:44:0x0002 }] */
    @TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int copyNativeBinariesAfterL(File file, File file2) {
        String str;
        try {
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(handleClass(), "create", file);
            if (invokeStaticMethod == null) {
                return -1;
            }
            String str2 = null;
            if (isVM64() && Build.SUPPORTED_64_BIT_ABIS.length > 0) {
                Set<String> abisFromApk = getAbisFromApk(file.getAbsolutePath());
                if (abisFromApk == null || abisFromApk.isEmpty()) {
                    return 0;
                }
                int intValue = ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "findSupportedAbi", invokeStaticMethod, Build.SUPPORTED_64_BIT_ABIS)).intValue();
                if (intValue >= 0) {
                    str2 = Build.SUPPORTED_64_BIT_ABIS[intValue];
                }
            }
            if (str2 == null && Build.SUPPORTED_32_BIT_ABIS.length > 0) {
                Set<String> abisFromApk2 = getAbisFromApk(file.getAbsolutePath());
                if (abisFromApk2 == null || abisFromApk2.isEmpty()) {
                    return 0;
                }
                int intValue2 = ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "findSupportedAbi", invokeStaticMethod, Build.SUPPORTED_32_BIT_ABIS)).intValue();
                if (intValue2 >= 0) {
                    str = Build.SUPPORTED_32_BIT_ABIS[intValue2];
                    if (str != null) {
                        return -1;
                    }
                    return ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "copyNativeBinaries", invokeStaticMethod, file2, str)).intValue();
                }
            }
            str = str2;
            if (str != null) {
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return -1;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return -1;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    @TargetApi(21)
    private static boolean isVM64() {
        if (Build.SUPPORTED_64_BIT_ABIS.length == 0) {
        }
        return false;
    }

    private static Set<String> getAbisFromApk(String str) {
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(str).entries();
            HashSet hashSet = new HashSet();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (!name.contains(Constants.PATH_PARENT) && name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextElement.isDirectory() && name.endsWith(PluginInstallerService.APK_LIB_SUFFIX)) {
                    hashSet.add(name.substring(name.indexOf("/") + 1, name.lastIndexOf("/")));
                }
            }
            return hashSet;
        } catch (Exception e) {
            return null;
        }
    }
}
