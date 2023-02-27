package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new j();
    public int a;
    public double b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PriceInfo() {
    }

    public double getTicketPrice() {
        return this.b;
    }

    public int getTicketType() {
        return this.a;
    }

    public PriceInfo(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readDouble();
    }

    public void setTicketPrice(double d) {
        this.b = d;
    }

    public void setTicketType(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeDouble(this.b);
    }
}
