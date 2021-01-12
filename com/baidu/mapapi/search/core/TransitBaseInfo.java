package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    private String f2858a;

    /* renamed from: b  reason: collision with root package name */
    private String f2859b;
    private String c;
    private String d;
    private String e;

    public TransitBaseInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransitBaseInfo(Parcel parcel) {
        this.f2858a = parcel.readString();
        this.f2859b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.c;
    }

    public String getArriveTime() {
        return this.e;
    }

    public String getDepartureStation() {
        return this.f2859b;
    }

    public String getDepartureTime() {
        return this.d;
    }

    public String getName() {
        return this.f2858a;
    }

    public void setArriveStation(String str) {
        this.c = str;
    }

    public void setArriveTime(String str) {
        this.e = str;
    }

    public void setDepartureStation(String str) {
        this.f2859b = str;
    }

    public void setDepartureTime(String str) {
        this.d = str;
    }

    public void setName(String str) {
        this.f2858a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2858a);
        parcel.writeString(this.f2859b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
