package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private int f2844a;

    /* renamed from: b  reason: collision with root package name */
    private double f2845b;

    public PriceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PriceInfo(Parcel parcel) {
        this.f2844a = parcel.readInt();
        this.f2845b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f2845b;
    }

    public int getTicketType() {
        return this.f2844a;
    }

    public void setTicketPrice(double d) {
        this.f2845b = d;
    }

    public void setTicketType(int i) {
        this.f2844a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2844a);
        parcel.writeDouble(this.f2845b);
    }
}
