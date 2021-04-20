package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7225a;

    /* renamed from: b  reason: collision with root package name */
    public String f7226b;

    /* renamed from: c  reason: collision with root package name */
    public int f7227c;

    /* renamed from: d  reason: collision with root package name */
    public int f7228d;

    /* renamed from: e  reason: collision with root package name */
    public String f7229e;

    public GeoCodeResult() {
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7225a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7226b = parcel.readString();
        this.f7227c = parcel.readInt();
        this.f7228d = parcel.readInt();
        this.f7229e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7226b;
    }

    public int getConfidence() {
        return this.f7228d;
    }

    public String getLevel() {
        return this.f7229e;
    }

    public LatLng getLocation() {
        return this.f7225a;
    }

    public int getPrecise() {
        return this.f7227c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7226b = str;
    }

    public void setConfidence(int i) {
        this.f7228d = i;
    }

    public void setLevel(String str) {
        this.f7229e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7225a = latLng;
    }

    public void setPrecise(int i) {
        this.f7227c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f7225a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7227c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7228d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7229e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f7225a);
        parcel.writeString(this.f7226b);
        parcel.writeInt(this.f7227c);
        parcel.writeInt(this.f7228d);
        parcel.writeString(this.f7229e);
    }
}
