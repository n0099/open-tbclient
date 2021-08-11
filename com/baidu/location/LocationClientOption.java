package com.baidu.location;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class LocationClientOption {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GpsFirst = 1;
    public static final int GpsOnly = 3;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LocationMode f40763a;
    public String addrType;
    public float autoNotifyLocSensitivity;
    public int autoNotifyMaxInterval;
    public int autoNotifyMinDistance;
    public int autoNotifyMinTimeInterval;
    public String coorType;
    public boolean disableLocCache;
    public boolean enableSimulateGps;
    public boolean isIgnoreCacheException;
    public boolean isIgnoreKillProcess;
    public boolean isNeedAltitude;
    public boolean isNeedAptag;
    public boolean isNeedAptagd;
    public boolean isNeedNewVersionRgc;
    public boolean isNeedPoiRegion;
    public boolean isNeedRegular;
    public boolean location_change_notify;
    public boolean mIsNeedDeviceDirect;
    public boolean openGps;
    public int priority;
    public String prodName;
    public int scanSpan;
    public String serviceName;
    public int timeOut;
    public int wifiCacheTimeOut;

    /* renamed from: com.baidu.location.LocationClientOption$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40764a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1557003085, "Lcom/baidu/location/LocationClientOption$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1557003085, "Lcom/baidu/location/LocationClientOption$1;");
                    return;
                }
            }
            int[] iArr = new int[LocationMode.values().length];
            f40764a = iArr;
            try {
                iArr[LocationMode.Hight_Accuracy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40764a[LocationMode.Battery_Saving.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40764a[LocationMode.Device_Sensors.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class LocationMode {
        public static final /* synthetic */ LocationMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LocationMode Battery_Saving;
        public static final LocationMode Device_Sensors;
        public static final LocationMode Hight_Accuracy;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1697229600, "Lcom/baidu/location/LocationClientOption$LocationMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1697229600, "Lcom/baidu/location/LocationClientOption$LocationMode;");
                    return;
                }
            }
            Hight_Accuracy = new LocationMode("Hight_Accuracy", 0);
            Battery_Saving = new LocationMode("Battery_Saving", 1);
            LocationMode locationMode = new LocationMode("Device_Sensors", 2);
            Device_Sensors = locationMode;
            $VALUES = new LocationMode[]{Hight_Accuracy, Battery_Saving, locationMode};
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LocationMode[]) $VALUES.clone() : (LocationMode[]) invokeV.objValue;
        }
    }

    public LocationClientOption() {
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
        this.coorType = "gcj02";
        this.addrType = "detail";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = true;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {locationClientOption};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.coorType = "gcj02";
        this.addrType = "detail";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = 12000;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = true;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
        this.coorType = locationClientOption.coorType;
        this.addrType = locationClientOption.addrType;
        this.openGps = locationClientOption.openGps;
        this.scanSpan = locationClientOption.scanSpan;
        this.timeOut = locationClientOption.timeOut;
        this.prodName = locationClientOption.prodName;
        this.priority = locationClientOption.priority;
        this.location_change_notify = locationClientOption.location_change_notify;
        this.serviceName = locationClientOption.serviceName;
        this.disableLocCache = locationClientOption.disableLocCache;
        this.isIgnoreCacheException = locationClientOption.isIgnoreCacheException;
        this.isIgnoreKillProcess = locationClientOption.isIgnoreKillProcess;
        this.enableSimulateGps = locationClientOption.enableSimulateGps;
        this.f40763a = locationClientOption.f40763a;
        this.isNeedAptag = locationClientOption.isNeedAptag;
        this.isNeedAptagd = locationClientOption.isNeedAptagd;
        this.isNeedPoiRegion = locationClientOption.isNeedPoiRegion;
        this.isNeedRegular = locationClientOption.isNeedRegular;
        this.mIsNeedDeviceDirect = locationClientOption.mIsNeedDeviceDirect;
        this.isNeedAltitude = locationClientOption.isNeedAltitude;
        this.autoNotifyMaxInterval = locationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = locationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = locationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = locationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = locationClientOption.wifiCacheTimeOut;
        this.isNeedNewVersionRgc = locationClientOption.isNeedNewVersionRgc;
    }

    public void SetIgnoreCacheException(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.isIgnoreCacheException = z;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.autoNotifyMaxInterval : invokeV.intValue;
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.autoNotifyLocSensitivity : invokeV.floatValue;
    }

    public void disableCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.disableLocCache = z;
        }
    }

    public String getAddrType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.addrType : (String) invokeV.objValue;
    }

    public int getAutoNotifyMinDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.autoNotifyMinDistance : invokeV.intValue;
    }

    public int getAutoNotifyMinTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.autoNotifyMinTimeInterval : invokeV.intValue;
    }

    public String getCoorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.coorType : (String) invokeV.objValue;
    }

    public LocationMode getLocationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40763a : (LocationMode) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.priority : invokeV.intValue;
    }

    public String getProdName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.prodName : (String) invokeV.objValue;
    }

    public int getScanSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.scanSpan : invokeV.intValue;
    }

    public String getServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.serviceName : (String) invokeV.objValue;
    }

    public int getTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.timeOut : invokeV.intValue;
    }

    public boolean isDisableCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.disableLocCache : invokeV.booleanValue;
    }

    public boolean isLocationNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.location_change_notify : invokeV.booleanValue;
    }

    public boolean isOpenGps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.openGps : invokeV.booleanValue;
    }

    public boolean optionEquals(LocationClientOption locationClientOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, locationClientOption)) == null) ? this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isNeedNewVersionRgc == locationClientOption.isNeedNewVersionRgc && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.f40763a == locationClientOption.f40763a : invokeL.booleanValue;
    }

    @Deprecated
    public void setAddrType(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        setIsNeedAddress("all".equals(str));
    }

    public void setCoorType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.equals("gcj02") || lowerCase.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09) || lowerCase.equals("bd09ll")) {
                this.coorType = lowerCase;
            }
        }
    }

    public void setEnableSimulateGps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.enableSimulateGps = z;
        }
    }

    public void setIgnoreKillProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.isIgnoreKillProcess = z;
        }
    }

    public void setIsNeedAddress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.addrType = z ? "all" : "noaddr";
        }
    }

    public void setIsNeedAltitude(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.isNeedAltitude = z;
        }
    }

    public void setIsNeedLocationDescribe(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.isNeedAptag = z;
        }
    }

    public void setIsNeedLocationPoiList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.isNeedAptagd = z;
        }
    }

    public void setLocationMode(LocationMode locationMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, locationMode) == null) {
            int i2 = AnonymousClass1.f40764a[locationMode.ordinal()];
            if (i2 == 1) {
                this.openGps = true;
                this.priority = 1;
            } else if (i2 == 2) {
                this.openGps = false;
                this.priority = 2;
            } else if (i2 != 3) {
                throw new IllegalArgumentException("Illegal this mode : " + locationMode);
            } else {
                this.priority = 3;
                this.openGps = true;
            }
            this.f40763a = locationMode;
        }
    }

    public void setLocationNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.location_change_notify = z;
        }
    }

    public void setNeedDeviceDirect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mIsNeedDeviceDirect = z;
        }
    }

    public void setNeedNewVersionRgc(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.isNeedNewVersionRgc = z;
        }
    }

    public void setOpenAutoNotifyMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            setOpenAutoNotifyMode(0, 0, 1);
        }
    }

    public void setOpenAutoNotifyMode(int i2, int i3, int i4) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048607, this, i2, i3, i4) == null) {
            int i5 = TiebaStatic.MAX_COST_VALUE;
            if (i2 > 180000) {
                i5 = i2 + 1000;
            }
            if (i5 < 10000) {
                throw new IllegalArgumentException("Illegal this maxLocInterval : " + i5 + " , maxLocInterval must >= 10000");
            }
            if (i4 == 1) {
                f2 = 0.5f;
            } else if (i4 == 2) {
                f2 = 0.3f;
            } else if (i4 != 3) {
                throw new IllegalArgumentException("Illegal this locSensitivity : " + i4);
            } else {
                f2 = 0.1f;
            }
            this.autoNotifyLocSensitivity = f2;
            this.autoNotifyMaxInterval = i5;
            this.autoNotifyMinTimeInterval = i2;
            this.autoNotifyMinDistance = i3;
        }
    }

    public void setOpenGps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.openGps = z;
        }
    }

    @Deprecated
    public void setPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            if (i2 == 1 || i2 == 2) {
                this.priority = i2;
            }
        }
    }

    public void setProdName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            if (str.length() > 64) {
                str = str.substring(0, 64);
            }
            this.prodName = str;
        }
    }

    public void setScanSpan(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || i2 < 0) {
            return;
        }
        this.scanSpan = i2;
    }

    @Deprecated
    public void setSema(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.isNeedAptag = z;
            this.isNeedPoiRegion = z2;
            this.isNeedRegular = z3;
        }
    }

    public void setServiceName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.serviceName = str;
        }
    }

    public void setTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.timeOut = i2;
        }
    }

    public void setWifiCacheTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || i2 < 10000) {
            return;
        }
        this.wifiCacheTimeOut = i2;
    }
}
