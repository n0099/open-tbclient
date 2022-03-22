package c.a.n0.i.d;

import androidx.annotation.NonNull;
import c.a.n0.a.f.d.l1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements l1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f8550c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.i.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public b f8551b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f8550c == null) {
                synchronized (c.class) {
                    if (f8550c == null) {
                        f8550c = new c();
                    }
                }
            }
            return f8550c;
        }
        return (c) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.d.l1
    public c.a.n0.a.k.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull c.a.n0.a.k0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, bVar);
            }
            if (this.a.f()) {
                return this.f8551b.a(str, jSONObject, bVar);
            }
            return new c.a.n0.a.k.h.b(10001, "authorize fail.");
        }
        return (c.a.n0.a.k.h.b) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new c.a.n0.i.b.b();
            this.f8551b = new b();
        }
    }
}
