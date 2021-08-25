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
import com.alipay.sdk.util.k;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "TriDesDecryptError";
    public static final String B = "ClientBindException";
    public static final String C = "SaveTradeTokenError";
    public static final String D = "ClientBindServiceFailed";
    public static final String E = "TryStartServiceEx";
    public static final String F = "BindWaitTimeoutEx";
    public static final String G = "CheckClientExistEx";
    public static final String H = "CheckClientSignEx";
    public static final String I = "GetInstalledAppEx";
    public static final String J = "ParserTidClientKeyEx";
    public static final String K = "PgApiInvoke";
    public static final String L = "PgBindStarting";
    public static final String M = "PgBinded";
    public static final String N = "PgBindEnd";
    public static final String O = "PgBindPay";
    public static final String P = "PgReturn";
    public static final String Q = "PgReturnV";
    public static final String R = "PgWltVer";
    public static final String S = "PgOpenStarting";
    public static final String T = "ErrIntentEx";
    public static final String U = "ErrActNull";
    public static final String V = "ErrActNull";
    public static final String W = "GetInstalledAppEx";
    public static final String X = "StartLaunchAppTransEx";
    public static final String Y = "CheckLaunchAppExistEx";
    public static final String Z = "LogCurrentAppLaunchSwitch";

    /* renamed from: a  reason: collision with root package name */
    public static final String f35804a = "net";
    public static final String aa = "LogCurrentQueryTime";
    public static final String ab = "LogCalledPackage";
    public static final String ac = "LogBindCalledH5";
    public static final String ad = "LogCalledH5";
    public static final String ae = "LogHkLoginByIntent";
    public static final String af = "SchemePayWrongHashEx";
    public static final String ag = "LogAppLaunchSwitchEnabled";
    public static final String ah = "H5CbUrlEmpty";
    public static final String ai = "H5CbEx";
    public static final String aj = "BuildSchemePayUriError";
    public static final String ak = "StartActivityEx";
    public static final String al = "JSONEx";
    public static final String am = "ParseBundleSerializableError";
    public static final String an = "ParseSchemeQueryError";
    public static final String ao = "tid_context_null";
    public static final String ap = "partner";
    public static final String aq = "out_trade_no";
    public static final String ar = "trade_no";
    public static final String as = "biz_content";
    public static final String at = "app_id";

    /* renamed from: b  reason: collision with root package name */
    public static final String f35805b = "biz";

    /* renamed from: c  reason: collision with root package name */
    public static final String f35806c = "cp";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35807d = "auth";

    /* renamed from: e  reason: collision with root package name */
    public static final String f35808e = "third";

    /* renamed from: f  reason: collision with root package name */
    public static final String f35809f = "tid";

    /* renamed from: g  reason: collision with root package name */
    public static final String f35810g = "wlt";

    /* renamed from: h  reason: collision with root package name */
    public static final String f35811h = "FormatResultEx";

    /* renamed from: i  reason: collision with root package name */
    public static final String f35812i = "GetApdidEx";

    /* renamed from: j  reason: collision with root package name */
    public static final String f35813j = "GetApdidNull";
    public static final String k = "GetApdidTimeout";
    public static final String l = "GetUtdidEx";
    public static final String m = "GetPackageInfoEx";
    public static final String n = "NotIncludeSignatures";
    public static final String o = "GetInstalledPackagesEx";
    public static final String p = "GetPublicKeyFromSignEx";
    public static final String q = "H5PayNetworkError";
    public static final String r = "H5AuthNetworkError";
    public static final String s = "SSLError";
    public static final String t = "SSLProceed";
    public static final String u = "SSLDenied";
    public static final String v = "H5PayDataAnalysisError";
    public static final String w = "H5AuthDataAnalysisError";
    public static final String x = "PublicKeyUnmatch";
    public static final String y = "ClientBindFailed";
    public static final String z = "TriDesEncryptError";
    public transient /* synthetic */ FieldHolder $fh;
    public String aA;
    public String aB;
    public String aC;
    public String aD;
    public String au;
    public String av;
    public String aw;
    public String ax;
    public String ay;
    public String az;

    public b(Context context, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.aB = "";
        this.aC = "";
        context = context != null ? context.getApplicationContext() : context;
        this.au = c();
        this.aw = a(context);
        this.ax = a(z2 ? 0L : a.c.a(context));
        this.ay = e();
        this.az = b(context);
        this.aA = "-";
        this.aD = "-";
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? TextUtils.isEmpty(this.aC) : invokeV.booleanValue;
    }

    private synchronized void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, this, str, str2, str3) == null) {
            synchronized (this) {
                c.d(com.alipay.sdk.cons.a.x, String.format("err %s %s %s", str, str2, str3));
                String str4 = "";
                if (!TextUtils.isEmpty(this.aC)) {
                    str4 = "" + PayTypeItemView.PayTypeItemViewData.MASK_FLAG;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = TextUtils.isEmpty(str3) ? "-" : b(str3);
                objArr[3] = b(b());
                sb.append(String.format("%s,%s,%s,%s", objArr));
                this.aC += sb.toString();
            }
        }
    }

    private synchronized void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, this, str, str2, str3) == null) {
            synchronized (this) {
                c.b(com.alipay.sdk.cons.a.x, String.format("event %s %s %s", str, str2, str3));
                String str4 = "";
                if (!TextUtils.isEmpty(this.aB)) {
                    str4 = "" + PayTypeItemView.PayTypeItemViewData.MASK_FLAG;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                Object[] objArr = new Object[4];
                objArr[0] = TextUtils.isEmpty(str) ? "-" : b(str);
                objArr[1] = b(str2);
                objArr[2] = b(str3);
                objArr[3] = b(b());
                sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
                this.aB += sb.toString();
            }
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? String.format("%s,%s,-,-,-", b(com.alipay.sdk.tid.a.a(com.alipay.sdk.sys.b.a().b()).a()), b(com.alipay.sdk.sys.b.a().e())) : (String) invokeV.objValue;
    }

    public void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            d("", str, str2 + "|" + str3);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date()) : (String) invokeV.objValue;
    }

    public void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, th) == null) {
            c(str, str2, a(th));
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : str.replace(PreferencesUtil.LEFT_MOUNT, "【").replace(PreferencesUtil.RIGHT_MOUNT, "】").replace("(", "（").replace(SmallTailInfo.EMOTION_SUFFIX, "）").replace(",", "，").replace(PayTypeItemView.PayTypeItemViewData.MASK_FLAG, Constants.WAVE_SEPARATOR).replace("#", "＃") : (String) invokeL.objValue;
    }

    public void a(String str, String str2, Throwable th, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, str2, th, str3) == null) {
            String a2 = a(th);
            c(str, str2, str3 + ": " + a2);
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            c(str, str2, str3);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            d("", str, str2);
        }
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
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
                    int i2 = 0;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        stringBuffer.append(stackTraceElement.toString());
                        stringBuffer.append(" 》 ");
                        i2++;
                        if (i2 > 5) {
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

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? TextUtils.isEmpty(str) ? "-" : str : (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", b(com.alipay.sdk.util.a.d(context)), "android", b(Build.VERSION.RELEASE), b(Build.MODEL), "-", b(com.alipay.sdk.util.a.a(context).a()), b(com.alipay.sdk.util.a.b(context).b()), "gw", b(com.alipay.sdk.util.a.a(context).b())) : (String) invokeL.objValue;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? String.format("%s,%s", d(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date())) : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                return UUID.randomUUID().toString();
            } catch (Throwable unused) {
                return "12345678uuid";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str == null) {
                str = "";
            }
            String[] split = str.split("&");
            String str4 = null;
            if (split != null) {
                str3 = null;
                String str5 = null;
                for (String str6 : split) {
                    String[] split2 = str6.split("=");
                    if (split2 != null && split2.length == 2) {
                        if (split2[0].equalsIgnoreCase(ap)) {
                            str4 = split2[1].replace("\"", "");
                        } else if (split2[0].equalsIgnoreCase(aq)) {
                            str3 = split2[1].replace("\"", "");
                        } else if (split2[0].equalsIgnoreCase(ar)) {
                            str5 = split2[1].replace("\"", "");
                        } else if (split2[0].equalsIgnoreCase(as)) {
                            try {
                                JSONObject jSONObject = new JSONObject(k.b(com.alipay.sdk.sys.a.a(), split2[1]));
                                if (TextUtils.isEmpty(str3)) {
                                    str3 = jSONObject.getString(aq);
                                }
                            } catch (Throwable unused) {
                            }
                        } else if (split2[0].equalsIgnoreCase("app_id") && TextUtils.isEmpty(str4)) {
                            str4 = split2[1];
                        }
                    }
                }
                str2 = str4;
                str4 = str5;
            } else {
                str2 = null;
                str3 = null;
            }
            return String.format("%s,%s,-,%s,-,-,-", b(str4), b(str3), b(str2));
        }
        return (String) invokeL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String d2 = d(str);
            this.av = d2;
            return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.au, d2, this.aw, this.ax, this.ay, this.az, this.aA, c(this.aB), c(this.aC), this.aD);
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str3 = "-";
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    str = applicationContext.getPackageName();
                    try {
                        PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(str, 64);
                        str3 = packageInfo.versionName + "|" + a(packageInfo);
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str = "-";
                }
                str2 = str3;
                str3 = str;
            } else {
                str2 = "-";
            }
            return String.format("%s,%s,-,-,-", b(str3), b(str2));
        }
        return (String) invokeL.objValue;
    }

    public static String a(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        String str;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, packageInfo)) == null) {
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
                return "0";
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.signatures.length);
                for (Signature signature : packageInfo.signatures) {
                    try {
                        a2 = k.a((com.alipay.sdk.sys.a) null, signature.toByteArray());
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(a2)) {
                        str = "?";
                        sb.append("-");
                        sb.append(str);
                    } else {
                        str = k.f(a2).substring(0, 8);
                        sb.append("-");
                        sb.append(str);
                    }
                }
                return sb.toString();
            } catch (Throwable unused2) {
                return "?";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
            String b2 = b("15.7.7");
            String b3 = b("h.a.3.7.7");
            return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", b2, b3, Constants.WAVE_SEPARATOR + j2);
        }
        return (String) invokeJ.objValue;
    }
}
