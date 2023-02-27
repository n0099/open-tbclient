package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class SuggestAddrInfo implements Parcelable {
    public static final Parcelable.Creator<SuggestAddrInfo> CREATOR = new n();
    public List<PoiInfo> a;
    public List<PoiInfo> b;
    public List<List<PoiInfo>> c;
    public List<CityInfo> d;
    public List<CityInfo> e;
    public List<List<CityInfo>> f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SuggestAddrInfo() {
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.c;
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.a);
        parcel.writeList(this.b);
        parcel.writeList(this.c);
        parcel.writeList(this.d);
        parcel.writeList(this.e);
        parcel.writeList(this.f);
    }
}
