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
    public List<PoiInfo> f7363a;

    /* renamed from: b  reason: collision with root package name */
    public List<PoiInfo> f7364b;

    /* renamed from: c  reason: collision with root package name */
    public List<List<PoiInfo>> f7365c;

    /* renamed from: d  reason: collision with root package name */
    public List<CityInfo> f7366d;

    /* renamed from: e  reason: collision with root package name */
    public List<CityInfo> f7367e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<CityInfo>> f7368f;

    public SuggestAddrInfo() {
    }

    public SuggestAddrInfo(Parcel parcel) {
        this.f7363a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7364b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7365c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.f7366d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7367e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f7368f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CityInfo> getSuggestEndCity() {
        return this.f7367e;
    }

    public List<PoiInfo> getSuggestEndNode() {
        return this.f7364b;
    }

    public List<CityInfo> getSuggestStartCity() {
        return this.f7366d;
    }

    public List<PoiInfo> getSuggestStartNode() {
        return this.f7363a;
    }

    public List<List<CityInfo>> getSuggestWpCity() {
        return this.f7368f;
    }

    public List<List<PoiInfo>> getSuggestWpNode() {
        return this.f7365c;
    }

    public void setSuggestEndCity(List<CityInfo> list) {
        this.f7367e = list;
    }

    public void setSuggestEndNode(List<PoiInfo> list) {
        this.f7364b = list;
    }

    public void setSuggestStartCity(List<CityInfo> list) {
        this.f7366d = list;
    }

    public void setSuggestStartNode(List<PoiInfo> list) {
        this.f7363a = list;
    }

    public void setSuggestWpCity(List<List<CityInfo>> list) {
        this.f7368f = list;
    }

    public void setSuggestWpNode(List<List<PoiInfo>> list) {
        this.f7365c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7363a);
        parcel.writeList(this.f7364b);
        parcel.writeList(this.f7365c);
        parcel.writeList(this.f7366d);
        parcel.writeList(this.f7367e);
        parcel.writeList(this.f7368f);
    }
}
