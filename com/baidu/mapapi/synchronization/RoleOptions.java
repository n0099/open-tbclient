package com.baidu.mapapi.synchronization;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class RoleOptions {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f40692a = "RoleOptions";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f40693b;

    /* renamed from: c  reason: collision with root package name */
    public int f40694c;

    /* renamed from: d  reason: collision with root package name */
    public String f40695d;

    /* renamed from: e  reason: collision with root package name */
    public String f40696e;

    /* renamed from: f  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f40697f;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f40698g;

    /* renamed from: h  reason: collision with root package name */
    public String f40699h;

    /* renamed from: i  reason: collision with root package name */
    public String f40700i;
    public LatLng j;
    public String k;
    public String l;
    public LatLng m;
    public String n;
    public String o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-509977915, "Lcom/baidu/mapapi/synchronization/RoleOptions;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-509977915, "Lcom/baidu/mapapi/synchronization/RoleOptions;");
        }
    }

    public RoleOptions() {
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
        this.f40693b = null;
        this.f40694c = 0;
        this.f40695d = null;
        this.f40696e = null;
        SyncCoordinateConverter.CoordType coordType = SyncCoordinateConverter.CoordType.BD09LL;
        this.f40697f = coordType;
        this.f40693b = null;
        this.f40694c = 0;
        this.f40695d = null;
        this.f40696e = null;
        this.f40698g = null;
        this.f40699h = null;
        this.f40700i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f40697f = coordType;
    }

    private LatLng a(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, latLng)) == null) ? new SyncCoordinateConverter().from(this.f40697f).coord(latLng).convert() : (LatLng) invokeL.objValue;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40697f : (SyncCoordinateConverter.CoordType) invokeV.objValue;
    }

    public String getDriverId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40695d : (String) invokeV.objValue;
    }

    public LatLng getDriverPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (LatLng) invokeV.objValue;
    }

    public String getDriverPositionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String getDriverPositionPoiUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public LatLng getEndPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (LatLng) invokeV.objValue;
    }

    public String getEndPositionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String getEndPositionPoiUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40693b : (String) invokeV.objValue;
    }

    public int getRoleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40694c : invokeV.intValue;
    }

    public LatLng getStartPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40698g : (LatLng) invokeV.objValue;
    }

    public String getStartPositionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f40700i : (String) invokeV.objValue;
    }

    public String getStartPositionPoiUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f40699h : (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f40696e : (String) invokeV.objValue;
    }

    public RoleOptions setCoordType(SyncCoordinateConverter.CoordType coordType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, coordType)) == null) {
            if (SyncCoordinateConverter.CoordType.BD09LL == coordType || SyncCoordinateConverter.CoordType.COMMON == coordType) {
                this.f40697f = coordType;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: CoordType only can be BD09LL or COMMON, please check!");
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setDriverId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: driverId is null");
            }
            this.f40695d = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setDriverPosition(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, latLng)) == null) {
            if (latLng == null) {
                this.m = null;
                return this;
            }
            if (SyncCoordinateConverter.CoordType.COMMON == this.f40697f) {
                latLng = a(latLng);
            }
            this.m = latLng;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setDriverPositionName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setDriverPositionPoiUid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.n = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setEndPosition(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, latLng)) == null) {
            if (latLng != null) {
                if (SyncCoordinateConverter.CoordType.COMMON == this.f40697f) {
                    latLng = a(latLng);
                }
                this.j = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: endPosition is null, must be applied!");
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setEndPositionName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setEndPositionPoiUid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setOrderId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: orderId is null.");
            }
            this.f40693b = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setRoleType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if (i2 == 0) {
                this.f40694c = i2;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: role type is invalid: " + i2);
        }
        return (RoleOptions) invokeI.objValue;
    }

    public RoleOptions setStartPosition(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, latLng)) == null) {
            if (latLng != null) {
                if (SyncCoordinateConverter.CoordType.COMMON == this.f40697f) {
                    latLng = a(latLng);
                }
                this.f40698g = latLng;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: StartPosition is null, must be applied!");
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setStartPositionName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f40700i = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setStartPositionPoiUid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f40699h = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }

    public RoleOptions setUserId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: user id is null");
            }
            this.f40696e = str;
            return this;
        }
        return (RoleOptions) invokeL.objValue;
    }
}
