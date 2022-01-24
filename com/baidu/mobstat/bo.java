package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ConectivityUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
/* loaded from: classes10.dex */
public final class bo {
    public static /* synthetic */ Interceptable $ic;
    public static final Proxy a;

    /* renamed from: b  reason: collision with root package name */
    public static final Proxy f36585b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658245, "Lcom/baidu/mobstat/bo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658245, "Lcom/baidu/mobstat/bo;");
                return;
            }
        }
        a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));
        f36585b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Environment.getExternalStorageState();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        File a2 = a(str);
        if (a2 == null || !a2.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(a2);
            try {
                byte[] a3 = a(fileInputStream2);
                if (a3 == null) {
                    bu.a(fileInputStream2);
                    return "";
                }
                String str2 = new String(a3, "utf-8");
                bu.a(fileInputStream2);
                return str2;
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                bu.a(fileInputStream);
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                bu.a(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            File a2 = a(str);
            if (a2 == null || !a2.isFile()) {
                return false;
            }
            return a2.delete();
        }
        return invokeL.booleanValue;
    }

    public static HttpURLConnection d(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) ? a(context, str, 50000, 50000) : (HttpURLConnection) invokeLL.objValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            boolean z = false;
            try {
                if (context.checkCallingOrSelfPermission(str) == 0) {
                    z = true;
                }
            } catch (Exception unused) {
            }
            if (!z) {
                bc c2 = bc.c();
                c2.b("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static File a(String str) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("mounted".equals(a())) {
                try {
                    file = Environment.getExternalStorageDirectory();
                } catch (Exception unused) {
                    file = null;
                }
                if (file == null) {
                    return null;
                }
                return new File(file, str);
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? context.getFileStreamPath(str).exists() : invokeLL.booleanValue;
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
            bu.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream);
        } catch (Exception unused) {
            bu.a(fileOutputStream);
        } catch (Throwable th) {
            bu.a(fileOutputStream);
            throw th;
        }
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) ? context.deleteFile(str) : invokeLL.booleanValue;
    }

    public static void a(String str, String str2, boolean z) {
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, str, str2, z) == null) {
            FileOutputStream fileOutputStream = null;
            try {
                File a2 = a(str);
                if (a2 != null) {
                    if (!a2.exists() && (parentFile = a2.getParentFile()) != null) {
                        parentFile.mkdirs();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(a2, z);
                    try {
                        bu.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream2);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        bu.a(fileOutputStream);
                        throw th;
                    }
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            bu.a(fileOutputStream);
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = context.openFileInput(str);
                byte[] a2 = a(fileInputStream);
                if (a2 != null) {
                    String str2 = new String(a2, "utf-8");
                    bu.a(fileInputStream);
                    return str2;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                bu.a(fileInputStream);
                throw th;
            }
            bu.a(fileInputStream);
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (bu.a(inputStream, byteArrayOutputStream)) {
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static HttpURLConnection a(Context context, String str, int i2, int i3) throws IOException {
        InterceptResult invokeLLII;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i2, i3)) == null) {
            URL url = new URL(str);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 != null && networkInfo2.isAvailable()) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                if (networkInfo != null && networkInfo.isAvailable()) {
                    String extraInfo = networkInfo.getExtraInfo();
                    String lowerCase = extraInfo != null ? extraInfo.toLowerCase() : "";
                    if (!lowerCase.startsWith(ConectivityUtils.APN_CMWAP) && !lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) && !lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                        if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                            httpURLConnection = (HttpURLConnection) url.openConnection(f36585b);
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(a);
                    }
                }
                httpURLConnection = null;
            }
            if (httpURLConnection == null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(i2);
            httpURLConnection.setReadTimeout(i3);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeLLII.objValue;
    }
}
