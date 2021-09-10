package c.a.p0.j.k.e;

import android.content.Context;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends c.a.p0.j.k.a<c.a.p0.a.h1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1788637484, "Lc/a/p0/j/k/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1788637484, "Lc/a/p0/j/k/e/c;");
                return;
            }
        }
        boolean z = k.f7077a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new c() : (c) invokeV.objValue;
    }

    @Override // c.a.p0.j.k.a
    public boolean b(Context context, c.a.p0.a.h1.c.c cVar, c.a.p0.a.h1.b bVar, c.a.p0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? e(context, cVar, bVar, eVar, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, c.a.p0.a.h1.c.c cVar, c.a.p0.a.h1.b bVar, c.a.p0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar, eVar, jSONObject)) == null) {
            c.a.p0.a.e0.d.g("map", "GetScaleAction start");
            c.a.p0.a.p.e.d B = c.a.p0.a.g1.f.V().B(cVar.f4658g);
            if (!(B instanceof c.a.p0.a.p.e.b)) {
                c.a.p0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            c.a.p0.j.n.c d2 = c.a.p0.j.c.b().c((c.a.p0.a.p.e.b) B).d(cVar.f4657f);
            if (d2 == null) {
                c.a.p0.a.e0.d.b("map", "can not find map by id " + cVar.f4657f);
                return false;
            }
            try {
                jSONObject.put("scale", d2.l.getMap().getMapStatus().zoom);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.p0.a.e0.d.g("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
