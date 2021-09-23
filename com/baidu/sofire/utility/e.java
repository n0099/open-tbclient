package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sofire.utility.l;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f45535a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1443542456, "Lcom/baidu/sofire/utility/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1443542456, "Lcom/baidu/sofire/utility/e;");
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            try {
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                String l = a2.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                String e2 = c.e(l);
                if (TextUtils.isEmpty(e2) || e2.equals(a2.k())) {
                    return;
                }
                a2.b(e2);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public static synchronized String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (e.class) {
                try {
                    if (!TextUtils.isEmpty(f45535a)) {
                        return f45535a;
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    String l = a2.l();
                    if (!TextUtils.isEmpty(l)) {
                        String e2 = c.e(l);
                        if (!TextUtils.isEmpty(e2)) {
                            f45535a = e2;
                            return e2;
                        }
                    }
                    String k = a2.k();
                    if (!TextUtils.isEmpty(k)) {
                        a2.c(new String(Base64.encode(h.a("30212102dicudiab".getBytes(), k.getBytes("UTF-8"), true), 10), "UTF-8"));
                        f45535a = k;
                        return k;
                    }
                    String g2 = g(context);
                    String h2 = u.h(context);
                    if (TextUtils.isEmpty(h2)) {
                        h2 = "0";
                    }
                    String str = g2 + "|" + new StringBuffer(h2).reverse().toString();
                    String str2 = new String(Base64.encode(h.a("30212102dicudiab".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8");
                    String k2 = a2.k();
                    if (TextUtils.isEmpty(k2)) {
                        a2.b(str);
                        a2.c(str2);
                        f45535a = str;
                        return str;
                    }
                    f45535a = k2;
                    return k2;
                } catch (Throwable unused) {
                    c.a();
                    return "";
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                String string = a2.f45430c.getString("sgud", "");
                if (TextUtils.isEmpty(string)) {
                    if (Build.VERSION.SDK_INT > 25) {
                        return "";
                    }
                    String h2 = u.h(context);
                    String i2 = u.i(context);
                    if (TextUtils.isEmpty(h2) && TextUtils.isEmpty(i2)) {
                        return "";
                    }
                    byte[] bytes = (h2 + ":" + i2).getBytes();
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        bytes[i3] = (byte) (bytes[i3] ^ 246);
                    }
                    String a3 = q.a(bytes);
                    if (TextUtils.isEmpty(a3)) {
                        return "";
                    }
                    a2.f45431d.putString("sgud", a3);
                    a2.f45431d.commit();
                    return a3;
                }
                return string;
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b A[Catch: all -> 0x0095, TryCatch #2 {all -> 0x0095, blocks: (B:5:0x0006, B:13:0x0027, B:15:0x003b, B:18:0x0066, B:21:0x0072, B:12:0x0024), top: B:33:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[Catch: all -> 0x0095, TryCatch #2 {all -> 0x0095, blocks: (B:5:0x0006, B:13:0x0027, B:15:0x003b, B:18:0x0066, B:21:0x0072, B:12:0x0024), top: B:33:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        InterceptResult invokeL;
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                String i2 = u.i(context);
                try {
                    str = Settings.System.getString(context.getContentResolver(), c.e("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                } catch (Throwable unused) {
                    str = "";
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        str = u.h(context);
                    }
                } catch (Throwable unused2) {
                    c.a();
                    string = Settings.System.getString(context.getContentResolver(), c.e("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                    if (TextUtils.isEmpty(string)) {
                    }
                    if (string != null) {
                    }
                }
                string = Settings.System.getString(context.getContentResolver(), c.e("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                if (TextUtils.isEmpty(string)) {
                    string = Settings.System.getString(context.getContentResolver(), a((c.e("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + str + i2).getBytes()));
                }
                if (string != null) {
                    return "";
                }
                String h2 = u.h(context);
                if (TextUtils.isEmpty(h2)) {
                    h2 = "0";
                }
                String stringBuffer = new StringBuffer(h2).reverse().toString();
                return string + "|" + stringBuffer;
            } catch (Throwable unused3) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                try {
                    String string = u.b(context) ? Settings.System.getString(context.getContentResolver(), c.e("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug=")) : "";
                    if (TextUtils.isEmpty(string)) {
                        string = u.h(context);
                    }
                    String h2 = u.h(context);
                    if (TextUtils.isEmpty(h2)) {
                        h2 = "0";
                    }
                    String stringBuffer = new StringBuffer(h2).reverse().toString();
                    String a2 = a(context, string);
                    if (!TextUtils.isEmpty(a2)) {
                        return a2 + "|" + stringBuffer;
                    }
                } catch (Throwable unused) {
                    c.a();
                    return "";
                }
            } catch (Exception unused2) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                    return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
                }
                return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
            } catch (Exception unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            String str2 = "";
            try {
                str = u.h(context);
                try {
                    str2 = u.i(context);
                } catch (Throwable unused) {
                    c.a();
                    String uuid = UUID.randomUUID().toString();
                    return a((str + str2 + uuid).getBytes());
                }
            } catch (Throwable unused2) {
                str = "";
            }
            String uuid2 = UUID.randomUUID().toString();
            return a((str + str2 + uuid2).getBytes());
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
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
                c.a();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.MANUFACTURER : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && u.c(context)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(externalStorageDirectory, c.e("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + c.e("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="))));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(Part.CRLF);
                    }
                    bufferedReader.close();
                    Object[] split = new String(l.a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
                    return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
                } catch (Exception unused) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Build.VERSION.SDK_INT > 7 ? Build.HARDWARE : "" : (String) invokeV.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Build.DISPLAY : (String) invokeV.objValue;
    }
}
