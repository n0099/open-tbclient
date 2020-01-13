package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes6.dex */
public class PlanNode implements Parcelable {
    public static final Parcelable.Creator<PlanNode> CREATOR = new m();
    private LatLng a;
    private String b;
    private String c;

    /* JADX INFO: Access modifiers changed from: protected */
    public PlanNode(Parcel parcel) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    PlanNode(LatLng latLng, String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = latLng;
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
        return this.a;
    }

    public String getName() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
