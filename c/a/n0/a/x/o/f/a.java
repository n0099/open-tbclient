package c.a.n0.a.x.o.f;

import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.k.c.b;
import c.a.n0.a.k.c.d;
import c.a.n0.a.p2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b bVar) {
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
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Prefetch" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "SwanPrefetchResourcesApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#prefetchResources params=" + str, false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return (c.a.n0.a.k.h.b) s.first;
            }
            if (!SwanAppNetworkUtils.i(c.a.n0.a.s0.a.c())) {
                return new c.a.n0.a.k.h.b(1001, "network disconnected");
            }
            JSONArray c2 = w.c(jSONObject, "video");
            if (c2 != null && c2.length() > 0) {
                c.a.n0.a.s0.a.U().a(c2);
            }
            JSONArray c3 = w.c(jSONObject, "image");
            if (c3 != null && c3.length() > 0) {
                c.a.n0.a.s0.a.U().c(c3);
            }
            return c.a.n0.a.k.h.b.f();
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }
}
