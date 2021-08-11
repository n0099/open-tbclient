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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes5.dex */
public final class LatLngBounds implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<LatLngBounds> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: classes5.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f41492a;

        /* renamed from: b  reason: collision with root package name */
        public double f41493b;

        /* renamed from: c  reason: collision with root package name */
        public double f41494c;

        /* renamed from: d  reason: collision with root package name */
        public double f41495d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41496e;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41496e = true;
        }

        public LatLngBounds build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LatLngBounds(new LatLng(this.f41493b, this.f41495d), new LatLng(this.f41492a, this.f41494c)) : (LatLngBounds) invokeV.objValue;
        }

        public Builder include(LatLng latLng) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
                if (latLng == null) {
                    return this;
                }
                if (this.f41496e) {
                    this.f41496e = false;
                    double d2 = latLng.latitude;
                    this.f41492a = d2;
                    this.f41493b = d2;
                    double d3 = latLng.longitude;
                    this.f41494c = d3;
                    this.f41495d = d3;
                }
                double d4 = latLng.latitude;
                double d5 = latLng.longitude;
                if (d4 < this.f41492a) {
                    this.f41492a = d4;
                }
                if (d4 > this.f41493b) {
                    this.f41493b = d4;
                }
                if (d5 < this.f41494c) {
                    this.f41494c = d5;
                }
                if (d5 > this.f41495d) {
                    this.f41495d = d5;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            double d2 = latLng2.latitude;
            LatLng latLng3 = this.northeast;
            double d3 = latLng3.latitude;
            double d4 = latLng2.longitude;
            double d5 = latLng3.longitude;
            double d6 = latLng.latitude;
            double d7 = latLng.longitude;
            return d6 >= d2 && d6 <= d3 && d7 >= d4 && d7 <= d5;
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
            double d2 = latLng.latitude;
            LatLng latLng2 = this.southwest;
            double d3 = latLng2.latitude;
            double d4 = ((d2 - d3) / 2.0d) + d3;
            double d5 = latLng.longitude;
            double d6 = latLng2.longitude;
            return new LatLng(d4, ((d5 - d6) / 2.0d) + d6);
        }
        return (LatLng) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "southwest: " + this.southwest.latitude + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.southwest.longitude + StringUtils.LF + "northeast: " + this.northeast.latitude + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.northeast.longitude;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i2) == null) {
            parcel.writeParcelable(this.northeast, i2);
            parcel.writeParcelable(this.southwest, i2);
        }
    }
}
