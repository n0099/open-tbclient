package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RecommendStopInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendStopInfo> CREATOR = new k();
    public String a;
    public LatLng b;
    public float c;
    public String d;
    public String e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RecommendStopInfo() {
    }

    public String getAddress() {
        return this.e;
    }

    public float getDistance() {
        return this.c;
    }

    public String getId() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    public RecommendStopInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.c = parcel.readFloat();
        this.e = parcel.readString();
        this.d = parcel.readString();
    }

    public void setAddress(String str) {
        this.e = str;
    }

    public void setDistance(float f) {
        this.c = f;
    }

    public void setId(String str) {
        this.d = str;
    }

    public void setLocation(LatLng latLng) {
        this.b = latLng;
    }

    public void setName(String str) {
        this.a = str;
    }

    public String toString() {
        return "RecommendStopInfo{mName='" + this.a + "', mLocation=" + this.b + ", mDistance=" + this.c + ", mId='" + this.d + "', mAddress='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeFloat(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
    }
}
