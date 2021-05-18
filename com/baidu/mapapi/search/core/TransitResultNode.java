package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f7287a;

    /* renamed from: b  reason: collision with root package name */
    public String f7288b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7289c;

    /* renamed from: d  reason: collision with root package name */
    public String f7290d;

    public TransitResultNode(int i2, String str, LatLng latLng, String str2) {
        this.f7288b = null;
        this.f7289c = null;
        this.f7290d = null;
        this.f7287a = i2;
        this.f7288b = str;
        this.f7289c = latLng;
        this.f7290d = str2;
    }

    public TransitResultNode(Parcel parcel) {
        this.f7288b = null;
        this.f7289c = null;
        this.f7290d = null;
        this.f7287a = parcel.readInt();
        this.f7288b = parcel.readString();
        this.f7289c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7290d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7287a;
    }

    public String getCityName() {
        return this.f7288b;
    }

    public LatLng getLocation() {
        return this.f7289c;
    }

    public String getSearchWord() {
        return this.f7290d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7287a);
        parcel.writeString(this.f7288b);
        parcel.writeValue(this.f7289c);
        parcel.writeString(this.f7290d);
    }
}
