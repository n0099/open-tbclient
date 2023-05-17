package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class WeatherSearchLocation implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchLocation> CREATOR = new f();
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherSearchLocation() {
    }

    public String getCity() {
        return this.c;
    }

    public String getCountry() {
        return this.a;
    }

    public String getDistrictID() {
        return this.e;
    }

    public String getDistrictName() {
        return this.d;
    }

    public String getProvince() {
        return this.b;
    }

    public WeatherSearchLocation(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public void setCity(String str) {
        this.c = str;
    }

    public void setCountry(String str) {
        this.a = str;
    }

    public void setDistrictID(String str) {
        this.e = str;
    }

    public void setDistrictName(String str) {
        this.d = str;
    }

    public void setProvince(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
