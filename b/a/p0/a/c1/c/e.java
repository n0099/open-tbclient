package b.a.p0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c1.d.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class e implements b.a.p0.f.i.m.b.c, b.a.p0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.c1.d.j f4134a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.f.i.l.e f4135b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4136c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.i1.g.c f4137d;

    /* renamed from: e  reason: collision with root package name */
    public String f4138e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4139f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4140g;

    /* loaded from: classes.dex */
    public class a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4141a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4141a = eVar;
        }

        @Override // b.a.p0.a.c1.d.j.a
        public void b(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4141a.f4135b == null) {
                return;
            }
            this.f4141a.f4135b.onCompletion();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4142a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4142a = eVar;
        }

        @Override // b.a.p0.a.c1.d.j.b
        public boolean f(b.a.p0.a.c1.d.j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f4142a.f4135b != null && this.f4142a.f4135b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4143a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4143a = eVar;
        }

        @Override // b.a.p0.a.c1.d.j.d
        public void e(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4143a.f4135b == null) {
                return;
            }
            this.f4143a.f4135b.onPrepared();
        }
    }

    /* loaded from: classes.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4144a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4144a = eVar;
        }

        @Override // b.a.p0.a.c1.d.j.e
        public void a(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4144a.f4135b == null) {
                return;
            }
            this.f4144a.f4135b.onResume();
        }
    }

    /* renamed from: b.a.p0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0125e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4145a;

        public C0125e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4145a = eVar;
        }

        @Override // b.a.p0.a.c1.d.j.f
        public void d(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4145a.f4135b == null) {
                return;
            }
            this.f4145a.f4135b.onStart();
        }
    }

    /* loaded from: classes.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4146a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4146a = eVar;
        }

        @Override // b.a.p0.a.c1.d.j.c
        public void c(b.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4146a.f4135b == null) {
                return;
            }
            this.f4146a.f4135b.onPause();
        }
    }

    public e() {
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
        this.f4139f = true;
    }

    @Override // b.a.p0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        b.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (jVar = this.f4134a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    @Override // b.a.p0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4137d.f4057g : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4138e : (String) invokeV.objValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public void d(boolean z) {
        b.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jVar = this.f4134a) == null) {
            return;
        }
        jVar.d(z);
    }

    @Override // b.a.p0.f.i.m.b.c
    public /* bridge */ /* synthetic */ b.a.p0.f.i.m.b.c e(Context context, @NonNull b.a.p0.f.i.j.a aVar) {
        n(context, aVar);
        return this;
    }

    @Override // b.a.p0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.p0.a.i1.g.c cVar = this.f4137d;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public void g(b.a.p0.f.i.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f4135b = eVar;
        }
    }

    @Override // b.a.p0.f.i.m.b.c
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public void h(b.a.p0.f.i.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            b.a.p0.a.i1.g.c p = p(aVar);
            this.f4137d = p;
            b.a.p0.a.c1.d.j jVar = this.f4134a;
            if (jVar != null) {
                jVar.o(p);
            }
        }
    }

    @Override // b.a.p0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b.a.p0.a.c1.d.j jVar = this.f4134a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b.a.p0.a.c1.d.j jVar = this.f4134a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // b.a.p0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f4139f = z;
            if (this.f4134a == null) {
                return;
            }
            if (z) {
                if (this.f4140g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.f4140g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.f4138e)) {
            return;
        }
        b.a.p0.a.i1.b.a(this);
    }

    @Override // b.a.p0.f.i.m.b.c
    public void mute(boolean z) {
        b.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (jVar = this.f4134a) == null) {
            return;
        }
        jVar.mute(z);
    }

    public e n(Context context, @NonNull b.a.p0.f.i.j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, aVar)) == null) {
            this.f4136c = context;
            b.a.p0.a.i1.g.c p = p(aVar);
            this.f4137d = p;
            this.f4138e = p.n;
            o();
            m();
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public b.a.p0.a.c1.d.j o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f4134a == null) {
                b.a.p0.a.c1.d.j r0 = b.a.p0.a.c1.a.r0();
                r0.e(this.f4136c, this.f4137d);
                this.f4134a = r0;
                r0.g(new a(this));
                this.f4134a.p(new b(this));
                this.f4134a.m(new c(this));
                this.f4134a.j(new d(this));
                this.f4134a.k(new C0125e(this));
                this.f4134a.q(new f(this));
            }
            return this.f4134a;
        }
        return (b.a.p0.a.c1.d.j) invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            b.a.p0.a.c1.d.j jVar = this.f4134a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.p0.a.c1.d.j jVar = this.f4134a;
            if (jVar != null) {
                jVar.stop();
                this.f4134a = null;
            }
            b.a.p0.a.i1.b.j(this);
        }
    }

    public b.a.p0.a.i1.g.c p(b.a.p0.f.i.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, aVar)) == null) {
            b.a.p0.a.i1.g.c cVar = new b.a.p0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f4056f = "SwanAdPlayer";
            cVar.s = aVar.f9775f;
            cVar.o = aVar.f9771b;
            cVar.B = aVar.o;
            cVar.M = aVar.z;
            cVar.I = aVar.v;
            cVar.C = aVar.p;
            return cVar;
        }
        return (b.a.p0.a.i1.g.c) invokeL.objValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && q()) {
            o().pause();
        }
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            b.a.p0.a.i1.g.c cVar = this.f4137d;
            return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.f.i.m.b.c
    public void resume() {
        b.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f4139f && (jVar = this.f4134a) != null) {
            jVar.resume();
        }
    }

    @Override // b.a.p0.f.i.m.b.c
    public void stop() {
        b.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (jVar = this.f4134a) == null) {
            return;
        }
        jVar.stop();
        this.f4134a = null;
    }
}
