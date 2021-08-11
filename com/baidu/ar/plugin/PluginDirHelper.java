package com.baidu.ar.plugin;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PluginDirHelper {
    public static /* synthetic */ Interceptable $ic;
    public static File sBaseDir;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1946160575, "Lcom/baidu/ar/plugin/PluginDirHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1946160575, "Lcom/baidu/ar/plugin/PluginDirHelper;");
        }
    }

    public PluginDirHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void cleanOptimizedDirectory(String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            try {
                File file = new File(str);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                }
                if (file.exists() && file.isFile()) {
                    file.delete();
                    file.mkdirs();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String enforceDirExists(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return (String) invokeL.objValue;
    }

    public static String getBaseDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            init(context);
            return enforceDirExists(sBaseDir);
        }
        return (String) invokeL.objValue;
    }

    public static String getContextDataDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? new File(new File(Environment.getDataDirectory(), "data/").getPath(), context.getPackageName()).getPath() : (String) invokeL.objValue;
    }

    public static String getPluginApkDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? enforceDirExists(new File(makePluginBaseDir(context, str), "apk")) : (String) invokeLL.objValue;
    }

    public static String getPluginApkFile(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? new File(getPluginApkDir(context, str), "base-1.apk").getPath() : (String) invokeLL.objValue;
    }

    public static String getPluginDalvikCacheDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? enforceDirExists(new File(makePluginBaseDir(context, str), "dalvik-cache")) : (String) invokeLL.objValue;
    }

    public static String getPluginDalvikCacheFile(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            String pluginDalvikCacheDir = getPluginDalvikCacheDir(context, str);
            String replace = new File(getPluginApkFile(context, str)).getName().replace(File.separator, TNCManager.TNC_PROBE_HEADER_SECEPTOR);
            if (replace.startsWith(TNCManager.TNC_PROBE_HEADER_SECEPTOR)) {
                replace = replace.substring(1);
            }
            return new File(pluginDalvikCacheDir, replace + "@classes.dex").getPath();
        }
        return (String) invokeLL.objValue;
    }

    public static String getPluginDataDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            String makePluginBaseDir = makePluginBaseDir(context, str);
            return enforceDirExists(new File(makePluginBaseDir, "data/" + str));
        }
        return (String) invokeLL.objValue;
    }

    public static String getPluginNativeLibraryDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) ? enforceDirExists(new File(makePluginBaseDir(context, str), "lib")) : (String) invokeLL.objValue;
    }

    public static String getPluginSignatureDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) ? enforceDirExists(new File(makePluginBaseDir(context, str), "Signature/")) : (String) invokeLL.objValue;
    }

    public static String getPluginSignatureFile(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65549, null, context, str, i2)) == null) ? new File(getPluginSignatureDir(context, str), String.format("Signature_%s.key", Integer.valueOf(i2))).getPath() : (String) invokeLLI.objValue;
    }

    public static List<String> getPluginSignatureFiles(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = new File(getPluginSignatureDir(context, str)).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    arrayList.add(file.getPath());
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, context) == null) && sBaseDir == null) {
            File file = new File(context.getCacheDir().getParentFile(), "Plugin");
            sBaseDir = file;
            enforceDirExists(file);
        }
    }

    public static String makePluginBaseDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
            init(context);
            return enforceDirExists(new File(sBaseDir, str));
        }
        return (String) invokeLL.objValue;
    }
}
