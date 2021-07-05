package com.baidu.mapapi.search.route;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
@SuppressLint({"ParcelCreator"})
/* loaded from: classes3.dex */
public class IndoorRouteLine extends RouteLine<IndoorRouteStep> {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<IndoorRouteLine> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class IndoorRouteStep extends RouteStep {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public RouteNode f7352d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7353e;

        /* renamed from: f  reason: collision with root package name */
        public String f7354f;

        /* renamed from: g  reason: collision with root package name */
        public String f7355g;

        /* renamed from: h  reason: collision with root package name */
        public String f7356h;

        /* renamed from: i  reason: collision with root package name */
        public List<IndoorStepNode> f7357i;
        public List<Double> j;

        /* loaded from: classes3.dex */
        public static class IndoorStepNode {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f7358a;

            /* renamed from: b  reason: collision with root package name */
            public int f7359b;

            /* renamed from: c  reason: collision with root package name */
            public LatLng f7360c;

            /* renamed from: d  reason: collision with root package name */
            public String f7361d;

            public IndoorStepNode() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public String getDetail() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7361d : (String) invokeV.objValue;
            }

            public LatLng getLocation() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7360c : (LatLng) invokeV.objValue;
            }

            public String getName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7358a : (String) invokeV.objValue;
            }

            public int getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7359b : invokeV.intValue;
            }

            public void setDetail(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                    this.f7361d = str;
                }
            }

            public void setLocation(LatLng latLng) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, latLng) == null) {
                    this.f7360c = latLng;
                }
            }

            public void setName(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                    this.f7358a = str;
                }
            }

            public void setType(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                    this.f7359b = i2;
                }
            }
        }

        public IndoorRouteStep() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private List<LatLng> a(List<Double> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, list)) == null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < list.size(); i2 += 2) {
                    arrayList.add(new LatLng(list.get(i2).doubleValue(), list.get(i2 + 1).doubleValue()));
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public String getBuildingId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7356h : (String) invokeV.objValue;
        }

        public RouteNode getEntrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7352d : (RouteNode) invokeV.objValue;
        }

        public RouteNode getExit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7353e : (RouteNode) invokeV.objValue;
        }

        public String getFloorId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7355g : (String) invokeV.objValue;
        }

        public String getInstructions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f7354f : (String) invokeV.objValue;
        }

        public List<IndoorStepNode> getStepNodes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7357i : (List) invokeV.objValue;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.mWayPoints == null) {
                    this.mWayPoints = a(this.j);
                }
                return this.mWayPoints;
            }
            return (List) invokeV.objValue;
        }

        public void setBuildingId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.f7356h = str;
            }
        }

        public void setEntrace(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, routeNode) == null) {
                this.f7352d = routeNode;
            }
        }

        public void setExit(RouteNode routeNode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, routeNode) == null) {
                this.f7353e = routeNode;
            }
        }

        public void setFloorId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.f7355g = str;
            }
        }

        public void setInstructions(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.f7354f = str;
            }
        }

        public void setPath(List<Double> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
                this.j = list;
            }
        }

        public void setStepNodes(List<IndoorStepNode> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
                this.f7357i = list;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1105749275, "Lcom/baidu/mapapi/search/route/IndoorRouteLine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1105749275, "Lcom/baidu/mapapi/search/route/IndoorRouteLine;");
                return;
            }
        }
        CREATOR = new g();
    }

    public IndoorRouteLine() {
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
        setType(RouteLine.TYPE.WALKSTEP);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndoorRouteLine(Parcel parcel) {
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
    public List<IndoorRouteStep> getAllStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.getAllStep() : (List) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
        }
    }
}
