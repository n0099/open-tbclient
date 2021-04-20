package com.baidu.location;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes2.dex */
public final class LocationClientOption {
    public static final int GpsFirst = 1;
    public static final int GpsOnly = 3;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NetWorkFirst = 2;

    /* renamed from: a  reason: collision with root package name */
    public LocationMode f6482a;
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
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6483a;

        static {
            int[] iArr = new int[LocationMode.values().length];
            f6483a = iArr;
            try {
                iArr[LocationMode.Hight_Accuracy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6483a[LocationMode.Battery_Saving.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6483a[LocationMode.Device_Sensors.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum LocationMode {
        Hight_Accuracy,
        Battery_Saving,
        Device_Sensors
    }

    public LocationClientOption() {
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
        this.f6482a = locationClientOption.f6482a;
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
        this.isIgnoreCacheException = z;
    }

    public int a() {
        return this.autoNotifyMaxInterval;
    }

    public float b() {
        return this.autoNotifyLocSensitivity;
    }

    public void disableCache(boolean z) {
        this.disableLocCache = z;
    }

    public String getAddrType() {
        return this.addrType;
    }

    public int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }

    public int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }

    public String getCoorType() {
        return this.coorType;
    }

    public LocationMode getLocationMode() {
        return this.f6482a;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProdName() {
        return this.prodName;
    }

    public int getScanSpan() {
        return this.scanSpan;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public boolean isDisableCache() {
        return this.disableLocCache;
    }

    public boolean isLocationNotify() {
        return this.location_change_notify;
    }

    public boolean isOpenGps() {
        return this.openGps;
    }

    public boolean optionEquals(LocationClientOption locationClientOption) {
        return this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isNeedNewVersionRgc == locationClientOption.isNeedNewVersionRgc && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.f6482a == locationClientOption.f6482a;
    }

    @Deprecated
    public void setAddrType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setIsNeedAddress("all".equals(str));
    }

    public void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09) || lowerCase.equals("bd09ll")) {
            this.coorType = lowerCase;
        }
    }

    public void setEnableSimulateGps(boolean z) {
        this.enableSimulateGps = z;
    }

    public void setIgnoreKillProcess(boolean z) {
        this.isIgnoreKillProcess = z;
    }

    public void setIsNeedAddress(boolean z) {
        this.addrType = z ? "all" : "noaddr";
    }

    public void setIsNeedAltitude(boolean z) {
        this.isNeedAltitude = z;
    }

    public void setIsNeedLocationDescribe(boolean z) {
        this.isNeedAptag = z;
    }

    public void setIsNeedLocationPoiList(boolean z) {
        this.isNeedAptagd = z;
    }

    public void setLocationMode(LocationMode locationMode) {
        int i = AnonymousClass1.f6483a[locationMode.ordinal()];
        if (i == 1) {
            this.openGps = true;
            this.priority = 1;
        } else if (i == 2) {
            this.openGps = false;
            this.priority = 2;
        } else if (i != 3) {
            throw new IllegalArgumentException("Illegal this mode : " + locationMode);
        } else {
            this.priority = 3;
            this.openGps = true;
        }
        this.f6482a = locationMode;
    }

    public void setLocationNotify(boolean z) {
        this.location_change_notify = z;
    }

    public void setNeedDeviceDirect(boolean z) {
        this.mIsNeedDeviceDirect = z;
    }

    public void setNeedNewVersionRgc(boolean z) {
        this.isNeedNewVersionRgc = z;
    }

    public void setOpenAutoNotifyMode() {
        setOpenAutoNotifyMode(0, 0, 1);
    }

    public void setOpenAutoNotifyMode(int i, int i2, int i3) {
        float f2;
        int i4 = TiebaStatic.MAX_COST_VALUE;
        if (i > 180000) {
            i4 = i + 1000;
        }
        if (i4 < 10000) {
            throw new IllegalArgumentException("Illegal this maxLocInterval : " + i4 + " , maxLocInterval must >= 10000");
        }
        if (i3 == 1) {
            f2 = 0.5f;
        } else if (i3 == 2) {
            f2 = 0.3f;
        } else if (i3 != 3) {
            throw new IllegalArgumentException("Illegal this locSensitivity : " + i3);
        } else {
            f2 = 0.1f;
        }
        this.autoNotifyLocSensitivity = f2;
        this.autoNotifyMaxInterval = i4;
        this.autoNotifyMinTimeInterval = i;
        this.autoNotifyMinDistance = i2;
    }

    public void setOpenGps(boolean z) {
        this.openGps = z;
    }

    @Deprecated
    public void setPriority(int i) {
        if (i == 1 || i == 2) {
            this.priority = i;
        }
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.prodName = str;
    }

    public void setScanSpan(int i) {
        this.scanSpan = i;
    }

    @Deprecated
    public void setSema(boolean z, boolean z2, boolean z3) {
        this.isNeedAptag = z;
        this.isNeedPoiRegion = z2;
        this.isNeedRegular = z3;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setTimeOut(int i) {
        this.timeOut = i;
    }

    public void setWifiCacheTimeOut(int i) {
        if (i >= 10000) {
            this.wifiCacheTimeOut = i;
        }
    }
}
