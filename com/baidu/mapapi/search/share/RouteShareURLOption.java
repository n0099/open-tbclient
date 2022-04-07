package com.baidu.mapapi.search.share;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RouteShareURLOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCityCode;
    public PlanNode mFrom;
    public RouteShareMode mMode;
    public int mPn;
    public PlanNode mTo;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class RouteShareMode {
        public static /* synthetic */ Interceptable $ic;
        public static final RouteShareMode BUS_ROUTE_SHARE_MODE;
        public static final RouteShareMode CAR_ROUTE_SHARE_MODE;
        public static final RouteShareMode CYCLE_ROUTE_SHARE_MODE;
        public static final RouteShareMode FOOT_ROUTE_SHARE_MODE;
        public static final /* synthetic */ RouteShareMode[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-78179592, "Lcom/baidu/mapapi/search/share/RouteShareURLOption$RouteShareMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-78179592, "Lcom/baidu/mapapi/search/share/RouteShareURLOption$RouteShareMode;");
                    return;
                }
            }
            CAR_ROUTE_SHARE_MODE = new RouteShareMode("CAR_ROUTE_SHARE_MODE", 0, 0);
            FOOT_ROUTE_SHARE_MODE = new RouteShareMode("FOOT_ROUTE_SHARE_MODE", 1, 1);
            CYCLE_ROUTE_SHARE_MODE = new RouteShareMode("CYCLE_ROUTE_SHARE_MODE", 2, 2);
            RouteShareMode routeShareMode = new RouteShareMode("BUS_ROUTE_SHARE_MODE", 3, 3);
            BUS_ROUTE_SHARE_MODE = routeShareMode;
            b = new RouteShareMode[]{CAR_ROUTE_SHARE_MODE, FOOT_ROUTE_SHARE_MODE, CYCLE_ROUTE_SHARE_MODE, routeShareMode};
        }

        public RouteShareMode(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = -1;
            this.a = i2;
        }

        public static RouteShareMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RouteShareMode) Enum.valueOf(RouteShareMode.class, str) : (RouteShareMode) invokeL.objValue;
        }

        public static RouteShareMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RouteShareMode[]) b.clone() : (RouteShareMode[]) invokeV.objValue;
        }

        public int getRouteShareMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    public RouteShareURLOption() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrom = null;
        this.mTo = null;
        this.mPn = 0;
        this.mCityCode = -1;
    }

    public RouteShareURLOption cityCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.mCityCode = i;
            return this;
        }
        return (RouteShareURLOption) invokeI.objValue;
    }

    public RouteShareURLOption from(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, planNode)) == null) {
            this.mFrom = planNode;
            return this;
        }
        return (RouteShareURLOption) invokeL.objValue;
    }

    public RouteShareMode getmMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMode : (RouteShareMode) invokeV.objValue;
    }

    public RouteShareURLOption pn(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.mPn = i;
            return this;
        }
        return (RouteShareURLOption) invokeI.objValue;
    }

    public RouteShareURLOption routMode(RouteShareMode routeShareMode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, routeShareMode)) == null) {
            this.mMode = routeShareMode;
            return this;
        }
        return (RouteShareURLOption) invokeL.objValue;
    }

    public RouteShareURLOption to(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, planNode)) == null) {
            this.mTo = planNode;
            return this;
        }
        return (RouteShareURLOption) invokeL.objValue;
    }
}
