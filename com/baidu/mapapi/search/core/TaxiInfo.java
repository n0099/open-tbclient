package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public float f7457a;

    /* renamed from: b  reason: collision with root package name */
    public String f7458b;

    /* renamed from: c  reason: collision with root package name */
    public int f7459c;

    /* renamed from: d  reason: collision with root package name */
    public int f7460d;

    /* renamed from: e  reason: collision with root package name */
    public float f7461e;

    /* renamed from: f  reason: collision with root package name */
    public float f7462f;

    public TaxiInfo() {
    }

    public TaxiInfo(Parcel parcel) {
        this.f7457a = parcel.readFloat();
        this.f7458b = parcel.readString();
        this.f7459c = parcel.readInt();
        this.f7460d = parcel.readInt();
        this.f7461e = parcel.readFloat();
        this.f7462f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7458b;
    }

    public int getDistance() {
        return this.f7459c;
    }

    public int getDuration() {
        return this.f7460d;
    }

    public float getPerKMPrice() {
        return this.f7461e;
    }

    public float getStartPrice() {
        return this.f7462f;
    }

    public float getTotalPrice() {
        return this.f7457a;
    }

    public void setDesc(String str) {
        this.f7458b = str;
    }

    public void setDistance(int i2) {
        this.f7459c = i2;
    }

    public void setDuration(int i2) {
        this.f7460d = i2;
    }

    public void setPerKMPrice(float f2) {
        this.f7461e = f2;
    }

    public void setStartPrice(float f2) {
        this.f7462f = f2;
    }

    public void setTotalPrice(float f2) {
        this.f7457a = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f7457a);
        parcel.writeString(this.f7458b);
        parcel.writeInt(this.f7459c);
        parcel.writeInt(this.f7460d);
        parcel.writeFloat(this.f7461e);
        parcel.writeFloat(this.f7462f);
    }
}
