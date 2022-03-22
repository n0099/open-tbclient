package c.a.n0.e.a.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
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
    public boolean f8169b;

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
        this.f8169b = false;
        c(context);
    }

    @Override // c.a.n0.e.a.b
    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8169b && (bVar = this.a) != null && bVar.b()) {
            this.f8169b = false;
            this.a.c(6, "", new int[0]);
            this.a.c(3, "", new int[0]);
            this.a.c(12, "", new int[0]);
            this.a.c(9, "", new int[0]);
        }
    }

    @Override // c.a.n0.e.a.b
    public void b(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && !this.f8169b && (bVar = this.a) != null && bVar.b() && this.a.c(12, "", new int[0]) == 0) {
            this.f8169b = true;
            this.a.c(5, "", new int[0]);
            this.a.c(2, "", new int[0]);
            this.a.c(11, "", new int[0]);
            this.a.c(8, "", new int[0]);
            this.a.c(39, "", new int[0]);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = b.a(context);
        }
    }
}
