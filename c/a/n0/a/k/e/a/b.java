package c.a.n0.a.k.e.a;

import android.content.Context;
import androidx.annotation.NonNull;
import c.a.n0.a.f.c.h;
import c.a.n0.a.f.d.n;
import c.a.n0.a.p2.w;
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
    public b(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
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
            boolean h2 = SwanAppAllianceLoginHelper.f28743d.h();
            if (h2) {
                return h2;
            }
            n h0 = c.a.n0.a.s0.a.h0();
            return h0 instanceof h ? ((h) h0).k(context) : h2;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "BaiduAccountApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isBaiduAccountSync", false);
            if (c.a.n0.a.t1.e.a0() == null) {
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            }
            boolean y = y(getContext());
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "isBaiduAccount", Boolean.valueOf(y));
            return new c.a.n0.a.k.h.b(0, jSONObject);
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }
}
