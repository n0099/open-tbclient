package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public float f7165a;

    /* renamed from: b  reason: collision with root package name */
    public String f7166b;

    /* renamed from: c  reason: collision with root package name */
    public int f7167c;

    /* renamed from: d  reason: collision with root package name */
    public int f7168d;

    /* renamed from: e  reason: collision with root package name */
    public float f7169e;

    /* renamed from: f  reason: collision with root package name */
    public float f7170f;

    public TaxiInfo() {
    }

    public TaxiInfo(Parcel parcel) {
        this.f7165a = parcel.readFloat();
        this.f7166b = parcel.readString();
        this.f7167c = parcel.readInt();
        this.f7168d = parcel.readInt();
        this.f7169e = parcel.readFloat();
        this.f7170f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7166b;
    }

    public int getDistance() {
        return this.f7167c;
    }

    public int getDuration() {
        return this.f7168d;
    }

    public float getPerKMPrice() {
        return this.f7169e;
    }

    public float getStartPrice() {
        return this.f7170f;
    }

    public float getTotalPrice() {
        return this.f7165a;
    }

    public void setDesc(String str) {
        this.f7166b = str;
    }

    public void setDistance(int i) {
        this.f7167c = i;
    }

    public void setDuration(int i) {
        this.f7168d = i;
    }

    public void setPerKMPrice(float f2) {
        this.f7169e = f2;
    }

    public void setStartPrice(float f2) {
        this.f7170f = f2;
    }

    public void setTotalPrice(float f2) {
        this.f7165a = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f7165a);
        parcel.writeString(this.f7166b);
        parcel.writeInt(this.f7167c);
        parcel.writeInt(this.f7168d);
        parcel.writeFloat(this.f7169e);
        parcel.writeFloat(this.f7170f);
    }
}
