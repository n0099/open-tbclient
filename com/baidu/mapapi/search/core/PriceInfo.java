package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();
    private int a;
    private double b;

    public PriceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PriceInfo(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.b;
    }

    public int getTicketType() {
        return this.a;
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
