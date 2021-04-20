package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7338a;

    /* renamed from: b  reason: collision with root package name */
    public String f7339b;

    /* renamed from: c  reason: collision with root package name */
    public String f7340c;

    public PlanNode(Parcel parcel) {
        this.f7338a = null;
        this.f7339b = null;
        this.f7340c = null;
        this.f7338a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7339b = parcel.readString();
        this.f7340c = parcel.readString();
    }

    public PlanNode(LatLng latLng, String str, String str2) {
        this.f7338a = null;
        this.f7339b = null;
        this.f7340c = null;
        this.f7338a = latLng;
        this.f7339b = str;
        this.f7340c = str2;
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
        return this.f7339b;
    }

    public LatLng getLocation() {
        return this.f7338a;
    }

    public String getName() {
        return this.f7340c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f7338a);
        parcel.writeString(this.f7339b);
        parcel.writeString(this.f7340c);
    }
}
