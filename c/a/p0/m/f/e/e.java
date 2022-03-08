package c.a.p0.m.f.e;

import android.content.Context;
import c.a.p0.a.s0.d.e;
import c.a.p0.m.f.f.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c.a.p0.m.f.a<c.a.p0.a.y0.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.i.c f10818b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.b f10819c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f10820d;

        public a(e eVar, Context context, c.a.p0.m.i.c cVar, c.a.p0.m.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10820d = eVar;
            this.a = context;
            this.f10818b = cVar;
            this.f10819c = bVar;
        }

        @Override // c.a.p0.m.f.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.u.d.o("map", "location permission fail");
            }
        }

        @Override // c.a.p0.m.f.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.u.d.o("map", "location permission success");
                this.f10820d.e(this.a, this.f10818b, this.f10819c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.m.i.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.b f10821b;

        public b(e eVar, c.a.p0.m.i.c cVar, c.a.p0.m.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.f10821b = bVar;
        }

        @Override // c.a.p0.a.s0.d.e.a
        public void a(c.a.p0.a.v1.f.j0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.p0.a.u.d.i("map", "get location " + bVar.a().toString());
                BaiduMap map = this.a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f8012c, bVar.f8011b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f8014e).latitude(bVar.f8012c).longitude(bVar.f8011b).build());
                this.f10821b.p(true);
            }
        }

        @Override // c.a.p0.a.s0.d.e.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.a.u.d.i("map", "get location error " + i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-998319468, "Lc/a/p0/m/f/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-998319468, "Lc/a/p0/m/f/e/e;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
    }

    public e() {
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

    public static e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new e() : (e) invokeV.objValue;
    }

    @Override // c.a.p0.m.f.a
    public boolean b(Context context, c.a.p0.a.y0.c.c cVar, c.a.p0.a.y0.b bVar, c.a.p0.a.t1.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? g(context, cVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void e(Context context, c.a.p0.m.i.c cVar, c.a.p0.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar) == null) {
            c.a.p0.a.s0.a.I().b("gcj02", true, false, new b(this, cVar, bVar));
        }
    }

    public final boolean g(Context context, c.a.p0.a.y0.c.c cVar, c.a.p0.a.y0.b bVar, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar, bVar, eVar)) == null) {
            c.a.p0.a.u.d.i("map", "MoveToLocationAction start");
            c.a.p0.a.f.e.d A = c.a.p0.a.w0.f.U().A(cVar.f7284g);
            if (!(A instanceof c.a.p0.a.f.e.b)) {
                c.a.p0.a.u.d.c("map", "WebViewManager is null");
                return false;
            }
            c.a.p0.m.b c2 = c.a.p0.m.c.b().c((c.a.p0.a.f.e.b) A);
            c.a.p0.m.i.c d2 = c2.d(cVar.f7283f);
            if (d2 == null) {
                c.a.p0.a.u.d.c("map", "can not find map by id " + cVar.f7283f);
                return false;
            } else if (!d2.k) {
                c.a.p0.a.u.d.o("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e2 = c2.e();
                if (e2 != null && c2.g()) {
                    d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                    d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d2.l.getMap().setMyLocationEnabled(true);
                    d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                    c.a.p0.a.u.d.i("map", "MoveToLocationAction end");
                    return true;
                }
                c.a.p0.m.f.f.d.b(context, new a(this, context, d2, c2));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
