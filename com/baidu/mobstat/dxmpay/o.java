package com.baidu.mobstat.dxmpay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ConectivityUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
/* loaded from: classes7.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Proxy f41587a;

    /* renamed from: b  reason: collision with root package name */
    public static final Proxy f41588b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1455169475, "Lcom/baidu/mobstat/dxmpay/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1455169475, "Lcom/baidu/mobstat/dxmpay/o;");
                return;
            }
        }
        f41587a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));
        f41588b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80));
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
            t.a(new ByteArrayInputStream(str2.getBytes("utf-8")), fileOutputStream);
        } catch (Exception unused) {
            t.a(fileOutputStream);
        } catch (Throwable th) {
            t.a(fileOutputStream);
            throw th;
        }
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) ? context.deleteFile(str) : invokeLL.booleanValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? context.getFileStreamPath(str).exists() : invokeLL.booleanValue;
    }

    public static HttpURLConnection d(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? a(context, str, 50000, 50000) : (HttpURLConnection) invokeLL.objValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            boolean z = false;
            try {
                if (context.checkCallingOrSelfPermission(str) == 0) {
                    z = true;
                }
            } catch (Exception unused) {
            }
            if (!z) {
                h c2 = h.c();
                c2.b("[WARNING] not have permission " + str + ", please add it in AndroidManifest.xml according our developer doc");
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = context.openFileInput(str);
                byte[] a2 = a(fileInputStream);
                if (a2 != null) {
                    String str2 = new String(a2, "utf-8");
                    t.a(fileInputStream);
                    return str2;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                t.a(fileInputStream);
                throw th;
            }
            t.a(fileInputStream);
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (t.a(inputStream, byteArrayOutputStream)) {
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
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, context, str, i2, i3)) == null) {
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
                            httpURLConnection = (HttpURLConnection) url.openConnection(f41588b);
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(f41587a);
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
