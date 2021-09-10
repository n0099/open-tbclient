package c.a.p0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c1.d.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes.dex */
public class e implements c.a.p0.f.i.m.b.c, c.a.p0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.a.c1.d.j f4740a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f.i.l.e f4741b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4742c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.i1.g.c f4743d;

    /* renamed from: e  reason: collision with root package name */
    public String f4744e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4745f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4746g;

    /* loaded from: classes.dex */
    public class a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4747a;

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
            this.f4747a = eVar;
        }

        @Override // c.a.p0.a.c1.d.j.a
        public void b(c.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4747a.f4741b == null) {
                return;
            }
            this.f4747a.f4741b.onCompletion();
        }
    }

    /* loaded from: classes.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4748a;

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
            this.f4748a = eVar;
        }

        @Override // c.a.p0.a.c1.d.j.b
        public boolean f(c.a.p0.a.c1.d.j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f4748a.f4741b != null && this.f4748a.f4741b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4749a;

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
            this.f4749a = eVar;
        }

        @Override // c.a.p0.a.c1.d.j.d
        public void e(c.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4749a.f4741b == null) {
                return;
            }
            this.f4749a.f4741b.onPrepared();
        }
    }

    /* loaded from: classes.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4750a;

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
            this.f4750a = eVar;
        }

        @Override // c.a.p0.a.c1.d.j.e
        public void a(c.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4750a.f4741b == null) {
                return;
            }
            this.f4750a.f4741b.onResume();
        }
    }

    /* renamed from: c.a.p0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0130e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4751a;

        public C0130e(e eVar) {
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
            this.f4751a = eVar;
        }

        @Override // c.a.p0.a.c1.d.j.f
        public void d(c.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4751a.f4741b == null) {
                return;
            }
            this.f4751a.f4741b.onStart();
        }
    }

    /* loaded from: classes.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f4752a;

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
            this.f4752a = eVar;
        }

        @Override // c.a.p0.a.c1.d.j.c
        public void c(c.a.p0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f4752a.f4741b == null) {
                return;
            }
            this.f4752a.f4741b.onPause();
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
        this.f4745f = true;
    }

    @Override // c.a.p0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        c.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (jVar = this.f4740a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    @Override // c.a.p0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4743d.f4658g : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4744e : (String) invokeV.objValue;
    }

    @Override // c.a.p0.f.i.m.b.c
    public void d(boolean z) {
        c.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jVar = this.f4740a) == null) {
            return;
        }
        jVar.d(z);
    }

    @Override // c.a.p0.f.i.m.b.c
    public /* bridge */ /* synthetic */ c.a.p0.f.i.m.b.c e(Context context, @NonNull c.a.p0.f.i.j.a aVar) {
        n(context, aVar);
        return this;
    }

    @Override // c.a.p0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.a.i1.g.c cVar = this.f4743d;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.f.i.m.b.c
    public void g(c.a.p0.f.i.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f4741b = eVar;
        }
    }

    @Override // c.a.p0.f.i.m.b.c
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.p0.f.i.m.b.c
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // c.a.p0.f.i.m.b.c
    public void h(c.a.p0.f.i.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            c.a.p0.a.i1.g.c p = p(aVar);
            this.f4743d = p;
            c.a.p0.a.c1.d.j jVar = this.f4740a;
            if (jVar != null) {
                jVar.o(p);
            }
        }
    }

    @Override // c.a.p0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.p0.f.i.m.b.c
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c.a.p0.a.c1.d.j jVar = this.f4740a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f.i.m.b.c
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.p0.a.c1.d.j jVar = this.f4740a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // c.a.p0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f4745f = z;
            if (this.f4740a == null) {
                return;
            }
            if (z) {
                if (this.f4746g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.f4746g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.f4744e)) {
            return;
        }
        c.a.p0.a.i1.b.a(this);
    }

    @Override // c.a.p0.f.i.m.b.c
    public void mute(boolean z) {
        c.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (jVar = this.f4740a) == null) {
            return;
        }
        jVar.mute(z);
    }

    public e n(Context context, @NonNull c.a.p0.f.i.j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, aVar)) == null) {
            this.f4742c = context;
            c.a.p0.a.i1.g.c p = p(aVar);
            this.f4743d = p;
            this.f4744e = p.n;
            o();
            m();
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public c.a.p0.a.c1.d.j o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f4740a == null) {
                c.a.p0.a.c1.d.j r0 = c.a.p0.a.c1.a.r0();
                r0.e(this.f4742c, this.f4743d);
                this.f4740a = r0;
                r0.g(new a(this));
                this.f4740a.p(new b(this));
                this.f4740a.m(new c(this));
                this.f4740a.j(new d(this));
                this.f4740a.k(new C0130e(this));
                this.f4740a.q(new f(this));
            }
            return this.f4740a;
        }
        return (c.a.p0.a.c1.d.j) invokeV.objValue;
    }

    @Override // c.a.p0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            c.a.p0.a.c1.d.j jVar = this.f4740a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.p0.a.c1.d.j jVar = this.f4740a;
            if (jVar != null) {
                jVar.stop();
                this.f4740a = null;
            }
            c.a.p0.a.i1.b.j(this);
        }
    }

    public c.a.p0.a.i1.g.c p(c.a.p0.f.i.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, aVar)) == null) {
            c.a.p0.a.i1.g.c cVar = new c.a.p0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f4657f = "SwanAdPlayer";
            cVar.s = aVar.f10552f;
            cVar.o = aVar.f10548b;
            cVar.B = aVar.o;
            cVar.M = aVar.z;
            cVar.I = aVar.v;
            cVar.C = aVar.p;
            return cVar;
        }
        return (c.a.p0.a.i1.g.c) invokeL.objValue;
    }

    @Override // c.a.p0.f.i.m.b.c
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
            c.a.p0.a.i1.g.c cVar = this.f4743d;
            return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f.i.m.b.c
    public void resume() {
        c.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f4745f && (jVar = this.f4740a) != null) {
            jVar.resume();
        }
    }

    @Override // c.a.p0.f.i.m.b.c
    public void stop() {
        c.a.p0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (jVar = this.f4740a) == null) {
            return;
        }
        jVar.stop();
        this.f4740a = null;
    }
}
