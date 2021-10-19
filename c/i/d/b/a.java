package c.i.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.cache.LongAddables;
/* loaded from: classes4.dex */
public final class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final g f34201a;

    /* renamed from: b  reason: collision with root package name */
    public final g f34202b;

    /* renamed from: c  reason: collision with root package name */
    public final g f34203c;

    /* renamed from: d  reason: collision with root package name */
    public final g f34204d;

    /* renamed from: e  reason: collision with root package name */
    public final g f34205e;

    /* renamed from: f  reason: collision with root package name */
    public final g f34206f;

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
        this.f34201a = LongAddables.a();
        this.f34202b = LongAddables.a();
        this.f34203c = LongAddables.a();
        this.f34204d = LongAddables.a();
        this.f34205e = LongAddables.a();
        this.f34206f = LongAddables.a();
    }

    public static long h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) {
            if (j2 >= 0) {
                return j2;
            }
            return Long.MAX_VALUE;
        }
        return invokeJ.longValue;
    }

    @Override // c.i.d.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f34201a.add(i2);
        }
    }

    @Override // c.i.d.b.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f34206f.increment();
        }
    }

    @Override // c.i.d.b.b
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f34203c.increment();
            this.f34205e.add(j2);
        }
    }

    @Override // c.i.d.b.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f34202b.add(i2);
        }
    }

    @Override // c.i.d.b.b
    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f34204d.increment();
            this.f34205e.add(j2);
        }
    }

    @Override // c.i.d.b.b
    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new d(h(this.f34201a.sum()), h(this.f34202b.sum()), h(this.f34203c.sum()), h(this.f34204d.sum()), h(this.f34205e.sum()), h(this.f34206f.sum())) : (d) invokeV.objValue;
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            d f2 = bVar.f();
            this.f34201a.add(f2.b());
            this.f34202b.add(f2.e());
            this.f34203c.add(f2.d());
            this.f34204d.add(f2.c());
            this.f34205e.add(f2.f());
            this.f34206f.add(f2.a());
        }
    }
}
