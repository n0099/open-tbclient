package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
/* loaded from: classes7.dex */
public class BusLineResult extends SearchResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<BusLineResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39631a;

    /* renamed from: b  reason: collision with root package name */
    public String f39632b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39633c;

    /* renamed from: d  reason: collision with root package name */
    public Date f39634d;

    /* renamed from: e  reason: collision with root package name */
    public Date f39635e;

    /* renamed from: f  reason: collision with root package name */
    public String f39636f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f39637g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f39638h;

    /* renamed from: i  reason: collision with root package name */
    public float f39639i;
    public float j;
    public String k;

    /* loaded from: classes7.dex */
    public static class BusStation extends RouteNode {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BusStation() {
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
    }

    /* loaded from: classes7.dex */
    public static class BusStep extends RouteStep {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BusStep() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-606041879, "Lcom/baidu/mapapi/search/busline/BusLineResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-606041879, "Lcom/baidu/mapapi/search/busline/BusLineResult;");
                return;
            }
        }
        CREATOR = new a();
    }

    public BusLineResult() {
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
        this.f39631a = null;
        this.f39632b = null;
        this.f39637g = null;
        this.f39638h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
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
        this.f39631a = null;
        this.f39632b = null;
        this.f39637g = null;
        this.f39638h = null;
        this.k = null;
        this.f39631a = parcel.readString();
        this.f39632b = parcel.readString();
        this.f39633c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f39634d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f39635e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f39636f = parcel.readString();
        this.f39637g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f39638h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public float getBasePrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39639i : invokeV.floatValue;
    }

    public String getBusCompany() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39631a : (String) invokeV.objValue;
    }

    public String getBusLineName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39632b : (String) invokeV.objValue;
    }

    public Date getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39635e : (Date) invokeV.objValue;
    }

    public String getLineDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public float getMaxPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.floatValue;
    }

    public Date getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f39634d : (Date) invokeV.objValue;
    }

    public List<BusStation> getStations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39637g : (List) invokeV.objValue;
    }

    public List<BusStep> getSteps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39638h : (List) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f39636f : (String) invokeV.objValue;
    }

    public boolean isMonthTicket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f39633c : invokeV.booleanValue;
    }

    public void setBasePrice(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            this.f39639i = f2;
        }
    }

    public void setBusLineName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f39632b = str;
        }
    }

    public void setEndTime(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, date) == null) {
            this.f39635e = date;
        }
    }

    public void setLineDirection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.k = str;
        }
    }

    public void setMaxPrice(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.j = f2;
        }
    }

    public void setMonthTicket(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f39633c = z;
        }
    }

    public void setStartTime(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, date) == null) {
            this.f39634d = date;
        }
    }

    public void setStations(List<BusStation> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.f39637g = list;
        }
    }

    public void setSteps(List<BusStep> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            this.f39638h = list;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f39636f = str;
        }
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, parcel, i2) == null) {
            parcel.writeString(this.f39631a);
            parcel.writeString(this.f39632b);
            parcel.writeValue(Boolean.valueOf(this.f39633c));
            parcel.writeValue(this.f39634d);
            parcel.writeValue(this.f39635e);
            parcel.writeString(this.f39636f);
            parcel.writeList(this.f39637g);
            parcel.writeList(this.f39638h);
        }
    }
}
