package c.p.a.e.a;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.a.d;
import c.p.a.e.b.f.r;
import c.p.a.e.b.f.s;
import c.p.a.e.b.f.u;
import c.p.a.e.b.f.w;
import c.p.a.e.b.f.z;
import c.p.a.e.b.p.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public EnqueueType J;
    public int K;
    public int L;
    public boolean M;
    public z N;
    public s O;
    public d.g P;
    public w Q;
    public u R;
    public boolean S;
    public c.p.a.e.b.f.j T;
    public boolean U;
    public JSONObject V;
    public String W;
    public List<r> X;
    public int Y;
    public long Z;

    /* renamed from: a  reason: collision with root package name */
    public Activity f35045a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public Context f35046b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public String f35047c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f35048d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public String f35049e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public String f35050f;
    public int[] f0;

    /* renamed from: g  reason: collision with root package name */
    public String f35051g;

    /* renamed from: h  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f35052h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35053i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35054j;
    public boolean k;
    public boolean l;
    public c.p.a.e.b.f.c m;
    public c.p.a.e.b.f.c n;
    public String o;
    public String p;
    public boolean q;
    public c.p.a.e.b.g.i r;
    public c.p.a.e.b.g.j s;
    public c.p.a.e.b.g.s t;
    public a u;
    public boolean v;
    public boolean w;
    public String x;
    public String y;
    public long z;

    public i(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35053i = true;
        this.f35054j = false;
        this.k = true;
        this.l = false;
        this.p = "application/vnd.android.package-archive";
        this.B = 5;
        this.F = true;
        this.J = EnqueueType.ENQUEUE_NONE;
        this.K = 150;
        this.M = true;
        this.X = new ArrayList();
        this.c0 = true;
        this.d0 = true;
        this.f35046b = context.getApplicationContext();
        this.f35047c = str;
    }

    public Activity A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35045a : (Activity) invokeV.objValue;
    }

    public c.p.a.e.b.f.c A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (c.p.a.e.b.f.c) invokeV.objValue;
    }

    public i B(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.z = j2;
            return this;
        }
        return (i) invokeJ.objValue;
    }

    public i B0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.I = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public i C(EnqueueType enqueueType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, enqueueType)) == null) {
            this.J = enqueueType;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public c.p.a.e.b.f.c C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (c.p.a.e.b.f.c) invokeV.objValue;
    }

    public i D(c.p.a.e.b.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
            this.m = cVar;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public i D0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.M = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public i E(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rVar)) == null) {
            synchronized (this.X) {
                if (rVar != null) {
                    if (!this.X.contains(rVar)) {
                        this.X.add(rVar);
                        return this;
                    }
                }
                return this;
            }
        }
        return (i) invokeL.objValue;
    }

    public String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public i F(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, uVar)) == null) {
            this.R = uVar;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public i F0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.A = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public i G(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, wVar)) == null) {
            this.Q = wVar;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public i H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f35049e = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public i H0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.b0 = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public i I(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, list)) == null) {
            this.f35052h = list;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public i J(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, jSONObject)) == null) {
            this.V = jSONObject;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public i J0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.c0 = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public i K(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            this.f35053i = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public a K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.u : (a) invokeV.objValue;
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.a0 = i2;
        }
    }

    public c.p.a.e.b.g.j L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.s : (c.p.a.e.b.g.j) invokeV.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    public c.p.a.e.b.g.i M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.r : (c.p.a.e.b.g.i) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.c0 : invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public List<String> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f35048d : (List) invokeV.objValue;
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.a0 : invokeV.intValue;
    }

    public u Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.R : (u) invokeV.objValue;
    }

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public JSONObject R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.V : (JSONObject) invokeV.objValue;
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public Context S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f35046b : (Context) invokeV.objValue;
    }

    public long S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.z : invokeV.longValue;
    }

    public i T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            this.B = i2;
            return this;
        }
        return (i) invokeI.objValue;
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.B : invokeV.intValue;
    }

    public i U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            this.f35050f = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.C : invokeV.intValue;
    }

    public i V(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, list)) == null) {
            this.f35048d = list;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public i W(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
            this.f35054j = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public i X(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            this.C = i2;
            return this;
        }
        return (i) invokeI.objValue;
    }

    public i Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            this.f35051g = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public i Z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f35047c : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public i b0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
            this.K = i2;
            return this;
        }
        return (i) invokeI.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public i c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public i d0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
            this.q = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public c.p.a.e.b.g.s e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.t : (c.p.a.e.b.g.s) invokeV.objValue;
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f35049e : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.K : invokeV.intValue;
    }

    public i f0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            this.L = i2;
            return this;
        }
        return (i) invokeI.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.L : invokeV.intValue;
    }

    public i g0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public i h0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z)) == null) {
            this.v = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.f35051g : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public i j0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i2)) == null) {
            this.Y = i2;
            return this;
        }
        return (i) invokeI.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public i k0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) {
            this.x = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public EnqueueType l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.J : (EnqueueType) invokeV.objValue;
    }

    public i l0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048646, this, z)) == null) {
            this.w = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public List<com.ss.android.socialbase.downloader.model.c> m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.f35052h : (List) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.f35050f : (String) invokeV.objValue;
    }

    public i n0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
            this.y = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public z o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.N : (z) invokeV.objValue;
    }

    public i o0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048652, this, z)) == null) {
            this.D = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public s p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.O : (s) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.f35053i : invokeV.booleanValue;
    }

    public d.g q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.P : (d.g) invokeV.objValue;
    }

    public i q0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, str)) == null) {
            this.E = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public w r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.Q : (w) invokeV.objValue;
    }

    public i r0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048658, this, z)) == null) {
            this.S = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public c.p.a.e.b.f.j s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.T : (c.p.a.e.b.f.j) invokeV.objValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.f35054j : invokeV.booleanValue;
    }

    public List<r> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.X : (List) invokeV.objValue;
    }

    public i t0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, str)) == null) {
            this.e0 = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public i u0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048664, this, z)) == null) {
            this.F = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.Y : invokeV.intValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.Z : invokeV.longValue;
    }

    public i w0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, str)) == null) {
            this.W = str;
            return this;
        }
        return (i) invokeL.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.d0 : invokeV.booleanValue;
    }

    public i x0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048670, this, z)) == null) {
            this.G = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.e0 : (String) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public int[] z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.f0 : (int[]) invokeV.objValue;
    }

    public i z0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048674, this, z)) == null) {
            this.H = z;
            return this;
        }
        return (i) invokeZ.objValue;
    }
}
