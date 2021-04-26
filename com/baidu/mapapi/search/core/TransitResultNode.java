package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f7470a;

    /* renamed from: b  reason: collision with root package name */
    public String f7471b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7472c;

    /* renamed from: d  reason: collision with root package name */
    public String f7473d;

    public TransitResultNode(int i2, String str, LatLng latLng, String str2) {
        this.f7471b = null;
        this.f7472c = null;
        this.f7473d = null;
        this.f7470a = i2;
        this.f7471b = str;
        this.f7472c = latLng;
        this.f7473d = str2;
    }

    public TransitResultNode(Parcel parcel) {
        this.f7471b = null;
        this.f7472c = null;
        this.f7473d = null;
        this.f7470a = parcel.readInt();
        this.f7471b = parcel.readString();
        this.f7472c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7473d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7470a;
    }

    public String getCityName() {
        return this.f7471b;
    }

    public LatLng getLocation() {
        return this.f7472c;
    }

    public String getSearchWord() {
        return this.f7473d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7470a);
        parcel.writeString(this.f7471b);
        parcel.writeValue(this.f7472c);
        parcel.writeString(this.f7473d);
    }
}
