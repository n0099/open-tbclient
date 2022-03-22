package c.a.n0.m.f.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends c.a.n0.m.f.a<c.a.n0.a.y0.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699384108, "Lc/a/n0/m/f/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699384108, "Lc/a/n0/m/f/e/c;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // c.a.n0.m.f.a
    public boolean b(Context context, c.a.n0.a.y0.c.c cVar, c.a.n0.a.y0.b bVar, c.a.n0.a.t1.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? e(context, cVar, bVar, eVar, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, c.a.n0.a.y0.c.c cVar, c.a.n0.a.y0.b bVar, c.a.n0.a.t1.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar, eVar, jSONObject)) == null) {
            c.a.n0.a.u.d.i("map", "GetScaleAction start");
            c.a.n0.a.f.e.d A = c.a.n0.a.w0.f.U().A(cVar.f6097c);
            if (!(A instanceof c.a.n0.a.f.e.b)) {
                c.a.n0.a.u.d.c("map", "WebViewManager is null");
                return false;
            }
            c.a.n0.m.i.c d2 = c.a.n0.m.c.b().c((c.a.n0.a.f.e.b) A).d(cVar.f6096b);
            if (d2 == null) {
                c.a.n0.a.u.d.c("map", "can not find map by id " + cVar.f6096b);
                return false;
            }
            try {
                jSONObject.put(AnimationProperty.SCALE, d2.l.getMap().getMapStatus().zoom);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.n0.a.u.d.i("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
