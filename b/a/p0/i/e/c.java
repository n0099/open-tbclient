package b.a.p0.i.e;

import androidx.annotation.NonNull;
import b.a.p0.a.p.d.l1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements l1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f10819c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.i.c.b f10820a;

    /* renamed from: b  reason: collision with root package name */
    public b f10821b;

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
            if (f10819c == null) {
                synchronized (c.class) {
                    if (f10819c == null) {
                        f10819c = new c();
                    }
                }
            }
            return f10819c;
        }
        return (c) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.d.l1
    public b.a.p0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull b.a.p0.a.u0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) {
            if (this.f10820a.e(str)) {
                return this.f10820a.a(str, jSONObject, bVar);
            }
            if (this.f10820a.f()) {
                return this.f10821b.a(str, jSONObject, bVar);
            }
            return new b.a.p0.a.u.h.b(10001, "authorize fail.");
        }
        return (b.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10820a = new b.a.p0.i.c.b();
            this.f10821b = new b();
        }
    }
}
