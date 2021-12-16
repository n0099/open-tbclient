package c.a.c0.s.z;

import c.a.c0.s.c0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public d f2121d;

    /* renamed from: e  reason: collision with root package name */
    public j f2122e;

    /* renamed from: f  reason: collision with root package name */
    public i f2123f;

    /* renamed from: g  reason: collision with root package name */
    public e f2124g;

    /* renamed from: h  reason: collision with root package name */
    public c f2125h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void B() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVar = this.f2123f) == null) {
            return;
        }
        iVar.b();
    }

    public void C() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iVar = this.f2123f) == null) {
            return;
        }
        iVar.a();
    }

    public void D(boolean z, boolean z2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (cVar = this.f2125h) == null) {
            return;
        }
        cVar.a(z, z2);
    }

    public void E(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jVar = this.f2122e) == null) {
            return;
        }
        jVar.a(z);
    }

    public void F(int i2, int i3) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (eVar = this.f2124g) == null) {
            return;
        }
        eVar.a(i2, i3);
    }

    public void G(int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (dVar = this.f2121d) == null) {
            return;
        }
        dVar.a(i2);
    }

    @Override // c.a.c0.s.z.n
    public void b(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            super.b(pVar);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(pVar.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(pVar.c())) {
                C();
            }
        }
    }

    @Override // c.a.c0.s.z.m, c.a.c0.s.z.n
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.r();
            this.f2121d = null;
            this.f2122e = null;
            this.f2124g = null;
            this.f2123f = null;
            this.f2125h = null;
        }
    }
}
