package c.a.n0.a.a1;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.g.g;
import c.a.n0.a.x.g.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.n0.a.k.e.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.n0.a.k.c.b bVar) {
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

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "UpdateMenuStyleApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#changeMenuStyle", false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((c.a.n0.a.k.h.b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.n0.a.k.h.b(202);
                }
                int y = y(optString);
                f U = f.U();
                if (U == null) {
                    return new c.a.n0.a.k.h.b(1001);
                }
                g V = U.V();
                if (V == null) {
                    return new c.a.n0.a.k.h.b(1001);
                }
                c.a.n0.a.x.g.d m = V.m();
                if (m == null) {
                    return new c.a.n0.a.k.h.b(1001);
                }
                c.a.n0.n.f M1 = m.M1();
                if (M1 == null) {
                    if (m instanceof k) {
                        ((k) m).h3(y);
                        return c.a.n0.a.k.h.b.f();
                    }
                    return new c.a.n0.a.k.h.b(1001);
                }
                M1.e(y);
                M1.z();
                return c.a.n0.a.k.h.b.f();
            }
            return new c.a.n0.a.k.h.b(202);
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public final int y(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1866956286) {
                if (hashCode == -838846263 && str.equals("update")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("webDegrade")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                return c2 != 1 ? 12 : 20;
            }
            return 19;
        }
        return invokeL.intValue;
    }
}
