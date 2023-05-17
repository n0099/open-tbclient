package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class WeatherSearchAlerts implements Parcelable {
    public static final Parcelable.Creator<WeatherSearchAlerts> CREATOR = new c();
    public String a;
    public String b;
    public String c;
    public String d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherSearchAlerts() {
    }

    public String getDesc() {
        return this.d;
    }

    public String getLevel() {
        return this.b;
    }

    public String getTitle() {
        return this.c;
    }

    public String getType() {
        return this.a;
    }

    public WeatherSearchAlerts(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    public void setDesc(String str) {
        this.d = str;
    }

    public void setLevel(String str) {
        this.b = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setType(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
