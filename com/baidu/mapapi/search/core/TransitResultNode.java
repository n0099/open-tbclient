package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f7179a;

    /* renamed from: b  reason: collision with root package name */
    public String f7180b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7181c;

    /* renamed from: d  reason: collision with root package name */
    public String f7182d;

    public TransitResultNode(int i, String str, LatLng latLng, String str2) {
        this.f7180b = null;
        this.f7181c = null;
        this.f7182d = null;
        this.f7179a = i;
        this.f7180b = str;
        this.f7181c = latLng;
        this.f7182d = str2;
    }

    public TransitResultNode(Parcel parcel) {
        this.f7180b = null;
        this.f7181c = null;
        this.f7182d = null;
        this.f7179a = parcel.readInt();
        this.f7180b = parcel.readString();
        this.f7181c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7182d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7179a;
    }

    public String getCityName() {
        return this.f7180b;
    }

    public LatLng getLocation() {
        return this.f7181c;
    }

    public String getSearchWord() {
        return this.f7182d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7179a);
        parcel.writeString(this.f7180b);
        parcel.writeValue(this.f7181c);
        parcel.writeString(this.f7182d);
    }
}
