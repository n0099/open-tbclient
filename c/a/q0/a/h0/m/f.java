package c.a.q0.a.h0.m;

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
public class f extends g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean H;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216130278, "Lc/a/q0/a/h0/m/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216130278, "Lc/a/q0/a/h0/m/f;");
                return;
            }
        }
        H = c.a.q0.a.k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str) {
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

    @Override // c.a.q0.a.h0.m.g, c.a.q0.q.f.i
    public void D(c.a.q0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            if (H) {
                String str = "swanAsyncUpdate :: onFetchError: " + bVar.toString();
            }
            I0("checkForUpdate", false);
            n0(bVar.a);
            if (c.a.q0.a.h0.m.s.a.m(bVar)) {
                c.a.q0.a.h0.m.s.a.c(this.s);
            }
        }
    }

    @Override // c.a.q0.q.f.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            if (this.r != null) {
                v0();
                I0("checkForUpdate", false);
                c.a.q0.a.h0.m.s.a.c(this.s);
            }
        }
    }

    @Override // c.a.q0.a.h0.m.g, c.a.q0.q.f.i
    public void H(c.a.q0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.H(gVar);
            I0("checkForUpdate", gVar != null && gVar.f());
        }
    }

    @Override // c.a.q0.q.f.i
    public void I(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            super.I(str, i2);
            c.a.q0.q.j.c a = c.a.q0.q.j.c.a(str);
            if (a == null) {
                return;
            }
            boolean b2 = c.a.q0.q.p.f.b(a.c());
            c.a.q0.a.e0.d.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i2);
            if (b2) {
                c.a.q0.a.y1.c.a e2 = c.a.q0.a.y1.c.a.e();
                c.a.q0.a.y1.c.c cVar = new c.a.q0.a.y1.c.c(129);
                cVar.f(true);
                e2.h(cVar);
            }
        }
    }

    public final void I0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(this.s)) {
            return;
        }
        i.f(str, this.s, z);
    }

    @Override // c.a.q0.a.h0.m.k
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // c.a.q0.a.h0.m.g
    public PMSDownloadType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PMSDownloadType.ASYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // c.a.q0.a.h0.m.g
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.w0();
            this.t.add(new UbcFlowEvent("na_start_update_db"));
            c.a.q0.a.u2.a G0 = G0();
            this.t.add(new UbcFlowEvent("na_end_update_db"));
            if (G0 == null) {
                boolean z = H;
                I0("updateReady", true);
                B0("main_async_download", "0");
                c.a.q0.a.h0.m.s.a.c(this.s);
                return;
            }
            boolean z2 = H;
        }
    }

    @Override // c.a.q0.a.h0.m.g
    public void x0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            I0("updateFailed", false);
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (H) {
                    String str = "swanAsyncUpdate :: pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage();
                }
            } else if (H) {
                String str2 = "swanAsyncUpdate :: 未知错误：" + th.getMessage();
            }
        }
    }
}
