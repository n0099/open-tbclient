package c.a.p0.r;

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
    public Context f12254a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f12255b;

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f12256c;

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<String> f12257d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f12258e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f12259f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f12260g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, h> f12261h;

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f12262i;

    /* renamed from: j  reason: collision with root package name */
    public int f12263j;
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
        this.f12255b = new HashSet<>();
        this.f12256c = new HashSet<>();
        this.f12257d = new HashSet<>();
        this.f12258e = new HashSet<>();
        this.f12259f = new HashMap<>();
        this.f12260g = new HashMap<>();
        this.f12261h = new HashMap<>();
        this.f12262i = new HashSet<>();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f12257d.contains(str) : invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (e.h().s()) {
                return true;
            }
            return this.f12256c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            if (this.f12255b.contains(str)) {
                return false;
            }
            if ((i2 & 16) == 0 && (i2 & 32) == 0) {
                return true;
            }
            return this.f12258e.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f12260g.containsKey(str) ? this.f12260g.get(str) : "" : (String) invokeL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12263j : invokeV.intValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (e.h().r() || TextUtils.isEmpty(str) || !this.f12259f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f12259f.get(str));
        }
        return invokeL.intValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (TextUtils.isEmpty(str) || !this.f12262i.contains(str)) ? "0" : "1" : (String) invokeL.objValue;
    }

    public void k(c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, context) == null) {
            this.f12254a = context;
            this.f12263j = 360000;
            t g2 = t.g();
            this.k = g2.getInt("ubc_data_expire_time", 259200000);
            this.l = g2.getInt("ubc_database_limit", 4000);
            cVar.e().w(this.f12255b, this.f12258e, this.f12256c, this.f12257d, this.f12259f, this.f12260g, this.f12261h, this.f12262i);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            h hVar = this.f12261h.get(str);
            return hVar != null && hVar.b();
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            h hVar = this.f12261h.get(str);
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
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (i3 = i2 * 60000) < this.f12263j) {
            return;
        }
        this.f12263j = i3;
    }

    public void q(List<g> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            for (g gVar : list) {
                if ("0".equals(gVar.f12270b)) {
                    this.f12255b.add(gVar.f12269a);
                } else {
                    this.f12255b.remove(gVar.f12269a);
                }
                if ("1".equals(gVar.f12271c)) {
                    this.f12256c.add(gVar.f12269a);
                } else {
                    this.f12256c.remove(gVar.f12269a);
                }
                if ("1".equals(gVar.f12274f)) {
                    this.f12257d.add(gVar.f12269a);
                } else {
                    this.f12257d.remove(gVar.f12269a);
                }
                int i3 = gVar.f12275g;
                if (i3 >= 1 && i3 <= 100) {
                    this.f12259f.put(gVar.f12269a, String.valueOf(i3));
                } else {
                    this.f12259f.remove(gVar.f12269a);
                }
                if (!TextUtils.isEmpty(gVar.f12276h)) {
                    this.f12260g.put(gVar.f12269a, gVar.f12276h);
                } else {
                    this.f12260g.remove(gVar.f12269a);
                }
                int i4 = gVar.f12278j;
                if (i4 != 0 && (i2 = gVar.f12277i) != 0) {
                    h hVar = new h(gVar.f12269a, i4, i2);
                    this.f12261h.put(hVar.a(), hVar);
                }
                if (TextUtils.equals(gVar.k, "1")) {
                    this.f12262i.add(gVar.f12269a);
                } else {
                    this.f12262i.remove(gVar.f12269a);
                }
            }
        }
    }
}
