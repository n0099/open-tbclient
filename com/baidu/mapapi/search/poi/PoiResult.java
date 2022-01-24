package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class PoiResult extends SearchResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<PoiResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f35592b;

    /* renamed from: c  reason: collision with root package name */
    public int f35593c;

    /* renamed from: d  reason: collision with root package name */
    public int f35594d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f35595e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35596f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f35597g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f35598h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(775562333, "Lcom/baidu/mapapi/search/poi/PoiResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(775562333, "Lcom/baidu/mapapi/search/poi/PoiResult;");
                return;
            }
        }
        CREATOR = new f();
    }

    public PoiResult() {
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
        this.a = 0;
        this.f35592b = 0;
        this.f35593c = 0;
        this.f35594d = 0;
        this.f35596f = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoiResult(Parcel parcel) {
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
        this.a = 0;
        this.f35592b = 0;
        this.f35593c = 0;
        this.f35594d = 0;
        this.f35596f = false;
        this.a = parcel.readInt();
        this.f35592b = parcel.readInt();
        this.f35593c = parcel.readInt();
        this.f35594d = parcel.readInt();
        this.f35595e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f35596f = parcel.readByte() != 0;
        this.f35598h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {errorno};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SearchResult.ERRORNO) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f35592b = 0;
        this.f35593c = 0;
        this.f35594d = 0;
        this.f35596f = false;
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

    public List<PoiAddrInfo> getAllAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35597g : (List) invokeV.objValue;
    }

    public List<PoiInfo> getAllPoi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35595e : (List) invokeV.objValue;
    }

    public int getCurrentPageCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35593c : invokeV.intValue;
    }

    public int getCurrentPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    public List<CityInfo> getSuggestCityList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35598h : (List) invokeV.objValue;
    }

    public int getTotalPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35592b : invokeV.intValue;
    }

    public int getTotalPoiNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35594d : invokeV.intValue;
    }

    public boolean isHasAddrInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35596f : invokeV.booleanValue;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f35597g = list;
        }
    }

    public void setCurrentPageCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f35593c = i2;
        }
    }

    public void setCurrentPageNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.a = i2;
        }
    }

    public void setHasAddrInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f35596f = z;
        }
    }

    public void setPoiInfo(List<PoiInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.f35595e = list;
        }
    }

    public void setSuggestCityList(List<CityInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.f35598h = list;
        }
    }

    public void setTotalPageNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f35592b = i2;
        }
    }

    public void setTotalPoiNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f35594d = i2;
        }
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.f35592b);
            parcel.writeInt(this.f35593c);
            parcel.writeInt(this.f35594d);
            parcel.writeTypedList(this.f35595e);
            parcel.writeByte(this.f35596f ? (byte) 1 : (byte) 0);
            parcel.writeTypedList(this.f35598h);
        }
    }
}
