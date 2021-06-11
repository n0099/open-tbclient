package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f7230a;

    /* renamed from: b  reason: collision with root package name */
    public String f7231b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7232c;

    /* renamed from: d  reason: collision with root package name */
    public String f7233d;

    public TransitResultNode(int i2, String str, LatLng latLng, String str2) {
        this.f7231b = null;
        this.f7232c = null;
        this.f7233d = null;
        this.f7230a = i2;
        this.f7231b = str;
        this.f7232c = latLng;
        this.f7233d = str2;
    }

    public TransitResultNode(Parcel parcel) {
        this.f7231b = null;
        this.f7232c = null;
        this.f7233d = null;
        this.f7230a = parcel.readInt();
        this.f7231b = parcel.readString();
        this.f7232c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7233d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7230a;
    }

    public String getCityName() {
        return this.f7231b;
    }

    public LatLng getLocation() {
        return this.f7232c;
    }

    public String getSearchWord() {
        return this.f7233d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7230a);
        parcel.writeString(this.f7231b);
        parcel.writeValue(this.f7232c);
        parcel.writeString(this.f7233d);
    }
}
