package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public float f7201a;

    /* renamed from: b  reason: collision with root package name */
    public String f7202b;

    /* renamed from: c  reason: collision with root package name */
    public int f7203c;

    /* renamed from: d  reason: collision with root package name */
    public int f7204d;

    /* renamed from: e  reason: collision with root package name */
    public float f7205e;

    /* renamed from: f  reason: collision with root package name */
    public float f7206f;

    public TaxiInfo() {
    }

    public TaxiInfo(Parcel parcel) {
        this.f7201a = parcel.readFloat();
        this.f7202b = parcel.readString();
        this.f7203c = parcel.readInt();
        this.f7204d = parcel.readInt();
        this.f7205e = parcel.readFloat();
        this.f7206f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f7202b;
    }

    public int getDistance() {
        return this.f7203c;
    }

    public int getDuration() {
        return this.f7204d;
    }

    public float getPerKMPrice() {
        return this.f7205e;
    }

    public float getStartPrice() {
        return this.f7206f;
    }

    public float getTotalPrice() {
        return this.f7201a;
    }

    public void setDesc(String str) {
        this.f7202b = str;
    }

    public void setDistance(int i) {
        this.f7203c = i;
    }

    public void setDuration(int i) {
        this.f7204d = i;
    }

    public void setPerKMPrice(float f2) {
        this.f7205e = f2;
    }

    public void setStartPrice(float f2) {
        this.f7206f = f2;
    }

    public void setTotalPrice(float f2) {
        this.f7201a = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f7201a);
        parcel.writeString(this.f7202b);
        parcel.writeInt(this.f7203c);
        parcel.writeInt(this.f7204d);
        parcel.writeFloat(this.f7205e);
        parcel.writeFloat(this.f7206f);
    }
}
