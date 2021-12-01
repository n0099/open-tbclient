package c.a.p0.a.p1.r.c;

import c.a.p0.a.d2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f7459b;

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
        this.a = "SwanAppPayCheckNode";
    }

    @Override // c.a.p0.a.p1.r.c.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "payinfo" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.p1.r.c.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = this.f7459b;
        }
    }

    @Override // c.a.p0.a.p1.r.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = this.f7459b;
        }
    }

    @Override // c.a.p0.a.p1.r.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        e a0;
        c.a.p0.a.h2.a d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            boolean z = this.f7459b;
            if (jSONObject == null || (a0 = e.a0()) == null || (d0 = a0.d0()) == null) {
                return;
            }
            d0.B("note_data_pay_check_list", jSONObject.toString());
        }
    }
}
