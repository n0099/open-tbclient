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
/* loaded from: classes2.dex */
public final class LocationClientOption {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FUZZY_MODE = 4;
    public static final int GPS_ONLY = 2;
    public static final int GpsFirst = 1;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NETWORK_FIRST = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public LocationMode a;
    public String addrType;
    public float autoNotifyLocSensitivity;
    public int autoNotifyMaxInterval;
    public int autoNotifyMinDistance;
    public int autoNotifyMinTimeInterval;
    public String coorType;
    public boolean disableLocCache;
    public boolean enableSimulateGps;
    public FirstLocType firstLocType;
    public boolean isEnableBeidouMode;
    public boolean isIgnoreCacheException;
    public boolean isIgnoreKillProcess;
    public boolean isNeedAltitude;
    public boolean isNeedAptag;
    public boolean isNeedAptagd;
    public boolean isNeedNewVersionRgc;
    public boolean isNeedPoiRegion;
    public boolean isNeedRegular;
    public boolean isOnceLocation;
    public int locLegalStatus;
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
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[LocationMode.Hight_Accuracy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LocationMode.Battery_Saving.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LocationMode.Device_Sensors.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LocationMode.Fuzzy_Locating.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class BDLocationPurpose {
        public static final /* synthetic */ BDLocationPurpose[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BDLocationPurpose SignIn;
        public static final BDLocationPurpose Sport;
        public static final BDLocationPurpose Transport;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(404618551, "Lcom/baidu/location/LocationClientOption$BDLocationPurpose;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(404618551, "Lcom/baidu/location/LocationClientOption$BDLocationPurpose;");
                    return;
                }
            }
            SignIn = new BDLocationPurpose("SignIn", 0);
            Sport = new BDLocationPurpose("Sport", 1);
            BDLocationPurpose bDLocationPurpose = new BDLocationPurpose("Transport", 2);
            Transport = bDLocationPurpose;
            $VALUES = new BDLocationPurpose[]{SignIn, Sport, bDLocationPurpose};
        }

        public BDLocationPurpose(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BDLocationPurpose valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BDLocationPurpose) Enum.valueOf(BDLocationPurpose.class, str) : (BDLocationPurpose) invokeL.objValue;
        }

        public static BDLocationPurpose[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BDLocationPurpose[]) $VALUES.clone() : (BDLocationPurpose[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class FirstLocType {
        public static final /* synthetic */ FirstLocType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FirstLocType ACCURACY_IN_FIRST_LOC;
        public static final FirstLocType SPEED_IN_FIRST_LOC;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1348597106, "Lcom/baidu/location/LocationClientOption$FirstLocType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1348597106, "Lcom/baidu/location/LocationClientOption$FirstLocType;");
                    return;
                }
            }
            SPEED_IN_FIRST_LOC = new FirstLocType("SPEED_IN_FIRST_LOC", 0);
            FirstLocType firstLocType = new FirstLocType("ACCURACY_IN_FIRST_LOC", 1);
            ACCURACY_IN_FIRST_LOC = firstLocType;
            $VALUES = new FirstLocType[]{SPEED_IN_FIRST_LOC, firstLocType};
        }

