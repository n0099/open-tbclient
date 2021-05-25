package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public int f7157a;

    /* renamed from: b  reason: collision with root package name */
    public double f7158b;

    public PriceInfo() {
    }

    public PriceInfo(Parcel parcel) {
        this.f7157a = parcel.readInt();
        this.f7158b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f7158b;
    }

    public int getTicketType() {
        return this.f7157a;
    }

    public void setTicketPrice(double d2) {
        this.f7158b = d2;
    }

    public void setTicketType(int i2) {
        this.f7157a = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7157a);
        parcel.writeDouble(this.f7158b);
    }
}
