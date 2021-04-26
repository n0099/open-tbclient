package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7481a;

    /* renamed from: b  reason: collision with root package name */
    public String f7482b;

    /* renamed from: c  reason: collision with root package name */
    public int f7483c;

    /* renamed from: d  reason: collision with root package name */
    public int f7484d;

    /* renamed from: e  reason: collision with root package name */
    public String f7485e;

    public GeoCodeResult() {
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7481a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7482b = parcel.readString();
        this.f7483c = parcel.readInt();
        this.f7484d = parcel.readInt();
        this.f7485e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7482b;
    }

    public int getConfidence() {
        return this.f7484d;
    }

    public String getLevel() {
        return this.f7485e;
    }

    public LatLng getLocation() {
        return this.f7481a;
    }

    public int getPrecise() {
        return this.f7483c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7482b = str;
    }

    public void setConfidence(int i2) {
        this.f7484d = i2;
    }

    public void setLevel(String str) {
        this.f7485e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7481a = latLng;
    }

    public void setPrecise(int i2) {
        this.f7483c = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f7481a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7483c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7484d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7485e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f7481a);
        parcel.writeString(this.f7482b);
        parcel.writeInt(this.f7483c);
        parcel.writeInt(this.f7484d);
        parcel.writeString(this.f7485e);
    }
}
