package c.a.p0.e.a.f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a implements c.a.p0.e.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9501b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9502c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9503d;

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
        c(context);
    }

    @Override // c.a.p0.e.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && this.f9501b && d()) {
            this.f9501b = false;
            if (this.a.c()) {
                this.a.e(12, 0);
                this.a.e(13, 0);
                return;
            }
            this.a.d(12, 0);
            this.a.d(13, 0);
        }
    }

    @Override // c.a.p0.e.a.b
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.a == null || this.f9501b || !d()) {
            return;
        }
        this.f9501b = true;
        if (this.a.c()) {
            this.a.e(12, i2);
            this.a.e(13, i2);
            return;
        }
        this.a.d(12, i2);
        this.a.d(13, i2);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = b.a(context);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.f9503d) {
                this.f9503d = true;
                this.f9502c = this.a.g();
            }
            return this.f9502c;
        }
        return invokeV.booleanValue;
    }
}
