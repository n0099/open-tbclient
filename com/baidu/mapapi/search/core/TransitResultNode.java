package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private int f2858a;

    /* renamed from: b  reason: collision with root package name */
    private String f2859b;
    private LatLng c;
    private String d;

    public TransitResultNode(int i, String str, LatLng latLng, String str2) {
        this.f2859b = null;
        this.c = null;
        this.d = null;
        this.f2858a = i;
        this.f2859b = str;
        this.c = latLng;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransitResultNode(Parcel parcel) {
        this.f2859b = null;
        this.c = null;
        this.d = null;
        this.f2858a = parcel.readInt();
        this.f2859b = parcel.readString();
        this.c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f2858a;
    }

    public String getCityName() {
        return this.f2859b;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public String getSearchWord() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2858a);
        parcel.writeString(this.f2859b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
    }
}
