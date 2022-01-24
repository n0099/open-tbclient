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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class DrivingRouteLine extends RouteLine<DrivingStep> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<DrivingRouteLine> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35608b;

    /* renamed from: c  reason: collision with root package name */
    public List<RouteNode> f35609c;

    /* renamed from: d  reason: collision with root package name */
    public int f35610d;

    /* renamed from: e  reason: collision with root package name */
    public int f35611e;

    /* loaded from: classes10.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<DrivingStep> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public List<LatLng> f35612d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f35613e;

        /* renamed from: f  reason: collision with root package name */
        public int f35614f;

        /* renamed from: g  reason: collision with root package name */
        public RouteNode f35615g;

        /* renamed from: h  reason: collision with root package name */
        public RouteNode f35616h;

        /* renamed from: i  reason: collision with root package name */
        public String f35617i;

        /* renamed from: j  reason: collision with root package name */
        public String f35618j;
        public String k;
        public String l;
        public int m;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1497548652, "Lcom/baidu/mapapi/search/route/DrivingRouteLine$DrivingStep;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1497548652, "Lcom/baidu/mapapi/search/route/DrivingRouteLine$DrivingStep;");
                    return;
                }
            }
            CREATOR = new e();
        }

        public DrivingStep() {
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
        public DrivingStep(Parcel parcel) {
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
            this.f35614f = parcel.readInt();
            this.f35615g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f35616h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f35617i = parcel.readString();
            this.f35618j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
            this.m = parcel.readInt();
            this.f35612d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f35613e = parcel.createIntArray();
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

        public int getDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35614f : invokeV.intValue;
        }

        public RouteNode getEntrance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35615g : (RouteNode) invokeV.objValue;
        }

        public String getEntranceInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35618j : (String) invokeV.objValue;
        }

        public RouteNode getExit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35616h : (RouteNode) invokeV.objValue;
        }

        public String getExitInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (String) invokeV.objValue;
        }

        public String getInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (String) invokeV.objValue;
        }

        public int getNumTurns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : invokeV.intValue;
        }

        public int[] getTrafficList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35613e : (int[]) invokeV.objValue;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.mWayPoints == null) {
                    this.mWayPoints = CoordUtil.decodeLocationList(this.f35617i);
                }
                return this.f35612d;
            }
            return (List) invokeV.objValue;
        }

        public void setDirection(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.f35614f = i2;
            }
        }

        public void setEntrance(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, routeNode) == null) {
                this.f35615g = routeNode;
            }
        }

        public void setEntranceInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.f35618j = str;
            }
        }

        public void setExit(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, routeNode) == null) {
                this.f35616h = routeNode;
            }
        }

        public void setExitInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.k = str;
            }
        }

        public void setInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.l = str;
            }
        }

        public void setNumTurns(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
                this.m = i2;
            }
        }

        public void setPathList(List<LatLng> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
                this.f35612d = list;
            }
        }

        public void setPathString(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                this.f35617i = str;
            }
        }

        public void setTrafficList(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, iArr) == null) {
                this.f35613e = iArr;
            }
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048596, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f35614f);
                parcel.writeParcelable(this.f35615g, 1);
                parcel.writeParcelable(this.f35616h, 1);
                parcel.writeString(this.f35617i);
                parcel.writeString(this.f35618j);
                parcel.writeString(this.k);
                parcel.writeString(this.l);
                parcel.writeInt(this.m);
                parcel.writeTypedList(this.f35612d);
                parcel.writeIntArray(this.f35613e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-505512453, "Lcom/baidu/mapapi/search/route/DrivingRouteLine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-505512453, "Lcom/baidu/mapapi/search/route/DrivingRouteLine;");
                return;
            }
        }
        CREATOR = new d();
    }

    public DrivingRouteLine() {
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
    public DrivingRouteLine(Parcel parcel) {
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
        this.f35608b = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.f35609c = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.f35610d = parcel.readInt();
        this.f35611e = parcel.readInt();
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

    public int getCongestionDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35610d : invokeV.intValue;
    }

    public int getLightNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35611e : invokeV.intValue;
    }

    public List<RouteNode> getWayPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35609c : (List) invokeV.objValue;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35608b : invokeV.booleanValue;
    }

    public void setCongestionDistance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f35610d = i2;
        }
    }

    public void setLightNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f35611e = i2;
        }
    }

    public void setSupportTraffic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f35608b = z;
        }
    }

    public void setWayPoints(List<RouteNode> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f35609c = list;
        }
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
            super.setType(RouteLine.TYPE.DRIVESTEP);
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f35608b ? (byte) 1 : (byte) 0);
            parcel.writeList(this.f35609c);
            parcel.writeInt(this.f35610d);
            parcel.writeInt(this.f35611e);
        }
    }
}
