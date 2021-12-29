package com.baidu.sofire.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.h;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.r1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static a f39764g;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f39765b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f39766c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f39767d;

    /* renamed from: e  reason: collision with root package name */
    public SharedPreferences f39768e;

    /* renamed from: f  reason: collision with root package name */
    public SharedPreferences.Editor f39769f;

    /* renamed from: h  reason: collision with root package name */
    public Context f39770h;

    /* renamed from: i  reason: collision with root package name */
    public int f39771i;

    /* renamed from: j  reason: collision with root package name */
    public String f39772j;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, SharedPreferences> f39773k;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39772j = null;
        this.f39773k = new HashMap();
        this.f39770h = context;
        int a = com.baidu.sofire.utility.c.a(context);
        this.f39771i = a;
        c cVar = new c(this.f39770h, a == 1 ? context.getSharedPreferences("leroadcfg", 0) : null, "leroadcfg", this.f39771i);
        this.a = cVar;
        SharedPreferences.Editor edit = cVar.edit();
        this.f39765b = edit;
        this.f39766c = this.a;
        this.f39767d = edit;
        c cVar2 = new c(this.f39770h, this.f39771i == 1 ? context.getSharedPreferences(r1.p, 0) : null, r1.p, this.f39771i);
        this.f39768e = cVar2;
        this.f39769f = cVar2.edit();
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (context == null) {
                    return f39764g;
                }
                if (f39764g == null) {
                    f39764g = new a(context);
                }
                return f39764g;
            }
        }
        return (a) invokeL.objValue;
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String string = this.a.getString("p_s_s_c_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String string = this.a.getString("p_s_o_d_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = this.a.getString("p_s_s_o_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String string = this.a.getString("p_s_n_o_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39766c.getString("xytk", "") : (String) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a.getBoolean("bka", true) : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f39765b.putLong("pu_ap_fd", System.currentTimeMillis());
            this.f39765b.commit();
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a.getInt("wi_fa_pu_ap", 0) : invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a.getInt("mo_fa_pu_ap", 0) : invokeV.intValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f39765b.putLong("pu_cl_fd", System.currentTimeMillis());
            this.f39765b.commit();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.f39765b.putLong("se_ae_fd", System.currentTimeMillis());
            this.f39765b.commit();
        }
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.a.getInt("wi_fa_pu_cl", 0) : invokeV.intValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.a.getInt("mo_fa_pu_cl", 0) : invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.a.getInt("mo_ae_fa_ct", 0) : invokeV.intValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f39766c.getString("xyus", "") : (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f39766c.getString("xyusec", "") : (String) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            String string = this.f39766c.getString("xyglsn", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            String string = this.f39766c.getString("rpiiemn", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            String string = this.f39766c.getString("rpnewuidn", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> p() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.a.getString("hcpk", "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e2) {
                        e2.getMessage();
                        com.baidu.sofire.b.b();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<Integer> q() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.a.getString("glspk", "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e2) {
                        e2.getMessage();
                        com.baidu.sofire.b.b();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.a.getInt("sustfd", 0) : invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.a.getInt("sufzfd", 0) : invokeV.intValue;
    }

    public final List<com.baidu.sofire.c.a> t() {
        InterceptResult invokeV;
        String[] split;
        com.baidu.sofire.c.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            String string = this.f39768e.getString("re_con", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : string.split("\\|\\|")) {
                if (!TextUtils.isEmpty(str) && (a = com.baidu.sofire.c.a.a(str)) != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r0 < 24) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            int i2 = 24;
            if ("com.baidu.BaiduMap.meizu".equals(this.f39770h.getPackageName())) {
                return this.f39768e.getInt("re_net_hr", 24);
            }
            int i3 = this.f39768e.getInt("re_net_hr", 3);
            try {
                String[] g2 = com.baidu.sofire.utility.c.g(this.f39770h);
                if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1]) && "200080".equals(g2[0])) {
                    if ("com.baidu.BaiduMap".equals(this.f39770h.getPackageName())) {
                    }
                }
                i2 = i3;
                return i2;
            } catch (Throwable unused) {
                return i3;
            }
        }
        return invokeV.intValue;
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f39768e.getInt("up_nu_li", 100) : invokeV.intValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.a.getBoolean("s_c_c", true) : invokeV.booleanValue;
    }

    public final String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            String string = this.a.getString("p_s_i_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            String string = this.a.getString("p_s_a_i_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            String string = this.a.getString("p_s_e_c_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f39765b.putInt("mo_fa_pu_ap", i2);
            this.f39765b.commit();
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f39767d.putString("rpnewuidn", "");
                this.f39767d.commit();
                return;
            }
            try {
                this.f39767d.putString("rpnewuidn", new String(Base64.encode(h.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.f39767d.commit();
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.f39765b.putInt("appal_te", i2);
            this.f39765b.commit();
        }
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.f39769f.putInt("g_r_d_d_n", i2);
            this.f39769f.commit();
        }
    }

    public final void i(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j2) == null) {
            this.f39765b.putLong("p_s_o_d_t_t", j2);
            this.f39765b.commit();
        }
    }

    public final void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j2) == null) {
            this.f39765b.putLong("p_s_s_o_t_t", j2);
            this.f39765b.commit();
        }
    }

    public final void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j2) == null) {
            this.f39765b.putLong("p_s_n_o_t_t", j2);
            this.f39765b.commit();
        }
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f39765b.putInt("mo_ae_fa_ct", i2);
            this.f39765b.commit();
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.f39765b.putInt("sustfd", i2);
            this.f39765b.commit();
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.f39765b.putInt("sufzfd", i2);
            this.f39765b.commit();
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f39767d.putString("xyus", str);
            this.f39767d.commit();
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            SharedPreferences sharedPreferences = this.f39768e;
            return sharedPreferences.getString("al_da" + str, "");
        }
        return (String) invokeL.objValue;
    }

    public final void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048618, this, j2) == null) {
            this.f39765b.putLong("p_s_s_c_t_t", j2);
            this.f39765b.commit();
        }
    }

    public final Bundle a(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        SharedPreferences a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            try {
                string = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if ("querySharedHandler".equals(string)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("handle_platform", "sofire");
                return bundle2;
            }
            String string2 = bundle.getString("pref_name");
            if (TextUtils.isEmpty(string2)) {
                return null;
            }
            String string3 = bundle.getString("key");
            if (TextUtils.isEmpty(string3)) {
                return null;
            }
            if (string2.equals("leroadcfg")) {
                a = this.a;
            } else if (string2.equals("leroadcfg")) {
                a = this.f39766c;
            } else if (string2.equals(r1.p)) {
                a = this.f39768e;
            } else {
                a = a(string2);
            }
            char c2 = 0;
            if (string.startsWith("get")) {
                String string4 = bundle.getString("defult_value");
                if (("getString".equals(string) || !TextUtils.isEmpty(string4)) && a != null) {
                    Bundle bundle3 = new Bundle();
                    switch (string.hashCode()) {
                        case -1249359687:
                            if (string.equals("getInt")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -75354382:
                            if (string.equals("getLong")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 804029191:
                            if (string.equals("getString")) {
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1101572082:
                            if (string.equals("getBoolean")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1953351846:
                            if (string.equals("getFloat")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    if (c2 == 0) {
                        bundle3.putString("result", a.getString(string3, string4));
                    } else if (c2 == 1) {
                        bundle3.putInt("result", a.getInt(string3, Integer.parseInt(string4)));
                    } else if (c2 == 2) {
                        bundle3.putLong("result", a.getLong(string3, Long.parseLong(string4)));
                    } else if (c2 == 3) {
                        bundle3.putFloat("result", a.getFloat(string3, Float.parseFloat(string4)));
                    } else if (c2 == 4) {
                        bundle3.putBoolean("result", a.getBoolean(string3, Boolean.parseBoolean(string4)));
                    }
                    return bundle3;
                }
                return null;
            }
            if (string.startsWith("put")) {
                SharedPreferences.Editor edit = a.edit();
                switch (string.hashCode()) {
                    case -976920992:
                        if (string.equals("putInt")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -462997504:
                        if (string.equals("putString")) {
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -219689429:
                        if (string.equals("putLong")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 478450201:
                        if (string.equals("putBoolean")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1773932685:
                        if (string.equals("putFloat")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    edit.putString(string3, bundle.getString("value"));
                } else if (c2 == 1) {
                    edit.putInt(string3, bundle.getInt("value"));
                } else if (c2 == 2) {
                    edit.putLong(string3, bundle.getLong("value"));
                } else if (c2 == 3) {
                    edit.putFloat(string3, bundle.getFloat("value"));
                } else if (c2 == 4) {
                    edit.putBoolean(string3, bundle.getBoolean("value"));
                }
                edit.apply();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f39767d.putString("xyusec", str);
            this.f39767d.commit();
        }
    }

    public final void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) {
            this.f39765b.putLong("p_s_i_t_t", j2);
            this.f39765b.commit();
        }
    }

    public final void f(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j2) == null) {
            this.f39765b.putLong("p_s_a_i_t_t", j2);
            this.f39765b.commit();
        }
    }

    public final void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j2) == null) {
            this.f39765b.putLong("p_s_e_c_t_t", j2);
            this.f39765b.commit();
        }
    }

    public final void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            this.f39769f.putLong("re_last_ofline_time", j2);
            this.f39769f.commit();
        }
    }

    public final void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.f39769f.putLong("re_day_len", j2);
            this.f39769f.commit();
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f39765b.putBoolean("se_fg_s", z);
            this.f39765b.commit();
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f39765b.putBoolean("a_a_c_b", z);
            this.f39765b.commit();
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f39765b.putInt("appal_daa", i2);
            this.f39765b.commit();
        }
    }

    public final void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            this.f39769f.putLong("re_day_b_t", j2);
            this.f39769f.commit();
        }
    }

    public final SharedPreferences a(String str) {
        InterceptResult invokeL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                synchronized (this.f39773k) {
                    sharedPreferences = this.f39773k.get(str);
                    if (sharedPreferences == null) {
                        c cVar = new c(this.f39770h, this.f39771i == 1 ? this.f39770h.getSharedPreferences(str, 0) : null, str, this.f39771i);
                        this.f39773k.put(str, cVar);
                        sharedPreferences = cVar;
                    }
                }
                return sharedPreferences;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getString("svi_n", "") : (String) invokeV.objValue;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f39765b.putInt("wi_fa_pu_ap", i2);
            this.f39765b.commit();
        }
    }

    public final void a(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    sb.append(iArr[i2]);
                    if (i2 != iArr.length - 1) {
                        sb.append("-");
                    }
                }
                this.f39765b.putString("hcpk", sb.toString());
            } else {
                this.f39765b.putString("hcpk", "");
            }
            this.f39765b.commit();
        }
    }

    public final void a(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            if (list.size() == 0) {
                this.f39765b.putString("glspk", "");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    sb.append(list.get(i2));
                    if (i2 != list.size() - 1) {
                        sb.append("-");
                    }
                }
                this.f39765b.putString("glspk", sb.toString());
            }
            this.f39765b.commit();
        }
    }

    public final void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.f39765b.putLong("slruct", j2);
            this.f39765b.commit();
        }
    }

    public final void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048586, this, i2, i3, i4) == null) {
            String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences.Editor editor = this.f39765b;
            editor.putInt(str + i3, i4);
            this.f39765b.commit();
        }
    }

    public final int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) {
            String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            SharedPreferences sharedPreferences = this.a;
            return sharedPreferences.getInt(str + i3, 0);
        }
        return invokeII.intValue;
    }

    public final void a(com.baidu.sofire.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            String string = this.f39768e.getString("re_con", "");
            SharedPreferences.Editor editor = this.f39769f;
            editor.putString("re_con", string + "||" + com.baidu.sofire.c.a.a(aVar));
            this.f39769f.commit();
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f39765b.putBoolean("s_c_c", z);
            if (Build.VERSION.SDK_INT >= 9) {
                this.f39765b.apply();
            } else {
                this.f39765b.commit();
            }
        }
    }
}
