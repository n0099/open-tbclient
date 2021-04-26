package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7598a;

    /* renamed from: b  reason: collision with root package name */
    public String f7599b;

    /* renamed from: c  reason: collision with root package name */
    public String f7600c;

    public PlanNode(Parcel parcel) {
        this.f7598a = null;
        this.f7599b = null;
        this.f7600c = null;
        this.f7598a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7599b = parcel.readString();
        this.f7600c = parcel.readString();
    }

    public PlanNode(LatLng latLng, String str, String str2) {
        this.f7598a = null;
        this.f7599b = null;
        this.f7600c = null;
        this.f7598a = latLng;
        this.f7599b = str;
        this.f7600c = str2;
    }

    public static PlanNode withCityCodeAndPlaceName(int i2, String str) {
        return new PlanNode(null, String.valueOf(i2), str);
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
        return this.f7599b;
    }

    public LatLng getLocation() {
        return this.f7598a;
    }

    public String getName() {
        return this.f7600c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f7598a);
        parcel.writeString(this.f7599b);
        parcel.writeString(this.f7600c);
    }
}
