package com.baidu.sofire.k;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074258923, "Lcom/baidu/sofire/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074258923, "Lcom/baidu/sofire/k/c;");
                return;
            }
        }
        b = new Object();
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (!TextUtils.isEmpty(a)) {
                    return a;
                }
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String d = a2.d();
                if (!TextUtils.isEmpty(d)) {
                    String b2 = a.b(d);
                    if (!TextUtils.isEmpty(b2)) {
                        a = b2;
                        return b2;
                    }
                }
                String a3 = a2.a();
                if (!TextUtils.isEmpty(a3)) {
                    a2.d.putString("xyusec", new String(Base64.encode(e.b("30212102dicudiab".getBytes(), a3.getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.d.commit();
                    a = a3;
                    return a3;
                } else if (TextUtils.isEmpty(a)) {
                    UUID.randomUUID();
                    synchronized (b) {
                        if (TextUtils.isEmpty(a)) {
                            String str = a(UUID.randomUUID().toString().getBytes(), true) + "|0";
                            a = str;
                            if (TextUtils.isEmpty(str)) {
                                return a;
                            }
                            String str2 = new String(Base64.encode(e.b("30212102dicudiab".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8");
                            String a4 = a2.a();
                            if (TextUtils.isEmpty(a4)) {
                                a2.d.putString("xyus", str);
                                a2.d.commit();
                                a2.d.putString("xyusec", str2);
                                a2.d.commit();
                                return a;
                            }
                            a = a4;
                            return a4;
                        }
                        return a;
                    }
                } else {
                    return a;
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || !m.b(context)) {
                return "";
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(externalStorageDirectory, a.b("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + a.b("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="))));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\r\n");
                }
                bufferedReader.close();
                Object[] split = new String(com.baidu.sofire.a.a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
                if (split == null || split.length != 2 || !str.equals(split[0])) {
                    return "";
                }
                return split[1];
            } catch (Exception unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (z) {
                        hexString = hexString.toUpperCase();
                    }
                    if (hexString.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(hexString);
                    sb.append("");
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                try {
                    if (!m.c(context)) {
                        str = "";
                    } else {
                        str = ApiReplaceUtil.getString(context.getContentResolver(), a.b("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = m.h(context);
                    }
                    String h = m.h(context);
                    if (TextUtils.isEmpty(h)) {
                        h = "0";
                    }
                    String stringBuffer = new StringBuffer(h).reverse().toString();
                    String a2 = a(context, str);
                    if (TextUtils.isEmpty(a2)) {
                        return "";
                    }
                    return a2 + "|" + stringBuffer;
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                    return "";
                }
            } catch (Exception unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[Catch: all -> 0x0096, TryCatch #2 {all -> 0x0096, blocks: (B:5:0x0006, B:13:0x0026, B:15:0x003a, B:18:0x0067, B:21:0x0073, B:12:0x0024), top: B:33:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067 A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #2 {all -> 0x0096, blocks: (B:5:0x0006, B:13:0x0026, B:15:0x003a, B:18:0x0067, B:21:0x0073, B:12:0x0024), top: B:33:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        InterceptResult invokeL;
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                String f = m.f(context);
                try {
                    str = ApiReplaceUtil.getString(context.getContentResolver(), a.b("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                } catch (Throwable unused) {
                    str = "";
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        str = m.h(context);
                    }
                } catch (Throwable unused2) {
                    int i = com.baidu.sofire.a.b.a;
                    string = ApiReplaceUtil.getString(context.getContentResolver(), a.b("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                    if (TextUtils.isEmpty(string)) {
                    }
                    if (string != null) {
                    }
                }
                string = ApiReplaceUtil.getString(context.getContentResolver(), a.b("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                if (TextUtils.isEmpty(string)) {
                    string = ApiReplaceUtil.getString(context.getContentResolver(), a((a.b("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + str + f).getBytes(), true));
                }
                if (string != null) {
                    return "";
                }
                String h = m.h(context);
                if (TextUtils.isEmpty(h)) {
                    h = "0";
                }
                String stringBuffer = new StringBuffer(h).reverse().toString();
                return string + "|" + stringBuffer;
            } catch (Throwable unused3) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(Context context) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            try {
                com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                String d = a2.d();
                if (TextUtils.isEmpty(d)) {
                    return;
                }
                String b2 = a.b(d);
                if (!TextUtils.isEmpty(b2) && (split = b2.split(WebChromeClient.PARAM_SEPARATOR)) != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && !split[1].equals("0")) {
                    String str = split[0] + "|0";
                    a2.d.putString("xyusec", new String(Base64.encode(e.b("30212102dicudiab".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
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
