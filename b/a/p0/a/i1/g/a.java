package b.a.p0.a.i1.g;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c1.d.j;
import b.a.p0.a.k;
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
public class a implements b.a.p0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f6163h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f6164a;

    /* renamed from: b  reason: collision with root package name */
    public String f6165b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.i1.g.c f6166c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6167d;

    /* renamed from: e  reason: collision with root package name */
    public Context f6168e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6169f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.a.i1.g.b f6170g;

    /* renamed from: b.a.p0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0263a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6171a;

        public C0263a(a aVar) {
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
            this.f6171a = aVar;
        }

        @Override // b.a.p0.a.c1.d.j.a
        public void b(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6171a.f6170g == null) {
                return;
            }
            this.f6171a.f6170g.b(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6172a;

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
            this.f6172a = aVar;
        }

        @Override // b.a.p0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f6172a.f6170g != null && this.f6172a.f6170g.f(jVar, i2, i3) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6173a;

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
            this.f6173a = aVar;
        }

        @Override // b.a.p0.a.c1.d.j.d
        public void e(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6173a.f6170g == null) {
                return;
            }
            this.f6173a.f6170g.e(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6174a;

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
            this.f6174a = aVar;
        }

        @Override // b.a.p0.a.c1.d.j.e
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6174a.f6170g == null) {
                return;
            }
            this.f6174a.f6170g.a(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6175a;

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
            this.f6175a = aVar;
        }

        @Override // b.a.p0.a.c1.d.j.f
        public void d(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6175a.f6170g == null) {
                return;
            }
            this.f6175a.f6170g.d(jVar);
        }
    }

    /* loaded from: classes.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6176a;

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
            this.f6176a = aVar;
        }

        @Override // b.a.p0.a.c1.d.j.c
        public void c(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f6176a.f6170g == null) {
                return;
            }
            this.f6176a.f6170g.c(jVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781431629, "Lb/a/p0/a/i1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781431629, "Lb/a/p0/a/i1/g/a;");
                return;
            }
        }
        f6163h = k.f6397a;
    }

    public a(Context context, @NonNull b.a.p0.a.i1.g.c cVar) {
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
        this.f6169f = true;
        this.f6168e = context;
        this.f6166c = cVar;
        this.f6165b = cVar.n;
        h();
        d();
    }

    @Override // b.a.p0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6166c.f4057g : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6165b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f6165b)) {
            return;
        }
        b.a.p0.a.i1.b.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // b.a.p0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.p0.a.i1.g.c cVar = this.f6166c;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    public b.a.p0.a.i1.g.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6166c : (b.a.p0.a.i1.g.c) invokeV.objValue;
    }

    public j h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f6164a == null) {
                b.a.p0.a.e0.d.g("video", "create player");
                j r0 = b.a.p0.a.c1.a.r0();
                r0.e(this.f6168e, this.f6166c);
                this.f6164a = r0;
                r0.g(new C0263a(this));
                this.f6164a.p(new b(this));
                this.f6164a.m(new c(this));
                this.f6164a.j(new d(this));
                this.f6164a.k(new e(this));
                this.f6164a.q(new f(this));
            }
            return this.f6164a;
        }
        return (j) invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // b.a.p0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f6169f = z;
            if (z) {
                if (this.f6167d) {
                    h().resume();
                }
                h().b();
            } else if (this.f6164a != null) {
                this.f6167d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.f6164a) == null) {
            return;
        }
        jVar.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j jVar = this.f6164a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j jVar = this.f6164a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            b.a.p0.a.e0.d.g("video", "Open Player " + cVar.n);
            j jVar = this.f6164a;
            if (jVar != null) {
                jVar.o(cVar);
            }
            this.f6166c = cVar;
        }
    }

    @Override // b.a.p0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            b.a.p0.a.e0.d.g("video", "onBackPressed");
            j jVar = this.f6164a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b.a.p0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
            j jVar = this.f6164a;
            if (jVar != null) {
                jVar.stop();
                this.f6164a = null;
            }
            b.a.p0.a.i1.b.j(this);
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
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (jVar = this.f6164a) == null) {
            return;
        }
        jVar.i(str);
    }

    public void r() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && z() && !n() && this.f6169f && (jVar = this.f6164a) != null) {
            jVar.resume();
        }
    }

    public void s(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && z() && (jVar = this.f6164a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (jVar = this.f6164a) == null) {
            return;
        }
        jVar.l(z, i2);
    }

    public void u(b.a.p0.a.i1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f6170g = bVar;
        }
    }

    public void v(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (jVar = this.f6164a) == null) {
            return;
        }
        jVar.d(z);
    }

    public void w(FrameLayout frameLayout) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frameLayout) == null) || (jVar = this.f6164a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    public void x(b.a.p0.a.i1.g.c cVar) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || (jVar = this.f6164a) == null) {
            return;
        }
        jVar.n(cVar);
    }

    public void y(b.a.p0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            boolean z = f6163h;
            j jVar = this.f6164a;
            if (jVar != null) {
                jVar.h(cVar, true);
            }
            this.f6166c = cVar;
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            b.a.p0.a.i1.g.c cVar = this.f6166c;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f6165b) || TextUtils.isEmpty(this.f6166c.f4056f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
