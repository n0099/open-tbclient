package c.a.n0.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.l.e;
import c.a.n0.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f3886e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f3887b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f3888c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3889d;

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
        this.f3887b = context.getSharedPreferences("once_login_config", 0);
        context.getSharedPreferences("leroadcfg", 0);
        this.f3888c = this.f3887b.edit();
        this.f3889d = context;
    }

    public static a h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f3886e == null) {
                synchronized (a.class) {
                    if (f3886e == null) {
                        f3886e = new a(context);
                    }
                }
            }
            return f3886e;
        }
        return (a) invokeL.objValue;
    }

    public void A(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            u("ky_llt", j2);
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            v("ky_dxc", str);
        }
    }

    public void C(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            M("k_sdk_a_s", str + "_" + str2);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            w("k_sdk_cu_s", z);
        }
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? g("ky_cfo_t", c.a.n0.l.c.f4068f) : invokeV.longValue;
    }

    public final String F(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) ? this.f3887b.getString(str, str2) : (String) invokeLL.objValue;
    }

    public void G(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            u("rp_last_off_ti", j2);
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            M("last_al_rp_d", str);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            w("k_is_ig_env", z);
        }
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!TextUtils.isEmpty(this.a)) {
                return this.a;
            }
            String F = F("xyus", "");
            this.a = F;
            if (TextUtils.isEmpty(F)) {
                String b2 = g.b(UUID.randomUUID().toString());
                this.a = b2;
                M("xyus", b2);
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public void K(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            u("ky_lvt", j2);
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            M("last_Rp_d", str);
        }
    }

    public final void M(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.f3888c.putString(str, str2);
            this.f3888c.commit();
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            w("k_sdk_s", z);
        }
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? i("k_cd_2", "") : (String) invokeV.objValue;
    }

    public void P(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            u("ky_cfs_t", j2);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            v("ky_ltc", str);
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            w("k_u_a_pr", z);
        }
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? i("ky_dxc", "") : (String) invokeV.objValue;
    }

    public void T(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            u("t_con_3g", j2);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        M("k_sdk_ra_k", str);
    }

    public long V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? g("k_last_a_ts", 0L) : invokeV.longValue;
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            M("ky_sg", str);
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? F("last_al_rp_d", "") : (String) invokeV.objValue;
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            v("ky_ydc", str);
        }
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? f("ky_lls", -1) : invokeV.intValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? o("k_sdk_ct_s", true) : invokeV.booleanValue;
    }

    public long a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? g("ky_llt", 0L) : invokeV.longValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? o("k_sdk_cu_s", true) : invokeV.booleanValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? F("last_Rp_d", "") : (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? o("k_is_ig_env", true) : invokeV.booleanValue;
    }

    public long c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? g("rp_last_off_ti", 0L) : invokeV.longValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? o("k_sdk_s", true) : invokeV.booleanValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? f("ky_lvs", -1) : invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? o("k_u_a_pr", false) : invokeV.booleanValue;
    }

    public long e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? g("ky_lvt", 0L) : invokeV.longValue;
    }

    public final int f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048612, this, str, i2)) == null) ? this.f3887b.getInt(str, i2) : invokeLI.intValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? i("ky_ltc", "") : (String) invokeV.objValue;
    }

    public final long g(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048614, this, str, j2)) == null) ? this.f3887b.getLong(str, j2) : invokeLJ.longValue;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            int f2 = f("k_mask_num", 4);
            if (f2 <= 4) {
                return 4;
            }
            if (f2 >= 8) {
                return 8;
            }
            return f2;
        }
        return invokeV.intValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? f("one_d_3g_con", 50) : invokeV.intValue;
    }

    public String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, str, str2)) == null) {
            String string = this.f3887b.getString(str, str2);
            return !TextUtils.isEmpty(string) ? e.a(this.f3889d, string) : "";
        }
        return (String) invokeLL.objValue;
    }

    public long i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? g("ky_cfs_t", 0L) : invokeV.longValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            M("k_sdk_a_s", "");
        }
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? f("rp_off_gap", 3) : invokeV.intValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            t("ky_lls", i2);
        }
    }

    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? F("k_sdk_ra_k", "") : (String) invokeV.objValue;
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j2) == null) {
            u("ky_cfo_t", j2);
        }
    }

    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? F("k_sdk_a_s", "") : (String) invokeV.objValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            v("k_cd_2", str);
        }
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? F("ky_sg", "") : (String) invokeV.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            w("k_sdk_cm_s", z);
        }
    }

    public long n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? g("t_con_3g", 0L) : invokeV.longValue;
    }

    public final boolean o(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048629, this, str, z)) == null) ? this.f3887b.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? i("ky_ydc", "") : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? F("ky_aid", "") : (String) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? o("k_sdk_cm_s", true) : invokeV.booleanValue;
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            t("ky_lvs", i2);
        }
    }

    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j2) == null) {
            u("k_last_a_ts", j2);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            M("ky_aid", str);
        }
    }

    public final void t(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048636, this, str, i2) == null) {
            this.f3888c.putInt(str, i2);
            this.f3888c.commit();
        }
    }

    public final void u(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048637, this, str, j2) == null) {
            this.f3888c.putLong(str, j2);
            this.f3888c.commit();
        }
    }

    public void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048638, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f3888c.putString(str, e.b(this.f3889d, str2.getBytes()));
        this.f3888c.commit();
    }

    public final void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048639, this, str, z) == null) {
            this.f3888c.putBoolean(str, z);
            this.f3888c.commit();
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            w("k_sdk_ct_s", z);
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? g("k_a_itl", c.a.n0.l.b.f4063b * 24) : invokeV.longValue;
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i2) == null) || i2 <= 4) {
            return;
        }
        t("k_mask_num", i2);
    }
}
