package com.baidu.ar.plugin.helper;

import android.annotation.TargetApi;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.ar.plugin.reflect.MethodUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes9.dex */
public class NativeLibraryHelperCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NativeLibraryHelperCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final int copyNativeBinaries(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, file2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return copyNativeBinariesAfterL(file, file2);
            }
            return copyNativeBinariesBeforeL(file, file2);
        }
        return invokeLL.intValue;
    }

    @TargetApi(21)
    public static int copyNativeBinariesAfterL(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, file2)) == null) {
            try {
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(handleClass(), "create", file);
                if (invokeStaticMethod == null) {
                    return -1;
                }
                String str = null;
                if (isVM64() && Build.SUPPORTED_64_BIT_ABIS.length > 0) {
                    Set<String> abisFromApk = getAbisFromApk(file.getAbsolutePath());
                    if (abisFromApk != null && !abisFromApk.isEmpty()) {
                        int intValue = ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "findSupportedAbi", invokeStaticMethod, Build.SUPPORTED_64_BIT_ABIS)).intValue();
                        if (intValue >= 0) {
                            str = Build.SUPPORTED_64_BIT_ABIS[intValue];
                        }
                    }
                    return 0;
                }
                if (str == null && Build.SUPPORTED_32_BIT_ABIS.length > 0) {
                    Set<String> abisFromApk2 = getAbisFromApk(file.getAbsolutePath());
                    if (abisFromApk2 != null && !abisFromApk2.isEmpty()) {
                        int intValue2 = ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "findSupportedAbi", invokeStaticMethod, Build.SUPPORTED_32_BIT_ABIS)).intValue();
                        if (intValue2 >= 0) {
                            str = Build.SUPPORTED_32_BIT_ABIS[intValue2];
                        }
                    }
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                return ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "copyNativeBinaries", invokeStaticMethod, file2, str)).intValue();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return -1;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return -1;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return -1;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public static int copyNativeBinariesBeforeL(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, file2)) == null) {
            try {
                return ((Integer) MethodUtils.invokeStaticMethod(nativeLibraryHelperClass(), "copyNativeBinariesIfNeededLI", file, file2)).intValue();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return -1;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return -1;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return -1;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public static Set<String> getAbisFromApk(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(str).entries();
                HashSet hashSet = new HashSet();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (!name.contains(Constants.PATH_PARENT) && name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextElement.isDirectory() && name.endsWith(".so")) {
                        hashSet.add(name.substring(name.indexOf("/") + 1, name.lastIndexOf("/")));
                    }
                }
                return hashSet;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static final Class handleClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? Class.forName("com.android.internal.content.NativeLibraryHelper$Handle") : (Class) invokeV.objValue;
    }

    @TargetApi(21)
    public static boolean isVM64() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Build.SUPPORTED_64_BIT_ABIS.length == 0) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final Class nativeLibraryHelperClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Class.forName("com.android.internal.content.NativeLibraryHelper") : (Class) invokeV.objValue;
    }
}
