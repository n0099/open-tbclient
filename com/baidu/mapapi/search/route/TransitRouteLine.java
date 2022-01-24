package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public final class TransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<TransitRouteLine> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TaxiInfo f35663b;

    /* loaded from: classes10.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<TransitStep> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public VehicleInfo f35664d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f35665e;

        /* renamed from: f  reason: collision with root package name */
        public RouteNode f35666f;

        /* renamed from: g  reason: collision with root package name */
        public TransitRouteStepType f35667g;

        /* renamed from: h  reason: collision with root package name */
        public String f35668h;

        /* renamed from: i  reason: collision with root package name */
        public String f35669i;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes10.dex */
        public static final class TransitRouteStepType {
            public static final /* synthetic */ TransitRouteStepType[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final TransitRouteStepType BUSLINE;
            public static final TransitRouteStepType SUBWAY;
            public static final TransitRouteStepType WAKLING;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-769319318, "Lcom/baidu/mapapi/search/route/TransitRouteLine$TransitStep$TransitRouteStepType;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-769319318, "Lcom/baidu/mapapi/search/route/TransitRouteLine$TransitStep$TransitRouteStepType;");
                        return;
                    }
                }
                BUSLINE = new TransitRouteStepType("BUSLINE", 0);
                SUBWAY = new TransitRouteStepType("SUBWAY", 1);
                TransitRouteStepType transitRouteStepType = new TransitRouteStepType("WAKLING", 2);
                WAKLING = transitRouteStepType;
                $VALUES = new TransitRouteStepType[]{BUSLINE, SUBWAY, transitRouteStepType};
            }

            public TransitRouteStepType(String str, int i2) {
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

            public static TransitRouteStepType valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TransitRouteStepType) Enum.valueOf(TransitRouteStepType.class, str) : (TransitRouteStepType) invokeL.objValue;
            }

            public static TransitRouteStepType[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TransitRouteStepType[]) $VALUES.clone() : (TransitRouteStepType[]) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1786043884, "Lcom/baidu/mapapi/search/route/TransitRouteLine$TransitStep;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1786043884, "Lcom/baidu/mapapi/search/route/TransitRouteLine$TransitStep;");
                    return;
                }
            }
            CREATOR = new p();
        }

        public TransitStep() {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitStep(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f35664d = (VehicleInfo) parcel.readParcelable(VehicleInfo.class.getClassLoader());
            this.f35665e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f35666f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            int readInt = parcel.readInt();
            this.f35667g = readInt == -1 ? null : TransitRouteStepType.values()[readInt];
            this.f35668h = parcel.readString();
            this.f35669i = parcel.readString();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public RouteNode getEntrance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35665e : (RouteNode) invokeV.objValue;
        }

        public RouteNode getExit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35666f : (RouteNode) invokeV.objValue;
        }

        public String getInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35668h : (String) invokeV.objValue;
        }

        public TransitRouteStepType getStepType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35667g : (TransitRouteStepType) invokeV.objValue;
        }

        public VehicleInfo getVehicleInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35664d : (VehicleInfo) invokeV.objValue;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.mWayPoints == null) {
                    this.mWayPoints = CoordUtil.decodeLocationList(this.f35669i);
                }
                return this.mWayPoints;
            }
            return (List) invokeV.objValue;
        }

        public void setEntrace(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, routeNode) == null) {
                this.f35665e = routeNode;
            }
        }

        public void setExit(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, routeNode) == null) {
                this.f35666f = routeNode;
            }
        }

        public void setInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.f35668h = str;
            }
        }

        public void setPathString(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.f35669i = str;
            }
        }

        public void setStepType(TransitRouteStepType transitRouteStepType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, transitRouteStepType) == null) {
                this.f35667g = transitRouteStepType;
            }
        }

        public void setVehicleInfo(VehicleInfo vehicleInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, vehicleInfo) == null) {
                this.f35664d = vehicleInfo;
            }
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeParcelable(this.f35664d, 1);
                parcel.writeParcelable(this.f35665e, 1);
                parcel.writeParcelable(this.f35666f, 1);
                TransitRouteStepType transitRouteStepType = this.f35667g;
                parcel.writeInt(transitRouteStepType == null ? -1 : transitRouteStepType.ordinal());
                parcel.writeString(this.f35668h);
                parcel.writeString(this.f35669i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-923412217, "Lcom/baidu/mapapi/search/route/TransitRouteLine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-923412217, "Lcom/baidu/mapapi/search/route/TransitRouteLine;");
                return;
            }
        }
        CREATOR = new o();
    }

    public TransitRouteLine() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransitRouteLine(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35663b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public TaxiInfo getTaxitInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35663b : (TaxiInfo) invokeV.objValue;
    }

    public void setTaxitInfo(TaxiInfo taxiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taxiInfo) == null) {
            this.f35663b = taxiInfo;
        }
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            super.setType(RouteLine.TYPE.TRANSITSTEP);
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f35663b, 1);
        }
    }
}
