package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
/* loaded from: classes4.dex */
public class GeoCodeResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();
    private LatLng a;
    private String b;

    public GeoCodeResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeoCodeResult(Parcel parcel) {
        this.a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.b = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.a;
    }

    public void setAddress(String str) {
        this.b = str;
    }

    public void setLocation(LatLng latLng) {
        this.a = latLng;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.a);
        parcel.writeString(this.b);
    }
}
