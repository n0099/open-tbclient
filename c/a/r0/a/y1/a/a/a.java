package c.a.r0.a.y1.a.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9824e;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;

    /* renamed from: b  reason: collision with root package name */
    public int f9825b;

    /* renamed from: c  reason: collision with root package name */
    public String f9826c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f9827d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(701682324, "Lc/a/r0/a/y1/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(701682324, "Lc/a/r0/a/y1/a/a/a;");
                return;
            }
        }
        f9824e = k.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Bundle();
        this.f9826c = "";
        this.f9827d = new Bundle();
    }

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(this.f9827d);
        }
    }

    public void d(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            boolean z = f9824e;
            if (c.a.r0.a.y1.a.b.d.a.a(this.f9826c)) {
                return;
            }
            if (f9824e) {
                String str = "messenger delegation finish with send result to client: " + this.f9825b + " observer: " + this.f9826c;
            }
            b.c(this.f9825b, this.f9826c, bundle);
        }
    }
}
