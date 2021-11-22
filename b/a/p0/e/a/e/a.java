package b.a.p0.e.a.e;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements b.a.p0.e.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f10224a;

    /* renamed from: b  reason: collision with root package name */
    public int f10225b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10226c;

    public a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10225b = -1;
        c(context);
    }

    @Override // b.a.p0.e.a.b
    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10226c && (bVar = this.f10224a) != null && bVar.c()) {
            this.f10226c = false;
            if (this.f10224a.b()) {
                g();
            } else {
                f();
            }
        }
    }

    @Override // b.a.p0.e.a.b
    public void b(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f10226c || (bVar = this.f10224a) == null || !bVar.c()) {
            return;
        }
        this.f10226c = true;
        if (this.f10224a.b()) {
            e(i2);
        } else {
            d(i2);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.f10224a == null) {
            this.f10224a = b.a(context);
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int g2 = this.f10224a.g();
            this.f10225b = g2;
            if (g2 != -1) {
                b.a.p0.e.a.d.b f2 = b.a.p0.e.a.h.a.f();
                int i3 = f2.f10215a;
                if (i3 < 1) {
                    i3 = 10;
                }
                int a2 = f2.a() <= 0 ? 10000000 : f2.a();
                int i4 = i3;
                this.f10224a.h(this.f10225b, 0, i4, -1, -1, -1);
                this.f10224a.h(this.f10225b, 2, i4, i3, -1, -1);
                int i5 = a2;
                this.f10224a.h(this.f10225b, 4, i5, -1, -1, -1);
                this.f10224a.h(this.f10225b, 6, i5, a2, -1, -1);
                this.f10224a.h(this.f10225b, 15, i3, i3, i3, i3);
                this.f10224a.h(this.f10225b, 17, a2, a2, a2, a2);
                this.f10224a.e(this.f10225b, i2);
            }
        }
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            b.a.p0.e.a.d.b f2 = b.a.p0.e.a.h.a.f();
            int i3 = f2.f10215a;
            if (i3 < 1) {
                i3 = 10;
            }
            int a2 = f2.a() <= 0 ? 10000000 : f2.a();
            int f3 = this.f10224a.f(i3, a2, i3, a2);
            this.f10225b = f3;
            if (f3 != -1) {
                this.f10224a.e(f3, i2);
            }
        }
    }

    public final void f() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (i2 = this.f10225b) == -1) {
            return;
        }
        this.f10224a.d(i2);
        this.f10224a.j(this.f10225b);
    }

    public final void g() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (i2 = this.f10225b) == -1) {
            return;
        }
        this.f10224a.d(i2);
        this.f10224a.i(this.f10225b);
    }
}
