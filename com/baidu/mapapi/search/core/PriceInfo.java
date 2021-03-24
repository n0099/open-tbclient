package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public int f7148a;

    /* renamed from: b  reason: collision with root package name */
    public double f7149b;

    public PriceInfo() {
    }

    public PriceInfo(Parcel parcel) {
        this.f7148a = parcel.readInt();
        this.f7149b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f7149b;
    }

    public int getTicketType() {
        return this.f7148a;
    }

    public void setTicketPrice(double d2) {
        this.f7149b = d2;
    }

    public void setTicketType(int i) {
        this.f7148a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7148a);
        parcel.writeDouble(this.f7149b);
    }
}
