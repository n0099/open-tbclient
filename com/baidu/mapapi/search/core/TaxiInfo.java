package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public float f7174a;

    /* renamed from: b  reason: collision with root package name */
    public String f7175b;

    /* renamed from: c  reason: collision with root package name */
    public int f7176c;

    /* renamed from: d  reason: collision with root package name */
    public int f7177d;

    /* renamed from: e  reason: collision with root package name */
    public float f7178e;

    /* renamed from: f  reason: collision with root package name */
    public float f7179f;

    public TaxiInfo() {
    }

    public TaxiInfo(Parcel parcel) {
        this.f7174a = parcel.readFloat();
        this.f7175b = parcel.readString();
        this.f7176c = parcel.readInt();
        this.f7177d = parcel.readInt();
        this.f7178e = parcel.readFloat();
        this.f7179f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7175b;
    }

    public int getDistance() {
        return this.f7176c;
    }

    public int getDuration() {
        return this.f7177d;
    }

    public float getPerKMPrice() {
        return this.f7178e;
    }

    public float getStartPrice() {
        return this.f7179f;
    }

    public float getTotalPrice() {
        return this.f7174a;
    }

    public void setDesc(String str) {
        this.f7175b = str;
    }

    public void setDistance(int i2) {
        this.f7176c = i2;
    }

    public void setDuration(int i2) {
        this.f7177d = i2;
    }

    public void setPerKMPrice(float f2) {
        this.f7178e = f2;
    }

    public void setStartPrice(float f2) {
        this.f7179f = f2;
    }

    public void setTotalPrice(float f2) {
        this.f7174a = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f7174a);
        parcel.writeString(this.f7175b);
        parcel.writeInt(this.f7176c);
        parcel.writeInt(this.f7177d);
        parcel.writeFloat(this.f7178e);
        parcel.writeFloat(this.f7179f);
    }
}
