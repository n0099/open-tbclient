package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class TransitResultNode implements Parcelable {
    public static final Parcelable.Creator<TransitResultNode> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private int f2982a;

    /* renamed from: b  reason: collision with root package name */
    private String f2983b;
    private LatLng c;
    private String d;

    public TransitResultNode(int i, String str, LatLng latLng, String str2) {
        this.f2983b = null;
        this.c = null;
        this.d = null;
        this.f2982a = i;
        this.f2983b = str;
        this.c = latLng;
        this.d = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransitResultNode(Parcel parcel) {
        this.f2983b = null;
        this.c = null;
        this.d = null;
        this.f2982a = parcel.readInt();
        this.f2983b = parcel.readString();
        this.c = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCityId() {
        return this.f2982a;
    }

    public String getCityName() {
        return this.f2983b;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public String getSearchWord() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2982a);
        parcel.writeString(this.f2983b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
    }
}
