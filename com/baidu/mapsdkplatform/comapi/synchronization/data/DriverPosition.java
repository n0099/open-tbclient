package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class DriverPosition implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<DriverPosition> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f40263a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f40264b;

    /* renamed from: c  reason: collision with root package name */
    public double f40265c;

    /* renamed from: d  reason: collision with root package name */
    public double f40266d;

    /* renamed from: e  reason: collision with root package name */
    public int f40267e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1483122778, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/DriverPosition;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1483122778, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/DriverPosition;");
                return;
            }
        }
        CREATOR = new a();
    }

    public DriverPosition() {
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
        this.f40263a = null;
        this.f40264b = null;
        this.f40265c = 0.0d;
        this.f40266d = 0.0d;
        this.f40267e = 0;
    }

    public DriverPosition(Parcel parcel) {
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
        this.f40263a = parcel.readString();
        this.f40264b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f40265c = parcel.readDouble();
        this.f40266d = parcel.readDouble();
        this.f40267e = parcel.readInt();
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

    public double getAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40265c : invokeV.doubleValue;
    }

    public int getOrderStateInPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40267e : invokeV.intValue;
    }

    public LatLng getPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40264b : (LatLng) invokeV.objValue;
    }

    public double getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40266d : invokeV.doubleValue;
    }

    public String getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40263a : (String) invokeV.objValue;
    }

    public void setAngle(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) {
            double d3 = 0.0d;
            if (d2 >= 0.0d) {
                d3 = 360.0d;
                if (d2 < 360.0d) {
                    this.f40265c = d2;
                    return;
                }
            }
            this.f40265c = d3;
        }
    }

    public void setOrderStateInPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f40267e = i2;
        }
    }

    public void setPoint(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, latLng) == null) {
            this.f40264b = latLng;
        }
    }

    public void setSpeed(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f40266d = d2;
        }
    }

    public void setTimeStamp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f40263a = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i2) == null) {
            parcel.writeString(this.f40263a);
            parcel.writeParcelable(this.f40264b, i2);
            parcel.writeDouble(this.f40265c);
            parcel.writeDouble(this.f40266d);
            parcel.writeInt(this.f40267e);
        }
    }
}
