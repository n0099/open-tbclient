package c.a.n0.a.h0.m;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e extends f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(828882090, "Lc/a/n0/a/h0/m/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(828882090, "Lc/a/n0/a/h0/m/e;");
                return;
            }
        }
        F = c.a.n0.a.k.f6803a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.h0.m.f, c.a.n0.n.f.g
    public void B(c.a.n0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (F) {
                String str = "swanAsyncUpdate :: onFetchError: " + aVar.toString();
            }
            E0("checkForUpdate", false);
            j0(aVar.f11601a);
            if (c.a.n0.a.h0.m.p.a.m(aVar)) {
                c.a.n0.a.h0.m.p.a.c(this.r);
            }
        }
    }

    @Override // c.a.n0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (this.q != null) {
                r0();
                E0("checkForUpdate", false);
                c.a.n0.a.h0.m.p.a.c(this.r);
            }
        }
    }

    public final void E0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) || TextUtils.isEmpty(this.r)) {
            return;
        }
        h.f(str, this.r, z);
    }

    @Override // c.a.n0.a.h0.m.f, c.a.n0.n.f.g
    public void F(c.a.n0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            if (fVar == null || !fVar.d()) {
                return;
            }
            E0("checkForUpdate", true);
        }
    }

    @Override // c.a.n0.n.f.g
    public void G(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
            super.G(str, i2);
            c.a.n0.n.i.c a2 = c.a.n0.n.i.c.a(str);
            if (a2 == null) {
                return;
            }
            boolean b2 = c.a.n0.n.o.e.b(a2.c());
            c.a.n0.a.e0.d.g("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i2);
            if (b2) {
                c.a.n0.a.v1.c.a e2 = c.a.n0.a.v1.c.a.e();
                c.a.n0.a.v1.c.c cVar = new c.a.n0.a.v1.c.c(129);
                cVar.f(true);
                e2.h(cVar);
            }
        }
    }

    @Override // c.a.n0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.h0.m.f
    public PMSDownloadType h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PMSDownloadType.ASYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.n0.a.h0.m.f
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.s0();
            this.s.add(new UbcFlowEvent("na_start_update_db"));
            c.a.n0.a.q2.a C0 = C0();
            this.s.add(new UbcFlowEvent("na_end_update_db"));
            if (C0 == null) {
                boolean z = F;
                E0("updateReady", true);
                x0("main_async_download", "0");
                c.a.n0.a.h0.m.p.a.c(this.r);
                return;
            }
            boolean z2 = F;
        }
    }

    @Override // c.a.n0.a.h0.m.f
    public void t0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            E0("updateFailed", false);
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (F) {
                    String str = "swanAsyncUpdate :: pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage();
                }
            } else if (F) {
                String str2 = "swanAsyncUpdate :: 未知错误：" + th.getMessage();
            }
        }
    }
}
