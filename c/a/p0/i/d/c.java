package c.a.p0.i.d;

import androidx.annotation.NonNull;
import c.a.p0.a.f.d.l1;
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
    public static volatile c f10217c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.i.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public b f10218b;

    public c() {
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
        c();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f10217c == null) {
                synchronized (c.class) {
                    if (f10217c == null) {
                        f10217c = new c();
                    }
                }
            }
            return f10217c;
        }
        return (c) invokeV.objValue;
    }

    @Override // c.a.p0.a.f.d.l1
    public c.a.p0.a.k.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull c.a.p0.a.k0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, bVar);
            }
            if (this.a.f()) {
                return this.f10218b.a(str, jSONObject, bVar);
            }
            return new c.a.p0.a.k.h.b(10001, "authorize fail.");
        }
        return (c.a.p0.a.k.h.b) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new c.a.p0.i.b.b();
            this.f10218b = new b();
        }
    }
}
