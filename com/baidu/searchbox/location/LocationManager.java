package com.baidu.searchbox.location;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class LocationManager {

    /* loaded from: classes.dex */
    public interface LocationListener {
        public static final int OTHER_ERROR = 4;
        public static final int REQUEST_FREQUENT = 2;
        public static final int SDK_NOT_INIT = 3;
        public static final int SERVER_ERROR = 1;

        void onError(int i);

        void onReceiveLocation(LocationInfo locationInfo);
    }

    /* loaded from: classes.dex */
    public interface LocationScanCloseListener {
        void onClose(boolean z);
    }

    /* loaded from: classes.dex */
    public static class LocationInfo {
        public String addressStr;
        public String city;
        public String cityCode;
        public String coorType;
        public String country;
        public String countryCode;
        public String district;
        public double latitude;
        public double longitude;
        public String province;
        public double radius;
        public String street;
        public String streetNo;
        public long time;

        public String getStreetStr() {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.street)) {
                sb.append(this.street);
                if (!TextUtils.isEmpty(this.streetNo)) {
                    sb.append(this.streetNo);
                }
            } else {
                sb.append(this.addressStr);
            }
            return sb.toString();
        }

        public String toString() {
            return "LocationInfo [time=" + this.time + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", radius=" + this.radius + ", addressStr=" + this.addressStr + ", province=" + this.province + ", city=" + this.city + ", street=" + this.street + ", streetNo=" + this.streetNo + ", district=" + this.district + ", cityCode=" + this.cityCode + ", coorType=" + this.coorType + ", country=" + this.country + ", countryCode=" + this.countryCode + "]";
        }
    }
}
