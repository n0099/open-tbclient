package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
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
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;
    public static String A = null;
    public static Map<String, String> B = null;
    public static Context a = null;
    public static final int b;
    public static float c = 0.0f;
    public static String d = null;
    public static final String e = "i";
    public static com.baidu.mapsdkplatform.comjni.util.a f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static int p;
    public static int q;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(42760377, "Lcom/baidu/mapsdkplatform/comapi/util/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(42760377, "Lcom/baidu/mapsdkplatform/comapi/util/i;");
                return;
            }
        }
        f = new com.baidu.mapsdkplatform.comjni.util.a();
        g = "02";
        s = "baidu";
        t = "";
        u = "";
        v = "";
        y = "-1";
        z = "-1";
        b = Integer.parseInt(Build.VERSION.SDK);
        c = 1.0f;
        A = "";
        B = new HashMap();
    }

    public i() {
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
            d();
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            r = str;
            f();
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            y = str2;
            z = str;
            f();
        }
    }

    public static byte[] a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("cpu", t);
            bundle.putString("resid", g);
            bundle.putString("channel", s);
            bundle.putString("glr", u);
            bundle.putString("glv", v);
            bundle.putString(FunAdSdk.PLATFORM_MB, g());
            bundle.putString("sv", i());
            bundle.putString("os", k());
            bundle.putInt("dpi_x", l());
            bundle.putInt("dpi_y", l());
            bundle.putString("net", r);
            bundle.putString("cuid", A);
            bundle.putByteArray(SocialOperation.GAME_SIGNATURE, a(a));
            bundle.putString(u.w, a.getPackageName());
            bundle.putInt("screen_x", h());
            bundle.putInt("screen_y", j());
            com.baidu.mapsdkplatform.comjni.util.a aVar = f;
            if (aVar != null) {
                aVar.a(bundle);
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            a = context;
            if (context.getFilesDir() != null) {
                w = context.getFilesDir().getAbsolutePath();
            }
            if (context.getCacheDir() != null) {
                x = context.getCacheDir().getAbsolutePath();
            }
            i = Build.MODEL;
            j = "Android" + Build.VERSION.SDK;
            h = context.getPackageName();
            c(context);
            d(context);
            q();
            A = p();
            B.put("resid", AppMD5.encodeUrlParamsValue(g));
            B.put("channel", AppMD5.encodeUrlParamsValue(m()));
            B.put(FunAdSdk.PLATFORM_MB, AppMD5.encodeUrlParamsValue(g()));
            B.put("sv", AppMD5.encodeUrlParamsValue(i()));
            B.put("os", AppMD5.encodeUrlParamsValue(k()));
            B.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(l()), Integer.valueOf(l()))));
            B.put("cuid", AppMD5.encodeUrlParamsValue(A));
            B.put(u.w, AppMD5.encodeUrlParamsValue(a.getPackageName()));
            B.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(h()), Integer.valueOf(j()))));
            com.baidu.mapsdkplatform.comjni.util.a aVar = f;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (B == null) {
                return null;
            }
            Date date = new Date();
            long time = date.getTime() + (date.getSeconds() * 1000);
            B.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf((time / 1000) + ((time % 1000) / 1000.0d)))));
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : B.entrySet()) {
                sb.append("&");
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String apiVersion = VersionInfo.getApiVersion();
                k = apiVersion;
                if (apiVersion != null && !apiVersion.equals("")) {
                    k = k.replace('_', IStringUtil.EXTENSION_SEPARATOR);
                }
                l = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                k = "1.0.0";
                l = 1;
            }
        }
    }

    public static void d() {
        com.baidu.mapsdkplatform.comjni.util.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, null) == null) || (aVar = f) == null) {
            return;
        }
        aVar.b();
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
            if (defaultDisplay != null) {
                m = defaultDisplay.getWidth();
                n = defaultDisplay.getHeight();
                defaultDisplay.getMetrics(displayMetrics);
            }
            c = displayMetrics.density;
            o = (int) displayMetrics.xdpi;
            p = (int) displayMetrics.ydpi;
            if (b > 3) {
                q = displayMetrics.densityDpi;
            } else {
                q = 160;
            }
            if (q == 0) {
                q = 160;
            }
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? r : (String) invokeV.objValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            B.put("net", AppMD5.encodeUrlParamsValue(e()));
            B.put("appid", AppMD5.encodeUrlParamsValue(y));
            B.put("bduid", "");
            if (f == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("cpu", t);
            bundle.putString("resid", g);
            bundle.putString("channel", s);
            bundle.putString("glr", u);
            bundle.putString("glv", v);
            bundle.putString(FunAdSdk.PLATFORM_MB, g());
            bundle.putString("sv", i());
            bundle.putString("os", k());
            bundle.putInt("dpi_x", l());
            bundle.putInt("dpi_y", l());
            bundle.putString("net", r);
            bundle.putString("cuid", A);
            bundle.putString(u.w, a.getPackageName());
            bundle.putInt("screen_x", h());
            bundle.putInt("screen_y", j());
            bundle.putString("appid", y);
            bundle.putString("duid", z);
            if (!TextUtils.isEmpty(d)) {
                bundle.putString("token", d);
            }
            f.a(bundle);
            SysUpdateObservable.getInstance().updatePhoneInfo();
        }
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? i : (String) invokeV.objValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? m : invokeV.intValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? k : (String) invokeV.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? n : invokeV.intValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? j : (String) invokeV.objValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? q : invokeV.intValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? s : (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? h : (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? w : (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                str = CommonParam.getCUID(a);
            } catch (Exception unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            r = "0";
        }
    }
}
