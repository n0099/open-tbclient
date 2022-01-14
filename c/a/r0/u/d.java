package c.a.r0.u;

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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f11812b;

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f11813c;

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<String> f11814d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f11815e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f11816f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f11817g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, h> f11818h;

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f11819i;

    /* renamed from: j  reason: collision with root package name */
    public int f11820j;
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
        this.f11812b = new HashSet<>();
        this.f11813c = new HashSet<>();
        this.f11814d = new HashSet<>();
        this.f11815e = new HashSet<>();
        this.f11816f = new HashMap<>();
        this.f11817g = new HashMap<>();
        this.f11818h = new HashMap<>();
        this.f11819i = new HashSet<>();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f11814d.contains(str) : invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (e.g().s()) {
                return true;
            }
            return this.f11813c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            if (this.f11812b.contains(str)) {
                return false;
            }
            if ((i2 & 16) == 0 && (i2 & 32) == 0) {
                return true;
            }
            return this.f11815e.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f11817g.containsKey(str) ? this.f11817g.get(str) : "" : (String) invokeL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11820j : invokeV.intValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (e.g().r() || TextUtils.isEmpty(str) || !this.f11816f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f11816f.get(str));
        }
        return invokeL.intValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (TextUtils.isEmpty(str) || !this.f11819i.contains(str)) ? "0" : "1" : (String) invokeL.objValue;
    }

    public void k(c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, context) == null) {
            this.a = context;
            this.f11820j = 360000;
            t f2 = t.f();
            this.k = f2.getInt("ubc_data_expire_time", 259200000);
            this.l = f2.getInt("ubc_database_limit", 4000);
            cVar.e().w(this.f11812b, this.f11815e, this.f11813c, this.f11814d, this.f11816f, this.f11817g, this.f11818h, this.f11819i);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            h hVar = this.f11818h.get(str);
            return hVar != null && hVar.b();
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            h hVar = this.f11818h.get(str);
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
        t.f().putInt("ubc_data_expire_time", i2);
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || i2 < this.l) {
            return;
        }
        this.l = i2;
        t.f().putInt("ubc_database_limit", i2);
    }

    public void p(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (i3 = i2 * 60000) < this.f11820j) {
            return;
        }
        this.f11820j = i3;
    }

    public void q(List<g> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            for (g gVar : list) {
                if ("0".equals(gVar.f11824b)) {
                    this.f11812b.add(gVar.a);
                } else {
                    this.f11812b.remove(gVar.a);
                }
                if ("1".equals(gVar.f11825c)) {
                    this.f11813c.add(gVar.a);
                } else {
                    this.f11813c.remove(gVar.a);
                }
                if ("1".equals(gVar.f11828f)) {
                    this.f11814d.add(gVar.a);
                } else {
                    this.f11814d.remove(gVar.a);
                }
                int i3 = gVar.f11829g;
                if (i3 >= 1 && i3 <= 100) {
                    this.f11816f.put(gVar.a, String.valueOf(i3));
                } else {
                    this.f11816f.remove(gVar.a);
                }
                if (!TextUtils.isEmpty(gVar.f11830h)) {
                    this.f11817g.put(gVar.a, gVar.f11830h);
                } else {
                    this.f11817g.remove(gVar.a);
                }
                int i4 = gVar.f11832j;
                if (i4 != 0 && (i2 = gVar.f11831i) != 0) {
                    h hVar = new h(gVar.a, i4, i2);
                    this.f11818h.put(hVar.a(), hVar);
                }
                if (TextUtils.equals(gVar.k, "1")) {
                    this.f11819i.add(gVar.a);
                } else {
                    this.f11819i.remove(gVar.a);
                }
            }
        }
    }
}
