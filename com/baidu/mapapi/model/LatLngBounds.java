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
import java.util.List;
/* loaded from: classes2.dex */
public final class LatLngBounds implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<LatLngBounds> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final LatLng northeast;
    public final LatLng southwest;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public double b;
        public double c;
        public double d;
        public double e;
        public double f;
        public boolean g;

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
            this.g = true;
        }

        private void a(LatLng latLng) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65537, this, latLng) != null) || latLng == null) {
                return;
            }
            double d = latLng.latitude;
            double d2 = latLng.longitude;
            if (d < this.a) {
                this.a = d;
            }
            if (d > this.b) {
                this.b = d;
            }
            int i = (d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1));
            if (i >= 0) {
                if (d2 < this.c) {
                    this.c = d2;
                }
                if (d2 > this.d) {
                    this.d = d2;
                    if (this.c == 0.0d) {
                        this.c = d2;
                    }
                }
                if (i == 0) {
                    this.e = d2;
                    return;
                }
                return;
            }
            if (d2 < this.f) {
                this.f = d2;
            }
            if (d2 > this.e) {
                this.e = d2;
            }
        }

        public LatLngBounds build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.e != 0.0d || this.f != 0.0d) {
                    if (this.d == 0.0d && this.c == 0.0d) {
                        this.d = this.e;
                        this.c = this.f;
                    } else {
                        double d = this.f + 360.0d;
                        this.c = d;
                        double d2 = this.d;
                        if (d > d2) {
                            this.d = d;
                            this.c = d2;
                        }
                    }
                }
                double d3 = this.d;
                if (d3 > 180.0d) {
                    double d4 = d3 - 360.0d;
                    this.d = d4;
                    double d5 = this.c;
                    if (d4 < d5) {
                        this.d = d5;
                        this.c = d4;
                    }
                }
                return new LatLngBounds(new LatLng(this.b, this.d), new LatLng(this.a, this.c));
            }
            return (LatLngBounds) invokeV.objValue;
        }

        public Builder include(LatLng latLng) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
                if (latLng == null) {
                    return this;
                }
                if (this.g) {
                    this.g = false;
                    double d = latLng.longitude;
                    if (d >= 0.0d) {
                        this.c = d;
                        this.d = d;
                    } else {
                        this.f = d;
                        this.e = d;
                    }
                    double d2 = latLng.latitude;
                    this.a = d2;
                    this.b = d2;
                }
                a(latLng);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder include(List<LatLng> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                if (list != null && list.size() != 0) {
                    if (list.get(0) != null && this.g) {
                        this.g = false;
                        if (list.get(0).longitude >= 0.0d) {
                            double d = list.get(0).longitude;
                            this.c = d;
                            this.d = d;
                        } else {
                            double d2 = list.get(0).longitude;
                            this.f = d2;
                            this.e = d2;
                        }
                        double d3 = list.get(0).latitude;
                        this.a = d3;
                        this.b = d3;
                    }
                    for (LatLng latLng : list) {
                        a(latLng);
                    }
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
            if (d5 >= d && d5 <= d2 && d6 >= d3 && d6 <= d4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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
