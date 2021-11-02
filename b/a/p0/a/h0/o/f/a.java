package b.a.p0.a.h0.o.f;

import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.u.c.b;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.w;
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

    public b.a.p0.a.u.h.b q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (b.a.p0.a.h0.o.g.a.f5647a) {
                String str2 = "receive prefetchResources data = " + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                return (b.a.p0.a.u.h.b) b2.first;
            }
            if (!SwanAppNetworkUtils.i(b.a.p0.a.c1.a.b())) {
                return new b.a.p0.a.u.h.b(1001, "network disconnected");
            }
            JSONArray c2 = w.c(jSONObject, "video");
            if (c2 != null && c2.length() > 0) {
                b.a.p0.a.c1.a.P().a(c2);
            }
            JSONArray c3 = w.c(jSONObject, "image");
            if (c3 != null && c3.length() > 0) {
                b.a.p0.a.c1.a.P().c(c3);
            }
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
