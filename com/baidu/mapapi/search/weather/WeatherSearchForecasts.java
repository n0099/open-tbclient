package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class WeatherSearchForecasts implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchForecasts> CREATOR = new e();
    public String a;
    public String b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherSearchForecasts() {
    }

    public int getAirQualityIndex() {
        return this.k;
    }

    public String getDate() {
        return this.a;
    }

    public int getHighestTemp() {
        return this.d;
    }

    public int getLowestTemp() {
        return this.c;
    }

    public String getPhenomenonDay() {
        return this.i;
    }

    public String getPhenomenonNight() {
        return this.j;
    }

    public String getWeek() {
        return this.b;
    }

    public String getWindDirectionDay() {
        return this.g;
    }

    public String getWindDirectionNight() {
        return this.h;
    }

    public String getWindPowerDay() {
        return this.e;
    }

    public String getWindPowerNight() {
        return this.f;
    }

    public WeatherSearchForecasts(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
    }

    public void setAirQualityIndex(int i) {
        this.k = i;
    }

    public void setDate(String str) {
        this.a = str;
    }

    public void setHighestTemp(int i) {
        this.d = i;
    }

    public void setLowestTemp(int i) {
        this.c = i;
    }

    public void setPhenomenonDay(String str) {
        this.i = str;
    }

    public void setPhenomenonNight(String str) {
        this.j = str;
    }

    public void setWeek(String str) {
        this.b = str;
    }

    public void setWindDirectionDay(String str) {
        this.g = str;
    }

    public void setWindDirectionNight(String str) {
        this.h = str;
    }

    public void setWindPowerDay(String str) {
        this.e = str;
    }

    public void setWindPowerNight(String str) {
        this.f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
