package com.baidu.mapapi.search.route;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.BMapManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RoutePlanSearch extends com.baidu.mapapi.search.core.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.d.e f39814a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39815b;

    public RoutePlanSearch() {
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
        this.f39815b = false;
        this.f39814a = new com.baidu.platform.core.d.j();
    }

    public static RoutePlanSearch newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            BMapManager.init();
            return new RoutePlanSearch();
        }
        return (RoutePlanSearch) invokeV.objValue;
    }

    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        InterceptResult invokeL;
        PlanNode planNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bikingRoutePlanOption)) == null) {
            if (this.f39814a != null) {
                if (bikingRoutePlanOption == null || bikingRoutePlanOption.mTo == null || (planNode = bikingRoutePlanOption.mFrom) == null) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
                }
                if (planNode.getLocation() == null && (bikingRoutePlanOption.mFrom.getName() == null || bikingRoutePlanOption.mFrom.getName() == "")) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option , origin is illegal");
                }
                if (bikingRoutePlanOption.mTo.getLocation() == null && (bikingRoutePlanOption.mTo.getName() == null || bikingRoutePlanOption.mTo.getName() == "")) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option , destination is illegal");
                }
                return this.f39814a.a(bikingRoutePlanOption);
            }
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f39815b) {
            return;
        }
        this.f39815b = true;
        this.f39814a.a();
        BMapManager.destroy();
    }

    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drivingRoutePlanOption)) == null) {
            com.baidu.platform.core.d.e eVar = this.f39814a;
            if (eVar != null) {
                if (drivingRoutePlanOption == null || drivingRoutePlanOption.mTo == null || drivingRoutePlanOption.mFrom == null) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
                }
                return eVar.a(drivingRoutePlanOption);
            }
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        InterceptResult invokeL;
        PlanNode planNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, massTransitRoutePlanOption)) == null) {
            if (this.f39814a != null) {
                if (massTransitRoutePlanOption == null || massTransitRoutePlanOption.mTo == null || (planNode = massTransitRoutePlanOption.mFrom) == null) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination can not be null");
                }
                if (planNode.getLocation() == null && (massTransitRoutePlanOption.mFrom.getName() == null || massTransitRoutePlanOption.mFrom.getCity() == null)) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option,origin is illegal");
                }
                if (massTransitRoutePlanOption.mTo.getLocation() == null && (massTransitRoutePlanOption.mTo.getName() == null || massTransitRoutePlanOption.mTo.getCity() == null)) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option,destination is illegal");
                }
                return this.f39814a.a(massTransitRoutePlanOption);
            }
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onGetRoutePlanResultListener) == null) {
            com.baidu.platform.core.d.e eVar = this.f39814a;
            if (eVar == null) {
                throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
            }
            if (onGetRoutePlanResultListener == null) {
                throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
            }
            eVar.a(onGetRoutePlanResultListener);
        }
    }

    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, transitRoutePlanOption)) == null) {
            com.baidu.platform.core.d.e eVar = this.f39814a;
            if (eVar != null) {
                if (transitRoutePlanOption == null || transitRoutePlanOption.mCityName == null || transitRoutePlanOption.mTo == null || transitRoutePlanOption.mFrom == null) {
                    throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination or city can not be null");
                }
                return eVar.a(transitRoutePlanOption);
            }
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, indoorRoutePlanOption)) == null) {
            com.baidu.platform.core.d.e eVar = this.f39814a;
            if (eVar != null) {
                if (indoorRoutePlanOption == null || indoorRoutePlanOption.mTo == null || indoorRoutePlanOption.mFrom == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
                }
                return eVar.a(indoorRoutePlanOption);
            }
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }

    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, walkingRoutePlanOption)) == null) {
            com.baidu.platform.core.d.e eVar = this.f39814a;
            if (eVar != null) {
                if (walkingRoutePlanOption == null || walkingRoutePlanOption.mTo == null || walkingRoutePlanOption.mFrom == null) {
                    throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
                }
                return eVar.a(walkingRoutePlanOption);
            }
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        return invokeL.booleanValue;
    }
}
