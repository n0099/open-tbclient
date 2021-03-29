package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public float f7166a;

    /* renamed from: b  reason: collision with root package name */
    public String f7167b;

    /* renamed from: c  reason: collision with root package name */
    public int f7168c;

    /* renamed from: d  reason: collision with root package name */
    public int f7169d;

    /* renamed from: e  reason: collision with root package name */
    public float f7170e;

    /* renamed from: f  reason: collision with root package name */
    public float f7171f;

    public TaxiInfo() {
    }

    public TaxiInfo(Parcel parcel) {
        this.f7166a = parcel.readFloat();
        this.f7167b = parcel.readString();
        this.f7168c = parcel.readInt();
        this.f7169d = parcel.readInt();
        this.f7170e = parcel.readFloat();
        this.f7171f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7167b;
    }

    public int getDistance() {
        return this.f7168c;
    }

    public int getDuration() {
        return this.f7169d;
    }

    public float getPerKMPrice() {
        return this.f7170e;
    }

    public float getStartPrice() {
        return this.f7171f;
    }

    public float getTotalPrice() {
        return this.f7166a;
    }

    public void setDesc(String str) {
        this.f7167b = str;
    }

    public void setDistance(int i) {
        this.f7168c = i;
    }

    public void setDuration(int i) {
        this.f7169d = i;
    }

    public void setPerKMPrice(float f2) {
        this.f7170e = f2;
    }

    public void setStartPrice(float f2) {
        this.f7171f = f2;
    }

    public void setTotalPrice(float f2) {
        this.f7166a = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f7166a);
        parcel.writeString(this.f7167b);
        parcel.writeInt(this.f7168c);
        parcel.writeInt(this.f7169d);
        parcel.writeFloat(this.f7170e);
        parcel.writeFloat(this.f7171f);
    }
}
