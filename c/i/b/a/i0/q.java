package c.i.b.a.i0;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class q implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33831e;

    /* renamed from: f  reason: collision with root package name */
    public long f33832f;

    /* renamed from: g  reason: collision with root package name */
    public long f33833g;

    /* renamed from: h  reason: collision with root package name */
    public c.i.b.a.p f33834h;

    public q() {
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
        this.f33834h = c.i.b.a.p.f33942d;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f33832f = j2;
            if (this.f33831e) {
                this.f33833g = SystemClock.elapsedRealtime();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f33831e) {
            return;
        }
        this.f33833g = SystemClock.elapsedRealtime();
        this.f33831e = true;
    }

    @Override // c.i.b.a.i0.h
    public c.i.b.a.p c(c.i.b.a.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar)) == null) {
            if (this.f33831e) {
                a(q());
            }
            this.f33834h = pVar;
            return pVar;
        }
        return (c.i.b.a.p) invokeL.objValue;
    }

    @Override // c.i.b.a.i0.h
    public c.i.b.a.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33834h : (c.i.b.a.p) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f33831e) {
            a(q());
            this.f33831e = false;
        }
    }

    @Override // c.i.b.a.i0.h
    public long q() {
        InterceptResult invokeV;
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j2 = this.f33832f;
            if (this.f33831e) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f33833g;
                c.i.b.a.p pVar = this.f33834h;
                if (pVar.f33943a == 1.0f) {
                    a2 = c.i.b.a.b.a(elapsedRealtime);
                } else {
                    a2 = pVar.a(elapsedRealtime);
                }
                return j2 + a2;
            }
            return j2;
        }
        return invokeV.longValue;
    }
}
