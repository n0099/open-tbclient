package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public int f7149a;

    /* renamed from: b  reason: collision with root package name */
    public double f7150b;

    public PriceInfo() {
    }

    public PriceInfo(Parcel parcel) {
        this.f7149a = parcel.readInt();
        this.f7150b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f7150b;
    }

    public int getTicketType() {
        return this.f7149a;
    }

    public void setTicketPrice(double d2) {
        this.f7150b = d2;
    }

    public void setTicketType(int i) {
        this.f7149a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7149a);
        parcel.writeDouble(this.f7150b);
    }
}
