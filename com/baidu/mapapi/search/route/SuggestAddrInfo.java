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
    public List<PoiInfo> f7307a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f7308b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f7309c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f7310d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f7311e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f7312f;

    public SuggestAddrInfo() {
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7307a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7308b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7309c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7310d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7311e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7312f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7311e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7308b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7310d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7307a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7312f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7309c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7311e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7308b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7310d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7307a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7312f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7309c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f7307a);
        parcel.writeList(this.f7308b);
        parcel.writeList(this.f7309c);
        parcel.writeList(this.f7310d);
        parcel.writeList(this.f7311e);
        parcel.writeList(this.f7312f);
    }
}
