package c.a.n0.e.a.e;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements c.a.n0.e.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public int f8183b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8184c;

    public a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8183b = -1;
        c(context);
    }

    @Override // c.a.n0.e.a.b
    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8184c && (bVar = this.a) != null && bVar.c()) {
            this.f8184c = false;
            if (this.a.b()) {
                g();
            } else {
                f();
            }
        }
    }

    @Override // c.a.n0.e.a.b
    public void b(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.f8184c || (bVar = this.a) == null || !bVar.c()) {
            return;
        }
        this.f8184c = true;
        if (this.a.b()) {
            e(i);
        } else {
            d(i);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = b.a(context);
        }
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int g2 = this.a.g();
            this.f8183b = g2;
            if (g2 != -1) {
                c.a.n0.e.a.d.b f2 = c.a.n0.e.a.h.a.f();
                int i2 = f2.a;
                if (i2 < 1) {
                    i2 = 10;
                }
                int a = f2.a() <= 0 ? LocalConstant.NEXTSUFFIX : f2.a();
                int i3 = i2;
                this.a.h(this.f8183b, 0, i3, -1, -1, -1);
                this.a.h(this.f8183b, 2, i3, i2, -1, -1);
                int i4 = a;
                this.a.h(this.f8183b, 4, i4, -1, -1, -1);
                this.a.h(this.f8183b, 6, i4, a, -1, -1);
                this.a.h(this.f8183b, 15, i2, i2, i2, i2);
                this.a.h(this.f8183b, 17, a, a, a, a);
                this.a.e(this.f8183b, i);
            }
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            c.a.n0.e.a.d.b f2 = c.a.n0.e.a.h.a.f();
            int i2 = f2.a;
            if (i2 < 1) {
                i2 = 10;
            }
            int a = f2.a() <= 0 ? LocalConstant.NEXTSUFFIX : f2.a();
            int f3 = this.a.f(i2, a, i2, a);
            this.f8183b = f3;
            if (f3 != -1) {
                this.a.e(f3, i);
            }
        }
    }

    public final void f() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (i = this.f8183b) == -1) {
            return;
        }
        this.a.d(i);
        this.a.j(this.f8183b);
    }

    public final void g() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (i = this.f8183b) == -1) {
            return;
        }
        this.a.d(i);
        this.a.i(this.f8183b);
    }
}
