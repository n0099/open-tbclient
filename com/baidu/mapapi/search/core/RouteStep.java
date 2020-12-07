package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class RouteStep implements Parcelable {
    public static final Parcelable.Creator<RouteStep> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    int f2110a;
    int b;
    String c;
    protected List<LatLng> mWayPoints;

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteStep() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteStep(Parcel parcel) {
        this.f2110a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.mWayPoints = new ArrayList();
        parcel.readList(this.mWayPoints, LatLng.class.getClassLoader());
        if (this.mWayPoints.size() == 0) {
            this.mWayPoints = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f2110a;
    }

    public int getDuration() {
        return this.b;
    }

    public String getName() {
        return this.c;
    }

    public List<LatLng> getWayPoints() {
        return this.mWayPoints;
    }

    public void setDistance(int i) {
        this.f2110a = i;
    }

    public void setDuration(int i) {
        this.b = i;
    }

    public void setName(String str) {
        this.c = str;
    }

    public void setWayPoints(List<LatLng> list) {
        this.mWayPoints = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2110a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeList(this.mWayPoints);
    }
}
