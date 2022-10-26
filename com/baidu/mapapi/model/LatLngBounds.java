package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class LatLngBounds implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: classes2.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public double b;
        public double c;
        public double d;
        public boolean e;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = true;
        }

        public LatLngBounds build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LatLngBounds(new LatLng(this.b, this.d), new LatLng(this.a, this.c)) : (LatLngBounds) invokeV.objValue;
        }

        public Builder include(LatLng latLng) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
                if (latLng == null) {
                    return this;
                }
                if (this.e) {
                    this.e = false;
                    double d = latLng.latitude;
                    this.a = d;
                    this.b = d;
                    double d2 = latLng.longitude;
                    this.c = d2;
                    this.d = d2;
                }
                double d3 = latLng.latitude;
                double d4 = latLng.longitude;
                if (d3 < this.a) {
                    this.a = d3;
                }
                if (d3 > this.b) {
                    this.b = d3;
                }
                if (d4 < this.c) {
                    this.c = d4;
                }
                if (d4 > this.d) {
                    this.d = d4;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1479529225, "Lcom/baidu/mapapi/model/LatLngBounds;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1479529225, "Lcom/baidu/mapapi/model/LatLngBounds;");
                return;
            }
        }
        CREATOR = new b();
    }

    public LatLngBounds(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.northeast = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {latLng, latLng2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.northeast = latLng;
        this.southwest = latLng2;
    }

    public boolean contains(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, latLng)) == null) {
            if (latLng == null) {
                return false;
            }
            LatLng latLng2 = this.southwest;
            double d = latLng2.latitude;
            LatLng latLng3 = this.northeast;
            double d2 = latLng3.latitude;
            double d3 = latLng2.longitude;
            double d4 = latLng3.longitude;
            double d5 = latLng.latitude;
            double d6 = latLng.longitude;
            return d5 >= d && d5 <= d2 && d6 >= d3 && d6 <= d4;
        }
        return invokeL.booleanValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public LatLng getCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LatLng latLng = this.northeast;
            double d = latLng.latitude;
            LatLng latLng2 = this.southwest;
            double d2 = latLng2.latitude;
            double d3 = ((d - d2) / 2.0d) + d2;
            double d4 = latLng.longitude;
            double d5 = latLng2.longitude;
            return new LatLng(d3, ((d4 - d5) / 2.0d) + d5);
        }
        return (LatLng) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "southwest: " + this.southwest.latitude + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.northeast.longitude;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i) == null) {
            parcel.writeParcelable(this.northeast, i);
            parcel.writeParcelable(this.southwest, i);
        }
    }
}
