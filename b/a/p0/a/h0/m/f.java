package b.a.p0.a.h0.m;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597581736, "Lb/a/p0/a/h0/m/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597581736, "Lb/a/p0/a/h0/m/f;");
                return;
            }
        }
        H = b.a.p0.a.k.f6863a;
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

    @Override // b.a.p0.a.h0.m.g, b.a.p0.q.f.i
    public void C(b.a.p0.q.i.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.C(bVar);
            if (H) {
                String str = "swanAsyncUpdate :: onFetchError: " + bVar.toString();
            }
            H0("checkForUpdate", false);
            m0(bVar.f11762a);
            if (b.a.p0.a.h0.m.s.a.m(bVar)) {
                b.a.p0.a.h0.m.s.a.c(this.s);
            }
        }
    }

    @Override // b.a.p0.q.f.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (this.r != null) {
                u0();
                H0("checkForUpdate", false);
                b.a.p0.a.h0.m.s.a.c(this.s);
            }
        }
    }

    @Override // b.a.p0.a.h0.m.g, b.a.p0.q.f.i
    public void G(b.a.p0.q.p.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            super.G(gVar);
            H0("checkForUpdate", gVar != null && gVar.f());
        }
    }

    @Override // b.a.p0.q.f.i
    public void H(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            super.H(str, i2);
            b.a.p0.q.j.c a2 = b.a.p0.q.j.c.a(str);
            if (a2 == null) {
                return;
            }
            boolean b2 = b.a.p0.q.p.f.b(a2.c());
            b.a.p0.a.e0.d.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i2);
            if (b2) {
                b.a.p0.a.y1.c.a e2 = b.a.p0.a.y1.c.a.e();
                b.a.p0.a.y1.c.c cVar = new b.a.p0.a.y1.c.c(129);
                cVar.f(true);
                e2.h(cVar);
            }
        }
    }

    public final void H0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(this.s)) {
            return;
        }
        i.f(str, this.s, z);
    }

    @Override // b.a.p0.a.h0.m.k
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.m.g
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PMSDownloadType.ASYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.m.g
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.v0();
            this.t.add(new UbcFlowEvent("na_start_update_db"));
            b.a.p0.a.u2.a F0 = F0();
            this.t.add(new UbcFlowEvent("na_end_update_db"));
            if (F0 == null) {
                boolean z = H;
                H0("updateReady", true);
                A0("main_async_download", "0");
                b.a.p0.a.h0.m.s.a.c(this.s);
                return;
            }
            boolean z2 = H;
        }
    }

    @Override // b.a.p0.a.h0.m.g
    public void w0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            H0("updateFailed", false);
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
