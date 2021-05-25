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
    public List<DrivingRouteLine> f7273a;

    /* renamed from: b  reason: collision with root package name */
    public List<TaxiInfo> f7274b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7275c;

    /* renamed from: d  reason: collision with root package name */
    public SuggestAddrInfo f7276d;

    public DrivingRouteResult() {
    }

    public DrivingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7273a = arrayList;
        parcel.readTypedList(arrayList, DrivingRouteLine.CREATOR);
        ArrayList arrayList2 = new ArrayList();
        this.f7274b = arrayList2;
        parcel.readTypedList(arrayList2, TaxiInfo.CREATOR);
        this.f7276d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.f7273a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7276d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.f7275c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.f7274b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.f7273a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7276d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.f7274b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f7273a);
        parcel.writeTypedList(this.f7274b);
        parcel.writeParcelable(this.f7276d, 1);
    }
}
