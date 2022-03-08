package c.a.t0;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g s;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f26006b;

    /* renamed from: c  reason: collision with root package name */
    public int f26007c;

    /* renamed from: d  reason: collision with root package name */
    public int f26008d;

    /* renamed from: e  reason: collision with root package name */
    public int f26009e;

    /* renamed from: f  reason: collision with root package name */
    public int f26010f;

    /* renamed from: g  reason: collision with root package name */
    public int f26011g;

    /* renamed from: h  reason: collision with root package name */
    public int f26012h;

    /* renamed from: i  reason: collision with root package name */
    public int f26013i;

    /* renamed from: j  reason: collision with root package name */
    public int f26014j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public long o;
    public boolean p;
    public f q;
    public h0 r;

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
        this.f26009e = 614400;
        this.f26010f = 153600;
        this.f26011g = 614400;
        this.f26012h = 614400;
        this.f26013i = 100;
        this.f26014j = 180;
        this.k = false;
        this.l = 819200;
        this.m = 60;
        this.n = false;
        this.o = 0L;
        this.p = false;
        this.q = new f();
        this.r = new h0();
    }

    public static g o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (s == null) {
                synchronized (e.class) {
                    if (s == null) {
                        s = new g();
                    }
                }
            }
            return s;
        }
        return (g) invokeV.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26013i : invokeV.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26014j : invokeV.intValue;
    }

    public int C(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!this.q.n.containsKey(str) || (num = this.q.n.get(str)) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public void D(c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, context) == null) {
            this.a = context;
            this.f26006b = 60000;
            k0 a = k0.a();
            this.f26007c = a.b("ubc_data_expire_time", 604800000);
            this.f26008d = a.b("ubc_database_limit", 10000);
            cVar.n().y(this.q);
            this.f26009e = a.b("ubc_launch_upload_max_limit", 614400);
            this.f26010f = a.b("ubc_single_log_max_limit", 153600);
            this.f26011g = a.b("ubc_real_upload_max_limit", 614400);
            this.f26012h = a.b("ubc_non_real_upload_max_limit", 614400);
            this.f26013i = a.b("ubc_upload_trigger_num", 100);
            this.f26014j = a.b("ubc_upload_trigger_time", 180);
            this.k = b0.i().q();
            this.l = b0.i().g();
            this.m = b0.i().b();
            this.n = b0.i().i();
            this.p = b0.i().l();
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q i2 = b0.i();
            if (i2 != null) {
                return i2.n();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            HashMap<String, l> hashMap = this.q.f26003j;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.q.f26003j.get(str).a();
        }
        return invokeL.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q.a.f26063b : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q.a.f26065d : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            HashMap<String, l> hashMap = this.q.f26003j;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.q.f26003j.get(str).b();
        }
        return invokeL.booleanValue;
    }

    public boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Context context = this.a;
            return context == null || L(context) || !c(str);
        }
        return invokeL.booleanValue;
    }

    public boolean L(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.q.f25996c.contains(str) : invokeL.booleanValue;
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || i2 < 604800000) {
            return;
        }
        this.f26007c = i2;
        k0.a().d("ubc_data_expire_time", i2);
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 < 10000) {
            return;
        }
        this.f26008d = i2;
        k0.a().d("ubc_database_limit", i2);
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || i2 < 153600) {
            return;
        }
        this.f26009e = i2;
        k0.a().d("ubc_launch_upload_max_limit", i2);
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 < 153600) {
            return;
        }
        this.f26012h = i2;
        k0.a().d("ubc_non_real_upload_max_limit", i2);
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 < 153600) {
            return;
        }
        this.f26011g = i2;
        k0.a().d("ubc_real_upload_max_limit", i2);
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || i2 < 30720) {
            return;
        }
        this.f26010f = i2;
        k0.a().d("ubc_single_log_max_limit", i2);
    }

    public void V(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || i2 < 1) {
            return;
        }
        this.f26006b = i2 * 60000;
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f26013i = i2;
        k0.a().d("ubc_upload_trigger_num", i2);
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f26014j = i2;
        k0.a().d("ubc_upload_trigger_time", i2);
    }

    public void Y(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            for (j jVar : list) {
                String c2 = jVar.c();
                if (!TextUtils.isEmpty(c2)) {
                    if (!jVar.s()) {
                        this.q.f25995b.add(c2);
                        this.q.f25999f.remove(c2);
                    } else {
                        this.q.f25995b.remove(c2);
                        this.q.f25999f.add(c2);
                    }
                    if (jVar.o()) {
                        this.q.f25996c.add(c2);
                        this.q.f25997d.remove(c2);
                    } else {
                        this.q.f25996c.remove(c2);
                        this.q.f25997d.add(c2);
                    }
                    if (jVar.k()) {
                        this.q.f25998e.add(c2);
                    } else {
                        this.q.f25998e.remove(c2);
                    }
                    if (jVar.n()) {
                        this.q.f26000g.add(c2);
                    } else {
                        this.q.f26000g.remove(c2);
                    }
                    int g2 = jVar.g();
                    if (g2 >= 1 && g2 <= 100) {
                        this.q.f26001h.put(c2, Integer.valueOf(g2));
                    } else {
                        this.q.f26001h.remove(c2);
                    }
                    String a = jVar.a();
                    if (!TextUtils.isEmpty(a)) {
                        this.q.f26002i.put(c2, a);
                    } else {
                        this.q.f26002i.remove(c2);
                    }
                    int d2 = jVar.d();
                    int e2 = jVar.e();
                    if (d2 != 0 && e2 != 0) {
                        this.q.f26003j.put(c2, new l(c2, e2, d2));
                    }
                    if (jVar.m()) {
                        this.q.k.add(c2);
                    } else {
                        this.q.k.remove(c2);
                    }
                    if (jVar.p()) {
                        this.q.l.add(c2);
                    } else {
                        this.q.l.remove(c2);
                    }
                    int b2 = jVar.b();
                    if (jVar.r()) {
                        this.q.m.put(c2, Integer.valueOf(b2));
                    } else {
                        this.q.m.remove(c2);
                    }
                    if (jVar.t()) {
                        this.q.n.remove(c2);
                    } else {
                        this.q.n.put(c2, Integer.valueOf(jVar.i()));
                    }
                    int f2 = jVar.f();
                    if (f2 != 2) {
                        this.q.o.put(c2, Integer.valueOf(f2));
                    } else {
                        this.q.o.remove(c2);
                    }
                }
            }
        }
    }

    public void Z(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) || this.o >= j2) {
            return;
        }
        this.o = j2;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? this.q.f25998e.contains(str) : invokeL.booleanValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!this.q.o.containsKey(str) || (num = this.q.o.get(str)) == null) {
                return 2;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? this.q.f26000g.contains(str) : invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? C(str) == 0 : invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (this.r.isUBCDebug() || this.q.f25996c.contains(str)) {
                return true;
            }
            return this.q.a.f26063b;
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) ? this.q.l.contains(str) : invokeL.booleanValue;
    }

    public boolean g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, str, i2)) == null) {
            if (this.q.f25995b.contains(str)) {
                return false;
            }
            if ((i2 & 16) != 0 || (i2 & 32) != 0) {
                return this.q.f25999f.contains(str);
            } else if (this.q.f25999f.contains(str)) {
                return true;
            } else {
                return this.q.a.a;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (!E() && this.r.isUBCSample() && y(str) > 0) {
                if (new Random().nextInt(100) >= y(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (this.q.f25995b.contains(str)) {
                return false;
            }
            if (this.q.f25999f.contains(str)) {
                return true;
            }
            return this.q.a.f26065d;
        }
        return invokeL.booleanValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) ? this.q.f26002i.containsKey(str) ? this.q.f26002i.get(str) : "" : (String) invokeL.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f26007c : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f26008d : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.q.a.f26064c : invokeV.intValue;
    }

    public int n(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            if (!this.q.m.containsKey(str) || (num = this.q.m.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f26009e : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f26012h : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f26011g : invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f26010f : invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f26006b : invokeV.intValue;
    }

    public HashSet<String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.q.f25997d : (HashSet) invokeV.objValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.o : invokeV.longValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.m : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l : invokeV.intValue;
    }

    public int y(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !this.q.f26001h.containsKey(str) || (num = this.q.f26001h.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public String z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) ? !TextUtils.isEmpty(str) ? (this.q.k.contains(str) || TextUtils.equals(str, "1876") || TextUtils.equals(str, "2980")) ? "1" : "0" : "0" : (String) invokeL.objValue;
    }
}
