package b.h.b.a.i0;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class q implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33512e;

    /* renamed from: f  reason: collision with root package name */
    public long f33513f;

    /* renamed from: g  reason: collision with root package name */
    public long f33514g;

    /* renamed from: h  reason: collision with root package name */
    public b.h.b.a.p f33515h;

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
        this.f33515h = b.h.b.a.p.f33619d;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f33513f = j;
            if (this.f33512e) {
                this.f33514g = SystemClock.elapsedRealtime();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f33512e) {
            return;
        }
        this.f33514g = SystemClock.elapsedRealtime();
        this.f33512e = true;
    }

    @Override // b.h.b.a.i0.h
    public b.h.b.a.p c(b.h.b.a.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar)) == null) {
            if (this.f33512e) {
                a(q());
            }
            this.f33515h = pVar;
            return pVar;
        }
        return (b.h.b.a.p) invokeL.objValue;
    }

    @Override // b.h.b.a.i0.h
    public b.h.b.a.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33515h : (b.h.b.a.p) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f33512e) {
            a(q());
            this.f33512e = false;
        }
    }

    @Override // b.h.b.a.i0.h
    public long q() {
        InterceptResult invokeV;
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j = this.f33513f;
            if (this.f33512e) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f33514g;
                b.h.b.a.p pVar = this.f33515h;
                if (pVar.f33620a == 1.0f) {
                    a2 = b.h.b.a.b.a(elapsedRealtime);
                } else {
                    a2 = pVar.a(elapsedRealtime);
                }
                return j + a2;
            }
            return j;
        }
        return invokeV.longValue;
    }
}
