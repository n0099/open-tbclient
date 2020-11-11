package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes7.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2115a;
    private String b;
    private int c;
    private int d;
    private String e;

    public GeoCodeResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeoCodeResult(Parcel parcel) {
        this.f2115a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getAddress() {
        return this.b;
    }

    public int getConfidence() {
        return this.d;
    }

    public String getLevel() {
        return this.e;
    }

    public LatLng getLocation() {
        return this.f2115a;
    }

    public int getPrecise() {
        return this.c;
    }

    @Deprecated
    public void setAddress(String str) {
        this.b = str;
    }

    public void setConfidence(int i) {
        this.d = i;
    }

    public void setLevel(String str) {
        this.e = str;
    }

    public void setLocation(LatLng latLng) {
        this.f2115a = latLng;
    }

    public void setPrecise(int i) {
        this.c = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GeoCodeResult: \n");
        stringBuffer.append("location = ").append(this.f2115a);
        stringBuffer.append("; precise = ").append(this.c);
        stringBuffer.append("; confidence = ").append(this.d);
        stringBuffer.append("; level = ").append(this.e);
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f2115a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
    }
}
