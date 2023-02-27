package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class WeatherLifeIndexes implements Parcelable {
    public static final Parcelable.Creator<WeatherLifeIndexes> CREATOR = new a();
    public String a;
    public String b;
    public String c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherLifeIndexes() {
    }

    public String getBrief() {
        return this.b;
    }

    public String getDetail() {
        return this.c;
    }

    public String getName() {
        return this.a;
    }

    public WeatherLifeIndexes(Parcel parcel) {
        setName(parcel.readString());
        setBrief(parcel.readString());
        setDetail(parcel.readString());
    }

    public void setBrief(String str) {
        this.b = str;
    }

    public void setDetail(String str) {
        this.c = str;
    }

    public void setName(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeString(getBrief());
        parcel.writeString(getDetail());
    }
}
