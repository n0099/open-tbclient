package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7303a;

    /* renamed from: b  reason: collision with root package name */
    public String f7304b;

    /* renamed from: c  reason: collision with root package name */
    public String f7305c;

    public PlanNode(Parcel parcel) {
        this.f7303a = null;
        this.f7304b = null;
        this.f7305c = null;
        this.f7303a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7304b = parcel.readString();
        this.f7305c = parcel.readString();
    }

    public PlanNode(LatLng latLng, String str, String str2) {
        this.f7303a = null;
        this.f7304b = null;
        this.f7305c = null;
        this.f7303a = latLng;
        this.f7304b = str;
        this.f7305c = str2;
    }

    public static PlanNode withCityCodeAndPlaceName(int i, String str) {
        return new PlanNode(null, String.valueOf(i), str);
    }

    public static PlanNode withCityNameAndPlaceName(String str, String str2) {
        return new PlanNode(null, str, str2);
    }

    public static PlanNode withLocation(LatLng latLng) {
        return new PlanNode(latLng, null, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCity() {
        return this.f7304b;
    }

    public LatLng getLocation() {
        return this.f7303a;
    }

    public String getName() {
        return this.f7305c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f7303a);
        parcel.writeString(this.f7304b);
        parcel.writeString(this.f7305c);
    }
}
