package c.a.p0.a.k.e.k;

import androidx.annotation.NonNull;
import c.a.p0.a.t1.e;
import c.a.p0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.p0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ActionConfigApi" : (String) invokeV.objValue;
    }

    public c.a.p0.a.k.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isAllowedAdOpenAppSync", false);
            if (e.a0() == null) {
                return new c.a.p0.a.k.h.b(1001, "swan app is null");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isAllowed", c.a.p0.a.s0.a.a().d());
                return new c.a.p0.a.k.h.b(0, "success", jSONObject);
            } catch (Exception e2) {
                d.d("ActionConfigApi", e2.getMessage(), e2);
                return new c.a.p0.a.k.h.b(1001, e2.getMessage() + "");
            }
        }
        return (c.a.p0.a.k.h.b) invokeV.objValue;
    }
}
