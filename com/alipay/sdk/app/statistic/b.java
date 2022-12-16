package com.alipay.sdk.app.statistic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.l;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "H5PayNetworkError";
    public static final String A0 = "TbCancel";
    public static final String B = "H5AuthNetworkError";
    public static final String B0 = "TbUnknown";
    public static final String C = "SSLError";
    public static final String C0 = "TbOk";
    public static final String D = "SSLProceed";
    public static final String D0 = "TbActFail";
    public static final String E = "SSLDenied";
    public static final String E0 = "tid_context_null";
    public static final String F = "H5PayDataAnalysisError";
    public static final String F0 = "partner";
    public static final String G = "H5AuthDataAnalysisError";
    public static final String G0 = "out_trade_no";
    public static final String H = "PublicKeyUnmatch";
    public static final String H0 = "trade_no";
    public static final String I = "ClientBindFailed";
    public static final String I0 = "biz_content";
    public static final String J = "TriDesEncryptError";
    public static final String J0 = "app_id";
    public static final String K = "TriDesDecryptError";
    public static final String L = "ClientBindException";
    public static final String M = "SaveTradeTokenError";
    public static final String N = "ClientBindServiceFailed";
    public static final String O = "TryStartServiceEx";
    public static final String P = "BindWaitTimeoutEx";
    public static final String Q = "CheckClientExistEx";
    public static final String R = "CheckClientSignEx";
    public static final String S = "GetInstalledAppEx";
    public static final String T = "ParserTidClientKeyEx";
    public static final String U = "PgApiInvoke";
    public static final String V = "PgBindStarting";
    public static final String W = "PgBinded";
    public static final String X = "PgBindEnd";
    public static final String Y = "PgBindPay";
    public static final String Z = "PgReturn";
    public static final String a0 = "PgReturnV";
    public static final String b0 = "PgWltVer";
    public static final String c0 = "PgOpenStarting";
    public static final String d0 = "ErrIntentEx";
    public static final String e0 = "ErrActNull";
    public static final String f0 = "ErrActNull";
    public static final String g0 = "GetInstalledAppEx";
    public static final String h0 = "StartLaunchAppTransEx";
    public static final String i0 = "CheckLaunchAppExistEx";
    public static final String j0 = "LogCurrentAppLaunchSwitch";
    public static final String k = "net";
    public static final String k0 = "LogCurrentQueryTime";
    public static final String l = "biz";
    public static final String l0 = "LogCalledPackage";
    public static final String m = "cp";
    public static final String m0 = "LogBindCalledH5";
    public static final String n = "auth";
    public static final String n0 = "LogCalledH5";
    public static final String o = "third";
    public static final String o0 = "LogHkLoginByIntent";
    public static final String p = "tid";
    public static final String p0 = "SchemePayWrongHashEx";
    public static final String q = "wlt";
    public static final String q0 = "LogAppLaunchSwitchEnabled";
    public static final String r = "FormatResultEx";
    public static final String r0 = "H5CbUrlEmpty";
    public static final String s = "GetApdidEx";
    public static final String s0 = "H5CbEx";
    public static final String t = "GetApdidNull";
    public static final String t0 = "BuildSchemePayUriError";
    public static final String u = "GetApdidTimeout";
    public static final String u0 = "StartActivityEx";
    public static final String v = "GetUtdidEx";
    public static final String v0 = "JSONEx";
    public static final String w = "GetPackageInfoEx";
    public static final String w0 = "ParseBundleSerializableError";
    public static final String x = "NotIncludeSignatures";
    public static final String x0 = "ParseSchemeQueryError";
    public static final String y = "GetInstalledPackagesEx";
    public static final String y0 = "TbChk";
    public static final String z = "GetPublicKeyFromSignEx";
    public static final String z0 = "TbStart";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public b(Context context, boolean z2) {
        long a;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = "";
        this.i = "";
        context = context != null ? context.getApplicationContext() : context;
        this.a = b();
        this.c = a(context);
        if (z2) {
            a = 0;
        } else {
            a = a.c.a(context);
        }
        this.d = a(a);
        this.e = a();
        this.f = b(context);
        this.g = "-";
        this.j = "-";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return String.format("%s,%s,-,-,-", c(com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.d().b()).d()), c(com.alipay.sdk.sys.b.d().c()));
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return String.format("%s,%s", e(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
        }
        return (String) invokeV.objValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            String c = c("15.8.02");
            String c2 = c("h.a.3.8.02");
            return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", c, c2, Constants.WAVE_SEPARATOR + j);
        }
        return (String) invokeJ.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        String packageName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String str = "-";
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    packageName = applicationContext.getPackageName();
                    try {
                        PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 64);
                        str = packageInfo.versionName + "|" + a(packageInfo);
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                }
                return String.format("%s,%s,-,-,-", c(packageName), c(str));
            }
            packageName = "-";
            return String.format("%s,%s,-,-,-", c(packageName), c(str));
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str.replace(PreferencesUtil.LEFT_MOUNT, "【").replace(PreferencesUtil.RIGHT_MOUNT, "】").replace("(", "（").replace(SmallTailInfo.EMOTION_SUFFIX, "）").replace(",", "，").replace("^", Constants.WAVE_SEPARATOR).replace("#", "＃");
        }
        return (String) invokeL.objValue;
    }

    public static String a(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        String str;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, packageInfo)) == null) {
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(packageInfo.signatures.length);
                    for (Signature signature : packageInfo.signatures) {
                        try {
                            a = l.a((com.alipay.sdk.sys.a) null, signature.toByteArray());
                        } catch (Throwable unused) {
                        }
                        if (TextUtils.isEmpty(a)) {
                            str = "?";
                            sb.append("-");
                            sb.append(str);
                        } else {
                            str = l.e(a).substring(0, 8);
                            sb.append("-");
                            sb.append(str);
                        }
                    }
                    return sb.toString();
                } catch (Throwable unused2) {
                    return "?";
                }
            }
            return "0";
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", c(com.alipay.sdk.util.a.c(context)), "android", c(Build.VERSION.RELEASE), c(Build.MODEL), "-", c(com.alipay.sdk.util.a.b(context).c()), c(com.alipay.sdk.util.a.d(context).b()), "gw", c(com.alipay.sdk.util.a.b(context).b()));
        }
        return (String) invokeL.objValue;
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(th.getClass().getName());
                stringBuffer.append(":");
                stringBuffer.append(th.getMessage());
                stringBuffer.append(" 》 ");
                StackTraceElement[] stackTrace = th.getStackTrace();
                if (stackTrace != null) {
                    int i = 0;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        stringBuffer.append(stackTraceElement.toString());
                        stringBuffer.append(" 》 ");
                        i++;
                        if (i > 5) {
                            break;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null) {
                str = "";
            }
            String[] split = str.split("&");
            String str4 = null;
            if (split != null) {
                str2 = null;
                str3 = null;
                for (String str5 : split) {
                    String[] split2 = str5.split("=");
                    if (split2 != null && split2.length == 2) {
                        if (split2[0].equalsIgnoreCase(F0)) {
                            str4 = split2[1].replace("\"", "");
                        } else if (split2[0].equalsIgnoreCase(G0)) {
                            str2 = split2[1].replace("\"", "");
                        } else if (split2[0].equalsIgnoreCase(H0)) {
                            str3 = split2[1].replace("\"", "");
                        } else if (split2[0].equalsIgnoreCase(I0)) {
                            try {
                                JSONObject jSONObject = new JSONObject(l.e(com.alipay.sdk.sys.a.e(), split2[1]));
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = jSONObject.getString(G0);
                                }
                            } catch (Throwable unused) {
                            }
                        } else if (split2[0].equalsIgnoreCase("app_id") && TextUtils.isEmpty(str4)) {
                            str4 = split2[1];
                        }
                    }
                }
            } else {
                str2 = null;
                str3 = null;
            }
            return String.format("%s,%s,-,%s,-,-,-", c(str3), c(str2), c(str4));
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
        }
        return (String) invokeV.objValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            return TextUtils.isEmpty(this.i);
        }
        return invokeV.booleanValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                return UUID.randomUUID().toString();
            } catch (Throwable unused) {
                return "12345678uuid";
            }
        }
        return (String) invokeV.objValue;
    }

    private synchronized void c(String str, String str2, String str3) {
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, str, str2, str3) == null) {
            synchronized (this) {
                c.d(com.alipay.sdk.cons.a.x, String.format("event %s %s %s", str, str2, str3));
                String str4 = "";
                if (!TextUtils.isEmpty(this.h)) {
                    str4 = "^";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                Object[] objArr = new Object[4];
                if (TextUtils.isEmpty(str)) {
                    c = "-";
                } else {
                    c = c(str);
                }
                objArr[0] = c;
                objArr[1] = c(str2);
                objArr[2] = c(str3);
                objArr[3] = c(c());
                sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
                this.h += sb.toString();
            }
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "-";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private synchronized void d(String str, String str2, String str3) {
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, this, str, str2, str3) == null) {
            synchronized (this) {
                c.c(com.alipay.sdk.cons.a.x, String.format("err %s %s %s", str, str2, str3));
                String str4 = "";
                if (!TextUtils.isEmpty(this.i)) {
                    str4 = "^";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = str2;
                if (TextUtils.isEmpty(str3)) {
                    c = "-";
                } else {
                    c = c(str3);
                }
                objArr[2] = c;
                objArr[3] = c(c());
                sb.append(String.format("%s,%s,%s,%s", objArr));
                this.i += sb.toString();
            }
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String b = b(str);
            this.b = b;
            return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.a, b, this.c, this.d, this.e, this.f, this.g, d(this.h), d(this.i), this.j);
        }
        return (String) invokeL.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            c("", str, str2);
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            c("", str, str2 + "|" + str3);
        }
    }

    public void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            d(str, str2, str3);
        }
    }

    public void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, th) == null) {
            d(str, str2, a(th));
        }
    }

    public void a(String str, String str2, Throwable th, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, th, str3) == null) {
            String a = a(th);
            d(str, str2, str3 + ": " + a);
        }
    }
}
