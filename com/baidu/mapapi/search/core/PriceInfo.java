package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public int f7200a;

    /* renamed from: b  reason: collision with root package name */
    public double f7201b;

    public PriceInfo() {
    }

    public PriceInfo(Parcel parcel) {
        this.f7200a = parcel.readInt();
        this.f7201b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f7201b;
    }

    public int getTicketType() {
        return this.f7200a;
    }

    public void setTicketPrice(double d2) {
        this.f7201b = d2;
    }

    public void setTicketType(int i2) {
        this.f7200a = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7200a);
        parcel.writeDouble(this.f7201b);
    }
}
