package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
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
/* loaded from: classes7.dex */
public class BikingRouteLine extends RouteLine<BikingStep> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<BikingRouteLine> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class BikingStep extends RouteStep implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<BikingStep> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public int f39747d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f39748e;

        /* renamed from: f  reason: collision with root package name */
        public RouteNode f39749f;

        /* renamed from: g  reason: collision with root package name */
        public String f39750g;

        /* renamed from: h  reason: collision with root package name */
        public String f39751h;

        /* renamed from: i  reason: collision with root package name */
        public String f39752i;
        public String j;
        public String k;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-746395550, "Lcom/baidu/mapapi/search/route/BikingRouteLine$BikingStep;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-746395550, "Lcom/baidu/mapapi/search/route/BikingRouteLine$BikingStep;");
                    return;
                }
            }
            CREATOR = new b();
        }

        public BikingStep() {
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
        public BikingStep(Parcel parcel) {
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
            this.f39747d = parcel.readInt();
            this.f39748e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f39749f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f39750g = parcel.readString();
            this.f39751h = parcel.readString();
            this.f39752i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
        }

        private List<LatLng> a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
                if (str != null && str.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    String[] split = str.split(";");
                    if (split != null && split.length != 0) {
                        for (String str2 : split) {
                            String[] split2 = str2.split(",");
                            if (split2 != null && split2.length >= 2) {
                                LatLng latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
                                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                    latLng = CoordTrans.baiduToGcj(latLng);
                                }
                                arrayList.add(latLng);
                            }
                        }
                        return arrayList;
                    }
                }
                return null;
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

        public int getDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39747d : invokeV.intValue;
        }

        public RouteNode getEntrance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39748e : (RouteNode) invokeV.objValue;
        }

        public String getEntranceInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39751h : (String) invokeV.objValue;
        }

        public RouteNode getExit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39749f : (RouteNode) invokeV.objValue;
        }

        public String getExitInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39752i : (String) invokeV.objValue;
        }

        public String getInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (String) invokeV.objValue;
        }

        public String getTurnType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (String) invokeV.objValue;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.mWayPoints == null) {
                    this.mWayPoints = a(this.f39750g);
                }
                return this.mWayPoints;
            }
            return (List) invokeV.objValue;
        }

        public void setDirection(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                this.f39747d = i2;
            }
        }

        public void setEntrance(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, routeNode) == null) {
                this.f39748e = routeNode;
            }
        }

        public void setEntranceInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.f39751h = str;
            }
        }

        public void setExit(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, routeNode) == null) {
                this.f39749f = routeNode;
            }
        }

        public void setExitInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.f39752i = str;
            }
        }

        public void setInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.j = str;
            }
        }

        public void setPathString(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.f39750g = str;
            }
        }

        public void setTurnType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                this.k = str;
            }
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i2) == null) {
                super.writeToParcel(parcel, 1);
                parcel.writeInt(this.f39747d);
                parcel.writeParcelable(this.f39748e, 1);
                parcel.writeParcelable(this.f39749f, 1);
                parcel.writeString(this.f39750g);
                parcel.writeString(this.f39751h);
                parcel.writeString(this.f39752i);
                parcel.writeString(this.j);
                parcel.writeString(this.k);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2115717478, "Lcom/baidu/mapapi/search/route/BikingRouteLine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2115717478, "Lcom/baidu/mapapi/search/route/BikingRouteLine;");
                return;
            }
        }
        CREATOR = new a();
    }

    public BikingRouteLine() {
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
    public BikingRouteLine(Parcel parcel) {
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

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<BikingStep> getAllStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.getAllStep() : (List) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            super.setType(RouteLine.TYPE.BIKINGSTEP);
            super.writeToParcel(parcel, 1);
        }
    }
}
