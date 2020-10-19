package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes7.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2143a;
    private String b;
    private String c;

    /* JADX INFO: Access modifiers changed from: protected */
    public PlanNode(Parcel parcel) {
        this.f2143a = null;
        this.b = null;
        this.c = null;
        this.f2143a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    PlanNode(LatLng latLng, String str, String str2) {
        this.f2143a = null;
        this.b = null;
        this.c = null;
        this.f2143a = latLng;
        this.b = str;
        this.c = str2;
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
        return this.b;
    }

    public LatLng getLocation() {
        return this.f2143a;
    }

    public String getName() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f2143a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
