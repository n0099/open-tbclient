package c.a.t0.a0.f.g.f;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public a f14793b;

    /* renamed from: c  reason: collision with root package name */
    public int f14794c;

    public e(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14794c = -1;
        this.a = tbPageContext;
    }

    public void a(ViewGroup viewGroup) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.a(viewGroup);
    }

    public void b(c.a.t0.a0.f.g.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, z) == null) {
            if (aVar == null) {
                this.f14794c = -1;
                this.f14793b = new b(this.a);
            } else if (z) {
                int i2 = aVar.f14743d;
                this.f14794c = i2;
                if (i2 == 1) {
                    this.f14793b = new d(this.a);
                } else if (i2 == 2) {
                    this.f14793b = new f(this.a);
                } else if (i2 != 3) {
                    this.f14793b = new b(this.a);
                } else {
                    this.f14793b = new c(this.a);
                }
            }
            if (this.f14793b.f(aVar)) {
                if (z) {
                    this.f14793b.d();
                }
                this.f14793b.b(aVar);
                return;
            }
            this.f14794c = -1;
            b bVar = new b(this.a);
            this.f14793b = bVar;
            if (z) {
                bVar.d();
            }
            this.f14793b.b(aVar);
        }
    }

    public boolean c(c.a.t0.a0.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) ? aVar == null || this.f14794c != aVar.f14743d : invokeL.booleanValue;
    }

    public void d(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.g(z);
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.h();
    }

    public void f(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.i(i2);
    }

    public void g() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.j();
    }

    public void h() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.k();
    }

    public void i() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.l();
    }

    public void j() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.m();
    }

    public void k() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.f14793b) == null) {
            return;
        }
        aVar.n();
    }
}
