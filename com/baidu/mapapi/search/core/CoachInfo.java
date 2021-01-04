package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes15.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private double f2956a;

    /* renamed from: b  reason: collision with root package name */
    private String f2957b;
    private String c;
    private String d;

    public CoachInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f2956a = parcel.readDouble();
        this.f2957b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f2957b;
    }

    public double getPrice() {
        return this.f2956a;
    }

    public String getProviderName() {
        return this.c;
    }

    public String getProviderUrl() {
        return this.d;
    }

    public void setBooking(String str) {
        this.f2957b = str;
    }

    public void setPrice(double d) {
        this.f2956a = d;
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
        parcel.writeDouble(this.f2956a);
        parcel.writeString(this.f2957b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
