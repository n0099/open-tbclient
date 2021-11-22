package b.a.p0.m.l.e;

import android.content.Context;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b.a.p0.m.l.a<b.a.p0.a.i1.c.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1960870894, "Lb/a/p0/m/l/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1960870894, "Lb/a/p0/m/l/e/d;");
                return;
            }
        }
        boolean z = k.f6863a;
    }

    public d() {
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

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new d() : (d) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.m.l.a
    /* renamed from: d */
    public boolean b(Context context, b.a.p0.a.i1.c.b bVar, b.a.p0.a.i1.b bVar2, b.a.p0.a.d2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar, bVar2, eVar, jSONObject)) == null) ? f(context, bVar, bVar2, eVar) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, b.a.p0.a.i1.c.b bVar, b.a.p0.a.i1.b bVar2, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar, bVar2, eVar)) == null) {
            b.a.p0.a.e0.d.i("map", "IncludePointsAction start");
            b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.U().A(bVar.f4197g);
            if (!(A instanceof b.a.p0.a.p.e.b)) {
                b.a.p0.a.e0.d.c("map", "WebViewManager is null");
                return false;
            }
            b.a.p0.m.o.c d2 = b.a.p0.m.c.b().c((b.a.p0.a.p.e.b) A).d(bVar.f4196f);
            if (d2 == null) {
                b.a.p0.a.e0.d.c("map", "can not find map by id " + bVar.f4196f);
                return false;
            }
            b.a.p0.a.e0.d.i("map", "IncludePointsAction end");
            return g(bVar, d2);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(b.a.p0.a.i1.c.b bVar, b.a.p0.m.o.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, cVar)) == null) {
            if (bVar == null || !bVar.isValid()) {
                return false;
            }
            BaiduMap map = cVar.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<b.a.p0.a.i1.c.h.c> it = bVar.D.iterator();
            while (it.hasNext()) {
                b.a.p0.a.i1.c.h.c next = it.next();
                builder.include(new LatLng(next.f6486e, next.f6487f));
            }
            LatLngBounds build = builder.build();
            int[] iArr = bVar.E;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
