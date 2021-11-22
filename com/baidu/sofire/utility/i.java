package com.baidu.sofire.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.android.internal.http.multipart.Part;
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
/* loaded from: classes7.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f44122a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f44123b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443542332, "Lcom/baidu/sofire/utility/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443542332, "Lcom/baidu/sofire/utility/i;");
                return;
            }
        }
        f44122a = new String[]{"java.lang.UnsatisfiedLinkError"};
        f44123b = new String[]{"space left"};
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        char c2;
        ApkInfo d2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            try {
                if (str.contains(f44122a[0])) {
                    c2 = 1;
                } else {
                    c2 = str.contains(f44123b[0]) ? (char) 2 : (char) 0;
                }
                if (c2 != 1) {
                    return c2 != 2 ? str : a(context, str);
                }
                String str3 = str + "\r\n{libpath=" + d2.libPath + "}";
                for (String str4 : com.baidu.sofire.core.f.a().d(str2).libPath.split(":")) {
                    if (str4.startsWith("/data/data/")) {
                        File file = new File(str4);
                        if (!file.exists()) {
                            str3 = str3 + "\r\nsubLibPathFile " + str4 + " not exists";
                        } else if (file.isDirectory()) {
                            for (File file2 : file.listFiles()) {
                                str3 = str3 + "\r\n{" + file2.getAbsolutePath() + ":" + q.a(file2) + "}\r\n";
                            }
                        } else {
                            str3 = str3 + "\r\nsubLibPathFile " + str4 + " not a dir";
                        }
                    }
                }
                return str3;
            } catch (Throwable unused) {
                c.a();
                return str;
            }
        }
        return (String) invokeLLL.objValue;
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
                return ((str2 + Part.CRLF) + jSONArray.toString()) + "\r\nAllFileSize=" + j;
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static long a(File file, JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        File[] listFiles;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, jSONArray)) == null) {
            long j = 0;
            if (file != null && jSONArray != null && file.isDirectory()) {
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
            }
            return j;
        }
        return invokeLL.longValue;
    }
}
