package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.kuaishou.weapon.p0.u;
import com.tencent.open.SocialOperation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static Map<String, String> A = null;
    public static String B = null;
    public static Context a = null;
    public static float b = 0.0f;
    public static String c = null;
    public static final String d = "h";
    public static com.baidu.mapsdkplatform.comjni.util.a e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static int k;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(42760346, "Lcom/baidu/mapsdkplatform/comapi/util/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(42760346, "Lcom/baidu/mapsdkplatform/comapi/util/h;");
                return;
            }
        }
        e = new com.baidu.mapsdkplatform.comjni.util.a();
        f = "02";
        r = "baidu";
        s = "";
        t = "";
        u = "";
        x = "-1";
        y = "-1";
        b = 1.0f;
        z = "";
        A = new HashMap();
        B = "";
    }

    public h() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c = null;
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            f();
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return B;
        }
        return (String) invokeV.objValue;
    }

    public static void f() {
        com.baidu.mapsdkplatform.comjni.util.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && (aVar = e) != null) {
            aVar.b();
        }
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return q;
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return h;
        }
        return (String) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return l;
        }
        return invokeV.intValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return j;
        }
        return (String) invokeV.objValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return m;
        }
        return invokeV.intValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return i;
        }
        return (String) invokeV.objValue;
    }

    public static int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return p;
        }
        return invokeV.intValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return r;
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return g;
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return v;
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                str = LBSAuthManager.getInstance(a).getCUID();
            } catch (Exception unused) {
                str = "";
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            q = "0";
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            q = str;
            h();
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            a = context;
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            x = str2;
            y = str;
            h();
        }
    }

    public static byte[] a(Context context) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    SigningInfo signingInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION).signingInfo;
                    if (signingInfo == null) {
                        return null;
                    }
                    if (signingInfo.hasMultipleSigners()) {
                        signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION).signingInfo.getApkContentsSigners();
                    } else {
                        signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION).signingInfo.getSigningCertificateHistory();
                    }
                } else {
                    signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    return signatureArr[0].toByteArray();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            JsonBuilder jsonBuilder = new JsonBuilder();
            jsonBuilder.object();
            jsonBuilder.putStringValue("cpu", s);
            jsonBuilder.putStringValue("resid", f);
            jsonBuilder.putStringValue("channel", r);
            jsonBuilder.putStringValue("glr", t);
            jsonBuilder.putStringValue("glv", u);
            jsonBuilder.putStringValue(FunAdSdk.PLATFORM_MB, i());
            jsonBuilder.putStringValue("sv", k());
            jsonBuilder.putStringValue("os", m());
            jsonBuilder.key("dpi_x").value(n());
            jsonBuilder.key("dpi_y").value(n());
            jsonBuilder.putStringValue("net", q);
            jsonBuilder.putStringValue("cuid", z);
            jsonBuilder.key(SocialOperation.GAME_SIGNATURE).arrayValue();
            byte[] a2 = a(a);
            if (a2 != null) {
                for (byte b2 : a2) {
                    jsonBuilder.value((int) b2);
                }
            }
            jsonBuilder.endArrayValue();
            jsonBuilder.putStringValue(u.w, a.getPackageName());
            jsonBuilder.key("screen_x").value(j());
            jsonBuilder.key("screen_y").value(l());
            jsonBuilder.endObject();
            String json = jsonBuilder.getJson();
            B = json;
            return json;
        }
        return (String) invokeV.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            A.put("net", AppMD5.encodeUrlParamsValue(g()));
            A.put("appid", AppMD5.encodeUrlParamsValue(x));
            A.put("bduid", "");
            JsonBuilder jsonBuilder = new JsonBuilder();
            jsonBuilder.object();
            jsonBuilder.putStringValue("cpu", s);
            jsonBuilder.putStringValue("resid", f);
            jsonBuilder.putStringValue("channel", r);
            jsonBuilder.putStringValue("glr", t);
            jsonBuilder.putStringValue("glv", u);
            jsonBuilder.putStringValue(FunAdSdk.PLATFORM_MB, i());
            jsonBuilder.putStringValue("sv", k());
            jsonBuilder.putStringValue("os", m());
            jsonBuilder.key("dpi_x").value(n());
            jsonBuilder.key("dpi_y").value(n());
            jsonBuilder.putStringValue("net", q);
            jsonBuilder.putStringValue("cuid", z);
            jsonBuilder.putStringValue(u.w, a.getPackageName());
            jsonBuilder.key("screen_x").value(j());
            jsonBuilder.key("screen_y").value(l());
            jsonBuilder.putStringValue("appid", x);
            jsonBuilder.putStringValue("duid", y);
            if (!TextUtils.isEmpty(c)) {
                jsonBuilder.putStringValue("token", c);
            }
            jsonBuilder.endObject();
            SysUpdateObservable.getInstance().updatePhoneInfo(jsonBuilder.getJson());
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            a = context;
            if (context.getFilesDir() != null) {
                v = context.getFilesDir().getAbsolutePath();
            }
            if (context.getCacheDir() != null) {
                w = context.getCacheDir().getAbsolutePath();
            }
            if (com.baidu.mapsdkplatform.comapi.c.b()) {
                i = "Android" + Build.VERSION.SDK;
                h = Build.MODEL;
            } else {
                i = "Android";
                h = "";
            }
            g = context.getPackageName();
            d(context);
            e(context);
            s();
            z = r();
            A.put("resid", AppMD5.encodeUrlParamsValue(f));
            A.put("channel", AppMD5.encodeUrlParamsValue(o()));
            A.put(FunAdSdk.PLATFORM_MB, AppMD5.encodeUrlParamsValue(i()));
            A.put("sv", AppMD5.encodeUrlParamsValue(k()));
            A.put("os", AppMD5.encodeUrlParamsValue(m()));
            A.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(n()), Integer.valueOf(n()))));
            A.put("cuid", AppMD5.encodeUrlParamsValue(z));
            A.put(u.w, AppMD5.encodeUrlParamsValue(a.getPackageName()));
            A.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(j()), Integer.valueOf(l()))));
            com.baidu.mapsdkplatform.comjni.util.a aVar = e;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String apiVersion = VersionInfo.getApiVersion();
                j = apiVersion;
                if (apiVersion != null && !apiVersion.equals("")) {
                    j = j.replace('_', IStringUtil.EXTENSION_SEPARATOR);
                }
                k = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                j = "1.0.0";
                k = 1;
            }
        }
    }

    public static void e(Context context) {
        Display display;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null) {
                display = windowManager.getDefaultDisplay();
            } else {
                display = null;
            }
            if (display != null) {
                l = display.getWidth();
                m = display.getHeight();
                display.getMetrics(displayMetrics);
            }
            b = displayMetrics.density;
            n = (int) displayMetrics.xdpi;
            o = (int) displayMetrics.ydpi;
            int i2 = displayMetrics.densityDpi;
            p = i2;
            if (i2 == 0) {
                p = 160;
            }
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (A == null) {
                return null;
            }
            Date date = new Date();
            long time = date.getTime() + (date.getSeconds() * 1000);
            A.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf((time / 1000) + ((time % 1000) / 1000.0d)))));
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : A.entrySet()) {
                sb.append("&");
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
