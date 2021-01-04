package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes15.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private int f2965a;

    /* renamed from: b  reason: collision with root package name */
    private double f2966b;

    public PriceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PriceInfo(Parcel parcel) {
        this.f2965a = parcel.readInt();
        this.f2966b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f2966b;
    }

    public int getTicketType() {
        return this.f2965a;
    }

    public void setTicketPrice(double d) {
        this.f2966b = d;
    }

    public void setTicketType(int i) {
        this.f2965a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2965a);
        parcel.writeDouble(this.f2966b);
    }
}
