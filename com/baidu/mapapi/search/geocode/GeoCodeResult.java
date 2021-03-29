package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7190a;

    /* renamed from: b  reason: collision with root package name */
    public String f7191b;

    /* renamed from: c  reason: collision with root package name */
    public int f7192c;

    /* renamed from: d  reason: collision with root package name */
    public int f7193d;

    /* renamed from: e  reason: collision with root package name */
    public String f7194e;

    public GeoCodeResult() {
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7190a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7191b = parcel.readString();
        this.f7192c = parcel.readInt();
        this.f7193d = parcel.readInt();
        this.f7194e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7191b;
    }

    public int getConfidence() {
        return this.f7193d;
    }

    public String getLevel() {
        return this.f7194e;
    }

    public LatLng getLocation() {
        return this.f7190a;
    }

    public int getPrecise() {
        return this.f7192c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7191b = str;
    }

    public void setConfidence(int i) {
        this.f7193d = i;
    }

    public void setLevel(String str) {
        this.f7194e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7190a = latLng;
    }

    public void setPrecise(int i) {
        this.f7192c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f7190a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7192c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7193d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7194e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f7190a);
        parcel.writeString(this.f7191b);
        parcel.writeInt(this.f7192c);
        parcel.writeInt(this.f7193d);
        parcel.writeString(this.f7194e);
    }
}
