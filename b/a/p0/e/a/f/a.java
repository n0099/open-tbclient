package b.a.p0.e.a.f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements b.a.p0.e.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f10236a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10237b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10238c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10239d;

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

    @Override // b.a.p0.e.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10236a != null && this.f10237b && d()) {
            this.f10237b = false;
            if (this.f10236a.c()) {
                this.f10236a.e(12, 0);
                this.f10236a.e(13, 0);
                return;
            }
            this.f10236a.d(12, 0);
            this.f10236a.d(13, 0);
        }
    }

    @Override // b.a.p0.e.a.b
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f10236a == null || this.f10237b || !d()) {
            return;
        }
        this.f10237b = true;
        if (this.f10236a.c()) {
            this.f10236a.e(12, i2);
            this.f10236a.e(13, i2);
            return;
        }
        this.f10236a.d(12, i2);
        this.f10236a.d(13, i2);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.f10236a == null) {
            this.f10236a = b.a(context);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.f10239d) {
                this.f10239d = true;
                this.f10238c = this.f10236a.g();
            }
            return this.f10238c;
        }
        return invokeV.booleanValue;
    }
}
