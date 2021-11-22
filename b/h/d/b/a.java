package b.h.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.cache.LongAddables;
/* loaded from: classes6.dex */
public final class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final g f33843a;

    /* renamed from: b  reason: collision with root package name */
    public final g f33844b;

    /* renamed from: c  reason: collision with root package name */
    public final g f33845c;

    /* renamed from: d  reason: collision with root package name */
    public final g f33846d;

    /* renamed from: e  reason: collision with root package name */
    public final g f33847e;

    /* renamed from: f  reason: collision with root package name */
    public final g f33848f;

    public a() {
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
        this.f33843a = LongAddables.a();
        this.f33844b = LongAddables.a();
        this.f33845c = LongAddables.a();
        this.f33846d = LongAddables.a();
        this.f33847e = LongAddables.a();
        this.f33848f = LongAddables.a();
    }

    public static long h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            if (j >= 0) {
                return j;
            }
            return Long.MAX_VALUE;
        }
        return invokeJ.longValue;
    }

    @Override // b.h.d.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f33843a.add(i2);
        }
    }

    @Override // b.h.d.b.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f33848f.increment();
        }
    }

    @Override // b.h.d.b.b
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f33845c.increment();
            this.f33847e.add(j);
        }
    }

    @Override // b.h.d.b.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f33844b.add(i2);
        }
    }

    @Override // b.h.d.b.b
    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f33846d.increment();
            this.f33847e.add(j);
        }
    }

    @Override // b.h.d.b.b
    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new d(h(this.f33843a.sum()), h(this.f33844b.sum()), h(this.f33845c.sum()), h(this.f33846d.sum()), h(this.f33847e.sum()), h(this.f33848f.sum())) : (d) invokeV.objValue;
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            d f2 = bVar.f();
            this.f33843a.add(f2.b());
            this.f33844b.add(f2.e());
            this.f33845c.add(f2.d());
            this.f33846d.add(f2.c());
            this.f33847e.add(f2.f());
            this.f33848f.add(f2.a());
        }
    }
}
