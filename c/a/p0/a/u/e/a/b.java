package c.a.p0.a.u.e.a;

import android.content.Context;
import androidx.annotation.NonNull;
import c.a.p0.a.p.c.h;
import c.a.p0.a.p.d.n;
import c.a.p0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
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
    public b(@NonNull c.a.p0.a.u.c.b bVar) {
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
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            boolean h2 = SwanAppAllianceLoginHelper.f39311d.h();
            if (h2) {
                return h2;
            }
            n h0 = c.a.p0.a.c1.a.h0();
            return h0 instanceof h ? ((h) h0).k(context) : h2;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "BaiduAccountApi" : (String) invokeV.objValue;
    }

    public c.a.p0.a.u.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isBaiduAccountSync", false);
            if (c.a.p0.a.d2.e.a0() == null) {
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            }
            boolean y = y(getContext());
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "isBaiduAccount", Boolean.valueOf(y));
            return new c.a.p0.a.u.h.b(0, jSONObject);
        }
        return (c.a.p0.a.u.h.b) invokeV.objValue;
    }
}