        public FirstLocType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FirstLocType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FirstLocType) Enum.valueOf(FirstLocType.class, str) : (FirstLocType) invokeL.objValue;
        }

        public static FirstLocType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FirstLocType[]) $VALUES.clone() : (FirstLocType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LocationMode {
        public static final /* synthetic */ LocationMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LocationMode Battery_Saving;
        public static final LocationMode Device_Sensors;
        public static final LocationMode Fuzzy_Locating;
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
            Device_Sensors = new LocationMode("Device_Sensors", 2);
            LocationMode locationMode = new LocationMode("Fuzzy_Locating", 3);
            Fuzzy_Locating = locationMode;
            $VALUES = new LocationMode[]{Hight_Accuracy, Battery_Saving, Device_Sensors, locationMode};
        }

        public LocationMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.coorType = "gcj02";
        this.addrType = "noaddr";
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
        this.isNeedNewVersionRgc = true;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
        this.locLegalStatus = 1;
        this.isEnableBeidouMode = false;
        this.firstLocType = FirstLocType.SPEED_IN_FIRST_LOC;
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {locationClientOption};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.coorType = "gcj02";
        this.addrType = "noaddr";
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
        this.isNeedNewVersionRgc = true;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
        this.locLegalStatus = 1;
        this.isEnableBeidouMode = false;
        this.firstLocType = FirstLocType.SPEED_IN_FIRST_LOC;
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
        this.a = locationClientOption.a;
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
        this.isOnceLocation = locationClientOption.isOnceLocation;
        this.locLegalStatus = locationClientOption.locLegalStatus;
        this.isEnableBeidouMode = locationClientOption.isEnableBeidouMode;
        this.firstLocType = locationClientOption.firstLocType;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (LocationMode) invokeV.objValue;
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

    public boolean isOnceLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.isOnceLocation : invokeV.booleanValue;
    }

    public boolean isOpenGps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.openGps : invokeV.booleanValue;
    }

    public boolean optionEquals(LocationClientOption locationClientOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, locationClientOption)) == null) ? this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isNeedNewVersionRgc == locationClientOption.isNeedNewVersionRgc && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isOnceLocation == locationClientOption.isOnceLocation && this.locLegalStatus == locationClientOption.locLegalStatus && this.isEnableBeidouMode == locationClientOption.isEnableBeidouMode && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.a == locationClientOption.a && this.enableSimulateGps == locationClientOption.enableSimulateGps && this.firstLocType == locationClientOption.firstLocType : invokeL.booleanValue;
    }

    @Deprecated
    public void setAddrType(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        setIsNeedAddress("all".equals(str));
    }

    public void setCoorType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
                this.coorType = lowerCase;
            }
        }
    }

    public void setEnableSimulateGps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.enableSimulateGps = z;
        }
    }

    public void setFirstLocType(FirstLocType firstLocType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, firstLocType) == null) {
            this.firstLocType = firstLocType;
        }
    }

    public void setIgnoreKillProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.isIgnoreKillProcess = z;
        }
    }

    public void setIsEnableBeidouMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.isEnableBeidouMode = z;
        }
    }

    public void setIsNeedAddress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.addrType = z ? "all" : "noaddr";
        }
    }

    public void setIsNeedAltitude(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.isNeedAltitude = z;
        }
    }

    public void setIsNeedLocationDescribe(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.isNeedAptag = z;
        }
    }

    public void setIsNeedLocationPoiList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.isNeedAptagd = z;
        }
    }

    public void setLocStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.locLegalStatus = z ? 1 : !z ? -2 : 0;
        }
    }

    public void setLocationMode(LocationMode locationMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, locationMode) == null) {
            int i = AnonymousClass1.a[locationMode.ordinal()];
            if (i == 1) {
                this.openGps = true;
                this.priority = 1;
            } else if (i == 2) {
                this.openGps = false;
                this.priority = 3;
            } else if (i == 3) {
                this.priority = 2;
                this.openGps = true;
            } else if (i != 4) {
                throw new IllegalArgumentException("Illegal this mode : " + locationMode);
            } else {
                this.priority = 4;
                this.openGps = false;
            }
            this.a = locationMode;
        }
    }

    public void setLocationNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.location_change_notify = z;
        }
    }

    public void setLocationPurpose(BDLocationPurpose bDLocationPurpose) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, bDLocationPurpose) == null) || bDLocationPurpose == null) {
            return;
        }
        if (bDLocationPurpose == BDLocationPurpose.SignIn) {
            setLocationMode(LocationMode.Hight_Accuracy);
            setLocationNotify(false);
            setScanSpan(0);
            setNeedNewVersionRgc(true);
            setIsNeedAddress(true);
            setIsNeedLocationPoiList(true);
            setIsNeedAltitude(true);
            setIsNeedLocationDescribe(true);
            setWifiCacheTimeOut(10000);
            return;
        }
        if (bDLocationPurpose == BDLocationPurpose.Sport) {
            setLocationMode(LocationMode.Hight_Accuracy);
            setLocationNotify(true);
            setScanSpan(3000);
        } else if (bDLocationPurpose != BDLocationPurpose.Transport) {
            return;
        } else {
            setLocationMode(LocationMode.Hight_Accuracy);
            setLocationNotify(true);
            setScanSpan(1000);
        }
        setNeedNewVersionRgc(true);
        setIsNeedAddress(true);
        setIsNeedLocationPoiList(false);
        setIsNeedAltitude(true);
        setIsNeedLocationDescribe(false);
        setWifiCacheTimeOut(1000);
    }

    public void setNeedDeviceDirect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.mIsNeedDeviceDirect = z;
        }
    }

    public void setNeedNewVersionRgc(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.isNeedNewVersionRgc = z;
        }
    }

    public void setOnceLocation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.isOnceLocation = z;
        }
    }

    public void setOpenAutoNotifyMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            setOpenAutoNotifyMode(0, 0, 1);
        }
    }

    public void setOpenAutoNotifyMode(int i, int i2, int i3) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048613, this, i, i2, i3) == null) {
            int i4 = TiebaStatic.MAX_COST_VALUE;
            if (i > 180000) {
                i4 = i + 1000;
            }
            if (i4 < 10000) {
                throw new IllegalArgumentException("Illegal this maxLocInterval : " + i4 + " , maxLocInterval must >= 10000");
            }
            if (i3 == 1) {
                f = 0.5f;
            } else if (i3 == 2) {
                f = 0.3f;
            } else if (i3 != 3) {
                throw new IllegalArgumentException("Illegal this locSensitivity : " + i3);
            } else {
                f = 0.1f;
            }
            this.autoNotifyLocSensitivity = f;
            this.autoNotifyMaxInterval = i4;
            this.autoNotifyMinTimeInterval = i;
            this.autoNotifyMinDistance = i2;
        }
    }

    public void setOpenGps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.openGps = z;
        }
    }

    @Deprecated
    public void setPriority(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            if (i == 1 || i == 3) {
                this.priority = i;
            }
        }
    }

    public void setProdName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            if (str.length() > 64) {
                str = str.substring(0, 64);
            }
            this.prodName = str;
        }
    }

    public void setScanSpan(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i) == null) || i < 0) {
            return;
        }
        this.scanSpan = i;
    }

    @Deprecated
    public void setSema(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.isNeedAptag = z;
            this.isNeedPoiRegion = z2;
            this.isNeedRegular = z3;
        }
    }

    public void setServiceName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.serviceName = str;
        }
    }

    public void setTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.timeOut = i;
        }
    }

    public void setWifiCacheTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i) == null) || i < 10000) {
            return;
        }
        this.wifiCacheTimeOut = i;
    }
}
