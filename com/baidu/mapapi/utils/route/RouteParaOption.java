package com.baidu.mapapi.utils.route;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RouteParaOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7548a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7549b;

    /* renamed from: c  reason: collision with root package name */
    public String f7550c;

    /* renamed from: d  reason: collision with root package name */
    public String f7551d;

    /* renamed from: e  reason: collision with root package name */
    public String f7552e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7553f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class EBusStrategyType {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ EBusStrategyType[] f7554a;
        public static final EBusStrategyType bus_no_subway;
        public static final EBusStrategyType bus_recommend_way;
        public static final EBusStrategyType bus_time_first;
        public static final EBusStrategyType bus_transfer_little;
        public static final EBusStrategyType bus_walk_little;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(203641350, "Lcom/baidu/mapapi/utils/route/RouteParaOption$EBusStrategyType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(203641350, "Lcom/baidu/mapapi/utils/route/RouteParaOption$EBusStrategyType;");
                    return;
                }
            }
            bus_time_first = new EBusStrategyType("bus_time_first", 0);
            bus_transfer_little = new EBusStrategyType("bus_transfer_little", 1);
            bus_walk_little = new EBusStrategyType("bus_walk_little", 2);
            bus_no_subway = new EBusStrategyType("bus_no_subway", 3);
            EBusStrategyType eBusStrategyType = new EBusStrategyType("bus_recommend_way", 4);
            bus_recommend_way = eBusStrategyType;
            f7554a = new EBusStrategyType[]{bus_time_first, bus_transfer_little, bus_walk_little, bus_no_subway, eBusStrategyType};
        }

        public EBusStrategyType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EBusStrategyType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EBusStrategyType) Enum.valueOf(EBusStrategyType.class, str) : (EBusStrategyType) invokeL.objValue;
        }

        public static EBusStrategyType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EBusStrategyType[]) f7554a.clone() : (EBusStrategyType[]) invokeV.objValue;
        }
    }

    public RouteParaOption() {
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
        this.f7553f = EBusStrategyType.bus_recommend_way;
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eBusStrategyType)) == null) {
            this.f7553f = eBusStrategyType;
            return this;
        }
        return (RouteParaOption) invokeL.objValue;
    }

    public RouteParaOption cityName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f7552e = str;
            return this;
        }
        return (RouteParaOption) invokeL.objValue;
    }

    public RouteParaOption endName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f7551d = str;
            return this;
        }
        return (RouteParaOption) invokeL.objValue;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, latLng)) == null) {
            this.f7549b = latLng;
            return this;
        }
        return (RouteParaOption) invokeL.objValue;
    }

    public EBusStrategyType getBusStrategyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7553f : (EBusStrategyType) invokeV.objValue;
    }

    public String getCityName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7552e : (String) invokeV.objValue;
    }

    public String getEndName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f7551d : (String) invokeV.objValue;
    }

    public LatLng getEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f7549b : (LatLng) invokeV.objValue;
    }

    public String getStartName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f7550c : (String) invokeV.objValue;
    }

    public LatLng getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f7548a : (LatLng) invokeV.objValue;
    }

    public RouteParaOption startName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f7550c = str;
            return this;
        }
        return (RouteParaOption) invokeL.objValue;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, latLng)) == null) {
            this.f7548a = latLng;
            return this;
        }
        return (RouteParaOption) invokeL.objValue;
    }
}
