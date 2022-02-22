package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.data.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
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
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
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
/* loaded from: classes10.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.alipay.android.app";

    /* renamed from: b  reason: collision with root package name */
    public static final String f31183b = "com.eg.android.AlipayGphone";

    /* renamed from: c  reason: collision with root package name */
    public static final String f31184c = "com.eg.android.AlipayGphoneRC";

    /* renamed from: d  reason: collision with root package name */
    public static final int f31185d = 99;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f31186e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f31187f = 125;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public a(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1255003132, "Lcom/alipay/sdk/util/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1255003132, "Lcom/alipay/sdk/util/l;");
                return;
            }
        }
        f31186e = new String[]{"10.1.5.1013151", "10.1.5.1013148"};
    }

    public l() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (EnvUtils.isSandBox()) {
                return f31184c;
            }
            try {
                return com.alipay.sdk.app.a.f31021d.get(0).a;
            } catch (Throwable unused) {
                return f31183b;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? "-1;-1" : (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) ? (EnvUtils.isSandBox() && TextUtils.equals(str, f31184c)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay" : (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
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

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            String c2 = c();
            int indexOf = c2.indexOf("-");
            if (indexOf != -1) {
                c2 = c2.substring(0, indexOf);
            }
            int indexOf2 = c2.indexOf(StringUtils.LF);
            if (indexOf2 != -1) {
                c2 = c2.substring(0, indexOf2);
            }
            return "Linux " + c2;
        }
        return (String) invokeV.objValue;
    }

    public static String e(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, aVar, str)) == null) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.F, e2);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static JSONObject f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            try {
                return new JSONObject(str);
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            String e2 = e();
            String d2 = d();
            String c2 = c(context);
            String f2 = f(context);
            return " (" + e2 + ";" + d2 + ";" + c2 + ";;" + f2 + SmallTailInfo.EMOTION_SUFFIX + "(sdk android)";
        }
        return (String) invokeL.objValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
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

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(a, 128) != null;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Map<String, String> b(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, aVar, str)) == null) {
            HashMap hashMap = new HashMap(4);
            int indexOf = str.indexOf(63);
            if (indexOf != -1 && indexOf < str.length() - 1) {
                for (String str2 : str.substring(indexOf + 1).split("&")) {
                    int indexOf2 = str2.indexOf(61, 1);
                    if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                        hashMap.put(str2.substring(0, indexOf2), e(aVar, str2.substring(indexOf2 + 1)));
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static Map<String, String> a(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
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

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return "Android " + Build.VERSION.RELEASE;
        }
        return (String) invokeV.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            DisplayMetrics d2 = d(context);
            return d2.widthPixels + "*" + d2.heightPixels;
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            String b2 = k.b(context);
            return b2.substring(0, b2.indexOf("://"));
        }
        return (String) invokeL.objValue;
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PackageInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31188b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31189c;

        public b(PackageInfo packageInfo, int i2, String str) {
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
            this.a = packageInfo;
            this.f31188b = i2;
            this.f31189c = str;
        }

        public boolean a(com.alipay.sdk.sys.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                Signature[] signatureArr = this.a.signatures;
                if (signatureArr == null || signatureArr.length == 0) {
                    return false;
                }
                for (Signature signature : signatureArr) {
                    String a = l.a(aVar, signature.toByteArray());
                    if (a != null && !TextUtils.equals(a, this.f31189c)) {
                        com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.H, String.format("Got %s, expected %s", a, this.f31189c));
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.versionCode < this.f31188b : invokeV.booleanValue;
        }
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) ? a(str, true) : (String) invokeL.objValue;
    }

    public static DisplayMetrics d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            try {
                return Process.myUid();
            } catch (Throwable th) {
                c.a(th);
                return DeepLinkCode.ERROR_LINK_NOT_MATCH;
            }
        }
        return invokeV.intValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
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

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, str, str2, str3)) == null) {
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

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? context.getResources().getConfiguration().locale.toString() : (String) invokeL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) ? Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches() : invokeL.booleanValue;
    }

    public static PackageInfo b(Context context, String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, str)) == null) ? context.getPackageManager().getPackageInfo(str, 192) : (PackageInfo) invokeLL.objValue;
    }

    public static boolean d(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, aVar, str)) == null) {
            try {
                int c2 = c(str);
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "bindExt", "" + c2);
                return com.alipay.sdk.data.a.u().n() && (c2 & 2) == 2;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            try {
                String[] split = com.alipay.sdk.data.a.u().f().split("\\|");
                String str = Build.MODEL;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                for (String str2 : split) {
                    if (TextUtils.equals(str, str2) || TextUtils.equals(str2, "all")) {
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

    public static boolean b(com.alipay.sdk.sys.a aVar, Context context, List<a.b> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, aVar, context, list)) == null) {
            try {
                for (a.b bVar : list) {
                    if (bVar != null) {
                        String str = bVar.a;
                        if (EnvUtils.isSandBox() && f31183b.equals(str)) {
                            str = f31184c;
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
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.i0, th);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String c(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, aVar, str)) == null) {
            try {
                return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            } catch (Exception e2) {
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "rflex", e2.getClass().getSimpleName());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar, byte[] bArr) {
        BigInteger modulus;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, aVar, bArr)) == null) {
            try {
                PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
                if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                    return null;
                }
                return modulus.toString(16);
            } catch (Exception e2) {
                com.alipay.sdk.app.statistic.a.a(aVar, "auth", com.alipay.sdk.app.statistic.b.z, e2);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            try {
                String i2 = com.alipay.sdk.data.a.u().i();
                if (TextUtils.isEmpty(i2)) {
                    return 0;
                }
                return (a(i2, "").contains(str) ? 2 : 0) | 1;
            } catch (Throwable unused) {
                return 61440;
            }
        }
        return invokeL.intValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i2)) == null) ? i2 / 100000 : invokeI.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                String lowerCase = Build.BRAND.toLowerCase();
                String lowerCase2 = Build.MANUFACTURER.toLowerCase();
                if (a(RomUtils.MANUFACTURER_HUAWEI, lowerCase, lowerCase2)) {
                    return 1;
                }
                if (a(RomUtils.MANUFACTURER_OPPO, lowerCase, lowerCase2)) {
                    return 2;
                }
                if (a(RomUtils.MANUFACTURER_VIVO, lowerCase, lowerCase2)) {
                    return 4;
                }
                if (a("lenovo", lowerCase, lowerCase2)) {
                    return 8;
                }
                if (a(RomUtils.MANUFACTURER_XIAOMI, lowerCase, lowerCase2)) {
                    return 16;
                }
                return a("oneplus", lowerCase, lowerCase2) ? 32 : 0;
            } catch (Exception unused) {
                return 61440;
            }
        }
        return invokeV.intValue;
    }

    public static b a(com.alipay.sdk.sys.a aVar, Context context, List<a.b> list) {
        InterceptResult invokeLLL;
        b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, aVar, context, list)) == null) {
            if (list == null) {
                return null;
            }
            for (a.b bVar : list) {
                if (bVar != null && (a2 = a(aVar, context, bVar.a, bVar.f31082b, bVar.f31083c)) != null && !a2.a(aVar) && !a2.a()) {
                    return a2;
                }
            }
            return null;
        }
        return (b) invokeLLL.objValue;
    }

    public static b a(com.alipay.sdk.sys.a aVar, Context context, String str, int i2, String str2) {
        InterceptResult invokeCommon;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{aVar, context, str, Integer.valueOf(i2), str2})) == null) {
            if (EnvUtils.isSandBox() && f31183b.equals(str)) {
                str = f31184c;
            }
            try {
                packageInfo = b(context, str);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.b(aVar, "auth", com.alipay.sdk.app.statistic.b.w, th.getMessage());
                packageInfo = null;
            }
            if (a(aVar, packageInfo)) {
                return a(packageInfo, i2, str2);
            }
            return null;
        }
        return (b) invokeCommon.objValue;
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, PackageInfo packageInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, aVar, packageInfo)) == null) {
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
                com.alipay.sdk.app.statistic.a.b(aVar, "auth", com.alipay.sdk.app.statistic.b.x, str);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static b a(PackageInfo packageInfo, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, packageInfo, i2, str)) == null) {
            if (packageInfo == null) {
                return null;
            }
            return new b(packageInfo, i2, str);
        }
        return (b) invokeLIL.objValue;
    }

    public static boolean a(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, packageInfo)) == null) {
            if (packageInfo == null) {
                return false;
            }
            try {
                String str = packageInfo.versionName;
                if (!TextUtils.equals(str, f31186e[0])) {
                    if (!TextUtils.equals(str, f31186e[1])) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, aVar, str, activity)) == null) {
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
                        if (parseInt != com.alipay.sdk.app.c.f31023c.b() && parseInt != com.alipay.sdk.app.c.f31029i.b()) {
                            com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.f31024d.b());
                            com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a(b2.b(), b2.a(), ""));
                            activity.runOnUiThread(new a(activity));
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
                        com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a(b3.b(), b3.a(), substring));
                        activity.runOnUiThread(new a(activity));
                        return true;
                    }
                    return false;
                }
                com.alipay.sdk.app.b.a(com.alipay.sdk.app.b.a());
                activity.finish();
                return true;
            }
            try {
                b a2 = a(aVar, activity, com.alipay.sdk.app.a.f31021d);
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, aVar, context)) == null) ? a(aVar, context, context.getPackageName()) : (String) invokeLL.objValue;
    }

    public static String a(com.alipay.sdk.sys.a aVar, Context context, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, aVar, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 128).versionName;
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.w, th);
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65552, null, str, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                if (z && digest.length > 16) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(digest, 0, bArr, 0, 16);
                    return a(bArr);
                }
                return a(digest);
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b2 : bArr) {
                sb.append(Character.forDigit((b2 & 240) >> 4, 16));
                sb.append(Character.forDigit(b2 & 15, 16));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static ActivityInfo a(Context context) {
        InterceptResult invokeL;
        ActivityInfo[] activityInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
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

    public static String a(com.alipay.sdk.sys.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aVar)) == null) ? c(aVar, RomUtils.PROP_RO_BUILD_FINGERPRINT) : (String) invokeL.objValue;
    }

    public static <T> T a(WeakReference<T> weakReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, weakReference)) == null) {
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (T) invokeL.objValue;
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, aVar, str)) == null) {
            try {
                String host = new URL(str).getHost();
                if (host.endsWith(com.alipay.sdk.cons.a.y)) {
                    return true;
                }
                return host.endsWith(com.alipay.sdk.cons.a.z);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "ckUrlErr", th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject a(Intent intent) {
        InterceptResult invokeL;
        Bundle extras;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, intent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (intent != null && (extras = intent.getExtras()) != null) {
                for (String str : extras.keySet()) {
                    try {
                        jSONObject.put(str, String.valueOf(extras.get(str)));
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean a(Object obj, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, obj, objArr)) == null) {
            if (objArr == null || objArr.length == 0) {
                return obj == null;
            }
            for (Object obj2 : objArr) {
                if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            String string = Settings.Secure.getString(((Application) com.alipay.sdk.sys.b.d().b()).getContentResolver(), str);
            return string != null ? string : str2;
        }
        return (String) invokeLL.objValue;
    }
}
