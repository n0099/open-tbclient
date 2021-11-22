package b.a.p0.m.l.e;

import android.content.Context;
import b.a.p0.a.k;
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
/* loaded from: classes4.dex */
public class c extends b.a.p0.m.l.a<b.a.p0.a.i1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1960870863, "Lb/a/p0/m/l/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1960870863, "Lb/a/p0/m/l/e/c;");
                return;
            }
        }
        boolean z = k.f6863a;
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

    @Override // b.a.p0.m.l.a
    public boolean b(Context context, b.a.p0.a.i1.c.c cVar, b.a.p0.a.i1.b bVar, b.a.p0.a.d2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? e(context, cVar, bVar, eVar, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, b.a.p0.a.i1.c.c cVar, b.a.p0.a.i1.b bVar, b.a.p0.a.d2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar, eVar, jSONObject)) == null) {
            b.a.p0.a.e0.d.i("map", "GetScaleAction start");
            b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.U().A(cVar.f4197g);
            if (!(A instanceof b.a.p0.a.p.e.b)) {
                b.a.p0.a.e0.d.c("map", "WebViewManager is null");
                return false;
            }
            b.a.p0.m.o.c d2 = b.a.p0.m.c.b().c((b.a.p0.a.p.e.b) A).d(cVar.f4196f);
            if (d2 == null) {
                b.a.p0.a.e0.d.c("map", "can not find map by id " + cVar.f4196f);
                return false;
            }
            try {
                jSONObject.put("scale", d2.l.getMap().getMapStatus().zoom);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b.a.p0.a.e0.d.i("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
