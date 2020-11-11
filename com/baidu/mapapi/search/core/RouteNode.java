package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes7.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private String f2107a;
    private LatLng b;
    private String c;

    public RouteNode() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteNode(Parcel parcel) {
        this.f2107a = parcel.readString();
        this.b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.c = parcel.readString();
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
        return this.b;
    }

    public String getTitle() {
        return this.f2107a;
    }

    public String getUid() {
        return this.c;
    }

    public void setLocation(LatLng latLng) {
        this.b = latLng;
    }

    public void setTitle(String str) {
        this.f2107a = str;
    }

    public void setUid(String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2107a);
        parcel.writeValue(this.b);
        parcel.writeString(this.c);
    }
}
