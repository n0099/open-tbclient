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
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class MassTransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MassTransitRouteLine> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public double c;
    public List<PriceInfo> d;
    public List<List<TransitStep>> e;

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<TransitStep> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public List<TrafficCondition> d;
        public LatLng e;
        public LatLng f;
        public TrainInfo g;
        public PlaneInfo h;
        public CoachInfo i;
        public BusInfo j;
        public StepVehicleInfoType k;
        public String l;
        public String m;

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes2.dex */
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
            public int a;

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

            public StepVehicleInfoType(String str, int i, int i2) {
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
                this.a = 0;
                this.a = i2;
            }

            public static StepVehicleInfoType valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (StepVehicleInfoType) Enum.valueOf(StepVehicleInfoType.class, str);
                }
                return (StepVehicleInfoType) invokeL.objValue;
            }

            public static StepVehicleInfoType[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (StepVehicleInfoType[]) $VALUES.clone();
                }
                return (StepVehicleInfoType[]) invokeV.objValue;
            }

            public int getInt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.a;
                }
                return invokeV.intValue;
            }
        }

        /* loaded from: classes2.dex */
        public static class TrafficCondition implements Parcelable {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<TrafficCondition> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public int b;

            @Override // android.os.Parcelable
            public int describeContents() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public int getTrafficGeoCnt() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.b;
                }
                return invokeV.intValue;
            }

            public int getTrafficStatus() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.a;
                }
                return invokeV.intValue;
            }

            public TrafficCondition(Parcel parcel) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcel};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
                this.a = parcel.readInt();
                this.b = parcel.readInt();
            }

            public void setTrafficGeoCnt(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                    this.b = i;
                }
            }

            public void setTrafficStatus(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                    this.a = i;
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i) == null) {
                    parcel.writeInt(this.a);
                    parcel.writeInt(this.b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public BusInfo getBusInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.j;
            }
            return (BusInfo) invokeV.objValue;
        }

        public CoachInfo getCoachInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.i;
            }
            return (CoachInfo) invokeV.objValue;
        }

        public LatLng getEndLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.f;
            }
            return (LatLng) invokeV.objValue;
        }

        public String getInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.l;
            }
            return (String) invokeV.objValue;
        }

        public PlaneInfo getPlaneInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.h;
            }
            return (PlaneInfo) invokeV.objValue;
        }

        public LatLng getStartLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.e;
            }
            return (LatLng) invokeV.objValue;
        }

        public List<TrafficCondition> getTrafficConditions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.d;
            }
            return (List) invokeV.objValue;
        }

        public TrainInfo getTrainInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.g;
            }
            return (TrainInfo) invokeV.objValue;
        }

        public StepVehicleInfoType getVehileType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.k;
            }
            return (StepVehicleInfoType) invokeV.objValue;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitStep(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.d = parcel.createTypedArrayList(TrafficCondition.CREATOR);
            this.e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.g = (TrainInfo) parcel.readParcelable(TrainInfo.class.getClassLoader());
            this.h = (PlaneInfo) parcel.readParcelable(PlaneInfo.class.getClassLoader());
            this.i = (CoachInfo) parcel.readParcelable(CoachInfo.class.getClassLoader());
            this.j = (BusInfo) parcel.readParcelable(BusInfo.class.getClassLoader());
            switch (parcel.readInt()) {
                case 1:
                    this.k = StepVehicleInfoType.ESTEP_TRAIN;
                    break;
                case 2:
                    this.k = StepVehicleInfoType.ESTEP_PLANE;
                    break;
                case 3:
                    this.k = StepVehicleInfoType.ESTEP_BUS;
                    break;
                case 4:
                    this.k = StepVehicleInfoType.ESTEP_DRIVING;
                    break;
                case 5:
                    this.k = StepVehicleInfoType.ESTEP_WALK;
                    break;
                case 6:
                    this.k = StepVehicleInfoType.ESTEP_COACH;
                    break;
            }
            this.l = parcel.readString();
            this.m = parcel.readString();
        }

        private List<LatLng> a(String str) {
            InterceptResult invokeL;
            String[] split;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
                ArrayList arrayList = new ArrayList();
                String[] split2 = str.split(ParamableElem.DIVIDE_PARAM);
                if (split2 != null) {
                    for (int i = 0; i < split2.length; i++) {
                        if (split2[i] != null && split2[i] != "" && (split = split2[i].split(",")) != null && split[1] != "" && split[0] != "") {
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

        public void setBusInfo(BusInfo busInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, busInfo) == null) {
                this.j = busInfo;
            }
        }

        public void setCoachInfo(CoachInfo coachInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, coachInfo) == null) {
                this.i = coachInfo;
            }
        }

        public void setEndLocation(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, latLng) == null) {
                this.f = latLng;
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
                this.h = planeInfo;
            }
        }

        public void setStartLocation(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, latLng) == null) {
                this.e = latLng;
            }
        }

        public void setTrafficConditions(List<TrafficCondition> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
                this.d = list;
            }
        }

        public void setTrainInfo(TrainInfo trainInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, trainInfo) == null) {
                this.g = trainInfo;
            }
        }

        public void setVehileType(StepVehicleInfoType stepVehicleInfoType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, stepVehicleInfoType) == null) {
                this.k = stepVehicleInfoType;
            }
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048597, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeTypedList(this.d);
                parcel.writeParcelable(this.e, i);
                parcel.writeParcelable(this.f, i);
                parcel.writeParcelable(this.g, i);
                parcel.writeParcelable(this.h, i);
                parcel.writeParcelable(this.i, i);
                parcel.writeParcelable(this.j, i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = null;
    }

    public String getArriveTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public List<List<TransitStep>> getNewSteps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public double getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return invokeV.doubleValue;
    }

    public List<PriceInfo> getPriceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = null;
        int readInt = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.createTypedArrayList(PriceInfo.CREATOR);
        if (readInt > 0) {
            this.e = new ArrayList();
            for (int i3 = 0; i3 < readInt; i3++) {
                this.e.add(parcel.createTypedArrayList(TransitStep.CREATOR));
            }
        }
    }

    public void setArriveTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.b = str;
        }
    }

    public void setNewSteps(List<List<TransitStep>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.e = list;
        }
    }

    public void setPrice(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d)}) == null) {
            this.c = d;
        }
    }

    public void setPriceInfo(List<PriceInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.d = list;
        }
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            List<List<TransitStep>> list = this.e;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            parcel.writeInt(size);
            parcel.writeString(this.b);
            parcel.writeDouble(this.c);
            parcel.writeTypedList(this.d);
            for (List<TransitStep> list2 : this.e) {
                parcel.writeTypedList(list2);
            }
        }
    }
}
