package c.a.o0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.c1.d.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class e implements c.a.o0.f.i.m.b.c, c.a.o0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.c1.d.j f4712a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.f.i.l.e f4713b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4714c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.i1.g.c f4715d;

    /* renamed from: e  reason: collision with root package name */
    public String f4716e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4717f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4718g;

    /* loaded from: classes.dex */
    public class a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4719a;

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
            this.f4719a = eVar;
        }

        @Override // c.a.o0.a.c1.d.j.a
        public void b(c.a.o0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4719a.f4713b == null) {
                return;
            }
            this.f4719a.f4713b.onCompletion();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4720a;

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
            this.f4720a = eVar;
        }

        @Override // c.a.o0.a.c1.d.j.b
        public boolean f(c.a.o0.a.c1.d.j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f4720a.f4713b != null && this.f4720a.f4713b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4721a;

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
            this.f4721a = eVar;
        }

        @Override // c.a.o0.a.c1.d.j.d
        public void e(c.a.o0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4721a.f4713b == null) {
                return;
            }
            this.f4721a.f4713b.onPrepared();
        }
    }

    /* loaded from: classes.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4722a;

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
            this.f4722a = eVar;
        }

        @Override // c.a.o0.a.c1.d.j.e
        public void a(c.a.o0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4722a.f4713b == null) {
                return;
            }
            this.f4722a.f4713b.onResume();
        }
    }

    /* renamed from: c.a.o0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0128e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4723a;

        public C0128e(e eVar) {
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
            this.f4723a = eVar;
        }

        @Override // c.a.o0.a.c1.d.j.f
        public void d(c.a.o0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4723a.f4713b == null) {
                return;
            }
            this.f4723a.f4713b.onStart();
        }
    }

    /* loaded from: classes.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4724a;

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
            this.f4724a = eVar;
        }

        @Override // c.a.o0.a.c1.d.j.c
        public void c(c.a.o0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4724a.f4713b == null) {
                return;
            }
            this.f4724a.f4713b.onPause();
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
        this.f4717f = true;
    }

    @Override // c.a.o0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        c.a.o0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (jVar = this.f4712a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    @Override // c.a.o0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4715d.f4630g : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4716e : (String) invokeV.objValue;
    }

    @Override // c.a.o0.f.i.m.b.c
    public void d(boolean z) {
        c.a.o0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jVar = this.f4712a) == null) {
            return;
        }
        jVar.d(z);
    }

    @Override // c.a.o0.f.i.m.b.c
    public /* bridge */ /* synthetic */ c.a.o0.f.i.m.b.c e(Context context, @NonNull c.a.o0.f.i.j.a aVar) {
        n(context, aVar);
        return this;
    }

    @Override // c.a.o0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.o0.a.i1.g.c cVar = this.f4715d;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.f.i.m.b.c
    public void g(c.a.o0.f.i.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f4713b = eVar;
        }
    }

    @Override // c.a.o0.f.i.m.b.c
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.o0.f.i.m.b.c
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // c.a.o0.f.i.m.b.c
    public void h(c.a.o0.f.i.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            c.a.o0.a.i1.g.c p = p(aVar);
            this.f4715d = p;
            c.a.o0.a.c1.d.j jVar = this.f4712a;
            if (jVar != null) {
                jVar.o(p);
            }
        }
    }

    @Override // c.a.o0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.o0.f.i.m.b.c
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.o0.a.c1.d.j jVar = this.f4712a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.f.i.m.b.c
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.o0.a.c1.d.j jVar = this.f4712a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // c.a.o0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f4717f = z;
            if (this.f4712a == null) {
                return;
            }
            if (z) {
                if (this.f4718g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.f4718g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.f4716e)) {
            return;
        }
        c.a.o0.a.i1.b.a(this);
    }

    @Override // c.a.o0.f.i.m.b.c
    public void mute(boolean z) {
        c.a.o0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (jVar = this.f4712a) == null) {
            return;
        }
        jVar.mute(z);
    }

    public e n(Context context, @NonNull c.a.o0.f.i.j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, aVar)) == null) {
            this.f4714c = context;
            c.a.o0.a.i1.g.c p = p(aVar);
            this.f4715d = p;
            this.f4716e = p.n;
            o();
            m();
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public c.a.o0.a.c1.d.j o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f4712a == null) {
                c.a.o0.a.c1.d.j r0 = c.a.o0.a.c1.a.r0();
                r0.e(this.f4714c, this.f4715d);
                this.f4712a = r0;
                r0.g(new a(this));
                this.f4712a.p(new b(this));
                this.f4712a.m(new c(this));
                this.f4712a.j(new d(this));
                this.f4712a.k(new C0128e(this));
                this.f4712a.q(new f(this));
            }
            return this.f4712a;
        }
        return (c.a.o0.a.c1.d.j) invokeV.objValue;
    }

    @Override // c.a.o0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            c.a.o0.a.c1.d.j jVar = this.f4712a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.o0.a.c1.d.j jVar = this.f4712a;
            if (jVar != null) {
                jVar.stop();
                this.f4712a = null;
            }
            c.a.o0.a.i1.b.j(this);
        }
    }

    public c.a.o0.a.i1.g.c p(c.a.o0.f.i.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, aVar)) == null) {
            c.a.o0.a.i1.g.c cVar = new c.a.o0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f4629f = "SwanAdPlayer";
            cVar.s = aVar.f10524f;
            cVar.o = aVar.f10520b;
            cVar.B = aVar.o;
            cVar.M = aVar.z;
            cVar.I = aVar.v;
            cVar.C = aVar.p;
            return cVar;
        }
        return (c.a.o0.a.i1.g.c) invokeL.objValue;
    }

    @Override // c.a.o0.f.i.m.b.c
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
            c.a.o0.a.i1.g.c cVar = this.f4715d;
            return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.f.i.m.b.c
    public void resume() {
        c.a.o0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f4717f && (jVar = this.f4712a) != null) {
            jVar.resume();
        }
    }

    @Override // c.a.o0.f.i.m.b.c
    public void stop() {
        c.a.o0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (jVar = this.f4712a) == null) {
            return;
        }
        jVar.stop();
        this.f4712a = null;
    }
}
