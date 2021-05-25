package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7198a;

    /* renamed from: b  reason: collision with root package name */
    public String f7199b;

    /* renamed from: c  reason: collision with root package name */
    public int f7200c;

    /* renamed from: d  reason: collision with root package name */
    public int f7201d;

    /* renamed from: e  reason: collision with root package name */
    public String f7202e;

    public GeoCodeResult() {
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7198a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7199b = parcel.readString();
        this.f7200c = parcel.readInt();
        this.f7201d = parcel.readInt();
        this.f7202e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7199b;
    }

    public int getConfidence() {
        return this.f7201d;
    }

    public String getLevel() {
        return this.f7202e;
    }

    public LatLng getLocation() {
        return this.f7198a;
    }

    public int getPrecise() {
        return this.f7200c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7199b = str;
    }

    public void setConfidence(int i2) {
        this.f7201d = i2;
    }

    public void setLevel(String str) {
        this.f7202e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7198a = latLng;
    }

    public void setPrecise(int i2) {
        this.f7200c = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f7198a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7200c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7201d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7202e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f7198a);
        parcel.writeString(this.f7199b);
        parcel.writeInt(this.f7200c);
        parcel.writeInt(this.f7201d);
        parcel.writeString(this.f7202e);
    }
}
