package c.a.r0.a.h0.o.f;

import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.u.c.b;
import c.a.r0.a.u.c.d;
import c.a.r0.a.z2.w;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Prefetch" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "SwanPrefetchResourcesApi" : (String) invokeV.objValue;
    }

    public c.a.r0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#prefetchResources params=" + str, false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return (c.a.r0.a.u.h.b) s.first;
            }
            if (!SwanAppNetworkUtils.i(c.a.r0.a.c1.a.c())) {
                return new c.a.r0.a.u.h.b(1001, "network disconnected");
            }
            JSONArray c2 = w.c(jSONObject, "video");
            if (c2 != null && c2.length() > 0) {
                c.a.r0.a.c1.a.U().a(c2);
            }
            JSONArray c3 = w.c(jSONObject, "image");
            if (c3 != null && c3.length() > 0) {
                c.a.r0.a.c1.a.U().c(c3);
            }
            return c.a.r0.a.u.h.b.f();
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }
}
