package com.baidu.mapapi.synchronization;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SyncCoordinateConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LatLng f41973a;

    /* renamed from: b  reason: collision with root package name */
    public CoordType f41974b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class CoordType {
        public static /* synthetic */ Interceptable $ic;
        public static final CoordType BD09LL;
        public static final CoordType COMMON;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ CoordType[] f41975a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(638961749, "Lcom/baidu/mapapi/synchronization/SyncCoordinateConverter$CoordType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(638961749, "Lcom/baidu/mapapi/synchronization/SyncCoordinateConverter$CoordType;");
                    return;
                }
            }
            COMMON = new CoordType("COMMON", 0);
            CoordType coordType = new CoordType("BD09LL", 1);
            BD09LL = coordType;
            f41975a = new CoordType[]{COMMON, coordType};
        }

        public CoordType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CoordType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CoordType) Enum.valueOf(CoordType.class, str) : (CoordType) invokeL.objValue;
        }

        public static CoordType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CoordType[]) f41975a.clone() : (CoordType[]) invokeV.objValue;
        }
    }

    public SyncCoordinateConverter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static LatLng a(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, latLng)) == null) ? a(latLng, "gcj02") : (LatLng) invokeL.objValue;
    }

    public static LatLng a(LatLng latLng, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, latLng, str)) == null) {
            if (latLng == null) {
                return null;
            }
            return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
        }
        return (LatLng) invokeLL.objValue;
    }

    public static LatLng b(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, latLng)) == null) {
            if (latLng == null) {
                return null;
            }
            return CoordTrans.baiduToGcj(latLng);
        }
        return (LatLng) invokeL.objValue;
    }

    public LatLng convert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f41973a == null) {
                return null;
            }
            if (this.f41974b == null) {
                this.f41974b = CoordType.BD09LL;
            }
            int i2 = a.f41978a[this.f41974b.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return b(this.f41973a);
            }
            return a(this.f41973a);
        }
        return (LatLng) invokeV.objValue;
    }

    public SyncCoordinateConverter coord(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, latLng)) == null) {
            this.f41973a = latLng;
            return this;
        }
        return (SyncCoordinateConverter) invokeL.objValue;
    }

    public SyncCoordinateConverter from(CoordType coordType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, coordType)) == null) {
            this.f41974b = coordType;
            return this;
        }
        return (SyncCoordinateConverter) invokeL.objValue;
    }
}
