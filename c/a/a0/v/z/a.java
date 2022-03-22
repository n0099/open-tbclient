package c.a.a0.v.z;

import c.a.a0.v.c0.p;
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
    public d f1869d;

    /* renamed from: e  reason: collision with root package name */
    public j f1870e;

    /* renamed from: f  reason: collision with root package name */
    public i f1871f;

    /* renamed from: g  reason: collision with root package name */
    public e f1872g;

    /* renamed from: h  reason: collision with root package name */
    public c f1873h;

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

    public void B() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVar = this.f1871f) == null) {
            return;
        }
        iVar.b();
    }

    public void C() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iVar = this.f1871f) == null) {
            return;
        }
        iVar.a();
    }

    public void D(boolean z, boolean z2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (cVar = this.f1873h) == null) {
            return;
        }
        cVar.a(z, z2);
    }

    public void E(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jVar = this.f1870e) == null) {
            return;
        }
        jVar.a(z);
    }

    public void F(int i, int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (eVar = this.f1872g) == null) {
            return;
        }
        eVar.a(i, i2);
    }

    public void G(int i) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (dVar = this.f1869d) == null) {
            return;
        }
        dVar.a(i);
    }

    @Override // c.a.a0.v.z.n
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

    @Override // c.a.a0.v.z.m, c.a.a0.v.z.n
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.r();
            this.f1869d = null;
            this.f1870e = null;
            this.f1872g = null;
            this.f1871f = null;
            this.f1873h = null;
        }
    }
}
