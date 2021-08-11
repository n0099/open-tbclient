package c.a.n0.j.k.e;

import android.content.Context;
import c.a.n0.a.c1.d.d;
import c.a.n0.a.k;
import c.a.n0.j.k.f.d;
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
/* loaded from: classes3.dex */
public class e extends c.a.n0.j.k.a<c.a.n0.a.h1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f11434a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.n.c f11435b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.b f11436c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f11437d;

        public a(e eVar, Context context, c.a.n0.j.n.c cVar, c.a.n0.j.b bVar) {
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
            this.f11437d = eVar;
            this.f11434a = context;
            this.f11435b = cVar;
            this.f11436c = bVar;
        }

        @Override // c.a.n0.j.k.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.e0.d.l("map", "location permission fail");
            }
        }

        @Override // c.a.n0.j.k.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.n0.a.e0.d.l("map", "location permission success");
                this.f11437d.e(this.f11434a, this.f11435b, this.f11436c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.n.c f11438a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.b f11439b;

        public b(e eVar, c.a.n0.j.n.c cVar, c.a.n0.j.b bVar) {
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
            this.f11438a = cVar;
            this.f11439b = bVar;
        }

        @Override // c.a.n0.a.c1.d.d.a
        public void a(c.a.n0.a.c2.f.k0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                c.a.n0.a.e0.d.g("map", "get location " + bVar.a().toString());
                BaiduMap map = this.f11438a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f4677c, bVar.f4676b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f4679e).latitude(bVar.f4677c).longitude(bVar.f4676b).build());
                this.f11439b.q(true);
            }
        }

        @Override // c.a.n0.a.c1.d.d.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.n0.a.e0.d.g("map", "get location error " + i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1805265296, "Lc/a/n0/j/k/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1805265296, "Lc/a/n0/j/k/e/e;");
                return;
            }
        }
        boolean z = k.f6803a;
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

    @Override // c.a.n0.j.k.a
    public boolean b(Context context, c.a.n0.a.h1.c.c cVar, c.a.n0.a.h1.b bVar, c.a.n0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? g(context, cVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void e(Context context, c.a.n0.j.n.c cVar, c.a.n0.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar) == null) {
            c.a.n0.a.c1.a.E().b("gcj02", true, false, new b(this, cVar, bVar));
        }
    }

    public final boolean g(Context context, c.a.n0.a.h1.c.c cVar, c.a.n0.a.h1.b bVar, c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar, bVar, eVar)) == null) {
            c.a.n0.a.e0.d.g("map", "MoveToLocationAction start");
            c.a.n0.a.p.e.d B = c.a.n0.a.g1.f.V().B(cVar.f4384g);
            if (!(B instanceof c.a.n0.a.p.e.b)) {
                c.a.n0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            c.a.n0.j.b c2 = c.a.n0.j.c.b().c((c.a.n0.a.p.e.b) B);
            c.a.n0.j.n.c d2 = c2.d(cVar.f4383f);
            if (d2 == null) {
                c.a.n0.a.e0.d.b("map", "can not find map by id " + cVar.f4383f);
                return false;
            } else if (!d2.k) {
                c.a.n0.a.e0.d.l("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e2 = c2.e();
                if (e2 != null && c2.h()) {
                    d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                    d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d2.l.getMap().setMyLocationEnabled(true);
                    d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                    c.a.n0.a.e0.d.g("map", "MoveToLocationAction end");
                    return true;
                }
                c.a.n0.j.k.f.d.b(context, new a(this, context, d2, c2));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
