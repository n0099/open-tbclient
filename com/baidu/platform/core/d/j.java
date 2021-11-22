package com.baidu.platform.core.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.SearchType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j extends com.baidu.platform.base.a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public OnGetRoutePlanResultListener f42918b;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42918b = null;
    }

    @Override // com.baidu.platform.core.d.e
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f42875a.lock();
            this.f42918b = null;
            this.f42875a.unlock();
        }
    }

    @Override // com.baidu.platform.core.d.e
    public void a(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onGetRoutePlanResultListener) == null) {
            this.f42875a.lock();
            this.f42918b = onGetRoutePlanResultListener;
            this.f42875a.unlock();
        }
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(BikingRoutePlanOption bikingRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bikingRoutePlanOption)) == null) {
            a aVar = new a();
            aVar.a(SearchType.l);
            return a(new b(bikingRoutePlanOption), this.f42918b, aVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(DrivingRoutePlanOption drivingRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drivingRoutePlanOption)) == null) {
            c cVar = new c();
            cVar.a(SearchType.k);
            return a(new d(drivingRoutePlanOption), this.f42918b, cVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(IndoorRoutePlanOption indoorRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, indoorRoutePlanOption)) == null) {
            f fVar = new f();
            fVar.a(SearchType.n);
            return a(new g(indoorRoutePlanOption), this.f42918b, fVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, massTransitRoutePlanOption)) == null) {
            h hVar = new h();
            hVar.a(SearchType.f42874i);
            return a(new i(massTransitRoutePlanOption), this.f42918b, hVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(TransitRoutePlanOption transitRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, transitRoutePlanOption)) == null) {
            m mVar = new m();
            mVar.a(SearchType.j);
            return a(new n(transitRoutePlanOption), this.f42918b, mVar);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(WalkingRoutePlanOption walkingRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, walkingRoutePlanOption)) == null) {
            o oVar = new o();
            oVar.a(SearchType.m);
            return a(new p(walkingRoutePlanOption), this.f42918b, oVar);
        }
        return invokeL.booleanValue;
    }
}
