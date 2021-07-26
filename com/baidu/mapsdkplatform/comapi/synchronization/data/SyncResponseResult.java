package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SyncResponseResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f7893a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f7894b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f7895c;

    /* renamed from: d  reason: collision with root package name */
    public float f7896d;

    /* renamed from: e  reason: collision with root package name */
    public long f7897e;

    /* renamed from: f  reason: collision with root package name */
    public float f7898f;

    /* renamed from: g  reason: collision with root package name */
    public long f7899g;

    /* renamed from: h  reason: collision with root package name */
    public int f7900h;

    /* renamed from: i  reason: collision with root package name */
    public String f7901i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-264501358, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/SyncResponseResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-264501358, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/SyncResponseResult;");
                return;
            }
        }
        CREATOR = new j();
    }

    public SyncResponseResult() {
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
        this.f7893a = new RouteLineInfo();
        this.f7894b = new TrafficInfo();
        this.f7895c = new DriverPosition();
        this.f7896d = 0.0f;
        this.f7897e = 0L;
        this.f7898f = 0.0f;
        this.f7899g = 0L;
        this.f7900h = 0;
        this.f7901i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
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
        this.f7893a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f7894b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f7895c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f7896d = (float) parcel.readLong();
        this.f7897e = parcel.readLong();
        this.f7898f = (float) parcel.readLong();
        this.f7899g = parcel.readLong();
        this.f7900h = parcel.readInt();
        this.f7901i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7893a : (RouteLineInfo) invokeV.objValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f7896d = f2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f7900h = i2;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f7897e = j;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f7901i = str;
        }
    }

    public TrafficInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f7894b : (TrafficInfo) invokeV.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f7898f = f2;
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f7899g = j;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }

    public DriverPosition c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f7895c : (DriverPosition) invokeV.objValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f7898f : invokeV.floatValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f7899g : invokeV.longValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i2) == null) {
            parcel.writeParcelable(this.f7893a, 1);
            parcel.writeParcelable(this.f7894b, 1);
            parcel.writeParcelable(this.f7895c, 1);
            parcel.writeFloat(this.f7896d);
            parcel.writeLong(this.f7897e);
            parcel.writeFloat(this.f7898f);
            parcel.writeLong(this.f7899g);
            parcel.writeInt(this.f7900h);
            parcel.writeString(this.f7901i);
            parcel.writeString(this.j);
        }
    }
}
