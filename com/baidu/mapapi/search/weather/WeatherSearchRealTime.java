package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class WeatherSearchRealTime implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchRealTime> CREATOR = new g();
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public float q;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherSearchRealTime() {
    }

    public int getAirQualityIndex() {
        return this.o;
    }

    public float getCO() {
        return this.q;
    }

    public int getClouds() {
        return this.h;
    }

    public float getHourlyPrecipitation() {
        return this.i;
    }

    public int getNO2() {
        return this.m;
    }

    public int getO3() {
        return this.k;
    }

    public int getPM10() {
        return this.p;
    }

    public int getPM2_5() {
        return this.l;
    }

    public String getPhenomenon() {
        return this.c;
    }

    public int getRelativeHumidity() {
        return this.a;
    }

    public int getSO2() {
        return this.n;
    }

    public int getSensoryTemp() {
        return this.b;
    }

    public int getTemperature() {
        return this.f;
    }

    public String getUpdateTime() {
        return this.e;
    }

    public int getVisibility() {
        return this.j;
    }

    public String getWindDirection() {
        return this.d;
    }

    public String getWindPower() {
        return this.g;
    }

    public WeatherSearchRealTime(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readString();
    }

    public void setAirQualityIndex(int i) {
        this.o = i;
    }

    public void setCO(float f) {
        this.q = f;
    }

    public void setClouds(int i) {
        this.h = i;
    }

    public void setHourlyPrecipitation(float f) {
        this.i = f;
    }

    public void setNO2(int i) {
        this.m = i;
    }

    public void setO3(int i) {
        this.k = i;
    }

    public void setPM10(int i) {
        this.p = i;
    }

    public void setPM2_5(int i) {
        this.l = i;
    }

    public void setPhenomenon(String str) {
        this.c = str;
    }

    public void setRelativeHumidity(int i) {
        this.a = i;
    }

    public void setSO2(int i) {
        this.n = i;
    }

    public void setSensoryTemp(int i) {
        this.b = i;
    }

    public void setTemperature(int i) {
        this.f = i;
    }

    public void setUpdateTime(String str) {
        this.e = str;
    }

    public void setVisibility(int i) {
        this.j = i;
    }

    public void setWindDirection(String str) {
        this.d = str;
    }

    public void setWindPower(String str) {
        this.g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
    }
}
