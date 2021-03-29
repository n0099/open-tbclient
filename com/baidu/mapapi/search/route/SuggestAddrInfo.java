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
    public List<PoiInfo> f7308a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f7309b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f7310c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f7311d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f7312e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f7313f;

    public SuggestAddrInfo() {
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7308a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7309b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7310c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7311d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7312e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7313f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7312e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7309b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7311d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7308a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7313f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7310c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7312e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7309b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7311d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7308a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7313f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7310c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f7308a);
        parcel.writeList(this.f7309b);
        parcel.writeList(this.f7310c);
        parcel.writeList(this.f7311d);
        parcel.writeList(this.f7312e);
        parcel.writeList(this.f7313f);
    }
}
