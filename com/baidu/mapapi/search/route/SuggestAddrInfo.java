package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;
/* loaded from: classes20.dex */
public class SuggestAddrInfo implements Parcelable {
    public static final Parcelable.Creator<SuggestAddrInfo> CREATOR = new n();
    private List<PoiInfo> a;
    private List<PoiInfo> b;
    private List<List<PoiInfo>> c;
    private List<CityInfo> d;
    private List<CityInfo> e;
    private List<List<CityInfo>> f;

    public SuggestAddrInfo() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuggestAddrInfo(Parcel parcel) {
        this.a = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.b = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.c = parcel.readArrayList(PoiInfo.class.getClassLoader());
        this.d = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.e = parcel.readArrayList(CityInfo.class.getClassLoader());
        this.f = parcel.readArrayList(CityInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
