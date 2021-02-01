package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private String f2848a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f2849b;
    private String c;

    public RouteNode() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteNode(Parcel parcel) {
        this.f2848a = parcel.readString();
        this.f2849b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
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
        return this.f2849b;
    }

    public String getTitle() {
        return this.f2848a;
    }

    public String getUid() {
        return this.c;
    }

    public void setLocation(LatLng latLng) {
        this.f2849b = latLng;
    }

    public void setTitle(String str) {
        this.f2848a = str;
    }

    public void setUid(String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2848a);
        parcel.writeValue(this.f2849b);
        parcel.writeString(this.c);
    }
}
