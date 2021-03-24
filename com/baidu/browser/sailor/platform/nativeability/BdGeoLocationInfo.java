package com.baidu.browser.sailor.platform.nativeability;

import android.text.TextUtils;
import android.text.format.DateFormat;
import com.baidu.browser.core.INoProGuard;
/* loaded from: classes2.dex */
public class BdGeoLocationInfo implements INoProGuard {
    public static final String COOR_TYPE_GCJ = "gcj02";
    public double mLongitude = 0.0d;
    public double mLatitude = 0.0d;
    public double mRadius = 100.0d;
    public long mTime = 0;
    public String mProvince = "";
    public String mCity = "";
    public String mDistrict = "";
    public String mStreet = "";
    public String mStreetNumber = "";
    public String mCityCode = "";

    public String getCity() {
        return this.mCity;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public String getCoorType() {
        return "gcj02";
    }

    public String getDistrict() {
        return this.mDistrict;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getProvince() {
        return this.mProvince;
    }

    public double getRadius() {
        return this.mRadius;
    }

    public String getStreet() {
        return this.mStreet;
    }

    public String getStreetNumber() {
        return this.mStreetNumber;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setCity(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mCity = str;
    }

    public void setCityCode(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mCityCode = str;
    }

    public void setDistrict(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mDistrict = str;
    }

    public void setLatitude(double d2) {
        this.mLatitude = d2;
    }

    public void setLongitude(double d2) {
        this.mLongitude = d2;
    }

    public void setProvince(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mProvince = str;
    }

    public void setRadius(double d2) {
        this.mRadius = d2;
    }

    public void setStreet(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mStreet = str;
    }

    public void setStreetNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mStreetNumber = str;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public String toString() {
        return "longitude[" + this.mLongitude + "] latitude[" + this.mLatitude + "] radius[" + this.mRadius + "] province[" + this.mProvince + "] city[" + this.mCity + "] district[" + this.mDistrict + "] street[" + this.mStreet + "] streetNumber[" + this.mStreetNumber + "] cityCode[" + this.mCityCode + "] mTime[" + ((Object) DateFormat.format("yyyy-MM-dd kk:mm:ss", this.mTime)) + "]";
    }
}
