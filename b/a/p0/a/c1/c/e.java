package b.a.p0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c1.d.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class e implements b.a.p0.h.i.n.b.c, b.a.p0.a.j1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.c1.d.k f4279a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.h.i.m.f f4280b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4281c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.j1.g.c f4282d;

    /* renamed from: e  reason: collision with root package name */
    public String f4283e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4284f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4285g;

    /* loaded from: classes.dex */
    public class a implements k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4286a;

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
            this.f4286a = eVar;
        }

        @Override // b.a.p0.a.c1.d.k.a
        public void b(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.f4286a.f4280b == null) {
                return;
            }
            this.f4286a.f4280b.onCompletion();
        }
    }

    /* loaded from: classes.dex */
    public class b implements k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4287a;

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
            this.f4287a = eVar;
        }

        @Override // b.a.p0.a.c1.d.k.b
        public boolean f(b.a.p0.a.c1.d.k kVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, kVar, i2, i3)) == null) ? this.f4287a.f4280b != null && this.f4287a.f4280b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements k.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4288a;

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
            this.f4288a = eVar;
        }

        @Override // b.a.p0.a.c1.d.k.d
        public void e(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.f4288a.f4280b == null) {
                return;
            }
            this.f4288a.f4280b.onPrepared();
        }
    }

    /* loaded from: classes.dex */
    public class d implements k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4289a;

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
            this.f4289a = eVar;
        }

        @Override // b.a.p0.a.c1.d.k.e
        public void a(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.f4289a.f4280b == null) {
                return;
            }
            this.f4289a.f4280b.onResume();
        }
    }

    /* renamed from: b.a.p0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0133e implements k.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4290a;

        public C0133e(e eVar) {
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
            this.f4290a = eVar;
        }

        @Override // b.a.p0.a.c1.d.k.f
        public void d(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.f4290a.f4280b == null) {
                return;
            }
            this.f4290a.f4280b.onStart();
        }
    }

    /* loaded from: classes.dex */
    public class f implements k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4291a;

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
            this.f4291a = eVar;
        }

        @Override // b.a.p0.a.c1.d.k.c
        public void c(b.a.p0.a.c1.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.f4291a.f4280b == null) {
                return;
            }
            this.f4291a.f4280b.onPause();
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
        this.f4284f = true;
    }

    @Override // b.a.p0.h.i.n.b.c
    public void a(FrameLayout frameLayout) {
        b.a.p0.a.c1.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (kVar = this.f4279a) == null) {
            return;
        }
        kVar.a(frameLayout);
    }

    @Override // b.a.p0.a.j1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4282d.f4197g : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.j1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4283e : (String) invokeV.objValue;
    }

    @Override // b.a.p0.h.i.n.b.c
    public void d(boolean z) {
        b.a.p0.a.c1.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (kVar = this.f4279a) == null) {
            return;
        }
        kVar.d(z);
    }

    @Override // b.a.p0.h.i.n.b.c
    public /* bridge */ /* synthetic */ b.a.p0.h.i.n.b.c e(Context context, @NonNull b.a.p0.h.i.j.a aVar) {
        n(context, aVar);
        return this;
    }

    @Override // b.a.p0.a.j1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.p0.a.j1.g.c cVar = this.f4282d;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.p0.h.i.n.b.c
    public void g(b.a.p0.h.i.m.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f4280b = fVar;
        }
    }

    @Override // b.a.p0.h.i.n.b.c
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // b.a.p0.h.i.n.b.c
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // b.a.p0.h.i.n.b.c
    public void h(b.a.p0.h.i.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            b.a.p0.a.j1.g.c p = p(aVar);
            this.f4282d = p;
            b.a.p0.a.c1.d.k kVar = this.f4279a;
            if (kVar != null) {
                kVar.o(p);
            }
        }
    }

    @Override // b.a.p0.a.j1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // b.a.p0.h.i.n.b.c
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b.a.p0.a.c1.d.k kVar = this.f4279a;
            return kVar != null && kVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.h.i.n.b.c
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b.a.p0.a.c1.d.k kVar = this.f4279a;
            return kVar != null && kVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.j1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // b.a.p0.a.j1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f4284f = z;
            if (this.f4279a == null) {
                return;
            }
            if (z) {
                if (this.f4285g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.f4285g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.f4283e)) {
            return;
        }
        b.a.p0.a.j1.b.a(this);
    }

    @Override // b.a.p0.h.i.n.b.c
    public void mute(boolean z) {
        b.a.p0.a.c1.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (kVar = this.f4279a) == null) {
            return;
        }
        kVar.mute(z);
    }

    public e n(Context context, @NonNull b.a.p0.h.i.j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, aVar)) == null) {
            this.f4281c = context;
            b.a.p0.a.j1.g.c p = p(aVar);
            this.f4282d = p;
            this.f4283e = p.n;
            o();
            m();
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public b.a.p0.a.c1.d.k o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f4279a == null) {
                b.a.p0.a.c1.d.k C0 = b.a.p0.a.c1.a.C0();
                C0.e(this.f4281c, this.f4282d);
                this.f4279a = C0;
                C0.g(new a(this));
                this.f4279a.p(new b(this));
                this.f4279a.m(new c(this));
                this.f4279a.j(new d(this));
                this.f4279a.k(new C0133e(this));
                this.f4279a.r(new f(this));
            }
            return this.f4279a;
        }
        return (b.a.p0.a.c1.d.k) invokeV.objValue;
    }

    @Override // b.a.p0.a.j1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            b.a.p0.a.c1.d.k kVar = this.f4279a;
            return kVar != null && kVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.j1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.p0.a.c1.d.k kVar = this.f4279a;
            if (kVar != null) {
                kVar.stop();
                this.f4279a = null;
            }
            b.a.p0.a.j1.b.k(this);
        }
    }

    public b.a.p0.a.j1.g.c p(b.a.p0.h.i.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, aVar)) == null) {
            b.a.p0.a.j1.g.c cVar = new b.a.p0.a.j1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f4196f = "SwanAdPlayer";
            cVar.s = aVar.f10424f;
            cVar.o = aVar.f10420b;
            cVar.B = aVar.o;
            cVar.M = aVar.z;
            cVar.I = aVar.v;
            cVar.C = aVar.p;
            return cVar;
        }
        return (b.a.p0.a.j1.g.c) invokeL.objValue;
    }

    @Override // b.a.p0.h.i.n.b.c
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
            b.a.p0.a.j1.g.c cVar = this.f4282d;
            return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.h.i.n.b.c
    public void resume() {
        b.a.p0.a.c1.d.k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f4284f && (kVar = this.f4279a) != null) {
            kVar.resume();
        }
    }

    @Override // b.a.p0.h.i.n.b.c
    public void stop() {
        b.a.p0.a.c1.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (kVar = this.f4279a) == null) {
            return;
        }
        kVar.stop();
        this.f4279a = null;
    }
}
