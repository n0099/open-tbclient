package c.a.o0.a.v1.a.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.a.k;
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
    public static final boolean f9171e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f9172a;

    /* renamed from: b  reason: collision with root package name */
    public int f9173b;

    /* renamed from: c  reason: collision with root package name */
    public String f9174c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f9175d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-949213004, "Lc/a/o0/a/v1/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-949213004, "Lc/a/o0/a/v1/a/a/a;");
                return;
            }
        }
        f9171e = k.f7049a;
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
        this.f9172a = new Bundle();
        this.f9174c = "";
        this.f9175d = new Bundle();
    }

    public abstract void b(@NonNull Bundle bundle);

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(this.f9175d);
        }
    }

    public void d(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            boolean z = f9171e;
            if (c.a.o0.a.v1.a.b.d.a.a(this.f9174c)) {
                return;
            }
            if (f9171e) {
                String str = "messenger delegation finish with send result to client: " + this.f9173b + " observer: " + this.f9174c;
            }
            b.c(this.f9173b, this.f9174c, bundle);
        }
    }
}
