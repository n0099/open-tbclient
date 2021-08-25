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
    public static String f34901a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f34902b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f34903c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f34904d;

    /* renamed from: e  reason: collision with root package name */
    public static String f34905e;

    /* renamed from: f  reason: collision with root package name */
    public static String f34906f;

    /* renamed from: g  reason: collision with root package name */
    public static String f34907g;
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
            String str2 = f34904d;
            if (str2 != null) {
                return str2.equals(str);
            }
            String g2 = g("ro.miui.ui.version.name");
            f34905e = g2;
            if (!TextUtils.isEmpty(g2)) {
                f34904d = "MIUI";
                f34906f = "com.xiaomi.market";
                f34907g = f34905e;
            } else {
                String g3 = g("ro.build.version.emui");
                f34905e = g3;
                if (!TextUtils.isEmpty(g3)) {
                    f34904d = "EMUI";
                    f34906f = "com.huawei.appmarket";
                } else {
                    String g4 = g(f34902b);
                    f34905e = g4;
                    if (!TextUtils.isEmpty(g4)) {
                        f34904d = f34901a;
                        if (j.a(f34903c) > -1) {
                            f34906f = f34903c;
                        } else {
                            f34906f = "com.heytap.market";
                        }
                    } else {
                        String g5 = g("ro.vivo.os.version");
                        f34905e = g5;
                        if (!TextUtils.isEmpty(g5)) {
                            f34904d = "VIVO";
                            f34906f = "com.bbk.appstore";
                        } else {
                            String g6 = g("ro.smartisan.version");
                            f34905e = g6;
                            if (!TextUtils.isEmpty(g6)) {
                                f34904d = "SMARTISAN";
                                f34906f = "com.smartisanos.appstore";
                            } else {
                                String g7 = g(RomUtils.KEY_VERSION_GIONEE);
                                f34905e = g7;
                                if (!TextUtils.isEmpty(g7)) {
                                    f34904d = "QIONEE";
                                    f34906f = "com.gionee.aora.market";
                                } else {
                                    String g8 = g("ro.lenovo.lvp.version");
                                    f34905e = g8;
                                    if (!TextUtils.isEmpty(g8)) {
                                        f34904d = "LENOVO";
                                        f34906f = "com.lenovo.leos.appstore";
                                    } else if (n().toUpperCase().contains("SAMSUNG")) {
                                        f34904d = "SAMSUNG";
                                        f34906f = "com.sec.android.app.samsungapps";
                                    } else if (n().toUpperCase().contains("ZTE")) {
                                        f34904d = "ZTE";
                                        f34906f = "zte.com.market";
                                    } else if (n().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                        f34904d = RomUtils.ROM_NUBIA;
                                        f34906f = "cn.nubia.neostore";
                                    } else if (o().toUpperCase().contains("FLYME")) {
                                        f34904d = "FLYME";
                                        f34906f = "com.meizu.mstore";
                                        f34905e = o();
                                    } else if (n().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        f34904d = RomTypeUtil.ROM_ONEPLUS;
                                        f34905e = g("ro.rom.version");
                                        if (j.a(f34903c) > -1) {
                                            f34906f = f34903c;
                                        } else {
                                            f34906f = "com.heytap.market";
                                        }
                                    } else {
                                        f34904d = n().toUpperCase();
                                        f34906f = "";
                                        f34905e = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f34904d.equals(str);
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
            return b(f34901a);
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
            if (f34904d == null) {
                b("");
            }
            return f34904d;
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f34905e == null) {
                b("");
            }
            return f34905e;
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f34906f == null) {
                b("");
            }
            return f34906f;
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
            return "V10".equals(f34907g);
        }
        return invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            t();
            return "V11".equals(f34907g);
        }
        return invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            t();
            return "V12".equals(f34907g);
        }
        return invokeV.booleanValue;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && TextUtils.isEmpty(f34901a)) {
            c.p.a.e.b.g.e.f();
            f34901a = c.p.a.e.b.d.c.f34971b;
            f34902b = "ro.build.version." + c.p.a.e.b.d.c.f34972c + "rom";
            f34903c = "com." + c.p.a.e.b.d.c.f34972c + ".market";
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && f34907g == null) {
            try {
                f34907g = g("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f34907g;
            if (str == null) {
                str = "";
            }
            f34907g = str;
        }
    }
}
