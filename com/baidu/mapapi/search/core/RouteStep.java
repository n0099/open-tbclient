package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RouteStep implements Parcelable {
    public static final Parcelable.Creator<RouteStep> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    public int f7271a;

    /* renamed from: b  reason: collision with root package name */
    public int f7272b;

    /* renamed from: c  reason: collision with root package name */
    public String f7273c;
    public List<LatLng> mWayPoints;

    public RouteStep() {
    }

    public RouteStep(Parcel parcel) {
        this.f7271a = parcel.readInt();
        this.f7272b = parcel.readInt();
        this.f7273c = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.mWayPoints = arrayList;
        parcel.readList(arrayList, LatLng.class.getClassLoader());
        if (this.mWayPoints.size() == 0) {
            this.mWayPoints = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f7271a;
    }

    public int getDuration() {
        return this.f7272b;
    }

    public String getName() {
        return this.f7273c;
    }

    public List<LatLng> getWayPoints() {
        return this.mWayPoints;
    }

    public void setDistance(int i2) {
        this.f7271a = i2;
    }

    public void setDuration(int i2) {
        this.f7272b = i2;
    }

    public void setName(String str) {
        this.f7273c = str;
    }

    public void setWayPoints(List<LatLng> list) {
        this.mWayPoints = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7271a);
        parcel.writeInt(this.f7272b);
        parcel.writeString(this.f7273c);
        parcel.writeList(this.mWayPoints);
    }
}
