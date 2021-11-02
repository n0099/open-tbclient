package b.i.b.a.i0;

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
    public boolean f32654e;

    /* renamed from: f  reason: collision with root package name */
    public long f32655f;

    /* renamed from: g  reason: collision with root package name */
    public long f32656g;

    /* renamed from: h  reason: collision with root package name */
    public b.i.b.a.p f32657h;

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
        this.f32657h = b.i.b.a.p.f32761d;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f32655f = j;
            if (this.f32654e) {
                this.f32656g = SystemClock.elapsedRealtime();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f32654e) {
            return;
        }
        this.f32656g = SystemClock.elapsedRealtime();
        this.f32654e = true;
    }

    @Override // b.i.b.a.i0.h
    public b.i.b.a.p c(b.i.b.a.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar)) == null) {
            if (this.f32654e) {
                a(q());
            }
            this.f32657h = pVar;
            return pVar;
        }
        return (b.i.b.a.p) invokeL.objValue;
    }

    @Override // b.i.b.a.i0.h
    public b.i.b.a.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32657h : (b.i.b.a.p) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f32654e) {
            a(q());
            this.f32654e = false;
        }
    }

    @Override // b.i.b.a.i0.h
    public long q() {
        InterceptResult invokeV;
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j = this.f32655f;
            if (this.f32654e) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f32656g;
                b.i.b.a.p pVar = this.f32657h;
                if (pVar.f32762a == 1.0f) {
                    a2 = b.i.b.a.b.a(elapsedRealtime);
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
