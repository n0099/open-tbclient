package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes2.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7189a;

    /* renamed from: b  reason: collision with root package name */
    public String f7190b;

    /* renamed from: c  reason: collision with root package name */
    public int f7191c;

    /* renamed from: d  reason: collision with root package name */
    public int f7192d;

    /* renamed from: e  reason: collision with root package name */
    public String f7193e;

    public GeoCodeResult() {
    }

    public GeoCodeResult(Parcel parcel) {
        this.f7189a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7190b = parcel.readString();
        this.f7191c = parcel.readInt();
        this.f7192d = parcel.readInt();
        this.f7193e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.f7190b;
    }

    public int getConfidence() {
        return this.f7192d;
    }

    public String getLevel() {
        return this.f7193e;
    }

    public LatLng getLocation() {
        return this.f7189a;
    }

    public int getPrecise() {
        return this.f7191c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.f7190b = str;
    }

    public void setConfidence(int i) {
        this.f7192d = i;
    }

    public void setLevel(String str) {
        this.f7193e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f7189a = latLng;
    }

    public void setPrecise(int i) {
        this.f7191c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ");
        stringBuffer.append(this.f7189a);
        stringBuffer.append("; precise = ");
        stringBuffer.append(this.f7191c);
        stringBuffer.append("; confidence = ");
        stringBuffer.append(this.f7192d);
        stringBuffer.append("; level = ");
        stringBuffer.append(this.f7193e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f7189a);
        parcel.writeString(this.f7190b);
        parcel.writeInt(this.f7191c);
        parcel.writeInt(this.f7192d);
        parcel.writeString(this.f7193e);
    }
}
