package com.baidu.mapapi.map;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MyLocationConfiguration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int accuracyCircleFillColor;
    public int accuracyCircleStrokeColor;
    public final BitmapDescriptor customMarker;
    public final boolean enableDirection;
    public final LocationMode locationMode;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class LocationMode {
        public static /* synthetic */ Interceptable $ic;
        public static final LocationMode COMPASS;
        public static final LocationMode FOLLOWING;
        public static final LocationMode NORMAL;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ LocationMode[] f40285a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-328089186, "Lcom/baidu/mapapi/map/MyLocationConfiguration$LocationMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-328089186, "Lcom/baidu/mapapi/map/MyLocationConfiguration$LocationMode;");
                    return;
                }
            }
            NORMAL = new LocationMode("NORMAL", 0);
            FOLLOWING = new LocationMode("FOLLOWING", 1);
            LocationMode locationMode = new LocationMode("COMPASS", 2);
            COMPASS = locationMode;
            f40285a = new LocationMode[]{NORMAL, FOLLOWING, locationMode};
        }

        public LocationMode(String str, int i2) {
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

        public static LocationMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LocationMode) Enum.valueOf(LocationMode.class, str) : (LocationMode) invokeL.objValue;
        }

        public static LocationMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LocationMode[]) f40285a.clone() : (LocationMode[]) invokeV.objValue;
        }
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {locationMode, Boolean.valueOf(z), bitmapDescriptor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = a(this.accuracyCircleFillColor);
        this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {locationMode, Boolean.valueOf(z), bitmapDescriptor, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = a(i2);
        this.accuracyCircleStrokeColor = a(i3);
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            return Color.argb(((-16777216) & i2) >> 24, i2 & 255, (65280 & i2) >> 8, (16711680 & i2) >> 16);
        }
        return invokeI.intValue;
    }
}
