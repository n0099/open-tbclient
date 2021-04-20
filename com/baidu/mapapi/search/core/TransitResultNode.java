package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    public int f7214a;

    /* renamed from: b  reason: collision with root package name */
    public String f7215b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7216c;

    /* renamed from: d  reason: collision with root package name */
    public String f7217d;

    public TransitResultNode(int i, String str, LatLng latLng, String str2) {
        this.f7215b = null;
        this.f7216c = null;
        this.f7217d = null;
        this.f7214a = i;
        this.f7215b = str;
        this.f7216c = latLng;
        this.f7217d = str2;
    }

    public TransitResultNode(Parcel parcel) {
        this.f7215b = null;
        this.f7216c = null;
        this.f7217d = null;
        this.f7214a = parcel.readInt();
        this.f7215b = parcel.readString();
        this.f7216c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7217d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f7214a;
    }

    public String getCityName() {
        return this.f7215b;
    }

    public LatLng getLocation() {
        return this.f7216c;
    }

    public String getSearchWord() {
        return this.f7217d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7214a);
        parcel.writeString(this.f7215b);
        parcel.writeValue(this.f7216c);
        parcel.writeString(this.f7217d);
    }
}
