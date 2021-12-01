package c.a.p0.a.k1;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.e;
import c.a.p0.a.g1.f;
import c.a.p0.a.h;
import c.a.p0.a.p.d.j1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.u.e.e.a {
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

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "SwanCallImageMenuApi" : (String) invokeV.objValue;
    }

    public c.a.p0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#callImageMenu", false);
            if (e.a0() == null) {
                return new c.a.p0.a.u.h.b(1001, "swan app is null");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("imageURL");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(202, c.a.p0.a.c1.a.c().getString(h.united_scheme_err_message_params_parse_fail));
                }
                return y(optString);
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            c.a.p0.a.p.e.c h2 = f.U().h();
            if (!(h2 instanceof NgWebView)) {
                return new c.a.p0.a.u.h.b(1001, "call image menu fail");
            }
            j1 E0 = c.a.p0.a.c1.a.E0();
            if (E0 == null) {
                return new c.a.p0.a.u.h.b(1001, "call image menu fail");
            }
            E0.b((NgWebView) h2, str);
            return c.a.p0.a.u.h.b.f();
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
