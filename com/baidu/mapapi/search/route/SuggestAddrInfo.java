package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class SuggestAddrInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SuggestAddrInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<PoiInfo> f41983a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f41984b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f41985c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f41986d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f41987e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f41988f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1355504350, "Lcom/baidu/mapapi/search/route/SuggestAddrInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1355504350, "Lcom/baidu/mapapi/search/route/SuggestAddrInfo;");
                return;
            }
        }
        CREATOR = new n();
    }

    public SuggestAddrInfo() {
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

    public SuggestAddrInfo(Parcel parcel) {
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
        this.f41983a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f41984b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f41985c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f41986d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f41987e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f41988f = parcel.readArrayList(CityInfo.class.getClassLoader());
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

    public List<CityInfo> getSuggestEndCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41987e : (List) invokeV.objValue;
    }

    public List<PoiInfo> getSuggestEndNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41984b : (List) invokeV.objValue;
    }

    public List<CityInfo> getSuggestStartCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41986d : (List) invokeV.objValue;
    }

    public List<PoiInfo> getSuggestStartNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41983a : (List) invokeV.objValue;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41988f : (List) invokeV.objValue;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41985c : (List) invokeV.objValue;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f41987e = list;
        }
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f41984b = list;
        }
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f41986d = list;
        }
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f41983a = list;
        }
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f41988f = list;
        }
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f41985c = list;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i2) == null) {
            parcel.writeList(this.f41983a);
            parcel.writeList(this.f41984b);
            parcel.writeList(this.f41985c);
            parcel.writeList(this.f41986d);
            parcel.writeList(this.f41987e);
            parcel.writeList(this.f41988f);
        }
    }
}
