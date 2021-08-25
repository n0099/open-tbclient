package c.a.o0.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12226a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f12227b;

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f12228c;

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<String> f12229d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f12230e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f12231f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f12232g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, h> f12233h;

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f12234i;

    /* renamed from: j  reason: collision with root package name */
    public int f12235j;
    public int k;
    public int l;

    public d() {
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
        this.f12227b = new HashSet<>();
        this.f12228c = new HashSet<>();
        this.f12229d = new HashSet<>();
        this.f12230e = new HashSet<>();
        this.f12231f = new HashMap<>();
        this.f12232g = new HashMap<>();
        this.f12233h = new HashMap<>();
        this.f12234i = new HashSet<>();
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == null) {
                synchronized (d.class) {
                    if (m == null) {
                        m = new d();
                    }
                }
            }
            return m;
        }
        return (d) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f12229d.contains(str) : invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (e.h().s()) {
                return true;
            }
            return this.f12228c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            if (this.f12227b.contains(str)) {
                return false;
            }
            if ((i2 & 16) == 0 && (i2 & 32) == 0) {
                return true;
            }
            return this.f12230e.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f12232g.containsKey(str) ? this.f12232g.get(str) : "" : (String) invokeL.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12235j : invokeV.intValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (e.h().r() || TextUtils.isEmpty(str) || !this.f12231f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f12231f.get(str));
        }
        return invokeL.intValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (TextUtils.isEmpty(str) || !this.f12234i.contains(str)) ? "0" : "1" : (String) invokeL.objValue;
    }

    public void k(c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, context) == null) {
            this.f12226a = context;
            this.f12235j = 360000;
            t g2 = t.g();
            this.k = g2.getInt("ubc_data_expire_time", 259200000);
            this.l = g2.getInt("ubc_database_limit", 4000);
            cVar.e().w(this.f12227b, this.f12230e, this.f12228c, this.f12229d, this.f12231f, this.f12232g, this.f12233h, this.f12234i);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            h hVar = this.f12233h.get(str);
            return hVar != null && hVar.b();
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            h hVar = this.f12233h.get(str);
            return hVar != null && hVar.c();
        }
        return invokeL.booleanValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < this.k) {
            return;
        }
        this.k = i2;
        t.g().putInt("ubc_data_expire_time", i2);
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || i2 < this.l) {
            return;
        }
        this.l = i2;
        t.g().putInt("ubc_database_limit", i2);
    }

    public void p(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (i3 = i2 * 60000) < this.f12235j) {
            return;
        }
        this.f12235j = i3;
    }

    public void q(List<g> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            for (g gVar : list) {
                if ("0".equals(gVar.f12242b)) {
                    this.f12227b.add(gVar.f12241a);
                } else {
                    this.f12227b.remove(gVar.f12241a);
                }
                if ("1".equals(gVar.f12243c)) {
                    this.f12228c.add(gVar.f12241a);
                } else {
                    this.f12228c.remove(gVar.f12241a);
                }
                if ("1".equals(gVar.f12246f)) {
                    this.f12229d.add(gVar.f12241a);
                } else {
                    this.f12229d.remove(gVar.f12241a);
                }
                int i3 = gVar.f12247g;
                if (i3 >= 1 && i3 <= 100) {
                    this.f12231f.put(gVar.f12241a, String.valueOf(i3));
                } else {
                    this.f12231f.remove(gVar.f12241a);
                }
                if (!TextUtils.isEmpty(gVar.f12248h)) {
                    this.f12232g.put(gVar.f12241a, gVar.f12248h);
                } else {
                    this.f12232g.remove(gVar.f12241a);
                }
                int i4 = gVar.f12250j;
                if (i4 != 0 && (i2 = gVar.f12249i) != 0) {
                    h hVar = new h(gVar.f12241a, i4, i2);
                    this.f12233h.put(hVar.a(), hVar);
                }
                if (TextUtils.equals(gVar.k, "1")) {
                    this.f12234i.add(gVar.f12241a);
                } else {
                    this.f12234i.remove(gVar.f12241a);
                }
            }
        }
    }
}
