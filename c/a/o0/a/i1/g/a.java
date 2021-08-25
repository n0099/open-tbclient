package c.a.o0.a.i1.g;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.c1.d.j;
import c.a.o0.a.k;
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
public class a implements c.a.o0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f6809h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f6810a;

    /* renamed from: b  reason: collision with root package name */
    public String f6811b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.a.i1.g.c f6812c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6813d;

    /* renamed from: e  reason: collision with root package name */
    public Context f6814e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6815f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.a.i1.g.b f6816g;

    /* renamed from: c.a.o0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0266a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6817a;

        public C0266a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6817a = aVar;
        }

        @Override // c.a.o0.a.c1.d.j.a
        public void b(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6817a.f6816g == null) {
                return;
            }
            this.f6817a.f6816g.b(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6818a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6818a = aVar;
        }

        @Override // c.a.o0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f6818a.f6816g != null && this.f6818a.f6816g.f(jVar, i2, i3) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6819a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6819a = aVar;
        }

        @Override // c.a.o0.a.c1.d.j.d
        public void e(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6819a.f6816g == null) {
                return;
            }
            this.f6819a.f6816g.e(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6820a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6820a = aVar;
        }

        @Override // c.a.o0.a.c1.d.j.e
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6820a.f6816g == null) {
                return;
            }
            this.f6820a.f6816g.a(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6821a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6821a = aVar;
        }

        @Override // c.a.o0.a.c1.d.j.f
        public void d(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6821a.f6816g == null) {
                return;
            }
            this.f6821a.f6816g.d(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6822a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6822a = aVar;
        }

        @Override // c.a.o0.a.c1.d.j.c
        public void c(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6822a.f6816g == null) {
                return;
            }
            this.f6822a.f6816g.c(jVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1873918771, "Lc/a/o0/a/i1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1873918771, "Lc/a/o0/a/i1/g/a;");
                return;
            }
        }
        f6809h = k.f7049a;
    }

    public a(Context context, @NonNull c.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6815f = true;
        this.f6814e = context;
        this.f6812c = cVar;
        this.f6811b = cVar.n;
        h();
        d();
    }

    @Override // c.a.o0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6812c.f4630g : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6811b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f6811b)) {
            return;
        }
        c.a.o0.a.i1.b.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.o0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.o0.a.i1.g.c cVar = this.f6812c;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    public c.a.o0.a.i1.g.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6812c : (c.a.o0.a.i1.g.c) invokeV.objValue;
    }

    public j h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f6810a == null) {
                c.a.o0.a.e0.d.g("video", "create player");
                j r0 = c.a.o0.a.c1.a.r0();
                r0.e(this.f6814e, this.f6812c);
                this.f6810a = r0;
                r0.g(new C0266a(this));
                this.f6810a.p(new b(this));
                this.f6810a.m(new c(this));
                this.f6810a.j(new d(this));
                this.f6810a.k(new e(this));
                this.f6810a.q(new f(this));
            }
            return this.f6810a;
        }
        return (j) invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.o0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f6815f = z;
            if (z) {
                if (this.f6813d) {
                    h().resume();
                }
                h().b();
            } else if (this.f6810a != null) {
                this.f6813d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.f6810a) == null) {
            return;
        }
        jVar.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j jVar = this.f6810a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j jVar = this.f6810a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(c.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            c.a.o0.a.e0.d.g("video", "Open Player " + cVar.n);
            j jVar = this.f6810a;
            if (jVar != null) {
                jVar.o(cVar);
            }
            this.f6812c = cVar;
        }
    }

    @Override // c.a.o0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.o0.a.e0.d.g("video", "onBackPressed");
            j jVar = this.f6810a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.o0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
            j jVar = this.f6810a;
            if (jVar != null) {
                jVar.stop();
                this.f6810a = null;
            }
            c.a.o0.a.i1.b.j(this);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && z()) {
            h().pause();
        }
    }

    public void q(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (jVar = this.f6810a) == null) {
            return;
        }
        jVar.i(str);
    }

    public void r() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && z() && !n() && this.f6815f && (jVar = this.f6810a) != null) {
            jVar.resume();
        }
    }

    public void s(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && z() && (jVar = this.f6810a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (jVar = this.f6810a) == null) {
            return;
        }
        jVar.l(z, i2);
    }

    public void u(c.a.o0.a.i1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f6816g = bVar;
        }
    }

    public void v(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (jVar = this.f6810a) == null) {
            return;
        }
        jVar.d(z);
    }

    public void w(FrameLayout frameLayout) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frameLayout) == null) || (jVar = this.f6810a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    public void x(c.a.o0.a.i1.g.c cVar) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || (jVar = this.f6810a) == null) {
            return;
        }
        jVar.n(cVar);
    }

    public void y(c.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            boolean z = f6809h;
            j jVar = this.f6810a;
            if (jVar != null) {
                jVar.h(cVar, true);
            }
            this.f6812c = cVar;
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            c.a.o0.a.i1.g.c cVar = this.f6812c;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f6811b) || TextUtils.isEmpty(this.f6812c.f4629f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
