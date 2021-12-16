package c.i.b.a.i0;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class q implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30617e;

    /* renamed from: f  reason: collision with root package name */
    public long f30618f;

    /* renamed from: g  reason: collision with root package name */
    public long f30619g;

    /* renamed from: h  reason: collision with root package name */
    public c.i.b.a.p f30620h;

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
        this.f30620h = c.i.b.a.p.f30714d;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f30618f = j2;
            if (this.f30617e) {
                this.f30619g = SystemClock.elapsedRealtime();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f30617e) {
            return;
        }
        this.f30619g = SystemClock.elapsedRealtime();
        this.f30617e = true;
    }

    @Override // c.i.b.a.i0.h
    public c.i.b.a.p c(c.i.b.a.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar)) == null) {
            if (this.f30617e) {
                a(q());
            }
            this.f30620h = pVar;
            return pVar;
        }
        return (c.i.b.a.p) invokeL.objValue;
    }

    @Override // c.i.b.a.i0.h
    public c.i.b.a.p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30620h : (c.i.b.a.p) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f30617e) {
            a(q());
            this.f30617e = false;
        }
    }

    @Override // c.i.b.a.i0.h
    public long q() {
        InterceptResult invokeV;
        long a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long j2 = this.f30618f;
            if (this.f30617e) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f30619g;
                c.i.b.a.p pVar = this.f30620h;
                if (pVar.a == 1.0f) {
                    a = c.i.b.a.b.a(elapsedRealtime);
                } else {
                    a = pVar.a(elapsedRealtime);
                }
                return j2 + a;
            }
            return j2;
        }
        return invokeV.longValue;
    }
}
