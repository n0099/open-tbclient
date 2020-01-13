package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();
    private double a;
    private String b;
    private String c;
    private String d;

    public CoachInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.a = parcel.readDouble();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.b;
    }

    public double getPrice() {
        return this.a;
    }

    public String getProviderName() {
        return this.c;
    }

    public String getProviderUrl() {
        return this.d;
    }

    public void setBooking(String str) {
        this.b = str;
    }

    public void setPrice(double d) {
        this.a = d;
    }

    public void setProviderName(String str) {
        this.c = str;
    }

    public void setProviderUrl(String str) {
        this.d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
