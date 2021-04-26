package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class SuggestAddrInfo implements Parcelable {
    public static final Parcelable.Creator<SuggestAddrInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public List<PoiInfo> f7603a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f7604b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f7605c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f7606d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f7607e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f7608f;

    public SuggestAddrInfo() {
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7603a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7604b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7605c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7606d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7607e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7608f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7607e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7604b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7606d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7603a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7608f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7605c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7607e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7604b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7606d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7603a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7608f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7605c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7603a);
        parcel.writeList(this.f7604b);
        parcel.writeList(this.f7605c);
        parcel.writeList(this.f7606d);
        parcel.writeList(this.f7607e);
        parcel.writeList(this.f7608f);
    }
}
