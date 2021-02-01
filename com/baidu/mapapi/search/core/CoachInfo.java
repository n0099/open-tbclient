package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private double f2837a;

    /* renamed from: b  reason: collision with root package name */
    private String f2838b;
    private String c;
    private String d;

    public CoachInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f2837a = parcel.readDouble();
        this.f2838b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f2838b;
    }

    public double getPrice() {
        return this.f2837a;
    }

    public String getProviderName() {
        return this.c;
    }

    public String getProviderUrl() {
        return this.d;
    }

    public void setBooking(String str) {
        this.f2838b = str;
    }

    public void setPrice(double d) {
        this.f2837a = d;
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
        parcel.writeDouble(this.f2837a);
        parcel.writeString(this.f2838b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
