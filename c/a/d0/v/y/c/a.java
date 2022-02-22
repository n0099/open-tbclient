package c.a.d0.v.y.c;

import c.a.d0.v.v0.r;
import c.a.d0.v.y.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@JvmName(name = "AuthStrategyHelper")
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b a;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host", "vdept3.bdstatic.com");
                jSONObject2.put("auth", "1_1_1_3");
                jSONArray.put(jSONObject2);
                jSONObject.put("hosts", jSONArray);
            } catch (Exception e2) {
                c.a.d0.i.a.c("AuthStrategyHelper", e2.toString());
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "defaultHostAuthConfig.toString()");
            return jSONObject3;
        }
        return (String) invokeV.objValue;
    }

    public static final List<c.a.d0.v.y.a.a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = c.a.d0.v.y.b.a.a(r.l().getString("host_auth_config", a()));
            }
            b bVar = a;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public static final synchronized c.a.d0.v.y.a.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (a.class) {
                if (str != null) {
                    List<c.a.d0.v.y.a.a> b2 = b();
                    if (b2 != null) {
                        try {
                            String host = new URL(str).getHost();
                            for (c.a.d0.v.y.a.a aVar : b2) {
                                if (Pattern.matches(aVar.b(), host)) {
                                    return aVar;
                                }
                            }
                        } catch (Exception e2) {
                            c.a.d0.i.a.a("AuthStrategyHelper", e2.getMessage());
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
        }
        return (c.a.d0.v.y.a.a) invokeL.objValue;
    }
}
