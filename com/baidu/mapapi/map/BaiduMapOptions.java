package com.baidu.mapapi.map;

import android.graphics.Point;
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
/* loaded from: classes10.dex */
public final class BaiduMapOptions implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public MapStatus a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36416b;

    /* renamed from: c  reason: collision with root package name */
    public int f36417c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36418d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36419e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36420f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36421g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36422h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36423i;

    /* renamed from: j  reason: collision with root package name */
    public LogoPosition f36424j;

    /* renamed from: k  reason: collision with root package name */
    public Point f36425k;
    public Point l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(387828884, "Lcom/baidu/mapapi/map/BaiduMapOptions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(387828884, "Lcom/baidu/mapapi/map/BaiduMapOptions;");
                return;
            }
        }
        CREATOR = new g();
    }

    public BaiduMapOptions() {
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
        this.a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f36416b = true;
        this.f36417c = 1;
        this.f36418d = true;
        this.f36419e = true;
        this.f36420f = true;
        this.f36421g = true;
        this.f36422h = true;
        this.f36423i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
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
        this.a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f36416b = true;
        this.f36417c = 1;
        this.f36418d = true;
        this.f36419e = true;
        this.f36420f = true;
        this.f36421g = true;
        this.f36422h = true;
        this.f36423i = true;
        this.a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f36416b = parcel.readByte() != 0;
        this.f36417c = parcel.readInt();
        this.f36418d = parcel.readByte() != 0;
        this.f36419e = parcel.readByte() != 0;
        this.f36420f = parcel.readByte() != 0;
        this.f36421g = parcel.readByte() != 0;
        this.f36422h = parcel.readByte() != 0;
        this.f36423i = parcel.readByte() != 0;
        this.f36425k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new com.baidu.mapsdkplatform.comapi.map.z().a(this.a.c()).a(this.f36416b).a(this.f36417c).b(this.f36418d).c(this.f36419e).d(this.f36420f).e(this.f36421g) : (com.baidu.mapsdkplatform.comapi.map.z) invokeV.objValue;
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.f36416b = z;
            return this;
        }
        return (BaiduMapOptions) invokeZ.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public BaiduMapOptions logoPosition(LogoPosition logoPosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, logoPosition)) == null) {
            this.f36424j = logoPosition;
            return this;
        }
        return (BaiduMapOptions) invokeL.objValue;
    }

    public BaiduMapOptions mapStatus(MapStatus mapStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mapStatus)) == null) {
            if (mapStatus != null) {
                this.a = mapStatus;
            }
            return this;
        }
        return (BaiduMapOptions) invokeL.objValue;
    }

    public BaiduMapOptions mapType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f36417c = i2;
            return this;
        }
        return (BaiduMapOptions) invokeI.objValue;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.f36420f = z;
            return this;
        }
        return (BaiduMapOptions) invokeZ.objValue;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f36418d = z;
            return this;
        }
        return (BaiduMapOptions) invokeZ.objValue;
    }

    public BaiduMapOptions scaleControlEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f36423i = z;
            return this;
        }
        return (BaiduMapOptions) invokeZ.objValue;
    }

    public BaiduMapOptions scaleControlPosition(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, point)) == null) {
            this.f36425k = point;
            return this;
        }
        return (BaiduMapOptions) invokeL.objValue;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.f36419e = z;
            return this;
        }
        return (BaiduMapOptions) invokeZ.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i2) == null) {
            parcel.writeParcelable(this.a, i2);
            parcel.writeByte(this.f36416b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f36417c);
            parcel.writeByte(this.f36418d ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f36419e ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f36420f ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f36421g ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f36422h ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f36423i ? (byte) 1 : (byte) 0);
            parcel.writeParcelable(this.f36425k, i2);
            parcel.writeParcelable(this.l, i2);
        }
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.f36422h = z;
            return this;
        }
        return (BaiduMapOptions) invokeZ.objValue;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, point)) == null) {
            this.l = point;
            return this;
        }
        return (BaiduMapOptions) invokeL.objValue;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.f36421g = z;
            return this;
        }
        return (BaiduMapOptions) invokeZ.objValue;
    }
}
