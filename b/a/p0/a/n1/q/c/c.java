package b.a.p0.a.n1.q.c;

import b.a.p0.a.a2.e;
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

    /* renamed from: a  reason: collision with root package name */
    public final String f6950a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f6951b;

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
        this.f6950a = "SwanAppPayCheckNode";
    }

    @Override // b.a.p0.a.n1.q.c.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "payinfo" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.n1.q.c.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = this.f6951b;
        }
    }

    @Override // b.a.p0.a.n1.q.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = this.f6951b;
        }
    }

    @Override // b.a.p0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        e P;
        b.a.p0.a.e2.a S;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            boolean z = this.f6951b;
            if (jSONObject == null || (P = e.P()) == null || (S = P.S()) == null) {
                return;
            }
            S.B("note_data_pay_check_list", jSONObject.toString());
        }
    }
}
