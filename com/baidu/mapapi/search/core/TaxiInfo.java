package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public float f7274a;

    /* renamed from: b  reason: collision with root package name */
    public String f7275b;

    /* renamed from: c  reason: collision with root package name */
    public int f7276c;

    /* renamed from: d  reason: collision with root package name */
    public int f7277d;

    /* renamed from: e  reason: collision with root package name */
    public float f7278e;

    /* renamed from: f  reason: collision with root package name */
    public float f7279f;

    public TaxiInfo() {
    }

    public TaxiInfo(Parcel parcel) {
        this.f7274a = parcel.readFloat();
        this.f7275b = parcel.readString();
        this.f7276c = parcel.readInt();
        this.f7277d = parcel.readInt();
        this.f7278e = parcel.readFloat();
        this.f7279f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7275b;
    }

    public int getDistance() {
        return this.f7276c;
    }

    public int getDuration() {
        return this.f7277d;
    }

    public float getPerKMPrice() {
        return this.f7278e;
    }

    public float getStartPrice() {
        return this.f7279f;
    }

    public float getTotalPrice() {
        return this.f7274a;
    }

    public void setDesc(String str) {
        this.f7275b = str;
    }

    public void setDistance(int i2) {
        this.f7276c = i2;
    }

    public void setDuration(int i2) {
        this.f7277d = i2;
    }

    public void setPerKMPrice(float f2) {
        this.f7278e = f2;
    }

    public void setStartPrice(float f2) {
        this.f7279f = f2;
    }

    public void setTotalPrice(float f2) {
        this.f7274a = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f7274a);
        parcel.writeString(this.f7275b);
        parcel.writeInt(this.f7276c);
        parcel.writeInt(this.f7277d);
        parcel.writeFloat(this.f7278e);
        parcel.writeFloat(this.f7279f);
    }
}
