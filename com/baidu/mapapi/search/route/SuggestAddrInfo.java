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
    public List<PoiInfo> f7343a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f7344b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f7345c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f7346d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f7347e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f7348f;

    public SuggestAddrInfo() {
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7343a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7344b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7345c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7346d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7347e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7348f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7347e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7344b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7346d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7343a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7348f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7345c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7347e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7344b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7346d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7343a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7348f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7345c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f7343a);
        parcel.writeList(this.f7344b);
        parcel.writeList(this.f7345c);
        parcel.writeList(this.f7346d);
        parcel.writeList(this.f7347e);
        parcel.writeList(this.f7348f);
    }
}
