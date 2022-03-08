package c.a.p0.m.f.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends c.a.p0.m.f.a<c.a.p0.a.y0.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998319592, "Lc/a/p0/m/f/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-998319592, "Lc/a/p0/m/f/e/a;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
    }

    public a() {
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

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    @Override // c.a.p0.m.f.a
    public boolean b(Context context, c.a.p0.a.y0.c.c cVar, c.a.p0.a.y0.b bVar, c.a.p0.a.t1.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? e(context, cVar, bVar, eVar, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, c.a.p0.a.y0.c.c cVar, c.a.p0.a.y0.b bVar, c.a.p0.a.t1.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar, eVar, jSONObject)) == null) {
            c.a.p0.a.u.d.i("map", "GetCenterLcationAction start");
            c.a.p0.a.f.e.d A = c.a.p0.a.w0.f.U().A(cVar.f7284g);
            if (!(A instanceof c.a.p0.a.f.e.b)) {
                c.a.p0.a.u.d.c("map", "WebViewManager is null");
                return false;
            }
            c.a.p0.m.i.c d2 = c.a.p0.m.c.b().c((c.a.p0.a.f.e.b) A).d(cVar.f7283f);
            if (d2 == null) {
                c.a.p0.a.u.d.c("map", "can not find map by id " + cVar.f7283f);
                return false;
            }
            MapStatus mapStatus = d2.l.getMap().getMapStatus();
            c.a.p0.a.y0.c.h.c cVar2 = new c.a.p0.a.y0.c.h.c();
            LatLng latLng = mapStatus.target;
            double d3 = latLng.latitude;
            cVar2.f9189e = d3;
            cVar2.f9190f = latLng.longitude;
            try {
                jSONObject.put("latitude", d3);
                jSONObject.put("longitude", cVar2.f9190f);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.p0.a.u.d.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
