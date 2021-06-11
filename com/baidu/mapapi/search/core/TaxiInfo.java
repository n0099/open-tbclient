package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public float f7217a;

    /* renamed from: b  reason: collision with root package name */
    public String f7218b;

    /* renamed from: c  reason: collision with root package name */
    public int f7219c;

    /* renamed from: d  reason: collision with root package name */
    public int f7220d;

    /* renamed from: e  reason: collision with root package name */
    public float f7221e;

    /* renamed from: f  reason: collision with root package name */
    public float f7222f;

    public TaxiInfo() {
    }

    public TaxiInfo(Parcel parcel) {
        this.f7217a = parcel.readFloat();
        this.f7218b = parcel.readString();
        this.f7219c = parcel.readInt();
        this.f7220d = parcel.readInt();
        this.f7221e = parcel.readFloat();
        this.f7222f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7218b;
    }

    public int getDistance() {
        return this.f7219c;
    }

    public int getDuration() {
        return this.f7220d;
    }

    public float getPerKMPrice() {
        return this.f7221e;
    }

    public float getStartPrice() {
        return this.f7222f;
    }

    public float getTotalPrice() {
        return this.f7217a;
    }

    public void setDesc(String str) {
        this.f7218b = str;
    }

    public void setDistance(int i2) {
        this.f7219c = i2;
    }

    public void setDuration(int i2) {
        this.f7220d = i2;
    }

    public void setPerKMPrice(float f2) {
        this.f7221e = f2;
    }

    public void setStartPrice(float f2) {
        this.f7222f = f2;
    }

    public void setTotalPrice(float f2) {
        this.f7217a = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f7217a);
        parcel.writeString(this.f7218b);
        parcel.writeInt(this.f7219c);
        parcel.writeInt(this.f7220d);
        parcel.writeFloat(this.f7221e);
        parcel.writeFloat(this.f7222f);
    }
}
