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
    public List<PoiInfo> f7320a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f7321b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f7322c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f7323d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f7324e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f7325f;

    public SuggestAddrInfo() {
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7320a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7321b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7322c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7323d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7324e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7325f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7324e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7321b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7323d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7320a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7325f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7322c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7324e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7321b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7323d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7320a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7325f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7322c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7320a);
        parcel.writeList(this.f7321b);
        parcel.writeList(this.f7322c);
        parcel.writeList(this.f7323d);
        parcel.writeList(this.f7324e);
        parcel.writeList(this.f7325f);
    }
}
