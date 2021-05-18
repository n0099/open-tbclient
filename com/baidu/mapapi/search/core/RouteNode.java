package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public String f7268a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7269b;

    /* renamed from: c  reason: collision with root package name */
    public String f7270c;

    public RouteNode() {
    }

    public RouteNode(Parcel parcel) {
        this.f7268a = parcel.readString();
        this.f7269b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7270c = parcel.readString();
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
        return this.f7269b;
    }

    public String getTitle() {
        return this.f7268a;
    }

    public String getUid() {
        return this.f7270c;
    }

    public void setLocation(LatLng latLng) {
        this.f7269b = latLng;
    }

    public void setTitle(String str) {
        this.f7268a = str;
    }

    public void setUid(String str) {
        this.f7270c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7268a);
        parcel.writeValue(this.f7269b);
        parcel.writeString(this.f7270c);
    }
}
