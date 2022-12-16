package com.baidu.sofire.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259016, "Lcom/baidu/sofire/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259016, "Lcom/baidu/sofire/k/f;");
                return;
            }
        }
        a = new String[]{"java.lang.UnsatisfiedLinkError"};
        b = new String[]{"space left"};
    }

    public static long a(File file, JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        File[] listFiles;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, jSONArray)) == null) {
            long j = 0;
            if (!file.isDirectory()) {
                return 0L;
            }
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2, jSONArray);
                } else if (file2.exists()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("path", file2.getAbsolutePath());
                    jSONObject.put("size", file2.length());
                    jSONArray.put(jSONObject);
                    length = file2.length();
                }
                j += length;
            }
            return j;
        }
        return invokeLL.longValue;
    }

    @SuppressLint({"NewApi"})
    public static String a(Context context, String str) {
        String str2;
        File[] listFiles;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
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
                        j += a(file, jSONArray);
                    }
                }
                return ((str2 + "\r\n") + jSONArray.toString()) + "\r\nAllFileSize=" + j;
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Context context, String str, String str2) {
        String a2;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            try {
                char c = 0;
                if (str.contains(a[0])) {
                    c = 1;
                } else if (str.contains(b[0])) {
                    c = 2;
                }
                if (c != 1) {
                    if (c == 2) {
                        a2 = a(context, str);
                    } else {
                        return str;
                    }
                } else {
                    a2 = a(str, str2);
                }
                return a2;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return str;
            }
        }
        return (String) invokeLLL.objValue;
    }

    @SuppressLint({"SdCardPath"})
    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        ApkInfo b2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            String str3 = str + "\r\n{libpath=" + b2.libPath + "}";
            for (String str4 : com.baidu.sofire.b.k.f.b(str2).libPath.split(":")) {
                if (str4.startsWith("/data/data/")) {
                    File file = new File(str4);
                    if (!file.exists()) {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                    } else if (!file.isDirectory()) {
                        str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                    } else {
                        for (File file2 : file.listFiles()) {
                            str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + j.a(file2) + "}\r\n";
                        }
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }
}
