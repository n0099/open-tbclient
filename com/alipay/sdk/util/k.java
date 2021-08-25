package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.data.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35989a = "com.eg.android.AlipayGphone";

    /* renamed from: b  reason: collision with root package name */
    public static final int f35990b = 125;

    /* renamed from: c  reason: collision with root package name */
    public static final String f35991c = "com.alipay.android.app";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35992d = "com.eg.android.AlipayGphoneRC";

    /* renamed from: e  reason: collision with root package name */
    public static final int f35993e = 99;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f35994f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1255003101, "Lcom/alipay/sdk/util/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1255003101, "Lcom/alipay/sdk/util/k;");
                return;
            }
        }
        f35994f = new String[]{"10.1.5.1013151", "10.1.5.1013148"};
    }

    public k() {
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (EnvUtils.isSandBox()) {
                return f35992d;
            }
            try {
                return com.alipay.sdk.app.a.f35782a.get(0).f35857a;
            } catch (Throwable unused) {
                return f35989a;
            }
        }
        return (String) invokeV.objValue;
    }

    public static Map<String, String> b(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("&")) {
                int indexOf = str2.indexOf("=", 1);
                if (-1 != indexOf) {
                    hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            try {
                return new JSONObject(str);
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) ? context.getResources().getConfiguration().locale.toString() : (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            DisplayMetrics i2 = i(context);
            return i2.widthPixels + "*" + i2.heightPixels;
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION), 256);
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
                if (matcher.matches() && matcher.groupCount() >= 4) {
                    return matcher.group(1) + StringUtils.LF + matcher.group(2) + " " + matcher.group(3) + StringUtils.LF + matcher.group(4);
                }
                return "Unavailable";
            } catch (IOException unused) {
                return "Unavailable";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) ? "-1;-1" : (String) invokeL.objValue;
    }

    public static ActivityInfo h(Context context) {
        InterceptResult invokeL;
        ActivityInfo[] activityInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            try {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                        if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                            return activityInfo;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                c.a(th);
                return null;
            }
        }
        return (ActivityInfo) invokeL.objValue;
    }

    public static DisplayMetrics i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? (EnvUtils.isSandBox() && TextUtils.equals(str, f35992d)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay" : (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            String b2 = b();
            String c2 = c();
            String d2 = d(context);
            String e2 = e(context);
            return " (" + b2 + ";" + c2 + ";" + d2 + ";;" + e2 + SmallTailInfo.EMOTION_SUFFIX + "(sdk android)";
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> a(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, aVar, str)) == null) {
            HashMap hashMap = new HashMap(4);
            int indexOf = str.indexOf(63);
            if (indexOf != -1 && indexOf < str.length() - 1) {
                for (String str2 : str.substring(indexOf + 1).split("&")) {
                    int indexOf2 = str2.indexOf(61, 1);
                    if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                        hashMap.put(str2.substring(0, indexOf2), b(aVar, str2.substring(indexOf2 + 1)));
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) ? Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches() : invokeL.booleanValue;
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final PackageInfo f35996a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35997b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35998c;

        public a(PackageInfo packageInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {packageInfo, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35996a = packageInfo;
            this.f35997b = i2;
            this.f35998c = str;
        }

        public boolean a(com.alipay.sdk.sys.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                Signature[] signatureArr = this.f35996a.signatures;
                if (signatureArr == null || signatureArr.length == 0) {
                    return false;
                }
                for (Signature signature : signatureArr) {
                    String a2 = k.a(aVar, signature.toByteArray());
                    if (a2 != null && !TextUtils.equals(a2, this.f35998c)) {
                        com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.x, String.format("Got %s, expected %s", a2, this.f35998c));
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35996a.versionCode < this.f35997b : invokeV.booleanValue;
        }
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            try {
                Uri parse = Uri.parse(str);
                return String.format("%s%s", parse.getAuthority(), parse.getPath());
            } catch (Throwable th) {
                c.a(th);
                return "-";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, aVar, str)) == null) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.v, e2);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                return Process.myUid();
            } catch (Throwable th) {
                c.a(th);
                return -200;
            }
        }
        return invokeV.intValue;
    }

    public static PackageInfo b(Context context, String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) ? context.getPackageManager().getPackageInfo(str, 192) : (PackageInfo) invokeLL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            String f2 = f();
            int indexOf = f2.indexOf("-");
            if (indexOf != -1) {
                f2 = f2.substring(0, indexOf);
            }
            int indexOf2 = f2.indexOf(StringUtils.LF);
            if (indexOf2 != -1) {
                f2 = f2.substring(0, indexOf2);
            }
            return "Linux " + f2;
        }
        return (String) invokeV.objValue;
    }

    public static boolean b(com.alipay.sdk.sys.a aVar, Context context, List<a.C1563a> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, aVar, context, list)) == null) {
            try {
                for (a.C1563a c1563a : list) {
                    if (c1563a != null) {
                        String str = c1563a.f35857a;
                        if (EnvUtils.isSandBox() && f35989a.equals(str)) {
                            str = f35992d;
                        }
                        try {
                            if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                                return true;
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                            continue;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.Y, th);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                String[] split = com.alipay.sdk.data.a.p().j().split("\\|");
                String str = Build.MODEL;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                for (String str2 : split) {
                    if (TextUtils.equals(str, str2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                c.a(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            String a2 = j.a(context);
            return a2.substring(0, a2.indexOf("://"));
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, str, str2, str3)) == null) {
            try {
                int indexOf = str3.indexOf(str) + str.length();
                if (indexOf <= str.length()) {
                    return "";
                }
                int indexOf2 = TextUtils.isEmpty(str2) ? 0 : str3.indexOf(str2, indexOf);
                if (indexOf2 < 1) {
                    return str3.substring(indexOf);
                }
                return str3.substring(indexOf, indexOf2);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String c(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, aVar, str)) == null) {
            try {
                return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            } catch (Exception e2) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "rflex", e2.getClass().getSimpleName());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a(), 128);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode < 99;
            } catch (Throwable th) {
                c.a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar, byte[] bArr) {
        BigInteger modulus;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, aVar, bArr)) == null) {
            try {
                PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
                if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                    return null;
                }
                return modulus.toString(16);
            } catch (Exception e2) {
                com.alipay.sdk.app.statistic.a.a(aVar, "auth", com.alipay.sdk.app.statistic.b.p, e2);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return "Android " + Build.VERSION.RELEASE;
        }
        return (String) invokeV.objValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) ? i2 / 100000 : invokeI.intValue;
    }

    public static a a(com.alipay.sdk.sys.a aVar, Context context, List<a.C1563a> list) {
        InterceptResult invokeLLL;
        a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, context, list)) == null) {
            if (list == null) {
                return null;
            }
            for (a.C1563a c1563a : list) {
                if (c1563a != null && (a2 = a(aVar, context, c1563a.f35857a, c1563a.f35858b, c1563a.f35859c)) != null && !a2.a(aVar) && !a2.a()) {
                    return a2;
                }
            }
            return null;
        }
        return (a) invokeLLL.objValue;
    }

    public static a a(com.alipay.sdk.sys.a aVar, Context context, String str, int i2, String str2) {
        InterceptResult invokeCommon;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{aVar, context, str, Integer.valueOf(i2), str2})) == null) {
            if (EnvUtils.isSandBox() && f35989a.equals(str)) {
                str = f35992d;
            }
            try {
                packageInfo = b(context, str);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "auth", com.alipay.sdk.app.statistic.b.m, th.getMessage());
                packageInfo = null;
            }
            if (a(aVar, packageInfo)) {
                return a(packageInfo, i2, str2);
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, PackageInfo packageInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, aVar, packageInfo)) == null) {
            String str = "";
            boolean z = false;
            if (packageInfo == null) {
                str = "info == null";
            } else {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null) {
                    str = "info.signatures == null";
                } else if (signatureArr.length <= 0) {
                    str = "info.signatures.length <= 0";
                } else {
                    z = true;
                }
            }
            if (!z) {
                com.alipay.sdk.app.statistic.a.a(aVar, "auth", com.alipay.sdk.app.statistic.b.n, str);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static a a(PackageInfo packageInfo, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, packageInfo, i2, str)) == null) {
            if (packageInfo == null) {
                return null;
            }
            return new a(packageInfo, i2, str);
        }
        return (a) invokeLIL.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(f35991c, 128) != null;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, packageInfo)) == null) {
            if (packageInfo == null) {
                return false;
            }
            try {
                String str = packageInfo.versionName;
                if (!TextUtils.equals(str, f35994f[0])) {
                    if (!TextUtils.equals(str, f35994f[1])) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < i2; i3++) {
                int nextInt = random.nextInt(3);
                if (nextInt == 0) {
                    sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
                } else if (nextInt == 1) {
                    sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
                } else if (nextInt == 2) {
                    sb.append(String.valueOf(new Random().nextInt(10)));
                }
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            String str2 = "";
            try {
                String str3 = "";
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.equals(str)) {
                        str3 = str3 + "#M";
                    } else {
                        if (runningAppProcessInfo.processName.startsWith(str + ":")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append("#");
                            sb.append(runningAppProcessInfo.processName.replace(str + ":", ""));
                            str3 = sb.toString();
                        }
                    }
                }
                str2 = str3;
            } catch (Throwable unused) {
            }
            if (str2.length() > 0) {
                str2 = str2.substring(1);
            }
            return str2.length() == 0 ? "N" : str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, String str, Activity activity) {
        InterceptResult invokeLLL;
        int parseInt;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, aVar, str, activity)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (activity == null) {
                return false;
            }
            if (!str.toLowerCase().startsWith(com.alipay.sdk.cons.a.l.toLowerCase()) && !str.toLowerCase().startsWith(com.alipay.sdk.cons.a.m.toLowerCase())) {
                if (!TextUtils.equals(str, com.alipay.sdk.cons.a.o) && !TextUtils.equals(str, com.alipay.sdk.cons.a.p)) {
                    if (str.startsWith(com.alipay.sdk.cons.a.n)) {
                        try {
                            String substring2 = str.substring(str.indexOf(com.alipay.sdk.cons.a.n) + 24);
                            parseInt = Integer.parseInt(substring2.substring(substring2.lastIndexOf(com.alipay.sdk.cons.a.q) + 10));
                        } catch (Exception unused) {
                            com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.e());
                        }
                        if (parseInt != com.alipay.sdk.app.c.f35788a.a() && parseInt != com.alipay.sdk.app.c.f35794g.a()) {
                            com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.f35789b.a());
                            com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a(b2.a(), b2.b(), ""));
                            activity.runOnUiThread(new Runnable(activity) { // from class: com.alipay.sdk.util.k.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ Activity f35995a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {activity};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f35995a = activity;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.f35995a.finish();
                                    }
                                }
                            });
                            return true;
                        }
                        if (com.alipay.sdk.cons.a.u) {
                            StringBuilder sb = new StringBuilder();
                            String decode = URLDecoder.decode(str);
                            String decode2 = URLDecoder.decode(decode);
                            String str2 = decode2.substring(decode2.indexOf(com.alipay.sdk.cons.a.n) + 24, decode2.lastIndexOf(com.alipay.sdk.cons.a.q)).split(com.alipay.sdk.cons.a.s)[0];
                            int indexOf = decode.indexOf(com.alipay.sdk.cons.a.s) + 12;
                            sb.append(str2);
                            sb.append(com.alipay.sdk.cons.a.s);
                            sb.append(decode.substring(indexOf, decode.indexOf("&", indexOf)));
                            sb.append(decode.substring(decode.indexOf("&", indexOf)));
                            substring = sb.toString();
                        } else {
                            String decode3 = URLDecoder.decode(str);
                            substring = decode3.substring(decode3.indexOf(com.alipay.sdk.cons.a.n) + 24, decode3.lastIndexOf(com.alipay.sdk.cons.a.q));
                        }
                        com.alipay.sdk.app.c b3 = com.alipay.sdk.app.c.b(parseInt);
                        com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a(b3.a(), b3.b(), substring));
                        activity.runOnUiThread(new Runnable(activity) { // from class: com.alipay.sdk.util.k.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Activity f35995a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = objArr;
                                    Object[] objArr = {activity};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f35995a = activity;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f35995a.finish();
                                }
                            }
                        });
                        return true;
                    }
                    return false;
                }
                com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.c());
                activity.finish();
                return true;
            }
            try {
                a a2 = a(aVar, activity, com.alipay.sdk.app.a.f35782a);
                if (a2 != null && !a2.a() && !a2.a(aVar)) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.cons.a.l);
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused2) {
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, aVar, context)) == null) ? a(aVar, context, context.getPackageName()) : (String) invokeLL.objValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar, Context context, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, aVar, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 128).versionName;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.m, th);
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b2 : bArr) {
                sb.append(Character.forDigit((b2 & 240) >> 4, 16));
                sb.append(Character.forDigit(b2 & 15, 16));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) ? c(aVar, RomUtils.PROP_RO_BUILD_FINGERPRINT) : (String) invokeL.objValue;
    }
}
