package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class WeatherResult extends SearchResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<WeatherResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public WeatherSearchRealTime a;
    public WeatherSearchLocation b;
    public List<WeatherSearchForecasts> c;
    public List<WeatherSearchForecastForHours> d;
    public List<WeatherLifeIndexes> e;
    public List<WeatherSearchAlerts> f;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1927909879, "Lcom/baidu/mapapi/search/weather/WeatherResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1927909879, "Lcom/baidu/mapapi/search/weather/WeatherResult;");
                return;
            }
        }
        CREATOR = new b();
    }

    public WeatherResult() {
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

    public List<WeatherSearchForecastForHours> getForecastHours() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List<WeatherSearchForecasts> getForecasts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public List<WeatherLifeIndexes> getLifeIndexes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public WeatherSearchLocation getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (WeatherSearchLocation) invokeV.objValue;
    }

    public WeatherSearchRealTime getRealTimeWeather() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (WeatherSearchRealTime) invokeV.objValue;
    }

    public List<WeatherSearchAlerts> getWeatherAlerts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherResult(Parcel parcel) {
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
        this.a = (WeatherSearchRealTime) parcel.readParcelable(WeatherSearchRealTime.class.getClassLoader());
        this.b = (WeatherSearchLocation) parcel.readParcelable(WeatherSearchLocation.class.getClassLoader());
        this.c = parcel.createTypedArrayList(WeatherSearchForecasts.CREATOR);
        this.d = parcel.createTypedArrayList(WeatherSearchForecastForHours.CREATOR);
        this.e = parcel.createTypedArrayList(WeatherLifeIndexes.CREATOR);
        this.f = parcel.createTypedArrayList(WeatherSearchAlerts.CREATOR);
    }

    public void setForecastHours(List<WeatherSearchForecastForHours> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.d = list;
        }
    }

    public void setForecasts(List<WeatherSearchForecasts> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.c = list;
        }
    }

    public void setLifeIndexes(List<WeatherLifeIndexes> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.e = list;
        }
    }

    public void setLocation(WeatherSearchLocation weatherSearchLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, weatherSearchLocation) == null) {
            this.b = weatherSearchLocation;
        }
    }

    public void setRealTimeWeather(WeatherSearchRealTime weatherSearchRealTime) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, weatherSearchRealTime) == null) {
            this.a = weatherSearchRealTime;
        }
    }

    public void setWeatherAlerts(List<WeatherSearchAlerts> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f = list;
        }
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeTypedList(this.c);
            parcel.writeTypedList(this.d);
            parcel.writeTypedList(this.e);
            parcel.writeTypedList(this.f);
        }
    }
}
