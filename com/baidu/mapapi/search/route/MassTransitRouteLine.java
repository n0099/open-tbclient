package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class MassTransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MassTransitRouteLine> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f41668b;

    /* renamed from: c  reason: collision with root package name */
    public double f41669c;

    /* renamed from: d  reason: collision with root package name */
    public List<PriceInfo> f41670d;

    /* renamed from: e  reason: collision with root package name */
    public List<List<TransitStep>> f41671e;

    /* loaded from: classes5.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<TransitStep> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public List<TrafficCondition> f41672d;

        /* renamed from: e  reason: collision with root package name */
        public LatLng f41673e;

        /* renamed from: f  reason: collision with root package name */
        public LatLng f41674f;

        /* renamed from: g  reason: collision with root package name */
        public TrainInfo f41675g;

        /* renamed from: h  reason: collision with root package name */
        public PlaneInfo f41676h;

        /* renamed from: i  reason: collision with root package name */
        public CoachInfo f41677i;

        /* renamed from: j  reason: collision with root package name */
        public BusInfo f41678j;
        public StepVehicleInfoType k;
        public String l;
        public String m;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes5.dex */
        public static final class StepVehicleInfoType {
            public static final /* synthetic */ StepVehicleInfoType[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final StepVehicleInfoType ESTEP_BUS;
            public static final StepVehicleInfoType ESTEP_COACH;
            public static final StepVehicleInfoType ESTEP_DRIVING;
            public static final StepVehicleInfoType ESTEP_PLANE;
            public static final StepVehicleInfoType ESTEP_TRAIN;
            public static final StepVehicleInfoType ESTEP_WALK;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f41679a;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1265442612, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine$TransitStep$StepVehicleInfoType;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1265442612, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine$TransitStep$StepVehicleInfoType;");
                        return;
                    }
                }
                ESTEP_TRAIN = new StepVehicleInfoType("ESTEP_TRAIN", 0, 1);
                ESTEP_PLANE = new StepVehicleInfoType("ESTEP_PLANE", 1, 2);
                ESTEP_BUS = new StepVehicleInfoType("ESTEP_BUS", 2, 3);
                ESTEP_DRIVING = new StepVehicleInfoType("ESTEP_DRIVING", 3, 4);
                ESTEP_WALK = new StepVehicleInfoType("ESTEP_WALK", 4, 5);
                StepVehicleInfoType stepVehicleInfoType = new StepVehicleInfoType("ESTEP_COACH", 5, 6);
                ESTEP_COACH = stepVehicleInfoType;
                $VALUES = new StepVehicleInfoType[]{ESTEP_TRAIN, ESTEP_PLANE, ESTEP_BUS, ESTEP_DRIVING, ESTEP_WALK, stepVehicleInfoType};
            }

            public StepVehicleInfoType(String str, int i2, int i3) {
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
                this.f41679a = 0;
                this.f41679a = i3;
            }

            public static StepVehicleInfoType valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (StepVehicleInfoType) Enum.valueOf(StepVehicleInfoType.class, str) : (StepVehicleInfoType) invokeL.objValue;
            }

            public static StepVehicleInfoType[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (StepVehicleInfoType[]) $VALUES.clone() : (StepVehicleInfoType[]) invokeV.objValue;
            }

            public int getInt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41679a : invokeV.intValue;
            }
        }

        /* loaded from: classes5.dex */
        public static class TrafficCondition implements Parcelable {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<TrafficCondition> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f41680a;

            /* renamed from: b  reason: collision with root package name */
            public int f41681b;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-245922276, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine$TransitStep$TrafficCondition;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-245922276, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine$TransitStep$TrafficCondition;");
                        return;
                    }
                }
                CREATOR = new k();
            }

            public TrafficCondition() {
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

            public TrafficCondition(Parcel parcel) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcel};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
                this.f41680a = parcel.readInt();
                this.f41681b = parcel.readInt();
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            public int getTrafficGeoCnt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41681b : invokeV.intValue;
            }

            public int getTrafficStatus() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41680a : invokeV.intValue;
            }

            public void setTrafficGeoCnt(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                    this.f41681b = i2;
                }
            }

            public void setTrafficStatus(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f41680a = i2;
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i2) == null) {
                    parcel.writeInt(this.f41680a);
                    parcel.writeInt(this.f41681b);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-384384936, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine$TransitStep;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-384384936, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine$TransitStep;");
                    return;
                }
            }
            CREATOR = new j();
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
            StepVehicleInfoType stepVehicleInfoType;
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
            this.f41672d = parcel.createTypedArrayList(TrafficCondition.CREATOR);
            this.f41673e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f41674f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f41675g = (TrainInfo) parcel.readParcelable(TrainInfo.class.getClassLoader());
            this.f41676h = (PlaneInfo) parcel.readParcelable(PlaneInfo.class.getClassLoader());
            this.f41677i = (CoachInfo) parcel.readParcelable(CoachInfo.class.getClassLoader());
            this.f41678j = (BusInfo) parcel.readParcelable(BusInfo.class.getClassLoader());
            switch (parcel.readInt()) {
                case 1:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_TRAIN;
                    this.k = stepVehicleInfoType;
                    this.l = parcel.readString();
                    this.m = parcel.readString();
                    return;
                case 2:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_PLANE;
                    this.k = stepVehicleInfoType;
                    this.l = parcel.readString();
                    this.m = parcel.readString();
                    return;
                case 3:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_BUS;
                    this.k = stepVehicleInfoType;
                    this.l = parcel.readString();
                    this.m = parcel.readString();
                    return;
                case 4:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_DRIVING;
                    this.k = stepVehicleInfoType;
                    this.l = parcel.readString();
                    this.m = parcel.readString();
                    return;
                case 5:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_WALK;
                    this.k = stepVehicleInfoType;
                    this.l = parcel.readString();
                    this.m = parcel.readString();
                    return;
                case 6:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_COACH;
                    this.k = stepVehicleInfoType;
                    this.l = parcel.readString();
                    this.m = parcel.readString();
                    return;
                default:
                    this.l = parcel.readString();
                    this.m = parcel.readString();
                    return;
            }
        }

        private List<LatLng> a(String str) {
            InterceptResult invokeL;
            String[] split;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
                ArrayList arrayList = new ArrayList();
                String[] split2 = str.split(";");
                if (split2 != null) {
                    for (int i2 = 0; i2 < split2.length; i2++) {
                        if (split2[i2] != null && split2[i2] != "" && (split = split2[i2].split(",")) != null && split[1] != "" && split[0] != "") {
                            LatLng latLng = new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.baiduToGcj(latLng);
                            }
                            arrayList.add(latLng);
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
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

        public BusInfo getBusInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41678j : (BusInfo) invokeV.objValue;
        }

        public CoachInfo getCoachInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41677i : (CoachInfo) invokeV.objValue;
        }

        public LatLng getEndLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41674f : (LatLng) invokeV.objValue;
        }

        public String getInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (String) invokeV.objValue;
        }

        public PlaneInfo getPlaneInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41676h : (PlaneInfo) invokeV.objValue;
        }

        public LatLng getStartLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41673e : (LatLng) invokeV.objValue;
        }

        public List<TrafficCondition> getTrafficConditions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41672d : (List) invokeV.objValue;
        }

        public TrainInfo getTrainInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f41675g : (TrainInfo) invokeV.objValue;
        }

        public StepVehicleInfoType getVehileType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (StepVehicleInfoType) invokeV.objValue;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.mWayPoints == null) {
                    this.mWayPoints = a(this.m);
                }
                return this.mWayPoints;
            }
            return (List) invokeV.objValue;
        }

        public void setBusInfo(BusInfo busInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, busInfo) == null) {
                this.f41678j = busInfo;
            }
        }

        public void setCoachInfo(CoachInfo coachInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, coachInfo) == null) {
                this.f41677i = coachInfo;
            }
        }

        public void setEndLocation(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, latLng) == null) {
                this.f41674f = latLng;
            }
        }

        public void setInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.l = str;
            }
        }

        public void setPathString(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.m = str;
            }
        }

        public void setPlaneInfo(PlaneInfo planeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, planeInfo) == null) {
                this.f41676h = planeInfo;
            }
        }

        public void setStartLocation(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, latLng) == null) {
                this.f41673e = latLng;
            }
        }

        public void setTrafficConditions(List<TrafficCondition> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
                this.f41672d = list;
            }
        }

        public void setTrainInfo(TrainInfo trainInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, trainInfo) == null) {
                this.f41675g = trainInfo;
            }
        }

        public void setVehileType(StepVehicleInfoType stepVehicleInfoType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, stepVehicleInfoType) == null) {
                this.k = stepVehicleInfoType;
            }
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048597, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeTypedList(this.f41672d);
                parcel.writeParcelable(this.f41673e, i2);
                parcel.writeParcelable(this.f41674f, i2);
                parcel.writeParcelable(this.f41675g, i2);
                parcel.writeParcelable(this.f41676h, i2);
                parcel.writeParcelable(this.f41677i, i2);
                parcel.writeParcelable(this.f41678j, i2);
                parcel.writeInt(this.k.getInt());
                parcel.writeString(this.l);
                parcel.writeString(this.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1662583437, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1662583437, "Lcom/baidu/mapapi/search/route/MassTransitRouteLine;");
                return;
            }
        }
        CREATOR = new i();
    }

    public MassTransitRouteLine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41671e = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MassTransitRouteLine(Parcel parcel) {
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
        this.f41671e = null;
        int readInt = parcel.readInt();
        this.f41668b = parcel.readString();
        this.f41669c = parcel.readDouble();
        this.f41670d = parcel.createTypedArrayList(PriceInfo.CREATOR);
        if (readInt > 0) {
            this.f41671e = new ArrayList();
            for (int i4 = 0; i4 < readInt; i4++) {
                this.f41671e.add(parcel.createTypedArrayList(TransitStep.CREATOR));
            }
        }
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

    public String getArriveTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41668b : (String) invokeV.objValue;
    }

    public List<List<TransitStep>> getNewSteps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41671e : (List) invokeV.objValue;
    }

    public double getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41669c : invokeV.doubleValue;
    }

    public List<PriceInfo> getPriceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41670d : (List) invokeV.objValue;
    }

    public void setArriveTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f41668b = str;
        }
    }

    public void setNewSteps(List<List<TransitStep>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f41671e = list;
        }
    }

    public void setPrice(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f41669c = d2;
        }
    }

    public void setPriceInfo(List<PriceInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f41670d = list;
        }
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            List<List<TransitStep>> list = this.f41671e;
            parcel.writeInt(list == null ? 0 : list.size());
            parcel.writeString(this.f41668b);
            parcel.writeDouble(this.f41669c);
            parcel.writeTypedList(this.f41670d);
            for (List<TransitStep> list2 : this.f41671e) {
                parcel.writeTypedList(list2);
            }
        }
    }
}
