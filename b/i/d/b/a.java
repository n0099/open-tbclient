package b.i.d.b;

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
    public final g f32985a;

    /* renamed from: b  reason: collision with root package name */
    public final g f32986b;

    /* renamed from: c  reason: collision with root package name */
    public final g f32987c;

    /* renamed from: d  reason: collision with root package name */
    public final g f32988d;

    /* renamed from: e  reason: collision with root package name */
    public final g f32989e;

    /* renamed from: f  reason: collision with root package name */
    public final g f32990f;

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
        this.f32985a = LongAddables.a();
        this.f32986b = LongAddables.a();
        this.f32987c = LongAddables.a();
        this.f32988d = LongAddables.a();
        this.f32989e = LongAddables.a();
        this.f32990f = LongAddables.a();
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

    @Override // b.i.d.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f32985a.add(i2);
        }
    }

    @Override // b.i.d.b.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32990f.increment();
        }
    }

    @Override // b.i.d.b.b
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f32987c.increment();
            this.f32989e.add(j);
        }
    }

    @Override // b.i.d.b.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f32986b.add(i2);
        }
    }

    @Override // b.i.d.b.b
    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f32988d.increment();
            this.f32989e.add(j);
        }
    }

    @Override // b.i.d.b.b
    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new d(h(this.f32985a.sum()), h(this.f32986b.sum()), h(this.f32987c.sum()), h(this.f32988d.sum()), h(this.f32989e.sum()), h(this.f32990f.sum())) : (d) invokeV.objValue;
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            d f2 = bVar.f();
            this.f32985a.add(f2.b());
            this.f32986b.add(f2.e());
            this.f32987c.add(f2.d());
            this.f32988d.add(f2.c());
            this.f32989e.add(f2.f());
            this.f32990f.add(f2.a());
        }
    }
}
