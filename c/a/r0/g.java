package c.a.r0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f29516a;

    /* renamed from: b  reason: collision with root package name */
    public int f29517b;

    /* renamed from: c  reason: collision with root package name */
    public int f29518c;

    /* renamed from: d  reason: collision with root package name */
    public int f29519d;

    /* renamed from: e  reason: collision with root package name */
    public int f29520e;

    /* renamed from: f  reason: collision with root package name */
    public int f29521f;

    /* renamed from: g  reason: collision with root package name */
    public int f29522g;

    /* renamed from: h  reason: collision with root package name */
    public int f29523h;

    /* renamed from: i  reason: collision with root package name */
    public f f29524i;

    /* renamed from: j  reason: collision with root package name */
    public e0 f29525j;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29520e = 614400;
        this.f29521f = 153600;
        this.f29522g = 614400;
        this.f29523h = 614400;
        this.f29524i = new f();
        this.f29525j = new e0();
    }

    public static g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (k == null) {
                synchronized (e.class) {
                    if (k == null) {
                        k = new g();
                    }
                }
            }
            return k;
        }
        return (g) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29524i.f29501a.f29579b : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29524i.f29501a.f29581d : invokeV.booleanValue;
    }

    public boolean C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            HashMap<String, l> hashMap = this.f29524i.f29510j;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.f29524i.f29510j.get(str).b();
        }
        return invokeL.booleanValue;
    }

    public boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Context context = this.f29516a;
            return context == null || E(context) || !c(str);
        }
        return invokeL.booleanValue;
    }

    public boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }

    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f29524i.f29503c.contains(str) : invokeL.booleanValue;
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 < 604800000) {
            return;
        }
        this.f29518c = i2;
        i0.e().putInt("ubc_data_expire_time", i2);
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 < 10000) {
            return;
        }
        this.f29519d = i2;
        i0.e().putInt("ubc_database_limit", i2);
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 < 153600) {
            return;
        }
        this.f29520e = i2;
        i0.e().putInt("ubc_launch_upload_max_limit", i2);
    }

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || i2 < 153600) {
            return;
        }
        this.f29523h = i2;
        i0.e().putInt("ubc_non_real_upload_max_limit", i2);
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 < 153600) {
            return;
        }
        this.f29522g = i2;
        i0.e().putInt("ubc_real_upload_max_limit", i2);
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 < 30720) {
            return;
        }
        this.f29521f = i2;
        i0.e().putInt("ubc_single_log_max_limit", i2);
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 6) {
            return;
        }
        this.f29517b = i2 * 60000;
    }

    public void N(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            for (j jVar : list) {
                String c2 = jVar.c();
                if (!TextUtils.isEmpty(c2)) {
                    if (!jVar.t()) {
                        this.f29524i.f29502b.add(c2);
                        this.f29524i.f29506f.remove(c2);
                    } else {
                        this.f29524i.f29502b.remove(c2);
                        this.f29524i.f29506f.add(c2);
                    }
                    if (jVar.p()) {
                        this.f29524i.f29503c.add(c2);
                        this.f29524i.f29504d.remove(c2);
                    } else {
                        this.f29524i.f29503c.remove(c2);
                        this.f29524i.f29504d.add(c2);
                    }
                    if (jVar.l()) {
                        this.f29524i.f29505e.add(c2);
                    } else {
                        this.f29524i.f29505e.remove(c2);
                    }
                    if (jVar.o()) {
                        this.f29524i.f29507g.add(c2);
                    } else {
                        this.f29524i.f29507g.remove(c2);
                    }
                    int g2 = jVar.g();
                    if (g2 >= 1 && g2 <= 100) {
                        this.f29524i.f29508h.put(c2, Integer.valueOf(g2));
                    } else {
                        this.f29524i.f29508h.remove(c2);
                    }
                    String a2 = jVar.a();
                    if (!TextUtils.isEmpty(a2)) {
                        this.f29524i.f29509i.put(c2, a2);
                    } else {
                        this.f29524i.f29509i.remove(c2);
                    }
                    int d2 = jVar.d();
                    int e2 = jVar.e();
                    if (d2 != 0 && e2 != 0) {
                        this.f29524i.f29510j.put(c2, new l(c2, e2, d2));
                    }
                    if (jVar.n()) {
                        this.f29524i.k.add(c2);
                    } else {
                        this.f29524i.k.remove(c2);
                    }
                    if (jVar.q()) {
                        this.f29524i.l.add(c2);
                    } else {
                        this.f29524i.l.remove(c2);
                    }
                    int b2 = jVar.b();
                    if (jVar.s()) {
                        this.f29524i.m.put(c2, Integer.valueOf(b2));
                    } else {
                        this.f29524i.m.remove(c2);
                    }
                    if (jVar.u()) {
                        this.f29524i.n.remove(c2);
                    } else {
                        this.f29524i.n.put(c2, Integer.valueOf(jVar.j()));
                    }
                    int f2 = jVar.f();
                    if (f2 != 2) {
                        this.f29524i.o.put(c2, Integer.valueOf(f2));
                    } else {
                        this.f29524i.o.remove(c2);
                    }
                }
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.f29524i.f29505e.contains(str) : invokeL.booleanValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (!this.f29524i.o.containsKey(str) || (num = this.f29524i.o.get(str)) == null) {
                return 2;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? this.f29524i.f29507g.contains(str) : invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? w(str) == 0 : invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (this.f29525j.isUBCDebug() || this.f29524i.f29503c.contains(str)) {
                return true;
            }
            return this.f29524i.f29501a.f29579b;
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? this.f29524i.l.contains(str) : invokeL.booleanValue;
    }

    public boolean g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, str, i2)) == null) {
            if (this.f29524i.f29502b.contains(str)) {
                return false;
            }
            if ((i2 & 16) != 0 || (i2 & 32) != 0) {
                return this.f29524i.f29506f.contains(str);
            } else if (this.f29524i.f29506f.contains(str)) {
                return true;
            } else {
                return this.f29524i.f29501a.f29578a;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (!y() && this.f29525j.isUBCSample() && u(str) > 0) {
                if (new Random().nextInt(100) >= u(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? this.f29524i.f29509i.containsKey(str) ? this.f29524i.f29509i.get(str) : "" : (String) invokeL.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f29518c : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f29519d : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f29524i.f29501a.f29580c : invokeV.intValue;
    }

    public int m(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            if (!this.f29524i.m.containsKey(str) || (num = this.f29524i.m.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f29520e : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f29523h : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f29522g : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f29521f : invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f29517b : invokeV.intValue;
    }

    public HashSet<String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f29524i.f29504d : (HashSet) invokeV.objValue;
    }

    public int u(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !this.f29524i.f29508h.containsKey(str) || (num = this.f29524i.f29508h.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) ? !TextUtils.isEmpty(str) ? (this.f29524i.k.contains(str) || TextUtils.equals(str, "1876") || TextUtils.equals(str, "2980")) ? "1" : "0" : "0" : (String) invokeL.objValue;
    }

    public int w(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            if (!this.f29524i.n.containsKey(str) || (num = this.f29524i.n.get(str)) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public void x(c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, cVar, context) == null) {
            this.f29516a = context;
            this.f29517b = 360000;
            i0 e2 = i0.e();
            this.f29518c = e2.getInt("ubc_data_expire_time", 604800000);
            this.f29519d = e2.getInt("ubc_database_limit", 10000);
            cVar.n().t(this.f29524i);
            this.f29520e = e2.getInt("ubc_launch_upload_max_limit", 614400);
            this.f29521f = e2.getInt("ubc_single_log_max_limit", 153600);
            this.f29522g = e2.getInt("ubc_real_upload_max_limit", 614400);
            this.f29523h = e2.getInt("ubc_non_real_upload_max_limit", 614400);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            q uBCContext = UBC.getUBCContext();
            if (uBCContext != null) {
                return uBCContext.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            HashMap<String, l> hashMap = this.f29524i.f29510j;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.f29524i.f29510j.get(str).a();
        }
        return invokeL.booleanValue;
    }
}
