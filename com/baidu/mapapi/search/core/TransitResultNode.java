package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f7178a;

    /* renamed from: b  reason: collision with root package name */
    public String f7179b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7180c;

    /* renamed from: d  reason: collision with root package name */
    public String f7181d;

    public TransitResultNode(int i, String str, LatLng latLng, String str2) {
        this.f7179b = null;
        this.f7180c = null;
        this.f7181d = null;
        this.f7178a = i;
        this.f7179b = str;
        this.f7180c = latLng;
        this.f7181d = str2;
    }

    public TransitResultNode(Parcel parcel) {
        this.f7179b = null;
        this.f7180c = null;
        this.f7181d = null;
        this.f7178a = parcel.readInt();
        this.f7179b = parcel.readString();
        this.f7180c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7181d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7178a;
    }

    public String getCityName() {
        return this.f7179b;
    }

    public LatLng getLocation() {
        return this.f7180c;
    }

    public String getSearchWord() {
        return this.f7181d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7178a);
        parcel.writeString(this.f7179b);
        parcel.writeValue(this.f7180c);
        parcel.writeString(this.f7181d);
    }
}
