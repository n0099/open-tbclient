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
    public int f7171a;

    /* renamed from: b  reason: collision with root package name */
    public int f7172b;

    /* renamed from: c  reason: collision with root package name */
    public String f7173c;
    public List<LatLng> mWayPoints;

    public RouteStep() {
    }

    public RouteStep(Parcel parcel) {
        this.f7171a = parcel.readInt();
        this.f7172b = parcel.readInt();
        this.f7173c = parcel.readString();
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
        return this.f7171a;
    }

    public int getDuration() {
        return this.f7172b;
    }

    public String getName() {
        return this.f7173c;
    }

    public List<LatLng> getWayPoints() {
        return this.mWayPoints;
    }

    public void setDistance(int i2) {
        this.f7171a = i2;
    }

    public void setDuration(int i2) {
        this.f7172b = i2;
    }

    public void setName(String str) {
        this.f7173c = str;
    }

    public void setWayPoints(List<LatLng> list) {
        this.mWayPoints = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7171a);
        parcel.writeInt(this.f7172b);
        parcel.writeString(this.f7173c);
        parcel.writeList(this.mWayPoints);
    }
}
