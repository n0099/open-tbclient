package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public String f7159a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7160b;

    /* renamed from: c  reason: collision with root package name */
    public String f7161c;

    public RouteNode() {
    }

    public RouteNode(Parcel parcel) {
        this.f7159a = parcel.readString();
        this.f7160b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7161c = parcel.readString();
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
        return this.f7160b;
    }

    public String getTitle() {
        return this.f7159a;
    }

    public String getUid() {
        return this.f7161c;
    }

    public void setLocation(LatLng latLng) {
        this.f7160b = latLng;
    }

    public void setTitle(String str) {
        this.f7159a = str;
    }

    public void setUid(String str) {
        this.f7161c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7159a);
        parcel.writeValue(this.f7160b);
        parcel.writeString(this.f7161c);
    }
}
