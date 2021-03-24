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
    public int f7162a;

    /* renamed from: b  reason: collision with root package name */
    public int f7163b;

    /* renamed from: c  reason: collision with root package name */
    public String f7164c;
    public List<LatLng> mWayPoints;

    public RouteStep() {
    }

    public RouteStep(Parcel parcel) {
        this.f7162a = parcel.readInt();
        this.f7163b = parcel.readInt();
        this.f7164c = parcel.readString();
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
        return this.f7162a;
    }

    public int getDuration() {
        return this.f7163b;
    }

    public String getName() {
        return this.f7164c;
    }

    public List<LatLng> getWayPoints() {
        return this.mWayPoints;
    }

    public void setDistance(int i) {
        this.f7162a = i;
    }

    public void setDuration(int i) {
        this.f7163b = i;
    }

    public void setName(String str) {
        this.f7164c = str;
    }

    public void setWayPoints(List<LatLng> list) {
        this.mWayPoints = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7162a);
        parcel.writeInt(this.f7163b);
        parcel.writeString(this.f7164c);
        parcel.writeList(this.mWayPoints);
    }
}
