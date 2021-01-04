package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes15.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private LatLng f3039a;

    /* renamed from: b  reason: collision with root package name */
    private String f3040b;
    private String c;

    /* JADX INFO: Access modifiers changed from: protected */
    public PlanNode(Parcel parcel) {
        this.f3039a = null;
        this.f3040b = null;
        this.c = null;
        this.f3039a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f3040b = parcel.readString();
        this.c = parcel.readString();
    }

    PlanNode(LatLng latLng, String str, String str2) {
        this.f3039a = null;
        this.f3040b = null;
        this.c = null;
        this.f3039a = latLng;
        this.f3040b = str;
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
        return this.f3040b;
    }

    public LatLng getLocation() {
        return this.f3039a;
    }

    public String getName() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f3039a);
        parcel.writeString(this.f3040b);
        parcel.writeString(this.c);
    }
}
