package com.baidu.android.pushservice.jni;

import android.content.Context;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class BaiduAppSSOJni {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1227734099, "Lcom/baidu/android/pushservice/jni/BaiduAppSSOJni;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1227734099, "Lcom/baidu/android/pushservice/jni/BaiduAppSSOJni;");
                return;
            }
        }
        try {
            System.loadLibrary("bdpush_V3_6");
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            try {
                byte[] a = a(context, str, Base64.decode(str2.getBytes(), 2));
                if (a == null || a.length <= 0) {
                    return null;
                }
                return new String(a, IMAudioTransRequest.CHARSET);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static byte[] a(Context context, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, bArr)) == null) {
            if (str == null) {
                str = "";
            }
            try {
                byte[] key = getKey(str);
                if (key == null) {
                    return null;
                }
                String str2 = new String(key, IMAudioTransRequest.CHARSET);
                if (str2.length() > 0) {
                    return decryptAESwithKey(str2.substring(16), str2.substring(0, 16), bArr, bArr.length);
                }
                return null;
            } catch (Exception | UnsatisfiedLinkError unused) {
                return null;
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            try {
                return Base64.encodeToString(b(context, str, str2.getBytes()), 2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static byte[] b(Context context, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        byte[] key;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, bArr)) == null) {
            if (str == null) {
                str = "";
            }
            try {
                key = getKey(str);
            } catch (Exception | UnsatisfiedLinkError unused) {
            }
            if (key == null) {
                return null;
            }
            String str2 = new String(key, IMAudioTransRequest.CHARSET);
            if (str2.length() > 0) {
                return encryptAESwithKey(str2.substring(16), str2.substring(0, 16), new String(bArr, IMAudioTransRequest.CHARSET));
            }
            return null;
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static native byte[] decryptAES(byte[] bArr, int i, int i2);

    public static native byte[] decryptAESwithKey(String str, String str2, byte[] bArr, int i);

    public static native String encodeBySha1(byte[] bArr);

    public static native byte[] encryptAES(String str, int i);

    public static native byte[] encryptAESwithKey(String str, String str2, String str3);

    public static native byte[] getKey(String str);

    public static native String getPublicKey(int i);
}
