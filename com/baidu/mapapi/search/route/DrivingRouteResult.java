package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class DrivingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public List<DrivingRouteLine> f7298a;

    /* renamed from: b  reason: collision with root package name */
    public List<TaxiInfo> f7299b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7300c;

    /* renamed from: d  reason: collision with root package name */
    public SuggestAddrInfo f7301d;

    public DrivingRouteResult() {
    }

    public DrivingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7298a = arrayList;
        parcel.readTypedList(arrayList, DrivingRouteLine.CREATOR);
        ArrayList arrayList2 = new ArrayList();
        this.f7299b = arrayList2;
        parcel.readTypedList(arrayList2, TaxiInfo.CREATOR);
        this.f7301d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.f7298a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7301d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.f7300c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.f7299b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.f7298a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7301d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.f7299b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f7298a);
        parcel.writeTypedList(this.f7299b);
        parcel.writeParcelable(this.f7301d, 1);
    }
}
