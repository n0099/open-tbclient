package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public String f7168a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7169b;

    /* renamed from: c  reason: collision with root package name */
    public String f7170c;

    public RouteNode() {
    }

    public RouteNode(Parcel parcel) {
        this.f7168a = parcel.readString();
        this.f7169b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7170c = parcel.readString();
    }

    public static RouteNode location(LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setLocation(latLng);
        return routeNode;
    }

    public static RouteNode titleAndLocation(String str, LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(str);
        routeNode.setLocation(latLng);
        return routeNode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getLocation() {
        return this.f7169b;
    }

    public String getTitle() {
        return this.f7168a;
    }

    public String getUid() {
        return this.f7170c;
    }

    public void setLocation(LatLng latLng) {
        this.f7169b = latLng;
    }

    public void setTitle(String str) {
        this.f7168a = str;
    }

    public void setUid(String str) {
        this.f7170c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7168a);
        parcel.writeValue(this.f7169b);
        parcel.writeString(this.f7170c);
    }
}
