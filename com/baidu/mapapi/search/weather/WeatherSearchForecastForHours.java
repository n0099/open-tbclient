package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class WeatherSearchForecastForHours implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchForecastForHours> CREATOR = new d();
    public int a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public int h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherSearchForecastForHours() {
    }

    public int getClouds() {
        return this.f;
    }

    public String getDataTime() {
        return this.b;
    }

    public int getHourlyPrecipitation() {
        return this.h;
    }

    public String getPhenomenon() {
        return this.g;
    }

    public int getRelativeHumidity() {
        return this.a;
    }

    public int getTemperature() {
        return this.e;
    }

    public String getWindDirection() {
        return this.c;
    }

    public String getWindPower() {
        return this.d;
    }

    public WeatherSearchForecastForHours(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
    }

    public void setClouds(int i) {
        this.f = i;
    }

    public void setDataTime(String str) {
        this.b = str;
    }

    public void setHourlyPrecipitation(int i) {
        this.h = i;
    }

    public void setPhenomenon(String str) {
        this.g = str;
    }

    public void setRelativeHumidity(int i) {
        this.a = i;
    }

    public void setTemperature(int i) {
        this.e = i;
    }

    public void setWindDirection(String str) {
        this.c = str;
    }

    public void setWindPower(String str) {
        this.d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
    }
}
