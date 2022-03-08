package com.baidu.mapapi.search.route;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class DrivingRoutePlanOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCityName;
    public PlanNode mFrom;
    public DrivingPolicy mPolicy;
    public PlanNode mTo;
    public List<PlanNode> mWayPoints;
    public DrivingTrafficPolicy mtrafficPolicy;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class DrivingPolicy {
        public static /* synthetic */ Interceptable $ic;
        public static final DrivingPolicy ECAR_AVOID_JAM;
        public static final DrivingPolicy ECAR_DIS_FIRST;
        public static final DrivingPolicy ECAR_FEE_FIRST;
        public static final DrivingPolicy ECAR_TIME_FIRST;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ DrivingPolicy[] f34228b;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-170962628, "Lcom/baidu/mapapi/search/route/DrivingRoutePlanOption$DrivingPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-170962628, "Lcom/baidu/mapapi/search/route/DrivingRoutePlanOption$DrivingPolicy;");
                    return;
                }
            }
            ECAR_AVOID_JAM = new DrivingPolicy("ECAR_AVOID_JAM", 0, 3);
            ECAR_TIME_FIRST = new DrivingPolicy("ECAR_TIME_FIRST", 1, 0);
            ECAR_DIS_FIRST = new DrivingPolicy("ECAR_DIS_FIRST", 2, 1);
            DrivingPolicy drivingPolicy = new DrivingPolicy("ECAR_FEE_FIRST", 3, 2);
            ECAR_FEE_FIRST = drivingPolicy;
            f34228b = new DrivingPolicy[]{ECAR_AVOID_JAM, ECAR_TIME_FIRST, ECAR_DIS_FIRST, drivingPolicy};
        }

        public DrivingPolicy(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i3;
        }

        public static DrivingPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DrivingPolicy) Enum.valueOf(DrivingPolicy.class, str) : (DrivingPolicy) invokeL.objValue;
        }

        public static DrivingPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DrivingPolicy[]) f34228b.clone() : (DrivingPolicy[]) invokeV.objValue;
        }

        public int getInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class DrivingTrafficPolicy {
        public static /* synthetic */ Interceptable $ic;
        public static final DrivingTrafficPolicy ROUTE_PATH;
        public static final DrivingTrafficPolicy ROUTE_PATH_AND_TRAFFIC;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ DrivingTrafficPolicy[] f34229b;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1438770887, "Lcom/baidu/mapapi/search/route/DrivingRoutePlanOption$DrivingTrafficPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1438770887, "Lcom/baidu/mapapi/search/route/DrivingRoutePlanOption$DrivingTrafficPolicy;");
                    return;
                }
            }
            ROUTE_PATH = new DrivingTrafficPolicy("ROUTE_PATH", 0, 0);
            DrivingTrafficPolicy drivingTrafficPolicy = new DrivingTrafficPolicy("ROUTE_PATH_AND_TRAFFIC", 1, 1);
            ROUTE_PATH_AND_TRAFFIC = drivingTrafficPolicy;
            f34229b = new DrivingTrafficPolicy[]{ROUTE_PATH, drivingTrafficPolicy};
        }

        public DrivingTrafficPolicy(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i3;
        }

        public static DrivingTrafficPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DrivingTrafficPolicy) Enum.valueOf(DrivingTrafficPolicy.class, str) : (DrivingTrafficPolicy) invokeL.objValue;
        }

        public static DrivingTrafficPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DrivingTrafficPolicy[]) f34229b.clone() : (DrivingTrafficPolicy[]) invokeV.objValue;
        }

        public int getInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    public DrivingRoutePlanOption() {
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
        this.mFrom = null;
        this.mTo = null;
        this.mPolicy = DrivingPolicy.ECAR_TIME_FIRST;
        this.mWayPoints = null;
        this.mtrafficPolicy = DrivingTrafficPolicy.ROUTE_PATH;
    }

    public DrivingRoutePlanOption currentCity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mCityName = str;
            return this;
        }
        return (DrivingRoutePlanOption) invokeL.objValue;
    }

    public DrivingRoutePlanOption from(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, planNode)) == null) {
            this.mFrom = planNode;
            return this;
        }
        return (DrivingRoutePlanOption) invokeL.objValue;
    }

    public DrivingRoutePlanOption passBy(List<PlanNode> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            this.mWayPoints = list;
            return this;
        }
        return (DrivingRoutePlanOption) invokeL.objValue;
    }

    public DrivingRoutePlanOption policy(DrivingPolicy drivingPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drivingPolicy)) == null) {
            this.mPolicy = drivingPolicy;
            return this;
        }
        return (DrivingRoutePlanOption) invokeL.objValue;
    }

    public DrivingRoutePlanOption to(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, planNode)) == null) {
            this.mTo = planNode;
            return this;
        }
        return (DrivingRoutePlanOption) invokeL.objValue;
    }

    public DrivingRoutePlanOption trafficPolicy(DrivingTrafficPolicy drivingTrafficPolicy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, drivingTrafficPolicy)) == null) {
            this.mtrafficPolicy = drivingTrafficPolicy;
            return this;
        }
        return (DrivingRoutePlanOption) invokeL.objValue;
    }
}
