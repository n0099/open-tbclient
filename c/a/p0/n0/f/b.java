package c.a.p0.n0.f;

import android.graphics.Canvas;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n0.h.c;
import c.a.p0.n0.h.d;
import c.a.p0.n0.h.e;
import c.a.p0.n0.h.f;
import c.a.p0.n0.h.g;
import c.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.ecs.system.DataSystem;
import com.baidu.tieba.danmu.ecs.system.RenderSystem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class b extends i {
    public static /* synthetic */ Interceptable $ic;
    public static final a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.n0.f.a j;
    public final c.a.p0.n0.k.b k;
    public long l;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ b c(a aVar, c.a.p0.n0.i.a aVar2, c cVar, int i, Object obj) {
            if ((i & 2) != 0) {
                cVar = aVar.a();
            }
            return aVar.b(aVar2, cVar);
        }

        public final g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new g(new d(), TuplesKt.to(5, new e()), TuplesKt.to(1, new f()), TuplesKt.to(4, new c.a.p0.n0.h.b())) : (g) invokeV.objValue;
        }

        public final b b(c.a.p0.n0.i.a renderer, c layouter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, renderer, layouter)) == null) {
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(layouter, "layouter");
                return new b(renderer, layouter);
            }
            return (b) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550749850, "Lc/a/p0/n0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-550749850, "Lc/a/p0/n0/f/b;");
                return;
            }
        }
        m = new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.p0.n0.i.a renderer, c layouter) {
        super(200, 1000, 200, 1500);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {renderer, layouter};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(layouter, "layouter");
        c.a.p0.n0.f.a aVar = new c.a.p0.n0.f.a(renderer);
        this.j = aVar;
        this.k = aVar.f();
        c.a.p0.n0.f.e.c cVar = new c.a.p0.n0.f.e.c(this.j);
        cVar.a = 1;
        Unit unit = Unit.INSTANCE;
        g(cVar);
        DataSystem dataSystem = new DataSystem(this.j);
        dataSystem.a = 2;
        Unit unit2 = Unit.INSTANCE;
        g(dataSystem);
        c.a.p0.n0.f.e.e.a aVar2 = new c.a.p0.n0.f.e.e.a(this.j);
        aVar2.a = 3;
        Unit unit3 = Unit.INSTANCE;
        g(aVar2);
        c.a.p0.n0.f.e.a aVar3 = new c.a.p0.n0.f.e.a(this.j);
        aVar3.a = 4;
        Unit unit4 = Unit.INSTANCE;
        g(aVar3);
        RenderSystem renderSystem = new RenderSystem(this.j);
        renderSystem.a = 5;
        Unit unit5 = Unit.INSTANCE;
        g(renderSystem);
        c.a.p0.n0.f.e.e.a aVar4 = (c.a.p0.n0.f.e.e.a) k(c.a.p0.n0.f.e.e.a.class);
        if (aVar4 == null) {
            return;
        }
        aVar4.p(layouter);
    }

    public static /* synthetic */ void E(b bVar, Float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = null;
        }
        bVar.D(f2);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.d(true);
            c.b.a.c.b<c.b.a.a.f> systems = l();
            Intrinsics.checkNotNullExpressionValue(systems, "systems");
            for (c.b.a.a.f fVar : systems) {
                p(fVar);
            }
        }
    }

    public final void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            c.a.p0.n0.k.b.f(this.k, j, 0.0f, 2, null);
            this.j.c().J();
            this.j.c().I();
            this.j.c().F();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.n0.k.b.f(this.k, 0L, 0.0f, 3, null);
            this.k.d(false);
        }
    }

    public final void D(Float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f2) == null) {
            c.a.p0.n0.g.e.b("Engine_step");
            this.k.g(f2);
            c.a.p0.n0.g.e.a();
        }
    }

    public final void F(c.a.p0.n0.a danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            c.a.p0.n0.f.e.c cVar = (c.a.p0.n0.f.e.c) k(c.a.p0.n0.f.e.c.class);
            if (cVar == null) {
                return;
            }
            cVar.m(danmakuConfig);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.n0.g.e.b("act");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            c.a.p0.n0.k.b bVar = this.k;
            long a2 = bVar.a() - this.l;
            update(bVar.b());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= 20) {
                BdLog.w("DanmakuEngine [Engine][ACT] overload act: interval: " + a2 + ", cost: " + elapsedRealtime2);
            }
            this.l = bVar.a();
            c.a.p0.n0.g.e.a();
        }
    }

    public final void s(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            RenderSystem renderSystem = (RenderSystem) k(RenderSystem.class);
            if (renderSystem == null) {
                return;
            }
            renderSystem.k(canvas, onRenderReady);
        }
    }

    public final c.a.p0.n0.a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.p0.n0.f.e.c cVar = (c.a.p0.n0.f.e.c) k(c.a.p0.n0.f.e.c.class);
            if (cVar == null) {
                return null;
            }
            return cVar.k();
        }
        return (c.a.p0.n0.a) invokeV.objValue;
    }

    public final c.a.p0.n0.f.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (c.a.p0.n0.f.a) invokeV.objValue;
    }

    public final long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k.a() : invokeV.longValue;
    }

    public final c.a.p0.n0.k.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (c.a.p0.n0.k.b) invokeV.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k.c() : invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.d(true);
        }
    }

    public final void z() {
        DataSystem dataSystem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (dataSystem = (DataSystem) k(DataSystem.class)) == null) {
            return;
        }
        dataSystem.D();
    }
}
