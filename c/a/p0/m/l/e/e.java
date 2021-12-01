package c.a.p0.m.l.e;

import android.content.Context;
import c.a.p0.a.c1.d.e;
import c.a.p0.a.k;
import c.a.p0.m.l.f.d;
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
/* loaded from: classes5.dex */
public class e extends c.a.p0.m.l.a<c.a.p0.a.i1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.o.c f10568b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.b f10569c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f10570d;

        public a(e eVar, Context context, c.a.p0.m.o.c cVar, c.a.p0.m.b bVar) {
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
            this.f10570d = eVar;
            this.a = context;
            this.f10568b = cVar;
            this.f10569c = bVar;
        }

        @Override // c.a.p0.m.l.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.e0.d.o("map", "location permission fail");
            }
        }

        @Override // c.a.p0.m.l.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.p0.a.e0.d.o("map", "location permission success");
                this.f10570d.e(this.a, this.f10568b, this.f10569c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.m.o.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.m.b f10571b;

        public b(e eVar, c.a.p0.m.o.c cVar, c.a.p0.m.b bVar) {
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
            this.f10571b = bVar;
        }

        @Override // c.a.p0.a.c1.d.e.a
        public void a(c.a.p0.a.f2.f.j0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.p0.a.e0.d.i("map", "get location " + bVar.a().toString());
                BaiduMap map = this.a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f5130c, bVar.f5129b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f5132e).latitude(bVar.f5130c).longitude(bVar.f5129b).build());
                this.f10571b.p(true);
            }
        }

        @Override // c.a.p0.a.c1.d.e.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.a.e0.d.i("map", "get location error " + i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-826544562, "Lc/a/p0/m/l/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-826544562, "Lc/a/p0/m/l/e/e;");
                return;
            }
        }
        boolean z = k.a;
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

    @Override // c.a.p0.m.l.a
    public boolean b(Context context, c.a.p0.a.i1.c.c cVar, c.a.p0.a.i1.b bVar, c.a.p0.a.d2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? g(context, cVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void e(Context context, c.a.p0.m.o.c cVar, c.a.p0.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar) == null) {
            c.a.p0.a.c1.a.I().b("gcj02", true, false, new b(this, cVar, bVar));
        }
    }

    public final boolean g(Context context, c.a.p0.a.i1.c.c cVar, c.a.p0.a.i1.b bVar, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar, bVar, eVar)) == null) {
            c.a.p0.a.e0.d.i("map", "MoveToLocationAction start");
            c.a.p0.a.p.e.d A = c.a.p0.a.g1.f.U().A(cVar.f4378g);
            if (!(A instanceof c.a.p0.a.p.e.b)) {
                c.a.p0.a.e0.d.c("map", "WebViewManager is null");
                return false;
            }
            c.a.p0.m.b c2 = c.a.p0.m.c.b().c((c.a.p0.a.p.e.b) A);
            c.a.p0.m.o.c d2 = c2.d(cVar.f4377f);
            if (d2 == null) {
                c.a.p0.a.e0.d.c("map", "can not find map by id " + cVar.f4377f);
                return false;
            } else if (!d2.f10606k) {
                c.a.p0.a.e0.d.o("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e2 = c2.e();
                if (e2 != null && c2.g()) {
                    d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                    d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d2.l.getMap().setMyLocationEnabled(true);
                    d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                    c.a.p0.a.e0.d.i("map", "MoveToLocationAction end");
                    return true;
                }
                c.a.p0.m.l.f.d.b(context, new a(this, context, d2, c2));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
