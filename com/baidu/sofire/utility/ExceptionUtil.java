package com.baidu.sofire.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExceptionUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] CHARACTER_LOAD_LIBRARY_FAIL;
    public static final String[] CHARACTER_NO_SPACE_LEFT;
    public static final int TYPE_LOAD_LIBRARY_FAIL = 1;
    public static final int TYPE_NO_SPACE_LEFT = 2;
    public static final int TYPE_UNKNOWN = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(59312220, "Lcom/baidu/sofire/utility/ExceptionUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(59312220, "Lcom/baidu/sofire/utility/ExceptionUtil;");
                return;
            }
        }
        CHARACTER_LOAD_LIBRARY_FAIL = new String[]{"java.lang.UnsatisfiedLinkError"};
        CHARACTER_NO_SPACE_LEFT = new String[]{"space left"};
    }

    public ExceptionUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @SuppressLint({"SdCardPath"})
    public static String checkLoadLibraryFail(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        ApkInfo apkInfoByPackageName;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            String str3 = str + "\r\n{libpath=" + apkInfoByPackageName.libPath + "}";
            for (String str4 : PluginloaderHub.peekInstance().getApkInfoByPackageName(str2).libPath.split(":")) {
                if (str4.startsWith("/data/data/")) {
                    File file = new File(str4);
                    if (!file.exists()) {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                    } else if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + MD5Util.getMD5(file2) + "}\r\n";
                        }
                    } else {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                    }
                }
            }
            return str3;
        }
        return (String) invokeLLL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String checkSpace(Context context, String str) {
        String str2;
        File[] listFiles;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                File filesDir = context.getFilesDir();
                if (Build.VERSION.SDK_INT >= 9) {
                    long freeSpace = filesDir.getFreeSpace();
                    str2 = ((str + "\r\nFreeSpace=" + freeSpace) + "  TotalSpace=" + filesDir.getTotalSpace()) + "  UsableSpace=" + filesDir.getUsableSpace();
                } else {
                    str2 = str;
                }
                JSONArray jSONArray = new JSONArray();
                long j = 0;
                for (File file : filesDir.listFiles()) {
                    if (file.isDirectory() && file.getName().startsWith(".")) {
                        j += collectFileSize(file, jSONArray);
                    }
                }
                return ((str2 + "\r\n") + jSONArray.toString()) + "\r\nAllFileSize=" + j;
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static long collectFileSize(File file, JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        File[] listFiles;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, jSONArray)) == null) {
            long j = 0;
            if (file != null && jSONArray != null && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        length = collectFileSize(file2, jSONArray);
                    } else if (file2.exists()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("path", file2.getAbsolutePath());
                        jSONObject.put("size", file2.length());
                        jSONArray.put(jSONObject);
                        length = file2.length();
                    }
                    j += length;
                }
            }
            return j;
        }
        return invokeLL.longValue;
    }

    public static String rebuildExceptionReason(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, str2)) == null) {
            try {
                char c = 0;
                if (str.contains(CHARACTER_LOAD_LIBRARY_FAIL[0])) {
                    c = 1;
                } else if (str.contains(CHARACTER_NO_SPACE_LEFT[0])) {
                    c = 2;
                }
                if (c != 1) {
                    return c != 2 ? str : checkSpace(context, str);
                }
                return checkLoadLibraryFail(context, str, str2);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return str;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
