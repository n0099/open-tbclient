package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class PriceInfo implements Parcelable {
    public static final Parcelable.Creator<PriceInfo> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private int f2842a;

    /* renamed from: b  reason: collision with root package name */
    private double f2843b;

    public PriceInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PriceInfo(Parcel parcel) {
        this.f2842a = parcel.readInt();
        this.f2843b = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getTicketPrice() {
        return this.f2843b;
    }

    public int getTicketType() {
        return this.f2842a;
    }

    public void setTicketPrice(double d) {
        this.f2843b = d;
    }

    public void setTicketType(int i) {
        this.f2842a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2842a);
        parcel.writeDouble(this.f2843b);
    }
}
