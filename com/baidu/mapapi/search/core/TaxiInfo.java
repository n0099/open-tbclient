package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class TaxiInfo implements Parcelable {
    public static final Parcelable.Creator<TaxiInfo> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private float f2852a;

    /* renamed from: b  reason: collision with root package name */
    private String f2853b;
    private int c;
    private int d;
    private float e;
    private float f;

    public TaxiInfo() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaxiInfo(Parcel parcel) {
        this.f2852a = parcel.readFloat();
        this.f2853b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readFloat();
        this.f = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.f2853b;
    }

    public int getDistance() {
        return this.c;
    }

    public int getDuration() {
        return this.d;
    }

    public float getPerKMPrice() {
        return this.e;
    }

    public float getStartPrice() {
        return this.f;
    }

    public float getTotalPrice() {
        return this.f2852a;
    }

    public void setDesc(String str) {
        this.f2853b = str;
    }

    public void setDistance(int i) {
        this.c = i;
    }

    public void setDuration(int i) {
        this.d = i;
    }

    public void setPerKMPrice(float f) {
        this.e = f;
    }

    public void setStartPrice(float f) {
        this.f = f;
    }

    public void setTotalPrice(float f) {
        this.f2852a = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f2852a);
        parcel.writeString(this.f2853b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
    }
}
