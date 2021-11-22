package b.a.p0.a.h0.i.g.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f5618a;

    /* renamed from: b  reason: collision with root package name */
    public long f5619b;

    public c() {
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
        this.f5619b = 0L;
        this.f5618a = new e();
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f5618a.a(aVar);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int size = this.f5618a.d().size();
            int i2 = this.f5618a.i();
            return i2 > 0 && (((double) size) * 1.0d) / ((double) i2) > 0.5d;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<a> d2 = this.f5618a.d();
            if (d2.size() <= 0) {
                return false;
            }
            for (a aVar : d2) {
                if (b.a.p0.a.h0.q.b.k().i(aVar.f5611f)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((double) this.f5618a.g().size()) >= 2.0d : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5618a.i() <= 2 || System.currentTimeMillis() - this.f5619b < 3000 : invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.f5618a.f().size();
            int i2 = this.f5618a.i();
            return i2 > 0 && (((double) size) * 1.0d) / ((double) i2) > 0.5d;
        }
        return invokeV.booleanValue;
    }

    public d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d dVar = new d();
            dVar.i(this.f5619b);
            dVar.h(this.f5618a.d());
            dVar.k(this.f5618a.g());
            dVar.l(this.f5618a.i());
            if (c()) {
                dVar.j(RequestStatus.STATUS_CORE_FAILED);
            } else if (e()) {
                dVar.j(RequestStatus.STATUS_UNKNOWN);
            } else if (f()) {
                dVar.j(RequestStatus.STATUS_SERVER_FAILED);
            } else if (b()) {
                dVar.j(RequestStatus.STATUS_FAILED);
            } else if (d()) {
                dVar.j(RequestStatus.STATUS_SLOW);
            } else {
                dVar.j(RequestStatus.STATUS_SUCCESS);
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f5618a.b();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f5619b = System.currentTimeMillis();
        }
    }
}
