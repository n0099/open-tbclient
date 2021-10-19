package c.p.a.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.a.j;
import c.p.a.e.b.j.a;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f35037a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f35038b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f35039c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f35040d;

    /* renamed from: e  reason: collision with root package name */
    public static String f35041e;

    /* renamed from: f  reason: collision with root package name */
    public static String f35042f;

    /* renamed from: g  reason: collision with root package name */
    public static String f35043g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1502078022, "Lc/p/a/e/a/h/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1502078022, "Lc/p/a/e/a/h/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b("EMUI") : invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            s();
            String str2 = f35040d;
            if (str2 != null) {
                return str2.equals(str);
            }
            String g2 = g("ro.miui.ui.version.name");
            f35041e = g2;
            if (!TextUtils.isEmpty(g2)) {
                f35040d = "MIUI";
                f35042f = "com.xiaomi.market";
                f35043g = f35041e;
            } else {
                String g3 = g("ro.build.version.emui");
                f35041e = g3;
                if (!TextUtils.isEmpty(g3)) {
                    f35040d = "EMUI";
                    f35042f = "com.huawei.appmarket";
                } else {
                    String g4 = g(f35038b);
                    f35041e = g4;
                    if (!TextUtils.isEmpty(g4)) {
                        f35040d = f35037a;
                        if (j.a(f35039c) > -1) {
                            f35042f = f35039c;
                        } else {
                            f35042f = "com.heytap.market";
                        }
                    } else {
                        String g5 = g("ro.vivo.os.version");
                        f35041e = g5;
                        if (!TextUtils.isEmpty(g5)) {
                            f35040d = "VIVO";
                            f35042f = "com.bbk.appstore";
                        } else {
                            String g6 = g("ro.smartisan.version");
                            f35041e = g6;
                            if (!TextUtils.isEmpty(g6)) {
                                f35040d = "SMARTISAN";
                                f35042f = "com.smartisanos.appstore";
                            } else {
                                String g7 = g(RomUtils.KEY_VERSION_GIONEE);
                                f35041e = g7;
                                if (!TextUtils.isEmpty(g7)) {
                                    f35040d = "QIONEE";
                                    f35042f = "com.gionee.aora.market";
                                } else {
                                    String g8 = g("ro.lenovo.lvp.version");
                                    f35041e = g8;
                                    if (!TextUtils.isEmpty(g8)) {
                                        f35040d = "LENOVO";
                                        f35042f = "com.lenovo.leos.appstore";
                                    } else if (n().toUpperCase().contains("SAMSUNG")) {
                                        f35040d = "SAMSUNG";
                                        f35042f = "com.sec.android.app.samsungapps";
                                    } else if (n().toUpperCase().contains("ZTE")) {
                                        f35040d = "ZTE";
                                        f35042f = "zte.com.market";
                                    } else if (n().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                        f35040d = RomUtils.ROM_NUBIA;
                                        f35042f = "cn.nubia.neostore";
                                    } else if (o().toUpperCase().contains("FLYME")) {
                                        f35040d = "FLYME";
                                        f35042f = "com.meizu.mstore";
                                        f35041e = o();
                                    } else if (n().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        f35040d = RomTypeUtil.ROM_ONEPLUS;
                                        f35041e = g("ro.rom.version");
                                        if (j.a(f35039c) > -1) {
                                            f35042f = f35039c;
                                        } else {
                                            f35042f = "com.heytap.market";
                                        }
                                    } else {
                                        f35040d = n().toUpperCase();
                                        f35042f = "";
                                        f35041e = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f35040d.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                c.p.a.e.b.l.f.E(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                c.p.a.e.b.l.f.E(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b("MIUI") : invokeV.booleanValue;
    }

    public static String e(String str) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str) : (String) invokeL.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b("VIVO") : invokeV.booleanValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (a.o().optBoolean("enable_reflect_system_properties", true)) {
                try {
                    return e(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return c(str);
                }
            }
            return c(str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            s();
            return b(f35037a);
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? b("FLYME") : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b("SAMSUNG") : invokeV.booleanValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f35040d == null) {
                b("");
            }
            return f35040d;
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f35041e == null) {
                b("");
            }
            return f35041e;
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f35042f == null) {
                b("");
            }
            return f35042f;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String str = Build.MANUFACTURER;
            return str == null ? "" : str.trim();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String str = Build.DISPLAY;
            return str == null ? "" : str.trim();
        }
        return (String) invokeV.objValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            t();
            return "V10".equals(f35043g);
        }
        return invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            t();
            return "V11".equals(f35043g);
        }
        return invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            t();
            return "V12".equals(f35043g);
        }
        return invokeV.booleanValue;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && TextUtils.isEmpty(f35037a)) {
            c.p.a.e.b.g.e.f();
            f35037a = c.p.a.e.b.d.c.f35107b;
            f35038b = "ro.build.version." + c.p.a.e.b.d.c.f35108c + "rom";
            f35039c = "com." + c.p.a.e.b.d.c.f35108c + ".market";
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && f35043g == null) {
            try {
                f35043g = g("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f35043g;
            if (str == null) {
                str = "";
            }
            f35043g = str;
        }
    }
}
