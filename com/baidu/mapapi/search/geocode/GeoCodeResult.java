package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7298a;

    /* renamed from: b  reason: collision with root package name */
    public String f7299b;

    /* renamed from: c  reason: collision with root package name */
    public int f7300c;

    /* renamed from: d  reason: collision with root package name */
    public int f7301d;

    /* renamed from: e  reason: collision with root package name */
    public String f7302e;

    public GeoCodeResult() {
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7298a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7299b = parcel.readString();
        this.f7300c = parcel.readInt();
        this.f7301d = parcel.readInt();
        this.f7302e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7299b;
    }

    public int getConfidence() {
        return this.f7301d;
    }

    public String getLevel() {
        return this.f7302e;
    }

    public LatLng getLocation() {
        return this.f7298a;
    }

    public int getPrecise() {
        return this.f7300c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7299b = str;
    }

    public void setConfidence(int i2) {
        this.f7301d = i2;
    }

    public void setLevel(String str) {
        this.f7302e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7298a = latLng;
    }

    public void setPrecise(int i2) {
        this.f7300c = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f7298a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7300c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7301d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7302e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f7298a);
        parcel.writeString(this.f7299b);
        parcel.writeInt(this.f7300c);
        parcel.writeInt(this.f7301d);
        parcel.writeString(this.f7302e);
    }
}
