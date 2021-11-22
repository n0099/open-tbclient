package b.a.p0.e.a.g;

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
    public int[] f10246a;

    /* renamed from: b  reason: collision with root package name */
    public b f10247b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10248c;

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
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f10248c && (bVar = this.f10247b) != null && bVar.c()) {
            this.f10248c = false;
            this.f10247b.f();
        }
    }

    @Override // b.a.p0.e.a.b
    public void b(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f10248c || (bVar = this.f10247b) == null || !bVar.c()) {
            return;
        }
        this.f10248c = true;
        this.f10247b.e(i2, this.f10246a);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.f10247b == null) {
            this.f10247b = b.b(context);
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f10246a == null) {
            b.a.p0.e.a.d.b f2 = b.a.p0.e.a.h.a.f();
            if (f2.f10215a <= 4) {
                this.f10246a = new int[]{1082130432, 4095, 1082146816, 4095, 1098907648, 4095, 1098956800, 0, 1077936128, 1};
            } else if (f2.f10222h && f2.d()) {
                this.f10246a = new int[]{1082130688, 4095, 1082147072, 4095, 1082130432, 4095, 1082146816, 4095, 1082130944, 4095, 1082147328, 4095, 1098907648, 4095, 1115734016, 4095, 1115750400, 4095, 1115766784, 4095, 1098956800, 0, 1077936128, 1};
            } else {
                this.f10246a = new int[]{1082130688, 4095, 1082147072, 4095, 1082130432, 4095, 1082146816, 4095, 1098907648, 4095, 1098956800, 0, 1077936128, 1};
            }
        }
    }
}
