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
    public List<PoiInfo> f7420a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f7421b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f7422c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f7423d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f7424e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f7425f;

    public SuggestAddrInfo() {
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7420a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7421b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7422c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7423d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7424e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7425f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7424e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7421b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7423d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7420a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7425f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7422c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7424e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7421b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7423d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7420a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7425f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7422c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7420a);
        parcel.writeList(this.f7421b);
        parcel.writeList(this.f7422c);
        parcel.writeList(this.f7423d);
        parcel.writeList(this.f7424e);
        parcel.writeList(this.f7425f);
    }
}
