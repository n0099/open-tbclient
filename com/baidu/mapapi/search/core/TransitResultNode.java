package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f7187a;

    /* renamed from: b  reason: collision with root package name */
    public String f7188b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7189c;

    /* renamed from: d  reason: collision with root package name */
    public String f7190d;

    public TransitResultNode(int i2, String str, LatLng latLng, String str2) {
        this.f7188b = null;
        this.f7189c = null;
        this.f7190d = null;
        this.f7187a = i2;
        this.f7188b = str;
        this.f7189c = latLng;
        this.f7190d = str2;
    }

    public TransitResultNode(Parcel parcel) {
        this.f7188b = null;
        this.f7189c = null;
        this.f7190d = null;
        this.f7187a = parcel.readInt();
        this.f7188b = parcel.readString();
        this.f7189c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7190d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7187a;
    }

    public String getCityName() {
        return this.f7188b;
    }

    public LatLng getLocation() {
        return this.f7189c;
    }

    public String getSearchWord() {
        return this.f7190d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7187a);
        parcel.writeString(this.f7188b);
        parcel.writeValue(this.f7189c);
        parcel.writeString(this.f7190d);
    }
}
