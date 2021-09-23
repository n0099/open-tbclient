package c.a.p0.a.j1;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.e;
import c.a.p0.a.g1.f;
import c.a.p0.a.h;
import c.a.p0.a.p.d.d1;
import c.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d {
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

    public c.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = d.f8735c;
            if (e.Q() == null) {
                return new c.a.p0.a.u.h.b(1001, "null swan runtime");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-callImageMenu", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f8735c) {
                    c.a.p0.a.e0.d.b("Api-callImageMenu", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("imageURL");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.p0.a.u.h.b(202, c.a.p0.a.c1.a.b().getString(h.united_scheme_err_message_params_parse_fail));
            }
            return s(optString);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.p0.a.p.e.c h2 = f.V().h();
            if (!(h2 instanceof NgWebView)) {
                return new c.a.p0.a.u.h.b(1001, "call image menu fail");
            }
            d1 t0 = c.a.p0.a.c1.a.t0();
            if (t0 == null) {
                return new c.a.p0.a.u.h.b(1001, "call image menu fail");
            }
            t0.b((NgWebView) h2, str);
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
