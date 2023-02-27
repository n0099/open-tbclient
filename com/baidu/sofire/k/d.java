package com.baidu.sofire.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] a;
    public static String b;
    public static Object c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074258954, "Lcom/baidu/sofire/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074258954, "Lcom/baidu/sofire/k/d;");
                return;
            }
        }
        a = f.a(16);
        b = "";
        c = new Object();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bytes = UUID.randomUUID().toString().getBytes();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                    if (upperCase.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(upperCase);
                    sb.append("");
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(b)) {
                    return b;
                }
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String d = a2.d();
                if (!TextUtils.isEmpty(d)) {
                    String c2 = b.c(d);
                    if (!TextUtils.isEmpty(c2)) {
                        b = c2;
                        return c2;
                    }
                }
                String a3 = a2.a();
                if (!TextUtils.isEmpty(a3)) {
                    a2.d.putString("xyusec", new String(Base64.encode(f.b(a, a3.getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.d.commit();
                    b = a3;
                    return a3;
                } else if (TextUtils.isEmpty(b)) {
                    UUID.randomUUID();
                    synchronized (c) {
                        if (TextUtils.isEmpty(b)) {
                            String str = a() + "|0";
                            b = str;
                            if (TextUtils.isEmpty(str)) {
                                return b;
                            }
                            String str2 = new String(Base64.encode(f.b(a, str.getBytes("UTF-8"), true), 10), "UTF-8");
                            String a4 = a2.a();
                            if (TextUtils.isEmpty(a4)) {
                                a2.d.putString("xyus", str);
                                a2.d.commit();
                                a2.d.putString("xyusec", str2);
                                a2.d.commit();
                                return b;
                            }
                            b = a4;
                            return a4;
                        }
                        return b;
                    }
                } else {
                    return b;
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            try {
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String d = a2.d();
                if (TextUtils.isEmpty(d)) {
                    return;
                }
                String c2 = b.c(d);
                if (!TextUtils.isEmpty(c2) && (split = c2.split(WebChromeClient.PARAM_SEPARATOR)) != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && !split[1].equals("0")) {
                    String str = split[0] + "|0";
                    a2.d.putString("xyusec", new String(Base64.encode(f.b(a, str.getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.d.commit();
                    a2.d.putString("xyus", str);
                    a2.d.commit();
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
