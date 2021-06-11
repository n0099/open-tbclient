package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7241a;

    /* renamed from: b  reason: collision with root package name */
    public String f7242b;

    /* renamed from: c  reason: collision with root package name */
    public int f7243c;

    /* renamed from: d  reason: collision with root package name */
    public int f7244d;

    /* renamed from: e  reason: collision with root package name */
    public String f7245e;

    public GeoCodeResult() {
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7241a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7242b = parcel.readString();
        this.f7243c = parcel.readInt();
        this.f7244d = parcel.readInt();
        this.f7245e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7242b;
    }

    public int getConfidence() {
        return this.f7244d;
    }

    public String getLevel() {
        return this.f7245e;
    }

    public LatLng getLocation() {
        return this.f7241a;
    }

    public int getPrecise() {
        return this.f7243c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7242b = str;
    }

    public void setConfidence(int i2) {
        this.f7244d = i2;
    }

    public void setLevel(String str) {
        this.f7245e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7241a = latLng;
    }

    public void setPrecise(int i2) {
        this.f7243c = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f7241a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7243c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7244d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7245e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f7241a);
        parcel.writeString(this.f7242b);
        parcel.writeInt(this.f7243c);
        parcel.writeInt(this.f7244d);
        parcel.writeString(this.f7245e);
    }
}
