package c.a.n0.a.s0.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s0.d.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class e implements c.a.n0.h.a.f.b.c, c.a.n0.a.z0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.s0.d.k a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.h.a.e.f f6146b;

    /* renamed from: c  reason: collision with root package name */
    public Context f6147c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.z0.g.c f6148d;

    /* renamed from: e  reason: collision with root package name */
    public String f6149e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6150f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6151g;

    /* loaded from: classes.dex */
    public class a implements k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.a.s0.d.k.a
        public void b(c.a.n0.a.s0.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f6146b == null) {
                return;
            }
            this.a.f6146b.onCompletion();
        }
    }

    /* loaded from: classes.dex */
    public class b implements k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.a.s0.d.k.b
        public boolean f(c.a.n0.a.s0.d.k kVar, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, kVar, i, i2)) == null) ? this.a.f6146b != null && this.a.f6146b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements k.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.a.s0.d.k.d
        public void e(c.a.n0.a.s0.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f6146b == null) {
                return;
            }
            this.a.f6146b.onPrepared();
        }
    }

    /* loaded from: classes.dex */
    public class d implements k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.a.s0.d.k.e
        public void a(c.a.n0.a.s0.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f6146b == null) {
                return;
            }
            this.a.f6146b.onResume();
        }
    }

    /* renamed from: c.a.n0.a.s0.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0444e implements k.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public C0444e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.a.s0.d.k.f
        public void d(c.a.n0.a.s0.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f6146b == null) {
                return;
            }
            this.a.f6146b.onStart();
        }
    }

    /* loaded from: classes.dex */
    public class f implements k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // c.a.n0.a.s0.d.k.c
        public void c(c.a.n0.a.s0.d.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || this.a.f6146b == null) {
                return;
            }
            this.a.f6146b.onPause();
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6150f = true;
    }

    @Override // c.a.n0.h.a.f.b.c
    public void a(FrameLayout frameLayout) {
        c.a.n0.a.s0.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.a(frameLayout);
    }

    @Override // c.a.n0.a.z0.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6148d.f6097c : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6149e : (String) invokeV.objValue;
    }

    @Override // c.a.n0.h.a.f.b.c
    public void d(boolean z) {
        c.a.n0.a.s0.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.d(z);
    }

    @Override // c.a.n0.h.a.f.b.c
    public /* bridge */ /* synthetic */ c.a.n0.h.a.f.b.c e(Context context, @NonNull c.a.n0.h.a.b.b bVar) {
        n(context, bVar);
        return this;
    }

    @Override // c.a.n0.a.z0.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.n0.a.z0.g.c cVar = this.f6148d;
            return cVar != null ? cVar.z : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.h.a.f.b.c
    public void g(c.a.n0.h.a.e.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f6146b = fVar;
        }
    }

    @Override // c.a.n0.h.a.f.b.c
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.n0.h.a.f.b.c
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // c.a.n0.h.a.f.b.c
    public void h(c.a.n0.h.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            c.a.n0.a.z0.g.c p = p(bVar);
            this.f6148d = p;
            c.a.n0.a.s0.d.k kVar = this.a;
            if (kVar != null) {
                kVar.o(p);
            }
        }
    }

    @Override // c.a.n0.a.z0.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.n0.h.a.f.b.c
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.n0.a.s0.d.k kVar = this.a;
            return kVar != null && kVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.h.a.f.b.c
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.n0.a.s0.d.k kVar = this.a;
            return kVar != null && kVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.z0.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // c.a.n0.a.z0.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f6150f = z;
            if (this.a == null) {
                return;
            }
            if (z) {
                if (this.f6151g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.f6151g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.f6149e)) {
            return;
        }
        c.a.n0.a.z0.b.a(this);
    }

    @Override // c.a.n0.h.a.f.b.c
    public void mute(boolean z) {
        c.a.n0.a.s0.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.mute(z);
    }

    public e n(Context context, @NonNull c.a.n0.h.a.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, bVar)) == null) {
            this.f6147c = context;
            c.a.n0.a.z0.g.c p = p(bVar);
            this.f6148d = p;
            this.f6149e = p.j;
            o();
            m();
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public c.a.n0.a.s0.d.k o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                c.a.n0.a.s0.d.k C0 = c.a.n0.a.s0.a.C0();
                C0.e(this.f6147c, this.f6148d);
                this.a = C0;
                C0.g(new a(this));
                this.a.p(new b(this));
                this.a.m(new c(this));
                this.a.j(new d(this));
                this.a.k(new C0444e(this));
                this.a.r(new f(this));
            }
            return this.a;
        }
        return (c.a.n0.a.s0.d.k) invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            c.a.n0.a.s0.d.k kVar = this.a;
            return kVar != null && kVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.z0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.n0.a.s0.d.k kVar = this.a;
            if (kVar != null) {
                kVar.stop();
                this.a = null;
            }
            c.a.n0.a.z0.b.k(this);
        }
    }

    public c.a.n0.a.z0.g.c p(c.a.n0.h.a.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            c.a.n0.a.z0.g.c cVar = new c.a.n0.a.z0.g.c();
            cVar.j = "SwanAdPlayer";
            cVar.f6096b = "SwanAdPlayer";
            cVar.o = bVar.f8307f;
            cVar.k = bVar.f8303b;
            cVar.x = bVar.o;
            cVar.I = bVar.z;
            cVar.E = bVar.v;
            cVar.y = bVar.p;
            return cVar;
        }
        return (c.a.n0.a.z0.g.c) invokeL.objValue;
    }

    @Override // c.a.n0.h.a.f.b.c
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
            c.a.n0.a.z0.g.c cVar = this.f6148d;
            return (cVar == null || TextUtils.isEmpty(cVar.y)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.h.a.f.b.c
    public void resume() {
        c.a.n0.a.s0.d.k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f6150f && (kVar = this.a) != null) {
            kVar.resume();
        }
    }

    @Override // c.a.n0.h.a.f.b.c
    public void stop() {
        c.a.n0.a.s0.d.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (kVar = this.a) == null) {
            return;
        }
        kVar.stop();
        this.a = null;
    }
}
