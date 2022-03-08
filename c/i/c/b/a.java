package c.i.c.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.cache.LongAddables;
/* loaded from: classes3.dex */
public final class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g a;

    /* renamed from: b  reason: collision with root package name */
    public final g f28664b;

    /* renamed from: c  reason: collision with root package name */
    public final g f28665c;

    /* renamed from: d  reason: collision with root package name */
    public final g f28666d;

    /* renamed from: e  reason: collision with root package name */
    public final g f28667e;

    /* renamed from: f  reason: collision with root package name */
    public final g f28668f;

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
        this.a = LongAddables.a();
        this.f28664b = LongAddables.a();
        this.f28665c = LongAddables.a();
        this.f28666d = LongAddables.a();
        this.f28667e = LongAddables.a();
        this.f28668f = LongAddables.a();
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

    @Override // c.i.c.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.a.add(i2);
        }
    }

    @Override // c.i.c.b.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28668f.increment();
        }
    }

    @Override // c.i.c.b.b
    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f28665c.increment();
            this.f28667e.add(j2);
        }
    }

    @Override // c.i.c.b.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f28664b.add(i2);
        }
    }

    @Override // c.i.c.b.b
    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f28666d.increment();
            this.f28667e.add(j2);
        }
    }

    @Override // c.i.c.b.b
    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new d(h(this.a.sum()), h(this.f28664b.sum()), h(this.f28665c.sum()), h(this.f28666d.sum()), h(this.f28667e.sum()), h(this.f28668f.sum())) : (d) invokeV.objValue;
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            d f2 = bVar.f();
            this.a.add(f2.b());
            this.f28664b.add(f2.e());
            this.f28665c.add(f2.d());
            this.f28666d.add(f2.c());
            this.f28667e.add(f2.f());
            this.f28668f.add(f2.a());
        }
    }
}
