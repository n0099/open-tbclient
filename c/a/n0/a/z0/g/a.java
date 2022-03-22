package c.a.n0.a.z0.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s0.d.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements c.a.n0.a.z0.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f7948h;
    public transient /* synthetic */ FieldHolder $fh;
    public k a;

    /* renamed from: b  reason: collision with root package name */
    public String f7949b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.z0.g.c f7950c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7951d;

    /* renamed from: e  reason: collision with root package name */
    public Context f7952e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7953f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.z0.g.b f7954g;

    /* renamed from: c.a.n0.a.z0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0612a implements k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0612a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.s0.d.k.a
        public void b(k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f7954g == null) {
                return;
            }
            this.a.f7954g.b(kVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.s0.d.k.b
        public boolean f(k kVar, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, kVar, i, i2)) == null) ? this.a.f7954g != null && this.a.f7954g.f(kVar, i, i2) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements k.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.s0.d.k.d
        public void e(k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f7954g == null) {
                return;
            }
            this.a.f7954g.e(kVar);
        }
    }

    /* loaded from: classes.dex */
    public class d implements k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.s0.d.k.e
        public void a(k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f7954g == null) {
                return;
            }
            this.a.f7954g.a(kVar);
        }
    }

    /* loaded from: classes.dex */
    public class e implements k.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.s0.d.k.f
        public void d(k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f7954g == null) {
                return;
            }
            this.a.f7954g.d(kVar);
        }
    }

    /* loaded from: classes.dex */
    public class f implements k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.s0.d.k.c
        public void c(k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f7954g == null) {
                return;
            }
            this.a.f7954g.c(kVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-376099706, "Lc/a/n0/a/z0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-376099706, "Lc/a/n0/a/z0/g/a;");
                return;
            }
        }
        f7948h = c.a.n0.a.a.a;
    }

    public a(Context context, @NonNull c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7953f = true;
        this.f7952e = context;
        this.f7950c = cVar;
        this.f7949b = cVar.j;
        h();
        d();
    }

    public void A(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (f7948h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            k kVar = this.a;
            if (kVar != null) {
                kVar.h(cVar, true);
            }
            this.f7950c = cVar;
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.z0.g.c cVar = this.f7950c;
            return (cVar == null || TextUtils.isEmpty(cVar.y) || TextUtils.isEmpty(this.f7949b) || TextUtils.isEmpty(this.f7950c.f6096b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.z0.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7950c.f6097c : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7949b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TextUtils.isEmpty(this.f7949b)) {
            return;
        }
        c.a.n0.a.z0.b.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.n0.a.z0.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.n0.a.z0.g.c cVar = this.f7950c;
            return cVar != null ? cVar.z : "";
        }
        return (String) invokeV.objValue;
    }

    public c.a.n0.a.z0.g.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f7950c : (c.a.n0.a.z0.g.c) invokeV.objValue;
    }

    public k h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                c.a.n0.a.u.d.i("video", "create player");
                k C0 = c.a.n0.a.s0.a.C0();
                C0.e(this.f7952e, this.f7950c);
                this.a = C0;
                C0.g(new C0612a(this));
                this.a.p(new b(this));
                this.a.m(new c(this));
                this.a.j(new d(this));
                this.a.k(new e(this));
                this.a.r(new f(this));
            }
            return this.a;
        }
        return (k) invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // c.a.n0.a.z0.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f7953f = z;
            if (z) {
                if (this.f7951d) {
                    h().resume();
                }
                h().b();
            } else if (this.a != null) {
                this.f7951d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void l() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            k kVar = this.a;
            return kVar != null && kVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            k kVar = this.a;
            return kVar != null && kVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(c.a.n0.a.z0.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
            c.a.n0.a.u.d.i("video", "Open Player " + cVar.j);
            k kVar = this.a;
            if (kVar != null) {
                kVar.o(cVar);
            }
            this.f7950c = cVar;
        }
    }

    @Override // c.a.n0.a.z0.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.n0.a.u.d.i("video", "onBackPressed");
            k kVar = this.a;
            return kVar != null && kVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.z0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.n0.a.u.d.i("video", MissionEvent.MESSAGE_DESTROY);
            k kVar = this.a;
            if (kVar != null) {
                kVar.stop();
                this.a = null;
            }
            c.a.n0.a.z0.b.k(this);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && B()) {
            h().pause();
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            k kVar = this.a;
            if (kVar != null) {
                return kVar.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.i(str);
    }

    public void s() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f7953f && (kVar = this.a) != null) {
            kVar.resume();
        }
    }

    public void t(int i) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (kVar = this.a) != null) {
            kVar.seekTo(i);
        }
    }

    public void u(boolean z, int i) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.l(z, i);
    }

    public void v(c.a.n0.a.z0.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            this.f7954g = bVar;
        }
    }

    public void w(boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.d(z);
    }

    public void x(FrameLayout frameLayout) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.a(frameLayout);
    }

    public void y() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (kVar = this.a) != null) {
            kVar.seekTo(0);
            this.a.pause();
        }
    }

    public void z(c.a.n0.a.z0.g.c cVar) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, cVar) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.n(cVar);
    }
}
