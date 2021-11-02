package b.a.p0.r;

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
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f11443a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f11444b;

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f11445c;

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<String> f11446d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f11447e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f11448f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f11449g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, h> f11450h;

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f11451i;
    public int j;
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
        this.f11444b = new HashSet<>();
        this.f11445c = new HashSet<>();
        this.f11446d = new HashSet<>();
        this.f11447e = new HashSet<>();
        this.f11448f = new HashMap<>();
        this.f11449g = new HashMap<>();
        this.f11450h = new HashMap<>();
        this.f11451i = new HashSet<>();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f11446d.contains(str) : invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (e.g().s()) {
                return true;
            }
            return this.f11445c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            if (this.f11444b.contains(str)) {
                return false;
            }
            if ((i2 & 16) == 0 && (i2 & 32) == 0) {
                return true;
            }
            return this.f11447e.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f11449g.containsKey(str) ? this.f11449g.get(str) : "" : (String) invokeL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (e.g().r() || TextUtils.isEmpty(str) || !this.f11448f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f11448f.get(str));
        }
        return invokeL.intValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (TextUtils.isEmpty(str) || !this.f11451i.contains(str)) ? "0" : "1" : (String) invokeL.objValue;
    }

    public void k(c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, context) == null) {
            this.f11443a = context;
            this.j = 360000;
            t g2 = t.g();
            this.k = g2.getInt("ubc_data_expire_time", 259200000);
            this.l = g2.getInt("ubc_database_limit", 4000);
            cVar.e().w(this.f11444b, this.f11447e, this.f11445c, this.f11446d, this.f11448f, this.f11449g, this.f11450h, this.f11451i);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            h hVar = this.f11450h.get(str);
            return hVar != null && hVar.b();
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            h hVar = this.f11450h.get(str);
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
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (i3 = i2 * 60000) < this.j) {
            return;
        }
        this.j = i3;
    }

    public void q(List<g> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            for (g gVar : list) {
                if ("0".equals(gVar.f11458b)) {
                    this.f11444b.add(gVar.f11457a);
                } else {
                    this.f11444b.remove(gVar.f11457a);
                }
                if ("1".equals(gVar.f11459c)) {
                    this.f11445c.add(gVar.f11457a);
                } else {
                    this.f11445c.remove(gVar.f11457a);
                }
                if ("1".equals(gVar.f11462f)) {
                    this.f11446d.add(gVar.f11457a);
                } else {
                    this.f11446d.remove(gVar.f11457a);
                }
                int i3 = gVar.f11463g;
                if (i3 >= 1 && i3 <= 100) {
                    this.f11448f.put(gVar.f11457a, String.valueOf(i3));
                } else {
                    this.f11448f.remove(gVar.f11457a);
                }
                if (!TextUtils.isEmpty(gVar.f11464h)) {
                    this.f11449g.put(gVar.f11457a, gVar.f11464h);
                } else {
                    this.f11449g.remove(gVar.f11457a);
                }
                int i4 = gVar.j;
                if (i4 != 0 && (i2 = gVar.f11465i) != 0) {
                    h hVar = new h(gVar.f11457a, i4, i2);
                    this.f11450h.put(hVar.a(), hVar);
                }
                if (TextUtils.equals(gVar.k, "1")) {
                    this.f11451i.add(gVar.f11457a);
                } else {
                    this.f11451i.remove(gVar.f11457a);
                }
            }
        }
    }
}
