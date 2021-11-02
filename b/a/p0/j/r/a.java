package b.a.p0.j.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f10995b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RoutePlanSearch f10996a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f10995b == null) {
                synchronized (a.class) {
                    if (f10995b == null) {
                        f10995b = new a();
                    }
                }
            }
            return f10995b;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        RoutePlanSearch routePlanSearch;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (routePlanSearch = this.f10996a) == null) {
            return;
        }
        routePlanSearch.destroy();
    }

    public void c(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng, latLng2, onGetRoutePlanResultListener) == null) || latLng == null || latLng2 == null || onGetRoutePlanResultListener == null) {
            return;
        }
        RoutePlanSearch newInstance = RoutePlanSearch.newInstance();
        this.f10996a = newInstance;
        newInstance.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
        PlanNode withLocation = PlanNode.withLocation(latLng);
        this.f10996a.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
    }
}
